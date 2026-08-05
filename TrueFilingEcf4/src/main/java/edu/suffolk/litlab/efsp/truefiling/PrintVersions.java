package edu.suffolk.litlab.efsp.truefiling;

import edu.suffolk.litlab.efsp.Jurisdiction;
import gov.niem.niem.domains.jxdm._4.CourtType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import org.apache.cxf.ext.logging.LoggingFeature;

public class PrintVersions {

  public static void main(String args[]) {
    LoggingFeature loggingFeature = new LoggingFeature();
    loggingFeature.setPrettyLogging(true);
    // TODO(brycew): add easy checks to look for client-sign.properties, Suffolk.pfx, and
    // X509_PASSWORD in env.
    System.out.println("Getting versions for all truefile servers");
    try {
      var review =
          SoapClientChooser.getFilingReviewFactory(Jurisdiction.ALASKA).getFilingReviewMDEPort();
      SoapClientChooser.setupServicePort((BindingProvider) review);
      // ClientProxy.getClient(review).getInInterceptors().add(test);

      var query = new CourtPolicyQueryMessageType();
      var court = new CourtType();
      var niemCoreObjFac = new gov.niem.niem.niem_core._2.ObjectFactory();
      var adamsId = niemCoreObjFac.createIdentificationType();
      var adamsStr = new gov.niem.niem.proxy.xsd._2.String();
      adamsStr.setValue("55da5b11-2bc4-4881-abd1-b0dfdb506bb1");
      adamsId.setIdentificationID(adamsStr);
      court.setOrganizationIdentification(adamsId);
      var text = new TextType();
      text.setValue("55da5b11-2bc4-4881-abd1-b0dfdb506bb1");
      court.setCourtName(text);
      query.setCaseCourt(court);
      var id = new IdentificationType();
      EntityType typ = new EntityType();
      var commonObjFac = new ObjectFactory();
      JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
      typ.setEntityRepresentation(elem2);
      query.setQuerySubmitter(typ);
      var string = new gov.niem.niem.proxy.xsd._2.String();
      string.setValue("http://localhost");
      id.setIdentificationID(string);
      query.setSendingMDELocationID(id);
      query.setSendingMDEProfileCode(
          "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:WebServicesMessaging-2.0");
      review.getPolicy(query);
    } catch (Exception ex) {
      System.err.println("Error making call: " + ex.getLocalizedMessage() + ", " + ex.toString());
      // continue
    }
  }
}
