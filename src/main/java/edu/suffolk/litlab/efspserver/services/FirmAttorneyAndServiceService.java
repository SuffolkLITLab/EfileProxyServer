package edu.suffolk.litlab.efspserver.services;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SecurityHub;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.schema.getfirmresponse.GetFirmResponseType;

/**
 * Service that handles the Firm, Attorney, and Service
 * Endpoints.
 * @author litlab
 *
 */
@Path("/firmattorneyservice/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class FirmAttorneyAndServiceService {

  private static Logger log = 
      LoggerFactory.getLogger(FirmAttorneyAndServiceService.class); 

  private SecurityHub security;
  
  public FirmAttorneyAndServiceService(SecurityHub security) {
    this.security = security;
  }

  @GET
  @Path("/firm")
  public Response getSelfFirm(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    GetFirmResponseType firm = firmPort.get().getFirm();
    return Response.ok(firm.getFirm()).build();
  }
  
}
