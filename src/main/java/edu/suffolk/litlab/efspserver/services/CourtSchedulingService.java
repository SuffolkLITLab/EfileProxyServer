package edu.suffolk.litlab.efspserver.services;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.ws.BindingProvider;

import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.hubspot.algebra.Result;

import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ReserveCourtDateRequestType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ReturnDateRequestType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reservedate.ReserveCourtDateMessageType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.courtschedulingmde.CourtSchedulingMDE;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.courtschedulingmde.CourtSchedulingMDE_Service;
import ecfv5.tyler.ecf.v5_0.extensions.common.FilingAttorneyEntityType;
import ecfv5.tyler.ecf.v5_0.extensions.common.FilingPartyEntityType;
import ecfv5.tyler.ecf.v5_0.extensions.common.FilingReferenceType;
import ecfv5.tyler.ecf.v5_0.extensions.reservedateresponse.ReserveDateResponseMessageType;
import ecfv5.tyler.ecf.v5_0.extensions.returndate.ReturnDateMessageType;
import ecfv5.tyler.ecf.v5_0.extensions.returndateresponse.ReturnDateResponseMessageType;
import edu.suffolk.litlab.efspserver.FilingDoc;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.SecurityHub;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.XmlHelper;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.codes.PartyType;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.ecf.ComboCaseCodes;
import edu.suffolk.litlab.efspserver.ecf.EcfCourtSpecificSerializer;
import edu.suffolk.litlab.efspserver.ecf.TylerLogin;
import ecfv5.gov.niem.release.niem.domains.cbrn._4.MessageContentErrorType;
import ecfv5.gov.niem.release.niem.domains.cbrn._4.MessageErrorType;
import ecfv5.gov.niem.release.niem.domains.cbrn._4.MessageStatusType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.CaseAugmentationType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.CaseOfficialType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.CourtEventType;
import ecfv5.gov.niem.release.niem.niem_core._4.AmountType;
import ecfv5.gov.niem.release.niem.niem_core._4.CaseType;
import ecfv5.gov.niem.release.niem.niem_core._4.DateRangeType;
import ecfv5.gov.niem.release.niem.niem_core._4.DateType;
import ecfv5.gov.niem.release.niem.niem_core._4.EntityType;
import ecfv5.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecfv5.gov.niem.release.niem.niem_core._4.PersonType;
import ecfv5.gov.niem.release.niem.niem_core._4.TextType;
import ecfv5.gov.niem.release.niem.proxy.xsd._4.Decimal;
import ecfv5.gov.niem.release.niem.proxy.xsd._4.Duration;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseFilingType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseOfficialAugmentationType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CourtEventAugmentationType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.PersonAugmentationType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;

@Path("/scheduling/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CourtSchedulingService {

  private static Logger log = LoggerFactory.getLogger(CourtSchedulingService.class);
  private static CourtSchedulingMDE_Service schedFactory = new CourtSchedulingMDE_Service();

  private ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ObjectFactory oasisWrapObjFac;
  private ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reservedate.ObjectFactory reserveDateObjFac;
  private ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory oasisObjFac;
  private ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.ObjectFactory oasisCivilObjFac;
  private ecfv5.tyler.ecf.v5_0.extensions.common.ObjectFactory tylerObjFac;
  private final ecfv5.gov.niem.release.niem.niem_core._4.ObjectFactory niemObjFac;
  private final ecfv5.gov.niem.release.niem.proxy.xsd._4.ObjectFactory proxyObjFac;
  private final ecfv5.gov.niem.release.niem.domains.jxdm._6.ObjectFactory jxObjFac;
  private final Map<String, InterviewToFilingEntityConverter> converterMap;
  private final SecurityHub security;
  private final CodeDatabase cd;

  
  public CourtSchedulingService(Map<String, InterviewToFilingEntityConverter> converterMap, SecurityHub security, CodeDatabase cd) {
    this.cd = cd;
    this.security = security;
    this.converterMap = converterMap;
    this.oasisWrapObjFac = new ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ObjectFactory();
    this.oasisObjFac = new ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory();
    this.reserveDateObjFac = new ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reservedate.ObjectFactory();
    this.oasisCivilObjFac = new ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.ObjectFactory();
    this.tylerObjFac = new ecfv5.tyler.ecf.v5_0.extensions.common.ObjectFactory();
    this.niemObjFac = new ecfv5.gov.niem.release.niem.niem_core._4.ObjectFactory();
    this.proxyObjFac = new ecfv5.gov.niem.release.niem.proxy.xsd._4.ObjectFactory();
    this.jxObjFac = new ecfv5.gov.niem.release.niem.domains.jxdm._6.ObjectFactory();
  }
  
  @POST
  @Path("/courts/{court_id}/return_date")
  public Response getReturnDate(@Context HttpHeaders httpHeaders, 
      @PathParam("court_id") String courtId, String allVars) throws SQLException, JAXBException {
    Optional<CourtSchedulingMDE> maybeServ = setupSchedulingPort(httpHeaders);
    if (maybeServ.isEmpty()) {
      return Response.status(401).build();
    }
    Optional<CourtLocationInfo> locationInfo = cd.getFullLocationInfo(courtId); 
    if (locationInfo.isEmpty()) {
      return Response.status(404).entity("No court: " + courtId).build(); 
    }
    if (!locationInfo.get().allowreturndate) {
      return Response.status(400).entity("Court " + courtId + " doesn't allow handling return dates").build();
    }
    
    MediaType mediaType = httpHeaders.getMediaType();
    InfoCollector collector = new FailFastCollector();
    Result<FilingInformation, FilingError> res = converterMap.get(mediaType.toString()).traverseInterview(allVars, collector);
    if (res.isErr()) {
      return Response.status(400).entity(collector.jsonSummary()).build();
    }
    FilingInformation info = res.unwrapOrElseThrow();
    info.setCourtLocation(courtId);
    if (info.getFilings().isEmpty()) {
      return Response.status(400).entity("Need to have a filing to calculate a request date").build();
    }
    try {
    EcfCourtSpecificSerializer serializer = new EcfCourtSpecificSerializer(cd, locationInfo.get());
    ComboCaseCodes allCodes = serializer.serializeCaseCodes(info, collector);
    Optional<String> caseTrackingId = info.getPreviousCaseId(); 
    List<FilingDoc.PartyId> partyIds = info.getFilers();
    // HACK(brycew): ECF allows multiple filers for an envelope, but this stupid Tyler call only takes a single Party Id. 
    Optional<FilingDoc.PartyId> firstFiler = (partyIds.isEmpty()) ? Optional.empty() : Optional.of(partyIds.get(0));
    Optional<String> filingAttorneyId = info.getFilings().get(0).getFilingAttorney();
    Optional<LocalDate> returnDate = info.getReturnDate();
    if (returnDate.isEmpty()) {
      return Response.status(400).entity("Need return_date").build();
    }
    
    boolean outOfState = false; 
    if (info.getMiscInfo().has("out_of_state")) {
      outOfState = info.getMiscInfo().get("out_of_state").asBoolean(false);
    }
    Optional<BigDecimal> maybeAmt = Optional.empty();
    if (allCodes.filings.stream().anyMatch(f -> f.amountincontroversy.equalsIgnoreCase("Required"))) {
      JsonNode jsonAmt = info.getMiscInfo().get("amount_in_controversy");
      if (jsonAmt == null || !jsonAmt.isBigDecimal()) {
        return Response.status(400).entity("Amount in controversy required").build();
      }
      maybeAmt = Optional.of(jsonAmt.decimalValue());
    }
    
    ReturnDateRequestType r = oasisWrapObjFac.createReturnDateRequestType();
    ReturnDateMessageType m = new ReturnDateMessageType();
    setupReq(m, courtId);
    CaseType ct = niemObjFac.createCaseType();
    caseTrackingId.ifPresent(id -> ct.setCaseTrackingID(Ecfv5XmlHelper.convertString(id)));

    DateType currentDate = Ecfv5XmlHelper.convertDate(LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()));
    CourtEventType event = jxObjFac.createCourtEventType();
    int i = 0;
    for (FilingDoc doc : info.getFilings()) {
      Optional<String> motionTypeCode = doc.getMotionType();
      CourtEventAugmentationType e = oasisObjFac.createCourtEventAugmentationType();
      e.setCourtEventEnteredOnDocketDate(currentDate);
      e.setCourtEventTypeCode(Ecfv5XmlHelper.convertText(allCodes.filings.get(i).code));
      motionTypeCode.ifPresentOrElse(mot -> {
        e.setCourtLocationCode(tylerObjFac.createMotionTypeCode(Ecfv5XmlHelper.convertText(mot)));
      }, () -> {
        e.setCourtLocationCode(tylerObjFac.createMotionTypeCode(Ecfv5XmlHelper.convertText("")));
      });
      event.getCourtEventAugmentationPoint().add(oasisObjFac.createCourtEventAugmentation(e));
      i++;
    }
    CaseAugmentationType jAug = jxObjFac.createCaseAugmentationType();
    jAug.getCaseCourtEvent().add(event);
    i = 1;
    for (String attorneyId : info.getAttorneyIds()) {
      Optional<String> partyRepresented = info.getPartyRepByAttorney(attorneyId);
      if (partyRepresented.isEmpty()) {
        return Response.status(400).entity("Attorney " + attorneyId + " doesn't represent any parties").build();
      }
      CaseOfficialType cot = jxObjFac.createCaseOfficialType();
      PersonType per = niemObjFac.createPersonType();
      per.setId("Attorney" + i);
      IdentificationType idTy = niemObjFac.createIdentificationType();
      idTy.setIdentificationID(Ecfv5XmlHelper.convertString(attorneyId));
      idTy.setIdentificationSourceText(Ecfv5XmlHelper.convertText("ATTORNEYID"));
      per.getPersonOtherIdentification().add(idTy);
      cot.setRoleOfPerson(per);
      CaseOfficialAugmentationType caseOffAug = oasisObjFac.createCaseOfficialAugmentationType();
      EntityType ent = niemObjFac.createEntityType();
      log.info("Party rep: " + partyRepresented.get());
      ent.setRef(partyRepresented.get());
      caseOffAug.getCaseRepresentedParty().add(ent);
      cot.getCaseOfficialAugmentationPoint().add(oasisObjFac.createCaseOfficialAugmentation(caseOffAug));
      jAug.getCaseOfficial().add(cot);
      i++;
    }
    ct.getCaseAugmentationPoint().add(jxObjFac.createCaseAugmentation(jAug));

    ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseAugmentationType ecfAug = 
        oasisObjFac.createCaseAugmentationType();
    TextType catText = niemObjFac.createTextType();
    catText.setValue(allCodes.cat.code.get());
    ecfAug.getRest().add(oasisObjFac.createCaseCategoryCode(catText));
    ecfAug.getRest().add(oasisObjFac.createCaseTypeCode(Ecfv5XmlHelper.convertNormalized(allCodes.type.code)));
    // TODO(brycew-later): write ecfv5 versions of this. Right now, don't have time to reimplement everything, so checking with old ecfv4 code and building here 
    List<PartyType> partyTypes = cd.getPartyTypeFor(courtId, allCodes.type.code); 
    List<String> partyTypeNames = partyTypes.stream().map(p -> p.name).collect(Collectors.toList());
    Map<String, EntityType> idToCaseParty = new HashMap<String, EntityType>();
    
    Function<Person, Result<EntityType, Response>> genEnt = (per) -> {
      Optional<PartyType> matchingType = partyTypes.stream()
          .filter(pt -> pt.name.equalsIgnoreCase(per.getRole()))
          .findFirst();
      TextType roleText = niemObjFac.createTextType();
      if (matchingType.isEmpty()) {
        InterviewVariable ptVar = collector.requestVar("party_type", "Legal role of the party", "choices", partyTypeNames);
        try {
          collector.addWrong(ptVar);
        } catch (FilingError err) {
          // N/A
        }
        return Result.err(Response.status(400).entity(collector.jsonSummary()).build());
      } else {
        roleText.setValue(matchingType.get().code);
      }
      EntityType ent = niemObjFac.createEntityType();
      PersonAugmentationType pat = oasisObjFac.createPersonAugmentationType();
      pat.getCaseParticipantRoleCode().add(roleText);
      if (!info.getPartyAttorneyMap().containsKey(per.getIdString()) 
          || info.getPartyAttorneyMap().get(per.getIdString()).isEmpty()) {
        IdentificationType idType = niemObjFac.createIdentificationType();
        idType.setIdentificationID(Ecfv5XmlHelper.convertString("SRL"));
        pat.setParticipantID(idType);
      } else {
        pat.setParticipantID(null); 
      }
      PersonType perType = niemObjFac.createPersonType();
      perType.getPersonAugmentationPoint().add(oasisObjFac.createPersonAugmentation(pat));
      ent.setEntityRepresentation(niemObjFac.createEntityPerson(perType)); 
      ent.setId(per.getIdString());
      idToCaseParty.put(per.getIdString(), ent);
      return Result.ok(ent);
    };
    for (Person per: info.getPlaintiffs()) {
      Result<EntityType, Response> ent = genEnt.apply(per);
      if (ent.isErr()) {
        return ent.unwrapErrOrElseThrow();
      }
      ecfAug.getRest().add(oasisObjFac.createCaseParty(ent.unwrapOrElseThrow()));
    }
    for (Person per: info.getDefendants()) {
      Result<EntityType, Response> ent = genEnt.apply(per);
      if (ent.isErr()) {
        return ent.unwrapErrOrElseThrow();
      }
      ecfAug.getRest().add(oasisObjFac.createCaseParty(ent.unwrapOrElseThrow()));
    }
    ct.getCaseAugmentationPoint().add(oasisObjFac.createCaseAugmentation(ecfAug));

    ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.CaseAugmentationType oasisAug =
        oasisCivilObjFac.createCaseAugmentationType();
    if (maybeAmt.isPresent()) {
      AmountType at = niemObjFac.createAmountType();
      Decimal d = proxyObjFac.createDecimal();
      d.setValue(maybeAmt.get());
      at.setAmount(d); 
      oasisAug.setAmountInControversy(at);
    }
    oasisAug.setJuryDemandIndicator(Ecfv5XmlHelper.convertBool(false));
    ct.getCaseAugmentationPoint().add(oasisCivilObjFac.createCaseAugmentation(oasisAug));

    ecfv5.tyler.ecf.v5_0.extensions.common.CaseAugmentationType tylerAug = tylerObjFac.createCaseAugmentationType();
    firstFiler.ifPresent(fil -> {
      FilingPartyEntityType fpet = tylerObjFac.createFilingPartyEntityType();
      log.info("Filing party: " + fil); 
      if (fil.isInCurrentFiling()) {
        FilingReferenceType frt = tylerObjFac.createFilingReferenceType();
        frt.setRef(idToCaseParty.get(fil.id));
        fpet.setPartyReference(frt);
      } else {
        IdentificationType idType = niemObjFac.createIdentificationType();
        idType.setIdentificationID(Ecfv5XmlHelper.convertString(fil.id));
        fpet.setPartyIdentification(idType); 
      }
      tylerAug.setFilingParty(fpet);
    });
    if (filingAttorneyId.isPresent()) {
      FilingAttorneyEntityType faet = tylerObjFac.createFilingAttorneyEntityType();
      faet.setAttorneyIdentification(Ecfv5XmlHelper.convertId(filingAttorneyId.get()));
      tylerAug.setFilingAttorney(faet);
    }

    Map<String, String> crossReferences = serializer.getCrossRefIds(info, collector, courtId, allCodes.type.code);
    for (Map.Entry<String, String> refs : crossReferences.entrySet()) {
      IdentificationType idType = niemObjFac.createIdentificationType();
      idType.setIdentificationID(Ecfv5XmlHelper.convertString(refs.getValue()));
      idType.setIdentificationSourceText(Ecfv5XmlHelper.convertText(refs.getKey()));
      tylerAug.getCrossReferenceNumber().add(idType);
    }

    ct.getCaseAugmentationPoint().add(tylerObjFac.createCaseAugmentation(tylerAug));
    m.setCase(ct);
    m.setReturnDate(Ecfv5XmlHelper.convertDate(returnDate.get()));
    m.setOutOfStateIndicator(Ecfv5XmlHelper.convertBool(outOfState));
    r.setReturnDateMessage(m);
    log.info("Full msg: " + XmlHelper.objectToXmlStrOrError(r, ReturnDateRequestType.class));
    ReturnDateResponseMessageType resp = maybeServ.get().getReturnDate(r).getReturnDateResponseMessage();
    log.info("Full resp: " + XmlHelper.objectToXmlStrOrError(resp, ReturnDateResponseMessageType.class));
    for (MessageContentErrorType err : resp.getMessageStatus().getMessageContentError()) {
      if (err.getErrorDescription().getErrorCodeText().getValue().equals("344")) {
        tylerAug.getCrossReferenceNumber().clear();
        ct.getCaseAugmentationPoint().add(tylerObjFac.createCaseAugmentation(tylerAug));
        m.setCase(ct);
        r.setReturnDateMessage(m);
        log.info("New full msg: " + XmlHelper.objectToXmlStrOrError(r, ReturnDateRequestType.class));
        resp = maybeServ.get().getReturnDate(r).getReturnDateResponseMessage();
        log.info("New full resp: " + XmlHelper.objectToXmlStrOrError(resp, ReturnDateResponseMessageType.class));
      }
    }
    MessageErrorType err = resp.getMessageStatus().getMessageHandlingError();
      if (err.getErrorCodeText().getValue().equals("344")) {
        tylerAug.getCrossReferenceNumber().clear();
        ct.getCaseAugmentationPoint().add(tylerObjFac.createCaseAugmentation(tylerAug));
        m.setCase(ct);
        r.setReturnDateMessage(m);
        log.info("New full msg: " + XmlHelper.objectToXmlStrOrError(r, ReturnDateRequestType.class));
        resp = maybeServ.get().getReturnDate(r).getReturnDateResponseMessage();
        log.info("New full resp: " + XmlHelper.objectToXmlStrOrError(resp, ReturnDateResponseMessageType.class));
      }
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getMessageStatus()).build();
    }
    return Response.ok(resp).build();
    } catch (FilingError err) {
      return Response.status(422).entity(collector.jsonSummary()).build();
    }
  }
  
  @POST
  @Path("/courts/{court_id}/reserve_date")
  public Response reserveCourtDateSync(@Context HttpHeaders httpHeaders,
      @PathParam("court_id") String courtId, String paramStr) throws JsonMappingException, JsonProcessingException, DatatypeConfigurationException {
    JsonMapper mapper = new JsonMapper();
    JsonNode params = mapper.readTree(paramStr); 
    
    ReserveCourtDateMessageType msg = reserveDateObjFac.createReserveCourtDateMessageType();
    setupReq(msg, courtId);
    if (!params.has("doc_id") || !params.get("doc_id").isTextual()) {
      return Response.status(400).entity("Need to pass doc_id").build();
    }
    IdentificationType idType = niemObjFac.createIdentificationType();
    idType.setId(params.get("doc_id").asText());
    msg.getDocumentIdentification().add(idType);
    
    if (params.has("estimated_duration") || params.has("start_date") || params.has("end_date")) {
      String estDur = params.get("estimated_duration").asText();
      Duration dur = proxyObjFac.createDuration();
      DatatypeFactory df = DatatypeFactory.newInstance();
      dur.setValue(df.newDuration(estDur));
      msg.setEstimatedDuration(dur);
      DateRangeType drt = niemObjFac.createDateRangeType();
      String startDate = params.get("start_date").asText();
      drt.setStartDate(Ecfv5XmlHelper.convertDate(LocalDate.ofInstant(Instant.parse(startDate), ZoneId.systemDefault())));
      String endDate = params.get("start_date").asText();
      drt.setEndDate(Ecfv5XmlHelper.convertDate(LocalDate.ofInstant(Instant.parse(endDate), ZoneId.systemDefault())));
      msg.getPotentialStartTimeRange().add(drt);
    }

    Optional<CourtSchedulingMDE> maybeServ = setupSchedulingPort(httpHeaders);
    if (maybeServ.isEmpty()) {
      return Response.status(401).build();
    }
    Optional<CourtLocationInfo> locationInfo = cd.getFullLocationInfo(courtId); 
    if (locationInfo.isEmpty()) {
      return Response.status(404).entity("No court: " + courtId).build(); 
    }
    if (!locationInfo.get().allowhearing) {
      return Response.status(400).entity("Court " + courtId + " doesn't allow handling return dates").build();
    }
    ReserveCourtDateRequestType req = oasisWrapObjFac.createReserveCourtDateRequestType();
    req.setReserveCourtDateMessage(msg);
    ReserveDateResponseMessageType resp = maybeServ.get().reserveCourtDateSync(req).getReserveDateResponseMessage();
    log.info("Full resp: " + resp);
    if (hasError(resp)) {
      return Response.status(400).entity(resp.getMessageStatus()).build();
    }
    return Response.ok(resp).build();
  }
    
  private Optional<CourtSchedulingMDE> setupSchedulingPort(HttpHeaders httpHeaders) {
    String apiKey = httpHeaders.getHeaderString("X-API-KEY");
    Optional<AtRest> atRest = security.getAtRestInfo(apiKey);
    if (atRest.isEmpty()) {
      log.warn("Couldn't checkLogin");
      return Optional.empty();
    }
    TylerLogin login = new TylerLogin();
    String tylerToken = httpHeaders.getHeaderString(login.getHeaderKey());
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds?");
      return Optional.empty();
    }
    CourtSchedulingMDE serv = schedFactory.getCourtSchedulingMDEPort();
    ServiceHelpers.setupServicePort((BindingProvider) serv);
    Map<String, Object> ctx = ((BindingProvider) serv).getRequestContext();
    try {
      List<Header> headersList = List.of(creds.get().toHeader());
      ctx.put(Header.HEADER_LIST, headersList);
    } catch (JAXBException ex) {
      log.warn(ex.toString());
      return Optional.empty();
    }
    return Optional.of(serv);
  }
  
  private static void setupReq(CaseFilingType cft, String courtId) {
    DateType currentDate = Ecfv5XmlHelper.convertDate(LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));
    cft.setDocumentPostDate(currentDate);
    cft.setCaseCourt(Ecfv5XmlHelper.convertCourtType(courtId));
    cft.setServiceInteractionProfileCode(Ecfv5XmlHelper.convertNormalized(ServiceHelpers.MDE_PROFILE_CODE));
    cft.setSendingMDELocationID(Ecfv5XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
  }
  
  private static boolean hasError(ResponseMessageType rt) {
    MessageStatusType ms = rt.getMessageStatus();
    String errorCodeText = ms.getMessageHandlingError().getErrorCodeText().getValue();
    return !ms.getMessageContentError().isEmpty() && !(errorCodeText.isBlank() || errorCodeText.equals("0"));
  }
}
