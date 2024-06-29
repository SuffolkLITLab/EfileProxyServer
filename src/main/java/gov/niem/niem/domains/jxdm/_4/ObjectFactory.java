
package gov.niem.niem.domains.jxdm._4;

import javax.xml.namespace.QName;
import gov.niem.niem.ansi_d20._2.AccidentSeverityCodeType;
import gov.niem.niem.ansi_d20._2.HazMatCodeType;
import gov.niem.niem.fbi._2.EXLCodeType;
import gov.niem.niem.fbi._2.LISCodeType;
import gov.niem.niem.fbi._2.LSTACodeType;
import gov.niem.niem.fbi._2.OFFCodeType;
import gov.niem.niem.niem_core._2.BiometricType;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.DriverLicenseAssociationType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.IncidentType;
import gov.niem.niem.niem_core._2.ItemValueType;
import gov.niem.niem.niem_core._2.JurisdictionType;
import gov.niem.niem.niem_core._2.LocationType;
import gov.niem.niem.niem_core._2.MeasureType;
import gov.niem.niem.niem_core._2.OrganizationType;
import gov.niem.niem.niem_core._2.ScheduleDayType;
import gov.niem.niem.niem_core._2.StatusType;
import gov.niem.niem.niem_core._2.SupervisionType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.proxy.xsd._2.Duration;
import gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.niem.niem.domains.jxdm._4 package. 
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

    private final static QName _ActivityLocationAssociation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ActivityLocationAssociation");
    private final static QName _AppellateCase_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "AppellateCase");
    private final static QName _AppellateCaseNotice_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "AppellateCaseNotice");
    private final static QName _AppellateCaseNoticeReasonText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "AppellateCaseNoticeReasonText");
    private final static QName _AppellateCaseOriginalCase_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "AppellateCaseOriginalCase");
    private final static QName _Arrest_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "Arrest");
    private final static QName _ArrestAgency_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ArrestAgency");
    private final static QName _ArrestAgencyRecordIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ArrestAgencyRecordIdentification");
    private final static QName _ArrestBailRecommendationText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ArrestBailRecommendationText");
    private final static QName _ArrestBloodAlcoholContentNumberText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ArrestBloodAlcoholContentNumberText");
    private final static QName _ArrestCharge_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ArrestCharge");
    private final static QName _ArrestLocation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ArrestLocation");
    private final static QName _ArrestOfficial_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ArrestOfficial");
    private final static QName _ArrestSubject_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ArrestSubject");
    private final static QName _ArrestWarrant_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ArrestWarrant");
    private final static QName _Booking_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "Booking");
    private final static QName _BookingAgencyRecordIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "BookingAgencyRecordIdentification");
    private final static QName _CaseAugmentation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseAugmentation");
    private final static QName _CaseCharge_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseCharge");
    private final static QName _CaseCourt_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseCourt");
    private final static QName _CaseCourtEvent_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseCourtEvent");
    private final static QName _CaseDefendantParty_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseDefendantParty");
    private final static QName _CaseDefenseAttorney_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseDefenseAttorney");
    private final static QName _CaseInitiatingAttorney_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseInitiatingAttorney");
    private final static QName _CaseInitiatingParty_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseInitiatingParty");
    private final static QName _CaseJudge_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseJudge");
    private final static QName _CaseLineageCase_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseLineageCase");
    private final static QName _CaseOfficial_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseOfficial");
    private final static QName _CaseOfficialCaseIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseOfficialCaseIdentification");
    private final static QName _CaseOfficialRoleText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseOfficialRoleText");
    private final static QName _CaseOtherEntity_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseOtherEntity");
    private final static QName _CaseProsecutionAttorney_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseProsecutionAttorney");
    private final static QName _CaseRespondentAttorney_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseRespondentAttorney");
    private final static QName _CaseRespondentParty_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CaseRespondentParty");
    private final static QName _ChargeReference_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeReference");
    private final static QName _Charge_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "Charge");
    private final static QName _ChargeApplicabilityText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeApplicabilityText");
    private final static QName _ChargeDegreeText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeDegreeText");
    private final static QName _ChargeDescriptionText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeDescriptionText");
    private final static QName _ChargeDisposition_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeDisposition");
    private final static QName _ChargeEnhancingAllegationCharge_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeEnhancingAllegationCharge");
    private final static QName _ChargeNCICCode_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeNCICCode");
    private final static QName _ChargeQualifierText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeQualifierText");
    private final static QName _ChargeSequenceID_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeSequenceID");
    private final static QName _ChargeSeverityLevel_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeSeverityLevel");
    private final static QName _ChargeSpecialAllegationText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeSpecialAllegationText");
    private final static QName _ChargeStatute_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ChargeStatute");
    private final static QName _Citation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "Citation");
    private final static QName _CitationAgency_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CitationAgency");
    private final static QName _CitationDismissalConditionIndicator_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CitationDismissalConditionIndicator");
    private final static QName _CitationIssuingOfficial_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CitationIssuingOfficial");
    private final static QName _CitationSubject_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CitationSubject");
    private final static QName _CitationViolation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CitationViolation");
    private final static QName _CourtReference_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CourtReference");
    private final static QName _CourtAppearance_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CourtAppearance");
    private final static QName _CourtAppearanceDate_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CourtAppearanceDate");
    private final static QName _CourtEvent_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CourtEvent");
    private final static QName _CourtEventJudge_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CourtEventJudge");
    private final static QName _CourtEventSchedule_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CourtEventSchedule");
    private final static QName _CourtEventSequenceID_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CourtEventSequenceID");
    private final static QName _CourtName_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CourtName");
    private final static QName _CourtOrder_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CourtOrder");
    private final static QName _CourtOrderStatus_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "CourtOrderStatus");
    private final static QName _DocumentCourtAssociation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DocumentCourtAssociation");
    private final static QName _DrivingAccidentSeverity_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingAccidentSeverity");
    private final static QName _DrivingAccidentSeverityCode_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingAccidentSeverityCode");
    private final static QName _DrivingIncident_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingIncident");
    private final static QName _DrivingIncidentHazMat_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingIncidentHazMat");
    private final static QName _DrivingIncidentHazMatCode_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingIncidentHazMatCode");
    private final static QName _DrivingIncidentLaserDetectionIndicator_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingIncidentLaserDetectionIndicator");
    private final static QName _DrivingIncidentLegalSpeedRate_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingIncidentLegalSpeedRate");
    private final static QName _DrivingIncidentPassengerQuantityText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingIncidentPassengerQuantityText");
    private final static QName _DrivingIncidentRadarDetectionIndicator_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingIncidentRadarDetectionIndicator");
    private final static QName _DrivingIncidentRecordedSpeedRate_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingIncidentRecordedSpeedRate");
    private final static QName _DrivingJurisdictionAuthorityNCICLSTACode_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "DrivingJurisdictionAuthorityNCICLSTACode");
    private final static QName _EnforcementOfficialBadgeIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "EnforcementOfficialBadgeIdentification");
    private final static QName _EnforcementOfficialUnavailableSchedule_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "EnforcementOfficialUnavailableSchedule");
    private final static QName _EnforcementOfficialUnit_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "EnforcementOfficialUnit");
    private final static QName _EnforcementUnitName_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "EnforcementUnitName");
    private final static QName _IdentificationJurisdictionNCICLISCode_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "IdentificationJurisdictionNCICLISCode");
    private final static QName _IncidentAugmentation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "IncidentAugmentation");
    private final static QName _IncidentDamagedPropertyReference_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "IncidentDamagedPropertyReference");
    private final static QName _IncidentOfficialPresentIndicator_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "IncidentOfficialPresentIndicator");
    private final static QName _IncidentTrafficAccidentInvolvedIndicator_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "IncidentTrafficAccidentInvolvedIndicator");
    private final static QName _JudicialOfficialBarIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "JudicialOfficialBarIdentification");
    private final static QName _JudicialOfficialBarMembership_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "JudicialOfficialBarMembership");
    private final static QName _Offense_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "Offense");
    private final static QName _OrganizationAugmentation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "OrganizationAugmentation");
    private final static QName _OrganizationORIIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "OrganizationORIIdentification");
    private final static QName _PersonAFISIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "PersonAFISIdentification");
    private final static QName _PersonAugmentation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "PersonAugmentation");
    private final static QName _PersonChargeAssociation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "PersonChargeAssociation");
    private final static QName _PersonDriverLicenseAssociation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "PersonDriverLicenseAssociation");
    private final static QName _PersonFBIIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "PersonFBIIdentification");
    private final static QName _PersonPalmPrint_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "PersonPalmPrint");
    private final static QName _PersonStateFingerprintIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "PersonStateFingerprintIdentification");
    private final static QName _PropertyAugmentation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "PropertyAugmentation");
    private final static QName _PropertyTotalDamageValue_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "PropertyTotalDamageValue");
    private final static QName _RegisterActionDescriptionText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "RegisterActionDescriptionText");
    private final static QName _RegisteredOffenderIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "RegisteredOffenderIdentification");
    private final static QName _RegisteredSexOffender_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "RegisteredSexOffender");
    private final static QName _Sentence_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "Sentence");
    private final static QName _SentenceCharge_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "SentenceCharge");
    private final static QName _SentenceDescriptionText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "SentenceDescriptionText");
    private final static QName _SentenceTerm_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "SentenceTerm");
    private final static QName _SeverityLevelDescriptionText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "SeverityLevelDescriptionText");
    private final static QName _SeverityLevelIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "SeverityLevelIdentification");
    private final static QName _StatuteReference_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "StatuteReference");
    private final static QName _Statute_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "Statute");
    private final static QName _StatuteCodeIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "StatuteCodeIdentification");
    private final static QName _StatuteCodeSectionIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "StatuteCodeSectionIdentification");
    private final static QName _StatuteDescriptionText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "StatuteDescriptionText");
    private final static QName _StatuteJurisdiction_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "StatuteJurisdiction");
    private final static QName _StatuteLevelText_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "StatuteLevelText");
    private final static QName _StatuteOffenseIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "StatuteOffenseIdentification");
    private final static QName _SubjectReference_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "SubjectReference");
    private final static QName _Subject_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "Subject");
    private final static QName _SubjectIdentification_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "SubjectIdentification");
    private final static QName _SubjectSupervision_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "SubjectSupervision");
    private final static QName _Term_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "Term");
    private final static QName _TermDuration_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "TermDuration");
    private final static QName _VictimReference_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "VictimReference");
    private final static QName _ViolatedStatuteAssociation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "ViolatedStatuteAssociation");
    private final static QName _WarrantExtraditionLimitation_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "WarrantExtraditionLimitation");
    private final static QName _WarrantExtraditionLimitationCode_QNAME = new QName("http://niem.gov/niem/domains/jxdm/4.0", "WarrantExtraditionLimitationCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.niem.niem.domains.jxdm._4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ActivityLocationAssociationType }
     * 
     */
    public ActivityLocationAssociationType createActivityLocationAssociationType() {
        return new ActivityLocationAssociationType();
    }

    /**
     * Create an instance of {@link AppellateCaseType }
     * 
     */
    public AppellateCaseType createAppellateCaseType() {
        return new AppellateCaseType();
    }

    /**
     * Create an instance of {@link AppellateCaseNoticeType }
     * 
     */
    public AppellateCaseNoticeType createAppellateCaseNoticeType() {
        return new AppellateCaseNoticeType();
    }

    /**
     * Create an instance of {@link ArrestType }
     * 
     */
    public ArrestType createArrestType() {
        return new ArrestType();
    }

    /**
     * Create an instance of {@link ChargeType }
     * 
     */
    public ChargeType createChargeType() {
        return new ChargeType();
    }

    /**
     * Create an instance of {@link EnforcementOfficialType }
     * 
     */
    public EnforcementOfficialType createEnforcementOfficialType() {
        return new EnforcementOfficialType();
    }

    /**
     * Create an instance of {@link SubjectType }
     * 
     */
    public SubjectType createSubjectType() {
        return new SubjectType();
    }

    /**
     * Create an instance of {@link WarrantType }
     * 
     */
    public WarrantType createWarrantType() {
        return new WarrantType();
    }

    /**
     * Create an instance of {@link BookingType }
     * 
     */
    public BookingType createBookingType() {
        return new BookingType();
    }

    /**
     * Create an instance of {@link CaseAugmentationType }
     * 
     */
    public CaseAugmentationType createCaseAugmentationType() {
        return new CaseAugmentationType();
    }

    /**
     * Create an instance of {@link CourtType }
     * 
     */
    public CourtType createCourtType() {
        return new CourtType();
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
     * Create an instance of {@link ChargeDispositionType }
     * 
     */
    public ChargeDispositionType createChargeDispositionType() {
        return new ChargeDispositionType();
    }

    /**
     * Create an instance of {@link SeverityLevelType }
     * 
     */
    public SeverityLevelType createSeverityLevelType() {
        return new SeverityLevelType();
    }

    /**
     * Create an instance of {@link StatuteType }
     * 
     */
    public StatuteType createStatuteType() {
        return new StatuteType();
    }

    /**
     * Create an instance of {@link CitationType }
     * 
     */
    public CitationType createCitationType() {
        return new CitationType();
    }

    /**
     * Create an instance of {@link CourtAppearanceType }
     * 
     */
    public CourtAppearanceType createCourtAppearanceType() {
        return new CourtAppearanceType();
    }

    /**
     * Create an instance of {@link JudicialOfficialType }
     * 
     */
    public JudicialOfficialType createJudicialOfficialType() {
        return new JudicialOfficialType();
    }

    /**
     * Create an instance of {@link CourtOrderType }
     * 
     */
    public CourtOrderType createCourtOrderType() {
        return new CourtOrderType();
    }

    /**
     * Create an instance of {@link DocumentCourtAssociationType }
     * 
     */
    public DocumentCourtAssociationType createDocumentCourtAssociationType() {
        return new DocumentCourtAssociationType();
    }

    /**
     * Create an instance of {@link DrivingIncidentType }
     * 
     */
    public DrivingIncidentType createDrivingIncidentType() {
        return new DrivingIncidentType();
    }

    /**
     * Create an instance of {@link EnforcementUnitType }
     * 
     */
    public EnforcementUnitType createEnforcementUnitType() {
        return new EnforcementUnitType();
    }

    /**
     * Create an instance of {@link IncidentAugmentationType }
     * 
     */
    public IncidentAugmentationType createIncidentAugmentationType() {
        return new IncidentAugmentationType();
    }

    /**
     * Create an instance of {@link JudicialOfficialBarMembershipType }
     * 
     */
    public JudicialOfficialBarMembershipType createJudicialOfficialBarMembershipType() {
        return new JudicialOfficialBarMembershipType();
    }

    /**
     * Create an instance of {@link OrganizationAugmentationType }
     * 
     */
    public OrganizationAugmentationType createOrganizationAugmentationType() {
        return new OrganizationAugmentationType();
    }

    /**
     * Create an instance of {@link PersonAugmentationType }
     * 
     */
    public PersonAugmentationType createPersonAugmentationType() {
        return new PersonAugmentationType();
    }

    /**
     * Create an instance of {@link PersonChargeAssociationType }
     * 
     */
    public PersonChargeAssociationType createPersonChargeAssociationType() {
        return new PersonChargeAssociationType();
    }

    /**
     * Create an instance of {@link PropertyAugmentationType }
     * 
     */
    public PropertyAugmentationType createPropertyAugmentationType() {
        return new PropertyAugmentationType();
    }

    /**
     * Create an instance of {@link RegisteredOffenderType }
     * 
     */
    public RegisteredOffenderType createRegisteredOffenderType() {
        return new RegisteredOffenderType();
    }

    /**
     * Create an instance of {@link SentenceType }
     * 
     */
    public SentenceType createSentenceType() {
        return new SentenceType();
    }

    /**
     * Create an instance of {@link TermType }
     * 
     */
    public TermType createTermType() {
        return new TermType();
    }

    /**
     * Create an instance of {@link ViolatedStatuteAssociationType }
     * 
     */
    public ViolatedStatuteAssociationType createViolatedStatuteAssociationType() {
        return new ViolatedStatuteAssociationType();
    }

    /**
     * Create an instance of {@link VictimType }
     * 
     */
    public VictimType createVictimType() {
        return new VictimType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityLocationAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActivityLocationAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ActivityLocationAssociation")
    public JAXBElement<ActivityLocationAssociationType> createActivityLocationAssociation(ActivityLocationAssociationType value) {
        return new JAXBElement<ActivityLocationAssociationType>(_ActivityLocationAssociation_QNAME, ActivityLocationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "AppellateCase")
    public JAXBElement<AppellateCaseType> createAppellateCase(AppellateCaseType value) {
        return new JAXBElement<AppellateCaseType>(_AppellateCase_QNAME, AppellateCaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppellateCaseNoticeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppellateCaseNoticeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "AppellateCaseNotice")
    public JAXBElement<AppellateCaseNoticeType> createAppellateCaseNotice(AppellateCaseNoticeType value) {
        return new JAXBElement<AppellateCaseNoticeType>(_AppellateCaseNotice_QNAME, AppellateCaseNoticeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "AppellateCaseNoticeReasonText")
    public JAXBElement<TextType> createAppellateCaseNoticeReasonText(TextType value) {
        return new JAXBElement<TextType>(_AppellateCaseNoticeReasonText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "AppellateCaseOriginalCase")
    public JAXBElement<CaseType> createAppellateCaseOriginalCase(CaseType value) {
        return new JAXBElement<CaseType>(_AppellateCaseOriginalCase_QNAME, CaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrestType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "Arrest")
    public JAXBElement<ArrestType> createArrest(ArrestType value) {
        return new JAXBElement<ArrestType>(_Arrest_QNAME, ArrestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ArrestAgency")
    public JAXBElement<OrganizationType> createArrestAgency(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_ArrestAgency_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ArrestAgencyRecordIdentification")
    public JAXBElement<IdentificationType> createArrestAgencyRecordIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ArrestAgencyRecordIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ArrestBailRecommendationText")
    public JAXBElement<TextType> createArrestBailRecommendationText(TextType value) {
        return new JAXBElement<TextType>(_ArrestBailRecommendationText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ArrestBloodAlcoholContentNumberText")
    public JAXBElement<TextType> createArrestBloodAlcoholContentNumberText(TextType value) {
        return new JAXBElement<TextType>(_ArrestBloodAlcoholContentNumberText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ArrestCharge")
    public JAXBElement<ChargeType> createArrestCharge(ChargeType value) {
        return new JAXBElement<ChargeType>(_ArrestCharge_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ArrestLocation")
    public JAXBElement<LocationType> createArrestLocation(LocationType value) {
        return new JAXBElement<LocationType>(_ArrestLocation_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnforcementOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnforcementOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ArrestOfficial")
    public JAXBElement<EnforcementOfficialType> createArrestOfficial(EnforcementOfficialType value) {
        return new JAXBElement<EnforcementOfficialType>(_ArrestOfficial_QNAME, EnforcementOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ArrestSubject")
    public JAXBElement<SubjectType> createArrestSubject(SubjectType value) {
        return new JAXBElement<SubjectType>(_ArrestSubject_QNAME, SubjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WarrantType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WarrantType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ArrestWarrant")
    public JAXBElement<WarrantType> createArrestWarrant(WarrantType value) {
        return new JAXBElement<WarrantType>(_ArrestWarrant_QNAME, WarrantType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BookingType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "Booking")
    public JAXBElement<BookingType> createBooking(BookingType value) {
        return new JAXBElement<BookingType>(_Booking_QNAME, BookingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "BookingAgencyRecordIdentification")
    public JAXBElement<IdentificationType> createBookingAgencyRecordIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_BookingAgencyRecordIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseAugmentation", substitutionHeadNamespace = "http://niem.gov/niem/structures/2.0", substitutionHeadName = "Augmentation")
    public JAXBElement<CaseAugmentationType> createCaseAugmentation(CaseAugmentationType value) {
        return new JAXBElement<CaseAugmentationType>(_CaseAugmentation_QNAME, CaseAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseCharge")
    public JAXBElement<ChargeType> createCaseCharge(ChargeType value) {
        return new JAXBElement<ChargeType>(_CaseCharge_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseCourt")
    public JAXBElement<CourtType> createCaseCourt(CourtType value) {
        return new JAXBElement<CourtType>(_CaseCourt_QNAME, CourtType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseCourtEvent")
    public JAXBElement<CourtEventType> createCaseCourtEvent(CourtEventType value) {
        return new JAXBElement<CourtEventType>(_CaseCourtEvent_QNAME, CourtEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseDefendantParty")
    public JAXBElement<EntityType> createCaseDefendantParty(EntityType value) {
        return new JAXBElement<EntityType>(_CaseDefendantParty_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseDefenseAttorney")
    public JAXBElement<CaseOfficialType> createCaseDefenseAttorney(CaseOfficialType value) {
        return new JAXBElement<CaseOfficialType>(_CaseDefenseAttorney_QNAME, CaseOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseInitiatingAttorney")
    public JAXBElement<CaseOfficialType> createCaseInitiatingAttorney(CaseOfficialType value) {
        return new JAXBElement<CaseOfficialType>(_CaseInitiatingAttorney_QNAME, CaseOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseInitiatingParty")
    public JAXBElement<EntityType> createCaseInitiatingParty(EntityType value) {
        return new JAXBElement<EntityType>(_CaseInitiatingParty_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseJudge")
    public JAXBElement<CaseOfficialType> createCaseJudge(CaseOfficialType value) {
        return new JAXBElement<CaseOfficialType>(_CaseJudge_QNAME, CaseOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseLineageCase")
    public JAXBElement<CaseType> createCaseLineageCase(CaseType value) {
        return new JAXBElement<CaseType>(_CaseLineageCase_QNAME, CaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseOfficial")
    public JAXBElement<CaseOfficialType> createCaseOfficial(CaseOfficialType value) {
        return new JAXBElement<CaseOfficialType>(_CaseOfficial_QNAME, CaseOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseOfficialCaseIdentification")
    public JAXBElement<IdentificationType> createCaseOfficialCaseIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_CaseOfficialCaseIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseOfficialRoleText")
    public JAXBElement<TextType> createCaseOfficialRoleText(TextType value) {
        return new JAXBElement<TextType>(_CaseOfficialRoleText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseOtherEntity")
    public JAXBElement<EntityType> createCaseOtherEntity(EntityType value) {
        return new JAXBElement<EntityType>(_CaseOtherEntity_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseProsecutionAttorney")
    public JAXBElement<CaseOfficialType> createCaseProsecutionAttorney(CaseOfficialType value) {
        return new JAXBElement<CaseOfficialType>(_CaseProsecutionAttorney_QNAME, CaseOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseRespondentAttorney")
    public JAXBElement<CaseOfficialType> createCaseRespondentAttorney(CaseOfficialType value) {
        return new JAXBElement<CaseOfficialType>(_CaseRespondentAttorney_QNAME, CaseOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CaseRespondentParty")
    public JAXBElement<EntityType> createCaseRespondentParty(EntityType value) {
        return new JAXBElement<EntityType>(_CaseRespondentParty_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeReference")
    public JAXBElement<ReferenceType> createChargeReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_ChargeReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "Charge")
    public JAXBElement<ChargeType> createCharge(ChargeType value) {
        return new JAXBElement<ChargeType>(_Charge_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeApplicabilityText")
    public JAXBElement<TextType> createChargeApplicabilityText(TextType value) {
        return new JAXBElement<TextType>(_ChargeApplicabilityText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeDegreeText")
    public JAXBElement<TextType> createChargeDegreeText(TextType value) {
        return new JAXBElement<TextType>(_ChargeDegreeText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeDescriptionText")
    public JAXBElement<TextType> createChargeDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ChargeDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeDispositionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeDispositionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeDisposition")
    public JAXBElement<ChargeDispositionType> createChargeDisposition(ChargeDispositionType value) {
        return new JAXBElement<ChargeDispositionType>(_ChargeDisposition_QNAME, ChargeDispositionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeEnhancingAllegationCharge")
    public JAXBElement<ChargeType> createChargeEnhancingAllegationCharge(ChargeType value) {
        return new JAXBElement<ChargeType>(_ChargeEnhancingAllegationCharge_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OFFCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OFFCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeNCICCode")
    public JAXBElement<OFFCodeType> createChargeNCICCode(OFFCodeType value) {
        return new JAXBElement<OFFCodeType>(_ChargeNCICCode_QNAME, OFFCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeQualifierText")
    public JAXBElement<TextType> createChargeQualifierText(TextType value) {
        return new JAXBElement<TextType>(_ChargeQualifierText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeSequenceID")
    public JAXBElement<IdentificationType> createChargeSequenceID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ChargeSequenceID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeverityLevelType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SeverityLevelType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeSeverityLevel")
    public JAXBElement<SeverityLevelType> createChargeSeverityLevel(SeverityLevelType value) {
        return new JAXBElement<SeverityLevelType>(_ChargeSeverityLevel_QNAME, SeverityLevelType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeSpecialAllegationText")
    public JAXBElement<TextType> createChargeSpecialAllegationText(TextType value) {
        return new JAXBElement<TextType>(_ChargeSpecialAllegationText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ChargeStatute")
    public JAXBElement<StatuteType> createChargeStatute(StatuteType value) {
        return new JAXBElement<StatuteType>(_ChargeStatute_QNAME, StatuteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CitationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CitationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "Citation")
    public JAXBElement<CitationType> createCitation(CitationType value) {
        return new JAXBElement<CitationType>(_Citation_QNAME, CitationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CitationAgency")
    public JAXBElement<OrganizationType> createCitationAgency(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_CitationAgency_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CitationDismissalConditionIndicator")
    public JAXBElement<Boolean> createCitationDismissalConditionIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_CitationDismissalConditionIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnforcementOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnforcementOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CitationIssuingOfficial")
    public JAXBElement<EnforcementOfficialType> createCitationIssuingOfficial(EnforcementOfficialType value) {
        return new JAXBElement<EnforcementOfficialType>(_CitationIssuingOfficial_QNAME, EnforcementOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CitationSubject")
    public JAXBElement<SubjectType> createCitationSubject(SubjectType value) {
        return new JAXBElement<SubjectType>(_CitationSubject_QNAME, SubjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CitationViolation")
    public JAXBElement<IncidentType> createCitationViolation(IncidentType value) {
        return new JAXBElement<IncidentType>(_CitationViolation_QNAME, IncidentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CourtReference")
    public JAXBElement<ReferenceType> createCourtReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_CourtReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtAppearanceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtAppearanceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CourtAppearance")
    public JAXBElement<CourtAppearanceType> createCourtAppearance(CourtAppearanceType value) {
        return new JAXBElement<CourtAppearanceType>(_CourtAppearance_QNAME, CourtAppearanceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CourtAppearanceDate")
    public JAXBElement<DateType> createCourtAppearanceDate(DateType value) {
        return new JAXBElement<DateType>(_CourtAppearanceDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtEventType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtEventType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CourtEvent")
    public JAXBElement<CourtEventType> createCourtEvent(CourtEventType value) {
        return new JAXBElement<CourtEventType>(_CourtEvent_QNAME, CourtEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JudicialOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JudicialOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CourtEventJudge")
    public JAXBElement<JudicialOfficialType> createCourtEventJudge(JudicialOfficialType value) {
        return new JAXBElement<JudicialOfficialType>(_CourtEventJudge_QNAME, JudicialOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleDayType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ScheduleDayType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CourtEventSchedule")
    public JAXBElement<ScheduleDayType> createCourtEventSchedule(ScheduleDayType value) {
        return new JAXBElement<ScheduleDayType>(_CourtEventSchedule_QNAME, ScheduleDayType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CourtEventSequenceID")
    public JAXBElement<IdentificationType> createCourtEventSequenceID(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_CourtEventSequenceID_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CourtName")
    public JAXBElement<TextType> createCourtName(TextType value) {
        return new JAXBElement<TextType>(_CourtName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtOrderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtOrderType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CourtOrder")
    public JAXBElement<CourtOrderType> createCourtOrder(CourtOrderType value) {
        return new JAXBElement<CourtOrderType>(_CourtOrder_QNAME, CourtOrderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "CourtOrderStatus")
    public JAXBElement<StatusType> createCourtOrderStatus(StatusType value) {
        return new JAXBElement<StatusType>(_CourtOrderStatus_QNAME, StatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentCourtAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentCourtAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DocumentCourtAssociation")
    public JAXBElement<DocumentCourtAssociationType> createDocumentCourtAssociation(DocumentCourtAssociationType value) {
        return new JAXBElement<DocumentCourtAssociationType>(_DocumentCourtAssociation_QNAME, DocumentCourtAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingAccidentSeverity")
    public JAXBElement<Object> createDrivingAccidentSeverity(Object value) {
        return new JAXBElement<Object>(_DrivingAccidentSeverity_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccidentSeverityCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccidentSeverityCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingAccidentSeverityCode", substitutionHeadNamespace = "http://niem.gov/niem/domains/jxdm/4.0", substitutionHeadName = "DrivingAccidentSeverity")
    public JAXBElement<AccidentSeverityCodeType> createDrivingAccidentSeverityCode(AccidentSeverityCodeType value) {
        return new JAXBElement<AccidentSeverityCodeType>(_DrivingAccidentSeverityCode_QNAME, AccidentSeverityCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DrivingIncidentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DrivingIncidentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingIncident")
    public JAXBElement<DrivingIncidentType> createDrivingIncident(DrivingIncidentType value) {
        return new JAXBElement<DrivingIncidentType>(_DrivingIncident_QNAME, DrivingIncidentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingIncidentHazMat")
    public JAXBElement<Object> createDrivingIncidentHazMat(Object value) {
        return new JAXBElement<Object>(_DrivingIncidentHazMat_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HazMatCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HazMatCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingIncidentHazMatCode", substitutionHeadNamespace = "http://niem.gov/niem/domains/jxdm/4.0", substitutionHeadName = "DrivingIncidentHazMat")
    public JAXBElement<HazMatCodeType> createDrivingIncidentHazMatCode(HazMatCodeType value) {
        return new JAXBElement<HazMatCodeType>(_DrivingIncidentHazMatCode_QNAME, HazMatCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingIncidentLaserDetectionIndicator")
    public JAXBElement<Boolean> createDrivingIncidentLaserDetectionIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_DrivingIncidentLaserDetectionIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingIncidentLegalSpeedRate")
    public JAXBElement<MeasureType> createDrivingIncidentLegalSpeedRate(MeasureType value) {
        return new JAXBElement<MeasureType>(_DrivingIncidentLegalSpeedRate_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingIncidentPassengerQuantityText")
    public JAXBElement<TextType> createDrivingIncidentPassengerQuantityText(TextType value) {
        return new JAXBElement<TextType>(_DrivingIncidentPassengerQuantityText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingIncidentRadarDetectionIndicator")
    public JAXBElement<Boolean> createDrivingIncidentRadarDetectionIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_DrivingIncidentRadarDetectionIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingIncidentRecordedSpeedRate")
    public JAXBElement<MeasureType> createDrivingIncidentRecordedSpeedRate(MeasureType value) {
        return new JAXBElement<MeasureType>(_DrivingIncidentRecordedSpeedRate_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LSTACodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LSTACodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "DrivingJurisdictionAuthorityNCICLSTACode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "IdentificationJurisdiction")
    public JAXBElement<LSTACodeType> createDrivingJurisdictionAuthorityNCICLSTACode(LSTACodeType value) {
        return new JAXBElement<LSTACodeType>(_DrivingJurisdictionAuthorityNCICLSTACode_QNAME, LSTACodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "EnforcementOfficialBadgeIdentification")
    public JAXBElement<IdentificationType> createEnforcementOfficialBadgeIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_EnforcementOfficialBadgeIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ScheduleDayType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ScheduleDayType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "EnforcementOfficialUnavailableSchedule")
    public JAXBElement<ScheduleDayType> createEnforcementOfficialUnavailableSchedule(ScheduleDayType value) {
        return new JAXBElement<ScheduleDayType>(_EnforcementOfficialUnavailableSchedule_QNAME, ScheduleDayType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnforcementUnitType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnforcementUnitType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "EnforcementOfficialUnit")
    public JAXBElement<EnforcementUnitType> createEnforcementOfficialUnit(EnforcementUnitType value) {
        return new JAXBElement<EnforcementUnitType>(_EnforcementOfficialUnit_QNAME, EnforcementUnitType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "EnforcementUnitName")
    public JAXBElement<TextType> createEnforcementUnitName(TextType value) {
        return new JAXBElement<TextType>(_EnforcementUnitName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LISCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LISCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "IdentificationJurisdictionNCICLISCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "IdentificationJurisdiction")
    public JAXBElement<LISCodeType> createIdentificationJurisdictionNCICLISCode(LISCodeType value) {
        return new JAXBElement<LISCodeType>(_IdentificationJurisdictionNCICLISCode_QNAME, LISCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "IncidentAugmentation", substitutionHeadNamespace = "http://niem.gov/niem/structures/2.0", substitutionHeadName = "Augmentation")
    public JAXBElement<IncidentAugmentationType> createIncidentAugmentation(IncidentAugmentationType value) {
        return new JAXBElement<IncidentAugmentationType>(_IncidentAugmentation_QNAME, IncidentAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "IncidentDamagedPropertyReference")
    public JAXBElement<ReferenceType> createIncidentDamagedPropertyReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_IncidentDamagedPropertyReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "IncidentOfficialPresentIndicator")
    public JAXBElement<Boolean> createIncidentOfficialPresentIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncidentOfficialPresentIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "IncidentTrafficAccidentInvolvedIndicator")
    public JAXBElement<Boolean> createIncidentTrafficAccidentInvolvedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncidentTrafficAccidentInvolvedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "JudicialOfficialBarIdentification")
    public JAXBElement<IdentificationType> createJudicialOfficialBarIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_JudicialOfficialBarIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JudicialOfficialBarMembershipType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JudicialOfficialBarMembershipType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "JudicialOfficialBarMembership")
    public JAXBElement<JudicialOfficialBarMembershipType> createJudicialOfficialBarMembership(JudicialOfficialBarMembershipType value) {
        return new JAXBElement<JudicialOfficialBarMembershipType>(_JudicialOfficialBarMembership_QNAME, JudicialOfficialBarMembershipType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "Offense")
    public JAXBElement<IncidentType> createOffense(IncidentType value) {
        return new JAXBElement<IncidentType>(_Offense_QNAME, IncidentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "OrganizationAugmentation", substitutionHeadNamespace = "http://niem.gov/niem/structures/2.0", substitutionHeadName = "Augmentation")
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
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "OrganizationORIIdentification")
    public JAXBElement<IdentificationType> createOrganizationORIIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_OrganizationORIIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "PersonAFISIdentification")
    public JAXBElement<IdentificationType> createPersonAFISIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonAFISIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "PersonAugmentation", substitutionHeadNamespace = "http://niem.gov/niem/structures/2.0", substitutionHeadName = "Augmentation")
    public JAXBElement<PersonAugmentationType> createPersonAugmentation(PersonAugmentationType value) {
        return new JAXBElement<PersonAugmentationType>(_PersonAugmentation_QNAME, PersonAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonChargeAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonChargeAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "PersonChargeAssociation")
    public JAXBElement<PersonChargeAssociationType> createPersonChargeAssociation(PersonChargeAssociationType value) {
        return new JAXBElement<PersonChargeAssociationType>(_PersonChargeAssociation_QNAME, PersonChargeAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverLicenseAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriverLicenseAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "PersonDriverLicenseAssociation")
    public JAXBElement<DriverLicenseAssociationType> createPersonDriverLicenseAssociation(DriverLicenseAssociationType value) {
        return new JAXBElement<DriverLicenseAssociationType>(_PersonDriverLicenseAssociation_QNAME, DriverLicenseAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "PersonFBIIdentification")
    public JAXBElement<IdentificationType> createPersonFBIIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonFBIIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BiometricType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BiometricType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "PersonPalmPrint")
    public JAXBElement<BiometricType> createPersonPalmPrint(BiometricType value) {
        return new JAXBElement<BiometricType>(_PersonPalmPrint_QNAME, BiometricType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "PersonStateFingerprintIdentification")
    public JAXBElement<IdentificationType> createPersonStateFingerprintIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonStateFingerprintIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PropertyAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PropertyAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "PropertyAugmentation", substitutionHeadNamespace = "http://niem.gov/niem/structures/2.0", substitutionHeadName = "Augmentation")
    public JAXBElement<PropertyAugmentationType> createPropertyAugmentation(PropertyAugmentationType value) {
        return new JAXBElement<PropertyAugmentationType>(_PropertyAugmentation_QNAME, PropertyAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemValueType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemValueType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "PropertyTotalDamageValue")
    public JAXBElement<ItemValueType> createPropertyTotalDamageValue(ItemValueType value) {
        return new JAXBElement<ItemValueType>(_PropertyTotalDamageValue_QNAME, ItemValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "RegisterActionDescriptionText")
    public JAXBElement<TextType> createRegisterActionDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_RegisterActionDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "RegisteredOffenderIdentification")
    public JAXBElement<IdentificationType> createRegisteredOffenderIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_RegisteredOffenderIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisteredOffenderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisteredOffenderType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "RegisteredSexOffender")
    public JAXBElement<RegisteredOffenderType> createRegisteredSexOffender(RegisteredOffenderType value) {
        return new JAXBElement<RegisteredOffenderType>(_RegisteredSexOffender_QNAME, RegisteredOffenderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SentenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SentenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "Sentence")
    public JAXBElement<SentenceType> createSentence(SentenceType value) {
        return new JAXBElement<SentenceType>(_Sentence_QNAME, SentenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "SentenceCharge")
    public JAXBElement<ChargeType> createSentenceCharge(ChargeType value) {
        return new JAXBElement<ChargeType>(_SentenceCharge_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "SentenceDescriptionText")
    public JAXBElement<TextType> createSentenceDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_SentenceDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TermType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TermType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "SentenceTerm")
    public JAXBElement<TermType> createSentenceTerm(TermType value) {
        return new JAXBElement<TermType>(_SentenceTerm_QNAME, TermType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "SeverityLevelDescriptionText")
    public JAXBElement<TextType> createSeverityLevelDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_SeverityLevelDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "SeverityLevelIdentification")
    public JAXBElement<IdentificationType> createSeverityLevelIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_SeverityLevelIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "StatuteReference")
    public JAXBElement<ReferenceType> createStatuteReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_StatuteReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "Statute")
    public JAXBElement<StatuteType> createStatute(StatuteType value) {
        return new JAXBElement<StatuteType>(_Statute_QNAME, StatuteType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "StatuteCodeIdentification")
    public JAXBElement<IdentificationType> createStatuteCodeIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_StatuteCodeIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "StatuteCodeSectionIdentification")
    public JAXBElement<IdentificationType> createStatuteCodeSectionIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_StatuteCodeSectionIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "StatuteDescriptionText")
    public JAXBElement<TextType> createStatuteDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_StatuteDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JurisdictionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JurisdictionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "StatuteJurisdiction")
    public JAXBElement<JurisdictionType> createStatuteJurisdiction(JurisdictionType value) {
        return new JAXBElement<JurisdictionType>(_StatuteJurisdiction_QNAME, JurisdictionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "StatuteLevelText")
    public JAXBElement<TextType> createStatuteLevelText(TextType value) {
        return new JAXBElement<TextType>(_StatuteLevelText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "StatuteOffenseIdentification")
    public JAXBElement<IdentificationType> createStatuteOffenseIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_StatuteOffenseIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "SubjectReference")
    public JAXBElement<ReferenceType> createSubjectReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_SubjectReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SubjectType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "Subject")
    public JAXBElement<SubjectType> createSubject(SubjectType value) {
        return new JAXBElement<SubjectType>(_Subject_QNAME, SubjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "SubjectIdentification")
    public JAXBElement<IdentificationType> createSubjectIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_SubjectIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupervisionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SupervisionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "SubjectSupervision")
    public JAXBElement<SupervisionType> createSubjectSupervision(SupervisionType value) {
        return new JAXBElement<SupervisionType>(_SubjectSupervision_QNAME, SupervisionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TermType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TermType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "Term")
    public JAXBElement<TermType> createTerm(TermType value) {
        return new JAXBElement<TermType>(_Term_QNAME, TermType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "TermDuration")
    public JAXBElement<Duration> createTermDuration(Duration value) {
        return new JAXBElement<Duration>(_TermDuration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "VictimReference")
    public JAXBElement<ReferenceType> createVictimReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_VictimReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViolatedStatuteAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViolatedStatuteAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "ViolatedStatuteAssociation")
    public JAXBElement<ViolatedStatuteAssociationType> createViolatedStatuteAssociation(ViolatedStatuteAssociationType value) {
        return new JAXBElement<ViolatedStatuteAssociationType>(_ViolatedStatuteAssociation_QNAME, ViolatedStatuteAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "WarrantExtraditionLimitation")
    public JAXBElement<Object> createWarrantExtraditionLimitation(Object value) {
        return new JAXBElement<Object>(_WarrantExtraditionLimitation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EXLCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EXLCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/domains/jxdm/4.0", name = "WarrantExtraditionLimitationCode", substitutionHeadNamespace = "http://niem.gov/niem/domains/jxdm/4.0", substitutionHeadName = "WarrantExtraditionLimitation")
    public JAXBElement<EXLCodeType> createWarrantExtraditionLimitationCode(EXLCodeType value) {
        return new JAXBElement<EXLCodeType>(_WarrantExtraditionLimitationCode_QNAME, EXLCodeType.class, null, value);
    }

}
