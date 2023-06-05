package edu.suffolk.litlab.efspserver;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Monitor {
  private static Logger log = LoggerFactory.getLogger(Monitor.class);

  private static final String monitoringEmail = StdLib.GetEnv("MONITORING_EMAIL").orElse("");
  public static final String EXTERNAL_DOMAIN =
      StdLib.GetEnv("EXTERNAL_DOMAIN").orElse("filingassemblymde.com");

  public static void sendErrorNotification(String errorStr) {
    String smallErrStr = (errorStr.length() > 21) ? errorStr.substring(0, 20) : errorStr;
    String fullEmailMsg =
        "There's been an error in the EfileProxyServer at "
            + EXTERNAL_DOMAIN
            + ", at "
            + LocalTime.now().toString()
            + ". The error was: "
            + errorStr
            + ". Check the logs for more information.";
    sendErrorNotification("Error in EfileProxy: " + smallErrStr, fullEmailMsg, Map.of());
  }

  public static void sendErrorNotification(
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
                      "Failed to notify that an updated failed, hope someone checks the logs\n\n"
                          + StdLib.strFromException(ex));
                }
              },
              () -> {
                log.warn("not monitoring error logs");
              });
    }
  }
}
