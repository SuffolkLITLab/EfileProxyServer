
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.DriverLicenseType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.ItemType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4 package. 
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

    private final static QName _CaseParticipant_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CaseParticipant");
    private final static QName _CaseAugmentation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CaseAugmentation");
    private final static QName _ReviewedLeadDocument_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ReviewedLeadDocument");
    private final static QName _ReviewedConnectedDocument_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ReviewedConnectedDocument");
    private final static QName _Document_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "Document");
    private final static QName _Alias_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "Alias");
    private final static QName _AliasAlternateName_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "AliasAlternateName");
    private final static QName _AliasAlternateNameTypeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "AliasAlternateNameTypeCode");
    private final static QName _AttachmentSequenceID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "AttachmentSequenceID");
    private final static QName _CaseAssociationTypeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CaseAssociationTypeCode");
    private final static QName _CaseCourtEvent_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CaseCourtEvent");
    private final static QName _CaseShortTitleText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CaseShortTitleText");
    private final static QName _CaseTypeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CaseTypeCode");
    private final static QName _CaseOfficial_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CaseOfficial");
    private final static QName _CaseOtherEntityAttorney_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CaseOtherEntityAttorney");
    private final static QName _CaseParticipantRoleCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CaseParticipantRoleCode");
    private final static QName _CaseRepresentedPartyReference_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CaseRepresentedPartyReference");
    private final static QName _CauseOfActionCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CauseOfActionCode");
    private final static QName _ChildDocketReference_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ChildDocketReference");
    private final static QName _ColorRelevantIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ColorRelevantIndicator");
    private final static QName _ConnectedDocument_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ConnectedDocument");
    private final static QName _CourtEventActor_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CourtEventActor");
    private final static QName _CourtEventDocument_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CourtEventDocument");
    private final static QName _CourtEventDocumentReference_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CourtEventDocumentReference");
    private final static QName _CourtEventEnteredOnDocketDate_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CourtEventEnteredOnDocketDate");
    private final static QName _CourtEventLocationCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CourtEventLocationCode");
    private final static QName _CourtEventLocationText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CourtEventLocationText");
    private final static QName _CourtEventOnBehalfOfActor_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CourtEventOnBehalfOfActor");
    private final static QName _CourtEventTypeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "CourtEventTypeCode");
    private final static QName _DocumentAttachment_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "DocumentAttachment");
    private final static QName _DocumentDocketID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "DocumentDocketID");
    private final static QName _DocumentHashText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "DocumentHashText");
    private final static QName _DocumentMetadata_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "DocumentMetadata");
    private final static QName _DocumentRenditionMetadata_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "DocumentRenditionMetadata");
    private final static QName _DocumentRendition_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "DocumentRendition");
    private final static QName _DocumentSignature_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "DocumentSignature");
    private final static QName _ElectronicServiceInformation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ElectronicServiceInformation");
    private final static QName _EntityAssociationTypeCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "EntityAssociationTypeCode");
    private final static QName _EntityItem_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "EntityItem");
    private final static QName _EntityItemReference_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "EntityItemReference");
    private final static QName _EntityOrganization_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "EntityOrganization");
    private final static QName _EntityPerson_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "EntityPerson");
    private final static QName _Error_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "Error");
    private final static QName _ErrorCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ErrorCode");
    private final static QName _ErrorText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ErrorText");
    private final static QName _FilingAttorneyID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "FilingAttorneyID");
    private final static QName _FilingCompletionDate_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "FilingCompletionDate");
    private final static QName _FilingPartyID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "FilingPartyID");
    private final static QName _FilingStatus_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "FilingStatus");
    private final static QName _FilingStatusCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "FilingStatusCode");
    private final static QName _InsuranceProofIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "InsuranceProofIndicator");
    private final static QName _OrganizationAssociation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "OrganizationAssociation");
    private final static QName _OrganizationAugmentation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "OrganizationAugmentation");
    private final static QName _ParentDocumentReference_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ParentDocumentReference");
    private final static QName _PersonAssociation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "PersonAssociation");
    private final static QName _PersonAugmentation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "PersonAugmentation");
    private final static QName _PersonDriverLicense_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "PersonDriverLicense");
    private final static QName _PersonInsurance_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "PersonInsurance");
    private final static QName _PersonOrganizationAssociation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "PersonOrganizationAssociation");
    private final static QName _PersonTitleText_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "PersonTitleText");
    private final static QName _PriorRelatedDocumentID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "PriorRelatedDocumentID");
    private final static QName _QuerySubmitter_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "QuerySubmitter");
    private final static QName _RedactionRequiredIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "RedactionRequiredIndicator");
    private final static QName _RedactedIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "RedactedIndicator");
    private final static QName _RelatedCaseAssociation_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "RelatedCaseAssociation");
    private final static QName _ReceivingMDELocationID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ReceivingMDELocationID");
    private final static QName _ReceivingMDEProfileCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ReceivingMDEProfileCode");
    private final static QName _SealDocumentIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "SealDocumentIndicator");
    private final static QName _SendingMDELocationID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "SendingMDELocationID");
    private final static QName _SendingMDEProfileCode_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "SendingMDEProfileCode");
    private final static QName _ServiceRecipientID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "ServiceRecipientID");
    private final static QName _Signature_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "Signature");
    private final static QName _SignatureProfileID_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "SignatureProfileID");
    private final static QName _SpecialHandlingInstructions_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "SpecialHandlingInstructions");
    private final static QName _SubjectICEIdentification_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", "SubjectICEIdentification");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType }
     * 
     */
    public oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType createDocumentType() {
        return new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType();
    }

    /**
     * Create an instance of {@link CaseParticipantType }
     * 
     */
    public CaseParticipantType createCaseParticipantType() {
        return new CaseParticipantType();
    }

    /**
     * Create an instance of {@link CaseAugmentationType }
     * 
     */
    public CaseAugmentationType createCaseAugmentationType() {
        return new CaseAugmentationType();
    }

    /**
     * Create an instance of {@link ReviewedDocumentType }
     * 
     */
    public ReviewedDocumentType createReviewedDocumentType() {
        return new ReviewedDocumentType();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link OrganizationType }
     * 
     */
    public OrganizationType createOrganizationType() {
        return new OrganizationType();
    }

    /**
     * Create an instance of {@link InsuranceType }
     * 
     */
    public InsuranceType createInsuranceType() {
        return new InsuranceType();
    }

    /**
     * Create an instance of {@link AliasType }
     * 
     */
    public AliasType createAliasType() {
        return new AliasType();
    }

    /**
     * Create an instance of {@link CourtEventType }
     * 
     */
    public CourtEventType createCourtEventType() {
        return new CourtEventType();
    }

    /**
     * Create an instance of {@link CaseOfficialType }
     * 
     */
    public CaseOfficialType createCaseOfficialType() {
        return new CaseOfficialType();
    }

    /**
     * Create an instance of {@link CourtEventActorType }
     * 
     */
    public CourtEventActorType createCourtEventActorType() {
        return new CourtEventActorType();
    }

    /**
     * Create an instance of {@link CourtEventDocumentType }
     * 
     */
    public CourtEventDocumentType createCourtEventDocumentType() {
        return new CourtEventDocumentType();
    }

    /**
     * Create an instance of {@link CourtEventOnBehalfOfActorType }
     * 
     */
    public CourtEventOnBehalfOfActorType createCourtEventOnBehalfOfActorType() {
        return new CourtEventOnBehalfOfActorType();
    }

    /**
     * Create an instance of {@link DocumentAttachmentType }
     * 
     */
    public DocumentAttachmentType createDocumentAttachmentType() {
        return new DocumentAttachmentType();
    }

    /**
     * Create an instance of {@link DocumentMetadataType }
     * 
     */
    public DocumentMetadataType createDocumentMetadataType() {
        return new DocumentMetadataType();
    }

    /**
     * Create an instance of {@link DocumentRenditionMetadataType }
     * 
     */
    public DocumentRenditionMetadataType createDocumentRenditionMetadataType() {
        return new DocumentRenditionMetadataType();
    }

    /**
     * Create an instance of {@link DocumentRenditionType }
     * 
     */
    public DocumentRenditionType createDocumentRenditionType() {
        return new DocumentRenditionType();
    }

    /**
     * Create an instance of {@link DocumentSignatureType }
     * 
     */
    public DocumentSignatureType createDocumentSignatureType() {
        return new DocumentSignatureType();
    }

    /**
     * Create an instance of {@link ElectronicServiceInformationType }
     * 
     */
    public ElectronicServiceInformationType createElectronicServiceInformationType() {
        return new ElectronicServiceInformationType();
    }

    /**
     * Create an instance of {@link ErrorType }
     * 
     */
    public ErrorType createErrorType() {
        return new ErrorType();
    }

    /**
     * Create an instance of {@link FilingStatusType }
     * 
     */
    public FilingStatusType createFilingStatusType() {
        return new FilingStatusType();
    }

    /**
     * Create an instance of {@link OrganizationAssociationType }
     * 
     */
    public OrganizationAssociationType createOrganizationAssociationType() {
        return new OrganizationAssociationType();
    }

    /**
     * Create an instance of {@link OrganizationAugmentationType }
     * 
     */
    public OrganizationAugmentationType createOrganizationAugmentationType() {
        return new OrganizationAugmentationType();
    }

    /**
     * Create an instance of {@link PersonAssociationType }
     * 
     */
    public PersonAssociationType createPersonAssociationType() {
        return new PersonAssociationType();
    }

    /**
     * Create an instance of {@link PersonAugmentationType }
     * 
     */
    public PersonAugmentationType createPersonAugmentationType() {
        return new PersonAugmentationType();
    }

    /**
     * Create an instance of {@link PersonOrganizationAssociationType }
     * 
     */
    public PersonOrganizationAssociationType createPersonOrganizationAssociationType() {
        return new PersonOrganizationAssociationType();
    }

    /**
     * Create an instance of {@link RelatedCaseAssociationType }
     * 
     */
    public RelatedCaseAssociationType createRelatedCaseAssociationType() {
        return new RelatedCaseAssociationType();
    }

    /**
     * Create an instance of {@link SignatureType }
     * 
     */
    public SignatureType createSignatureType() {
        return new SignatureType();
    }

    /**
     * Create an instance of {@link QueryMessageType }
     * 
     */
    public QueryMessageType createQueryMessageType() {
        return new QueryMessageType();
    }

    /**
     * Create an instance of {@link QueryResponseMessageType }
     * 
     */
    public QueryResponseMessageType createQueryResponseMessageType() {
        return new QueryResponseMessageType();
    }

    /**
     * Create an instance of {@link SubjectType }
     * 
     */
    public SubjectType createSubjectType() {
        return new SubjectType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseParticipantType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseParticipantType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CaseParticipant")
    public JAXBElement<CaseParticipantType> createCaseParticipant(CaseParticipantType value) {
        return new JAXBElement<CaseParticipantType>(_CaseParticipant_QNAME, CaseParticipantType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CaseAugmentation")
    public JAXBElement<CaseAugmentationType> createCaseAugmentation(CaseAugmentationType value) {
        return new JAXBElement<CaseAugmentationType>(_CaseAugmentation_QNAME, CaseAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReviewedDocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReviewedDocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ReviewedLeadDocument")
    public JAXBElement<ReviewedDocumentType> createReviewedLeadDocument(ReviewedDocumentType value) {
        return new JAXBElement<ReviewedDocumentType>(_ReviewedLeadDocument_QNAME, ReviewedDocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReviewedDocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReviewedDocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ReviewedConnectedDocument")
    public JAXBElement<ReviewedDocumentType> createReviewedConnectedDocument(ReviewedDocumentType value) {
        return new JAXBElement<ReviewedDocumentType>(_ReviewedConnectedDocument_QNAME, ReviewedDocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "Document")
    public JAXBElement<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType> createDocument(oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType value) {
        return new JAXBElement<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType>(_Document_QNAME, oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AliasType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AliasType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "Alias")
    public JAXBElement<AliasType> createAlias(AliasType value) {
        return new JAXBElement<AliasType>(_Alias_QNAME, AliasType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "AliasAlternateName")
    public JAXBElement<TextType> createAliasAlternateName(TextType value) {
        return new JAXBElement<TextType>(_AliasAlternateName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "AliasAlternateNameTypeCode")
    public JAXBElement<TextType> createAliasAlternateNameTypeCode(TextType value) {
        return new JAXBElement<TextType>(_AliasAlternateNameTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link gov.niem.niem.proxy.xsd._2.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link gov.niem.niem.proxy.xsd._2.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "AttachmentSequenceID")
    public JAXBElement<gov.niem.niem.proxy.xsd._2.String> createAttachmentSequenceID(gov.niem.niem.proxy.xsd._2.String value) {
        return new JAXBElement<gov.niem.niem.proxy.xsd._2.String>(_AttachmentSequenceID_QNAME, gov.niem.niem.proxy.xsd._2.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CaseAssociationTypeCode")
    public JAXBElement<TextType> createCaseAssociationTypeCode(TextType value) {
        return new JAXBElement<TextType>(_CaseAssociationTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CaseCourtEvent", substitutionHeadNamespace = "http://niem.gov/niem/domains/jxdm/4.0", substitutionHeadName = "CaseCourtEvent")
    public JAXBElement<CourtEventType> createCaseCourtEvent(CourtEventType value) {
        return new JAXBElement<CourtEventType>(_CaseCourtEvent_QNAME, CourtEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CaseShortTitleText")
    public JAXBElement<TextType> createCaseShortTitleText(TextType value) {
        return new JAXBElement<TextType>(_CaseShortTitleText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CaseTypeCode")
    public JAXBElement<TextType> createCaseTypeCode(TextType value) {
        return new JAXBElement<TextType>(_CaseTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CaseOfficial")
    public JAXBElement<CaseOfficialType> createCaseOfficial(CaseOfficialType value) {
        return new JAXBElement<CaseOfficialType>(_CaseOfficial_QNAME, CaseOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CaseOtherEntityAttorney")
    public JAXBElement<CaseOfficialType> createCaseOtherEntityAttorney(CaseOfficialType value) {
        return new JAXBElement<CaseOfficialType>(_CaseOtherEntityAttorney_QNAME, CaseOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CaseParticipantRoleCode")
    public JAXBElement<TextType> createCaseParticipantRoleCode(TextType value) {
        return new JAXBElement<TextType>(_CaseParticipantRoleCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CaseRepresentedPartyReference")
    public JAXBElement<ReferenceType> createCaseRepresentedPartyReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_CaseRepresentedPartyReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CauseOfActionCode")
    public JAXBElement<TextType> createCauseOfActionCode(TextType value) {
        return new JAXBElement<TextType>(_CauseOfActionCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ChildDocketReference")
    public JAXBElement<ReferenceType> createChildDocketReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_ChildDocketReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ColorRelevantIndicator")
    public JAXBElement<Boolean> createColorRelevantIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ColorRelevantIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link gov.niem.niem.niem_core._2.DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ConnectedDocument")
    public JAXBElement<gov.niem.niem.niem_core._2.DocumentType> createConnectedDocument(gov.niem.niem.niem_core._2.DocumentType value) {
        return new JAXBElement<gov.niem.niem.niem_core._2.DocumentType>(_ConnectedDocument_QNAME, gov.niem.niem.niem_core._2.DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventActorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventActorType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CourtEventActor")
    public JAXBElement<CourtEventActorType> createCourtEventActor(CourtEventActorType value) {
        return new JAXBElement<CourtEventActorType>(_CourtEventActor_QNAME, CourtEventActorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventDocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventDocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CourtEventDocument")
    public JAXBElement<CourtEventDocumentType> createCourtEventDocument(CourtEventDocumentType value) {
        return new JAXBElement<CourtEventDocumentType>(_CourtEventDocument_QNAME, CourtEventDocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CourtEventDocumentReference")
    public JAXBElement<ReferenceType> createCourtEventDocumentReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_CourtEventDocumentReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CourtEventEnteredOnDocketDate")
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
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CourtEventLocationCode")
    public JAXBElement<TextType> createCourtEventLocationCode(TextType value) {
        return new JAXBElement<TextType>(_CourtEventLocationCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CourtEventLocationText")
    public JAXBElement<TextType> createCourtEventLocationText(TextType value) {
        return new JAXBElement<TextType>(_CourtEventLocationText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventOnBehalfOfActorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventOnBehalfOfActorType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CourtEventOnBehalfOfActor")
    public JAXBElement<CourtEventOnBehalfOfActorType> createCourtEventOnBehalfOfActor(CourtEventOnBehalfOfActorType value) {
        return new JAXBElement<CourtEventOnBehalfOfActorType>(_CourtEventOnBehalfOfActor_QNAME, CourtEventOnBehalfOfActorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "CourtEventTypeCode")
    public JAXBElement<TextType> createCourtEventTypeCode(TextType value) {
        return new JAXBElement<TextType>(_CourtEventTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentAttachmentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentAttachmentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "DocumentAttachment")
    public JAXBElement<DocumentAttachmentType> createDocumentAttachment(DocumentAttachmentType value) {
        return new JAXBElement<DocumentAttachmentType>(_DocumentAttachment_QNAME, DocumentAttachmentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "DocumentDocketID")
    public JAXBElement<IdentificationType> createDocumentDocketID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_DocumentDocketID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "DocumentHashText")
    public JAXBElement<TextType> createDocumentHashText(TextType value) {
        return new JAXBElement<TextType>(_DocumentHashText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentMetadataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentMetadataType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "DocumentMetadata")
    public JAXBElement<DocumentMetadataType> createDocumentMetadata(DocumentMetadataType value) {
        return new JAXBElement<DocumentMetadataType>(_DocumentMetadata_QNAME, DocumentMetadataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentRenditionMetadataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentRenditionMetadataType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "DocumentRenditionMetadata")
    public JAXBElement<DocumentRenditionMetadataType> createDocumentRenditionMetadata(DocumentRenditionMetadataType value) {
        return new JAXBElement<DocumentRenditionMetadataType>(_DocumentRenditionMetadata_QNAME, DocumentRenditionMetadataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentRenditionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentRenditionType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "DocumentRendition")
    public JAXBElement<DocumentRenditionType> createDocumentRendition(DocumentRenditionType value) {
        return new JAXBElement<DocumentRenditionType>(_DocumentRendition_QNAME, DocumentRenditionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentSignatureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentSignatureType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "DocumentSignature")
    public JAXBElement<DocumentSignatureType> createDocumentSignature(DocumentSignatureType value) {
        return new JAXBElement<DocumentSignatureType>(_DocumentSignature_QNAME, DocumentSignatureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ElectronicServiceInformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ElectronicServiceInformationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ElectronicServiceInformation")
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
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "EntityAssociationTypeCode")
    public JAXBElement<TextType> createEntityAssociationTypeCode(TextType value) {
        return new JAXBElement<TextType>(_EntityAssociationTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "EntityItem", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<ItemType> createEntityItem(ItemType value) {
        return new JAXBElement<ItemType>(_EntityItem_QNAME, ItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "EntityItemReference", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<ReferenceType> createEntityItemReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_EntityItemReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "EntityOrganization", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<OrganizationType> createEntityOrganization(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_EntityOrganization_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "EntityPerson", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<PersonType> createEntityPerson(PersonType value) {
        return new JAXBElement<PersonType>(_EntityPerson_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ErrorType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "Error")
    public JAXBElement<ErrorType> createError(ErrorType value) {
        return new JAXBElement<ErrorType>(_Error_QNAME, ErrorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ErrorCode")
    public JAXBElement<TextType> createErrorCode(TextType value) {
        return new JAXBElement<TextType>(_ErrorCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ErrorText")
    public JAXBElement<TextType> createErrorText(TextType value) {
        return new JAXBElement<TextType>(_ErrorText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "FilingAttorneyID")
    public JAXBElement<IdentificationType> createFilingAttorneyID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_FilingAttorneyID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "FilingCompletionDate")
    public JAXBElement<DateType> createFilingCompletionDate(DateType value) {
        return new JAXBElement<DateType>(_FilingCompletionDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "FilingPartyID")
    public JAXBElement<IdentificationType> createFilingPartyID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_FilingPartyID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingStatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingStatusType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "FilingStatus")
    public JAXBElement<FilingStatusType> createFilingStatus(FilingStatusType value) {
        return new JAXBElement<FilingStatusType>(_FilingStatus_QNAME, FilingStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "FilingStatusCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<java.lang.String> createFilingStatusCode(java.lang.String value) {
        return new JAXBElement<java.lang.String>(_FilingStatusCode_QNAME, java.lang.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "InsuranceProofIndicator")
    public JAXBElement<Boolean> createInsuranceProofIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_InsuranceProofIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "OrganizationAssociation")
    public JAXBElement<OrganizationAssociationType> createOrganizationAssociation(OrganizationAssociationType value) {
        return new JAXBElement<OrganizationAssociationType>(_OrganizationAssociation_QNAME, OrganizationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "OrganizationAugmentation")
    public JAXBElement<OrganizationAugmentationType> createOrganizationAugmentation(OrganizationAugmentationType value) {
        return new JAXBElement<OrganizationAugmentationType>(_OrganizationAugmentation_QNAME, OrganizationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ParentDocumentReference")
    public JAXBElement<ReferenceType> createParentDocumentReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_ParentDocumentReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "PersonAssociation")
    public JAXBElement<PersonAssociationType> createPersonAssociation(PersonAssociationType value) {
        return new JAXBElement<PersonAssociationType>(_PersonAssociation_QNAME, PersonAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "PersonAugmentation")
    public JAXBElement<PersonAugmentationType> createPersonAugmentation(PersonAugmentationType value) {
        return new JAXBElement<PersonAugmentationType>(_PersonAugmentation_QNAME, PersonAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverLicenseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriverLicenseType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "PersonDriverLicense")
    public JAXBElement<DriverLicenseType> createPersonDriverLicense(DriverLicenseType value) {
        return new JAXBElement<DriverLicenseType>(_PersonDriverLicense_QNAME, DriverLicenseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "PersonInsurance")
    public JAXBElement<InsuranceType> createPersonInsurance(InsuranceType value) {
        return new JAXBElement<InsuranceType>(_PersonInsurance_QNAME, InsuranceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonOrganizationAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonOrganizationAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "PersonOrganizationAssociation")
    public JAXBElement<PersonOrganizationAssociationType> createPersonOrganizationAssociation(PersonOrganizationAssociationType value) {
        return new JAXBElement<PersonOrganizationAssociationType>(_PersonOrganizationAssociation_QNAME, PersonOrganizationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "PersonTitleText")
    public JAXBElement<TextType> createPersonTitleText(TextType value) {
        return new JAXBElement<TextType>(_PersonTitleText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "PriorRelatedDocumentID")
    public JAXBElement<IdentificationType> createPriorRelatedDocumentID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PriorRelatedDocumentID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "QuerySubmitter")
    public JAXBElement<EntityType> createQuerySubmitter(EntityType value) {
        return new JAXBElement<EntityType>(_QuerySubmitter_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "RedactionRequiredIndicator")
    public JAXBElement<Boolean> createRedactionRequiredIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_RedactionRequiredIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "RedactedIndicator")
    public JAXBElement<Boolean> createRedactedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_RedactedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedCaseAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RelatedCaseAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "RelatedCaseAssociation")
    public JAXBElement<RelatedCaseAssociationType> createRelatedCaseAssociation(RelatedCaseAssociationType value) {
        return new JAXBElement<RelatedCaseAssociationType>(_RelatedCaseAssociation_QNAME, RelatedCaseAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ReceivingMDELocationID")
    public JAXBElement<IdentificationType> createReceivingMDELocationID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ReceivingMDELocationID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ReceivingMDEProfileCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<java.lang.String> createReceivingMDEProfileCode(java.lang.String value) {
        return new JAXBElement<java.lang.String>(_ReceivingMDEProfileCode_QNAME, java.lang.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "SealDocumentIndicator")
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
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "SendingMDELocationID")
    public JAXBElement<IdentificationType> createSendingMDELocationID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_SendingMDELocationID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "SendingMDEProfileCode")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    public JAXBElement<java.lang.String> createSendingMDEProfileCode(java.lang.String value) {
        return new JAXBElement<java.lang.String>(_SendingMDEProfileCode_QNAME, java.lang.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "ServiceRecipientID")
    public JAXBElement<IdentificationType> createServiceRecipientID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ServiceRecipientID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignatureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SignatureType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "Signature")
    public JAXBElement<SignatureType> createSignature(SignatureType value) {
        return new JAXBElement<SignatureType>(_Signature_QNAME, SignatureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "SignatureProfileID")
    public JAXBElement<TextType> createSignatureProfileID(TextType value) {
        return new JAXBElement<TextType>(_SignatureProfileID_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "SpecialHandlingInstructions")
    public JAXBElement<TextType> createSpecialHandlingInstructions(TextType value) {
        return new JAXBElement<TextType>(_SpecialHandlingInstructions_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", name = "SubjectICEIdentification")
    public JAXBElement<IdentificationType> createSubjectICEIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_SubjectICEIdentification_QNAME, IdentificationType.class, null, value);
    }

}
