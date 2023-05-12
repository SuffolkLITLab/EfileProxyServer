package edu.suffolk.litlab.efspserver.services;

import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CodeUpdater;
import edu.suffolk.litlab.efspserver.db.DatabaseCreator;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateCodeVersions implements Job {
  private static Logger log = LoggerFactory.getLogger(UpdateCodeVersions.class);

  /**
   * A very light wrapper around the CLI CodeUpdater tool. A separate Job is started for each
   * jurisdiciton, so only jurisdiciton and Tyler env is passed through.
   */
  public void execute(JobExecutionContext context) throws JobExecutionException {
    JobDataMap dataMap = context.getJobDetail().getJobDataMap();
    String jurisdiction = dataMap.getString("TYLER_JURISDICTION");
    String env = dataMap.getString("TYLER_ENV");
    String x509Password = dataMap.getString("X509_PASSWORD");

    String pgFullUrl = dataMap.getString("POSTGRES_URL");
    String pgDb = dataMap.getString("POSTGRES_DB");
    String pgUser = dataMap.getString("POSTGRES_USERNAME");
    String pgPassword = dataMap.getString("POSTGRES_PASSWORD");

    try (Connection conn =
            DatabaseCreator.makeSingleConnection(pgDb, pgFullUrl, pgUser, pgPassword);
        CodeDatabase cd = new CodeDatabase(jurisdiction, env, conn)) {
      boolean success = CodeUpdater.executeCommand(cd, jurisdiction, env, List.of("refresh"), x509Password);
      if (!success) {
        // TODO(brycew): send email to admin!
      }
    } catch (SQLException e) {
      log.error("Couldn't connect to Codes db from Job Executor: " + StdLib.strFromException(e));
    }
  }
}
