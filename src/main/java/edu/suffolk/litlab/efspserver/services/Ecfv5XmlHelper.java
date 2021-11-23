package edu.suffolk.litlab.efspserver.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ecfv5.gov.niem.release.niem.domains.jxdm._6.CourtType;
import ecfv5.gov.niem.release.niem.niem_core._4.DateType;
import ecfv5.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecfv5.gov.niem.release.niem.niem_core._4.TextType;
import ecfv5.gov.niem.release.niem.proxy.xsd._4.NormalizedString;

public class Ecfv5XmlHelper {
  
  static final ecfv5.gov.niem.release.niem.niem_core._4.ObjectFactory niemCoreObjFac;
  static final ecfv5.gov.niem.release.niem.proxy.xsd._4.ObjectFactory niemProxyObjFac;
  static final ecfv5.gov.niem.release.niem.domains.jxdm._6.ObjectFactory jxObjFac;
  static final DatatypeFactory datatypeFac;

  static {
    niemProxyObjFac = new ecfv5.gov.niem.release.niem.proxy.xsd._4.ObjectFactory();
    niemCoreObjFac = new ecfv5.gov.niem.release.niem.niem_core._4.ObjectFactory();
    jxObjFac = new ecfv5.gov.niem.release.niem.domains.jxdm._6.ObjectFactory();
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

    ecfv5.gov.niem.release.niem.proxy.xsd._4.Date d = niemProxyObjFac.createDate();
    XMLGregorianCalendar x = datatypeFac.newXMLGregorianCalendar(cal);
    x.setTimezone(DatatypeConstants.FIELD_UNDEFINED); 
    d.setValue(x);

    DateType dt = niemCoreObjFac.createDateType(); 
    dt.setDateRepresentation(niemCoreObjFac.createDate(d));
    return dt;
  }

  public static ecfv5.gov.niem.release.niem.proxy.xsd._4.DateTime convertProxyDate(LocalDateTime date) {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), date.getHour(), date.getMinute(), date.getSecond());

    ecfv5.gov.niem.release.niem.proxy.xsd._4.DateTime d = niemProxyObjFac.createDateTime();
    d.setValue(datatypeFac.newXMLGregorianCalendar(cal));
    return d;
  }
  
  
  
  public static DateType convertDate(Date date) {
    GregorianCalendar cal = new GregorianCalendar();
    cal.setTime(date);

    ecfv5.gov.niem.release.niem.proxy.xsd._4.Date d = niemProxyObjFac.createDate();
    d.setValue(datatypeFac.newXMLGregorianCalendar(cal));

    DateType dt = niemCoreObjFac.createDateType(); 
    dt.setDateRepresentation(niemCoreObjFac.createDate(d));
    return dt;
  }
  
  public static DateType convertDate(LocalDateTime date) {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), date.getHour(), date.getMinute(), date.getSecond());

    ecfv5.gov.niem.release.niem.proxy.xsd._4.DateTime t = niemProxyObjFac.createDateTime();
    XMLGregorianCalendar x = datatypeFac.newXMLGregorianCalendar(cal);
    x.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
    t.setValue(x);

    DateType dt = niemCoreObjFac.createDateType(); 
    dt.setDateRepresentation(niemCoreObjFac.createDateTime(t));
    return dt;
  }

  public static DateType convertDate(OffsetDateTime date) {
    OffsetDateTime op = date.toInstant().atOffset(ZoneOffset.UTC);
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(op.getYear(), op.getMonthValue() - 1, op.getDayOfMonth(), op.getHour(), op.getMinute(), op.getSecond());
    cal.setTimeZone(TimeZone.getTimeZone("UTC"));

    ecfv5.gov.niem.release.niem.proxy.xsd._4.DateTime t = niemProxyObjFac.createDateTime();
    XMLGregorianCalendar x = datatypeFac.newXMLGregorianCalendar(cal);
    x.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
    t.setValue(x);

    DateType dt = niemCoreObjFac.createDateType(); 
    dt.setDateRepresentation(niemCoreObjFac.createDateTime(t));
    return dt;
  }
  
  public static ecfv5.gov.niem.release.niem.proxy.xsd._4.Boolean convertBool(boolean value) {
    var boolVal = new ecfv5.gov.niem.release.niem.proxy.xsd._4.Boolean();
    boolVal.setValue(value);
    return boolVal;
  }

  public static CourtType convertCourtType(String courtId) {
    CourtType court = jxObjFac.createCourtType();
    court.setOrganizationIdentification(Ecfv5XmlHelper.convertId(courtId));
    return court;
  }

  public static IdentificationType convertId(String idStr) {
    ecfv5.gov.niem.release.niem.niem_core._4.IdentificationType id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    return id;
  }
  public static IdentificationType convertId(
      String idStr, String category) {
    ecfv5.gov.niem.release.niem.niem_core._4.IdentificationType id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    id.setIdentificationCategoryAbstract(
        niemCoreObjFac.createIdentificationCategoryAbstract(convertText(category)));
    return id;
  }

  public static ecfv5.gov.niem.release.niem.proxy.xsd._4.String convertString(String str) {
    ecfv5.gov.niem.release.niem.proxy.xsd._4.String outStr = niemProxyObjFac.createString();
    outStr.setValue(str);
    return outStr;
  }

  public static TextType convertText(String str) {
    TextType tt = niemCoreObjFac.createTextType();
    tt.setValue(str);
    return tt;
  }
  
  public static NormalizedString convertNormalized(String str) {
    NormalizedString outStr = niemProxyObjFac.createNormalizedString();
    outStr.setValue(str);
    return outStr;
  }
  
}
