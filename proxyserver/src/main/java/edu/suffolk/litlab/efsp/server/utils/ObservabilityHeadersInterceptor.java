package edu.suffolk.litlab.efsp.server.utils;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
@Provider
@PreMatching // lets this run on all requests, not just those that match an endpoint
public class ObservabilityHeadersInterceptor implements ContainerRequestFilter {
  private static final Logger log = LoggerFactory.getLogger(ObservabilityHeadersInterceptor.class);

  private static final String SESSION_ID = "efsp-session-id";
  private static final String CORRELATION_ID = "efsp-correlation-id";
  private static final String REQUEST_ID = "efsp-request-id";

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    var headers = requestContext.getHeaders();
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
        log.trace("Using generated string `{}` as requestId", requestId);
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
    log.trace("Read in `{}` from the {} header, will use in MDC", val, headerKey);
    return val;
  }
}
