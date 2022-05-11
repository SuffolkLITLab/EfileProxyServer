package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import edu.suffolk.litlab.efspserver.HttpsCallbackHandler;
import edu.suffolk.litlab.efspserver.SendMessage;
import edu.suffolk.litlab.efspserver.SoapClientChooser;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.db.DatabaseCreator;
import edu.suffolk.litlab.efspserver.db.DatabaseVersion;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.db.MessageSettingsDatabase;
import edu.suffolk.litlab.efspserver.db.UserDatabase;
import edu.suffolk.litlab.efspserver.docassemble.DocassembleToFilingInformationConverter;
import edu.suffolk.litlab.efspserver.ecf.TylerModuleSetup;
import edu.suffolk.litlab.efspserver.jeffnet.JeffNetModuleSetup;
import tyler.efm.services.EfmFirmService;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;
import javax.ws.rs.core.MediaType;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EfspServer {
  private static Logger log =
      LoggerFactory.getLogger(EfspServer.class);

  private JAXRSServerFactoryBean sf;
  private Server server;

  static {
    Optional<String> certPassword = GetEnv("CERT_PASSWORD");
    if (certPassword.isPresent()) {
      HttpsCallbackHandler.setCertPassword(certPassword.get());
      SpringBusFactory factory = new SpringBusFactory();
      Bus bus = factory.createBus("src/main/config/ServerConfig.xml");
      BusFactory.setDefaultBus(bus);
    } else {
      log.warn("Didn't enter a CERT_PASSWORD. Falling back to HTTP. Did you pass an .env file?");
    }
  }

  protected EfspServer(
      DataSource codeDs, // always 
      DataSource userDs, // always 
      OrgMessageSender sender, // always
      List<EfmModuleSetup> modules,
      Map<String, InterviewToFilingInformationConverter> converterMap
      ) throws SQLException, NoSuchAlgorithmException {
    try (CodeDatabase cd = new CodeDatabase(codeDs.getConnection())) {
      cd.createTablesIfAbsent();
    }
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

    Map<String, Map<String, EfmFilingInterface>> filingMap = new HashMap<String, Map<String, EfmFilingInterface>>();
    Map<String, Map<String, EfmRestCallbackInterface>> callbackMap = new HashMap<String, Map<String, EfmRestCallbackInterface>>();
    for (EfmModuleSetup mod : modules) {
      mod.preSetup();
      mod.setupGlobals();
      Set<String> courts = mod.getCourts();
      EfmFilingInterface filer = mod.getInterface();
      Optional<EfmRestCallbackInterface> maybeCallback = mod.getCallback();
      Map<String, EfmFilingInterface> courtToFiler = new HashMap<String, EfmFilingInterface>();
      Map<String, EfmRestCallbackInterface> courtToCallback = new HashMap<String, EfmRestCallbackInterface>();
      for (String court : courts) {
        courtToFiler.put(court, filer);
        maybeCallback.ifPresent(call -> courtToCallback.put(court, call));
      }
      callbackMap.put(mod.getJurisdiction(), courtToCallback);
      filingMap.put(mod.getJurisdiction(), courtToFiler);
    }

    Optional<String> tylerJurisdiction = GetEnv("TYLER_JURISDICTION");
    Optional<String> tylerEnv = GetEnv("TYLER_ENV");
    String jurisdiction = tylerJurisdiction.get();
    if (tylerEnv.isPresent()) {
      jurisdiction += "-" + tylerEnv.get();
    }
    Optional<EfmFirmService> firmFactory = SoapClientChooser.getEfmFirmFactory(jurisdiction); 
    if (firmFactory.isEmpty()) {
      throw new RuntimeException("Cannot find jurisdiction " + jurisdiction + " at start for EfmFirm");
    }
    
    String baseLocalUrl = System.getenv("BASE_LOCAL_URL"); //"https://0.0.0.0:9000";
    SecurityHub security = new SecurityHub(userDs, jurisdiction);
    
    Map<Class<?>, SingletonResourceProvider> services = new HashMap<Class<?>, SingletonResourceProvider>();
    services.put(AdminUserService.class, new SingletonResourceProvider(new AdminUserService(jurisdiction, security, codeDs)));
    services.put(FilingReviewService.class,
        new SingletonResourceProvider(new FilingReviewService(
            userDs, converterMap, filingMap, callbackMap, security, sender)));
    services.put(FirmAttorneyAndServiceService.class,
        new SingletonResourceProvider(new FirmAttorneyAndServiceService(security, codeDs, firmFactory.get())));
    // TODO(brycew-later): refactor to reduce the number of services, or make just "Tyler services" and "JeffNet services" Providers
    if (GetEnv("TOGA_CLIENT_KEY").isPresent() && GetEnv("TOGA_URL").isPresent()) {
      services.put(PaymentsService.class,
          new SingletonResourceProvider(new PaymentsService(security, 
              GetEnv("TOGA_CLIENT_KEY").get(), 
              GetEnv("TOGA_URL").get(),
              firmFactory.get(), codeDs)));
    }
    services.put(CasesService.class,
        new SingletonResourceProvider(new CasesService(security, codeDs, jurisdiction)));
    services.put(CodesService.class,
        new SingletonResourceProvider(new CodesService(codeDs)));
    services.put(CourtSchedulingService.class,
        new SingletonResourceProvider(new CourtSchedulingService(converterMap, security, codeDs, jurisdiction)));
    services.put(MessageSettingsService.class,
        new SingletonResourceProvider(new MessageSettingsService(security, userDs)));
    services.put(RootService.class, new SingletonResourceProvider(new RootService()));

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
    sf.setAddress(baseLocalUrl);
    server = sf.create();
  }

  protected void stopServer() {
    if (server != null) {
      server.stop();
      server.destroy();
    }
  }

  /** Quick wrapper to get an env var as an optional. */
  public static Optional<String> GetEnv(String envVarName) {
    String val = System.getenv(envVarName);
    if (val == null || val.isBlank()) {
      return Optional.empty();
    }
    return Optional.of(val);
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
      dv.createTablesIfAbsent();
      if (!dv.updateToLatest()) {
        log.error("Couldn't update the database schemas: exiting now");
        System.exit(3);
      }
    }

    Optional<SendMessage> sendMsg = SendMessage.create();
    if (sendMsg.isEmpty()) {
      throw new RuntimeException("You didn't pass enough info to create the SendMessage class");
    }
    OrgMessageSender sender = new OrgMessageSender(userDs, sendMsg.get());

    List<EfmModuleSetup> modules = new ArrayList<>();
    TylerModuleSetup.create(codeDs, userDs, sender).ifPresent(mod -> modules.add(mod));
    JeffNetModuleSetup.create(userDs, sender).ifPresent(mod -> modules.add(mod));
    if (modules.isEmpty()) {
      log.error("Couldn't load enough parameters to start either the Tyler or JeffNet filer modules."
              + "Please check your environment variables and try again.");
      throw new RuntimeException("No filer modules available");
    }
    log.info("Starting Server with the following Filers: " + modules);

    EfspServer server = new EfspServer(
        codeDs, userDs, sender, modules,
        converterMap);
    
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        server.stopServer();
        for (EfmModuleSetup mod : modules) {
          mod.shutdown();
        }
      }
    });
    log.info("Server ready...");

    while (true) {
      Thread.sleep(5 * 60 * 1000);
    }
  }
}
