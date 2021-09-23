package edu.suffolk.litlab.efspserver.services;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import edu.suffolk.litlab.efspserver.codes.CodeUpdater;

public class UpdateCodeVersions implements Job {
  
  /** A very light wrapper around the CLI CodeUpdater tool. */
  public void execute(JobExecutionContext context) throws JobExecutionException {
    JobDataMap dataMap = context.getJobDetail().getJobDataMap();
    String endpoint = dataMap.getString("TYLER_ENDPOINT");
    String x509Password = dataMap.getString("X509_PASSWORD");

    CodeUpdater.executeCommand("refresh", endpoint, null, x509Password);
  }

}
