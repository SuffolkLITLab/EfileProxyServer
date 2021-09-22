package edu.suffolk.litlab.efspserver.services;

import static edu.suffolk.litlab.efspserver.services.ServiceHelpers.makeResponse;
import static edu.suffolk.litlab.efspserver.docassemble.JsonHelpers.getStringMember;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.suffolk.litlab.efspserver.SecurityHub;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.schema.attachservicecontactrequest.AttachServiceContactRequestType;
import tyler.efm.services.schema.attorneylistresponse.AttorneyListResponseType;
import tyler.efm.services.schema.baseresponse.BaseResponseType;
import tyler.efm.services.schema.common.AddressType;
import tyler.efm.services.schema.common.AttorneyType;
import tyler.efm.services.schema.common.FirmType;
import tyler.efm.services.schema.common.ServiceContactType;
import tyler.efm.services.schema.createattorneyrequest.CreateAttorneyRequestType;
import tyler.efm.services.schema.createattorneyresponse.CreateAttorneyResponseType;
import tyler.efm.services.schema.createservicecontactrequest.CreateServiceContactRequestType;
import tyler.efm.services.schema.createservicecontactresponse.CreateServiceContactResponseType;
import tyler.efm.services.schema.detachservicecontactrequest.DetachServiceContactRequestType;
import tyler.efm.services.schema.getattorneyrequest.GetAttorneyRequestType;
import tyler.efm.services.schema.getattorneyresponse.GetAttorneyResponseType;
import tyler.efm.services.schema.getfirmresponse.GetFirmResponseType;
import tyler.efm.services.schema.getpubliclistrequest.GetPublicListRequestType;
import tyler.efm.services.schema.getservicecontactrequest.GetServiceContactRequestType;
import tyler.efm.services.schema.getservicecontactresponse.GetServiceContactResponseType;
import tyler.efm.services.schema.removeattorneyrequest.RemoveAttorneyRequestType;
import tyler.efm.services.schema.removeservicecontactrequest.RemoveServiceContactRequestType;
import tyler.efm.services.schema.servicecontactlistresponse.ServiceContactListResponseType;
import tyler.efm.services.schema.updateattorneyrequest.UpdateAttorneyRequestType;
import tyler.efm.services.schema.updateattorneyresponse.UpdateAttorneyResponseType;
import tyler.efm.services.schema.updatefirmrequest.UpdateFirmRequestType;
import tyler.efm.services.schema.updateservicecontactrequest.UpdateServiceContactRequestType;
import tyler.efm.services.schema.updateservicecontactresponse.UpdateServiceContactResponseType;

/**
 * Service that handles the Firm, Attorney, and Service
 * Endpoints.
 * @author litlab
 *
 */
@Path("/firmattorneyservice/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class FirmAttorneyAndServiceService {

  private SecurityHub security;
  private CodeDatabase cd;

  private tyler.efm.services.schema.common.ObjectFactory tylerCommonObjFac =
      new tyler.efm.services.schema.common.ObjectFactory();

  public FirmAttorneyAndServiceService(SecurityHub security, CodeDatabase cd) {
    this.security = security;
    this.cd = cd;
  }

  @GET
  @Path("/firm")
  public Response getSelfFirm(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(401).build();
    }

    GetFirmResponseType firm = firmPort.get().getFirm();
    return makeResponse(firm, () -> Response.ok(firm.getFirm()).build());
  }

  @PATCH
  @Path("/firm")
  public Response updateFirm(@Context HttpHeaders httpHeaders, String json) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(401).build();
    }

    GetFirmResponseType existing = firmPort.get().getFirm();
    FirmType firm = existing.getFirm();
    ObjectMapper mapper = new ObjectMapper();
    try {
      JsonNode node = mapper.readTree(json);
      getStringMember(node, "firmName").ifPresent(name -> firm.setFirmName(name));
      getStringMember(node, "phoneNumber").ifPresent(phone -> firm.setPhoneNumber(phone));
      AddressType addr = firm.getAddress();
      JsonNode addrNode = node.get("address");
      if (addrNode != null && addrNode.isObject()) {
        getStringMember(addrNode, "addressLine1").ifPresent(line1-> addr.setAddressLine1(line1));
        getStringMember(addrNode, "addressLine2").ifPresent(line2-> addr.setAddressLine2(line2));
        getStringMember(addrNode, "city").ifPresent(city -> addr.setCity(city));
        getStringMember(addrNode, "state").ifPresent(state -> addr.setState(state));
        getStringMember(addrNode, "zipCode").ifPresent(zip -> addr.setZipCode(zip));
        getStringMember(addrNode, "country").ifPresent(country -> addr.setCountry(country));
      }
      firm.setAddress(addr);

      UpdateFirmRequestType updateReq = new UpdateFirmRequestType();
      updateReq.setFirm(firm);
      BaseResponseType resp = firmPort.get().updateFirm(updateReq);
      return makeResponse(resp, () -> Response.ok().build());
    } catch (JsonProcessingException e) {
      return Response.status(400).entity("The Body passed should be proper JSON: " + e).build();
    }
  }

  @GET
  @Path("/attorneys")
  public Response getAttorneyList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    AttorneyListResponseType resp = firmPort.get().getAttorneyList();
    return makeResponse(resp, () -> Response.ok(resp.getAttorney()).build());
  }

  @GET
  @Path("/attorneys/{attorney_id}")
  public Response getAttorney(@Context HttpHeaders httpHeaders,
      @PathParam("attorney_id") String attorneyId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    GetAttorneyRequestType req = new GetAttorneyRequestType();
    req.setAttorneyID(attorneyId);
    GetAttorneyResponseType resp = firmPort.get().getAttorney(req);
    return makeResponse(resp, () -> Response.ok(resp.getAttorney()).build());
  }

  @POST
  @Path("/attorneys")
  public Response createAttorney(@Context HttpHeaders httpHeaders,
      AttorneyType attorney) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }
    CreateAttorneyRequestType req = new CreateAttorneyRequestType();
    req.setAttorney(attorney);
    // TODO(brycew-later): what happens if a court has an additional requirement on the attorney number?
    // Won't in IL at least. If it does, this whole system is poorly defined
    DataFieldRow row = cd.getDataField("1", "GlobalAttorneyNumber");
    if (row.isrequired && attorney.getBarNumber().isBlank()) {
      return Response.status(400).entity("Bar number required").build();
    }
    if (!row.matchRegex(attorney.getBarNumber())) {
      return Response.status(400).entity("Bar number doesn't match regex: " + row.regularexpression).build();
    }

    CreateAttorneyResponseType resp = firmPort.get().createAttorney(req);
    return makeResponse(resp, () -> Response.ok("\"" + resp.getAttorneyID() + "\"").build());
  }

  @PATCH
  @Path("/attorneys/{attorney_id}")
  public Response updateAttorney(@Context HttpHeaders httpHeaders,
      @PathParam("attorney_id") String attorneyId, String json) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    GetAttorneyRequestType req = new GetAttorneyRequestType();
    req.setAttorneyID(attorneyId);
    GetAttorneyResponseType existingResp = firmPort.get().getAttorney(req);
    AttorneyType att = existingResp.getAttorney();

    ObjectMapper mapper = new ObjectMapper();
    try {
      JsonNode node = mapper.readTree(json);
      getStringMember(node, "firstName").ifPresent(first -> att.setFirstName(first));
      getStringMember(node, "middleName").ifPresent(middle -> att.setMiddleName(middle));
      getStringMember(node, "lastName").ifPresent(last-> att.setLastName(last));
      getStringMember(node, "barNumber").ifPresent(bar -> att.setBarNumber(bar));

      UpdateAttorneyRequestType updateReq = new UpdateAttorneyRequestType();
      updateReq.setAttorney(att);
      UpdateAttorneyResponseType resp = firmPort.get().updateAttorney(updateReq);
      return makeResponse(resp, () -> Response.ok("\"" + resp.getAttorneyID() + "\"").build());
    } catch (JsonProcessingException e) {
      return Response.status(400).entity("The Body passed should be proper JSON: " + e).build();
    }
  }

  @DELETE
  @Path("/attorneys/{attorney_id}")
  public Response removeAttorney(@Context HttpHeaders httpHeaders,
      @PathParam("attorney_id") String attorneyId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(403).build();
    }

    RemoveAttorneyRequestType req = new RemoveAttorneyRequestType();
    req.setAttorneyID(attorneyId);
    BaseResponseType resp = firmPort.get().removeAttorney(req);
    return makeResponse(resp, () -> Response.ok().build());
  }

  @GET
  @Path("/service-contacts")
  public Response getServiceContactList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(401).build();
    }
    ServiceContactListResponseType resp = firmPort.get().getServiceContactList();
    return makeResponse(resp, () -> Response.ok(resp.getServiceContact()).build());
  }

  @GET
  @Path("/service-contacts/{contact_id}")
  public Response getServiceContact(@Context HttpHeaders httpHeaders,
      @PathParam("contact_id") String contactId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(401).build();
    }

    GetServiceContactRequestType req = new GetServiceContactRequestType();
    req.setServiceContactID(contactId);
    GetServiceContactResponseType resp = firmPort.get().getServiceContact(req);
    return makeResponse(resp, () -> Response.ok(resp.getServiceContact()).build());
  }

  @DELETE
  @Path("/service-contacts/{contact_id}")
  public Response removeServiceContact(@Context HttpHeaders httpHeaders,
      @PathParam("contact_id") String contactId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(401).build();
    }

    RemoveServiceContactRequestType req = new RemoveServiceContactRequestType();
    req.setServiceContactID(contactId);
    BaseResponseType resp = firmPort.get().removeServiceContact(req);
    return makeResponse(resp, ()-> Response.ok().build());
  }

  @POST
  @Path("/service-contacts")
  public Response createServiceContact(@Context HttpHeaders httpHeaders,
      ServiceContactInput input) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(401).build();
    }

    CreateServiceContactRequestType req = new CreateServiceContactRequestType();
    ServiceContactType contact = new ServiceContactType();
    contact.setAddress(input.address);
    contact.setAdministrativeCopy(input.administrativeCopy);
    contact.setEmail(input.email);
    contact.setFirstName(input.firstName);
    contact.setMiddleName(input.middleName);
    contact.setLastName(input.lastName);
    contact.setIsPublic(tylerCommonObjFac.createServiceContactTypeIsPublic(input.isPublic));
    contact.setIsInFirmMasterList(tylerCommonObjFac.createServiceContactTypeIsInFirmMasterList(input.isInFirmMaster));
    contact.setPhoneNumber(input.phoneNumber);
    req.setServiceContact(contact);
    CreateServiceContactResponseType resp = firmPort.get().createServiceContact(req);
    return makeResponse(resp, ()->Response.ok("\"" + resp.getServiceContactID() + "\"").build());
  }

  @PUT
  @Path("/service-contacts/{contact_id}/cases")
  public Response attachServiceContact(@Context HttpHeaders httpHeaders,
      @PathParam("contact_id") String contactId, String json) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(401).build();
    }
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node;
    try {
      node = mapper.readTree(json);
    } catch (JsonProcessingException e) {
      return Response.status(400).entity(e.toString()).build();
    }
    if (!node.has("caseId") || !node.get("caseId").isTextual()) {
      return Response.status(400).entity("Need to pass in caseId as text").build();
    }

    AttachServiceContactRequestType req = new AttachServiceContactRequestType();
    req.setServiceContactID(contactId);
    req.setCaseID(node.get("caseId").asText());
    if (node.has("casePartyId") && node.get("casePartyId").isTextual()) {
      req.setCasePartyID(node.get("casePartyId").asText());
    }
    BaseResponseType resp = firmPort.get().attachServiceContact(req);
    return makeResponse(resp, () -> Response.ok().build());
  }

  @DELETE
  @Path("/service-contacts/{contact_id}/cases/{case_id}")
  public Response detachServiceContact(@Context HttpHeaders httpHeaders,
      @PathParam("contact_id") String contactId, @PathParam("case_id") String caseId,
      @QueryParam("case_party_id") String casePartyId) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(401).build();
    }

    DetachServiceContactRequestType req = new DetachServiceContactRequestType();
    req.setServiceContactID(contactId);
    req.setCaseID(caseId);
    if (casePartyId != null && !casePartyId.isBlank()) {
      req.setCasePartyID(casePartyId);
    }
    BaseResponseType resp = firmPort.get().detachServiceContact(req);
    return makeResponse(resp, () -> Response.ok().build());
  }

  @PATCH
  @Path("/service-contacts/{contact_id}")
  public Response updateServiceContact(@Context HttpHeaders httpHeaders,
      @PathParam("contact_id") String contactId, String json) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(401).build();
    }

    GetServiceContactRequestType getReq = new GetServiceContactRequestType();
    getReq.setServiceContactID(contactId);
    GetServiceContactResponseType getResp = firmPort.get().getServiceContact(getReq);
    if (ServiceHelpers.hasError(getResp)) {
      return Response.status(404).entity("No service contact with id " + contactId).build();
    }
    ServiceContactType contact = getResp.getServiceContact();
    ObjectMapper mapper = new ObjectMapper();
    try {
      JsonNode node = mapper.readTree(json);
      getStringMember(node, "firstName").ifPresent(first -> contact.setFirstName(first));
      getStringMember(node, "middleName").ifPresent(middle -> contact.setMiddleName(middle));
      getStringMember(node, "lastName").ifPresent(last-> contact.setLastName(last));
      getStringMember(node, "email").ifPresent(email -> contact.setEmail(email));
      getStringMember(node, "administrativeCopy").ifPresent(email -> contact.setAdministrativeCopy(email));
      getStringMember(node, "phoneNumber").ifPresent(phone -> contact.setPhoneNumber(phone));
      getJsonBoolean(node, "isPublic").ifPresent(
          pub -> contact.setIsPublic(tylerCommonObjFac.createServiceContactTypeIsPublic(pub)));
      getJsonBoolean(node, "isInFirmMasterList").ifPresent(
          in -> contact.setIsInFirmMasterList(tylerCommonObjFac.createServiceContactTypeIsInFirmMasterList(in)));
    } catch (JsonProcessingException e) {
      return Response.status(400).entity(e.toString()).build();
    }
    UpdateServiceContactRequestType req = new UpdateServiceContactRequestType();
    req.setServiceContact(contact);
    UpdateServiceContactResponseType resp = firmPort.get().updateServiceContact(req);
    return makeResponse(resp, () -> Response.ok("\"" + resp.getServiceContactID() + "\"").build());
  }

  @GET
  @Path("/service-contacts/public")
  public Response getPublicList(@Context HttpHeaders httpHeaders,
      String json) {
    Optional<IEfmFirmService> firmPort = ServiceHelpers.setupFirmPort(httpHeaders, security);
    if (firmPort.isEmpty()) {
      return Response.status(401).build();
    }
    ObjectMapper mapper = new ObjectMapper();
    GetPublicListRequestType msg = new GetPublicListRequestType();
    try {
      JsonNode node = mapper.readTree(json);
      getStringMember(node, "firstName").ifPresent(first-> msg.setFirstName(first));
      getStringMember(node, "lastName").ifPresent(last-> msg.setFirstName(last));
      getStringMember(node, "firmName").ifPresent(firmName-> msg.setFirstName(firmName));
      getStringMember(node, "email").ifPresent(email-> msg.setFirstName(email));
      ServiceContactListResponseType resp = firmPort.get().getPublicList(msg);
      // For "PublicServiceContactShowEmail" Datafield, we force API keys: the restriction of 
      // "programmatic harvesting of emails" will have to be done on the DA side
      return makeResponse(resp,
          () -> {
            DataFieldRow row = cd.getDataField("1", "PublicServiceContactShowFreeFormFirmName");
            List<ServiceContactType> contacts = resp.getServiceContact();
            contacts.stream().forEach(con -> {
              if (!row.isvisible) {
                // Hide the FirmName, but leave the AddByFirmName alone
                con.setFirmName(null);
              }
            });
            return Response.ok(contacts).build();
          });
    } catch (JsonProcessingException e) {
      return Response.status(400).entity(e.toString()).build();
    }
  }

  private Optional<Boolean> getJsonBoolean(JsonNode node, String attr) {
      JsonNode maybeAttr = node.get(attr);
      if (maybeAttr != null && maybeAttr.isBoolean()) {
        return Optional.of(maybeAttr.asBoolean());
      }
      return Optional.empty();
  }
}
