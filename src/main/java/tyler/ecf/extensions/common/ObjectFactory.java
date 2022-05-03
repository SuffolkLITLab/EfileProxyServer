
package tyler.ecf.extensions.common;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.MeasureType;
import gov.niem.niem.niem_core._2.NonNegativeDecimalType;
import gov.niem.niem.niem_core._2.ProperNameTextType;
import gov.niem.niem.niem_core._2.StructuredAddressType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.proxy.xsd._2.Decimal;
import gov.niem.niem.proxy.xsd._2.GYear;
import gov.niem.niem.structures._2.ReferenceType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.common package. 
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

    private final static QName _TimeoutMinutes_QNAME = new QName("urn:tyler:ecf:extensions:Common", "TimeoutMinutes");
    private final static QName _TimeoutResetHour_QNAME = new QName("urn:tyler:ecf:extensions:Common", "TimeoutResetHour");
    private final static QName _DevelopmentPolicyParameters_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DevelopmentPolicyParameters");
    private final static QName _PersonCapability_QNAME = new QName("urn:tyler:ecf:extensions:Common", "PersonCapability");
    private final static QName _IAmThisUserIndicator_QNAME = new QName("urn:tyler:ecf:extensions:Common", "IAmThisUserIndicator");
    private final static QName _CourtSplitAmount_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CourtSplitAmount");
    private final static QName _NonCourtSplitAmount_QNAME = new QName("urn:tyler:ecf:extensions:Common", "NonCourtSplitAmount");
    private final static QName _FeeSplit_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FeeSplit");
    private final static QName _PaymentInstructionID_QNAME = new QName("urn:tyler:ecf:extensions:Common", "PaymentInstructionID");
    private final static QName _PartyService_QNAME = new QName("urn:tyler:ecf:extensions:Common", "PartyService");
    private final static QName _FilingAssociation_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingAssociation");
    private final static QName _PartyReference_QNAME = new QName("urn:tyler:ecf:extensions:Common", "PartyReference");
    private final static QName _FilingReference_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingReference");
    private final static QName _ServiceDate_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ServiceDate");
    private final static QName _FilerInformation_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilerInformation");
    private final static QName _RecipientInformation_QNAME = new QName("urn:tyler:ecf:extensions:Common", "RecipientInformation");
    private final static QName _SubmitterInformation_QNAME = new QName("urn:tyler:ecf:extensions:Common", "SubmitterInformation");
    private final static QName _FilerName_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilerName");
    private final static QName _FirmName_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FirmName");
    private final static QName _RecipientName_QNAME = new QName("urn:tyler:ecf:extensions:Common", "RecipientName");
    private final static QName _RecipientFirmName_QNAME = new QName("urn:tyler:ecf:extensions:Common", "RecipientFirmName");
    private final static QName _SubmitterName_QNAME = new QName("urn:tyler:ecf:extensions:Common", "SubmitterName");
    private final static QName _SubmitterFirmName_QNAME = new QName("urn:tyler:ecf:extensions:Common", "SubmitterFirmName");
    private final static QName _CaseAddress_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseAddress");
    private final static QName _AgencyOperation_QNAME = new QName("urn:tyler:ecf:extensions:Common", "AgencyOperation");
    private final static QName _Agency_QNAME = new QName("urn:tyler:ecf:extensions:Common", "Agency");
    private final static QName _AgencyIdentification_QNAME = new QName("urn:tyler:ecf:extensions:Common", "AgencyIdentification");
    private final static QName _WillFiledDate_QNAME = new QName("urn:tyler:ecf:extensions:Common", "WillFiledDate");
    private final static QName _QuestionAnswer_QNAME = new QName("urn:tyler:ecf:extensions:Common", "QuestionAnswer");
    private final static QName _QuestionID_QNAME = new QName("urn:tyler:ecf:extensions:Common", "QuestionID");
    private final static QName _AnswerID_QNAME = new QName("urn:tyler:ecf:extensions:Common", "AnswerID");
    private final static QName _RegistrationNumber_QNAME = new QName("urn:tyler:ecf:extensions:Common", "RegistrationNumber");
    private final static QName _RegistrationStateCode_QNAME = new QName("urn:tyler:ecf:extensions:Common", "RegistrationStateCode");
    private final static QName _VehicleTypeCode_QNAME = new QName("urn:tyler:ecf:extensions:Common", "VehicleTypeCode");
    private final static QName _ModelYear_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ModelYear");
    private final static QName _CommercialVehicleIndicator_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CommercialVehicleIndicator");
    private final static QName _HazardousIndicator_QNAME = new QName("urn:tyler:ecf:extensions:Common", "HazardousIndicator");
    private final static QName _Vehicle_QNAME = new QName("urn:tyler:ecf:extensions:Common", "Vehicle");
    private final static QName _CitationAugmentation_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CitationAugmentation");
    private final static QName _DrivingIncident_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DrivingIncident");
    private final static QName _LegalSpeedRate_QNAME = new QName("urn:tyler:ecf:extensions:Common", "LegalSpeedRate");
    private final static QName _ActualSpeedRate_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ActualSpeedRate");
    private final static QName _JurisdictionCode_QNAME = new QName("urn:tyler:ecf:extensions:Common", "JurisdictionCode");
    private final static QName _ExtendedData_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ExtendedData");
    private final static QName _CaseEvent_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseEvent");
    private final static QName _FilingEvent_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingEvent");
    private final static QName _ProviderCharge_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ProviderCharge");
    private final static QName _MotionTypeCode_QNAME = new QName("urn:tyler:ecf:extensions:Common", "MotionTypeCode");
    private final static QName _DecedentPartyAssociation_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DecedentPartyAssociation");
    private final static QName _EntityFiler_QNAME = new QName("urn:tyler:ecf:extensions:Common", "EntityFiler");
    private final static QName _CaseAbstractor_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseAbstractor");
    private final static QName _AbstractorName_QNAME = new QName("urn:tyler:ecf:extensions:Common", "AbstractorName");
    private final static QName _Fees_QNAME = new QName("urn:tyler:ecf:extensions:Common", "Fees");
    private final static QName _CaseTypeText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseTypeText");
    private final static QName _FilerTypeText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilerTypeText");
    private final static QName _CaseSubTypeText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseSubTypeText");
    private final static QName _Identification_QNAME = new QName("urn:tyler:ecf:extensions:Common", "Identification");
    private final static QName _OrganizationOtherIdentification_QNAME = new QName("urn:tyler:ecf:extensions:Common", "OrganizationOtherIdentification");
    private final static QName _AttachServiceContactIndicator_QNAME = new QName("urn:tyler:ecf:extensions:Common", "AttachServiceContactIndicator");
    private final static QName _LowerCourtText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "LowerCourtText");
    private final static QName _LowerCourtJudgeText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "LowerCourtJudgeText");
    private final static QName _LowerCourtCaseTypeText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "LowerCourtCaseTypeText");
    private final static QName _RedactionID_QNAME = new QName("urn:tyler:ecf:extensions:Common", "RedactionID");
    private final static QName _AttachmentReference_QNAME = new QName("urn:tyler:ecf:extensions:Common", "AttachmentReference");
    private final static QName _RedactionIdentification_QNAME = new QName("urn:tyler:ecf:extensions:Common", "RedactionIdentification");
    private final static QName _PropertyAccountNumber_QNAME = new QName("urn:tyler:ecf:extensions:Common", "PropertyAccountNumber");
    private final static QName _AccountNumber_QNAME = new QName("urn:tyler:ecf:extensions:Common", "AccountNumber");
    private final static QName _CaseAugmentation_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseAugmentation");
    private final static QName _FilingLeadDocument_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingLeadDocument");
    private final static QName _FilingConnectedDocument_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingConnectedDocument");
    private final static QName _ReviewedLeadDocument_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ReviewedLeadDocument");
    private final static QName _ReviewedConnectedDocument_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ReviewedConnectedDocument");
    private final static QName _Document_QNAME = new QName("urn:tyler:ecf:extensions:Common", "Document");
    private final static QName _DocumentReviewer_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DocumentReviewer");
    private final static QName _DocumentReviewDate_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DocumentReviewDate");
    private final static QName _FilingReviewCommentsText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingReviewCommentsText");
    private final static QName _RejectReasonText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "RejectReasonText");
    private final static QName _WaiverIndicator_QNAME = new QName("urn:tyler:ecf:extensions:Common", "WaiverIndicator");
    private final static QName _MaxFeeAmount_QNAME = new QName("urn:tyler:ecf:extensions:Common", "MaxFeeAmount");
    private final static QName _ReturnDate_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ReturnDate");
    private final static QName _OutOfStateIndicator_QNAME = new QName("urn:tyler:ecf:extensions:Common", "OutOfStateIndicator");
    private final static QName _ScheduleDayStartTime_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ScheduleDayStartTime");
    private final static QName _ScheduleDayEndTime_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ScheduleDayEndTime");
    private final static QName _CourtRoom_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CourtRoom");
    private final static QName _CourtStreet_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CourtStreet");
    private final static QName _CourtCityStateZip_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CourtCityStateZip");
    private final static QName _ServiceReference_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ServiceReference");
    private final static QName _ServicePartyReference_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ServicePartyReference");
    private final static QName _HearingSchedule_QNAME = new QName("urn:tyler:ecf:extensions:Common", "HearingSchedule");
    private final static QName _CourtesyCopiesText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CourtesyCopiesText");
    private final static QName _PreliminaryCopiesText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "PreliminaryCopiesText");
    private final static QName _Multiplier_QNAME = new QName("urn:tyler:ecf:extensions:Common", "Multiplier");
    private final static QName _FeeAmount_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FeeAmount");
    private final static QName _DocumentOptionalService_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DocumentOptionalService");
    private final static QName _FilingCommentsText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingCommentsText");
    private final static QName _RemedyCode_QNAME = new QName("urn:tyler:ecf:extensions:Common", "RemedyCode");
    private final static QName _DamageAmountCode_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DamageAmountCode");
    private final static QName _ProcedureRemedy_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ProcedureRemedy");
    private final static QName _CivilClaimAmount_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CivilClaimAmount");
    private final static QName _ProbateEstateAmount_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ProbateEstateAmount");
    private final static QName _CaseTitle_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseTitle");
    private final static QName _CaseNumber_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseNumber");
    private final static QName _FilingType_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingType");
    private final static QName _FilingAttorney_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingAttorney");
    private final static QName _FilingCode_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingCode");
    private final static QName _OrganizationIdentificationID_QNAME = new QName("urn:tyler:ecf:extensions:Common", "OrganizationIdentificationID");
    private final static QName _CaseCategoryCode_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseCategoryCode");
    private final static QName _CaseTypeCode_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseTypeCode");
    private final static QName _CaseJudge_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseJudge");
    private final static QName _Payment_QNAME = new QName("urn:tyler:ecf:extensions:Common", "Payment");
    private final static QName _AccountName_QNAME = new QName("urn:tyler:ecf:extensions:Common", "AccountName");
    private final static QName _CardType_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CardType");
    private final static QName _Last4Digits_QNAME = new QName("urn:tyler:ecf:extensions:Common", "Last4Digits");
    private final static QName _ExpirationMonth_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ExpirationMonth");
    private final static QName _ExpirationYear_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ExpirationYear");
    private final static QName _TransactionAmount_QNAME = new QName("urn:tyler:ecf:extensions:Common", "TransactionAmount");
    private final static QName _TransactionResponse_QNAME = new QName("urn:tyler:ecf:extensions:Common", "TransactionResponse");
    private final static QName _TransactionID_QNAME = new QName("urn:tyler:ecf:extensions:Common", "TransactionID");
    private final static QName _OrderID_QNAME = new QName("urn:tyler:ecf:extensions:Common", "OrderID");
    private final static QName _ServiceContactIdentification_QNAME = new QName("urn:tyler:ecf:extensions:Common", "ServiceContactIdentification");
    private final static QName _DocumentID_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DocumentID");
    private final static QName _CMSID_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CMSID");
    private final static QName _FilingID_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingID");
    private final static QName _DocumentAttachmentReference_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DocumentAttachmentReference");
    private final static QName _FilingIdentificationReference_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingIdentificationReference");
    private final static QName _CourtEvent_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CourtEvent");
    private final static QName _DocumentAttachmentIdentification_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DocumentAttachmentIdentification");
    private final static QName _FilingIdentification_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingIdentification");
    private final static QName _FilingAction_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingAction");
    private final static QName _TrackingNumber_QNAME = new QName("urn:tyler:ecf:extensions:Common", "TrackingNumber");
    private final static QName _MailServiceIndicator_QNAME = new QName("urn:tyler:ecf:extensions:Common", "MailServiceIndicator");
    private final static QName _CaseSecurity_QNAME = new QName("urn:tyler:ecf:extensions:Common", "CaseSecurity");
    private final static QName _PhysicalFeatureDescriptionText_QNAME = new QName("urn:tyler:ecf:extensions:Common", "PhysicalFeatureDescriptionText");
    private final static QName _PhysicalFeatureReference_QNAME = new QName("urn:tyler:ecf:extensions:Common", "PhysicalFeatureReference");
    private final static QName _PhysicalFeature_QNAME = new QName("urn:tyler:ecf:extensions:Common", "PhysicalFeature");
    private final static QName _PageCount_QNAME = new QName("urn:tyler:ecf:extensions:Common", "PageCount");
    private final static QName _DocumentSecurity_QNAME = new QName("urn:tyler:ecf:extensions:Common", "DocumentSecurity");
    private final static QName _FilingAssociationParty_QNAME = new QName("urn:tyler:ecf:extensions:Common", "FilingAssociationParty");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.common
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DevelopmentPolicyParametersType }
     * 
     */
    public DevelopmentPolicyParametersType createDevelopmentPolicyParametersType() {
        return new DevelopmentPolicyParametersType();
    }

    /**
     * Create an instance of {@link CapabilityType }
     * 
     */
    public CapabilityType createCapabilityType() {
        return new CapabilityType();
    }

    /**
     * Create an instance of {@link SplitAmountType }
     * 
     */
    public SplitAmountType createSplitAmountType() {
        return new SplitAmountType();
    }

    /**
     * Create an instance of {@link FeeSplitType }
     * 
     */
    public FeeSplitType createFeeSplitType() {
        return new FeeSplitType();
    }

    /**
     * Create an instance of {@link PartyServiceType }
     * 
     */
    public PartyServiceType createPartyServiceType() {
        return new PartyServiceType();
    }

    /**
     * Create an instance of {@link FilingAssociationType }
     * 
     */
    public FilingAssociationType createFilingAssociationType() {
        return new FilingAssociationType();
    }

    /**
     * Create an instance of {@link FilerInformationType }
     * 
     */
    public FilerInformationType createFilerInformationType() {
        return new FilerInformationType();
    }

    /**
     * Create an instance of {@link RecipientInformationType }
     * 
     */
    public RecipientInformationType createRecipientInformationType() {
        return new RecipientInformationType();
    }

    /**
     * Create an instance of {@link SubmitterInformationType }
     * 
     */
    public SubmitterInformationType createSubmitterInformationType() {
        return new SubmitterInformationType();
    }

    /**
     * Create an instance of {@link AgencyType }
     * 
     */
    public AgencyType createAgencyType() {
        return new AgencyType();
    }

    /**
     * Create an instance of {@link QuestionAnswerType }
     * 
     */
    public QuestionAnswerType createQuestionAnswerType() {
        return new QuestionAnswerType();
    }

    /**
     * Create an instance of {@link VehicleType }
     * 
     */
    public VehicleType createVehicleType() {
        return new VehicleType();
    }

    /**
     * Create an instance of {@link CitationAugmentationType }
     * 
     */
    public CitationAugmentationType createCitationAugmentationType() {
        return new CitationAugmentationType();
    }

    /**
     * Create an instance of {@link DrivingIncidentType }
     * 
     */
    public DrivingIncidentType createDrivingIncidentType() {
        return new DrivingIncidentType();
    }

    /**
     * Create an instance of {@link ExtendedDataType }
     * 
     */
    public ExtendedDataType createExtendedDataType() {
        return new ExtendedDataType();
    }

    /**
     * Create an instance of {@link CaseEventType }
     * 
     */
    public CaseEventType createCaseEventType() {
        return new CaseEventType();
    }

    /**
     * Create an instance of {@link ProviderChargeType }
     * 
     */
    public ProviderChargeType createProviderChargeType() {
        return new ProviderChargeType();
    }

    /**
     * Create an instance of {@link DecedentPartyAssociationType }
     * 
     */
    public DecedentPartyAssociationType createDecedentPartyAssociationType() {
        return new DecedentPartyAssociationType();
    }

    /**
     * Create an instance of {@link PersonFilerType }
     * 
     */
    public PersonFilerType createPersonFilerType() {
        return new PersonFilerType();
    }

    /**
     * Create an instance of {@link CaseAbstractorType }
     * 
     */
    public CaseAbstractorType createCaseAbstractorType() {
        return new CaseAbstractorType();
    }

    /**
     * Create an instance of {@link OrganizationIdentificationType }
     * 
     */
    public OrganizationIdentificationType createOrganizationIdentificationType() {
        return new OrganizationIdentificationType();
    }

    /**
     * Create an instance of {@link RedactionIdentificationType }
     * 
     */
    public RedactionIdentificationType createRedactionIdentificationType() {
        return new RedactionIdentificationType();
    }

    /**
     * Create an instance of {@link CaseAugmentationType }
     * 
     */
    public CaseAugmentationType createCaseAugmentationType() {
        return new CaseAugmentationType();
    }

    /**
     * Create an instance of {@link tyler.ecf.extensions.common.DocumentType }
     * 
     */
    public tyler.ecf.extensions.common.DocumentType createDocumentType() {
        return new tyler.ecf.extensions.common.DocumentType();
    }

    /**
     * Create an instance of {@link ReviewedDocumentType }
     * 
     */
    public ReviewedDocumentType createReviewedDocumentType() {
        return new ReviewedDocumentType();
    }

    /**
     * Create an instance of {@link ServicePartyDataType }
     * 
     */
    public ServicePartyDataType createServicePartyDataType() {
        return new ServicePartyDataType();
    }

    /**
     * Create an instance of {@link HearingScheduleType }
     * 
     */
    public HearingScheduleType createHearingScheduleType() {
        return new HearingScheduleType();
    }

    /**
     * Create an instance of {@link DocumentOptionalServiceType }
     * 
     */
    public DocumentOptionalServiceType createDocumentOptionalServiceType() {
        return new DocumentOptionalServiceType();
    }

    /**
     * Create an instance of {@link ProcedureRemedyType }
     * 
     */
    public ProcedureRemedyType createProcedureRemedyType() {
        return new ProcedureRemedyType();
    }

    /**
     * Create an instance of {@link PaymentType }
     * 
     */
    public PaymentType createPaymentType() {
        return new PaymentType();
    }

    /**
     * Create an instance of {@link ServiceContactIdentificationType }
     * 
     */
    public ServiceContactIdentificationType createServiceContactIdentificationType() {
        return new ServiceContactIdentificationType();
    }

    /**
     * Create an instance of {@link CourtEventType }
     * 
     */
    public CourtEventType createCourtEventType() {
        return new CourtEventType();
    }

    /**
     * Create an instance of {@link DocumentAttachmentIdentificationType }
     * 
     */
    public DocumentAttachmentIdentificationType createDocumentAttachmentIdentificationType() {
        return new DocumentAttachmentIdentificationType();
    }

    /**
     * Create an instance of {@link FilingIdentificationType }
     * 
     */
    public FilingIdentificationType createFilingIdentificationType() {
        return new FilingIdentificationType();
    }

    /**
     * Create an instance of {@link PhysicalFeatureType }
     * 
     */
    public PhysicalFeatureType createPhysicalFeatureType() {
        return new PhysicalFeatureType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "TimeoutMinutes")
    public JAXBElement<Integer> createTimeoutMinutes(Integer value) {
        return new JAXBElement<Integer>(_TimeoutMinutes_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "TimeoutResetHour")
    public JAXBElement<XMLGregorianCalendar> createTimeoutResetHour(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_TimeoutResetHour_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DevelopmentPolicyParametersType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DevelopmentPolicyParametersType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DevelopmentPolicyParameters", substitutionHeadNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0", substitutionHeadName = "DevelopmentPolicyParameters")
    public JAXBElement<DevelopmentPolicyParametersType> createDevelopmentPolicyParameters(DevelopmentPolicyParametersType value) {
        return new JAXBElement<DevelopmentPolicyParametersType>(_DevelopmentPolicyParameters_QNAME, DevelopmentPolicyParametersType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CapabilityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CapabilityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "PersonCapability", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonCapability")
    public JAXBElement<CapabilityType> createPersonCapability(CapabilityType value) {
        return new JAXBElement<CapabilityType>(_PersonCapability_QNAME, CapabilityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "IAmThisUserIndicator")
    public JAXBElement<Boolean> createIAmThisUserIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IAmThisUserIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SplitAmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SplitAmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CourtSplitAmount")
    public JAXBElement<SplitAmountType> createCourtSplitAmount(SplitAmountType value) {
        return new JAXBElement<SplitAmountType>(_CourtSplitAmount_QNAME, SplitAmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SplitAmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SplitAmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "NonCourtSplitAmount")
    public JAXBElement<SplitAmountType> createNonCourtSplitAmount(SplitAmountType value) {
        return new JAXBElement<SplitAmountType>(_NonCourtSplitAmount_QNAME, SplitAmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeeSplitType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeeSplitType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FeeSplit")
    public JAXBElement<FeeSplitType> createFeeSplit(FeeSplitType value) {
        return new JAXBElement<FeeSplitType>(_FeeSplit_QNAME, FeeSplitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "PaymentInstructionID")
    public JAXBElement<TextType> createPaymentInstructionID(TextType value) {
        return new JAXBElement<TextType>(_PaymentInstructionID_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PartyServiceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PartyServiceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "PartyService")
    public JAXBElement<PartyServiceType> createPartyService(PartyServiceType value) {
        return new JAXBElement<PartyServiceType>(_PartyService_QNAME, PartyServiceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingAssociation")
    public JAXBElement<FilingAssociationType> createFilingAssociation(FilingAssociationType value) {
        return new JAXBElement<FilingAssociationType>(_FilingAssociation_QNAME, FilingAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "PartyReference")
    public JAXBElement<ReferenceType> createPartyReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_PartyReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingReference")
    public JAXBElement<ReferenceType> createFilingReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_FilingReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ServiceDate")
    public JAXBElement<DateType> createServiceDate(DateType value) {
        return new JAXBElement<DateType>(_ServiceDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilerInformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilerInformationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilerInformation")
    public JAXBElement<FilerInformationType> createFilerInformation(FilerInformationType value) {
        return new JAXBElement<FilerInformationType>(_FilerInformation_QNAME, FilerInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecipientInformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RecipientInformationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "RecipientInformation")
    public JAXBElement<RecipientInformationType> createRecipientInformation(RecipientInformationType value) {
        return new JAXBElement<RecipientInformationType>(_RecipientInformation_QNAME, RecipientInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitterInformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubmitterInformationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "SubmitterInformation")
    public JAXBElement<SubmitterInformationType> createSubmitterInformation(SubmitterInformationType value) {
        return new JAXBElement<SubmitterInformationType>(_SubmitterInformation_QNAME, SubmitterInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilerName")
    public JAXBElement<TextType> createFilerName(TextType value) {
        return new JAXBElement<TextType>(_FilerName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FirmName")
    public JAXBElement<TextType> createFirmName(TextType value) {
        return new JAXBElement<TextType>(_FirmName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "RecipientName")
    public JAXBElement<TextType> createRecipientName(TextType value) {
        return new JAXBElement<TextType>(_RecipientName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "RecipientFirmName")
    public JAXBElement<TextType> createRecipientFirmName(TextType value) {
        return new JAXBElement<TextType>(_RecipientFirmName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "SubmitterName")
    public JAXBElement<TextType> createSubmitterName(TextType value) {
        return new JAXBElement<TextType>(_SubmitterName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "SubmitterFirmName")
    public JAXBElement<TextType> createSubmitterFirmName(TextType value) {
        return new JAXBElement<TextType>(_SubmitterFirmName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StructuredAddressType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StructuredAddressType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseAddress")
    public JAXBElement<StructuredAddressType> createCaseAddress(StructuredAddressType value) {
        return new JAXBElement<StructuredAddressType>(_CaseAddress_QNAME, StructuredAddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgencyOperationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AgencyOperationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "AgencyOperation")
    public JAXBElement<AgencyOperationType> createAgencyOperation(AgencyOperationType value) {
        return new JAXBElement<AgencyOperationType>(_AgencyOperation_QNAME, AgencyOperationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AgencyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AgencyType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "Agency")
    public JAXBElement<AgencyType> createAgency(AgencyType value) {
        return new JAXBElement<AgencyType>(_Agency_QNAME, AgencyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "AgencyIdentification")
    public JAXBElement<IdentificationType> createAgencyIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_AgencyIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "WillFiledDate")
    public JAXBElement<DateType> createWillFiledDate(DateType value) {
        return new JAXBElement<DateType>(_WillFiledDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuestionAnswerType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QuestionAnswerType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "QuestionAnswer")
    public JAXBElement<QuestionAnswerType> createQuestionAnswer(QuestionAnswerType value) {
        return new JAXBElement<QuestionAnswerType>(_QuestionAnswer_QNAME, QuestionAnswerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "QuestionID")
    public JAXBElement<TextType> createQuestionID(TextType value) {
        return new JAXBElement<TextType>(_QuestionID_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "AnswerID")
    public JAXBElement<TextType> createAnswerID(TextType value) {
        return new JAXBElement<TextType>(_AnswerID_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "RegistrationNumber")
    public JAXBElement<TextType> createRegistrationNumber(TextType value) {
        return new JAXBElement<TextType>(_RegistrationNumber_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "RegistrationStateCode")
    public JAXBElement<ProperNameTextType> createRegistrationStateCode(ProperNameTextType value) {
        return new JAXBElement<ProperNameTextType>(_RegistrationStateCode_QNAME, ProperNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "VehicleTypeCode")
    public JAXBElement<TextType> createVehicleTypeCode(TextType value) {
        return new JAXBElement<TextType>(_VehicleTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GYear }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GYear }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ModelYear")
    public JAXBElement<GYear> createModelYear(GYear value) {
        return new JAXBElement<GYear>(_ModelYear_QNAME, GYear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CommercialVehicleIndicator")
    public JAXBElement<Boolean> createCommercialVehicleIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_CommercialVehicleIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "HazardousIndicator")
    public JAXBElement<Boolean> createHazardousIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_HazardousIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VehicleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VehicleType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "Vehicle", substitutionHeadNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", substitutionHeadName = "Vehicle")
    public JAXBElement<VehicleType> createVehicle(VehicleType value) {
        return new JAXBElement<VehicleType>(_Vehicle_QNAME, VehicleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CitationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CitationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CitationAugmentation")
    public JAXBElement<CitationAugmentationType> createCitationAugmentation(CitationAugmentationType value) {
        return new JAXBElement<CitationAugmentationType>(_CitationAugmentation_QNAME, CitationAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DrivingIncidentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DrivingIncidentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DrivingIncident")
    public JAXBElement<DrivingIncidentType> createDrivingIncident(DrivingIncidentType value) {
        return new JAXBElement<DrivingIncidentType>(_DrivingIncident_QNAME, DrivingIncidentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "LegalSpeedRate")
    public JAXBElement<MeasureType> createLegalSpeedRate(MeasureType value) {
        return new JAXBElement<MeasureType>(_LegalSpeedRate_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ActualSpeedRate")
    public JAXBElement<MeasureType> createActualSpeedRate(MeasureType value) {
        return new JAXBElement<MeasureType>(_ActualSpeedRate_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "JurisdictionCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "IdentificationJurisdiction")
    public JAXBElement<TextType> createJurisdictionCode(TextType value) {
        return new JAXBElement<TextType>(_JurisdictionCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExtendedDataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExtendedDataType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ExtendedData")
    public JAXBElement<ExtendedDataType> createExtendedData(ExtendedDataType value) {
        return new JAXBElement<ExtendedDataType>(_ExtendedData_QNAME, ExtendedDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseEventType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseEventType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseEvent", substitutionHeadNamespace = "urn:tyler:ecf:extensions:Common", substitutionHeadName = "ExtendedData")
    public JAXBElement<CaseEventType> createCaseEvent(CaseEventType value) {
        return new JAXBElement<CaseEventType>(_CaseEvent_QNAME, CaseEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingEvent")
    public JAXBElement<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType> createFilingEvent(oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType value) {
        return new JAXBElement<oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType>(_FilingEvent_QNAME, oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProviderChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProviderChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ProviderCharge")
    public JAXBElement<ProviderChargeType> createProviderCharge(ProviderChargeType value) {
        return new JAXBElement<ProviderChargeType>(_ProviderCharge_QNAME, ProviderChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "MotionTypeCode")
    public JAXBElement<TextType> createMotionTypeCode(TextType value) {
        return new JAXBElement<TextType>(_MotionTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DecedentPartyAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DecedentPartyAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DecedentPartyAssociation")
    public JAXBElement<DecedentPartyAssociationType> createDecedentPartyAssociation(DecedentPartyAssociationType value) {
        return new JAXBElement<DecedentPartyAssociationType>(_DecedentPartyAssociation_QNAME, DecedentPartyAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonFilerType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonFilerType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "EntityFiler", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<PersonFilerType> createEntityFiler(PersonFilerType value) {
        return new JAXBElement<PersonFilerType>(_EntityFiler_QNAME, PersonFilerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAbstractorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAbstractorType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseAbstractor", substitutionHeadNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", substitutionHeadName = "CaseParticipant")
    public JAXBElement<CaseAbstractorType> createCaseAbstractor(CaseAbstractorType value) {
        return new JAXBElement<CaseAbstractorType>(_CaseAbstractor_QNAME, CaseAbstractorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "AbstractorName")
    public JAXBElement<TextType> createAbstractorName(TextType value) {
        return new JAXBElement<TextType>(_AbstractorName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "Fees")
    public JAXBElement<AmountType> createFees(AmountType value) {
        return new JAXBElement<AmountType>(_Fees_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseTypeText")
    public JAXBElement<TextType> createCaseTypeText(TextType value) {
        return new JAXBElement<TextType>(_CaseTypeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilerTypeText")
    public JAXBElement<TextType> createFilerTypeText(TextType value) {
        return new JAXBElement<TextType>(_FilerTypeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseSubTypeText")
    public JAXBElement<TextType> createCaseSubTypeText(TextType value) {
        return new JAXBElement<TextType>(_CaseSubTypeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "Identification")
    public JAXBElement<IdentificationType> createIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_Identification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationIdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationIdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "OrganizationOtherIdentification", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "OrganizationIdentification")
    public JAXBElement<OrganizationIdentificationType> createOrganizationOtherIdentification(OrganizationIdentificationType value) {
        return new JAXBElement<OrganizationIdentificationType>(_OrganizationOtherIdentification_QNAME, OrganizationIdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "AttachServiceContactIndicator")
    public JAXBElement<Boolean> createAttachServiceContactIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_AttachServiceContactIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "LowerCourtText")
    public JAXBElement<TextType> createLowerCourtText(TextType value) {
        return new JAXBElement<TextType>(_LowerCourtText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "LowerCourtJudgeText")
    public JAXBElement<TextType> createLowerCourtJudgeText(TextType value) {
        return new JAXBElement<TextType>(_LowerCourtJudgeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "LowerCourtCaseTypeText")
    public JAXBElement<TextType> createLowerCourtCaseTypeText(TextType value) {
        return new JAXBElement<TextType>(_LowerCourtCaseTypeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "RedactionID")
    public JAXBElement<TextType> createRedactionID(TextType value) {
        return new JAXBElement<TextType>(_RedactionID_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "AttachmentReference")
    public JAXBElement<ReferenceType> createAttachmentReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_AttachmentReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RedactionIdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RedactionIdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "RedactionIdentification")
    public JAXBElement<RedactionIdentificationType> createRedactionIdentification(RedactionIdentificationType value) {
        return new JAXBElement<RedactionIdentificationType>(_RedactionIdentification_QNAME, RedactionIdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "PropertyAccountNumber")
    public JAXBElement<TextType> createPropertyAccountNumber(TextType value) {
        return new JAXBElement<TextType>(_PropertyAccountNumber_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "AccountNumber")
    public JAXBElement<TextType> createAccountNumber(TextType value) {
        return new JAXBElement<TextType>(_AccountNumber_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseAugmentation", substitutionHeadNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", substitutionHeadName = "CaseAugmentation")
    public JAXBElement<CaseAugmentationType> createCaseAugmentation(CaseAugmentationType value) {
        return new JAXBElement<CaseAugmentationType>(_CaseAugmentation_QNAME, CaseAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingLeadDocument", substitutionHeadNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", substitutionHeadName = "FilingLeadDocument")
    public JAXBElement<tyler.ecf.extensions.common.DocumentType> createFilingLeadDocument(tyler.ecf.extensions.common.DocumentType value) {
        return new JAXBElement<tyler.ecf.extensions.common.DocumentType>(_FilingLeadDocument_QNAME, tyler.ecf.extensions.common.DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingConnectedDocument", substitutionHeadNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CoreFilingMessage-4.0", substitutionHeadName = "FilingConnectedDocument")
    public JAXBElement<tyler.ecf.extensions.common.DocumentType> createFilingConnectedDocument(tyler.ecf.extensions.common.DocumentType value) {
        return new JAXBElement<tyler.ecf.extensions.common.DocumentType>(_FilingConnectedDocument_QNAME, tyler.ecf.extensions.common.DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReviewedDocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReviewedDocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ReviewedLeadDocument", substitutionHeadNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", substitutionHeadName = "ReviewedLeadDocument")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ReviewedConnectedDocument", substitutionHeadNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", substitutionHeadName = "ReviewedConnectedDocument")
    public JAXBElement<ReviewedDocumentType> createReviewedConnectedDocument(ReviewedDocumentType value) {
        return new JAXBElement<ReviewedDocumentType>(_ReviewedConnectedDocument_QNAME, ReviewedDocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "Document", substitutionHeadNamespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", substitutionHeadName = "Document")
    public JAXBElement<tyler.ecf.extensions.common.DocumentType> createDocument(tyler.ecf.extensions.common.DocumentType value) {
        return new JAXBElement<tyler.ecf.extensions.common.DocumentType>(_Document_QNAME, tyler.ecf.extensions.common.DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DocumentReviewer")
    public JAXBElement<EntityType> createDocumentReviewer(EntityType value) {
        return new JAXBElement<EntityType>(_DocumentReviewer_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DocumentReviewDate")
    public JAXBElement<DateType> createDocumentReviewDate(DateType value) {
        return new JAXBElement<DateType>(_DocumentReviewDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingReviewCommentsText")
    public JAXBElement<TextType> createFilingReviewCommentsText(TextType value) {
        return new JAXBElement<TextType>(_FilingReviewCommentsText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "RejectReasonText")
    public JAXBElement<TextType> createRejectReasonText(TextType value) {
        return new JAXBElement<TextType>(_RejectReasonText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "WaiverIndicator")
    public JAXBElement<Boolean> createWaiverIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_WaiverIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "MaxFeeAmount")
    public JAXBElement<AmountType> createMaxFeeAmount(AmountType value) {
        return new JAXBElement<AmountType>(_MaxFeeAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ReturnDate")
    public JAXBElement<DateType> createReturnDate(DateType value) {
        return new JAXBElement<DateType>(_ReturnDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "OutOfStateIndicator")
    public JAXBElement<Boolean> createOutOfStateIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_OutOfStateIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ScheduleDayStartTime")
    public JAXBElement<DateType> createScheduleDayStartTime(DateType value) {
        return new JAXBElement<DateType>(_ScheduleDayStartTime_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ScheduleDayEndTime")
    public JAXBElement<DateType> createScheduleDayEndTime(DateType value) {
        return new JAXBElement<DateType>(_ScheduleDayEndTime_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CourtRoom")
    public JAXBElement<TextType> createCourtRoom(TextType value) {
        return new JAXBElement<TextType>(_CourtRoom_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CourtStreet")
    public JAXBElement<TextType> createCourtStreet(TextType value) {
        return new JAXBElement<TextType>(_CourtStreet_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CourtCityStateZip")
    public JAXBElement<TextType> createCourtCityStateZip(TextType value) {
        return new JAXBElement<TextType>(_CourtCityStateZip_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ServiceReference")
    public JAXBElement<ReferenceType> createServiceReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_ServiceReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServicePartyDataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServicePartyDataType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ServicePartyReference", substitutionHeadNamespace = "urn:tyler:ecf:extensions:Common", substitutionHeadName = "ExtendedData")
    public JAXBElement<ServicePartyDataType> createServicePartyReference(ServicePartyDataType value) {
        return new JAXBElement<ServicePartyDataType>(_ServicePartyReference_QNAME, ServicePartyDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HearingScheduleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HearingScheduleType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "HearingSchedule")
    public JAXBElement<HearingScheduleType> createHearingSchedule(HearingScheduleType value) {
        return new JAXBElement<HearingScheduleType>(_HearingSchedule_QNAME, HearingScheduleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CourtesyCopiesText")
    public JAXBElement<TextType> createCourtesyCopiesText(TextType value) {
        return new JAXBElement<TextType>(_CourtesyCopiesText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "PreliminaryCopiesText")
    public JAXBElement<TextType> createPreliminaryCopiesText(TextType value) {
        return new JAXBElement<TextType>(_PreliminaryCopiesText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "Multiplier")
    public JAXBElement<Decimal> createMultiplier(Decimal value) {
        return new JAXBElement<Decimal>(_Multiplier_QNAME, Decimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FeeAmount")
    public JAXBElement<Decimal> createFeeAmount(Decimal value) {
        return new JAXBElement<Decimal>(_FeeAmount_QNAME, Decimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentOptionalServiceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentOptionalServiceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DocumentOptionalService")
    public JAXBElement<DocumentOptionalServiceType> createDocumentOptionalService(DocumentOptionalServiceType value) {
        return new JAXBElement<DocumentOptionalServiceType>(_DocumentOptionalService_QNAME, DocumentOptionalServiceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingCommentsText")
    public JAXBElement<TextType> createFilingCommentsText(TextType value) {
        return new JAXBElement<TextType>(_FilingCommentsText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "RemedyCode")
    public JAXBElement<TextType> createRemedyCode(TextType value) {
        return new JAXBElement<TextType>(_RemedyCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DamageAmountCode")
    public JAXBElement<TextType> createDamageAmountCode(TextType value) {
        return new JAXBElement<TextType>(_DamageAmountCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProcedureRemedyType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProcedureRemedyType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ProcedureRemedy")
    public JAXBElement<ProcedureRemedyType> createProcedureRemedy(ProcedureRemedyType value) {
        return new JAXBElement<ProcedureRemedyType>(_ProcedureRemedy_QNAME, ProcedureRemedyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CivilClaimAmount")
    public JAXBElement<AmountType> createCivilClaimAmount(AmountType value) {
        return new JAXBElement<AmountType>(_CivilClaimAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ProbateEstateAmount")
    public JAXBElement<AmountType> createProbateEstateAmount(AmountType value) {
        return new JAXBElement<AmountType>(_ProbateEstateAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseTitle", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DocumentCategoryText")
    public JAXBElement<TextType> createCaseTitle(TextType value) {
        return new JAXBElement<TextType>(_CaseTitle_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseNumber", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DocumentCategoryText")
    public JAXBElement<TextType> createCaseNumber(TextType value) {
        return new JAXBElement<TextType>(_CaseNumber_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingType", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DocumentCategoryText")
    public JAXBElement<TextType> createFilingType(TextType value) {
        return new JAXBElement<TextType>(_FilingType_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingAttorney", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DocumentCategoryText")
    public JAXBElement<TextType> createFilingAttorney(TextType value) {
        return new JAXBElement<TextType>(_FilingAttorney_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DocumentCategoryText")
    public JAXBElement<TextType> createFilingCode(TextType value) {
        return new JAXBElement<TextType>(_FilingCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "OrganizationIdentificationID", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DocumentCategoryText")
    public JAXBElement<TextType> createOrganizationIdentificationID(TextType value) {
        return new JAXBElement<TextType>(_OrganizationIdentificationID_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseCategoryCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DocumentCategoryText")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseTypeCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DocumentCategoryText")
    public JAXBElement<TextType> createCaseTypeCode(TextType value) {
        return new JAXBElement<TextType>(_CaseTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseJudge", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DocumentCategoryText")
    public JAXBElement<TextType> createCaseJudge(TextType value) {
        return new JAXBElement<TextType>(_CaseJudge_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PaymentType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "Payment")
    public JAXBElement<PaymentType> createPayment(PaymentType value) {
        return new JAXBElement<PaymentType>(_Payment_QNAME, PaymentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "AccountName")
    public JAXBElement<java.lang.String> createAccountName(java.lang.String value) {
        return new JAXBElement<java.lang.String>(_AccountName_QNAME, java.lang.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CardType")
    public JAXBElement<java.lang.String> createCardType(java.lang.String value) {
        return new JAXBElement<java.lang.String>(_CardType_QNAME, java.lang.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "Last4Digits")
    public JAXBElement<java.lang.String> createLast4Digits(java.lang.String value) {
        return new JAXBElement<java.lang.String>(_Last4Digits_QNAME, java.lang.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ExpirationMonth")
    public JAXBElement<Integer> createExpirationMonth(Integer value) {
        return new JAXBElement<Integer>(_ExpirationMonth_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ExpirationYear")
    public JAXBElement<Integer> createExpirationYear(Integer value) {
        return new JAXBElement<Integer>(_ExpirationYear_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "TransactionAmount")
    public JAXBElement<AmountType> createTransactionAmount(AmountType value) {
        return new JAXBElement<AmountType>(_TransactionAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "TransactionResponse")
    public JAXBElement<java.lang.String> createTransactionResponse(java.lang.String value) {
        return new JAXBElement<java.lang.String>(_TransactionResponse_QNAME, java.lang.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "TransactionID")
    public JAXBElement<java.lang.String> createTransactionID(java.lang.String value) {
        return new JAXBElement<java.lang.String>(_TransactionID_QNAME, java.lang.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link java.lang.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "OrderID")
    public JAXBElement<java.lang.String> createOrderID(java.lang.String value) {
        return new JAXBElement<java.lang.String>(_OrderID_QNAME, java.lang.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceContactIdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceContactIdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "ServiceContactIdentification")
    public JAXBElement<ServiceContactIdentificationType> createServiceContactIdentification(ServiceContactIdentificationType value) {
        return new JAXBElement<ServiceContactIdentificationType>(_ServiceContactIdentification_QNAME, ServiceContactIdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link gov.niem.niem.proxy.xsd._2.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link gov.niem.niem.proxy.xsd._2.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DocumentID")
    public JAXBElement<gov.niem.niem.proxy.xsd._2.String> createDocumentID(gov.niem.niem.proxy.xsd._2.String value) {
        return new JAXBElement<gov.niem.niem.proxy.xsd._2.String>(_DocumentID_QNAME, gov.niem.niem.proxy.xsd._2.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link gov.niem.niem.proxy.xsd._2.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link gov.niem.niem.proxy.xsd._2.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CMSID")
    public JAXBElement<gov.niem.niem.proxy.xsd._2.String> createCMSID(gov.niem.niem.proxy.xsd._2.String value) {
        return new JAXBElement<gov.niem.niem.proxy.xsd._2.String>(_CMSID_QNAME, gov.niem.niem.proxy.xsd._2.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link gov.niem.niem.proxy.xsd._2.String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link gov.niem.niem.proxy.xsd._2.String }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingID")
    public JAXBElement<gov.niem.niem.proxy.xsd._2.String> createFilingID(gov.niem.niem.proxy.xsd._2.String value) {
        return new JAXBElement<gov.niem.niem.proxy.xsd._2.String>(_FilingID_QNAME, gov.niem.niem.proxy.xsd._2.String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DocumentAttachmentReference")
    public JAXBElement<ReferenceType> createDocumentAttachmentReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_DocumentAttachmentReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingIdentificationReference")
    public JAXBElement<ReferenceType> createFilingIdentificationReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_FilingIdentificationReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CourtEvent")
    public JAXBElement<CourtEventType> createCourtEvent(CourtEventType value) {
        return new JAXBElement<CourtEventType>(_CourtEvent_QNAME, CourtEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentAttachmentIdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentAttachmentIdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DocumentAttachmentIdentification")
    public JAXBElement<DocumentAttachmentIdentificationType> createDocumentAttachmentIdentification(DocumentAttachmentIdentificationType value) {
        return new JAXBElement<DocumentAttachmentIdentificationType>(_DocumentAttachmentIdentification_QNAME, DocumentAttachmentIdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingIdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingIdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingIdentification")
    public JAXBElement<FilingIdentificationType> createFilingIdentification(FilingIdentificationType value) {
        return new JAXBElement<FilingIdentificationType>(_FilingIdentification_QNAME, FilingIdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingTypeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingTypeType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingAction")
    public JAXBElement<FilingTypeType> createFilingAction(FilingTypeType value) {
        return new JAXBElement<FilingTypeType>(_FilingAction_QNAME, FilingTypeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "TrackingNumber")
    public JAXBElement<TextType> createTrackingNumber(TextType value) {
        return new JAXBElement<TextType>(_TrackingNumber_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "MailServiceIndicator")
    public JAXBElement<Boolean> createMailServiceIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_MailServiceIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseSecurityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseSecurityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "CaseSecurity")
    public JAXBElement<CaseSecurityType> createCaseSecurity(CaseSecurityType value) {
        return new JAXBElement<CaseSecurityType>(_CaseSecurity_QNAME, CaseSecurityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "PhysicalFeatureDescriptionText")
    public JAXBElement<TextType> createPhysicalFeatureDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_PhysicalFeatureDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "PhysicalFeatureReference")
    public JAXBElement<ReferenceType> createPhysicalFeatureReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_PhysicalFeatureReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhysicalFeatureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PhysicalFeatureType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "PhysicalFeature")
    public JAXBElement<PhysicalFeatureType> createPhysicalFeature(PhysicalFeatureType value) {
        return new JAXBElement<PhysicalFeatureType>(_PhysicalFeature_QNAME, PhysicalFeatureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "PageCount", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "BinarySizeValue")
    public JAXBElement<NonNegativeDecimalType> createPageCount(NonNegativeDecimalType value) {
        return new JAXBElement<NonNegativeDecimalType>(_PageCount_QNAME, NonNegativeDecimalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentSecurityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentSecurityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "DocumentSecurity")
    public JAXBElement<DocumentSecurityType> createDocumentSecurity(DocumentSecurityType value) {
        return new JAXBElement<DocumentSecurityType>(_DocumentSecurity_QNAME, DocumentSecurityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Common", name = "FilingAssociationParty")
    public JAXBElement<IdentificationType> createFilingAssociationParty(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_FilingAssociationParty_QNAME, IdentificationType.class, null, value);
    }

}
