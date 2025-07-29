package edu.suffolk.litlab.efsp.server.utils;

import edu.suffolk.litlab.efsp.server.services.AdminUserService;
import edu.suffolk.litlab.efsp.stdlib.StdLib;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.apache.cxf.interceptor.Fault;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class SoapExceptionMapper implements ExceptionMapper<Fault> {
  private static final Logger log = LoggerFactory.getLogger(AdminUserService.class);

  @Override
  public Response toResponse(Fault exception) {
    log.error(StdLib.strFromException(exception));
    return Response.status(500)
        .entity("\"Something went wrong when talking to Tyler Technologies servers\"")
        .build();
  }
}
