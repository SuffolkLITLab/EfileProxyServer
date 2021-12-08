package edu.suffolk.litlab.efspserver.services;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
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

  public static ecfv5.gov.niem.release.niem.proxy.xsd._4.DateTime convertProxyDate(LocalDateTime date) {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), date.getHour(), date.getMinute(), date.getSecond());

    var outputDate = niemProxyObjFac.createDateTime();
    outputDate.setValue(datatypeFac.newXMLGregorianCalendar(cal));
    return outputDate;
  }

  public static DateType convertDate(LocalDate date) {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), 0, 0, 0);

    XMLGregorianCalendar xmlCal = datatypeFac.newXMLGregorianCalendar(cal);
    xmlCal.setTimezone(DatatypeConstants.FIELD_UNDEFINED); 
    var proxyDate = niemProxyObjFac.createDate();
    proxyDate.setValue(xmlCal);

    DateType outputDate = niemCoreObjFac.createDateType(); 
    outputDate.setDateRepresentation(niemCoreObjFac.createDate(proxyDate));
    return outputDate;
  }
  
  /** Always returns datetimes that are UTC and with no milliseconds. */
  public static DateType convertDateTime(Instant inst, int fracSecondPrecision) {
    OffsetDateTime op = inst.atOffset(ZoneOffset.UTC);
    return convertCourtReserveDate(op, fracSecondPrecision);
  }

  /**
   * Tyler requires that you "[respond] back with the same time stamp that the response provides to you"
   * This is difficult given that we send that timestamp to DA and get it back, as a timestamp
   * object that represents the same time, but might not be formatted the exact same.
   * 
   * We make an assumption here that all DA timestamps given to us from the Court look like: "2022-03-25T15:00:00.0Z"
   * 
   * @param date The timestamp that we are trying to select, might be of arbitrary sub-second precision
   * @param fracSecondPrecision: only takes 0, 1, 2, 3, uses that many decimal places in the seconds 
   * @return a DateType that has _only_ the tenths decimal place, so it serializes like "2022-03-25T15:00:00.0Z"
   */
  public static DateType convertCourtReserveDate(OffsetDateTime date, int fracSecondPrecision) {
    System.out.println("Pre-Truncated: " + date.getNano());
    OffsetDateTime op = date.toInstant().atOffset(ZoneOffset.UTC);
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(op.getYear(), op.getMonthValue() - 1, op.getDayOfMonth(), op.getHour(), op.getMinute(), op.getSecond());
    cal.setTimeZone(TimeZone.getTimeZone("UTC"));

    var t = niemProxyObjFac.createDateTime();
    XMLGregorianCalendar xmlCal = datatypeFac.newXMLGregorianCalendar(cal);
    xmlCal.setMillisecond(date.getNano() / 1000000);
    if (fracSecondPrecision == 0) {
      xmlCal.setMillisecond(DatatypeConstants.FIELD_UNDEFINED);
    } else if (fracSecondPrecision > 0) {
      BigDecimal d = xmlCal.getFractionalSecond();
      MathContext mc = new MathContext(fracSecondPrecision, RoundingMode.DOWN);
      xmlCal.setFractionalSecond(d.round(mc));
    }
    t.setValue(xmlCal);

    DateType dt = niemCoreObjFac.createDateType(); 
    dt.setDateRepresentation(niemCoreObjFac.createDateTime(t));
    return dt;
  }
  
  /////// Wrapper functions: no semantic changes of the input to the output.
  
  public static ecfv5.gov.niem.release.niem.proxy.xsd._4.Boolean convertBool(boolean value) {
    var boolVal = niemProxyObjFac.createBoolean(); 
    boolVal.setValue(value);
    return boolVal;
  }

  public static CourtType convertCourtType(String courtId) {
    CourtType court = jxObjFac.createCourtType();
    court.setOrganizationIdentification(Ecfv5XmlHelper.convertId(courtId));
    return court;
  }

  public static IdentificationType convertId(String idStr) {
    IdentificationType id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    return id;
  }
  public static IdentificationType convertId(
      String idStr, String category) {
    IdentificationType id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    id.setIdentificationCategoryAbstract(
        niemCoreObjFac.createIdentificationCategoryAbstract(convertText(category)));
    return id;
  }

  public static ecfv5.gov.niem.release.niem.proxy.xsd._4.String convertString(String str) {
    var outStr = niemProxyObjFac.createString();
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
