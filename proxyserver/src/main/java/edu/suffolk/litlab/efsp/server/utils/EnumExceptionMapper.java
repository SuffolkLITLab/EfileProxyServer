package edu.suffolk.litlab.efsp.server.utils;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EnumExceptionMapper implements ExceptionMapper<IllegalArgumentException> {
  public Logger log = LoggerFactory.getLogger(EnumExceptionMapper.class);

  @Override
  public Response toResponse(IllegalArgumentException exception) {
    if (exception
        .getMessage()
        .contains(" edu.suffolk.litlab.efsp.server.services.EcfCodesService.DesiredResult")) {
      return Response.status(400)
          .entity("Unknown value for `result` parameter: should be 'NAMES', or 'COURT_COVERAGE'")
          .build();
    }
    log.error("Catching non user-facing IllegalArgumentException", exception);
    return Response.status(500).build();
  }
}
