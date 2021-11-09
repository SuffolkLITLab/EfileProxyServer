package edu.suffolk.litlab.efspserver;

import gov.niem.niem.domains.jxdm._4.CourtType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.MeasureType;
import gov.niem.niem.niem_core._2.TextType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;

import java.io.File;
import java.io.StringWriter;
import java.time.LocalDate;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.namespace.QName;

/**
 * Helper class that easily converts Java native types to Cumbersome XML Schema types,
 * particularly those from Oasis's ECF standard, and the National Information
 * Exchange Model (NIEM).
 *
 * <p>Some information about NIEM:
 * Many of the types here all include the "SimpleObjectAttributeGroup", which,
 * "provides a collection of attributes which are appropriate for
 *    definition of object types", including an ID attribute, a Metadata attribute,
 * and a Link Metadata attribute that directly reference objects via IDs instead of
 * including the object as an element. TBH, I'm not sure what the design decisions
 * that dictate the use of them are, but they exist.</p>
 *
 * @author Bryce Willey
 *
 */
public class XmlHelper {

  static final gov.niem.niem.proxy.xsd._2.ObjectFactory niemProxyObjFac;
  static final gov.niem.niem.niem_core._2.ObjectFactory niemCoreObjFac;
  static final gov.niem.niem.domains.jxdm._4.ObjectFactory jxObjFac;

  static {
    niemProxyObjFac = new gov.niem.niem.proxy.xsd._2.ObjectFactory();
    niemCoreObjFac = new gov.niem.niem.niem_core._2.ObjectFactory();
    jxObjFac = new gov.niem.niem.domains.jxdm._4.ObjectFactory();
  }

  /** Creates a date from a java date. Doesn't have time associated with it. */
  public static DateType convertDate(LocalDate date) {
    DateType dt = niemCoreObjFac.createDateType();
    gov.niem.niem.proxy.xsd._2.Date d = niemProxyObjFac.createDate();
    DatatypeFactory datatypeFac;
    try {
      datatypeFac = DatatypeFactory.newInstance();
    } catch (DatatypeConfigurationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    // TODO(#47): THIS TIMEZONE IS WRONG: how should LocalDate +
    // GregorianCalendar operate?
    d.setValue(datatypeFac.newXMLGregorianCalendarDate(date.getYear(),
        date.getMonth().getValue(), date.getDayOfMonth(), 0));

    dt.setDateRepresentation(niemCoreObjFac.createDate(d));
    return dt;
  }

  /** Niem's Boolean type: either true or false. */
  public static gov.niem.niem.proxy.xsd._2.Boolean convertBool(boolean bool) {
    gov.niem.niem.proxy.xsd._2.Boolean val = new gov.niem.niem.proxy.xsd._2.Boolean();
    val.setValue(bool);
    return val;
  }


  /** Converts a Java string to NIEM "Text", a wrapper around the NIEM String.
   *
   * <p>"A data type for a character string"</p>
   */
  public static TextType convertText(String str) {
    TextType tt = niemCoreObjFac.createTextType();
    tt.setValue(str);
    return tt;
  }

  /** Converts a Java string to NIEM's XML String. "A datatype for character strings in XML."
   * Practically, just a xsd:string with the extra SimpleObjectAttributeGroup attributes.
   */
  public static gov.niem.niem.proxy.xsd._2.String convertString(String str) {
    gov.niem.niem.proxy.xsd._2.String outStr = niemProxyObjFac.createString();
    outStr.setValue(str);
    return outStr;
  }
  
  /** @param type will always be in bytes, but this is for backup. */
  public static long sizeMeasureAsBytes(MeasureType type) {
    String measureText = ((TextType) type.getMeasureValue().getValue()).getValue();
    long measureNum = Long.parseLong(measureText);
    String measureUnit = type.getMeasureUnitText().getValue();
    if (measureUnit.equalsIgnoreCase("byte")) {
      return measureNum;
    } else if (measureUnit.equalsIgnoreCase("kilobyte") || measureUnit.equals("kB")) {
      return measureNum * 1000;
    } else if (measureUnit.equals("KB") || measureUnit.equals("KiB")) {
      return measureNum * 1024;
    } else if (measureUnit.equals("MB")) {
      return measureNum * 1000 * 1000;
    } else {
      return measureNum;
    }
  }

  public static gov.niem.niem.niem_core._2.IdentificationType convertId(String idStr) {
    gov.niem.niem.niem_core._2.IdentificationType id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    return id;
  }

  public static gov.niem.niem.niem_core._2.IdentificationType convertId(
      String idStr, String category) {
    gov.niem.niem.niem_core._2.IdentificationType id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    id.setIdentificationCategory(
        niemCoreObjFac.createIdentificationCategoryText(convertText(category)));
    return id;
  }

  /** Converts a Java string to a URI. */
  public static gov.niem.niem.proxy.xsd._2.AnyURI convertUri(String uri) {
    gov.niem.niem.proxy.xsd._2.AnyURI anyUri = niemProxyObjFac.createAnyURI();
    anyUri.setValue(uri);
    return anyUri;
  }

  public static gov.niem.niem.proxy.xsd._2.Base64Binary convertBase64(final byte[] rawContent) {
    gov.niem.niem.proxy.xsd._2.Base64Binary binaryString = niemProxyObjFac.createBase64Binary();
    // We don't need to encode Base64? For some strange reason, JAXB does it for us.
    // See https://stackoverflow.com/a/7224025
    //binaryString.setValue(Base64.getEncoder().encode(rawContent));
    binaryString.setValue(rawContent);
    return binaryString;
  }

  public static CourtType convertCourtType(String courtId) {
    CourtType court = jxObjFac.createCourtType();
    JAXBElement<gov.niem.niem.niem_core._2.IdentificationType> idType =
        niemCoreObjFac.createOrganizationIdentification(XmlHelper.convertId(courtId));
    court.setOrganizationIdentification(idType);
    return court;
  }
  
  public static String amountToString(AmountType amt) {
    if (amt == null) {
      return "";
    }
    String currencyId = amt.getCurrencyID();
    String valStr = amt.getValue().toString();
    if (currencyId == null) {
      return valStr;
    }
    // TODO(brycew): more internationalization
    if (currencyId.equals("USD")) {
      return "$" + valStr;
    } else {
      return valStr + currencyId;
    }
  }

  /**
   * Converts any XML annotated object (from CXF) to a string. Useful for
   * debugging. Doesn't throw, but does return the string of the exception instead.
   *
   * @param  <T>   the type of object being passed in
   * @param  toXml The object to do things with
   * @return       the XML string to do what you want with
   */
  public static <T> String objectToXmlStrOrError(T toXml, Class<T> toXmlClazz) {
    try {
      return objectToXmlStr(toXml, toXmlClazz);
    } catch (JAXBException | NullPointerException ex) {
      return ex.toString();
    }
  }

  /**
   * Converts any XML annotated object (from CXF) to a string. Useful for
   * testing. Will throw an exception if there's a JAXB error.
   *
   * @param  <T>   the type of object being passed in
   * @param  toXml The object to do things with
   * @return       the XML string to do what you want with
   */
  public static <T> String objectToXmlStr(T toXml, Class<T> toXmlClazz) throws JAXBException {
    JAXBContext jaxContext = JAXBContext.newInstance(toXmlClazz,
        gov.niem.niem.niem_core._2.ObjectFactory.class,
        gov.niem.niem.structures._2.ObjectFactory.class,
        oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory.class,
        oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory.class,
        ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory.class,
        ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.ObjectFactory.class,
        ecfv5.gov.niem.release.niem.niem_core._4.ObjectFactory.class,
        ecfv5.gov.niem.release.niem.domains.jxdm._6.ObjectFactory.class
        );
    Marshaller mar = jaxContext.createMarshaller();
    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    QName qname = new QName("suffolk.test.objectToXml", "objectToXml");
    JAXBElement<T> wrappedRoot = new JAXBElement<T>(qname, toXmlClazz, toXml);
    StringWriter sw = new StringWriter();
    mar.marshal(wrappedRoot, sw);
    return sw.toString();
  }

  /**
   * Converts any XML annotated object (from CXF) to a file. Useful for
   * testing larger XML objects that are unwieldly to print.
   * Will throw an exception if there's a JAXB error.
   *
   * @param  <T>   the type of object being passed in
   * @param  toXml The object to do things with
   */
  public static <T> void objectToXmlFile(T toXml, Class<T> toXmlClazz,
      File outfile) throws JAXBException {
    JAXBContext jc = JAXBContext.newInstance(
        gov.niem.niem.niem_core._2.ObjectFactory.class,
        gov.niem.niem.structures._2.ObjectFactory.class,
        oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory.class,
        oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory.class);
    Marshaller mar = jc.createMarshaller();
    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    QName qname = new QName("suffolk.test.objectToXml", "objectToXml");
    JAXBElement<T> pp = new JAXBElement<T>(qname, toXmlClazz, toXml);
    mar.marshal(pp, outfile);
  }

}
