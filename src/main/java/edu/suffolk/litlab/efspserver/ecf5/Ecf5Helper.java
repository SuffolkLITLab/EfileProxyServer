package edu.suffolk.litlab.efspserver.ecf5;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.suffolk.litlab.efspserver.SoapX509CallbackHandler;
import edu.suffolk.litlab.efspserver.tyler.TylerUserNamePassword;

import javax.xml.datatype.DatatypeFactory;

import gov.niem.release.niem.domains.jxdm._6.CourtType;
import gov.niem.release.niem.niem_core._4.DateType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDEService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.ws.BindingProvider;

public class Ecf5Helper {
  private static Logger log = LoggerFactory.getLogger(Ecf5Helper.class);

  private static final gov.niem.release.niem.proxy.xsd._4.ObjectFactory niemProxyObjFac;
  private static final gov.niem.release.niem.niem_core._4.ObjectFactory niemCoreObjFac;
  private static final gov.niem.release.niem.domains.jxdm._6.ObjectFactory jxObjFac;
  private static final DatatypeFactory datatypeFac;

  static {
    niemProxyObjFac = new gov.niem.release.niem.proxy.xsd._4.ObjectFactory();
    niemCoreObjFac = new gov.niem.release.niem.niem_core._4.ObjectFactory();
    jxObjFac = new gov.niem.release.niem.domains.jxdm._6.ObjectFactory();
    try {
      datatypeFac = DatatypeFactory.newInstance();
    } catch (DatatypeConfigurationException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public static DateType convertDate(LocalDate date) {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), 0, 0, 0);
    gov.niem.release.niem.proxy.xsd._4.Date d = niemProxyObjFac.createDate();
    XMLGregorianCalendar x = datatypeFac.newXMLGregorianCalendar(cal);
    x.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
    d.setValue(x);
    DateType dt = niemCoreObjFac.createDateType();
    dt.setDateRepresentation(niemCoreObjFac.createDate(d));
    return dt;
  }

  public static DateType convertNow() {
    return convertDate(LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault()));
  }

  public static gov.niem.release.niem.proxy.xsd._4.String convertString(String str) {
    gov.niem.release.niem.proxy.xsd._4.String outStr = niemProxyObjFac.createString();
    outStr.setValue(str);
    return outStr;
  }

  public static gov.niem.release.niem.niem_core._4.TextType convertText(String text) {
    gov.niem.release.niem.niem_core._4.TextType textType = niemCoreObjFac.createTextType();
    textType.setValue(text);
    return textType;
  }

  public static gov.niem.release.niem.niem_core._4.PersonNameTextType convertPersonText(String name) {
    gov.niem.release.niem.niem_core._4.PersonNameTextType nameTextType = niemCoreObjFac.createPersonNameTextType();
    nameTextType.setValue(name);
    return nameTextType;
  }

  public static gov.niem.release.niem.proxy.xsd._4.NormalizedString convertNormalizedString(String str) {
    gov.niem.release.niem.proxy.xsd._4.NormalizedString outStr = niemProxyObjFac.createNormalizedString();
    outStr.setValue(str);
    return outStr;
  }

  public static gov.niem.release.niem.niem_core._4.IdentificationType convertId(String idStr) {
    var id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    return id;
  }

  public static gov.niem.release.niem.niem_core._4.IdentificationType convertId(String idStr, String source, String categoryDesc) {
    var id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    id.setIdentificationSourceText(convertText(source));
    id.setIdentificationCategoryDescriptionText(convertText(categoryDesc));
    return id;
  }

  public static CourtType convertCourt(String courtId) {
    CourtType court = jxObjFac.createCourtType();
    court.setOrganizationIdentification(convertId(courtId));
    return court;
  }

  public static Optional<CourtPolicyMDE> setupPolicyPort(CourtPolicyMDEService policyServFactory, String tylerToken) {
    Optional<TylerUserNamePassword> creds = TylerUserNamePassword.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds from " + tylerToken + "?");
      return Optional.empty();
    }
    CourtPolicyMDE mde = policyServFactory.getCourtPolicyMDE();
    Map<String, Object> ctx = ((BindingProvider) mde).getRequestContext();
    List<Header> headerList = List.of(creds.get().toHeader());
    ctx.put(Header.HEADER_LIST, headerList);
    setupServicePort((BindingProvider) mde);
    return Optional.of(mde);
  }

  /*
  public static <T extends QueryMessageType> T prep(T newMsg, String courtId) {
    EntityType typ = new EntityType();
    var commonObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    newMsg.setQuerySubmitter(typ);
    newMsg.setCaseCourt(XmlHelper.convertCourtType(courtId));
    newMsg.setSendingMDELocationID(XmlHelper.convertId(ServiceHelpers.SERVICE_URL));
    newMsg.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    return newMsg;
  }
  */

  /**
   * Converts any XML annotated object (from CXF) to a string. Useful for debugging. Doesn't throw,
   * but does return the string of the exception instead.
   *
   * @param  <T> the type of object being passed in
   * @param toXml The object to do things with
   * @return the XML string to do what you want with
   */
  public static <T> String objectToXmlStrOrError(T toXml, Class<T> toXmlClazz) {
    try {
      return objectToXmlStr(toXml, toXmlClazz);
    } catch (JAXBException | NullPointerException ex) {
      return ex.toString() + "(original obj was : " + toXml.toString() + ")";
    }
  }

  /**
   * Converts any XML annotated object (from CXF) to a string. Useful for testing. Will throw an
   * exception if there's a JAXB error.
   *
   * @param  <T> the type of object being passed in
   * @param toXml The object to do things with
   * @return the XML string to do what you want with
   */
  public static <T> String objectToXmlStr(T toXml, Class<T> toXmlClazz) throws JAXBException {
    JAXBContext jaxContext =
        JAXBContext.newInstance(
            toXmlClazz,
            gov.niem.release.niem.niem_core._4.ObjectFactory.class,
            gov.niem.release.niem.structures._4.ObjectFactory.class,
            https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ObjectFactory.class);
    Marshaller mar = jaxContext.createMarshaller();
    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    QName qname = new QName("suffolk.test.objectToXml", "objectToXml");
    JAXBElement<T> wrappedRoot = new JAXBElement<T>(qname, toXmlClazz, toXml);
    StringWriter sw = new StringWriter();
    mar.marshal(wrappedRoot, sw);
    return sw.toString();
  }


  /**
   * Sets up a connection to Tyler's SOAP API WITHOUT any Auth headers, but does handle the X.509
   * certificate and signing parameters.
   *
   * <p>Can be used to make an Auth request, or can have the header inserted later.
   */
  public static void setupServicePort(BindingProvider bp) {
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put("security.username", "bwilley@suffolk.edu");
    ctx.put("security.password", "can-be-anything?");
    ctx.put("security.signature.properties", "client_sign.properties");
    ctx.put("security.callback-handler", SoapX509CallbackHandler.class.getName());
    ctx.put("security.signature.username", "1");
  }
}
