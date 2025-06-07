package edu.suffolk.litlab.efsp.server.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class JsonExceptionMapper implements ExceptionMapper<JsonProcessingException> {
  Logger log = LoggerFactory.getLogger(JsonExceptionMapper.class);

  @Override
  public Response toResponse(JsonProcessingException exception) {
    log.error("Exception when processing JSON input:", exception);
    return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
  }
}
