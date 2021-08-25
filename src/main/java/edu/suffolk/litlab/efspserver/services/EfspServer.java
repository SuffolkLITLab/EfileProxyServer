package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import edu.suffolk.litlab.efspserver.HttpsCallbackHandler;
import edu.suffolk.litlab.efspserver.SecurityHub;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.db.MessageSettingsDatabase;
import edu.suffolk.litlab.efspserver.db.UserDatabase;
import edu.suffolk.litlab.efspserver.docassemble.DocassembleToFilingEntityConverter;
import edu.suffolk.litlab.efspserver.ecf.TylerModuleSetup;
import edu.suffolk.litlab.efspserver.jeffnet.JeffNetModuleSetup;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.Bus;
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
    if (false) {
    Optional<String> certPassword = GetEnv("CERT_PASSWORD");
    certPassword.ifPresentOrElse(
        pass -> HttpsCallbackHandler.setCertPassword(pass),
        () -> log.error("Didn't enter a CERT_PASSWORD: Did you pass an .env file?"));
    SpringBusFactory factory = new SpringBusFactory();
    Bus bus = factory.createBus("src/main/config/ServerConfig.xml");
    SpringBusFactory.setDefaultBus(bus);
    }
  }

  protected EfspServer(
      String dbUser, String dbPassword, // always
      UserDatabase ud, // always
      MessageSettingsDatabase md, // always
      LoginDatabase ld, // always
      OrgMessageSender sender, // always
      String userDatabaseName, // always
      List<EfmModuleSetup> modules,
      CodeDatabase cd, // Tyler specific (?)
      Map<String, InterviewToFilingEntityConverter> converterMap
      ) throws Exception {
    try {
      ud.createDbConnection(dbUser, dbPassword);
      ld.createDbConnection(dbUser, dbPassword);
      md.createDbConnection(dbUser, dbPassword);
      cd.createTablesIfAbsent();
      ud.createTablesIfAbsent();
      ld.createTablesIfAbsent();
      md.createTablesIfAbsent();
    } catch (SQLException ex) {
      log.error("SQLException: " + ex);
      System.exit(2);
      //downloadAll = true;
    }

    Map<String, EfmFilingInterface> filingMap = new HashMap<String, EfmFilingInterface>();
    Map<String, EfmRestCallbackInterface> callbackMap = new HashMap<String, EfmRestCallbackInterface>();
    for (EfmModuleSetup mod : modules) {
      mod.preSetup();
      mod.setupGlobals();
      Set<String> courts = mod.getCourts();
      EfmFilingInterface filer = mod.getInterface();
      Optional<EfmRestCallbackInterface> maybeCallback = mod.getCallback();
      for (String court : courts) {
        filingMap.put(court, filer);
        maybeCallback.ifPresent(call -> callbackMap.put(court, call));
      }
    }
    

    String baseLocalUrl = "http://0.0.0.0:9000";
    cd.setAutocommit(true);
    ud.setAutocommit(true);
    ld.setAutocommit(true);
    md.setAutocommit(true);
    SecurityHub security = new SecurityHub(ld);

    sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(AdminUserService.class,
        FilingReviewService.class,
        FirmAttorneyAndServiceService.class,
        PaymentsService.class,
        MessageSettingsService.class,
        CasesService.class);
    sf.setResourceProvider(AdminUserService.class,
        new SingletonResourceProvider(new AdminUserService(security, cd)));
    sf.setResourceProvider(FilingReviewService.class,
        new SingletonResourceProvider(new FilingReviewService(
            ud, converterMap, filingMap, callbackMap, security, sender)));
    sf.setResourceProvider(FirmAttorneyAndServiceService.class,
        new SingletonResourceProvider(new FirmAttorneyAndServiceService(security)));
    sf.setResourceProvider(PaymentsService.class,
        new SingletonResourceProvider(new PaymentsService(security)));
    sf.setResourceProvider(CasesService.class,
        new SingletonResourceProvider(new CasesService(security, cd)));
    sf.setResourceProvider(MessageSettingsService.class,
        new SingletonResourceProvider(new MessageSettingsService(security, md)));

    Map<Object, Object> extensionMappings = new HashMap<Object, Object>();
    extensionMappings.put("xml", MediaType.APPLICATION_XML);
    extensionMappings.put("json", MediaType.APPLICATION_JSON);
    sf.setExtensionMappings(extensionMappings);
    List<Object> providers = List.of(
        new JAXBElementProvider(), 
        new JacksonJsonProvider());
    sf.setProviders(providers);
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
  
  //public static 
  

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
    
    InterviewToFilingEntityConverter daJsonConverter = 
        new DocassembleToFilingEntityConverter(
            EfspServer.class.getResourceAsStream("/taxonomy.csv"));
    Map<String, InterviewToFilingEntityConverter> converterMap = 
        Map.of("application/json", daJsonConverter,
               "text/json", daJsonConverter);
    
    CodeDatabase cd = new CodeDatabase(dbUrl, dbPortInt, codeDatabaseName);
    UserDatabase ud = new UserDatabase(dbUrl, dbPortInt, userDatabaseName);
    LoginDatabase ld = new LoginDatabase(dbUrl, dbPortInt, userDatabaseName);
    MessageSettingsDatabase md = new MessageSettingsDatabase(dbUrl, dbPortInt, userDatabaseName);
    OrgMessageSender sender = new OrgMessageSender(md);

    List<EfmModuleSetup> modules = new ArrayList<EfmModuleSetup>();
    TylerModuleSetup.create(cd, ud, sender).ifPresent(mod -> modules.add(mod));
    JeffNetModuleSetup.create(ud, new OrgMessageSender(md)).ifPresent(mod -> modules.add(mod));
    if (modules.isEmpty()) {
      log.error("Couldn't load enough parameters to start either the Tyler or JeffNet filer modules."
              + "Please check your environment variables and try again.");
      throw new RuntimeException("No filer modules available");
    }
    log.info("Starting Server with the following Filers: " + modules);
    
    EfspServer server = new EfspServer(
        dbUser, dbPassword, ud, md, ld, sender, userDatabaseName, modules, cd,
        converterMap);

    // TODO(brycew): use https://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ScheduledExecutorService.html
    // to routinely update codes if necessary
    // TODO(brycew): consider http://www.quartz-scheduler.org/ too?
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        server.stopServer();
      }
    });
    log.info("Server ready...");
    
    while (true) {
      Thread.sleep(5 * 60 * 1000);
    }
  }
}
