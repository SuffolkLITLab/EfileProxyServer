package edu.suffolk.litlab.efspserver.services;

import edu.suffolk.litlab.efspserver.Monitor;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CodeUpdater;
import edu.suffolk.litlab.efspserver.db.DatabaseCreator;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class UpdateCodeVersions implements Job {
  private static Logger log = LoggerFactory.getLogger(UpdateCodeVersions.class);

  private static final String badUpdateEmailTemplate =
      """
    Something's wrong with the EfileProxy. On the {{external_server}} server, `UpdateCodeVersions`
    has failed to refresh the downloaded genericodes for the jurisdiction {{jurisdiction}} (env: {{env}}).
    Unfortunately We can't send the potential problems in this message yet, but check the logs around
    {{error_timestamp}}.

    Good luck, lol.
    - The EfileProxyServer
      """;

  /**
   * A very light wrapper around the CLI CodeUpdater tool. A separate Job is started for each
   * jurisdiciton, so only jurisdiciton and Tyler env is passed through.
   */
  public void execute(JobExecutionContext context) throws JobExecutionException {
    JobDataMap dataMap = context.getJobDetail().getJobDataMap();
    String jurisdiction = dataMap.getString("TYLER_JURISDICTION");
    String env = dataMap.getString("TYLER_ENV");
    MDC.put(MDCWrappers.OPERATION, "UpdateCodeVersions.execute");
    MDC.put(MDCWrappers.USER_ID, jurisdiction);
    String x509Password = dataMap.getString("X509_PASSWORD");

    String pgFullUrl = dataMap.getString("POSTGRES_URL");
    String pgDb = dataMap.getString("POSTGRES_DB");
    String pgUser = dataMap.getString("POSTGRES_USERNAME");
    String pgPassword = dataMap.getString("POSTGRES_PASSWORD");

    boolean success = true;
    try (Connection conn =
            DatabaseCreator.makeSingleConnection(pgDb, pgFullUrl, pgUser, pgPassword);
        CodeDatabase cd = new CodeDatabase(jurisdiction, env, conn)) {
      success = CodeUpdater.executeCommand(cd, jurisdiction, env, List.of("refresh"), x509Password);
    } catch (SQLException e) {
      log.error("Couldn't connect to Codes db from Job Executor: " + StdLib.strFromException(e));
      success = false;
    }
    if (!success) {
      Monitor.sendImmediateErrorNotification(
          "UpdateCodeVersions error on " + Monitor.EXTERNAL_DOMAIN,
          badUpdateEmailTemplate,
          Map.of(
              "external_server",
              ServiceHelpers.EXTERNAL_URL,
              "jurisdiction",
              jurisdiction,
              "env",
              env,
              "error_timestamp",
              LocalDate.now().toString()));
    }
  }
}
