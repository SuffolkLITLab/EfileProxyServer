package edu.suffolk.assemblyline.efspserver;

import gov.niem.niem.domains.jxdm._4.CourtType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.TextType;
import java.time.LocalDate;
import java.util.Base64;
import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

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
    // TODO(brycew): THIS TIMEZONE IS WRONG: how should LocalDate +
    // GregorianCalendar operate?
    d.setValue(datatypeFac.newXMLGregorianCalendarDate(date.getYear(), 
        date.getMonth().getValue(), date.getDayOfMonth(), 0));

    dt.setDateRepresentation(niemCoreObjFac.createDate(d));
    return dt;
  }
  
  public static gov.niem.niem.proxy.xsd._2.Boolean convertBool(boolean bool) {
    gov.niem.niem.proxy.xsd._2.Boolean val = new gov.niem.niem.proxy.xsd._2.Boolean();
    val.setValue(bool);
    return val;
  }
  
  
  /** Converts a Java string to Niem "Text".
   * TODO(brycew): what's the difference between text and String?
   */
  public static TextType convertText(String str) {
    TextType tt = niemCoreObjFac.createTextType();
    tt.setValue(str);
    return tt;
  }
  
  /** Converts a Java string to Niem's XML String. */
  public static gov.niem.niem.proxy.xsd._2.String convertString(String str) {
    gov.niem.niem.proxy.xsd._2.String outStr = niemProxyObjFac.createString();
    outStr.setValue(str);
    return outStr;
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
  
  public static gov.niem.niem.proxy.xsd._2.AnyURI convertUri(String uri) {
    gov.niem.niem.proxy.xsd._2.AnyURI anyUri = niemProxyObjFac.createAnyURI();
    anyUri.setValue(uri);
    return anyUri;
  }
  
  public static gov.niem.niem.proxy.xsd._2.Base64Binary convertBase64(final byte[] rawContent) {
    gov.niem.niem.proxy.xsd._2.Base64Binary binaryString = niemProxyObjFac.createBase64Binary();
    binaryString.setValue(Base64.getEncoder().encode(rawContent));
    return binaryString;
  }
  
  public static CourtType convertCourtType(String courtId) {
    CourtType court = jxObjFac.createCourtType();
    JAXBElement<gov.niem.niem.niem_core._2.IdentificationType> idType = 
        niemCoreObjFac.createOrganizationIdentification(XmlHelper.convertId(courtId));
    court.setOrganizationIdentification(idType);
    return court;
  }
}
