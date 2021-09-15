package edu.suffolk.litlab.efspserver.services;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hubspot.algebra.Result;

import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ReturnDateRequestType;
import ecfv5.tyler.ecf.v5_0.extensions.returndate.ReturnDateMessageType;
import edu.suffolk.litlab.efspserver.FilingInformation;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.CaseAugmentationType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.CourtEventType;
import ecfv5.gov.niem.release.niem.niem_core._4.CaseType;
import ecfv5.gov.niem.release.niem.niem_core._4.DateType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CourtEventAugmentationType;

@Path("/scheduling/")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CourtSchedulingService {

  private ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ObjectFactory oasisWrapObjFac;
  private ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory oasisObjFac;
  private ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.ObjectFactory oasisCivilObjFac;
  private ecfv5.tyler.ecf.v5_0.extensions.common.ObjectFactory tylerObjFac;
  private ecfv5.gov.niem.release.niem.niem_core._4.ObjectFactory niemObjFac;
  private ecfv5.gov.niem.release.niem.domains.jxdm._6.ObjectFactory jxObjFac;
  private Map<String, InterviewToFilingEntityConverter> converterMap;

  
  public CourtSchedulingService(Map<String, InterviewToFilingEntityConverter> converterMap) {
    this.converterMap = converterMap;
    this.oasisWrapObjFac = new ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ObjectFactory();
    this.oasisObjFac = new ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory();
    this.oasisCivilObjFac = new ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.ObjectFactory();
    this.tylerObjFac = new ecfv5.tyler.ecf.v5_0.extensions.common.ObjectFactory();
    this.niemObjFac = new ecfv5.gov.niem.release.niem.niem_core._4.ObjectFactory();
    this.jxObjFac = new ecfv5.gov.niem.release.niem.domains.jxdm._6.ObjectFactory();
  }
  
  @POST
  @Path("/courts/{court_id}/return_date")
  public Response getReturnDate(@Context HttpHeaders httpHeaders, 
      @PathParam("court_id") String courtId, String allVars) {
    MediaType mediaType = httpHeaders.getMediaType();
    InfoCollector collector = new FailFastCollector();
    Result<FilingInformation, FilingError> res = converterMap.get(mediaType.toString()).traverseInterview(allVars, collector);
    if (res.isErr()) {
      return Response.status(400).entity(collector.jsonSummary()).build();
    }
    FilingInformation info = res.unwrapOrElseThrow();
    if (info.getFilings().isEmpty()) {
      return Response.status(400).entity("Need to have a filing to calculate a request date").build();
    }
    // TODO(brycew): figure out how to convert these vars from names to the codes
    Optional<String> caseTrackingId = Optional.empty();
    String filingCode = info.getFilings().get(0).getFilingComponentName();
    String motionTypeCode = info.getFilings().get(0).getMotionType().get();
    String caseCategoryCode = info.getCaseCategory().code.get();
    String caseTypeCode = info.getCaseType();
    String filingPartyId = info.getFilings().get(0).getFilingPartyIds().get(0);
    String filingAttorneyId = info.getFilings().get(0).getFilingAttorney().get();
    LocalDate returnDate = info.getFilings().get(0).getReturnDate().get();
    boolean outOfState = info.getMiscInfo().get("out_of_state").asBoolean();
    //CaseOfficial  Repeat this element as necessary to reflect attorneys relevant to this filing. The IdentificationID element must contain an EFM unique identifier for a firm attorney record. For an attorney representing a case participant, the CaseRepresentedParty element must reference a CaseParty structure.
    //CaseParty Repeat this element for each case party relevant to this filing. Include any new case parties as well as any existing party for which an attorney is being added. Use EntityPerson or EntityOrganization as appropriate. Set the ParticipantID\IdentificationID element to SRL if the party is a self-represented litigant
    //CaseParticipantRoleCode The PartyType code for the party
    //AmountInControversy Ad Damnum (damage amount) being sought
    //CrossReferenceNumber  IdentificationSourceText must contain a valid Cross Reference Code. IdentificationID should contain the cross reference number
    
    ReturnDateRequestType r = oasisWrapObjFac.createReturnDateRequestType();
    ReturnDateMessageType m = new ReturnDateMessageType();
    m.setCaseCourt(Ecfv5XmlHelper.convertCourtType(courtId));
    m.setServiceInteractionProfileCode(Ecfv5XmlHelper.convertNormalized(ServiceHelpers.MDE_PROFILE_CODE));
    m.setSendingMDELocationID(Ecfv5XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    DateType currentDate = Ecfv5XmlHelper.convertDate(LocalDate.from(Instant.now()));
    m.setDocumentPostDate(currentDate);
    CaseType ct = niemObjFac.createCaseType();
    caseTrackingId.ifPresent(id -> ct.setCaseTrackingID(Ecfv5XmlHelper.convertString(id)));

    CourtEventAugmentationType e = oasisObjFac.createCourtEventAugmentationType();
    e.setCourtEventEnteredOnDocketDate(currentDate);
    e.setCourtEventTypeCode(Ecfv5XmlHelper.convertText(filingCode));
    e.setCourtLocationCode(tylerObjFac.createMotionTypeCode(Ecfv5XmlHelper.convertText(motionTypeCode)));
    CourtEventType event = jxObjFac.createCourtEventType();
    event.getCourtEventAugmentationPoint().add(oasisObjFac.createCourtEventAugmentation(e));
    CaseAugmentationType jAug = jxObjFac.createCaseAugmentationType();
    jAug.getCaseCourtEvent().add(event);
    ct.getCaseAugmentationPoint().add(jxObjFac.createCaseAugmentation(jAug));

    ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseAugmentationType ecfAug = oasisObjFac.createCaseAugmentationType();
    // TODO(brycew): CONTINUE
    for (String attorneyId : info.getAttorneyIds()) {
      ecfAug.getRest().add(null);
    }
    ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.CaseAugmentationType oasisAug =
        oasisCivilObjFac.createCaseAugmentationType();
    oasisAug.setAmountInControversy(null);
    oasisAug.setJuryDemandIndicator(Ecfv5XmlHelper.convertBool(false));
    ct.getCaseAugmentationPoint().add(oasisCivilObjFac.createCaseAugmentation(oasisAug));

    ecfv5.tyler.ecf.v5_0.extensions.common.CaseAugmentationType tylerAug = tylerObjFac.createCaseAugmentationType();
    tylerAug.setFilingParty(null);
    tylerAug.setFilingAttorney(null);
    tylerAug.getCrossReferenceNumber().add(null);
    ct.getCaseAugmentationPoint().add(tylerObjFac.createCaseAugmentation(tylerAug));
    m.setCase(ct);
    r.setReturnDateMessage(m);
    return Response.status(500).build();
  }
  
  
}
