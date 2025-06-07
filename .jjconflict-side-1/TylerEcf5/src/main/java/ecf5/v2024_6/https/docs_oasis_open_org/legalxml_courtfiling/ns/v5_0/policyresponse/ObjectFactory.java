
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.MeasureType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.NumericType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.AnyURI;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse package. 
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

    private final static QName _GetPolicyResponseMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "GetPolicyResponseMessageAugmentationPoint");
    private final static QName _AcceptConfidentialFilingsIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "AcceptConfidentialFilingsIndicator");
    private final static QName _AcceptDocumentsRequiringFeesIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "AcceptDocumentsRequiringFeesIndicator");
    private final static QName _AcceptMultipleLeadDocumentsIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "AcceptMultipleLeadDocumentsIndicator");
    private final static QName _CodeListExtension_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "CodeListExtension");
    private final static QName _DevelopmentPolicy_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "DevelopmentPolicy");
    private final static QName _ECFElementNameText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "ECFElementNameText");
    private final static QName _ExtensionCanonicalURI_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "ExtensionCanonicalURI");
    private final static QName _ExtensionCanonicalVersionURI_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "ExtensionCanonicalVersionURI");
    private final static QName _ExtensionElementName_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "ExtensionElementName");
    private final static QName _ExtensionLocationURI_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "ExtensionLocationURI");
    private final static QName _FilerRequiredToServeIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "FilerRequiredToServeIndicator");
    private final static QName _FilingFeesMayBeApplicableIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "FilingFeesMayBeApplicableIndicator");
    private final static QName _GetPolicyResponseMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "GetPolicyResponseMessage");
    private final static QName _MajorDesignElement_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "MajorDesignElement");
    private final static QName _MajorDesignElementLocationID_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "MajorDesignElementLocationID");
    private final static QName _MajorDesignElementTypeCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "MajorDesignElementTypeCode");
    private final static QName _MaximumAllowedAttachmentPageQuantity_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "MaximumAllowedAttachmentPageQuantity");
    private final static QName _MaximumAllowedAttachmentSize_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "MaximumAllowedAttachmentSize");
    private final static QName _MaximumAllowedMessageSize_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "MaximumAllowedMessageSize");
    private final static QName _OperationNameCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "OperationNameCode");
    private final static QName _PolicyVersionID_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "PolicyVersionID");
    private final static QName _RuntimePolicy_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "RuntimePolicy");
    private final static QName _SchemaExtension_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "SchemaExtension");
    private final static QName _SupportedCaseCategories_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "SupportedCaseCategories");
    private final static QName _SupportedOperations_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "SupportedOperations");
    private final static QName _SupportedServiceInteractionProfiles_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "SupportedServiceInteractionProfiles");
    private final static QName _SupportedSignaturesProfiles_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "SupportedSignaturesProfiles");
    private final static QName _URLAttachmentSupportedIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", "URLAttachmentSupportedIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CodeListExtensionType }
     * 
     */
    public CodeListExtensionType createCodeListExtensionType() {
        return new CodeListExtensionType();
    }

    /**
     * Create an instance of {@link DevelopmentPolicyType }
     * 
     */
    public DevelopmentPolicyType createDevelopmentPolicyType() {
        return new DevelopmentPolicyType();
    }

    /**
     * Create an instance of {@link GetPolicyResponseMessageType }
     * 
     */
    public GetPolicyResponseMessageType createGetPolicyResponseMessageType() {
        return new GetPolicyResponseMessageType();
    }

    /**
     * Create an instance of {@link MajorDesignElementType }
     * 
     */
    public MajorDesignElementType createMajorDesignElementType() {
        return new MajorDesignElementType();
    }

    /**
     * Create an instance of {@link RuntimePolicyType }
     * 
     */
    public RuntimePolicyType createRuntimePolicyType() {
        return new RuntimePolicyType();
    }

    /**
     * Create an instance of {@link SchemaExtensionType }
     * 
     */
    public SchemaExtensionType createSchemaExtensionType() {
        return new SchemaExtensionType();
    }

    /**
     * Create an instance of {@link SupportedCaseCategoriesType }
     * 
     */
    public SupportedCaseCategoriesType createSupportedCaseCategoriesType() {
        return new SupportedCaseCategoriesType();
    }

    /**
     * Create an instance of {@link SupportedOperationsType }
     * 
     */
    public SupportedOperationsType createSupportedOperationsType() {
        return new SupportedOperationsType();
    }

    /**
     * Create an instance of {@link SupportedServiceInteractionProfilesType }
     * 
     */
    public SupportedServiceInteractionProfilesType createSupportedServiceInteractionProfilesType() {
        return new SupportedServiceInteractionProfilesType();
    }

    /**
     * Create an instance of {@link SupportedSignatureProfilesType }
     * 
     */
    public SupportedSignatureProfilesType createSupportedSignatureProfilesType() {
        return new SupportedSignatureProfilesType();
    }

    /**
     * Create an instance of {@link ExtensionType }
     * 
     */
    public ExtensionType createExtensionType() {
        return new ExtensionType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "GetPolicyResponseMessageAugmentationPoint")
    public JAXBElement<Object> createGetPolicyResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetPolicyResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "AcceptConfidentialFilingsIndicator")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "AcceptDocumentsRequiringFeesIndicator")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "AcceptMultipleLeadDocumentsIndicator")
    public JAXBElement<Boolean> createAcceptMultipleLeadDocumentsIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_AcceptMultipleLeadDocumentsIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodeListExtensionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CodeListExtensionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "CodeListExtension")
    public JAXBElement<CodeListExtensionType> createCodeListExtension(CodeListExtensionType value) {
        return new JAXBElement<CodeListExtensionType>(_CodeListExtension_QNAME, CodeListExtensionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DevelopmentPolicyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DevelopmentPolicyType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "DevelopmentPolicy")
    public JAXBElement<DevelopmentPolicyType> createDevelopmentPolicy(DevelopmentPolicyType value) {
        return new JAXBElement<DevelopmentPolicyType>(_DevelopmentPolicy_QNAME, DevelopmentPolicyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "ECFElementNameText")
    public JAXBElement<TextType> createECFElementNameText(TextType value) {
        return new JAXBElement<TextType>(_ECFElementNameText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "ExtensionCanonicalURI")
    public JAXBElement<AnyURI> createExtensionCanonicalURI(AnyURI value) {
        return new JAXBElement<AnyURI>(_ExtensionCanonicalURI_QNAME, AnyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "ExtensionCanonicalVersionURI")
    public JAXBElement<AnyURI> createExtensionCanonicalVersionURI(AnyURI value) {
        return new JAXBElement<AnyURI>(_ExtensionCanonicalVersionURI_QNAME, AnyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "ExtensionElementName")
    public JAXBElement<AnyURI> createExtensionElementName(AnyURI value) {
        return new JAXBElement<AnyURI>(_ExtensionElementName_QNAME, AnyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "ExtensionLocationURI")
    public JAXBElement<AnyURI> createExtensionLocationURI(AnyURI value) {
        return new JAXBElement<AnyURI>(_ExtensionLocationURI_QNAME, AnyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "FilerRequiredToServeIndicator")
    public JAXBElement<Boolean> createFilerRequiredToServeIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_FilerRequiredToServeIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "FilingFeesMayBeApplicableIndicator")
    public JAXBElement<Boolean> createFilingFeesMayBeApplicableIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_FilingFeesMayBeApplicableIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPolicyResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPolicyResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "GetPolicyResponseMessage")
    public JAXBElement<GetPolicyResponseMessageType> createGetPolicyResponseMessage(GetPolicyResponseMessageType value) {
        return new JAXBElement<GetPolicyResponseMessageType>(_GetPolicyResponseMessage_QNAME, GetPolicyResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MajorDesignElementType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MajorDesignElementType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "MajorDesignElement")
    public JAXBElement<MajorDesignElementType> createMajorDesignElement(MajorDesignElementType value) {
        return new JAXBElement<MajorDesignElementType>(_MajorDesignElement_QNAME, MajorDesignElementType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "MajorDesignElementLocationID")
    public JAXBElement<IdentificationType> createMajorDesignElementLocationID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_MajorDesignElementLocationID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "MajorDesignElementTypeCode")
    public JAXBElement<NormalizedString> createMajorDesignElementTypeCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_MajorDesignElementTypeCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NumericType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NumericType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "MaximumAllowedAttachmentPageQuantity")
    public JAXBElement<NumericType> createMaximumAllowedAttachmentPageQuantity(NumericType value) {
        return new JAXBElement<NumericType>(_MaximumAllowedAttachmentPageQuantity_QNAME, NumericType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "MaximumAllowedAttachmentSize")
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
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "MaximumAllowedMessageSize")
    public JAXBElement<MeasureType> createMaximumAllowedMessageSize(MeasureType value) {
        return new JAXBElement<MeasureType>(_MaximumAllowedMessageSize_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "OperationNameCode")
    public JAXBElement<NormalizedString> createOperationNameCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_OperationNameCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "PolicyVersionID")
    public JAXBElement<IdentificationType> createPolicyVersionID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PolicyVersionID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RuntimePolicyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RuntimePolicyType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "RuntimePolicy")
    public JAXBElement<RuntimePolicyType> createRuntimePolicy(RuntimePolicyType value) {
        return new JAXBElement<RuntimePolicyType>(_RuntimePolicy_QNAME, RuntimePolicyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SchemaExtensionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SchemaExtensionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "SchemaExtension")
    public JAXBElement<SchemaExtensionType> createSchemaExtension(SchemaExtensionType value) {
        return new JAXBElement<SchemaExtensionType>(_SchemaExtension_QNAME, SchemaExtensionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupportedCaseCategoriesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SupportedCaseCategoriesType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "SupportedCaseCategories")
    public JAXBElement<SupportedCaseCategoriesType> createSupportedCaseCategories(SupportedCaseCategoriesType value) {
        return new JAXBElement<SupportedCaseCategoriesType>(_SupportedCaseCategories_QNAME, SupportedCaseCategoriesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupportedOperationsType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SupportedOperationsType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "SupportedOperations")
    public JAXBElement<SupportedOperationsType> createSupportedOperations(SupportedOperationsType value) {
        return new JAXBElement<SupportedOperationsType>(_SupportedOperations_QNAME, SupportedOperationsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupportedServiceInteractionProfilesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SupportedServiceInteractionProfilesType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "SupportedServiceInteractionProfiles")
    public JAXBElement<SupportedServiceInteractionProfilesType> createSupportedServiceInteractionProfiles(SupportedServiceInteractionProfilesType value) {
        return new JAXBElement<SupportedServiceInteractionProfilesType>(_SupportedServiceInteractionProfiles_QNAME, SupportedServiceInteractionProfilesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupportedSignatureProfilesType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SupportedSignatureProfilesType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "SupportedSignaturesProfiles")
    public JAXBElement<SupportedSignatureProfilesType> createSupportedSignaturesProfiles(SupportedSignatureProfilesType value) {
        return new JAXBElement<SupportedSignatureProfilesType>(_SupportedSignaturesProfiles_QNAME, SupportedSignatureProfilesType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", name = "URLAttachmentSupportedIndicator")
    public JAXBElement<Boolean> createURLAttachmentSupportedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_URLAttachmentSupportedIndicator_QNAME, Boolean.class, null, value);
    }

}
