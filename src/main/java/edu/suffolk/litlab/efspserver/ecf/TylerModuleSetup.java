package edu.suffolk.litlab.efspserver.ecf;

import org.quartz.impl.StdSchedulerFactory;
import org.quartz.CronScheduleBuilder;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.cxf.jaxws.EndpointImpl;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SoapX509CallbackHandler;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CodeUpdater;
import edu.suffolk.litlab.efspserver.services.AdminUserService;
import edu.suffolk.litlab.efspserver.services.CasesService;
import edu.suffolk.litlab.efspserver.services.CourtSchedulingService;
import edu.suffolk.litlab.efspserver.services.EfmFilingInterface;
import edu.suffolk.litlab.efspserver.services.EfmModuleSetup;
import edu.suffolk.litlab.efspserver.services.EfmRestCallbackInterface;
import edu.suffolk.litlab.efspserver.services.FilingReviewService;
import edu.suffolk.litlab.efspserver.services.FirmAttorneyAndServiceService;
import edu.suffolk.litlab.efspserver.services.InterviewToFilingInformationConverter;
import edu.suffolk.litlab.efspserver.services.JurisdictionServiceHandle;
import edu.suffolk.litlab.efspserver.services.OrgMessageSender;
import edu.suffolk.litlab.efspserver.services.PaymentsService;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import edu.suffolk.litlab.efspserver.services.UpdateCodeVersions;

public class TylerModuleSetup implements EfmModuleSetup {
  private static Logger log =
      LoggerFactory.getLogger(TylerModuleSetup.class);
  private final String pgUrl;
  private final String pgDb;
  private final String pgUser;
  private final String pgPassword;
  private final String tylerJurisdiction;
  private final String x509Password;
  private final DataSource codeDs;
  private final DataSource userDs;
  private final Map<String, InterviewToFilingInformationConverter> converterMap;

  // Payments Stuff
  private final String togaKey;
  private final String togaUrl;
  private OrgMessageSender sender;
  private Scheduler scheduler;
  private String tylerEnv;

  public static class CreationArgs {
    public String pgUrl;
    public String pgDb;
    public String pgUser;
    public String pgPassword;
    public String tylerEnv;
    public String x509Password;
    public String togaUrl;
  }

  /** Use this factory method instead of the class constructor. */
  public static Optional<TylerModuleSetup> create(
      String jurisdiction, String togaKey, Map<String, InterviewToFilingInformationConverter> converterMap,
      DataSource codeDs, DataSource userDs, OrgMessageSender sender) {
    Optional<CreationArgs> args = createFromEnvVars();
    if (args.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(new TylerModuleSetup(args.get(), jurisdiction, togaKey, converterMap, codeDs, userDs, sender));
  }

  private TylerModuleSetup(
      CreationArgs args,
      String jurisdiction,
      String togaKey,
      Map<String, InterviewToFilingInformationConverter> converterMap,
      DataSource codeDs, DataSource userDs, OrgMessageSender sender) {
    this.codeDs = codeDs;
    this.userDs = userDs;
    this.converterMap = converterMap;
    this.pgUrl = args.pgUrl;
    this.pgDb = args.pgDb;
    this.pgUser = args.pgUser;
    this.pgPassword = args.pgPassword;
    this.tylerJurisdiction = jurisdiction; 
    this.tylerEnv = args.tylerEnv;
    this.x509Password = args.x509Password;
    this.togaKey = togaKey;
    this.togaUrl = args.togaUrl;
    this.sender = sender;
  }

  private static Optional<CreationArgs> createFromEnvVars() {
    Optional<String> maybeX509Password = EfmModuleSetup.GetEnv("X509_PASSWORD");
    if (maybeX509Password.isEmpty() || maybeX509Password.orElse("").isBlank()) {
      log.warn("If using Tyler, X509_PASSWORD can't be null. Did you forget to source .env?");
      return Optional.empty();
    }
    CreationArgs args = new CreationArgs();
    args.x509Password = maybeX509Password.get();

    Optional<String> maybeTylerEnv = EfmModuleSetup.GetEnv("TYLER_ENV");
    if (maybeTylerEnv.isPresent()) {
      log.info("Using " + maybeTylerEnv.get() + " for TYLER_ENV"); 
      args.tylerEnv = maybeTylerEnv.get();
    } else {
      log.info("Not using any TYLER_ENV, maybe prod?");
    }

    args.pgUser = EfmModuleSetup.GetEnv("POSTGRES_USER").orElse("postgres");
    Optional<String> maybeDbPassword = EfmModuleSetup.GetEnv("POSTGRES_PASSWORD");
    if (maybeDbPassword.isEmpty()) {
      log.warn("You need to define a POSTGRES_PASSWORD");
      return Optional.empty();
    }
    args.pgPassword = maybeDbPassword.get();
    args.pgDb = EfmModuleSetup.GetEnv("POSTGRES_CODES_DB").orElse("tyler_efm_codes");
    args.pgUrl = "jdbc:postgresql://" + EfmModuleSetup.GetEnv("POSTGRES_URL").orElse("localhost")
        + ":" + EfmModuleSetup.GetEnv("POSTGRES_PORT").orElse("5432");

    Optional<String> maybeTogaUrl = EfmModuleSetup.GetEnv("TOGA_URL");
    if (maybeTogaUrl.isEmpty()) {
      log.warn("You need to define a TOGA_URL");
      return Optional.empty();
    }
    args.togaUrl = maybeTogaUrl.get();
    return Optional.of(args);
  }

  @Override
  public void preSetup() {
    // HACK(brycew): cheap DI. Should have something better, but
    // I don't quite understand Spring yet
    SoapX509CallbackHandler.setX509Password(x509Password);

    log.info("Checking table if absent");
    try (CodeDatabase cd = new CodeDatabase(tylerJurisdiction, tylerEnv, codeDs.getConnection())) {
      cd.createTablesIfAbsent();
      List<String> locations = cd.getAllLocations();
      log.info("All locations for " + this.tylerJurisdiction + "-" + this.tylerEnv + ": " + locations);
      boolean downloadAll = (cd.getAllLocations().size() == 0);
      if (downloadAll) {
        log.info("Downloading all codes for " + tylerJurisdiction + ": please wait a bit");
        CodeUpdater.executeCommand(cd, tylerJurisdiction, tylerEnv, List.of("downloadAll"), this.x509Password);
      }
    } catch (SQLException e) {
      log.error("SQL Exception: " + StdLib.strFromException(e));
      throw new RuntimeException(e);
    }
    log.info("Done checking table if absent");

    try {
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      scheduler.start();
      
      String jobName = "job-" + this.tylerJurisdiction + "-" + this.tylerEnv;
      
      JobDetail job = JobBuilder.newJob(UpdateCodeVersions.class)
          .withIdentity(jobName, "codesdb-group")
          .usingJobData("TYLER_JURISDICTION", this.tylerJurisdiction)
          .usingJobData("TYLER_ENV", this.tylerEnv)
          .usingJobData("X509_PASSWORD", this.x509Password)
          .usingJobData("POSTGRES_URL", this.pgUrl)
          .usingJobData("POSTGRES_DB", this.pgDb)
          .usingJobData("POSTGRES_USERNAME", this.pgUser)
          .usingJobData("POSTGRES_PASSWORD", this.pgPassword)
          .build();
      
      String triggerName = "trigger-" + this.tylerJurisdiction + "-" + this.tylerEnv;
      Trigger trigger = TriggerBuilder.newTrigger()
          .withIdentity(triggerName, "codesdb-group")
          .startNow()
          .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(2, 15))
          // Testable version! Updates the codes 20 seconds after launch
          //.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20)) 
          .build();
      
      scheduler.scheduleJob(job, trigger);
    } catch (SchedulerException se) {
      log.error("Scheduler Exception: " + StdLib.strFromException(se));
      throw new RuntimeException(se);
    }
  }

  @Override
  public String getJurisdiction() {
    return tylerJurisdiction;
  }

  @Override
  public Set<String> getCourts() {
    try (CodeDatabase cd = new CodeDatabase(tylerJurisdiction, tylerEnv, codeDs.getConnection())) {
      Set<String> allCourts = new HashSet<String>(cd.getAllLocations());
      // 0 and 1 are special "system" courts that have defaults for all courts.
      // They aren't available for filing
      // TODO(brycew): but don't actually remove 0, which is needed to search all courts at the same time?
      // I do hate this interface
      // allCourts.remove("0");
      allCourts.remove("1");
      return allCourts;
    } catch (SQLException ex) {
      log.error("SQL error when getting courts to route to Tyler: " + ex);
      return Set.of();
    }
  }

  @Override
  public JurisdictionServiceHandle getServiceHandle() {
    var filingMap = new HashMap<String, EfmFilingInterface>();
    var callbackMap = new HashMap<String, EfmRestCallbackInterface>();

    final String jurisdiction = getJurisdiction();
    final String env = this.tylerEnv;
    
    EfmFilingInterface filer = new OasisEcfFiler(jurisdiction, env, codeDs);
    
    for (String court: getCourts()) {
      filingMap.put(court, filer);
      getCallback().ifPresent(call -> callbackMap.put(court, call));
    }
    
    var adminUser = new AdminUserService(jurisdiction, env, this.codeDs, this.userDs);
    var cases = new CasesService(jurisdiction, env, this.codeDs, this.userDs);
    var codes = new EcfCodesService(jurisdiction, env, this.codeDs);
    Optional<CourtSchedulingService> courtScheduler = Optional.empty();
    if (jurisdiction == "illinois") {
      courtScheduler = Optional.of(new CourtSchedulingService(converterMap, jurisdiction, env, codeDs, userDs));
    }
    var filingReview = new FilingReviewService(getJurisdiction(), this.userDs, converterMap, filingMap, callbackMap, this.sender); 
    var firmAttorney = new FirmAttorneyAndServiceService(jurisdiction, env, this.codeDs, this.userDs);
    var payments = new PaymentsService(jurisdiction, env, this.togaKey, this.togaUrl, this.codeDs, this.userDs);
    JurisdictionServiceHandle handle = new JurisdictionServiceHandle(getJurisdiction(),
        adminUser, cases, codes, courtScheduler, filingReview, firmAttorney, payments);
    return handle;
  }

  @Override
  public Optional<EfmRestCallbackInterface> getCallback() {
    return Optional.empty();
  }

  @Override
  public void setupGlobals() {
    OasisEcfWsCallback implementor = new OasisEcfWsCallback(tylerJurisdiction, tylerEnv, codeDs, userDs, sender);
    String baseLocalUrl = ServiceHelpers.BASE_LOCAL_URL;
    String address = baseLocalUrl + "/jurisdictions/" + tylerJurisdiction + ServiceHelpers.ASSEMBLY_PORT;
    log.info("Starting NFRC callback server at " + address);
    EndpointImpl jaxWsEndpoint = (EndpointImpl) javax.xml.ws.Endpoint.publish(address, implementor);
    log.info("Wsdl location: " + jaxWsEndpoint.getWsdlLocation());
    log.info("Address : " + jaxWsEndpoint.getAddress());
    log.info("Bean name: " + jaxWsEndpoint.getBeanName());
    
    
    OasisEcfv5WsCallback impl2 = new OasisEcfv5WsCallback(tylerJurisdiction, tylerEnv, codeDs, userDs, sender);
    String v5Address = baseLocalUrl + "/jurisdictions/" + tylerJurisdiction + ServiceHelpers.ASSEMBLY_PORT_V5;
    EndpointImpl jaxWsV5Endpoint = (EndpointImpl) javax.xml.ws.Endpoint.publish(v5Address, impl2);
    log.info("V5 Wsdl location: " + jaxWsV5Endpoint.getWsdlLocation());
    log.info("V5 Address : " + jaxWsV5Endpoint.getAddress());
    log.info("V5 Bean name: " + jaxWsV5Endpoint.getBeanName());

    
    /*
    Endpoint cxfEndpoint = jaxWsEndpoint.getServer().getEndpoint();

    // Tyler SHOULD actually send us signed messages, but they're lazy, and we have to do what they do.
    cxfEndpoint.getBinding().getBindingInfo().setProperty("security.callback-handler", SoapX509CallbackHandler.class.getName());
    cxfEndpoint.getBinding().getBindingInfo().setProperty("security.signature.properties", "client_sign.properties");
    Map<String, Object> inProps = new HashMap<String, Object>();
    //inProps.put(WSHandlerConstants.ACTION, "Signature");
    inProps.put(WSHandlerConstants.SIG_PROP_FILE, "client_sign.properties");
    WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
    cxfEndpoint.getInInterceptors().add(wssIn);
    Map<String, Object> outProps = new HashMap<String, Object>();
    WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);

    // Keep these lines around, good for debugging if SOAP starts to act up again
    cxfEndpoint.getInInterceptors().add(new LoggingInInterceptor());
    cxfEndpoint.getOutInterceptors().add(new LoggingOutInterceptor());
    */
  }

  @Override
  public void shutdown() {
    if (scheduler != null) {
      try {
        scheduler.shutdown();
      } catch (SchedulerException e) {
        log.error("SchedulerException on shutdown: " + e.toString());
      }
    }
  }
  
  @Override
  public String toString() {
    return "TylerModuleSetup[jurisdiction=" + tylerJurisdiction + ",env=" + tylerEnv +"]"; 
  }
}
