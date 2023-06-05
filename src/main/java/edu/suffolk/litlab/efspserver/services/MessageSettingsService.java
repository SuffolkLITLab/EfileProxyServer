package edu.suffolk.litlab.efspserver.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.db.MessageInfo;
import edu.suffolk.litlab.efspserver.db.MessageSettingsDatabase;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Path("/messages")
@Produces({MediaType.APPLICATION_JSON})
public class MessageSettingsService {
  private static Logger log = LoggerFactory.getLogger(MessageSettingsService.class);

  private final DataSource ds;

  public MessageSettingsService(DataSource ds) {
    this.ds = ds;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    EndpointReflection ef = new EndpointReflection("");
    return Response.ok(
            ef.endPointsToMap(ef.findRESTEndpoints(List.of(MessageSettingsService.class))))
        .build();
  }

  @GET
  @Path("/settings")
  public Response getMsgSettings(@Context HttpHeaders httpHeaders) {
    MDC.put(MDCWrappers.OPERATION, "MessageSettingsService.getMsgSettings");
    try (Connection conn = ds.getConnection()) {
      LoginDatabase ld = new LoginDatabase(conn);
      Optional<AtRest> atRest = ld.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
      if (atRest.isEmpty()) {
        return Response.status(401).entity("\"Not logged in to efile\"").build();
      }
      var md = new MessageSettingsDatabase(conn);
      Optional<MessageInfo> info = md.findMessageInfo(atRest.get().serverId);
      if (info.isEmpty()) {
        MDCWrappers.removeAllMDCs();
        return Response.status(404).entity("\"No current email settings for this server\"").build();
      }
      MDCWrappers.removeAllMDCs();
      return Response.ok(info.get()).build();
    } catch (SQLException ex) {
      log.error("Couldn't get email settings for server: " + StdLib.strFromException(ex));
      MDCWrappers.removeAllMDCs();
      return Response.status(500).build();
    }
  }

  @PATCH
  @Path("/settings")
  public Response setMsgSettings(@Context HttpHeaders httpHeaders, String newInfoStr) {
    try (Connection conn = ds.getConnection()) {
      MDC.put(MDCWrappers.OPERATION, "MessageSettingsService.setMsgSettings");
      LoginDatabase ld = new LoginDatabase(conn);
      Optional<AtRest> atRest = ld.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
      if (atRest.isEmpty()) {
        return Response.status(401).entity("\"Not logged in to efile\"").build();
      }
      if (newInfoStr == null || newInfoStr.isBlank()) {
        MDCWrappers.removeAllMDCs();
        return Response.status(200).build();
      }
      ObjectMapper mapper = new ObjectMapper();

      JsonNode node;
      try {
        node = mapper.readTree(newInfoStr);
      } catch (JsonProcessingException e) {
        log.error("You need to pass a JSON string to /settings; we got " + newInfoStr);
        MDCWrappers.removeAllMDCs();
        return Response.status(400).build();
      }
      MessageInfo newInfo = new MessageInfo(node);

      var md = new MessageSettingsDatabase(conn);
      MessageInfo existingInfo =
          md.findMessageInfo(atRest.get().serverId)
              .orElse(new MessageInfo(atRest.get().serverId, null, null, null, null, null));
      existingInfo.emailResponseTemplate = newInfo.emailResponseTemplate;
      existingInfo.subjectLine = newInfo.subjectLine;
      existingInfo.fromEmail = newInfo.fromEmail;
      md.updateTable(existingInfo);
      MDCWrappers.removeAllMDCs();
      return Response.status(200).build();
    } catch (SQLException ex) {
      log.error("Error when trying to update settings: " + StdLib.strFromException(ex));
      MDCWrappers.removeAllMDCs();
      return Response.status(500).build();
    }
  }
}
