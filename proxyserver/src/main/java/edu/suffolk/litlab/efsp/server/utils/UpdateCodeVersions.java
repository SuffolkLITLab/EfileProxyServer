package edu.suffolk.litlab.efsp.server.utils;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.DatabaseCreator;
import edu.suffolk.litlab.efsp.server.logging.MDCWrappers;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CodeDatabase;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CodeUpdater;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class UpdateCodeVersions implements Job {
  private static Logger log = LoggerFactory.getLogger(UpdateCodeVersions.class);

  /**
   * A very light wrapper around the CLI CodeUpdater tool. A separate Job is started for each
   * jurisdiction, so only jurisdiction and Tyler env is passed through.
   */
  public void execute(JobExecutionContext context) throws JobExecutionException {
    JobDataMap dataMap = context.getJobDetail().getJobDataMap();
    var jurisdiction = Jurisdiction.parse(dataMap.getString("TYLER_JURISDICTION"));
    MDC.put(MDCWrappers.OPERATION, "UpdateCodeVersions.execute");
    MDC.put(MDCWrappers.USER_ID, jurisdiction.getName());
    String x509Password = dataMap.getString("X509_PASSWORD");

    String pgFullUrl = dataMap.getString("POSTGRES_URL");
    String pgDb = dataMap.getString("POSTGRES_DB");
    String pgUser = dataMap.getString("POSTGRES_USERNAME");
    String pgPassword = dataMap.getString("POSTGRES_PASSWORD");

    boolean success = true;
    try (Connection conn =
            DatabaseCreator.makeSingleConnection(pgDb, pgFullUrl, pgUser, pgPassword);
        CodeDatabase cd = new CodeDatabase(jurisdiction, conn)) {
      success =
          CodeUpdater.executeCommand(() -> cd, jurisdiction, List.of("refresh"), x509Password);
    } catch (SQLException e) {
      log.error("Couldn't connect to Codes db from Job Executor: ", e);
      success = false;
    }
    log.info("Finished code updates with status: {}", success);
    if (!success) {
      log.error("UpdateCodeVersions error, failed to refresh the downloaded genericodes");
    }
    MDCWrappers.removeAllMDCs();
  }
}
