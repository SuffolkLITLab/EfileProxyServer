package edu.suffolk.litlab.efsp.server.utils;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import org.apache.cxf.interceptor.AbstractInDatabindingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class ObservabilityHeadersInterceptor extends AbstractInDatabindingInterceptor {
  private static final Logger log = LoggerFactory.getLogger(ObservabilityHeadersInterceptor.class);

  private static final String SESSION_ID = "efsp-session-id";
  private static final String CORRELATION_ID = "efsp-correlation-id";
  private static final String REQUEST_ID = "efsp-request-id";

  public ObservabilityHeadersInterceptor() {
    super(Phase.UNMARSHAL);
  }

  @Override
  public void handleMessage(Message message) throws Fault {
    var headers = (Map<String, List<String>>) message.get(Message.PROTOCOL_HEADERS);
    try {
      String sessionId = handleHeaderString(headers, SESSION_ID);
      if (sessionId != null) {
        MDC.put(MDCWrappers.SESSION_ID, sessionId);
      }
      String correlationId = handleHeaderString(headers, CORRELATION_ID);
      if (correlationId != null) {
        MDC.put(MDCWrappers.CORRELATION_ID, correlationId);
      }
      String requestId = handleHeaderString(headers, REQUEST_ID);
      if (requestId == null) {
        requestId = UUID.randomUUID().toString();
        log.info("Using generated string `{}` as requestId", requestId);
      }
      MDC.put(MDCWrappers.REQUEST_ID, requestId);
    } catch (IllegalArgumentException ex) {
      log.error("IllegalArgumentException when setting MDC from headers", ex);
    }
  }

  private static final Pattern safeRegex = Pattern.compile("^[A-Za-z0-9\\-]{0,36}$");

  private String handleHeaderString(Map<String, List<String>> headers, String headerKey) {
    var headerList = headers.get(headerKey);
    if (headerList == null || headerList.isEmpty()) {
      return null;
    }
    String val = headerList.getFirst();
    if (!safeRegex.matcher(val).matches()) {
      log.warn(
          "Not adding the {} header to MDC, as it's not safe (numbers, letters, dashes only)",
          headerKey);
      // We only want to put safe strings into our logs; this one doesn't look safe.
      return null;
    }
    log.info("Read in `{}` from the {} header, will use in MDC", val, headerKey);
    return val;
  }
}
