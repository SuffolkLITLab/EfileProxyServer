package edu.suffolk.litlab.efspserver.services;

import edu.suffolk.litlab.efspserver.SendMessage;

import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/*
 * This is just for custom endpoints, like Jefferson Parish. Other callbacks will be a SOAP server.
*/

@Path("/status_callback/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class EfmCallback {
  private static Logger log = 
      Logger.getLogger("edu.suffolk.litlab.efspserver.services.EfmCallback"); 

  // @POST("/court/{court_id}/{filing_id}/status")
  /*
  public Response getFilingStatus(@Context HttpHeaders httpHeaders,
  @PathParam("court_id") String courtId, 
  @PathParam("filing_id") String filingId)
  // the JP callback will include the same authentication token that we sent them
  */
}

// create endpoints with annotations like @GET
// comes from JAXRS