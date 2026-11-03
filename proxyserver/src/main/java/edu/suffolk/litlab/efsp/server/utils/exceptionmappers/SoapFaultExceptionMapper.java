package edu.suffolk.litlab.efsp.server.utils.exceptionmappers;

import edu.suffolk.litlab.efsp.server.services.AdminUserService;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.xml.ws.soap.SOAPFaultException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class SoapFaultExceptionMapper implements ExceptionMapper<SOAPFaultException> {
  private static final Logger log = LoggerFactory.getLogger(AdminUserService.class);

  @Override
  public Response toResponse(SOAPFaultException exception) {
    var fault = exception.getFault();
    if (fault != null) {
      var detail = fault.getDetail();
      if (detail != null) {
        var text = detail.getTextContent();
        log.error("Soap error: {}", text, exception);
      } else {
        log.error("Soap error (no text content?): {}", fault.getFaultString(), exception);
      }
    } else {
      log.error("Soap error (no fault?)", exception);
    }
    return Response.status(502).entity("\"Got an error response from a SOAP server\"").build();
  }
}
