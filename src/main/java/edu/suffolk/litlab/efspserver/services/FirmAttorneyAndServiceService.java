package edu.suffolk.litlab.efspserver.services;

import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
  
  /*
  @GET
  @Path("/attorneys")
  public Response getAttorneyList(@Context HttpHeaders httpHeaders) {
    
  }
  
  @GET
  @Path("/attorneys/{attorney_id}")
  public Response getAttorney(@Context HttpHeaders httpHeaders, 
      @PathParam("attorney_id") String attorneyId) {
    
  }
  
  @DELETE
  @Path("/attorneys/{attorney_id}")
  public Response removeAttorney(@Context HttpHeaders httpHeaders,
      @PathParam("attorney_id") String attorneyId) {
    
  }
  
  @GET
  @Path("/service-contacts")
  public Response getServiceContactList(@Context HttpHeaders httpHeaders) {
    
  }
  
  @GET
  @Path("/service-contacts/{contact_id}")
  public Response getServiceContact(@Context HttpHeaders httpHeaders, @PathParam("contact_id") String contactId) {
    
  }
  
  @GET
  @Path("/public-service-contacts")
  public Response getPublicList(@Context HttpHeaders httpHeaders, 
      String json) {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.readTree(json);
    // TODO(brycew): check for first Name, last name, firm name, and email
  }
  */
}
