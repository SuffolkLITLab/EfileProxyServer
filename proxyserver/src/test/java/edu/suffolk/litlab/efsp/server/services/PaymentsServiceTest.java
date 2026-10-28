package edu.suffolk.litlab.efsp.server.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.server.EfspServer;
import edu.suffolk.litlab.efsp.server.auth.SecurityHub;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerFirmClient;
import edu.suffolk.litlab.efsp.tyler.TylerFirmFactory;
import edu.suffolk.litlab.efsp.tyler.TylerUserClient;
import edu.suffolk.litlab.efsp.tyler.TylerUserFactory;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CodeDatabase;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CourtLocationInfo;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import tyler.efm.latest.services.schema.baseresponse.BaseResponseType;
import tyler.efm.latest.services.schema.common.ErrorType;
import tyler.efm.latest.services.schema.common.PaymentAccountType;
import tyler.efm.latest.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;
import tyler.efm.latest.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType;

public class PaymentsServiceTest {

  private static final String ENDPOINT_ADDRESS = "http://localhost:9090/jurisdictions/illinois";
  private static final String API_KEY = "abc123";
  private Server server;
  private WebClient client;

  // Mocks
  private static MockedStatic<TylerClients> mockClients;
  private static TylerFirmClient tylerFirmClient;
  private static TylerUserClient tylerUserClient;
  private LoginDatabase ld;
  private CodeDatabase cd;

  private List<String> globalServerAdmin = List.of("admin@example.com", "admin2@example.com");

  @BeforeAll
  static void init() {
    // Do the static mock only once per thread.
    tylerFirmClient = mock(TylerFirmClient.class);
    TylerFirmFactory firmFactory = mock(TylerFirmFactory.class);
    when(firmFactory.makeFirmClient(any())).thenReturn(tylerFirmClient);

    tylerUserClient = mock(TylerUserClient.class);
    TylerUserFactory userFactory = mock(TylerUserFactory.class);
    when(userFactory.makeUserClient(any())).thenReturn(tylerUserClient);

    mockClients = Mockito.mockStatic(TylerClients.class);
    mockClients
        .when(() -> TylerClients.getEfmFirmFactory(any()))
        .thenReturn(Optional.of(firmFactory));
    mockClients
        .when(() -> TylerClients.getEfmUserFactory(any()))
        .thenReturn(Optional.of(userFactory));
  }

  private void startServer() {
    AtRest atRest = new AtRest();
    atRest.serverId = UUID.randomUUID();
    atRest.enabled = Map.of("tyler", true);
    ld = mock(LoginDatabase.class);
    when(ld.getAtRestInfo(eq(API_KEY))).thenReturn(Optional.of(atRest));

    CourtLocationInfo info = new CourtLocationInfo("doesn't matter", false, true, false);
    cd = mock(CodeDatabase.class);
    when(cd.getFullLocationInfo("0")).thenReturn(Optional.of(info));

    JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(PaymentsService.class);
    sf.setResourceProvider(
        PaymentsService.class,
        new SingletonResourceProvider(
            new PaymentsService(
                Jurisdiction.ILLINOIS,
                "togaKey",
                "toga.url.example.com",
                () -> cd,
                globalServerAdmin)));
    sf.setAddress(ENDPOINT_ADDRESS);
    Map<Object, Object> extensionMappings = Map.of("json", MediaType.APPLICATION_JSON);
    sf.setExtensionMappings(extensionMappings);
    List<?> providers =
        EfspServer.providers(() -> ld, new SecurityHub(() -> ld, List.of(Jurisdiction.ILLINOIS)));
    sf.setProviders(providers);
    server = sf.create();

    client = WebClient.create(ENDPOINT_ADDRESS);
    client.accept("application/json");
    client.type(MediaType.APPLICATION_JSON);
  }

  @BeforeEach
  void setup() throws Exception {
    startServer();
  }

  @AfterEach
  public void tearDown() throws Exception {
    server.stop();
    server.destroy();
  }

  @AfterAll
  static void destroy() {
    mockClients.close();
  }

  @Test
  public void testNoApiKey() {
    client.path("/global-accounts");

    Response resp = client.get();
    assertThat(resp.getStatus()).isEqualTo(401);
  }

  @Nested
  class GlobalServerAdminTest {

    @BeforeEach
    public void setup() {
      client.header("X-API-KEY", API_KEY);
    }

    @Test
    public void testGetGlobalPaymentAccounts() {
      var soapResp = new PaymentAccountListResponseType();
      var paymentAccount = new PaymentAccountType();
      paymentAccount.setAccountName("Test Account");
      paymentAccount.setPaymentAccountTypeCode("W");
      soapResp.getPaymentAccount().add(paymentAccount);
      var err = new ErrorType();
      err.setErrorCode("0");
      soapResp.setError(err);
      when(tylerFirmClient.getGlobalPaymentAccountList()).thenReturn(soapResp);

      client.path("/global-accounts");
      Response resp = client.get();
      assertThat(resp.getStatus()).isEqualTo(200);
      assertThat(resp.readEntity(String.class)).contains("Test Account");
    }

    @Test
    public void testRejectIfNoLogin() {
      client.path("/global-accounts/abc-123");
      client.header("X-API-KEY", API_KEY);

      Response resp = client.delete();
      assertThat(resp.getStatus()).isEqualTo(401);
    }

    @Test
    public void testRejectIfNotGlobalAdmin() {
      client.path("/global-accounts/abc-123");
      client.header("X-API-KEY", API_KEY);
      client.header("TYLER-TOKEN-ILLINOIS", "otheruser@example.com:abcde12345");
      var soapResp = new BaseResponseType();
      var err = new ErrorType();
      err.setErrorCode("0");
      soapResp.setError(err);
      RemovePaymentAccountRequestType req = new RemovePaymentAccountRequestType();
      req.setPaymentAccountID("abc-123");
      when(tylerFirmClient.removeGlobalPaymentAccount(req)).thenReturn(soapResp);

      Response resp = client.delete();
      assertThat(resp.getStatus()).isEqualTo(401);
    }

    @Test
    public void testDeleteIfGlobalAdmin() {
      client.path("/global-accounts/abc-123");
      client.header("X-API-KEY", API_KEY);
      client.header("TYLER-TOKEN-ILLINOIS", "admin@example.com:abcde12345");
      var soapResp = new BaseResponseType();
      var err = new ErrorType();
      err.setErrorCode("0");
      soapResp.setError(err);
      RemovePaymentAccountRequestType req = new RemovePaymentAccountRequestType();
      req.setPaymentAccountID("abc-123");
      when(tylerFirmClient.removeGlobalPaymentAccount(any())).thenReturn(soapResp);

      Response resp = client.delete();
      assertThat(resp.getStatus()).isEqualTo(200);
    }

    @Test
    public void testDeleteIfGlobalAdmin2() {
      client.path("/global-accounts/abc-123");
      client.header("X-API-KEY", API_KEY);
      client.header("TYLER-TOKEN-ILLINOIS", "admin2@example.com:abcde12345");
      var soapResp = new BaseResponseType();
      var err = new ErrorType();
      err.setErrorCode("0");
      soapResp.setError(err);
      RemovePaymentAccountRequestType req = new RemovePaymentAccountRequestType();
      req.setPaymentAccountID("abc-123");
      when(tylerFirmClient.removeGlobalPaymentAccount(any())).thenReturn(soapResp);

      Response resp = client.delete();
      assertThat(resp.getStatus()).isEqualTo(200);
    }
  }
}
