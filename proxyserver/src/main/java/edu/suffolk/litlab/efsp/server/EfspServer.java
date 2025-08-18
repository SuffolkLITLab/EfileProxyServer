package edu.suffolk.litlab.efsp.server;

import static edu.suffolk.litlab.efsp.stdlib.StdLib.GetEnv;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import edu.suffolk.litlab.efsp.db.DatabaseCreator;
import edu.suffolk.litlab.efsp.db.DatabaseVersion;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.MessageSettingsDatabase;
import edu.suffolk.litlab.efsp.db.UserDatabase;
import edu.suffolk.litlab.efsp.docassemble.DocassembleToFilingInformationConverter;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.server.auth.SecurityHub;
import edu.suffolk.litlab.efsp.server.services.AcmeChallengeService;
import edu.suffolk.litlab.efsp.server.services.ApiUserSettingsService;
import edu.suffolk.litlab.efsp.server.services.AuthenticationService;
import edu.suffolk.litlab.efsp.server.services.JurisdictionServiceHandle;
import edu.suffolk.litlab.efsp.server.services.JurisdictionSwitch;
import edu.suffolk.litlab.efsp.server.services.MessageSettingsService;
import edu.suffolk.litlab.efsp.server.services.RootService;
import edu.suffolk.litlab.efsp.server.setup.EfmModuleSetup;
import edu.suffolk.litlab.efsp.server.setup.EfmRestCallbackInterface;
import edu.suffolk.litlab.efsp.server.setup.jeffnet.JeffNetModuleSetup;
import edu.suffolk.litlab.efsp.server.setup.tyler.TylerModuleSetup;
import edu.suffolk.litlab.efsp.server.utils.HttpsCallbackHandler;
import edu.suffolk.litlab.efsp.server.utils.JsonExceptionMapper;
import edu.suffolk.litlab.efsp.server.utils.ObservabilityResetInterceptor;
import edu.suffolk.litlab.efsp.server.utils.ObservabilityHeadersInterceptor;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import edu.suffolk.litlab.efsp.server.utils.SendMessage;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.server.utils.SoapExceptionMapper;
import edu.suffolk.litlab.efsp.utils.InterviewToFilingInformationConverter;
import jakarta.ws.rs.core.MediaType;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import javax.sql.DataSource;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
// import org.apache.cxf.transport.http.HttpServerEngineSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EfspServer {
  private static Logger log = LoggerFactory.getLogger(EfspServer.class);

  private JAXRSServerFactoryBean sf;
  private JAXRSServerFactoryBean acmeSf;
  private Server server;
  private Server acmeServer;

  private static final File CERT_KEY_STORE = new File("src/main/config/tls_server_cert.jks");

  // BusFactory.setDefaultBus needs to happen before other CXF code, so use a static block
  static {
    // Creating the Bus will immediately unlock the JKS file in `ServerConfig.xml`, so we set
    // CallbackHandler's CertPassword before we create the factory.
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
        log.warn(
            CERT_KEY_STORE.getAbsolutePath()
                + " doesn't exist, needed to run HTTPS. Falling back to HTTP.");
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
      @Nullable AcmeChallengeService challengeService)
      throws SQLException, NoSuchAlgorithmException {

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

    Supplier<LoginDatabase> ldSupplier = () -> LoginDatabase.fromDS(userDs);
    Supplier<MessageSettingsDatabase> mdSupplier = () -> MessageSettingsDatabase.fromDS(userDs);

    Map<Class<?>, SingletonResourceProvider> services =
        new HashMap<Class<?>, SingletonResourceProvider>();
    services.put(RootService.class, new SingletonResourceProvider(new RootService()));
    services.put(
        MessageSettingsService.class,
        new SingletonResourceProvider(new MessageSettingsService(ldSupplier, mdSupplier)));
    services.put(
        ApiUserSettingsService.class,
        new SingletonResourceProvider(new ApiUserSettingsService(ldSupplier)));
    services.put(
        AuthenticationService.class,
        new SingletonResourceProvider(new AuthenticationService(security)));
    services.put(
        JurisdictionSwitch.class,
        new SingletonResourceProvider(new JurisdictionSwitch(jurisdictionMap)));
    if (challengeService != null && !ServiceHelpers.BASE_ACME_URL.isBlank()) {
      services.put(AcmeChallengeService.class, new SingletonResourceProvider(challengeService));
      acmeSf = new JAXRSServerFactoryBean();
      acmeSf.setResourceClasses(AcmeChallengeService.class);
      acmeSf.setResourceProvider(
          AcmeChallengeService.class, new SingletonResourceProvider(challengeService));
      acmeSf.setAddress(ServiceHelpers.BASE_ACME_URL);
      acmeServer = acmeSf.create();
    }

    sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(new ArrayList<Class<?>>(services.keySet()));
    for (Map.Entry<Class<?>, SingletonResourceProvider> prov : services.entrySet()) {
      sf.setResourceProvider(prov.getKey(), prov.getValue());
    }
    sf.setExtensionMappings(
        Map.of(
            "xml", MediaType.APPLICATION_XML,
            "json", MediaType.APPLICATION_JSON));
    sf.setProviders(providers());

    sf.setAddress(ServiceHelpers.BASE_LOCAL_URL);
    sf.getInInterceptors().add(new ObservabilityHeadersInterceptor());
    sf.getOutInterceptors().add(new ObservabilityResetInterceptor());
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

  /**
   * Does the initial setup for databases if they don't exist or aren't up to date.
   *
   * @throws InterruptedException
   */
  private static void setupDatabases(DataSource codeDs, DataSource userDs)
      throws NoSuchAlgorithmException, InterruptedException {

    // Update / make the latest definition of the databases if necessary
    try (Connection codeConn = codeDs.getConnection();
        Connection userConn = userDs.getConnection()) {
      DatabaseVersion dv = new DatabaseVersion(codeConn, userConn);
      @SuppressWarnings("resource")
      LoginDatabase ld = new LoginDatabase(userConn);
      @SuppressWarnings("resource")
      // Jurisdiction and env args can be null, we're just making the tables
      CodeDatabase cd = new CodeDatabase(null, null, codeConn);
      boolean brandNew = !ld.tablesExist() || !cd.tablesExist();

      // Now we can tell if everything is being set up fresh. If so, we'll make everything now.
      // If not, should assume that we're an older version, and all of the necessary tables will
      // be made by the Database Version.
      if (brandNew) {
        log.info("Recognized that this might be a new DB instance: creating all tables.");
        @SuppressWarnings("resource")
        UserDatabase ud = new UserDatabase(userConn);
        ud.createTablesIfAbsent();
        ld.createTablesIfAbsent();
        @SuppressWarnings("resource")
        MessageSettingsDatabase md = new MessageSettingsDatabase(userConn);
        md.createTablesIfAbsent();
        cd.createTablesIfAbsent();
      }

      dv.createTablesIfAbsent(brandNew);
      if (!dv.updateToLatest()) {
        log.error("Couldn't update the database schemas: exiting now");
        System.exit(3);
      }
      userConn.setAutoCommit(true);
      codeConn.setAutoCommit(true);
    } catch (SQLException ex) {
      log.error("SQLException when setting up / creating tables", ex);
      System.exit(2);
    }
  }

  public static List<?> providers() {
    return List.of(
        new JAXBElementProvider<Object>(),
        new JacksonJsonProvider(), // TODO(brycew): JAXBJSon?
        new SoapExceptionMapper(),
        new JsonExceptionMapper());
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

    DataSource codeDs =
        DatabaseCreator.makeDataSource(
            dbUrl, dbPortInt, codeDatabaseName, dbUser, dbPassword, 7, 100);
    DataSource userDs =
        DatabaseCreator.makeDataSource(
            dbUrl, dbPortInt, userDatabaseName, dbUser, dbPassword, 7, 100);

    setupDatabases(codeDs, userDs);

    InterviewToFilingInformationConverter daJsonConverter =
        new DocassembleToFilingInformationConverter(
            EfspServer.class.getResourceAsStream("/taxonomy.csv"));
    Map<String, InterviewToFilingInformationConverter> converterMap =
        Map.of(
            "application/json", daJsonConverter,
            "text/json", daJsonConverter);

    Optional<SendMessage> sendMsg = SendMessage.create();
    if (sendMsg.isEmpty()) {
      throw new RuntimeException("You didn't pass enough info to create the SendMessage class");
    }
    Supplier<MessageSettingsDatabase> mdSupplier = () -> MessageSettingsDatabase.fromDS(userDs);
    OrgMessageSender sender = new OrgMessageSender(mdSupplier, sendMsg.get());

    Optional<String> tylerJurisdictions = GetEnv("TYLER_JURISDICTIONS");
    Optional<String> togaKeyStr = GetEnv("TOGA_CLIENT_KEYS");
    Optional<String> tylerEnv = GetEnv("TYLER_ENV");
    List<String> jurisdictions = List.of(tylerJurisdictions.orElse("").split(" "));
    List<String> togaKeys = List.of(togaKeyStr.orElse("").split(" "));
    if (jurisdictions.size() > 0 && jurisdictions.size() != togaKeys.size()) {
      log.error("TOGA_CLIENT_KEYS list should be same size as TYLER_JURISDICTIONS list.");
      throw new RuntimeException("TOGA_CLIENT_KEYS and TYLER_JURISDICTION mismatch");
    }

    List<EfmModuleSetup> modules = new ArrayList<>();
    for (int idx = 0; idx < jurisdictions.size(); idx++) {
      String jurisdiction = jurisdictions.get(idx);
      if (jurisdiction.isBlank()) {
        continue;
      }
      TylerModuleSetup.create(jurisdiction, togaKeys.get(idx), converterMap, codeDs, userDs, sender)
          .ifPresent(mod -> modules.add(mod));
    }
    JeffNetModuleSetup.create(converterMap, userDs, sender).ifPresent(mod -> modules.add(mod));
    if (modules.isEmpty()) {
      log.error(
          "Couldn't load enough parameters to start either the Tyler or JeffNet filer modules."
              + "Please check your environment variables and try again.");
      throw new RuntimeException("No filer modules available");
    }
    log.info("Starting Server with the following Filers: {}", modules);

    SecurityHub security = new SecurityHub(userDs, tylerEnv, jurisdictions);
    AcmeChallengeService challengeService = null;
    boolean useLetsEncrypt =
        GetEnv("USE_LETSENCRYPT").map(str -> Boolean.parseBoolean(str)).orElse(false);
    if (useLetsEncrypt) {
      log.info("Using lets encrypt!");
      challengeService = new AcmeChallengeService();
    }
    EfspServer server =
        new EfspServer(codeDs, userDs, sender, modules, security, converterMap, challengeService);

    Runtime.getRuntime()
        .addShutdownHook(
            new Thread() {
              @Override
              public void run() {
                log.info("Stopping servers");
                server.stopServers();
                for (EfmModuleSetup mod : modules) {
                  log.info("Stopping module {}", mod.getJurisdiction());
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
