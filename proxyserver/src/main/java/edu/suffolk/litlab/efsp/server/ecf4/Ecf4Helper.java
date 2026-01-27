package edu.suffolk.litlab.efsp.server.ecf4;

import com.hubspot.algebra.Result;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.CourtType;
import ecf4.latest.gov.niem.niem.fips_10_4._2.CountryCodeType;
import ecf4.latest.gov.niem.niem.niem_core._2.DateType;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import ecf4.latest.gov.niem.niem.niem_core._2.MeasureType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Decimal;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseFilingType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.tyler.TylerErrorCodes;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.File;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper class that easily converts Java native types to Cumbersome XML Schema types, particularly
 * those from Oasis's ECF standard, and the National Information Exchange Model (NIEM).
 *
 * <p>Some information about NIEM: Many of the types here all include the
 * "SimpleObjectAttributeGroup", which, "provides a collection of attributes which are appropriate
 * for definition of object types", including an ID attribute, a Metadata attribute, and a Link
 * Metadata attribute that directly reference objects via IDs instead of including the object as an
 * element. TBH, I'm not sure what the design decisions that dictate the use of them are, but they
 * exist.
 *
 * @author Bryce Willey
 */
public class Ecf4Helper {
  private static final Logger log = LoggerFactory.getLogger(Ecf4Helper.class);

  static final ecf4.latest.gov.niem.niem.proxy.xsd._2.ObjectFactory niemProxyObjFac;
  static final ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory niemCoreObjFac;
  static final ecf4.latest.gov.niem.niem.domains.jxdm._4.ObjectFactory jxObjFac;
  static final DatatypeFactory datatypeFac;

  static {
    niemProxyObjFac = new ecf4.latest.gov.niem.niem.proxy.xsd._2.ObjectFactory();
    niemCoreObjFac = new ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory();
    jxObjFac = new ecf4.latest.gov.niem.niem.domains.jxdm._4.ObjectFactory();
    try {
      datatypeFac = DatatypeFactory.newInstance();
    } catch (DatatypeConfigurationException e) {
      throw new RuntimeException(e);
    }
  }

  /** Creates a date from a java date. Doesn't have time associated with it. */
  public static DateType convertDate(LocalDate date) {
    GregorianCalendar cal = new GregorianCalendar();
    // TODO(#47): DEFAULT TIMEZONE IS WRONG: how should LocalDate +
    // GregorianCalendar operate?
    cal.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), 0, 0, 0);

    ecf4.latest.gov.niem.niem.proxy.xsd._2.Date d = niemProxyObjFac.createDate();
    XMLGregorianCalendar x = datatypeFac.newXMLGregorianCalendar(cal);
    x.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
    d.setValue(x);

    DateType dt = niemCoreObjFac.createDateType();
    dt.setDateRepresentation(niemCoreObjFac.createDate(d));
    return dt;
  }

  /** Niem's Boolean type: either true or false. */
  public static ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean convertBool(boolean bool) {
    ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean val =
        new ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean();
    val.setValue(bool);
    return val;
  }

  public static Optional<String> getNonEmptyText(TextType text) {
    if (text != null && text.getValue() != null && !text.getValue().isBlank()) {
      return Optional.of(text.getValue());
    }
    return Optional.empty();
  }

  /**
   * Converts a Java string to NIEM "Text", a wrapper around the NIEM String.
   *
   * <p>"A data type for a character string"
   */
  public static TextType convertText(String str) {
    TextType tt = niemCoreObjFac.createTextType();
    tt.setValue(str);
    return tt;
  }

  /**
   * Converts a Java string to NIEM's XML String. "A datatype for character strings in XML."
   * Practically, just a xsd:string with the extra SimpleObjectAttributeGroup attributes.
   */
  public static ecf4.latest.gov.niem.niem.proxy.xsd._2.String convertString(String str) {
    ecf4.latest.gov.niem.niem.proxy.xsd._2.String outStr = niemProxyObjFac.createString();
    outStr.setValue(str);
    return outStr;
  }

  /**
   * @param type will always be in bytes, but this is for backup.
   */
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

  public static ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType convertId(String idStr) {
    var id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    return id;
  }

  public static ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType convertId(
      String idStr, String category) {
    var id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    id.setIdentificationCategory(
        niemCoreObjFac.createIdentificationCategoryText(convertText(category)));
    return id;
  }

  public static Decimal convertDecimal(BigDecimal deci) {
    Decimal xml = new Decimal();
    xml.setValue(deci);
    return xml;
  }

  /**
   * Convert an int to a BigDecimal to an XML Decimal
   *
   * <p>Weird conversion, but the multiplier on optional services is a Decimal for some reason? "I
   * need 2.3 copies of this sent to my office", lmao.
   *
   * @param val
   * @return
   */
  public static Decimal convertDecimal(int val) {
    return convertDecimal(new BigDecimal(val));
  }

  /** Converts a Java string to a URI. */
  public static ecf4.latest.gov.niem.niem.proxy.xsd._2.AnyURI convertUri(String uri) {
    ecf4.latest.gov.niem.niem.proxy.xsd._2.AnyURI anyUri = niemProxyObjFac.createAnyURI();
    anyUri.setValue(uri);
    return anyUri;
  }

  public static ecf4.latest.gov.niem.niem.proxy.xsd._2.Base64Binary convertBase64(
      final byte[] rawContent) {
    var binaryString = niemProxyObjFac.createBase64Binary();
    // We don't need to encode Base64? For some strange reason, JAXB does it for us.
    // See https://stackoverflow.com/a/7224025
    // binaryString.setValue(Base64.getEncoder().encode(rawContent));
    binaryString.setValue(rawContent);
    return binaryString;
  }

  public static CourtType convertCourtType(String courtId) {
    CourtType court = jxObjFac.createCourtType();
    var idType = niemCoreObjFac.createOrganizationIdentification(Ecf4Helper.convertId(courtId));
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
            ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory.class,
            ecf4.latest.gov.niem.niem.structures._2.ObjectFactory.class,
            ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4
                .ObjectFactory.class,
            ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory
                .class
            /* ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory.class,
            ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.ObjectFactory.class,
            ecfv5.gov.niem.release.niem.niem_core._4.ObjectFactory.class,
            ecfv5.gov.niem.release.niem.domains.jxdm._6.ObjectFactory.class*/ );
    Marshaller mar = jaxContext.createMarshaller();
    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    QName qname = new QName("suffolk.test.objectToXml", "objectToXml");
    JAXBElement<T> wrappedRoot = new JAXBElement<T>(qname, toXmlClazz, toXml);
    StringWriter sw = new StringWriter();
    mar.marshal(wrappedRoot, sw);
    return sw.toString();
  }

  /**
   * Converts any XML annotated object (from CXF) to a file. Useful for testing larger XML objects
   * that are unwieldly to print. Will throw an exception if there's a JAXB error.
   *
   * @param  <T> the type of object being passed in
   * @param toXml The object to do things with
   */
  public static <T> void objectToXmlFile(T toXml, Class<T> toXmlClazz, File outfile)
      throws JAXBException {
    JAXBContext jc =
        JAXBContext.newInstance(
            ecf4.latest.gov.niem.niem.niem_core._2.ObjectFactory.class,
            ecf4.latest.gov.niem.niem.structures._2.ObjectFactory.class,
            ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4
                .ObjectFactory.class,
            ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory
                .class);
    Marshaller mar = jc.createMarshaller();
    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    QName qname = new QName("suffolk.test.objectToXml", "objectToXml");
    JAXBElement<T> pp = new JAXBElement<T>(qname, toXmlClazz, toXml);
    mar.marshal(pp, outfile);
  }

  /** Turn a given string into a country type. */
  public static CountryCodeType strToCountryCode(String country) {
    CountryCodeType cct = new CountryCodeType();
    cct.setValue(country);
    return cct;
  }

  public static <T extends QueryMessageType> T prep(T newMsg, String courtId) {
    EntityType typ = new EntityType();
    var commonObjFac =
        new ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4
            .ObjectFactory();
    JAXBElement<PersonType> elem2 = commonObjFac.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    newMsg.setQuerySubmitter(typ);
    newMsg.setCaseCourt(Ecf4Helper.convertCourtType(courtId));
    // Example in the ECF4 docs is "https://filingreviewmde.com", which matches best to
    // EXTERNAL_URL.
    // Doesn't seem to be used by Tyler however.
    newMsg.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.EXTERNAL_URL));
    newMsg.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    return newMsg;
  }

  public static Response makeResponse(
      QueryResponseMessageType resp, Supplier<Response> defaultRespFunc) {
    return mapTylerCodesToHttp(checkErrors(resp.getError()), defaultRespFunc);
  }

  public record Error(String code, String text) {}

  /**
   * Returns the error type on errors from the ECF side of the API. They work the same as the Tyler
   * ones.
   */
  public static Optional<Error> checkError(
      ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType error) {
    var errCode = error.getErrorCode();
    if (errCode != null && !errCode.getValue().equals("0")) {
      log.error("Error!: {}: {}", errCode.getValue(), error.getErrorText().getValue());
      return Optional.of(new Error(errCode.getValue(), error.getErrorText().getValue()));
    }
    return Optional.empty();
  }

  public static List<Error> checkErrors(
      List<ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType>
          errors) {
    return errors.stream().flatMap(err -> checkError(err).stream()).toList();
  }

  public static Response mapTylerCodesToHttp(List<Error> err, Supplier<Response> defaultResp) {
    if (!err.isEmpty()) {
      var mainErr = err.getFirst();
      if (TylerErrorCodes.tylerToHttp.containsKey(mainErr.code)) {
        return Response.status(TylerErrorCodes.tylerToHttp.get(mainErr.code))
            .entity(mainErr.text)
            .build();
      }

      // 422 as semantic issues covers most of the error codes
      return Response.status(422).entity(mainErr.text).build();
    }
    return defaultResp.get();
  }

  public static void setupReplys(CaseFilingType reply) {
    reply.setSendingMDELocationID(Ecf4Helper.convertId(ServiceHelpers.SERVICE_URL));
    reply.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
  }
}
