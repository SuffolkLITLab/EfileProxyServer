package edu.suffolk.litlab.efsp.server.utils;

import edu.suffolk.litlab.efsp.server.utils.ProxyServerException.AuthenticationNeeded;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ProxyServerExceptionMapper implements ExceptionMapper<ProxyServerException> {

  @Override
  public Response toResponse(ProxyServerException exception) {
    return switch (exception) {
      case AuthenticationNeeded n ->
          Response.status(Response.Status.UNAUTHORIZED)
              .entity("Need to be logged in to file")
              .build();
      default -> Response.status(500).build();
    };
  }
}
