package edu.suffolk.litlab.efspserver.services;

import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.SecurityHub;
import edu.suffolk.litlab.efspserver.db.LoginInfo;
import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/codes/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class Codes {
  private static Logger log = LoggerFactory.getLogger(Codes.class); 
  private Map<String, EfmFilingInterface> filingInterfaces;

  private CodeDatabase cd;
  public Codes(CodeDatabase cd, Map<String, EfmFilingInterface> filingInterfaces) {
    this.cd = cd;
    this.filingInterfaces = filingInterfaces;
  }


  @GET
  @Path("/categories/{court_id}")
  public Response getCategories(@Context HttpHeaders httpHeaders, 
    @PathParam("court_id") String courtId) throws SQLException {
      List<CaseCategory> categories;

      if (!filingInterfaces.containsKey(courtId)) {
        return Response.status(404).entity("Court does not exist " + courtId).build();
      }
      categories = cd.getCaseCategoriesFor(courtId);

    return Response.ok(categories).build();
  }

}
