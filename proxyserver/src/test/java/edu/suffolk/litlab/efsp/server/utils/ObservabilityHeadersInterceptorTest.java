package edu.suffolk.litlab.efsp.server.utils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Map;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.apache.cxf.message.Message;
import org.slf4j.MDC;

public class ObservabilityHeadersInterceptorTest {

  ObservabilityHeadersInterceptor interceptor = new ObservabilityHeadersInterceptor();

  @Property
  boolean interceptorHandlesAllHeaders(
      @ForAll String sessionId, @ForAll String corrId, @ForAll String reqId) {
    Message m = mock(Message.class);
    when(m.get(Message.PROTOCOL_HEADERS))
        .thenReturn(
            Map.of(
                "efsp-session-id",
                List.of(sessionId),
                "efsp-correlation-id",
                List.of(corrId),
                "efsp-request-id",
                List.of(reqId)));
    interceptor.handleMessage(m);

    // Request should always be present, but as long as we don't crash we're good.
    return MDC.get(MDCWrappers.REQUEST_ID) != null;
  }
}
