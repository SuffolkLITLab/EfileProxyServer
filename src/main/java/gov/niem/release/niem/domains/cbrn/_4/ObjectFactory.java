
package gov.niem.release.niem.domains.cbrn._4;

import javax.xml.namespace.QName;
import gov.niem.release.niem.codes.cbrncl._4.CredentialsAuthenticatedCodeType;
import gov.niem.release.niem.codes.cbrncl._4.MessageStatusCodeType;
import gov.niem.release.niem.codes.cbrncl._4.SystemOperatingModeCodeType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.proxy.xsd._4.DateTime;
import gov.niem.release.niem.proxy.xsd._4.String;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.niem.release.niem.domains.cbrn._4 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CredentialsAuthenticatedCode_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "CredentialsAuthenticatedCode");
    private final static QName _ErrorCodeDescriptionText_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "ErrorCodeDescriptionText");
    private final static QName _ErrorCodeText_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "ErrorCodeText");
    private final static QName _ErrorDescription_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "ErrorDescription");
    private final static QName _ErrorNodeName_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "ErrorNodeName");
    private final static QName _MessageContentError_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "MessageContentError");
    private final static QName _MessageHandlingError_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "MessageHandlingError");
    private final static QName _MessageStatus_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "MessageStatus");
    private final static QName _MessageStatusAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "MessageStatusAugmentationPoint");
    private final static QName _MessageStatusCode_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "MessageStatusCode");
    private final static QName _MultimediaDataMIMEKindText_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "MultimediaDataMIMEKindText");
    private final static QName _ResendRequestIndicator_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "ResendRequestIndicator");
    private final static QName _SystemEventDateTime_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "SystemEventDateTime");
    private final static QName _SystemOperatingModeCode_QNAME = new QName("http://release.niem.gov/niem/domains/cbrn/4.0/", "SystemOperatingModeCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.niem.release.niem.domains.cbrn._4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MessageErrorType }
     * 
     */
    public MessageErrorType createMessageErrorType() {
        return new MessageErrorType();
    }

    /**
     * Create an instance of {@link MessageContentErrorType }
     * 
     */
    public MessageContentErrorType createMessageContentErrorType() {
        return new MessageContentErrorType();
    }

    /**
     * Create an instance of {@link MessageStatusType }
     * 
     */
    public MessageStatusType createMessageStatusType() {
        return new MessageStatusType();
    }

    /**
     * Create an instance of {@link RemarksComplexObjectType }
     * 
     */
    public RemarksComplexObjectType createRemarksComplexObjectType() {
        return new RemarksComplexObjectType();
    }

    /**
     * Create an instance of {@link SystemEventType }
     * 
     */
    public SystemEventType createSystemEventType() {
        return new SystemEventType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CredentialsAuthenticatedCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CredentialsAuthenticatedCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "CredentialsAuthenticatedCode")
    public JAXBElement<CredentialsAuthenticatedCodeType> createCredentialsAuthenticatedCode(CredentialsAuthenticatedCodeType value) {
        return new JAXBElement<CredentialsAuthenticatedCodeType>(_CredentialsAuthenticatedCode_QNAME, CredentialsAuthenticatedCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "ErrorCodeDescriptionText")
    public JAXBElement<TextType> createErrorCodeDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ErrorCodeDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "ErrorCodeText")
    public JAXBElement<TextType> createErrorCodeText(TextType value) {
        return new JAXBElement<TextType>(_ErrorCodeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageErrorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MessageErrorType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "ErrorDescription")
    public JAXBElement<MessageErrorType> createErrorDescription(MessageErrorType value) {
        return new JAXBElement<MessageErrorType>(_ErrorDescription_QNAME, MessageErrorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "ErrorNodeName")
    public JAXBElement<TextType> createErrorNodeName(TextType value) {
        return new JAXBElement<TextType>(_ErrorNodeName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageContentErrorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MessageContentErrorType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "MessageContentError")
    public JAXBElement<MessageContentErrorType> createMessageContentError(MessageContentErrorType value) {
        return new JAXBElement<MessageContentErrorType>(_MessageContentError_QNAME, MessageContentErrorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageErrorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MessageErrorType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "MessageHandlingError")
    public JAXBElement<MessageErrorType> createMessageHandlingError(MessageErrorType value) {
        return new JAXBElement<MessageErrorType>(_MessageHandlingError_QNAME, MessageErrorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageStatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MessageStatusType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "MessageStatus")
    public JAXBElement<MessageStatusType> createMessageStatus(MessageStatusType value) {
        return new JAXBElement<MessageStatusType>(_MessageStatus_QNAME, MessageStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "MessageStatusAugmentationPoint")
    public JAXBElement<Object> createMessageStatusAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_MessageStatusAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageStatusCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MessageStatusCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "MessageStatusCode")
    public JAXBElement<MessageStatusCodeType> createMessageStatusCode(MessageStatusCodeType value) {
        return new JAXBElement<MessageStatusCodeType>(_MessageStatusCode_QNAME, MessageStatusCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "MultimediaDataMIMEKindText")
    public JAXBElement<String> createMultimediaDataMIMEKindText(String value) {
        return new JAXBElement<String>(_MultimediaDataMIMEKindText_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "ResendRequestIndicator")
    public JAXBElement<Boolean> createResendRequestIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ResendRequestIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "SystemEventDateTime")
    public JAXBElement<DateTime> createSystemEventDateTime(DateTime value) {
        return new JAXBElement<DateTime>(_SystemEventDateTime_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SystemOperatingModeCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SystemOperatingModeCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", name = "SystemOperatingModeCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "SystemOperatingModeAbstract")
    public JAXBElement<SystemOperatingModeCodeType> createSystemOperatingModeCode(SystemOperatingModeCodeType value) {
        return new JAXBElement<SystemOperatingModeCodeType>(_SystemOperatingModeCode_QNAME, SystemOperatingModeCodeType.class, null, value);
    }

}
