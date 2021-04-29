package edu.suffolk.assemblyline.efspserver;

import gov.niem.niem.domains.jxdm._4.CourtType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.ObjectFactory;
import gov.niem.niem.niem_core._2.PersonType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

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
   * @throws IOException
   */
  public InputStream getHtml(String urlToRead, String authHeader) throws IOException {
    URL url = new URL(urlToRead);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.setRequestMethod("GET");
    conn.setRequestProperty("tyl-efm-api", authHeader);
    return conn.getInputStream();
  }

  private Duration downloads = Duration.ZERO;
  private Duration updates = Duration.ZERO;

  private boolean downloadAndReadZip(String url, String signedTime, String tableName, String location,
      CodeDatabase cd, Connection conn) throws IOException, JAXBException, SQLException {
    Instant startTable = Instant.now(Clock.systemUTC());
    try (InputStream urlStream = getHtml(url, signedTime)) {
      // Write out the zip file
      String zipName = tableName + "_" + location + ".zip";
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
      // Delete the zip file after processing: no need to have it hanging around.
      File f = new File(zipName);
      f.delete();
      return true;
    } catch (IOException ex) {
      // Some system codes (everything but "country", "state", "filingstatus", "datafield",
      // and "servicetype") are expected to 500. Not really sure why they give us bad URLs.
      System.err.println("Skipping " + url
          + ", got exception downloading zip: " + ex.toString());
      return false;
    }
  }

  public void downloadAll(String baseUrl, FilingReviewMDEPort filingPort) throws Exception {
    Map<String, String> codeUrls = Map.of(
        "version",  "/CodeService/codes/version/",
        "location", "/CodeService/codes/location/",
        // NOTE: the Tyler docs say this is available from `GetPolicy'. That is wrong.
        "error",    "/CodeService/codes/error"
        );
    // TODO(brycew): can tell if court codes will differ if they have a Row in Version codes
    // where the simple value differs from the "0" Row. Need to check both
    
    HeaderSigner signer = new HeaderSigner();
    CodeDatabase cd = new CodeDatabase();

    Connection conn = cd.createDbConnection();
    String signedTime = signer.signedCurrentTime();
    for (Map.Entry<String, String> urlSuffix : codeUrls.entrySet()) {
      downloadAndReadZip(baseUrl + urlSuffix.getValue(), signedTime,
          urlSuffix.getKey(), "", cd, conn);
    }

    downloads = Duration.ZERO;
    updates = Duration.ZERO;
    List<String> locs = cd.getAllLocations();
    for (String location : locs) {
      System.err.println("Location: " + location);
      //final Instant startLoc = Instant.now(Clock.systemUTC());
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
      JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class, gov.niem.niem.structures._2.ObjectFactory.class,
          oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory.class,
          oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory.class);
      Marshaller mar = jc.createMarshaller();
      mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      QName qname = new QName("tyler.test.bbb", "bbb");
      JAXBElement<CourtPolicyResponseMessageType> pp =
          new JAXBElement<CourtPolicyResponseMessageType>(qname, CourtPolicyResponseMessageType.class, p);
      mar.marshal(pp, new File("full_court_obj_" + location + ".xml"));

      // TODO(brycew): use the version codes to check the checksums of each table, 
      // then see if we need to update
      for (CourtCodelistType ccl : p.getRuntimePolicyParameters().getCourtCodelist()) {
        JAXBElement<?> obj = ccl.getEffectiveDate().getDateRepresentation();
        // TODO(brycew): check that the effective date is later than today
        String ecfElem = ccl.getECFElementName().getValue();
        if (ncToTableName.containsKey(ecfElem)) {
          String tableName = ncToTableName.get(ecfElem);
          // Tyler will give us URLs with spaces in them, which aren't valid. This makes them valid
          String url =
              ccl.getCourtCodelistURI().getIdentificationID().getValue().replace(" ", "%20");
          downloadAndReadZip(url, signer.signedCurrentTime(), tableName, location, cd, conn);
        } else {
          System.err.println(ecfElem + " not in the nc map!");
        }
      }
      System.err.println("Downloads took: " + downloads + ", and updates took: " + updates);
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
