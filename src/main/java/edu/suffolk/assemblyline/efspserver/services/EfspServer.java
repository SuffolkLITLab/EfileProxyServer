package edu.suffolk.assemblyline.efspserver.services;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import edu.suffolk.assemblyline.efspserver.ClientCallbackHandler;
import edu.suffolk.assemblyline.efspserver.CodeUpdater;
import edu.suffolk.assemblyline.efspserver.codes.CodeDatabase;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;

public class EfspServer {
  
  private JAXRSServerFactoryBean sf;
  private Server server;

  protected EfspServer(String x509Password, 
      String dbUrl, String dbPort,
      String dbUser, String dbPassword,
      String dbDatabaseName) throws Exception {
    boolean downloadAll = false;
    CodeDatabase cd;
    cd = new CodeDatabase(dbUrl, dbPort, dbDatabaseName);
    try {
      cd.createDbConnection(dbUser, dbPassword);
      if (cd.getAllLocations().size() == 0) {
        // Code database is empty!
        downloadAll = true;
      }
    } catch (SQLException ex) {
      downloadAll = true;
    }

    if (downloadAll) {
      cd.createDbConnection(dbUser, dbPassword);
      System.err.println("Download all codes: please wait a bit");
      CodeUpdater cu = new CodeUpdater();
      cu.downloadAll("https://illinois-stage.tylerhost.net", cd);
    }
    
    sf = new JAXRSServerFactoryBean();
    sf.setResourceClasses(AdminUserService.class,
        FilingReviewService.class);
    // HACK(brycew): cheap DI. Should have something better, but
    // I don't quite understand Spring yet
    ClientCallbackHandler.setX509Password(x509Password);
    sf.setResourceProvider(AdminUserService.class,
        new SingletonResourceProvider(new AdminUserService()));
    cd.createDbConnection(dbUser, dbPassword);
    sf.setResourceProvider(FilingReviewService.class,
        new SingletonResourceProvider(new FilingReviewService(cd)));
    Map<Object, Object> extensionMappings = new HashMap<Object, Object>();
    extensionMappings.put("xml", MediaType.APPLICATION_XML);
    extensionMappings.put("json", MediaType.APPLICATION_JSON);
    sf.setExtensionMappings(extensionMappings);
    List<Object> providers = List.of(
        new JAXBElementProvider(), 
        new JacksonJsonProvider());
    sf.setProviders(providers);
    //sf.setAddress("http://localhost:9000");
    sf.setAddress("http://0.0.0.0:9000");
    server = sf.create();
  }
  
  protected void StopServer() {
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
      throw new RuntimeException("x509Password can't be null. Did you forget to source .env?");
    }
    String x509Password = maybeX509Password.get();
    
    String dbUrl = GetEnv("POSTGRES_URL").orElse("localhost");
    String dbPort = GetEnv("POSTGRES_PORT").orElse("5432"); // Default PG port
    String dbDatabaseName = GetEnv("POSTGRES_CODES_DB").orElse("tyler_efm_codes");
    String dbUser = GetEnv("POSTGRES_USER").orElse("postgres"); 
    Optional<String> maybeDbPassword = GetEnv("POSTGRES_PASSWORD"); 
    if (maybeDbPassword.isEmpty()) {
      throw new RuntimeException("You need to pass a POSTGRES password in");
    }
    String dbPassword = maybeDbPassword.get();
    
    EfspServer server = new EfspServer(x509Password, dbUrl, dbPort, 
        dbUser, dbPassword, dbDatabaseName);

    // TODO(brycew): use https://docs.oracle.com/javase/6/docs/api/java/util/concurrent/ScheduledExecutorService.html
    // to routinely update codes if necessary
    // TODO(brycew): consider http://www.quartz-scheduler.org/ too?
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        server.StopServer();
      }
    });
    
    while (true) {
      System.out.println("Server ready...");
      Thread.sleep(5 * 60 * 1000);
      System.out.println("Server exiting");
    }
  }
}
