package edu.suffolk.litlab.efspserver.services;

import static edu.suffolk.litlab.efspserver.services.ServiceHelpers.GetEnv;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import edu.suffolk.litlab.efspserver.HttpsCallbackHandler;
import edu.suffolk.litlab.efspserver.SendMessage;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.db.DatabaseCreator;
import edu.suffolk.litlab.efspserver.db.DatabaseVersion;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.db.MessageSettingsDatabase;
import edu.suffolk.litlab.efspserver.db.UserDatabase;
import edu.suffolk.litlab.efspserver.docassemble.DocassembleToFilingInformationConverter;
import edu.suffolk.litlab.efspserver.ecf.TylerModuleSetup;
import edu.suffolk.litlab.efspserver.jeffnet.JeffNetModuleSetup;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.Nullable;
import javax.sql.DataSource;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
//import org.apache.cxf.transport.http.HttpServerEngineSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EfspServer {
  private static Logger log =
      LoggerFactory.getLogger(EfspServer.class);

  private JAXRSServerFactoryBean sf;
  private JAXRSServerFactoryBean acmeSf;
  private Server server;
  private Server acmeServer;

  private final static File CERT_KEY_STORE = new File("src/main/config/tls_server_cert.jks");

  static {
    Optional<String> certPassword = GetEnv("CERT_PASSWORD");
    if (certPassword.isPresent() && CERT_KEY_STORE.isFile()) {
      HttpsCallbackHandler.setCertPassword(certPassword.get());
      SpringBusFactory factory = new SpringBusFactory();
      Bus bus = factory.createBus("src/main/config/ServerConfig.xml");
      // bus.setProperty(HttpServerEngineSupport.ENABLE_HTTP2, true);
      BusFactory.setDefaultBus(bus);
    } else {
      if (certPassword.isEmpty()) {
        log.warn("Didn't enter a CERT_PASSWORD. Falling back to HTTP. Did you pass an .env file?");
      }
      if (!CERT_KEY_STORE.isFile()) {
        log.warn(CERT_KEY_STORE.getAbsolutePath() + " doesn't exist, needed to run HTTPS. Falling back to HTTP.");
      }
    }
  }

  protected EfspServer(
      DataSource codeDs,
      DataSource userDs,
      OrgMessageSender sender,
      List<EfmModuleSetup> modules,
      SecurityHub security,
      Map<String, InterviewToFilingInformationConverter> converterMap,
      @Nullable AcmeChallengeService challengeService
      ) throws SQLException, NoSuchAlgorithmException {
    try (Connection conn = userDs.getConnection()) {
      UserDatabase ud = new UserDatabase(conn);
      ud.createTablesIfAbsent();
      LoginDatabase ld = new LoginDatabase(conn);
      ld.createTablesIfAbsent();
      MessageSettingsDatabase md = new MessageSettingsDatabase(conn);
      md.createTablesIfAbsent();
    } catch (SQLException ex) {
      log.error("SQLException: " + StdLib.strFromException(ex)); 
      System.exit(2);
    }
    
    var jurisdictionMap = new HashMap<String, JurisdictionServiceHandle>();
    var callbackMap = new HashMap<String, Optional<EfmRestCallbackInterface>>();
    for (EfmModuleSetup mod : modules) {
      mod.preSetup();
      mod.setupGlobals();
      JurisdictionServiceHandle handle = mod.getServiceHandle();
      Optional<EfmRestCallbackInterface> maybeCallback = mod.getCallback();
      jurisdictionMap.put(mod.getJurisdiction(), handle);
      callbackMap.put(mod.getJurisdiction(), maybeCallback);
    }
    
    Map<Class<?>, SingletonResourceProvider> services = new HashMap<Class<?>, SingletonResourceProvider>();
    services.put(RootService.class, new SingletonResourceProvider(new RootService()));
    services.put(MessageSettingsService.class,
        new SingletonResourceProvider(new MessageSettingsService(userDs)));
    services.put(ApiUserSettingsService.class,
        new SingletonResourceProvider(new ApiUserSettingsService(userDs)));
    services.put(AuthenticationService.class,
        new SingletonResourceProvider(new AuthenticationService(security)));
    services.put(JurisdictionSwitch.class, new SingletonResourceProvider(new JurisdictionSwitch(jurisdictionMap)));
    if (challengeService != null && !ServiceHelpers.BASE_ACME_URL.isBlank()) {
      services.put(AcmeChallengeService.class, new SingletonResourceProvider(challengeService));
      acmeSf = new JAXRSServerFactoryBean();
      acmeSf.setResourceClasses(AcmeChallengeService.class);
      acmeSf.setResourceProvider(AcmeChallengeService.class, new SingletonResourceProvider(challengeService));
      acmeSf.setAddress(ServiceHelpers.BASE_ACME_URL);
      acmeServer = acmeSf.create();
    }

    sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(new ArrayList<Class<?>>(services.keySet()));
    for (Map.Entry<Class<?>, SingletonResourceProvider> prov : services.entrySet()) {
      sf.setResourceProvider(prov.getKey(), prov.getValue());
    }
    sf.setExtensionMappings(Map.of(
        "xml", MediaType.APPLICATION_XML,
        "json", MediaType.APPLICATION_JSON));
    sf.setProviders(List.of(
        new JAXBElementProvider<Object>(),
        new JacksonJsonProvider()));

    sf.setAddress(ServiceHelpers.BASE_LOCAL_URL);
    server = sf.create();
  }

  protected void stopServers() {
    if (server != null) {
      server.stop();
      server.destroy();
    }
    if (acmeServer != null) {
      acmeServer.stop();
      acmeServer.destroy();
    }
  }

  public static void main(String[] args) throws Exception {
    String dbUrl = GetEnv("POSTGRES_URL").orElse("localhost");
    String dbPort = GetEnv("POSTGRES_PORT").orElse("5432"); // Default PG port
    int dbPortInt = Integer.parseInt(dbPort);
    String codeDatabaseName = GetEnv("POSTGRES_CODES_DB").orElse("tyler_efm_codes");
    String userDatabaseName = GetEnv("POSTGRES_USER_DB").orElse("user_transactions");
    String dbUser = GetEnv("POSTGRES_USER").orElse("postgres");
    Optional<String> maybeDbPassword = GetEnv("POSTGRES_PASSWORD");
    if (maybeDbPassword.isEmpty()) {
      throw new RuntimeException("You need to pass a POSTGRES password in");
    }
    String dbPassword = maybeDbPassword.get();

    InterviewToFilingInformationConverter daJsonConverter =
        new DocassembleToFilingInformationConverter(
            EfspServer.class.getResourceAsStream("/taxonomy.csv"));
    Map<String, InterviewToFilingInformationConverter> converterMap =
        Map.of("application/json", daJsonConverter,
               "text/json", daJsonConverter);
    
    DataSource codeDs = DatabaseCreator.makeDataSource(dbUrl, dbPortInt, codeDatabaseName, dbUser, dbPassword, 7, 100);
    DataSource userDs = DatabaseCreator.makeDataSource(dbUrl, dbPortInt, userDatabaseName, dbUser, dbPassword, 7, 100);
    
    try (Connection codeConn = codeDs.getConnection(); 
         Connection userConn = userDs.getConnection()) {
      DatabaseVersion dv = new DatabaseVersion(codeConn, userConn);
      LoginDatabase ld = new LoginDatabase(userConn);
      boolean brandNew = !ld.tablesExist();
      dv.createTablesIfAbsent(brandNew);
      if (!dv.updateToLatest()) {
        log.error("Couldn't update the database schemas: exiting now");
        System.exit(3);
      }
      userConn.setAutoCommit(true);
      codeConn.setAutoCommit(true);
    }

    Optional<SendMessage> sendMsg = SendMessage.create();
    if (sendMsg.isEmpty()) {
      throw new RuntimeException("You didn't pass enough info to create the SendMessage class");
    }
    OrgMessageSender sender = new OrgMessageSender(userDs, sendMsg.get());

    List<EfmModuleSetup> modules = new ArrayList<>();

    Optional<String> tylerJurisdictions = GetEnv("TYLER_JURISDICTIONS");
    Optional<String> togaKeyStr = GetEnv("TOGA_CLIENT_KEYS");
    Optional<String> tylerEnv = GetEnv("TYLER_ENV");
    List<String> jurisdictions = List.of(tylerJurisdictions.orElse("").split(" "));
    List<String> togaKeys = List.of(togaKeyStr.orElse("").split(" "));
    if (jurisdictions.size() > 0 && jurisdictions.size() != togaKeys.size()) {
      log.error("TOGA_CLIENT_KEYS list should be same size as TYLER_JURSIDICTIONS list.");
      throw new RuntimeException("TOGA_CLIENT_KEYS and TYLER_JURISDICTION mismatch");
    }
    for (int idx = 0; idx < jurisdictions.size(); idx++) {
      String jurisdiction = jurisdictions.get(idx);
      if (jurisdiction.isBlank()) {
        continue;
      }
      TylerModuleSetup.create(jurisdiction, togaKeys.get(idx), converterMap, codeDs, userDs, sender).ifPresent(mod -> modules.add(mod));
    }
    JeffNetModuleSetup.create(converterMap, userDs, sender).ifPresent(mod -> modules.add(mod));
    if (modules.isEmpty()) {
      log.error("Couldn't load enough parameters to start either the Tyler or JeffNet filer modules."
              + "Please check your environment variables and try again.");
      throw new RuntimeException("No filer modules available");
    }
    log.info("Starting Server with the following Filers: " + modules);

    SecurityHub security = new SecurityHub(userDs, tylerEnv, jurisdictions);
    AcmeChallengeService challengeService = null;
    boolean useLetsEncrypt = GetEnv("USE_LETSENCRYPT").map(str -> Boolean.parseBoolean(str)).orElse(false);
    if (useLetsEncrypt) {
      log.info("Using lets encrypt!");
      challengeService = new AcmeChallengeService();
    }
    EfspServer server = new EfspServer(
        codeDs, userDs, sender, modules, security,
        converterMap, challengeService);
    
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        server.stopServers();
        for (EfmModuleSetup mod : modules) {
          mod.shutdown();
        }
      }
    });
    log.info("Server ready!");

    while (true) {
      Thread.sleep(5 * 60 * 1000);
    }
  }
}
