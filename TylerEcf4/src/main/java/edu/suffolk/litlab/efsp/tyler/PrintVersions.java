package edu.suffolk.litlab.efsp.tyler;

import ecf4.latest.gov.niem.niem.domains.jxdm._4.CourtType;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import edu.suffolk.litlab.efsp.Jurisdiction;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.ws.BindingProvider;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.w3c.dom.Element;

public class PrintVersions extends AbstractSoapInterceptor implements CallbackHandler {

  public PrintVersions() {
    super("unmarshal");
  }

  @Override
  public void handleMessage(org.apache.cxf.binding.soap.SoapMessage message)
      throws org.apache.cxf.interceptor.Fault {
    var h =
        message.getHeader(
            new javax.xml.namespace.QName("urn:tyler:efm:services", "EFMConfigurationHeader"));
    System.out.print("Version: " + ((Element) h.getObject()).getFirstChild().getTextContent());
  }

  /** Handles setting the password for Webservices accessing the x509 certificates. */
  public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
    for (int i = 0; i < callbacks.length; i++) {
      if (callbacks[i] instanceof WSPasswordCallback) {
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        pc.setPassword(System.getenv("X509_PASSWORD"));
      } else {
        throw new UnsupportedCallbackException(callbacks[i], "Unrecognized Callback");
      }
    }
  }

  public static void setupServicePort(BindingProvider bp) {
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put("security.username", "bwilley@suffolk.edu");
    ctx.put("security.password", "can-be-anything?");
    ctx.put("security.signature.properties", "client_sign.properties");
    ctx.put("security.callback-handler", PrintVersions.class.getName());
    ctx.put("security.signature.username", "1");
  }

  public static void main(String args[]) {
    for (Jurisdiction j : Jurisdiction.values()) {
      System.out.println(j);

      try {
        var review =
            SoapClientChooser.getFilingReviewFactory(new TylerDomain(j, TylerEnv.STAGE))
                .get()
                .getFilingReviewMDEPort();
        setupServicePort((BindingProvider) review);
        Client client = ClientProxy.getClient(review);
        var test = new PrintVersions();
        client.getInInterceptors().add(test);
        var query = new CourtPolicyQueryMessageType();
        var court = new CourtType();
        var niemCoreObjFac = new ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory();
        var jxObjFac = new ecf4.latest.gov.niem.niem.domains.jxdm._4.ObjectFactory();
        var adamsId = niemCoreObjFac.createIdentificationType();
        var adamsStr = new ecf4.latest.gov.niem.niem.proxy.xsd._2.String();
        adamsStr.setValue("adams");
        adamsId.setIdentificationID(adamsStr);
        var idType = niemCoreObjFac.createOrganizationIdentification(adamsId);
        court.setOrganizationIdentification(idType);
        var text = new TextType();
        text.setValue("adams");
        court.setCourtName(text);
        query.setCaseCourt(court);
        var id = new IdentificationType();
        EntityType typ = new EntityType();
        var commonObjFac = new ObjectFactory();
        JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
        typ.setEntityRepresentation(elem2);
        query.setQuerySubmitter(typ);
        var string = new ecf4.latest.gov.niem.niem.proxy.xsd._2.String();
        string.setValue("http://localhost");
        id.setIdentificationID(string);
        query.setSendingMDELocationID(id);
        query.setSendingMDEProfileCode(
            "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:WebServicesMessaging-2.0");
        review.getPolicy(query);
      } catch (Exception ex) {
        // continue;
      }
    }
  }
}
