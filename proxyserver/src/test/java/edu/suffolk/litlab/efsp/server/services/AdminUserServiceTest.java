package edu.suffolk.litlab.efsp.server.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.server.EfspServer;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.tyler.TylerFirmClient;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tyler.efm.latest.services.schema.registrationresponse.RegistrationResponseType;

public class AdminUserServiceTest {

  private static final String ENDPOINT_ADDRESS = "http://localhost:9090";
  private Server server;

  private void startServer() throws Exception {
    TylerFirmClient client = mock(TylerFirmClient.class);
    RegistrationResponseType resp = new RegistrationResponseType();
    resp.setUserID("abc123");
    resp.setPasswordHash("the_hash");
    when(client.registerUser(any())).thenReturn(resp);

    Mockito.mockStatic(ServiceHelpers.class)
        .when(() -> ServiceHelpers.setupFirmPort(any(), any()))
        .thenReturn(Optional.of(client));

    JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(AdminUserService.class);
    sf.setResourceProvider(
        AdminUserService.class,
        new SingletonResourceProvider(
            new AdminUserService("illinois", "stage", null, null, (a) -> Result.nullOk())));
    sf.setAddress(ENDPOINT_ADDRESS);
    Map<Object, Object> extensionMappings = Map.of("json", MediaType.APPLICATION_JSON);
    sf.setExtensionMappings(extensionMappings);
    List<?> providers = EfspServer.providers();
    sf.setProviders(providers);
    server = sf.create();
  }

  @BeforeEach
  void init() throws Exception {
    startServer();
  }

  @AfterEach
  public void destroy() throws Exception {
    server.stop();
    server.destroy();
  }

  @Test
  public void testBadInputToRegisterUser() {
    WebClient client = WebClient.create(ENDPOINT_ADDRESS);
    client.accept("application/json");
    client.type(MediaType.APPLICATION_JSON);
    client.path("/users");
    Response resp = client.post("{\"email\": \"\", \"registrationType\": \"Individual\"}");
    assertThat(resp.getStatus()).isEqualTo(400);
  }
}
