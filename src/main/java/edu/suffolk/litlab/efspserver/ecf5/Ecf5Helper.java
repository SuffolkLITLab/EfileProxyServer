package edu.suffolk.litlab.efspserver.ecf5;

import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import edu.suffolk.litlab.efspserver.tyler.TylerErrorCodes;
import edu.suffolk.litlab.efspserver.tyler.TylerUserNamePassword;
import gov.niem.release.niem.domains.cbrn._4.MessageErrorType;
import gov.niem.release.niem.domains.cbrn._4.MessageStatusType;
import gov.niem.release.niem.domains.jxdm._6.CourtType;
import gov.niem.release.niem.niem_core._4.DateType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.FilingMessageType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtpolicymde.CourtPolicyMDEService;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtrecordmde.CourtRecordMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtrecordmde.CourtRecordMDEService;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.filingreviewmde.FilingReviewMDE;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.filingreviewmde.FilingReviewMDEService;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.ws.BindingProvider;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Supplier;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.ecf.v5_0.extensions.tylerfilingreviewmde.TylerFilingReviewMDE;
import tyler.ecf.v5_0.extensions.tylerfilingreviewmde.TylerFilingReviewMDEService;

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

    XMLGregorianCalendar xmlCal = datatypeFac.newXMLGregorianCalendar(cal);
    xmlCal.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
    var proxyDate = niemProxyObjFac.createDate();
    proxyDate.setValue(xmlCal);

    DateType outputDate = niemCoreObjFac.createDateType();
    outputDate.setDateRepresentation(niemCoreObjFac.createDate(proxyDate));
    return outputDate;
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

  public static gov.niem.release.niem.niem_core._4.AmountType convertAmount(BigDecimal number) {
    var amt = new gov.niem.release.niem.niem_core._4.AmountType();
    var deci = new gov.niem.release.niem.proxy.xsd._4.Decimal();
    deci.setValue(number);
    amt.setAmount(deci);
    return amt;
  }

  public static String amountToString(
      oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType amt) {
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

  /** Always returns datetimes that are UTC and with no milliseconds. */
  public static DateType convertDateTime(Instant inst, int fracSecondPrecision) {
    OffsetDateTime op = inst.atOffset(ZoneOffset.UTC);
    return convertCourtReserveDate(op, fracSecondPrecision);
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

  public static gov.niem.release.niem.niem_core._4.PersonNameTextType convertPersonText(
      String name) {
    gov.niem.release.niem.niem_core._4.PersonNameTextType nameTextType =
        niemCoreObjFac.createPersonNameTextType();
    nameTextType.setValue(name);
    return nameTextType;
  }

  public static gov.niem.release.niem.proxy.xsd._4.NormalizedString convertNormalizedString(
      String str) {
    gov.niem.release.niem.proxy.xsd._4.NormalizedString outStr =
        niemProxyObjFac.createNormalizedString();
    outStr.setValue(str);
    return outStr;
  }

  public static gov.niem.release.niem.niem_core._4.ProperNameTextType convertProperName(
      String name) {
    gov.niem.release.niem.niem_core._4.ProperNameTextType pntt =
        niemCoreObjFac.createProperNameTextType();
    pntt.setValue(name);
    return pntt;
  }

  public static gov.niem.release.niem.niem_core._4.IdentificationType convertId(String idStr) {
    var id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    return id;
  }

  public static gov.niem.release.niem.niem_core._4.IdentificationType convertId(
      String idStr, String category) {
    var id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    id.setIdentificationCategoryAbstract(
        niemCoreObjFac.createIdentificationCategoryAbstract(convertText(category)));
    return id;
  }

  public static gov.niem.release.niem.niem_core._4.IdentificationType convertId(
      String idStr, String source, String categoryDesc) {
    var id = niemCoreObjFac.createIdentificationType();
    id.setIdentificationID(convertString(idStr));
    id.setIdentificationSourceText(convertText(source));
    id.setIdentificationCategoryDescriptionText(convertText(categoryDesc));
    return id;
  }

  public static gov.niem.release.niem.niem_core._4.NonNegativeDecimalType convertDecimal(
      BigDecimal deci) {
    var deciXml = niemCoreObjFac.createNonNegativeDecimalType();
    deciXml.setValue(deci);
    return deciXml;
  }

  public static gov.niem.release.niem.niem_core._4.NonNegativeDecimalType convertDecimal(int val) {
    return convertDecimal(new BigDecimal(val));
  }

  public static gov.niem.release.niem.proxy.xsd._4.Boolean convertBool(boolean value) {
    var boolVal = niemProxyObjFac.createBoolean();
    boolVal.setValue(value);
    return boolVal;
  }

  public static CourtType convertCourt(String courtId) {
    CourtType court = jxObjFac.createCourtType();
    court.setOrganizationIdentification(convertId(courtId));
    return court;
  }

  public static Optional<CourtPolicyMDE> setupPolicyPort(
      CourtPolicyMDEService policyServFactory, String tylerToken) {
    var creds = TylerUserNamePassword.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds from " + tylerToken + "?");
      return Optional.empty();
    }
    CourtPolicyMDE mde = policyServFactory.getCourtPolicyMDE();
    ServiceHelpers.setupServicePort((BindingProvider) mde, creds.get());
    return Optional.of(mde);
  }

  public static Optional<FilingReviewMDE> setupReviewPort(
      FilingReviewMDEService reviewServFactory, String tylerToken) {
    var creds = TylerUserNamePassword.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds from " + tylerToken + "?");
      return Optional.empty();
    }

    FilingReviewMDE mde = reviewServFactory.getFilingReviewMDE();
    ServiceHelpers.setupServicePort((BindingProvider) mde, creds.get());
    return Optional.of(mde);
  }

  public static Optional<TylerFilingReviewMDE> setupTylerReviewPort(
      TylerFilingReviewMDEService tylerReviewServFactory, String tylerToken) {
    var creds = TylerUserNamePassword.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds from " + tylerToken + "?");
      return Optional.empty();
    }

    TylerFilingReviewMDE mde = tylerReviewServFactory.getTylerFilingReviewMDE();
    ServiceHelpers.setupServicePort((BindingProvider) mde, creds.get());
    return Optional.of(mde);
  }

  public static Optional<CourtRecordMDE> setupRecordPort(
      CourtRecordMDEService recordServFactory, String tylerToken) {
    var creds = TylerUserNamePassword.userCredsFromAuthorization(tylerToken);
    if (creds.isEmpty()) {
      log.warn("No creds from " + tylerToken + "?");
      return Optional.empty();
    }

    CourtRecordMDE mde = recordServFactory.getCourtRecordMDE();
    ServiceHelpers.setupServicePort((BindingProvider) mde, creds.get());
    return Optional.of(mde);
  }

  public static <T extends RequestMessageType> T prep(T newMsg, String courtId) {
    newMsg.setCaseCourt(convertCourt(courtId));
    // The example in the docs is "http://example.com/efsp1"
    newMsg.setSendingMDELocationID(convertId(ServiceHelpers.EXTERNAL_URL));
    newMsg.setServiceInteractionProfileCode(
        convertNormalizedString(ServiceHelpers.MDE_PROFILE_CODE_5));
    newMsg.setDocumentPostDate(convertNow());
    // TODO: Tyler just sends this back to us, so it can be whatever? Should be unique though.
    newMsg.getDocumentIdentification().add(convertId("1", "FilingAssembly", "messageID"));
    return newMsg;
  }

  public static <T extends FilingMessageType> T prep(T newMsg, String courtId) {
    newMsg.setCaseCourt(convertCourt(courtId));
    newMsg.setSendingMDELocationID(convertId(ServiceHelpers.EXTERNAL_URL));
    newMsg.setServiceInteractionProfileCode(
        convertNormalizedString(ServiceHelpers.MDE_PROFILE_CODE_5));
    newMsg.setDocumentPostDate(convertNow());
    // TODO: Tyler just sends this back to us, so it can be whatever? Should be unique though.
    newMsg.getDocumentIdentification().add(convertId("1", "FilingAssembly", "messageID"));
    return newMsg;
  }

  /** Returns true on errors from the Tyler / Admin side of the API. */
  public static boolean checkErrors(tyler.efm.services.schema.common.ErrorType error) {
    if (!error.getErrorCode().equals("0")) {
      log.error("Error!: " + error.getErrorCode() + ": " + error.getErrorText());
      return true;
    }
    return false;
  }

  private static class SimpleError {
    private final String code;
    private final String description;

    SimpleError(String code, String description) {
      this.code = (code != null) ? code : "";
      this.description = (description != null) ? description : "";
    }

    public String getCode() {
      return code;
    }

    public String toString() {
      return code + " " + description;
    }
  }

  private static Optional<SimpleError> checkMessageErrorType(MessageErrorType error) {
    if (error != null
        && error.getErrorCodeText() != null
        && !error.getErrorCodeText().getValue().isEmpty()
        && !error.getErrorCodeText().getValue().equals("0")) {
      return Optional.of(
          new SimpleError(
              error.getErrorCodeText().getValue(), error.getErrorCodeDescriptionText().getValue()));
    }
    return Optional.empty();
  }

  /**
   * Returns present on errors from the ECF side of the API. They work the same as the Tyler ones.
   */
  public static Optional<SimpleError> checkErrors(MessageStatusType status) {
    if (!status.getMessageContentError().isEmpty()) {
      for (var error : status.getMessageContentError()) {
        if (error != null) {
          var maybeMessage = checkMessageErrorType(error.getErrorDescription());
          if (maybeMessage.isPresent()) {
            return maybeMessage;
          }
        }
      }
    }
    var handlingError = checkMessageErrorType(status.getMessageHandlingError());
    if (handlingError.isPresent()) {
      return handlingError;
    }

    return Optional.empty();
  }

  public static Response mapTylerCodesToHttp(
      MessageStatusType status, Supplier<Response> defaultRespFunc) {
    var error = checkErrors(status);
    if (error.isEmpty()) {
      return defaultRespFunc.get();
    }

    if (TylerErrorCodes.tylerToHttp.containsKey(error.get().getCode())) {
      return Response.status(TylerErrorCodes.tylerToHttp.get(error.get().getCode()))
          .entity(error.toString())
          .build();
    }

    // 422 as semantic issues covers most of the error codes
    return Response.status(422).entity(error.toString()).build();
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
            gov.niem.release.niem.niem_core._4.ObjectFactory.class,
            gov.niem.release.niem.structures._4.ObjectFactory.class,
            https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory.class,
            https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.ObjectFactory.class,
            https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers.ObjectFactory.class);
    Marshaller mar = jaxContext.createMarshaller();
    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    QName qname = new QName("suffolk.test.objectToXml", "objectToXml");
    JAXBElement<T> wrappedRoot = new JAXBElement<T>(qname, toXmlClazz, toXml);
    StringWriter sw = new StringWriter();
    mar.marshal(wrappedRoot, sw);
    return sw.toString();
  }
}
