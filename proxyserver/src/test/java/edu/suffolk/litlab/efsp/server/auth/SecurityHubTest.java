package edu.suffolk.litlab.efsp.server.auth;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.db.model.NewTokens;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerUserClient;
import edu.suffolk.litlab.efsp.tyler.TylerUserFactory;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.latest.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.latest.services.schema.common.ErrorType;

public class SecurityHubTest {

  private static final ObjectMapper mapper = new ObjectMapper();
  private static final String API_KEY = "the_key";

  private static MockedStatic<TylerClients> mockClients;
  private static TylerUserClient tylerUserClient;
  private SecurityHub hub;
  private LoginDatabase ld;

  @BeforeAll
  static void init() {
    tylerUserClient = mock(TylerUserClient.class);
    TylerUserFactory userFactory = mock(TylerUserFactory.class);
    when(userFactory.makeUserClient(any())).thenReturn(tylerUserClient);

    mockClients = Mockito.mockStatic(TylerClients.class);
    when(TylerClients.getEfmUserFactory(any(), any())).thenReturn(Optional.of(userFactory));
  }

  @AfterAll
  static void destroy() {
    mockClients.close();
  }

  @BeforeEach
  public void setup() {
    ld = mock(LoginDatabase.class);
    hub = new SecurityHub(() -> ld, Optional.of("stage"), List.of("illinois"));
  }

  @Test
  public void testNoLogin() throws Exception {
    when(ld.getAtRestInfo("")).thenReturn(Optional.empty());

    var nothing = hub.login("", mapper.readTree("{}"));
    assertThat(nothing).isEmpty();
  }

  @Test
  public void testNoOpLogin() throws Exception {
    AtRest atRest = new AtRest();
    atRest.enabled = Map.of("tyler", false, "jeffnet", false);
    when(ld.getAtRestInfo(API_KEY)).thenReturn(Optional.of(atRest));

    // Do nothing should still succeed login (they can ping our codes API)
    var doNothing = hub.login(API_KEY, mapper.readTree("{}"));
    assertThat(doNothing).isPresent();
    assertThat(doNothing.get().getTokens()).isEmpty();

    var inactiveTyler = hub.login(API_KEY, mapper.readTree("{\"tyler\": {}}"));
    assertThat(inactiveTyler).isEmpty();
  }

  @Nested
  class TylerLoginTests {
    private static final String EMAIL = "bob@example.com";
    private static final String PASSWORD = "example_password";
    private static final String PASSWORD_HASH = "the_password_hash";

    private ObjectNode tylerNode;
    private ObjectNode loginNode;

    @BeforeEach
    public void setup() {
      AtRest atRest = new AtRest();
      atRest.enabled = Map.of("tyler", true, "jeffnet", false);
      when(ld.getAtRestInfo(API_KEY)).thenReturn(Optional.of(atRest));

      var authReq = new AuthenticateRequestType();
      authReq.setEmail(EMAIL);
      authReq.setPassword(PASSWORD);

      var error = new ErrorType();
      error.setErrorCode("0");

      var authResp = new AuthenticateResponseType();
      authResp.setEmail(EMAIL);
      authResp.setError(error);
      authResp.setUserID("abc123");
      authResp.setPasswordHash(PASSWORD_HASH);
      when(tylerUserClient.authenticateUser(refEq(authReq))).thenReturn(authResp);

      tylerNode = mapper.createObjectNode();
      tylerNode.put("username", EMAIL);
      tylerNode.put("password", PASSWORD);

      loginNode = mapper.createObjectNode();
      loginNode.set("tyler-illinois", tylerNode);
    }

    @Test
    public void testTylerLoginFailed() throws Exception {
      var error = new ErrorType();
      error.setErrorCode("1");
      error.setErrorText("sucks to suck, haha");
      var authResp = new AuthenticateResponseType();
      authResp.setError(error);
      when(tylerUserClient.authenticateUser(any())).thenReturn(authResp);

      Optional<NewTokens> failed = hub.login(API_KEY, loginNode);
      assertThat(failed).isEmpty();
    }

    @Test
    public void testTylerLogin() throws Exception {
      Optional<NewTokens> activeTyler = hub.login(API_KEY, loginNode);
      assertThat(activeTyler).isPresent();
      assertThat(activeTyler.get().getTokens().get("TYLER-TOKEN-ILLINOIS"))
          .isEqualTo("bob@example.com:the_password_hash");
      Optional<NewTokens> repeatLogin = hub.login(API_KEY, loginNode);
      assertThat(repeatLogin).isPresent();
      assertThat(activeTyler.get()).isEqualTo(repeatLogin.get());
    }

    @Test
    public void testLoginWithUnauthorizedJeffNet() throws Exception {
      ObjectNode jeffNetNode = mapper.createObjectNode();
      jeffNetNode.put("api_key", "the_jeffnet_key");
      loginNode.set("jeffnet", jeffNetNode);
      Optional<NewTokens> withJeffnet = hub.login(API_KEY, loginNode);
      assertThat(withJeffnet).isEmpty();
    }

    @Test
    public void testLoginWithUnsupported() throws Exception {
      loginNode.set("unsupported", mapper.createObjectNode());
      Optional<NewTokens> withUnsupported = hub.login(API_KEY, loginNode);
      assertThat(withUnsupported).isEmpty();
    }

    @Test
    public void testEverything() throws Exception {
      ObjectNode jeffNetNode = mapper.createObjectNode();
      jeffNetNode.put("key", "the_jeffnet_key");
      loginNode.set("jeffnet", jeffNetNode);

      AtRest atRest = new AtRest();
      atRest.enabled = Map.of("tyler", true, "jeffnet", true);
      when(ld.getAtRestInfo(API_KEY)).thenReturn(Optional.of(atRest));

      Optional<NewTokens> activeEverything = hub.login(API_KEY, loginNode);
      assertThat(activeEverything).isPresent();
      var tokens = activeEverything.get().getTokens();
      assertThat(tokens).containsKey("TYLER-TOKEN-ILLINOIS");
      assertThat(tokens.get("TYLER-TOKEN-ILLINOIS")).isEqualTo(EMAIL + ":" + PASSWORD_HASH);
      assertThat(tokens).containsKey("JEFFNET-TOKEN");
      assertThat(tokens.get("JEFFNET-TOKEN")).isEqualTo("the_jeffnet_key");
    }
  }

  @Test
  public void testJustJeffNet() throws Exception {
    ObjectNode jeffNetNode = mapper.createObjectNode();
    jeffNetNode.put("key", "the_jeffnet_key");
    ObjectNode loginNode = mapper.createObjectNode();
    loginNode.set("jeffnet", jeffNetNode);

    AtRest atRest = new AtRest();
    atRest.enabled = Map.of("tyler", false, "jeffnet", true);
    when(ld.getAtRestInfo(API_KEY)).thenReturn(Optional.of(atRest));

    Optional<NewTokens> activeEverything = hub.login(API_KEY, loginNode);
    assertThat(activeEverything).isPresent();
    var tokens = activeEverything.get().getTokens();
    assertThat(tokens.get("JEFFNET-TOKEN")).isEqualTo("the_jeffnet_key");
  }
}
