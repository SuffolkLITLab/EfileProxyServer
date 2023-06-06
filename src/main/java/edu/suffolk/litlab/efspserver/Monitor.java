package edu.suffolk.litlab.efspserver;

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

  public static void sendErrorNotification(String errorStr) {
    LocalTime now = LocalTime.now();
    if (lastSent != null && now.isAfter(lastSent.plusMinutes(2))) {
      String smallErrStr = (errorStr.length() > 21) ? errorStr.substring(0, 20) : errorStr;
      StringBuilder fullEmailMsg = new StringBuilder();
      fullEmailMsg
          .append("There's been an error in the EfileProxyServer at ")
          .append(EXTERNAL_DOMAIN)
          .append(", at ")
          .append(now.toString())
          .append(". The error was: ")
          .append(errorStr)
          .append(". ");
      if (prevErrors.get() > 0) {
        fullEmailMsg
            .append("There were ")
            .append(prevErrors.get())
            .append(" previous errors between now and ")
            .append(lastSent.toString())
            .append(". Check the logs for more information.");
      }
      sendImmediateErrorNotification(
          "Error in EfileProxy: " + smallErrStr, fullEmailMsg.toString(), Map.of());
      lastSent = now;
      prevErrors.set(0);
    } else {
      prevErrors.incrementAndGet();
    }
  }

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
