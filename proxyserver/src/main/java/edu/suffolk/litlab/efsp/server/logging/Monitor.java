package edu.suffolk.litlab.efsp.server.logging;

import edu.suffolk.litlab.efsp.server.utils.SendMessage;
import edu.suffolk.litlab.efsp.stdlib.StdLib;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Monitor {
  private static Logger log = LoggerFactory.getLogger(Monitor.class);

  private static final String monitoringEmail = StdLib.GetEnv("MONITORING_EMAIL").orElse("");
  public static final String EXTERNAL_DOMAIN =
      StdLib.GetEnv("EXTERNAL_DOMAIN").orElse("filingassemblymde.com");

  private static LocalTime lastSent = null;
  private static AtomicInteger prevErrors = new AtomicInteger(0);

  /**
   * Sends error notifications, without overwhelming the monitoring channel. Can be called whenever,
   * and will only send a notification once every 2 minutes.
   *
   * <p>This works because most of the error info is still in the logs.
   */
  public static void sendErrorNotification(String errorStr) {
    LocalTime now = LocalTime.now();
    if (lastSent == null || (lastSent != null && now.isAfter(lastSent.plusMinutes(2)))) {
      String smallErrStr = (errorStr.length() > 21) ? errorStr.substring(0, 20) : errorStr;
      StringBuilder fullEmailMsg = new StringBuilder();
      fullEmailMsg
          .append("There's been an error in the EfileProxyServer at ")
          .append(EXTERNAL_DOMAIN)
          .append(", at ")
          .append(now.toString())
          .append(". The error was: \n")
          .append(errorStr)
          .append(". ");
      if (lastSent != null && prevErrors.get() > 0) {
        fullEmailMsg
            .append("There were ")
            .append(prevErrors.get())
            .append(" previous error(s) between ")
            .append(lastSent.toString())
            .append(" and now. Check the logs for more information.");
      }
      sendImmediateErrorNotification(
          "Error in EfileProxy: " + smallErrStr, fullEmailMsg.toString(), Map.of());
      lastSent = now;
      prevErrors.set(0);
    } else {
      prevErrors.incrementAndGet();
    }
  }

  /**
   * Sends an error notification immediately. Should only call for scheduled processes, and not
   * anything that can be triggered by an API user.
   *
   * <p>The server needs to be able to send email messages for monitoring to work.
   *
   * @see edu.suffolk.litlab.efsp.server.utils.SendMessage
   * @param subject The subject of the notification (email subject for now)
   * @param template The body of the notification, as a jinja template
   * @param context the mapping of jinja variables in `template` to the strings they should become.
   */
  public static void sendImmediateErrorNotification(
      String subject, String template, Map<String, Object> context) {
    if (monitoringEmail != null && !monitoringEmail.isBlank()) {
      SendMessage.create()
          .ifPresentOrElse(
              sender -> {
                try {
                  sender.sendEmail(
                      "massaccess@suffolk.edu", subject, monitoringEmail, template, context);
                } catch (IOException ex) {
                  log.error(
                      "Failed to notify that an updated failed, hope someone checks the logs\n\n",
                      ex);
                }
              },
              () -> {
                log.warn("not monitoring error logs");
              });
    }
  }
}
