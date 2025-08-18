package edu.suffolk.litlab.efsp.server.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.MessageSettingsDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.db.model.MessageInfo;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import edu.suffolk.litlab.efsp.server.utils.MDCWrappers;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Path("/messages")
@Produces({MediaType.APPLICATION_JSON})
public class MessageSettingsService {
  private static Logger log = LoggerFactory.getLogger(MessageSettingsService.class);

  private final Supplier<LoginDatabase> ldSupplier;
  private final Supplier<MessageSettingsDatabase> mdSupplier;

  public MessageSettingsService(
      Supplier<LoginDatabase> ldSupplier, Supplier<MessageSettingsDatabase> mdSupplier) {
    this.ldSupplier = ldSupplier;
    this.mdSupplier = mdSupplier;
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
    OrgMessageSender orgMsg = new OrgMessageSender(mdSupplier, null);
    try (LoginDatabase ld = ldSupplier.get()) {
      Optional<AtRest> atRest = ld.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
      if (atRest.isEmpty()) {
        return Response.status(401).entity("\"Not logged in to efile\"").build();
      }
      MessageInfo info = orgMsg.getSettings(atRest.get().serverId);
      return Response.ok(info).build();
    } catch (SQLException ex) {
      log.error("Couldn't get email settings for server: ", ex);
      return Response.status(500).build();
    }
  }

  @PATCH
  @Path("/settings")
  public Response setMsgSettings(@Context HttpHeaders httpHeaders, String newInfoStr) {
    Optional<AtRest> atRest = Optional.empty();
    try (LoginDatabase ld = ldSupplier.get()) {
      MDC.put(MDCWrappers.OPERATION, "MessageSettingsService.setMsgSettings");
      atRest = ld.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY"));
    } catch (SQLException ex) {
      log.error("Error when trying to update settings: ", ex);
      return Response.status(500).build();
    }
    if (atRest.isEmpty()) {
      return Response.status(401).entity("\"Not logged in to efile\"").build();
    }
    if (newInfoStr == null || newInfoStr.isBlank()) {
      return Response.status(200).build();
    }
    ObjectMapper mapper = new ObjectMapper();

    JsonNode node;
    try {
      node = mapper.readTree(newInfoStr);
    } catch (JsonProcessingException e) {
      log.error("You need to pass a JSON string to /settings; we got {}", newInfoStr, e);
      return Response.status(400).build();
    }
    MessageInfo newInfo = new MessageInfo(node);

    try (var md = mdSupplier.get()) {
      MessageInfo existingInfo =
          md.findMessageInfo(atRest.get().serverId)
              .orElse(new MessageInfo(atRest.get().serverId, null, null, null, null, null));
      existingInfo.emailResponseTemplate = newInfo.emailResponseTemplate;
      existingInfo.subjectLine = newInfo.subjectLine;
      existingInfo.fromEmail = newInfo.fromEmail;
      md.updateTable(existingInfo);
      return Response.status(200).build();
    } catch (SQLException ex) {
      log.error("Error when trying to update settings: ", ex);
      return Response.status(500).build();
    }
  }
}
