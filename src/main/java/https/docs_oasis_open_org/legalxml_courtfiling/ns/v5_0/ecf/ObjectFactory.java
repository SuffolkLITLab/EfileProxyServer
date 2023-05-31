
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import javax.xml.namespace.QName;
import gov.niem.release.niem.domains.jxdm._6.CourtEventType;
import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.StatusType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf package. 
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

    private final static QName _ReviewedDocumentAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ReviewedDocumentAugmentationPoint");
    private final static QName _AffectedParticipant_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "AffectedParticipant");
    private final static QName _CaseAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseAugmentation");
    private final static QName _CaseCategoryCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseCategoryCode");
    private final static QName _CaseCauseOfActionCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseCauseOfActionCode");
    private final static QName _CaseFiling_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseFiling");
    private final static QName _CaseNewIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseNewIndicator");
    private final static QName _CaseOfficialAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseOfficialAugmentation");
    private final static QName _CaseParticipantRoleCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseParticipantRoleCode");
    private final static QName _CaseParty_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseParty");
    private final static QName _CasePartySelfRepresentationIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CasePartySelfRepresentationIndicator");
    private final static QName _CaseRepresentedParty_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseRepresentedParty");
    private final static QName _CaseShortTitleText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseShortTitleText");
    private final static QName _CaseTrackingID_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseTrackingID");
    private final static QName _CaseTypeCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CaseTypeCode");
    private final static QName _CauseOfActionCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CauseOfActionCode");
    private final static QName _ChildDocket_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ChildDocket");
    private final static QName _ColorRelevantIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ColorRelevantIndicator");
    private final static QName _ConnectedDocument_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ConnectedDocument");
    private final static QName _ConnectedDocumentReview_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ConnectedDocumentReview");
    private final static QName _CourtEventActor_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CourtEventActor");
    private final static QName _CourtEventAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CourtEventAugmentation");
    private final static QName _CourtEventEnteredOnDocketDate_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CourtEventEnteredOnDocketDate");
    private final static QName _CourtEventLocationText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CourtEventLocationText");
    private final static QName _CourtEventOnBehalfOfActor_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CourtEventOnBehalfOfActor");
    private final static QName _CourtEventTypeCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CourtEventTypeCode");
    private final static QName _CourtLocationCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "CourtLocationCode");
    private final static QName _Document_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "Document");
    private final static QName _DocumentAddedInReviewIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentAddedInReviewIndicator");
    private final static QName _DocumentAssociationAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentAssociationAugmentation");
    private final static QName _DocumentAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentAugmentation");
    private final static QName _DocumentDocketingStatusCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentDocketingStatusCode");
    private final static QName _DocumentFiler_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentFiler");
    private final static QName _DocumentRelatedCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentRelatedCode");
    private final static QName _DocumentRendition_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentRendition");
    private final static QName _DocumentRenditionHash_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentRenditionHash");
    private final static QName _DocumentReviewDisposition_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentReviewDisposition");
    private final static QName _DocumentReviewStatus_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentReviewStatus");
    private final static QName _DocumentReviewStatusCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentReviewStatusCode");
    private final static QName _DocumentReviewer_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentReviewer");
    private final static QName _DocumentSignature_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentSignature");
    private final static QName _DocumentStatus_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentStatus");
    private final static QName _DocumentTypeCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "DocumentTypeCode");
    private final static QName _ElectronicServiceInformation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ElectronicServiceInformation");
    private final static QName _EntityAssociationTypeCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "EntityAssociationTypeCode");
    private final static QName _FeeExceptionReasonCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "FeeExceptionReasonCode");
    private final static QName _FeeExceptionSupportingText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "FeeExceptionSupportingText");
    private final static QName _FilingCompletionDate_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "FilingCompletionDate");
    private final static QName _FilingDocketingStatusCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "FilingDocketingStatusCode");
    private final static QName _FilingReviewStatusCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "FilingReviewStatusCode");
    private final static QName _FilingStatus_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "FilingStatus");
    private final static QName _ItemAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ItemAugmentation");
    private final static QName _LeadDocumentReview_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "LeadDocumentReview");
    private final static QName _MatchingFiling_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "MatchingFiling");
    private final static QName _MessageStatusAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "MessageStatusAugmentation");
    private final static QName _OrganizationAssociationAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "OrganizationAssociationAugmentation");
    private final static QName _OrganizationAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "OrganizationAugmentation");
    private final static QName _ParticipantID_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ParticipantID");
    private final static QName _PersonAssociationAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "PersonAssociationAugmentation");
    private final static QName _PersonAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "PersonAugmentation");
    private final static QName _PersonIdentificationCategoryCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "PersonIdentificationCategoryCode");
    private final static QName _PersonOrganizationAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "PersonOrganizationAugmentation");
    private final static QName _ReceivingMDELocationID_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ReceivingMDELocationID");
    private final static QName _ReceivingMDEProfileCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ReceivingMDEProfileCode");
    private final static QName _RedactedIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "RedactedIndicator");
    private final static QName _RedactionRequiredIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "RedactionRequiredIndicator");
    private final static QName _RegisterActionDescriptionCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "RegisterActionDescriptionCode");
    private final static QName _RelatedCaseAssociationTypeCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "RelatedCaseAssociationTypeCode");
    private final static QName _RelationActivityAssociationAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "RelationActivityAssociationAugmentation");
    private final static QName _ReviewedDocument_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ReviewedDocument");
    private final static QName _ReviewedDocumentAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ReviewedDocumentAugmentation");
    private final static QName _SealDocumentIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "SealDocumentIndicator");
    private final static QName _SendingMDELocationID_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "SendingMDELocationID");
    private final static QName _ServiceInteractionProfileCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ServiceInteractionProfileCode");
    private final static QName _ServiceRecipientID_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ServiceRecipientID");
    private final static QName _ServiceStatusCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "ServiceStatusCode");
    private final static QName _SignatureAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "SignatureAugmentation");
    private final static QName _SignatureProfileCode_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "SignatureProfileCode");
    private final static QName _SpecialHandlingInstructionsText_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "SpecialHandlingInstructionsText");
    private final static QName _SubjectAugmentation_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "SubjectAugmentation");
    private final static QName _SubjectWarrantIssuedIndicator_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "SubjectWarrantIssuedIndicator");
    private final static QName _VehicleOperatorInsuranceCoverage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", "VehicleOperatorInsuranceCoverage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CaseAugmentationType }
     * 
     */
    public CaseAugmentationType createCaseAugmentationType() {
        return new CaseAugmentationType();
    }

    /**
     * Create an instance of {@link CaseFilingType }
     * 
     */
    public CaseFilingType createCaseFilingType() {
        return new CaseFilingType();
    }

    /**
     * Create an instance of {@link CaseOfficialAugmentationType }
     * 
     */
    public CaseOfficialAugmentationType createCaseOfficialAugmentationType() {
        return new CaseOfficialAugmentationType();
    }

    /**
     * Create an instance of {@link DocumentReviewType }
     * 
     */
    public DocumentReviewType createDocumentReviewType() {
        return new DocumentReviewType();
    }

    /**
     * Create an instance of {@link CourtEventOnBehalfOfActorType }
     * 
     */
    public CourtEventOnBehalfOfActorType createCourtEventOnBehalfOfActorType() {
        return new CourtEventOnBehalfOfActorType();
    }

    /**
     * Create an instance of {@link CourtEventAugmentationType }
     * 
     */
    public CourtEventAugmentationType createCourtEventAugmentationType() {
        return new CourtEventAugmentationType();
    }

    /**
     * Create an instance of {@link CourtEventActorType }
     * 
     */
    public CourtEventActorType createCourtEventActorType() {
        return new CourtEventActorType();
    }

    /**
     * Create an instance of {@link https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentType }
     * 
     */
    public https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentType createDocumentType() {
        return new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentType();
    }

    /**
     * Create an instance of {@link DocumentAssociationAugmentationType }
     * 
     */
    public DocumentAssociationAugmentationType createDocumentAssociationAugmentationType() {
        return new DocumentAssociationAugmentationType();
    }

    /**
     * Create an instance of {@link DocumentAugmentationType }
     * 
     */
    public DocumentAugmentationType createDocumentAugmentationType() {
        return new DocumentAugmentationType();
    }

    /**
     * Create an instance of {@link DocumentRenditionType }
     * 
     */
    public DocumentRenditionType createDocumentRenditionType() {
        return new DocumentRenditionType();
    }

    /**
     * Create an instance of {@link DocumentReviewDispositionType }
     * 
     */
    public DocumentReviewDispositionType createDocumentReviewDispositionType() {
        return new DocumentReviewDispositionType();
    }

    /**
     * Create an instance of {@link DocumentSignatureType }
     * 
     */
    public DocumentSignatureType createDocumentSignatureType() {
        return new DocumentSignatureType();
    }

    /**
     * Create an instance of {@link DocumentStatusType }
     * 
     */
    public DocumentStatusType createDocumentStatusType() {
        return new DocumentStatusType();
    }

    /**
     * Create an instance of {@link ElectronicServiceInformationType }
     * 
     */
    public ElectronicServiceInformationType createElectronicServiceInformationType() {
        return new ElectronicServiceInformationType();
    }

    /**
     * Create an instance of {@link FilingStatusType }
     * 
     */
    public FilingStatusType createFilingStatusType() {
        return new FilingStatusType();
    }

    /**
     * Create an instance of {@link ItemAugmentationType }
     * 
     */
    public ItemAugmentationType createItemAugmentationType() {
        return new ItemAugmentationType();
    }

    /**
     * Create an instance of {@link MatchingFilingType }
     * 
     */
    public MatchingFilingType createMatchingFilingType() {
        return new MatchingFilingType();
    }

    /**
     * Create an instance of {@link MessageStatusAugmentationType }
     * 
     */
    public MessageStatusAugmentationType createMessageStatusAugmentationType() {
        return new MessageStatusAugmentationType();
    }

    /**
     * Create an instance of {@link OrganizationAssociationAugmentationType }
     * 
     */
    public OrganizationAssociationAugmentationType createOrganizationAssociationAugmentationType() {
        return new OrganizationAssociationAugmentationType();
    }

    /**
     * Create an instance of {@link OrganizationAugmentationType }
     * 
     */
    public OrganizationAugmentationType createOrganizationAugmentationType() {
        return new OrganizationAugmentationType();
    }

    /**
     * Create an instance of {@link PersonAssociationAugmentationType }
     * 
     */
    public PersonAssociationAugmentationType createPersonAssociationAugmentationType() {
        return new PersonAssociationAugmentationType();
    }

    /**
     * Create an instance of {@link PersonAugmentationType }
     * 
     */
    public PersonAugmentationType createPersonAugmentationType() {
        return new PersonAugmentationType();
    }

    /**
     * Create an instance of {@link PersonOrganizationAssociationAugmentationType }
     * 
     */
    public PersonOrganizationAssociationAugmentationType createPersonOrganizationAssociationAugmentationType() {
        return new PersonOrganizationAssociationAugmentationType();
    }

    /**
     * Create an instance of {@link RelatedActivityAssociationAugmentationType }
     * 
     */
    public RelatedActivityAssociationAugmentationType createRelatedActivityAssociationAugmentationType() {
        return new RelatedActivityAssociationAugmentationType();
    }

    /**
     * Create an instance of {@link ReviewedDocumentType }
     * 
     */
    public ReviewedDocumentType createReviewedDocumentType() {
        return new ReviewedDocumentType();
    }

    /**
     * Create an instance of {@link ReviewedDocumentAugmentationType }
     * 
     */
    public ReviewedDocumentAugmentationType createReviewedDocumentAugmentationType() {
        return new ReviewedDocumentAugmentationType();
    }

    /**
     * Create an instance of {@link SignatureAugmentationType }
     * 
     */
    public SignatureAugmentationType createSignatureAugmentationType() {
        return new SignatureAugmentationType();
    }

    /**
     * Create an instance of {@link SubjectAugmentationType }
     * 
     */
    public SubjectAugmentationType createSubjectAugmentationType() {
        return new SubjectAugmentationType();
    }

    /**
     * Create an instance of {@link InsuranceType }
     * 
     */
    public InsuranceType createInsuranceType() {
        return new InsuranceType();
    }

    /**
     * Create an instance of {@link CallbackMessageType }
     * 
     */
    public CallbackMessageType createCallbackMessageType() {
        return new CallbackMessageType();
    }

    /**
     * Create an instance of {@link RequestMessageType }
     * 
     */
    public RequestMessageType createRequestMessageType() {
        return new RequestMessageType();
    }

    /**
     * Create an instance of {@link ResponseMessageType }
     * 
     */
    public ResponseMessageType createResponseMessageType() {
        return new ResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ReviewedDocumentAugmentationPoint")
    public JAXBElement<Object> createReviewedDocumentAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ReviewedDocumentAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "AffectedParticipant")
    public JAXBElement<EntityType> createAffectedParticipant(EntityType value) {
        return new JAXBElement<EntityType>(_AffectedParticipant_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CaseAugmentationPoint")
    public JAXBElement<CaseAugmentationType> createCaseAugmentation(CaseAugmentationType value) {
        return new JAXBElement<CaseAugmentationType>(_CaseAugmentation_QNAME, CaseAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseCategoryCode")
    public JAXBElement<TextType> createCaseCategoryCode(TextType value) {
        return new JAXBElement<TextType>(_CaseCategoryCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseCauseOfActionCode")
    public JAXBElement<TextType> createCaseCauseOfActionCode(TextType value) {
        return new JAXBElement<TextType>(_CaseCauseOfActionCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseFilingType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseFilingType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseFiling")
    public JAXBElement<CaseFilingType> createCaseFiling(CaseFilingType value) {
        return new JAXBElement<CaseFilingType>(_CaseFiling_QNAME, CaseFilingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseNewIndicator")
    public JAXBElement<Boolean> createCaseNewIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_CaseNewIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseOfficialAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", substitutionHeadName = "CaseOfficialAugmentationPoint")
    public JAXBElement<CaseOfficialAugmentationType> createCaseOfficialAugmentation(CaseOfficialAugmentationType value) {
        return new JAXBElement<CaseOfficialAugmentationType>(_CaseOfficialAugmentation_QNAME, CaseOfficialAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseParticipantRoleCode")
    public JAXBElement<TextType> createCaseParticipantRoleCode(TextType value) {
        return new JAXBElement<TextType>(_CaseParticipantRoleCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseParty")
    public JAXBElement<EntityType> createCaseParty(EntityType value) {
        return new JAXBElement<EntityType>(_CaseParty_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CasePartySelfRepresentationIndicator")
    public JAXBElement<Boolean> createCasePartySelfRepresentationIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_CasePartySelfRepresentationIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseRepresentedParty")
    public JAXBElement<EntityType> createCaseRepresentedParty(EntityType value) {
        return new JAXBElement<EntityType>(_CaseRepresentedParty_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseShortTitleText")
    public JAXBElement<TextType> createCaseShortTitleText(TextType value) {
        return new JAXBElement<TextType>(_CaseShortTitleText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseTrackingID")
    public JAXBElement<IdentificationType> createCaseTrackingID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_CaseTrackingID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CaseTypeCode")
    public JAXBElement<NormalizedString> createCaseTypeCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_CaseTypeCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CauseOfActionCode")
    public JAXBElement<TextType> createCauseOfActionCode(TextType value) {
        return new JAXBElement<TextType>(_CauseOfActionCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ChildDocket")
    public JAXBElement<CourtEventType> createChildDocket(CourtEventType value) {
        return new JAXBElement<CourtEventType>(_ChildDocket_QNAME, CourtEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ColorRelevantIndicator")
    public JAXBElement<Boolean> createColorRelevantIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ColorRelevantIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link gov.niem.release.niem.niem_core._4.DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link gov.niem.release.niem.niem_core._4.DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ConnectedDocument")
    public JAXBElement<gov.niem.release.niem.niem_core._4.DocumentType> createConnectedDocument(gov.niem.release.niem.niem_core._4.DocumentType value) {
        return new JAXBElement<gov.niem.release.niem.niem_core._4.DocumentType>(_ConnectedDocument_QNAME, gov.niem.release.niem.niem_core._4.DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentReviewType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentReviewType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ConnectedDocumentReview")
    public JAXBElement<DocumentReviewType> createConnectedDocumentReview(DocumentReviewType value) {
        return new JAXBElement<DocumentReviewType>(_ConnectedDocumentReview_QNAME, DocumentReviewType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventOnBehalfOfActorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventOnBehalfOfActorType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CourtEventActor")
    public JAXBElement<CourtEventOnBehalfOfActorType> createCourtEventActor(CourtEventOnBehalfOfActorType value) {
        return new JAXBElement<CourtEventOnBehalfOfActorType>(_CourtEventActor_QNAME, CourtEventOnBehalfOfActorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CourtEventAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", substitutionHeadName = "CourtEventAugmentationPoint")
    public JAXBElement<CourtEventAugmentationType> createCourtEventAugmentation(CourtEventAugmentationType value) {
        return new JAXBElement<CourtEventAugmentationType>(_CourtEventAugmentation_QNAME, CourtEventAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CourtEventEnteredOnDocketDate")
    public JAXBElement<DateType> createCourtEventEnteredOnDocketDate(DateType value) {
        return new JAXBElement<DateType>(_CourtEventEnteredOnDocketDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CourtEventLocationText")
    public JAXBElement<TextType> createCourtEventLocationText(TextType value) {
        return new JAXBElement<TextType>(_CourtEventLocationText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventActorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventActorType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CourtEventOnBehalfOfActor")
    public JAXBElement<CourtEventActorType> createCourtEventOnBehalfOfActor(CourtEventActorType value) {
        return new JAXBElement<CourtEventActorType>(_CourtEventOnBehalfOfActor_QNAME, CourtEventActorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CourtEventTypeCode")
    public JAXBElement<TextType> createCourtEventTypeCode(TextType value) {
        return new JAXBElement<TextType>(_CourtEventTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "CourtLocationCode")
    public JAXBElement<TextType> createCourtLocationCode(TextType value) {
        return new JAXBElement<TextType>(_CourtLocationCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "Document")
    public JAXBElement<https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentType> createDocument(https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentType value) {
        return new JAXBElement<https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentType>(_Document_QNAME, https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentAddedInReviewIndicator")
    public JAXBElement<Boolean> createDocumentAddedInReviewIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_DocumentAddedInReviewIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentAssociationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentAssociationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentAssociationAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "DocumentAssociationAugmentationPoint")
    public JAXBElement<DocumentAssociationAugmentationType> createDocumentAssociationAugmentation(DocumentAssociationAugmentationType value) {
        return new JAXBElement<DocumentAssociationAugmentationType>(_DocumentAssociationAugmentation_QNAME, DocumentAssociationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "DocumentAugmentationPoint")
    public JAXBElement<DocumentAugmentationType> createDocumentAugmentation(DocumentAugmentationType value) {
        return new JAXBElement<DocumentAugmentationType>(_DocumentAugmentation_QNAME, DocumentAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentDocketingStatusCode")
    public JAXBElement<NormalizedString> createDocumentDocketingStatusCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_DocumentDocketingStatusCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentFiler")
    public JAXBElement<EntityType> createDocumentFiler(EntityType value) {
        return new JAXBElement<EntityType>(_DocumentFiler_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentRelatedCode")
    public JAXBElement<NormalizedString> createDocumentRelatedCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_DocumentRelatedCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentRenditionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentRenditionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentRendition")
    public JAXBElement<DocumentRenditionType> createDocumentRendition(DocumentRenditionType value) {
        return new JAXBElement<DocumentRenditionType>(_DocumentRendition_QNAME, DocumentRenditionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentRenditionHash")
    public JAXBElement<TextType> createDocumentRenditionHash(TextType value) {
        return new JAXBElement<TextType>(_DocumentRenditionHash_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentReviewDispositionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentReviewDispositionType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentReviewDisposition")
    public JAXBElement<DocumentReviewDispositionType> createDocumentReviewDisposition(DocumentReviewDispositionType value) {
        return new JAXBElement<DocumentReviewDispositionType>(_DocumentReviewDisposition_QNAME, DocumentReviewDispositionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentReviewStatus")
    public JAXBElement<StatusType> createDocumentReviewStatus(StatusType value) {
        return new JAXBElement<StatusType>(_DocumentReviewStatus_QNAME, StatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentReviewStatusCode")
    public JAXBElement<NormalizedString> createDocumentReviewStatusCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_DocumentReviewStatusCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentReviewer")
    public JAXBElement<EntityType> createDocumentReviewer(EntityType value) {
        return new JAXBElement<EntityType>(_DocumentReviewer_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentSignatureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentSignatureType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentSignature")
    public JAXBElement<DocumentSignatureType> createDocumentSignature(DocumentSignatureType value) {
        return new JAXBElement<DocumentSignatureType>(_DocumentSignature_QNAME, DocumentSignatureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentStatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentStatusType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentStatus")
    public JAXBElement<DocumentStatusType> createDocumentStatus(DocumentStatusType value) {
        return new JAXBElement<DocumentStatusType>(_DocumentStatus_QNAME, DocumentStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "DocumentTypeCode")
    public JAXBElement<TextType> createDocumentTypeCode(TextType value) {
        return new JAXBElement<TextType>(_DocumentTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElectronicServiceInformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ElectronicServiceInformationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ElectronicServiceInformation")
    public JAXBElement<ElectronicServiceInformationType> createElectronicServiceInformation(ElectronicServiceInformationType value) {
        return new JAXBElement<ElectronicServiceInformationType>(_ElectronicServiceInformation_QNAME, ElectronicServiceInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "EntityAssociationTypeCode")
    public JAXBElement<TextType> createEntityAssociationTypeCode(TextType value) {
        return new JAXBElement<TextType>(_EntityAssociationTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "FeeExceptionReasonCode")
    public JAXBElement<TextType> createFeeExceptionReasonCode(TextType value) {
        return new JAXBElement<TextType>(_FeeExceptionReasonCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "FeeExceptionSupportingText")
    public JAXBElement<TextType> createFeeExceptionSupportingText(TextType value) {
        return new JAXBElement<TextType>(_FeeExceptionSupportingText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "FilingCompletionDate")
    public JAXBElement<DateType> createFilingCompletionDate(DateType value) {
        return new JAXBElement<DateType>(_FilingCompletionDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "FilingDocketingStatusCode")
    public JAXBElement<NormalizedString> createFilingDocketingStatusCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_FilingDocketingStatusCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "FilingReviewStatusCode")
    public JAXBElement<NormalizedString> createFilingReviewStatusCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_FilingReviewStatusCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingStatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingStatusType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "FilingStatus")
    public JAXBElement<FilingStatusType> createFilingStatus(FilingStatusType value) {
        return new JAXBElement<FilingStatusType>(_FilingStatus_QNAME, FilingStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ItemAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ItemAugmentationPoint")
    public JAXBElement<ItemAugmentationType> createItemAugmentation(ItemAugmentationType value) {
        return new JAXBElement<ItemAugmentationType>(_ItemAugmentation_QNAME, ItemAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentReviewType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentReviewType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "LeadDocumentReview")
    public JAXBElement<DocumentReviewType> createLeadDocumentReview(DocumentReviewType value) {
        return new JAXBElement<DocumentReviewType>(_LeadDocumentReview_QNAME, DocumentReviewType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MatchingFilingType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MatchingFilingType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "MatchingFiling")
    public JAXBElement<MatchingFilingType> createMatchingFiling(MatchingFilingType value) {
        return new JAXBElement<MatchingFilingType>(_MatchingFiling_QNAME, MatchingFilingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MessageStatusAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MessageStatusAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "MessageStatusAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/cbrn/4.1/", substitutionHeadName = "MessageStatusAugmentationPoint")
    public JAXBElement<MessageStatusAugmentationType> createMessageStatusAugmentation(MessageStatusAugmentationType value) {
        return new JAXBElement<MessageStatusAugmentationType>(_MessageStatusAugmentation_QNAME, MessageStatusAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationAssociationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationAssociationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "OrganizationAssociationAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "OrganizationAssociationAugmentationPoint")
    public JAXBElement<OrganizationAssociationAugmentationType> createOrganizationAssociationAugmentation(OrganizationAssociationAugmentationType value) {
        return new JAXBElement<OrganizationAssociationAugmentationType>(_OrganizationAssociationAugmentation_QNAME, OrganizationAssociationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "OrganizationAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "OrganizationAugmentationPoint")
    public JAXBElement<OrganizationAugmentationType> createOrganizationAugmentation(OrganizationAugmentationType value) {
        return new JAXBElement<OrganizationAugmentationType>(_OrganizationAugmentation_QNAME, OrganizationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ParticipantID")
    public JAXBElement<IdentificationType> createParticipantID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ParticipantID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonAssociationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonAssociationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "PersonAssociationAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonAssociationAugmentationPoint")
    public JAXBElement<PersonAssociationAugmentationType> createPersonAssociationAugmentation(PersonAssociationAugmentationType value) {
        return new JAXBElement<PersonAssociationAugmentationType>(_PersonAssociationAugmentation_QNAME, PersonAssociationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "PersonAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonAugmentationPoint")
    public JAXBElement<PersonAugmentationType> createPersonAugmentation(PersonAugmentationType value) {
        return new JAXBElement<PersonAugmentationType>(_PersonAugmentation_QNAME, PersonAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "PersonIdentificationCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "IdentificationCategoryAbstract")
    public JAXBElement<NormalizedString> createPersonIdentificationCategoryCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_PersonIdentificationCategoryCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonOrganizationAssociationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonOrganizationAssociationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "PersonOrganizationAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonOrganizationAssociationAugmentationPoint")
    public JAXBElement<PersonOrganizationAssociationAugmentationType> createPersonOrganizationAugmentation(PersonOrganizationAssociationAugmentationType value) {
        return new JAXBElement<PersonOrganizationAssociationAugmentationType>(_PersonOrganizationAugmentation_QNAME, PersonOrganizationAssociationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ReceivingMDELocationID")
    public JAXBElement<IdentificationType> createReceivingMDELocationID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ReceivingMDELocationID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ReceivingMDEProfileCode")
    public JAXBElement<NormalizedString> createReceivingMDEProfileCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_ReceivingMDEProfileCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "RedactedIndicator")
    public JAXBElement<Boolean> createRedactedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_RedactedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "RedactionRequiredIndicator")
    public JAXBElement<Boolean> createRedactionRequiredIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_RedactionRequiredIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "RegisterActionDescriptionCode")
    public JAXBElement<TextType> createRegisterActionDescriptionCode(TextType value) {
        return new JAXBElement<TextType>(_RegisterActionDescriptionCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "RelatedCaseAssociationTypeCode")
    public JAXBElement<TextType> createRelatedCaseAssociationTypeCode(TextType value) {
        return new JAXBElement<TextType>(_RelatedCaseAssociationTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedActivityAssociationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RelatedActivityAssociationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "RelationActivityAssociationAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "RelatedActivityAssociationAugmentationPoint")
    public JAXBElement<RelatedActivityAssociationAugmentationType> createRelationActivityAssociationAugmentation(RelatedActivityAssociationAugmentationType value) {
        return new JAXBElement<RelatedActivityAssociationAugmentationType>(_RelationActivityAssociationAugmentation_QNAME, RelatedActivityAssociationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReviewedDocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReviewedDocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ReviewedDocument")
    public JAXBElement<ReviewedDocumentType> createReviewedDocument(ReviewedDocumentType value) {
        return new JAXBElement<ReviewedDocumentType>(_ReviewedDocument_QNAME, ReviewedDocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReviewedDocumentAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReviewedDocumentAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ReviewedDocumentAugmentation", substitutionHeadNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", substitutionHeadName = "ReviewedDocumentAugmentationPoint")
    public JAXBElement<ReviewedDocumentAugmentationType> createReviewedDocumentAugmentation(ReviewedDocumentAugmentationType value) {
        return new JAXBElement<ReviewedDocumentAugmentationType>(_ReviewedDocumentAugmentation_QNAME, ReviewedDocumentAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "SealDocumentIndicator")
    public JAXBElement<Boolean> createSealDocumentIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_SealDocumentIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "SendingMDELocationID")
    public JAXBElement<IdentificationType> createSendingMDELocationID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_SendingMDELocationID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ServiceInteractionProfileCode")
    public JAXBElement<NormalizedString> createServiceInteractionProfileCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_ServiceInteractionProfileCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ServiceRecipientID")
    public JAXBElement<IdentificationType> createServiceRecipientID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ServiceRecipientID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "ServiceStatusCode")
    public JAXBElement<NormalizedString> createServiceStatusCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_ServiceStatusCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignatureAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SignatureAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "SignatureAugmentation")
    public JAXBElement<SignatureAugmentationType> createSignatureAugmentation(SignatureAugmentationType value) {
        return new JAXBElement<SignatureAugmentationType>(_SignatureAugmentation_QNAME, SignatureAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "SignatureProfileCode")
    public JAXBElement<NormalizedString> createSignatureProfileCode(NormalizedString value) {
        return new JAXBElement<NormalizedString>(_SignatureProfileCode_QNAME, NormalizedString.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "SpecialHandlingInstructionsText")
    public JAXBElement<TextType> createSpecialHandlingInstructionsText(TextType value) {
        return new JAXBElement<TextType>(_SpecialHandlingInstructionsText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubjectAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubjectAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "SubjectAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", substitutionHeadName = "SubjectAugmentationPoint")
    public JAXBElement<SubjectAugmentationType> createSubjectAugmentation(SubjectAugmentationType value) {
        return new JAXBElement<SubjectAugmentationType>(_SubjectAugmentation_QNAME, SubjectAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "SubjectWarrantIssuedIndicator")
    public JAXBElement<Boolean> createSubjectWarrantIssuedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_SubjectWarrantIssuedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", name = "VehicleOperatorInsuranceCoverage")
    public JAXBElement<InsuranceType> createVehicleOperatorInsuranceCoverage(InsuranceType value) {
        return new JAXBElement<InsuranceType>(_VehicleOperatorInsuranceCoverage_QNAME, InsuranceType.class, null, value);
    }

}
