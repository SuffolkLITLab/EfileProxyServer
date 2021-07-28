package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import edu.suffolk.litlab.efspserver.ClientCallbackHandler;
import edu.suffolk.litlab.efspserver.CodeUpdater;
import edu.suffolk.litlab.efspserver.LoginDatabase;
import edu.suffolk.litlab.efspserver.SecurityHub;
import edu.suffolk.litlab.efspserver.UserDatabase;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.docassemble.DocassembleToFilingEntityConverter;
import edu.suffolk.litlab.efspserver.ecf.OasisEcfFiler;
import edu.suffolk.litlab.efspserver.ecf.OasisEcfWsCallback;
import edu.suffolk.litlab.efspserver.jeffnet.JeffNetFiler;
import edu.suffolk.litlab.efspserver.jeffnet.JeffNetRestCallback;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Endpoint;

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
  
  protected EfspServer(String x509Password, 
      String dbUrl, int dbPort,
      String dbUser, String dbPassword,
      String codeDatabaseName,
      UserDatabase ud,
      String userDatabaseName,
      Map<String, InterviewToFilingEntityConverter> converterMap,
      Map<String, EfmFilingInterface> filingMap,
      Map<String, EfmRestCallbackInterface> callbackMap) throws Exception {
    boolean downloadAll = false;
    CodeDatabase cd = new CodeDatabase(dbUrl, dbPort, codeDatabaseName);
    LoginDatabase ld = new LoginDatabase(dbUrl, dbPort, userDatabaseName);
    try {
      cd.createDbConnection(dbUser, dbPassword);
      if (cd.getAllLocations().size() == 0) {
        // Code database is empty!
        downloadAll = true;
      }
      ud.createDbConnection(dbUser, dbPassword);
      ld.createDbConnection(dbUser, dbPassword);
      ud.createTablesIfAbsent();
      ld.createTablesIfAbsent();
    } catch (SQLException ex) {
      downloadAll = true;
    }

    if (downloadAll) {
      cd.createDbConnection(dbUser, dbPassword);
      log.debug("Downloading all codes: please wait a bit");
      CodeUpdater.downloadAll("https://illinois-stage.tylerhost.net", cd);
    }
    
    String baseLocalUrl = "http://0.0.0.0:9000";
    cd.setAutocommit(true);
    ud.setAutocommit(true);
    ld.setAutocommit(true);
    SecurityHub security = new SecurityHub(ld);
    sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(AdminUserService.class,
        FilingReviewService.class,
        FirmAttorneyAndServiceService.class);
    // HACK(brycew): cheap DI. Should have something better, but
    // I don't quite understand Spring yet
    ClientCallbackHandler.setX509Password(x509Password);
    sf.setResourceProvider(AdminUserService.class,
        new SingletonResourceProvider(new AdminUserService(security)));
    cd.createDbConnection(dbUser, dbPassword);
    sf.setResourceProvider(FilingReviewService.class,
        new SingletonResourceProvider(new FilingReviewService(
            ud, converterMap, filingMap, callbackMap, security)));
    sf.setResourceProvider(FirmAttorneyAndServiceService.class,
        new SingletonResourceProvider(new FirmAttorneyAndServiceService(security)));
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
  

  public static void main(String[] args) throws Exception {
    Optional<String> maybeX509Password = GetEnv("X509_PASSWORD");
    if (maybeX509Password.isEmpty()) {
      throw new RuntimeException("X509_PASSWORD can't be null. Did you forget to source .env?");
    }
    Optional<String> maybeJeffersonEndpoint = GetEnv("JEFFERSON_ENDPOINT");
    if (maybeJeffersonEndpoint.isEmpty()) {
      throw new RuntimeException("JEFFERSON_ENDPOINT needs to be the "
            + "defined. Did you forget to source .env?");
    }
    String x509Password = maybeX509Password.get();
    
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
    
    EfmFilingInterface jeffersonParish = new JeffNetFiler(
        maybeJeffersonEndpoint.get());
    Map<String, EfmFilingInterface> filingMap = new HashMap<String, EfmFilingInterface>(); 
    filingMap.put("Jefferson", jeffersonParish);
    CodeDatabase cd = new CodeDatabase(dbUrl, dbPortInt, codeDatabaseName);
    EfmFilingInterface tylerInterface = new OasisEcfFiler(cd);
    List<String> hardcodedTylerIds = List.of("adams", "alexander", "bond", "boone", "brown", 
        "bureau", "calhoun", "carroll", "cass", "clay", "cook", 
        "peoria", "perry", "scott", "washington");
    for (String courtId : hardcodedTylerIds) {
      filingMap.put(courtId, tylerInterface);
    }
    
    UserDatabase ud = new UserDatabase(dbUrl, dbPortInt, userDatabaseName);
    OrgMessageSender sender = new OrgMessageSender();
    EfmRestCallbackInterface callback = new JeffNetRestCallback(ud, new OrgMessageSender());

    Object implementor = new OasisEcfWsCallback(ud, sender);
    // TODO(brycew): cleaner way to handle baseLocalUrl?
    String baseLocalUrl = "http://0.0.0.0:9000";
    String address = baseLocalUrl + ServiceHelpers.ASSEMBLY_PORT; 
    Endpoint.publish(address, implementor);
    
    Map<String, EfmRestCallbackInterface> callbackMap = Map.of("Jefferson", callback);
    
    EfspServer server = new EfspServer(x509Password, dbUrl, dbPortInt, 
        dbUser, dbPassword, codeDatabaseName, ud, userDatabaseName, 
        converterMap, filingMap, callbackMap);

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
