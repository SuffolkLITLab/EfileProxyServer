package edu.suffolk.litlab.efspserver.services;

import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CodeUpdater;
import edu.suffolk.litlab.efspserver.db.DatabaseCreator;

public class UpdateCodeVersions implements Job {
  private static Logger log = 
      LoggerFactory.getLogger(UpdateCodeVersions.class);
  
  /** A very light wrapper around the CLI CodeUpdater tool. */
  public void execute(JobExecutionContext context) throws JobExecutionException {
    JobDataMap dataMap = context.getJobDetail().getJobDataMap();
    String endpoint = dataMap.getString("TYLER_ENDPOINT");
    String x509Password = dataMap.getString("X509_PASSWORD");

    Optional<DataSource> ds = DatabaseCreator.getDataSource(DatabaseCreator.TylerJNDIName); 
    if (ds.isEmpty()) {
      log.error("Couldn't make a database creator in the Job executor"); 
      return;
    }
    try (CodeDatabase cd = new CodeDatabase(ds.get().getConnection())) {
      CodeUpdater.executeCommand(cd, "refresh", endpoint, x509Password);
    } catch (SQLException e) {
      log.error("Couldn't make a database creator: " + StdLib.strFromException(e));
    }
  }

}
