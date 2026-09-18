package edu.suffolk.litlab.efsp.server.services.impl;

import ecf4.latest.gov.niem.niem.niem_core._2.CaseType;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseListQueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseParticipantType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistresponsemessage_4.CaseListResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caseresponsemessage_4.CaseResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationquerymessage_4.ServiceInformationQueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationresponsemessage_4.ServiceInformationResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.CourtRecordMDEPort;
import ecf4.latest.tyler.ecf.extensions.common.CaseAugmentationType;
import ecf4.latest.tyler.ecf.extensions.serviceattachcaselistquerymessage.ServiceAttachCaseListQueryMessageType;
import ecf4.latest.tyler.ecf.extensions.serviceattachcaselistresponsemessage.ServiceAttachCaseListResponseMessageType;
import ecf4.latest.tyler.ecf.extensions.serviceinformationhistoryquerymessage.ServiceInformationHistoryQueryMessageType;
import ecf4.latest.tyler.ecf.extensions.serviceinformationhistoryresponsemessage.ServiceInformationHistoryResponseMessageType;
import ecf4.latest.tyler.efm.wsdl.webservicesprofile_implementation_4_0.CourtRecordMDEService;
import edu.suffolk.litlab.efsp.Jurisdiction;
import edu.suffolk.litlab.efsp.model.Name;
import edu.suffolk.litlab.efsp.server.auth.UserCreds;
import edu.suffolk.litlab.efsp.server.services.api.CaseSearchAPI;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers.FileableCourtType;
import edu.suffolk.litlab.efsp.server.utils.TylerEcf4Helper;
import edu.suffolk.litlab.efsp.tyler.Ecf4Helper;
import edu.suffolk.litlab.efsp.tyler.SoapClientChooser;
import edu.suffolk.litlab.efsp.tyler.ecf4.EcfCaseTypeFactory;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CodeDatabase;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.CourtLocationInfo;
import edu.suffolk.litlab.efsp.tyler.ecfcodes.DataFieldRow;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TylerCaseSearch implements CaseSearchAPI {
  private static Logger log = LoggerFactory.getLogger(TylerCaseSearch.class);
  private final CourtRecordMDEService recordFactory;
  private final ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4
          .ObjectFactory
      listObjFac =
          new ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4
              .ObjectFactory();
  private final ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4
          .ObjectFactory
      ecfOf =
          new ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4
              .ObjectFactory();
  private final Supplier<CodeDatabase> cdSupplier;

  public TylerCaseSearch(Jurisdiction jurisdiction, Supplier<CodeDatabase> cdSupplier) {

    Optional<CourtRecordMDEService> maybeRecords =
        SoapClientChooser.getCourtRecordFactory(jurisdiction);
    if (maybeRecords.isEmpty()) {
      throw new RuntimeException("Can't find " + jurisdiction + " for court record factory");
    }
    this.recordFactory = maybeRecords.get();
    this.cdSupplier = cdSupplier;
  }

  public Response getCourts() {
    try (CodeDatabase cd = cdSupplier.get()) {
      return ServiceHelpers.getCourts(cd, FileableCourtType.NONE, false).build();
    } catch (SQLException ex) {
      return Response.status(500).entity("database error retrieving all courts!").build();
    }
  }

  private Response runQuery(
      Consumer<CaseListQueryMessageType> setupQuery,
      String courtId,
      UserCreds creds,
      ReturnType rt) {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(creds);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }
    try (CodeDatabase cd = cdSupplier.get()) {
      Optional<CourtLocationInfo> info = cd.getFullLocationInfo(courtId);
      if (info.isEmpty()) {
        return Response.status(404).entity(courtId + " not in available courts to search").build();
      }

      // NOTE(brycew): Tyler's docs for "LegacyLocationCaseSearch" says:
      // "Provides requirements regarding restricting search location to only those locations which
      // allow initial filings. When IsVisible=True, only locations which allow initial filings
      // will be allowed." Unfortunately, this doesnt make any sense, and we can still search at
      // locations where LegacyLocation is true and initial is False. So turning this off for now.
      // DataFieldRow legacyRow = cd.getDataField(courtId, "LegacyLocationCaseSearch");

      // if (legacyRow.isvisible && !info.get().initial) {
      //  return Response.status(400)
      //      .entity(courtId + " doesn't allow for subsequent case searches")
      //      .build();
      // }

      if (courtId.equals("1")) {
        DataFieldRow row = cd.getDataField("1", "AdvancedSearchLocationAllLocations");
        if (!row.isvisible) {
          return Response.status(400).entity("Can't search all locations").build();
        }
      }

      CaseListQueryMessageType query = new CaseListQueryMessageType();
      EntityType typ = new EntityType();
      JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
      typ.setEntityRepresentation(elem2);
      query.setQuerySubmitter(typ);
      query.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
      query.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
      query.setSendingMDEProfileCode(Ecf4Helper.MDE_PROFILE_CODE);
      setupQuery.accept(query);
      CaseListResponseMessageType resp = maybePort.get().getCaseList(query);
      int statusCode = hasError(resp);
      if (statusCode >= 400) {
        // TODO: convert the errors into JSON?
        return Response.status(statusCode).entity(resp.getError()).build();
      }
      return Response.status(statusCode).entity(resp.getCase()).build();
    } catch (SQLException e) {
      log.error("can't get connection: ", e);
      return Response.status(500).build();
    }
  }

  @Override
  public Response queryCases(String courtId, String docketId, UserCreds creds, ReturnType rt) {
    Consumer<CaseListQueryMessageType> setupQuery =
        (query) -> {
          CaseType ct = new CaseType();
          ct.setCaseDocketID(Ecf4Helper.convertString(docketId));
          query.getCaseListQueryCase().add(ct);
        };
    return runQuery(setupQuery, courtId, creds, rt);
  }

  @Override
  public Response queryCases(
      String courtId, Name name, boolean isOrg, UserCreds creds, ReturnType rt) {
    Consumer<CaseListQueryMessageType> setupQuery =
        (query) -> {
          if (isOrg) {
            OrganizationType ot = ecfOf.createOrganizationType();
            ot.setOrganizationName(Ecf4Helper.convertText(name.getFirstName()));
            var commonCpt = ecfOf.createCaseParticipantType();
            commonCpt.setEntityRepresentation(ecfOf.createEntityOrganization(ot));
            commonCpt.setCaseParticipantRoleCode(Ecf4Helper.convertText(""));
            CaseParticipantType cpt = listObjFac.createCaseParticipantType();
            cpt.setCaseParticipant(ecfOf.createCaseParticipant(commonCpt));
            query.getCaseListQueryCaseParticipant().add(cpt);
          } else {
            PersonType pt = ecfOf.createPersonType();
            pt.setPersonName(name.getNameType());

            var commonCpt = ecfOf.createCaseParticipantType();
            commonCpt.setEntityRepresentation(ecfOf.createEntityPerson(pt));
            commonCpt.setCaseParticipantRoleCode(Ecf4Helper.convertText(""));

            CaseParticipantType cpt = listObjFac.createCaseParticipantType();
            cpt.setCaseParticipant(ecfOf.createCaseParticipant(commonCpt));
            query.getCaseListQueryCaseParticipant().add(cpt);
          }
        };
    return runQuery(setupQuery, courtId, creds, rt);
  }

  public Response getCase(String courtId, String caseId, UserCreds creds, ReturnType rt) {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(creds);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }

    try (CodeDatabase cd = cdSupplier.get()) {
      Optional<CourtLocationInfo> locationInfo = cd.getFullLocationInfo(courtId);
      if (locationInfo.isEmpty()) {
        log.warn("Can't find court location for {} when getting case", courtId);
        return Response.status(404).entity("No court " + courtId).build();
      }
      CaseQueryMessageType query = new CaseQueryMessageType();
      EntityType typ = new EntityType();
      JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
      typ.setEntityRepresentation(elem2);
      query.setQuerySubmitter(typ);
      query.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
      query.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
      query.setSendingMDEProfileCode(Ecf4Helper.MDE_PROFILE_CODE);
      query.setCaseTrackingID(Ecf4Helper.convertString(caseId));
      query.setCaseQueryCriteria(EcfCaseTypeFactory.getCriteria());
      CaseResponseMessageType resp = maybePort.get().getCase(query);
      int statusCode = hasError(resp);
      if (statusCode >= 400) {
        return Response.status(statusCode).entity(resp.getError()).build();
      }

      if (locationInfo.get().hasprotectedcasetypes) {
        CaseType caseType = resp.getCase().getValue();
        Optional<CaseAugmentationType> caseAug = EcfCaseTypeFactory.getCaseAugmentation(caseType);
        caseAug.ifPresent(
            aug -> {
              if (locationInfo
                  .get()
                  .protectedcasetypes
                  .contains(aug.getCaseTypeText().getValue())) {
                TextType protectedText =
                    Ecf4Helper.convertText(locationInfo.get().protectedcasereplacementstring);
                aug.setCaseTypeText(protectedText);
                caseType.setCaseCategoryText(protectedText);
              }
            });
      }
      return Response.status(statusCode).entity(resp.getCase()).build();
    } catch (SQLException e) {
      log.error("can't get connection: ", e);
      return Response.status(500).build();
    }
  }

  public Response getServiceInformation(
      String courtId, String caseId, UserCreds creds, ReturnType rt) {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(creds);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }

    ServiceInformationQueryMessageType query = new ServiceInformationQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
    query.setCaseTrackingID(Ecf4Helper.convertString(caseId));
    query.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(Ecf4Helper.MDE_PROFILE_CODE);
    ServiceInformationResponseMessageType resp = maybePort.get().getServiceInformation(query);
    int statusCode = hasError(resp);
    if (statusCode >= 400) {
      return Response.status(statusCode).entity(resp.getError()).build();
    }
    return Response.ok(resp.getServiceRecipient()).build();
  }

  public Response getServiceInformationHistory(
      String courtId, String caseId, UserCreds creds, ReturnType rt) {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(creds);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }
    ServiceInformationHistoryQueryMessageType query =
        new ServiceInformationHistoryQueryMessageType();
    EntityType typ = new EntityType();
    JAXBElement<PersonType> elem2 = ecfOf.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    query.setQuerySubmitter(typ);
    query.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
    query.setCaseTrackingID(Ecf4Helper.convertString(caseId));
    query.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(Ecf4Helper.MDE_PROFILE_CODE);
    ServiceInformationHistoryResponseMessageType resp =
        maybePort.get().getServiceInformationHistory(query);
    int statusCode = hasError(resp);
    if (statusCode >= 400) {
      return Response.status(statusCode).entity(resp.getError()).build();
    }
    return Response.ok(resp.getServiceRecipient()).build();
  }

  public Response queryServiceAttachCases(
      String courtId, String serviceId, UserCreds creds, ReturnType rt) {
    Optional<CourtRecordMDEPort> maybePort = setupRecordPort(creds);
    if (maybePort.isEmpty()) {
      return Response.status(401).build();
    }

    ServiceAttachCaseListQueryMessageType query = new ServiceAttachCaseListQueryMessageType();
    EntityType typ = new EntityType();
    typ.setEntityRepresentation(ecfOf.createEntityPerson(new PersonType()));
    query.setQuerySubmitter(typ);
    query.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
    query.setServiceContactIdentification(Ecf4Helper.convertId(serviceId));
    query.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
    query.setSendingMDEProfileCode(Ecf4Helper.MDE_PROFILE_CODE);
    ServiceAttachCaseListResponseMessageType resp = maybePort.get().getServiceAttachCaseList(query);
    int statusCode = hasError(resp);
    if (statusCode >= 400) {
      return Response.status(statusCode).entity(resp.getError()).build();
    }
    return Response.ok(resp.getCase()).build();
  }

  private static int hasError(QueryResponseMessageType resp) {
    boolean hasError =
        resp.getError().size() > 1
            || (resp.getError().size() == 1
                && !resp.getError().get(0).getErrorCode().getValue().equals("0"));
    if (hasError) {
      // If the response has issues connecting with the CMS, we are still supposed to allow
      // for case search / e-filing. So, we'll return an error with the error code, but also any
      // cases that were still present.
      // -15: CMS timed out, -11: CMS is unavailable, -10: some info in case might be missing
      Set<String> cmsConnectionErrors = Set.of("-11", "-15", "-10");
      if (resp.getError().stream()
          .anyMatch(err -> cmsConnectionErrors.contains(err.getErrorCode().getValue()))) {
        return 203;
      } else {
        return 400;
      }
    }
    return 200;
  }

  private Optional<CourtRecordMDEPort> setupRecordPort(UserCreds userCreds) {
    if (userCreds.toHeaders().isEmpty()) {
      log.warn("No creds?");
      return Optional.empty();
    }

    CourtRecordMDEPort port = recordFactory.getCourtRecordMDEPort();

    // Sometimes, getCases takes an incredibly long time. Bump timeout to 3 minutes
    ServiceHelpers.changeTimeout((BindingProvider) port, 180_000);
    TylerEcf4Helper.setupServicePort((BindingProvider) port, userCreds);
    return Optional.of(port);
  }
}
