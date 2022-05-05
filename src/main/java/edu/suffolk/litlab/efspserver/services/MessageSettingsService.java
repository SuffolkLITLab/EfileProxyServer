package edu.suffolk.litlab.efspserver.services;

import static edu.suffolk.litlab.efspserver.services.EndpointReflection.endPointsToMap;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.db.MessageInfo;
import edu.suffolk.litlab.efspserver.db.MessageSettingsDatabase;

@Path("/messages")
@Produces({MediaType.APPLICATION_JSON})
public class MessageSettingsService {
  private static Logger log = 
      LoggerFactory.getLogger(MessageSettingsService.class); 
  
  private SecurityHub security;
  private MessageSettingsDatabase md;

  public MessageSettingsService(SecurityHub security,
      MessageSettingsDatabase md) {
    this.security = security;
    this.md = md;
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAll() {
    EndpointReflection ef = new EndpointReflection();
    return Response.ok(endPointsToMap(ef.findRESTEndpoints(List.of(MessageSettingsService.class)))).build();
  }
  
  @GET
  @Path("/settings")
  public Response getMsgSettings(@Context HttpHeaders httpHeaders) {
    Optional<AtRest> atRest = security.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY")); 
    if (atRest.isEmpty()) {
      return Response.status(401).entity("Not logged in to efile").build();
    }
    Optional<MessageInfo> info = this.md.findMessageInfo(atRest.get().serverId);
    if (info.isEmpty()) {
      return Response.status(404).entity("No current email settings for this server").build();
    }
    
    return Response.ok(info.get()).build();
  }
  
  @PATCH
  @Path("/settings")
  public Response setMsgSettings(@Context HttpHeaders httpHeaders, String newInfoStr) {
    Optional<AtRest> atRest = security.getAtRestInfo(httpHeaders.getHeaderString("X-API-KEY")); 
    if (atRest.isEmpty()) {
      return Response.status(401).entity("Not logged in to efile").build();
    }

    if (newInfoStr == null || newInfoStr.isBlank()) {
      return Response.status(200).build();
    }
    ObjectMapper mapper = new ObjectMapper();
    
    JsonNode node;
    try {
      node = mapper.readTree(newInfoStr);
    } catch (JsonProcessingException e) {
      log.error("You need to pass a JSON string");
      return Response.status(400).build();
    }
    MessageInfo newInfo = new MessageInfo(node);
    
    MessageInfo existingInfo = this.md.findMessageInfo(atRest.get().serverId) 
        .orElse(new MessageInfo(atRest.get().serverId, null, null, null, null));
    existingInfo.emailTemplate = newInfo.emailTemplate;
    existingInfo.subjectLine = newInfo.subjectLine;
    existingInfo.fromEmail = newInfo.fromEmail;
    try {
      md.updateTable(existingInfo); 
      return Response.status(200).build();
    } catch (SQLException ex) {
      log.error("Error when trying to update settings: " + ex);
      return Response.status(500).build();
    }
  }
}
