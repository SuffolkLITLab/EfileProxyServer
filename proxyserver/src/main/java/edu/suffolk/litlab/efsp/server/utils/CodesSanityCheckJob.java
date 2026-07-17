package edu.suffolk.litlab.efsp.server.utils;

import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.db.DatabaseCreator;
import edu.suffolk.litlab.efsp.server.logging.MDCWrappers;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CodeDatabase;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CodesSanityChecker;
import java.sql.Connection;
import java.sql.SQLException;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class CodesSanityCheckJob implements Job {
  private static Logger log = LoggerFactory.getLogger(CodesSanityCheckJob.class);

  // Runs as a separate task so if this check goes wrong, it won't break the actual nightly database
  // update.
  public void execute(JobExecutionContext context) throws JobExecutionException {
    JobDataMap dataMap = context.getJobDetail().getJobDataMap();
    var jurisdiction = Jurisdiction.parse(dataMap.getString("TYLER_JURISDICTION"));
    MDC.put(MDCWrappers.OPERATION, "CodesSanityCheckJob.execute");
    MDC.put(MDCWrappers.USER_ID, jurisdiction.getName());

    String pgFullUrl = dataMap.getString("POSTGRES_URL");
    String pgDb = dataMap.getString("POSTGRES_DB");
    String pgUser = dataMap.getString("POSTGRES_USERNAME");
    String pgPassword = dataMap.getString("POSTGRES_PASSWORD");

    try (Connection conn =
            DatabaseCreator.makeSingleConnection(pgDb, pgFullUrl, pgUser, pgPassword);
        CodeDatabase cd = new CodeDatabase(jurisdiction, conn)) {
      new CodesSanityChecker(cd, jurisdiction.getName()).runAll();
    } catch (SQLException e) {
      log.error("Couldn't connect to Codes db from CodesSanityCheckJob: ", e);
    }
    MDCWrappers.removeAllMDCs();
  }
}
