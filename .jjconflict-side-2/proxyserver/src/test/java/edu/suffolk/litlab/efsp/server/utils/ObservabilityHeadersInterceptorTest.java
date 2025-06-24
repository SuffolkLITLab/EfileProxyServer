package edu.suffolk.litlab.efsp.server.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.MultivaluedHashMap;
import java.io.IOException;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.slf4j.MDC;

public class ObservabilityHeadersInterceptorTest {

  ObservabilityHeadersInterceptor interceptor = new ObservabilityHeadersInterceptor();

  @Property
  boolean interceptorHandlesAllHeaders(
      @ForAll String sessionId, @ForAll String corrId, @ForAll String reqId) throws IOException {
    ContainerRequestContext ctx = mock(ContainerRequestContext.class);
    var headers = new MultivaluedHashMap<String, String>();
    headers.add("efsp-session-id", sessionId);
    headers.add("efsp-correlation-id", corrId);
    headers.add("efsp-request-id", reqId);
    when(ctx.getHeaders()).thenReturn(headers);

    interceptor.filter(ctx);

    // Request should always be present, but as long as we don't crash we're good.
    return MDC.get(MDCWrappers.REQUEST_ID) != null;
  }
}
