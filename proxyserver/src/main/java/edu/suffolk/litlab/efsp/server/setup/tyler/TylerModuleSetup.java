package edu.suffolk.litlab.efsp.server.setup.tyler;

import static edu.suffolk.litlab.efsp.stdlib.StdLib.GetEnv;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.UserDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.CodeUpdater;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.DataFieldRow;
import edu.suffolk.litlab.efsp.server.services.AdminUserService;
import edu.suffolk.litlab.efsp.server.services.CasesService;
import edu.suffolk.litlab.efsp.server.services.CourtSchedulingService;
import edu.suffolk.litlab.efsp.server.services.EcfCodesService;
import edu.suffolk.litlab.efsp.server.services.FilingReviewService;
import edu.suffolk.litlab.efsp.server.services.FirmAttorneyAndServiceService;
import edu.suffolk.litlab.efsp.server.services.JurisdictionServiceHandle;
import edu.suffolk.litlab.efsp.server.services.PaymentsService;
import edu.suffolk.litlab.efsp.server.services.impl.EfmFilingInterface;
import edu.suffolk.litlab.efsp.server.setup.EfmModuleSetup;
import edu.suffolk.litlab.efsp.server.setup.EfmRestCallbackInterface;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.server.utils.SoapX509CallbackHandler;
import edu.suffolk.litlab.efsp.server.utils.UpdateCodeVersions;
import edu.suffolk.litlab.efsp.stdlib.StdLib;
import edu.suffolk.litlab.efsp.tyler.TylerEnv;
import edu.suffolk.litlab.efsp.utils.InterviewToFilingInformationConverter;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.sql.DataSource;
import org.apache.cxf.jaxws.EndpointImpl;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TylerModuleSetup implements EfmModuleSetup {
  private static Logger log = LoggerFactory.getLogger(TylerModuleSetup.class);
  private final String pgUrl;
  private final String pgDb;
  private final String pgUser;
  private final String pgPassword;
  private final String tylerJurisdiction;
  private final String x509Password;
  private final DataSource codeDs;
  private final DataSource userDs;
  private final Map<String, InterviewToFilingInformationConverter> converterMap;
  private final TylerEnv tylerEnv;
  private final LocalTime codesDbUpdateTime;

  // Payments Stuff
  private final String togaKey;
  private final String togaUrl;
  private OrgMessageSender sender;
  private Scheduler scheduler;

  public static class CreationArgs {
    public String pgUrl;
    public String pgDb;
    public String pgUser;
    public String pgPassword;
    public TylerEnv tylerEnv;
    public String x509Password;
    public String togaUrl;
  }

  /** Use this factory method instead of the class constructor. */
  public static Optional<TylerModuleSetup> create(
      String jurisdiction,
      String togaKey,
      LocalTime codesDbUpdateTime,
      Map<String, InterviewToFilingInformationConverter> converterMap,
      DataSource codeDs,
      DataSource userDs,
      OrgMessageSender sender) {
    Optional<CreationArgs> args = createFromEnvVars();
    if (args.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(
        new TylerModuleSetup(
            args.get(),
            jurisdiction,
            togaKey,
            codesDbUpdateTime,
            converterMap,
            codeDs,
            userDs,
            sender));
  }

  private TylerModuleSetup(
      CreationArgs args,
      String jurisdiction,
      String togaKey,
      LocalTime codesDbUpdateTime,
      Map<String, InterviewToFilingInformationConverter> converterMap,
      DataSource codeDs,
      DataSource userDs,
      OrgMessageSender sender) {
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
    this.codesDbUpdateTime = codesDbUpdateTime;
  }

  private static Optional<CreationArgs> createFromEnvVars() {
    Optional<String> maybeX509Password = GetEnv("X509_PASSWORD");
    if (maybeX509Password.isEmpty() || maybeX509Password.orElse("").isBlank()) {
      log.warn("If using Tyler, X509_PASSWORD can't be null. Did you forget to source .env?");
      return Optional.empty();
    }
    CreationArgs args = new CreationArgs();
    args.x509Password = maybeX509Password.get();

    Optional<TylerEnv> maybeTylerEnv = GetEnv("TYLER_ENV").map(TylerEnv::parse);
    if (maybeTylerEnv.isPresent()) {
      log.info("Using {} for TYLER_ENV", maybeTylerEnv.get());
      args.tylerEnv = maybeTylerEnv.get();
    } else {
      log.info("Not using any TYLER_ENV, maybe prod?");
    }

    args.pgUser = GetEnv("POSTGRES_USER").orElse("postgres");
    Optional<String> maybeDbPassword = GetEnv("POSTGRES_PASSWORD");
    if (maybeDbPassword.isEmpty()) {
      log.warn("You need to define a POSTGRES_PASSWORD");
      return Optional.empty();
    }
    args.pgPassword = maybeDbPassword.get();
    args.pgDb = GetEnv("POSTGRES_CODES_DB").orElse("tyler_efm_codes");
    args.pgUrl =
        "jdbc:postgresql://"
            + GetEnv("POSTGRES_URL").orElse("localhost")
            + ":"
            + GetEnv("POSTGRES_PORT").orElse("5432");

    Optional<String> maybeTogaUrl = GetEnv("TOGA_URL");
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
      log.info(
          "All locations for " + this.tylerJurisdiction + "-" + this.tylerEnv + ": " + locations);
      boolean downloadAll = (cd.getAllLocations().size() == 0);
      if (downloadAll) {
        String testOnlyLocation = StdLib.GetEnv("_TEST_ONLY_LOCATION").orElse("");
        if (!testOnlyLocation.isBlank()) {
          log.info(
              "Downloading just codes for "
                  + testOnlyLocation
                  + " in "
                  + tylerJurisdiction
                  + ": please wait a bit");
          CodeUpdater.executeCommand(
              () -> cd,
              tylerJurisdiction,
              tylerEnv,
              List.of("replacesome", testOnlyLocation),
              this.x509Password);
        } else {
          log.info("Downloading all codes for {}: please wait a bit", tylerJurisdiction);
          CodeUpdater.executeCommand(
              () -> cd, tylerJurisdiction, tylerEnv, List.of("replaceall"), this.x509Password);
        }
      }
    } catch (SQLException e) {
      log.error("SQL Exception: ", e);
      throw new RuntimeException(e);
    }
    log.info("Done checking table if absent");

    try {
      boolean disableQuartzSchedule =
          Boolean.parseBoolean(GetEnv("DISABLE_SCHEDULE_FOR_CODE_UPDATE").orElse("false"));
      boolean scheduleImmediately =
          Boolean.parseBoolean(GetEnv("SCHEDULE_CODE_UPDATE_IMMEDIATELY").orElse("false"));

      if (disableQuartzSchedule) {
        return;
      }

      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      scheduler.start();

      // Always schedule daily codes update.
      int hour = codesDbUpdateTime.getHour();
      int min = codesDbUpdateTime.getMinute();
      var r = new Random();
      String triggerName = "trigger-" + this.tylerJurisdiction + "-" + this.tylerEnv;
      Trigger trigger =
          TriggerBuilder.newTrigger()
              .withIdentity(triggerName, "codesdb-group")
              .startNow()
              .withSchedule(CronScheduleBuilder.dailyAtHourAndMinute(hour, min + r.nextInt(4)))
              .build();

      log.info("Scheduling daily Tyler EFM code update job around {}", codesDbUpdateTime);
      scheduler.scheduleJob(
          buildJob("job-" + this.tylerJurisdiction + "-" + this.tylerEnv), trigger);

      if (scheduleImmediately) {
        // Schedule immediate codes update.
        // Testable version - updates the codes 20 seconds after launch
        // Also useful for immediately running the update on ephemeral machines that are controlled
        // by external cron
        Trigger immediateTrigger =
            TriggerBuilder.newTrigger()
                .withIdentity(
                    "trigger-immediate-" + this.tylerJurisdiction + "-" + this.tylerEnv,
                    "codesdb-group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(20))
                .build();
        log.info("Scheduling immediate Tyler EFM code update job.");
        scheduler.scheduleJob(
            buildJob("job-immediate-" + this.tylerJurisdiction + "-" + this.tylerEnv),
            immediateTrigger);
      }
    } catch (SchedulerException se) {
      log.error("Scheduler Exception: ", se);
      throw new RuntimeException(se);
    }
  }

  @Override
  public String getJurisdiction() {
    return tylerJurisdiction;
  }

  public Set<String> getCourts() {
    try (CodeDatabase cd = new CodeDatabase(tylerJurisdiction, tylerEnv, codeDs.getConnection())) {
      Set<String> allCourts = new HashSet<String>(cd.getAllLocations());
      // 0 and 1 are special "system" courts that have defaults for all courts.
      // They aren't available for filing
      // TODO(brycew): but don't actually remove 0, which is needed to search all courts at the same
      // time?
      // I do hate this interface
      // allCourts.remove("0");
      allCourts.remove("1");
      return allCourts;
    } catch (SQLException ex) {
      log.error("SQL error when getting courts to route to Tyler: ", ex);
      return Set.of();
    }
  }

  @Override
  public JurisdictionServiceHandle getServiceHandle() {
    var filingMap = new HashMap<String, EfmFilingInterface>();
    var callbackMap = new HashMap<String, EfmRestCallbackInterface>();

    final String jurisdiction = getJurisdiction();
    final TylerEnv env = this.tylerEnv;

    Supplier<CodeDatabase> cdSupplier =
        () -> {
          return CodeDatabase.fromDS(jurisdiction, env, this.codeDs);
        };

    EfmFilingInterface filer = new Ecf4Filer(jurisdiction, env, cdSupplier);
    for (String court : getCourts()) {
      filingMap.put(court, filer);
      getCallback().ifPresent(call -> callbackMap.put(court, call));
    }

    Function<String, Result<NullValue, String>> passwordChecker =
        (password) -> {
          // The "0" is the default for all courts, sometimes "1" though? There's no way to enforce
          // court specific passwords
          DataFieldRow globalPasswordRow = DataFieldRow.MissingDataField("GlobalPassword");
          try (CodeDatabase cd = cdSupplier.get()) {
            globalPasswordRow = cd.getDataField("0", "GlobalPassword");
          } catch (SQLException e) {
            log.error("Couldn't get connection to Codes db:", e);
          }
          if (globalPasswordRow.isvisible
              && globalPasswordRow.isrequired
              && password != null
              && password != null
              && !password.isEmpty()) {
            if (globalPasswordRow.matchRegex(password)) {
              return Result.nullOk();
            } else {
              return Result.err(globalPasswordRow.validationmessage);
            }
          }
          return Result.nullOk();
        };

    Supplier<LoginDatabase> ldSupplier = () -> LoginDatabase.fromDS(this.userDs);
    Supplier<UserDatabase> udSupplier = () -> UserDatabase.fromDS(this.userDs);

    var adminUser =
        new AdminUserService(jurisdiction, env, ldSupplier, cdSupplier, passwordChecker);
    var cases = new CasesService(jurisdiction, env, ldSupplier, cdSupplier);
    var codes = new EcfCodesService(jurisdiction, cdSupplier);
    Optional<CourtSchedulingService> courtScheduler = Optional.empty();
    if (jurisdiction == "illinois") {
      courtScheduler =
          Optional.of(
              new CourtSchedulingService(converterMap, jurisdiction, env, ldSupplier, cdSupplier));
    }
    var filingReview =
        new FilingReviewService(
            getJurisdiction(),
            ldSupplier,
            udSupplier,
            converterMap,
            filingMap,
            callbackMap,
            this.sender);
    var firmAttorney = new FirmAttorneyAndServiceService(jurisdiction, env, ldSupplier, cdSupplier);
    var payments =
        new PaymentsService(jurisdiction, env, this.togaKey, this.togaUrl, ldSupplier, cdSupplier);
    JurisdictionServiceHandle handle =
        new JurisdictionServiceHandle(
            getJurisdiction(),
            adminUser,
            cases,
            codes,
            courtScheduler,
            filingReview,
            firmAttorney,
            payments);
    return handle;
  }

  @Override
  public Optional<EfmRestCallbackInterface> getCallback() {
    return Optional.empty();
  }

  @Override
  public void setupGlobals() {
    Supplier<CodeDatabase> makeCD = () -> CodeDatabase.fromDS(tylerJurisdiction, tylerEnv, codeDs);
    Supplier<UserDatabase> makeUD = () -> UserDatabase.fromDS(userDs);
    OasisEcfWsCallback implementor = new OasisEcfWsCallback(makeCD, makeUD, sender);
    String baseLocalUrl = ServiceHelpers.BASE_LOCAL_URL;
    String address =
        baseLocalUrl + "/jurisdictions/" + tylerJurisdiction + ServiceHelpers.ASSEMBLY_PORT;
    log.info("Starting NFRC callback server at {}", address);
    EndpointImpl jaxWsEndpoint =
        (EndpointImpl) jakarta.xml.ws.Endpoint.publish(address, implementor);
    log.info("Address : {}", jaxWsEndpoint.getAddress());
    log.info("Bean name: {}", jaxWsEndpoint.getBeanName());

    OasisEcfv5WsCallback impl2 = new OasisEcfv5WsCallback(makeCD, makeUD, sender);
    String v5Address =
        baseLocalUrl + "/jurisdictions/" + tylerJurisdiction + ServiceHelpers.ASSEMBLY_PORT_V5;
    EndpointImpl jaxWsV5Endpoint = (EndpointImpl) jakarta.xml.ws.Endpoint.publish(v5Address, impl2);
    log.info("V5 Address : {}", jaxWsV5Endpoint.getAddress());
    log.info("V5 Bean name: {}", jaxWsV5Endpoint.getBeanName());

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
        log.error("SchedulerException on shutdown: ", e);
      }
    }
  }

  @Override
  public String toString() {
    return "TylerModuleSetup[jurisdiction=" + tylerJurisdiction + ",env=" + tylerEnv + "]";
  }

  private JobDetail buildJob(final String jobName) {
    return JobBuilder.newJob(UpdateCodeVersions.class)
        .withIdentity(jobName, "codesdb-group")
        .usingJobData("TYLER_JURISDICTION", this.tylerJurisdiction)
        .usingJobData("TYLER_ENV", this.tylerEnv.getName())
        .usingJobData("X509_PASSWORD", this.x509Password)
        .usingJobData("POSTGRES_URL", this.pgUrl)
        .usingJobData("POSTGRES_DB", this.pgDb)
        .usingJobData("POSTGRES_USERNAME", this.pgUser)
        .usingJobData("POSTGRES_PASSWORD", this.pgPassword)
        .build();
  }
}
