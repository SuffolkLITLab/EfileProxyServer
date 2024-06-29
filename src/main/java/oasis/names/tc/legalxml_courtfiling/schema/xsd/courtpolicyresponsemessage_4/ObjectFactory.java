
package oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.MeasureType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.AnyURI;
import gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4 package. 
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

    private final static QName _AcceptDocumentsRequiringFeesIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "AcceptDocumentsRequiringFeesIndicator");
    private final static QName _AcceptConfidentialFilingsIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "AcceptConfidentialFilingsIndicator");
    private final static QName _AcceptMultipleLeadDocumentsIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "AcceptMultipleLeadDocumentsIndicator");
    private final static QName _CourtCodelist_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "CourtCodelist");
    private final static QName _CourtCodelistURI_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "CourtCodelistURI");
    private final static QName _CourtExtension_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "CourtExtension");
    private final static QName _CourtExtensionURI_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "CourtExtensionURI");
    private final static QName _CourtPolicyResponseMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "CourtPolicyResponseMessage");
    private final static QName _DevelopmentPolicyParameters_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "DevelopmentPolicyParameters");
    private final static QName _ECFElementName_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "ECFElementName");
    private final static QName _EffectiveDate_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "EffectiveDate");
    private final static QName _ExpirationDate_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "ExpirationDate");
    private final static QName _FilingFeesMayBeApplicableIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "FilingFeesMayBeApplicableIndicator");
    private final static QName _GetFeesCalculationSupportedIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "GetFeesCalculationSupportedIndicator");
    private final static QName _GetCaseListSupportedIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "GetCaseListSupportedIndicator");
    private final static QName _LocationSpecificUrl_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "LocationSpecificUrl");
    private final static QName _MajorDesignElementNameCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "MajorDesignElementNameCode");
    private final static QName _MaximumAllowedAttachmentSize_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "MaximumAllowedAttachmentSize");
    private final static QName _MaximumAllowedMessageSize_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "MaximumAllowedMessageSize");
    private final static QName _PolicyLastUpdateDate_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "PolicyLastUpdateDate");
    private final static QName _PolicyVersionID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "PolicyVersionID");
    private final static QName _PublicKeyInformation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "PublicKeyInformation");
    private final static QName _RuntimePolicyParameters_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "RuntimePolicyParameters");
    private final static QName _SupportedCaseType_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "SupportedCaseType");
    private final static QName _SupportedMessageProfileCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "SupportedMessageProfileCode");
    private final static QName _SupportedOperationName_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "SupportedOperationName");
    private final static QName _SupportedSignatureProfileCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "SupportedSignatureProfileCode");
    private final static QName _URLAttachmentSupportedIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", "URLAttachmentSupportedIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CourtCodelistType }
     * 
     */
    public CourtCodelistType createCourtCodelistType() {
        return new CourtCodelistType();
    }

    /**
     * Create an instance of {@link CourtExtensionType }
     * 
     */
    public CourtExtensionType createCourtExtensionType() {
        return new CourtExtensionType();
    }

    /**
     * Create an instance of {@link CourtPolicyResponseMessageType }
     * 
     */
    public CourtPolicyResponseMessageType createCourtPolicyResponseMessageType() {
        return new CourtPolicyResponseMessageType();
    }

    /**
     * Create an instance of {@link DevelopmentPolicyParametersType }
     * 
     */
    public DevelopmentPolicyParametersType createDevelopmentPolicyParametersType() {
        return new DevelopmentPolicyParametersType();
    }

    /**
     * Create an instance of {@link MajorDesignElementNameCodeType }
     * 
     */
    public MajorDesignElementNameCodeType createMajorDesignElementNameCodeType() {
        return new MajorDesignElementNameCodeType();
    }

    /**
     * Create an instance of {@link PublicKeyInformationType }
     * 
     */
    public PublicKeyInformationType createPublicKeyInformationType() {
        return new PublicKeyInformationType();
    }

    /**
     * Create an instance of {@link RuntimePolicyParametersType }
     * 
     */
    public RuntimePolicyParametersType createRuntimePolicyParametersType() {
        return new RuntimePolicyParametersType();
    }

    /**
     * Create an instance of {@link CaseTypeCodeType }
     * 
     */
    public CaseTypeCodeType createCaseTypeCodeType() {
        return new CaseTypeCodeType();
    }

    /**
     * Create an instance of {@link OperationNameType }
     * 
     */
    public OperationNameType createOperationNameType() {
        return new OperationNameType();
    }

    /**
     * Create an instance of {@link CourtPolicyQueryMessageType }
     * 
     */
    public CourtPolicyQueryMessageType createCourtPolicyQueryMessageType() {
        return new CourtPolicyQueryMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "AcceptDocumentsRequiringFeesIndicator")
    public JAXBElement<Boolean> createAcceptDocumentsRequiringFeesIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_AcceptDocumentsRequiringFeesIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "AcceptConfidentialFilingsIndicator")
    public JAXBElement<Boolean> createAcceptConfidentialFilingsIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_AcceptConfidentialFilingsIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "AcceptMultipleLeadDocumentsIndicator")
    public JAXBElement<Boolean> createAcceptMultipleLeadDocumentsIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_AcceptMultipleLeadDocumentsIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtCodelistType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtCodelistType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "CourtCodelist")
    public JAXBElement<CourtCodelistType> createCourtCodelist(CourtCodelistType value) {
        return new JAXBElement<CourtCodelistType>(_CourtCodelist_QNAME, CourtCodelistType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "CourtCodelistURI")
    public JAXBElement<IdentificationType> createCourtCodelistURI(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_CourtCodelistURI_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtExtensionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtExtensionType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "CourtExtension")
    public JAXBElement<CourtExtensionType> createCourtExtension(CourtExtensionType value) {
        return new JAXBElement<CourtExtensionType>(_CourtExtension_QNAME, CourtExtensionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "CourtExtensionURI")
    public JAXBElement<IdentificationType> createCourtExtensionURI(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_CourtExtensionURI_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtPolicyResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtPolicyResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "CourtPolicyResponseMessage")
    public JAXBElement<CourtPolicyResponseMessageType> createCourtPolicyResponseMessage(CourtPolicyResponseMessageType value) {
        return new JAXBElement<CourtPolicyResponseMessageType>(_CourtPolicyResponseMessage_QNAME, CourtPolicyResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DevelopmentPolicyParametersType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DevelopmentPolicyParametersType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "DevelopmentPolicyParameters")
    public JAXBElement<DevelopmentPolicyParametersType> createDevelopmentPolicyParameters(DevelopmentPolicyParametersType value) {
        return new JAXBElement<DevelopmentPolicyParametersType>(_DevelopmentPolicyParameters_QNAME, DevelopmentPolicyParametersType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "ECFElementName")
    public JAXBElement<TextType> createECFElementName(TextType value) {
        return new JAXBElement<TextType>(_ECFElementName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "EffectiveDate")
    public JAXBElement<DateType> createEffectiveDate(DateType value) {
        return new JAXBElement<DateType>(_EffectiveDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "ExpirationDate")
    public JAXBElement<DateType> createExpirationDate(DateType value) {
        return new JAXBElement<DateType>(_ExpirationDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "FilingFeesMayBeApplicableIndicator")
    public JAXBElement<Boolean> createFilingFeesMayBeApplicableIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_FilingFeesMayBeApplicableIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "GetFeesCalculationSupportedIndicator")
    public JAXBElement<Boolean> createGetFeesCalculationSupportedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_GetFeesCalculationSupportedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "GetCaseListSupportedIndicator")
    public JAXBElement<Boolean> createGetCaseListSupportedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_GetCaseListSupportedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "LocationSpecificUrl")
    public JAXBElement<AnyURI> createLocationSpecificUrl(AnyURI value) {
        return new JAXBElement<AnyURI>(_LocationSpecificUrl_QNAME, AnyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MajorDesignElementNameCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MajorDesignElementNameCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "MajorDesignElementNameCode")
    public JAXBElement<MajorDesignElementNameCodeType> createMajorDesignElementNameCode(MajorDesignElementNameCodeType value) {
        return new JAXBElement<MajorDesignElementNameCodeType>(_MajorDesignElementNameCode_QNAME, MajorDesignElementNameCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "MaximumAllowedAttachmentSize")
    public JAXBElement<MeasureType> createMaximumAllowedAttachmentSize(MeasureType value) {
        return new JAXBElement<MeasureType>(_MaximumAllowedAttachmentSize_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "MaximumAllowedMessageSize")
    public JAXBElement<MeasureType> createMaximumAllowedMessageSize(MeasureType value) {
        return new JAXBElement<MeasureType>(_MaximumAllowedMessageSize_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "PolicyLastUpdateDate")
    public JAXBElement<DateType> createPolicyLastUpdateDate(DateType value) {
        return new JAXBElement<DateType>(_PolicyLastUpdateDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "PolicyVersionID")
    public JAXBElement<IdentificationType> createPolicyVersionID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PolicyVersionID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PublicKeyInformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PublicKeyInformationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "PublicKeyInformation")
    public JAXBElement<PublicKeyInformationType> createPublicKeyInformation(PublicKeyInformationType value) {
        return new JAXBElement<PublicKeyInformationType>(_PublicKeyInformation_QNAME, PublicKeyInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RuntimePolicyParametersType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RuntimePolicyParametersType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "RuntimePolicyParameters")
    public JAXBElement<RuntimePolicyParametersType> createRuntimePolicyParameters(RuntimePolicyParametersType value) {
        return new JAXBElement<RuntimePolicyParametersType>(_RuntimePolicyParameters_QNAME, RuntimePolicyParametersType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseTypeCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseTypeCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "SupportedCaseType")
    public JAXBElement<CaseTypeCodeType> createSupportedCaseType(CaseTypeCodeType value) {
        return new JAXBElement<CaseTypeCodeType>(_SupportedCaseType_QNAME, CaseTypeCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "SupportedMessageProfileCode")
    public JAXBElement<TextType> createSupportedMessageProfileCode(TextType value) {
        return new JAXBElement<TextType>(_SupportedMessageProfileCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationNameType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OperationNameType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "SupportedOperationName")
    public JAXBElement<OperationNameType> createSupportedOperationName(OperationNameType value) {
        return new JAXBElement<OperationNameType>(_SupportedOperationName_QNAME, OperationNameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "SupportedSignatureProfileCode")
    public JAXBElement<TextType> createSupportedSignatureProfileCode(TextType value) {
        return new JAXBElement<TextType>(_SupportedSignatureProfileCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", name = "URLAttachmentSupportedIndicator")
    public JAXBElement<Boolean> createURLAttachmentSupportedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_URLAttachmentSupportedIndicator_QNAME, Boolean.class, null, value);
    }

}
