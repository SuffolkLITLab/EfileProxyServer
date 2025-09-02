package edu.suffolk.litlab.efsp.server.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.server.EfspServer;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerDomain;
import edu.suffolk.litlab.efsp.tyler.TylerEnv;
import edu.suffolk.litlab.efsp.tyler.TylerFirmClient;
import edu.suffolk.litlab.efsp.tyler.TylerFirmFactory;
import edu.suffolk.litlab.efsp.tyler.TylerUserClient;
import edu.suffolk.litlab.efsp.tyler.TylerUserFactory;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
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
import tyler.efm.latest.services.schema.common.ErrorType;
import tyler.efm.latest.services.schema.common.UserType;
import tyler.efm.latest.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.latest.services.schema.registrationresponse.RegistrationResponseType;

public class AdminUserServiceTest {

  private static final String ENDPOINT_ADDRESS = "http://localhost:9090";
  private static final String API_KEY = "abc123";
  private Server server;
  private WebClient client;

  // Mocks
  private static MockedStatic<TylerClients> mockClients;
  private static TylerFirmClient tylerFirmClient;
  private static TylerUserClient tylerUserClient;
  private LoginDatabase ld;
  private CodeDatabase cd;

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
    when(TylerClients.getEfmFirmFactory(any())).thenReturn(Optional.of(firmFactory));
    when(TylerClients.getEfmUserFactory(any())).thenReturn(Optional.of(userFactory));
  }

  private void startServer() {
    AtRest atRest = new AtRest();
    atRest.serverId = UUID.randomUUID();
    atRest.enabled = Map.of("tyler", true);
    ld = mock(LoginDatabase.class);
    when(ld.getAtRestInfo(eq(API_KEY))).thenReturn(Optional.of(atRest));

    CourtLocationInfo info = new CourtLocationInfo();
    info.allowindividualregistration = true;
    cd = mock(CodeDatabase.class);
    when(cd.getFullLocationInfo("0")).thenReturn(Optional.of(info));

    Function<String, Result<NullValue, String>> passwordChecker =
        (password) -> {
          if (password.equals("password")) {
            return Result.err("Password can't be password");
          }
          return Result.nullOk();
        };

    JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(AdminUserService.class);
    sf.setResourceProvider(
        AdminUserService.class,
        new SingletonResourceProvider(
            new AdminUserService(
                new TylerDomain(Jurisdiction.ILLINOIS, TylerEnv.STAGE),
                () -> ld,
                () -> cd,
                passwordChecker)));
    sf.setAddress(ENDPOINT_ADDRESS);
    Map<Object, Object> extensionMappings = Map.of("json", MediaType.APPLICATION_JSON);
    sf.setExtensionMappings(extensionMappings);
    List<?> providers = EfspServer.providers();
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
    client.path("/users");

    Response resp = client.post("{\"registrationType\": \"INDIVIDUAL\"}");
    assertThat(resp.getStatus()).isEqualTo(401);
  }

  @Nested
  class RegisterUserTest {

    private static final String SUCCESS_REQ =
        """
      {
        "email": "bob@example.com", "registrationType": "INDIVIDUAL",
        "streetAddressLine1": "123 Main St", "city": "Boston", "stateCode": "MA",
        "zipCode": "02127", "phoneNumber": "6173331234",
        "password": "MyP@ssword"
      }
    """;

    @BeforeEach
    public void setup() {
      client.path("/users");
      client.header("X-API-KEY", API_KEY);
    }

    @Test
    public void testSuccessfullRegisterUser() {
      RegistrationResponseType soapResp = new RegistrationResponseType();
      soapResp.setUserID("abc123");
      soapResp.setPasswordHash("the_hash");
      var err = new ErrorType();
      err.setErrorCode("0");
      soapResp.setError(err);
      when(tylerFirmClient.registerUser(any())).thenReturn(soapResp);

      Response resp = client.post(SUCCESS_REQ);
      assertThat(resp.getStatus()).isEqualTo(201);
      assertThat(resp.readEntity(String.class)).contains("the_hash");
    }

    @Test
    public void testNoLogin() {
      when(ld.getAtRestInfo(any())).thenReturn(Optional.empty());
      Response resp = client.post(SUCCESS_REQ);
      assertThat(resp.getStatus()).isEqualTo(401);
    }

    @Test
    public void testBadInputToRegisterUser() {
      Response resp = client.post("{\"email\": \"\", \"registrationType\": \"Individual\"}");
      assertThat(resp.getStatus()).isEqualTo(400);
    }

    @Test
    public void testMissingPasswordToRegisterUser() {
      Response resp =
          client.post(
              """
      {
        "email": "bob@example.com", "registrationType": "INDIVIDUAL",
        "streetAddressLine1": "123 Main St", "city": "Boston", "stateCode": "MA",
        "zipCode": "02127", "countryCode": "US", "phoneNumber": "6173331234"
      }
    """);
      assertThat(resp.getStatus()).isEqualTo(422);
      assertThat(resp.readEntity(String.class)).contains("password");
    }

    @Test
    public void testBadPassword() {

      String badReq =
          """
        {
          "email": "bob@example.com", "registrationType": "INDIVIDUAL",
          "streetAddressLine1": "123 Main St", "city": "Boston", "stateCode": "MA",
          "zipCode": "02127", "phoneNumber": "6173331234",
          "password": "password"
        }
      """;
      Response resp = client.post(badReq);
      assertThat(resp.getStatus()).isEqualTo(400);
      assertThat(resp.readEntity(String.class)).isEqualTo("Password can't be password");
    }
  }

  @Nested
  class GetUserTest {
    @BeforeEach
    public void setup() {
      client.path("/user");
      client.header("X-API-KEY", API_KEY);

      GetUserResponseType soapResp = new GetUserResponseType();
      var user = new UserType();
      user.setEmail("bob@example.com");
      soapResp.setUser(user);
      var err = new ErrorType();
      err.setErrorCode("0");
      soapResp.setError(err);
      when(tylerUserClient.getUser(any())).thenReturn(soapResp);
    }

    @Test
    public void testNoTylerJurisdictionHeader() {
      Response resp = client.get();
      assertThat(resp.getStatus()).isEqualTo(401);
    }

    @Test
    public void testNoTylerUserIdHeader() {
      Response resp = client.header("TYLER-TOKEN-ILLINOIS", "bob@example.com:abc123").get();
      assertThat(resp.getStatus()).isEqualTo(500);
      assertThat(resp.readEntity(String.class)).contains("Server does not have a Tyler UUID");
    }

    @Test
    public void testWithAllHeadersCaseInsensitive() {
      client.removeAllHeaders();
      client.header("X-API-KEY", API_KEY);
      client.header("TYLER-TOKEN-ILLINOIS", "bob@example.com:abc123");
      client.header("TYLER-ID-ILLINOIS", "12345678-abcd-1234-abcd-12345678abcd");
      var resp = client.get();
      assertThat(resp.getStatus()).isEqualTo(200);

      client.removeAllHeaders();
      client.header("X-API-KEY", API_KEY);
      client.header("TYLER-TOKEN-ILLINOIS", "bob@example.com:abc123");
      client.header("TYLER-ID-illinois", "12345678-abcd-1234-abcd-12345678abcd");
      resp = client.get();
      assertThat(resp.getStatus()).isEqualTo(200);

      client.removeAllHeaders();
      client.header("X-API-KEY", API_KEY);
      client.header("TYLER-TOKEN-ILLINOIS", "bob@example.com:abc123");
      client.header("TYLER-ID-Illinois", "12345678-abcd-1234-abcd-12345678abcd");
      resp = client.get();
      assertThat(resp.getStatus()).isEqualTo(200);
    }
  }
}
