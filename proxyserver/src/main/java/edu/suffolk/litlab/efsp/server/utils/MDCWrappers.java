package edu.suffolk.litlab.efsp.server.utils;

import org.slf4j.MDC;

/**
 * Some string constants used when dealing with Mapped Diagnostic Contexts (MDC) in logback, which
 * we use to separate out logs from different servers as users.
 */
public class MDCWrappers {
  public static final String SERVER_ID = "serverId";
  public static final String USER_ID = "userId";
  public static final String OPERATION = "operation";

  public static void removeAllMDCs() {
    MDC.remove(SERVER_ID);
    MDC.remove(USER_ID);
    MDC.remove(OPERATION);
  }
}
