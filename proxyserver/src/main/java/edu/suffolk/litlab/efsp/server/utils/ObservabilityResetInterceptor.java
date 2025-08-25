package edu.suffolk.litlab.efsp.server.utils;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Provider
/** Clears all MDC entries after our business logic finishes running. */
public class ObservabilityResetInterceptor implements ContainerResponseFilter {
  private static final Logger log = LoggerFactory.getLogger(ObservabilityResetInterceptor.class);

  @Override
  public void filter(ContainerRequestContext request, ContainerResponseContext response)
      throws IOException {
    log.info(
        "Sending back status of {} in response to {}",
        response.getStatus(),
        request.getUriInfo().getPath());
    MDCWrappers.removeAllMDCs();
  }
}
