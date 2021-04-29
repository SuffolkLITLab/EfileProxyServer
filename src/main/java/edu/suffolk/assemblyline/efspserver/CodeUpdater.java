package edu.suffolk.assemblyline.efspserver;

import gov.niem.niem.domains.jxdm._4.CourtType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.ObjectFactory;
import gov.niem.niem.niem_core._2.PersonType;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.xml.bind.JAXBElement;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtCodelistType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import org.apache.cxf.headers.Header;
import tyler.efm.services.EfmFirmService;
import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;

public class CodeUpdater {
  
  public static final Map<String, String> ncToTableName = new HashMap<String, String>();

  static {
    //TODO(brycew): there's little more info on these mappings and how they combine besides: 
    //   The name of an ECF element to be substituted by a court-specific codelist or extension
    // Is this actually an XPath? Should figure it out
    ncToTableName.put("nc:CaseCategoryText", "casecategory");
    ncToTableName.put("tyler:CaseTypeText", "casetype");
    ncToTableName.put("nc:LocationCountryName", "country");
    ncToTableName.put("tyler:DamageAmountCode", "damageamount");
    ncToTableName.put("tyler:DisclaimerRequirementCode", "disclaimerrequirement");
    ncToTableName.put("nc:BinaryFormatStandardName", "documenttype");
    ncToTableName.put("tyler:FilerTypeText", "filertype");
    ncToTableName.put("j:RegisterActionDescriptionText", "filing");
    ncToTableName.put("nc:BinaryCategoryText", "filingcomponent");
    ncToTableName.put("tyler:DocumentOptionalService", "optionalservice");
    ncToTableName.put("ecf:CaseParticipantRoleCode", "partytype");
    ncToTableName.put("tyler:RemedyCode", "procedureremedy");
    ncToTableName.put("nc:LocationStateName", "state");
    ncToTableName.put("ecf:FilingStatusCode", "filingstatus");
    ncToTableName.put("nc:PersonNameSuffixText", "namesuffix");
    ncToTableName.put("tyler:DataFieldConfigCode", "datafield");
    ncToTableName.put("ecf:ServiceRecipientID/nc:IdentificationSourceText", "servicetype");
    ncToTableName.put("nc:BinaryLocationURI", "filetype");
    ncToTableName.put("j:/ArrestCharge/j:ArrestLocation/nc:LocationName", "arrestlocation");
    ncToTableName.put("cext:BondTypeText", "bond");
    ncToTableName.put("cext:Charge/cext:ChargeStatute/j:StatuteLevelText", "degree");
    ncToTableName.put("j:ArrestOfficial/j:EnforcementOfficialUnit/nc:OrganizationIdentification/nc:IdentificationID",
        "lawenforcementunit"); 
    ncToTableName.put("nc:DocumentIdentification/nc:IdentificationSourceText", "crossreference");
    ncToTableName.put("cext:GeneralOffenseText", "generaloffense");
    ncToTableName.put("cext:StatuteTypeText", "statutetype");
    ncToTableName.put("ecf:PersonDriverLicense/nc:DriverLicenseIdentification/nc:IdentificationCategoryText",
        "driverlicensetype");
    ncToTableName.put("cext:Charge/cext:ChargeStatute/j:StatuteCodeIdentification/nc:IdentificationID",
        "statute"); 
    ncToTableName.put("nc:PrimaryLanguage\\nc:LanguageCode", "language");
    ncToTableName.put("nc:PersonPhysicalFeature\\nc:PhysicalFeatureCategoryCode", 
        "physicalfeature");
    ncToTableName.put("nc:PersonHairColorCode", "haircolor");
    ncToTableName.put("nc:PersonEyeColorCode", "eyecolor");
    ncToTableName.put("nc:PersonEthnicityText", "ethnicity");
    ncToTableName.put("nc:PersonRaceText", "race");
    ncToTableName.put("tyler:CaseSubTypeText", "casesubtype");
    ncToTableName.put("cext:Charge\\cext:ChargePhaseText", "chargephase");
    ncToTableName.put("tyler:VehicleTypeCode", "vehicletype");
    ncToTableName.put("nc:VehicleMakeCode", "vehiclemake");
    ncToTableName.put("nc:VehicleColorPrimaryCode", "vehiclecolor");
    ncToTableName.put("tyler:MotionTypeCode", "motiontype");
    ncToTableName.put("j:Citation\\nc:ActivityIdentification\\tyler:JurisdictionCode", 
        "citationjurisdiction");
    ncToTableName.put("tyler:QuestionCode", "question");
    ncToTableName.put("tyler:AnswerCode", "answer");
  }
  
  /**
   * https://stackoverflow.com/a/1485730/11416267
   *
   * @return
   */
  public InputStream getHtml(String urlToRead, String authHeader) throws Exception {
    URL url = new URL(urlToRead);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("tyl-efm-api", authHeader);
    return conn.getInputStream();
  }

  public void downloadAll(String baseUrl, FilingReviewMDEPort filingPort) throws Exception {
    Map<String, String> codeUrls = Map.of(
        "version",  "/CodeService/codes/version/",
        "location", "/CodeService/codes/location/",
        // NOTE: the Tyler docs say this is available from `GetPolicy'. That is wrong.
        "error",    "/CodeService/codes/error"
        // NOTE: the below URLs seem to be available both with and without the court code
        // at the end. 
        // TODO(brycew): can tell if court codes will differ if they have a Row in Version codes
        // where the simple value differs from the "0" Row. Need to check both
        //"country", "/CodeService/codes/country/",
        //"state",   "/CodeService/codes/state/",
        //"filingstatus", "/CodeService/codes/filingstatus/", 
        //"datafield",    "/CodeService/codes/datafield/"
        );
    
    HeaderSigner signer = new HeaderSigner();
    CodeDatabase cd = new CodeDatabase();
    Connection conn = cd.createDbConnection();
    /*
    for (Map.Entry<String, String> urlSuffix : codeUrls.entrySet()) {
      InputStream urlStream = getHtml(baseUrl + urlSuffix.getValue(), signedTime); 
      // Write out the zip file
      String zipName = urlSuffix.getKey() + ".zip";
      FileOutputStream fileOut = new FileOutputStream(zipName);
      long length = urlStream.transferTo(fileOut);
      System.out.println(length + " bytes transfered for " + urlSuffix);
      ZipFile zip = new ZipFile(zipName);
      ZipEntry entry = zip.entries().nextElement();
      
      cd.updateTable(urlSuffix.getKey(), "", zip.getInputStream(entry), conn);
      zip.close();
    }
    */

    Duration downloads = Duration.ZERO;
    Duration updates = Duration.ZERO;
    List<String> locs = cd.getAllLocations();
    for (String location : locs) {
      System.err.println("Location: " + location);
      if (location.equals("0") || location.equals("1")) {
        // TODO(brycew): download just system codes / File & Serve somehow? https://Illinois-stage.tylerhost.net/codeservice/codes/casecategory/0/
        // 500's for some reason, and it's really annoying.
        System.err.println("Skipping location " + location);
        continue;
      }
      final Instant startLoc = Instant.now(Clock.systemUTC());
      CourtPolicyQueryMessageType m = new CourtPolicyQueryMessageType();
      IdentificationType courtId = EfspServer.makeIDType(location); 
      ObjectFactory of = new ObjectFactory();
      JAXBElement<IdentificationType> elem = of.createOrganizationIdentification(courtId);
      CourtType court = new CourtType();
      court.setOrganizationIdentification(elem);
      m.setCaseCourt(court);
      // TODO(brycew): change this stuff
      m.setSendingMDELocationID(EfspServer.makeIDType("https://filingassemblymde.com"));
      m.setSendingMDEProfileCode("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:WebServicesMessaging-2.0");
      JAXBElement<PersonType> elem2 = of.createEntityPerson(new PersonType());  
      EntityType typ = new EntityType();
      typ.setEntityRepresentation(elem2);
      m.setQuerySubmitter(typ);
      CourtPolicyResponseMessageType p = filingPort.getPolicy(m);
      Instant getPolicyLoc = Instant.now(Clock.systemUTC());
      downloads = downloads.plus(Duration.between(startLoc, getPolicyLoc));
      // TODO(brycew): use the version codes to check the checksums of each table, 
      // then see if we need to update
      for (CourtCodelistType ccl : p.getRuntimePolicyParameters().getCourtCodelist()) {
        JAXBElement<?> obj = ccl.getEffectiveDate().getDateRepresentation();
        // TODO(brycew): check that the effective date is later than today
        String ecfElem = ccl.getECFElementName().getValue();
        if (ncToTableName.containsKey(ecfElem)) {
          Instant startTable = Instant.now(Clock.systemUTC());
          String signedTime = signer.signedCurrentTime();
          InputStream urlStream = getHtml(
              ccl.getCourtCodelistURI().getIdentificationID().getValue(), signedTime);
          String tableName = ncToTableName.get(ecfElem);
          String zipName = location + "_" + tableName + ".zip";
          FileOutputStream fileOut = new FileOutputStream(zipName);
          long length = urlStream.transferTo(fileOut);
          System.out.println(length + " bytes transfered for " + zipName);
          downloads = downloads.plus(Duration.between(startTable, Instant.now(Clock.systemUTC())));
          ZipFile zip = new ZipFile(zipName);
          ZipEntry entry = zip.entries().nextElement();
          
          Instant updateTableLoc = Instant.now(Clock.systemUTC());
          cd.updateTable(tableName, location, zip.getInputStream(entry), conn);
          updates = updates.plus(Duration.between(updateTableLoc, Instant.now(Clock.systemUTC())));
          zip.close();
        } else {
          System.err.println(ecfElem + " not in the nc map!");
        }
      }
    }
    System.err.println("Downloads took: " + downloads + ", and updates took: " + updates);
  }

  public static void main(String[] args) throws Exception {
    final Instant startSetup = Instant.now(Clock.systemUTC());
    URL userWsdlUrl = EfmUserService.WSDL_LOCATION;
    IEfmUserService userPort = EfspServer.makeUserService(userWsdlUrl);
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail("bwilley@suffolk.edu");
    authReq.setPassword(System.getenv("BRYCE_USER_PASSWORD"));
    AuthenticateResponseType authRes = userPort.authenticateUser(authReq);
    System.out.println("Auth'd?: " + authRes.getError().getErrorText());
    List<Header> headersList = TylerUserNamePassword.makeHeaderList(authRes); 
    FilingReviewMDEPort filingPort = EfspServer.makeFilingService(
        FilingReviewMDEService.WSDL_LOCATION, headersList); 
    Instant finishSetup = Instant.now(Clock.systemUTC());
    System.err.println("Takes " + Duration.between(finishSetup, startSetup) + " to setup ports");
    CodeUpdater cd = new CodeUpdater();
    cd.downloadAll("https://illinois-stage.tylerhost.net", filingPort);
  }
}
