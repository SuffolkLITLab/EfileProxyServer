package edu.suffolk.litlab.efspserver.ecf5;

import gov.niem.release.niem.domains.jxdm._6.CourtType;
import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;

public class Ecfv5XmlHelper {

  static final gov.niem.release.niem.niem_core._4.ObjectFactory niemCoreObjFac;
  static final gov.niem.release.niem.proxy.xsd._4.ObjectFactory niemProxyObjFac;
  static final gov.niem.release.niem.domains.jxdm._6.ObjectFactory jxObjFac;
  static final DatatypeFactory datatypeFac;

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

  public static <T> String objectToXmlStrOrError(T toXml, Class<T> toXmlClazz) {
    try {
      return objectToXmlStr(toXml, toXmlClazz);
    } catch (JAXBException | NullPointerException ex) {
      return ex.toString() + "(original obj was : " + toXml.toString() + ")";
    }
  }

  public static <T> String objectToXmlStr(T toXml, Class<T> toXmlClazz) throws JAXBException {
    JAXBContext jaxContext =
        JAXBContext.newInstance(
            toXmlClazz,
            /*gov.niem.niem.niem_core._2.ObjectFactory.class,
            gov.niem.niem.structures._2.ObjectFactory.class,
            oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory.class,
            oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory.class */
            https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory.class,
            https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.ObjectFactory.class,
            gov.niem.release.niem.niem_core._4.ObjectFactory.class,
            gov.niem.release.niem.domains.jxdm._6.ObjectFactory.class);
    Marshaller mar = jaxContext.createMarshaller();
    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    QName qname = new QName("suffolk.test.objectToXml", "objectToXml");
    JAXBElement<T> wrappedRoot = new JAXBElement<T>(qname, toXmlClazz, toXml);
    StringWriter sw = new StringWriter();
    mar.marshal(wrappedRoot, sw);
    return sw.toString();
  }

  public static gov.niem.release.niem.proxy.xsd._4.DateTime convertProxyDate(LocalDateTime date) {
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(
        date.getYear(),
        date.getMonthValue() - 1,
        date.getDayOfMonth(),
        date.getHour(),
        date.getMinute(),
        date.getSecond());

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
   * Tyler requires that you "[respond] back with the same time stamp that the response provides to
   * you" This is difficult given that we send that timestamp to DA and get it back, as a timestamp
   * object that represents the same time, but might not be formatted the exact same.
   *
   * <p>We make an assumption here that all DA timestamps given to us from the Court look like:
   * "2022-03-25T15:00:00.0Z"
   *
   * @param date The timestamp that we are trying to select, might be of arbitrary sub-second
   *     precision
   * @param fracSecondPrecision: only takes 0, 1, 2, 3, uses that many decimal places in the seconds
   * @return a DateType that has _only_ the tenths decimal place, so it serializes like
   *     "2022-03-25T15:00:00.0Z"
   */
  public static DateType convertCourtReserveDate(OffsetDateTime date, int fracSecondPrecision) {
    System.out.println("Pre-Truncated: " + date.getNano());
    OffsetDateTime op = date.toInstant().atOffset(ZoneOffset.UTC);
    GregorianCalendar cal = new GregorianCalendar();
    cal.set(
        op.getYear(),
        op.getMonthValue() - 1,
        op.getDayOfMonth(),
        op.getHour(),
        op.getMinute(),
        op.getSecond());
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

  public static gov.niem.release.niem.proxy.xsd._4.Boolean convertBool(boolean value) {
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

  public static IdentificationType convertId(String idStr, String category) {
    IdentificationType id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    id.setIdentificationCategoryAbstract(
        niemCoreObjFac.createIdentificationCategoryAbstract(convertText(category)));
    return id;
  }

  public static gov.niem.release.niem.proxy.xsd._4.String convertString(String str) {
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
