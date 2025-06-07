
package ecf4.latest.gov.niem.release.niem.domains.jxdm._6;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.release.niem.codes.aamva_d20._4.AccidentSeverityCodeType;
import ecf4.latest.gov.niem.release.niem.codes.aamva_d20._4.DriverLicenseClassCodeType;
import ecf4.latest.gov.niem.release.niem.codes.aamva_d20._4.HazMatCodeType;
import ecf4.latest.gov.niem.release.niem.codes.aamva_d20._4.JurisdictionAuthorityCodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.CountryCodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.EXLCodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.EYECodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.HAIRCodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.PCOCodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.RACECodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.SEXCodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.SMTCodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.VCOCodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.VMACodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.VMOCodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ncic._4.VSTCodeType;
import ecf4.latest.gov.niem.release.niem.codes.fbi_ucr._4.EthnicityCodeType;
import ecf4.latest.gov.niem.release.niem.codes.mmucc._4.DrivingRestrictionCodeType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.AmountType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.CaseType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DateType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.EntityType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.ItemType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.ItemValueType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.JurisdictionType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.LocationType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.OffenseLevelCodeType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.OrganizationType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.PersonType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.ScheduleDayType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.SpeedMeasureType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.SupervisionType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.TextType;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.gov.niem.release.niem.domains.jxdm._6 package. 
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

    private final static QName _AppellateCase_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "AppellateCase");
    private final static QName _AppellateCaseNotice_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "AppellateCaseNotice");
    private final static QName _AppellateCaseNoticeReasonText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "AppellateCaseNoticeReasonText");
    private final static QName _AppellateCaseOriginalCase_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "AppellateCaseOriginalCase");
    private final static QName _Arrest_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "Arrest");
    private final static QName _ArrestAgency_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ArrestAgency");
    private final static QName _ArrestAgencyRecordIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ArrestAgencyRecordIdentification");
    private final static QName _ArrestCharge_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ArrestCharge");
    private final static QName _ArrestLocation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ArrestLocation");
    private final static QName _ArrestOfficial_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ArrestOfficial");
    private final static QName _ArrestSubject_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ArrestSubject");
    private final static QName _ArrestWarrant_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ArrestWarrant");
    private final static QName _Booking_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "Booking");
    private final static QName _BookingAgency_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "BookingAgency");
    private final static QName _BookingAgencyRecordIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "BookingAgencyRecordIdentification");
    private final static QName _CaseAugmentation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseAugmentation");
    private final static QName _CaseCharge_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseCharge");
    private final static QName _CaseCourt_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseCourt");
    private final static QName _CaseCourtEvent_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseCourtEvent");
    private final static QName _CaseJudge_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseJudge");
    private final static QName _CaseLineageCase_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseLineageCase");
    private final static QName _CaseNumberText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseNumberText");
    private final static QName _CaseOfficial_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseOfficial");
    private final static QName _CaseOfficialAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseOfficialAugmentationPoint");
    private final static QName _CaseOfficialCaseIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseOfficialCaseIdentification");
    private final static QName _CaseOtherEntity_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CaseOtherEntity");
    private final static QName _ChargeAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeAugmentationPoint");
    private final static QName _ChargeDegreeText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeDegreeText");
    private final static QName _ChargeDescriptionText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeDescriptionText");
    private final static QName _ChargeDisposition_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeDisposition");
    private final static QName _ChargeEnhancingAllegationCharge_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeEnhancingAllegationCharge");
    private final static QName _ChargeEnhancingFactor_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeEnhancingFactor");
    private final static QName _ChargeEnhancingFactorText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeEnhancingFactorText");
    private final static QName _ChargeQualifierText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeQualifierText");
    private final static QName _ChargeSequenceID_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeSequenceID");
    private final static QName _ChargeSeverityLevel_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeSeverityLevel");
    private final static QName _ChargeSpecialAllegationText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeSpecialAllegationText");
    private final static QName _ChargeStatute_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ChargeStatute");
    private final static QName _Citation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "Citation");
    private final static QName _CitationAgency_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CitationAgency");
    private final static QName _CitationDismissalConditionIndicator_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CitationDismissalConditionIndicator");
    private final static QName _CitationDismissalConditionText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CitationDismissalConditionText");
    private final static QName _CitationIssuingOfficial_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CitationIssuingOfficial");
    private final static QName _CitationSubject_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CitationSubject");
    private final static QName _ConveyanceColorPrimaryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ConveyanceColorPrimaryCode");
    private final static QName _ConveyanceRegistration_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ConveyanceRegistration");
    private final static QName _ConveyanceRegistrationPlateCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ConveyanceRegistrationPlateCategoryAbstract");
    private final static QName _ConveyanceRegistrationPlateCategoryText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ConveyanceRegistrationPlateCategoryText");
    private final static QName _ConveyanceRegistrationPlateIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ConveyanceRegistrationPlateIdentification");
    private final static QName _CourtAdministrativeUnitText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CourtAdministrativeUnitText");
    private final static QName _CourtAppearance_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CourtAppearance");
    private final static QName _CourtAppearanceDate_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CourtAppearanceDate");
    private final static QName _CourtAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CourtAugmentationPoint");
    private final static QName _CourtEventAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CourtEventAugmentationPoint");
    private final static QName _CourtEventJudge_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CourtEventJudge");
    private final static QName _CourtEventSchedule_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CourtEventSchedule");
    private final static QName _CourtEventSequenceID_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CourtEventSequenceID");
    private final static QName _CourtName_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CourtName");
    private final static QName _CourtOrderAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CourtOrderAugmentationPoint");
    private final static QName _CrashDrivingRestrictionCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "CrashDrivingRestrictionCode");
    private final static QName _DrivingRestrictionAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingRestrictionAbstract");
    private final static QName _DriverLicense_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DriverLicense");
    private final static QName _DriverLicenseCommercialClassAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DriverLicenseCommercialClassAbstract");
    private final static QName _DriverLicenseCommercialClassCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DriverLicenseCommercialClassCode");
    private final static QName _DriverLicenseExpirationDate_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DriverLicenseExpirationDate");
    private final static QName _DriverLicenseIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DriverLicenseIdentification");
    private final static QName _DriverLicenseIssueDate_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DriverLicenseIssueDate");
    private final static QName _DriverLicenseRestriction_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DriverLicenseRestriction");
    private final static QName _DriverLicenseWithdrawal_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DriverLicenseWithdrawal");
    private final static QName _DriverLicenseWithdrawalEffectiveDate_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DriverLicenseWithdrawalEffectiveDate");
    private final static QName _DrivingAccidentSeverityAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingAccidentSeverityAbstract");
    private final static QName _DrivingAccidentSeverityCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingAccidentSeverityCode");
    private final static QName _DrivingIncident_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingIncident");
    private final static QName _DrivingIncidentAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingIncidentAugmentationPoint");
    private final static QName _DrivingIncidentHazMatAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingIncidentHazMatAbstract");
    private final static QName _DrivingIncidentHazMatCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingIncidentHazMatCode");
    private final static QName _DrivingIncidentLaserDetectionIndicator_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingIncidentLaserDetectionIndicator");
    private final static QName _DrivingIncidentLegalSpeedRateMeasure_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingIncidentLegalSpeedRateMeasure");
    private final static QName _DrivingIncidentPassengerQuantityText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingIncidentPassengerQuantityText");
    private final static QName _DrivingIncidentRadarDetectionIndicator_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingIncidentRadarDetectionIndicator");
    private final static QName _DrivingIncidentRecordedSpeedRateMeasure_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingIncidentRecordedSpeedRateMeasure");
    private final static QName _DrivingRestrictionEndDate_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingRestrictionEndDate");
    private final static QName _DrivingRestrictionText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "DrivingRestrictionText");
    private final static QName _EnforcementOfficialBadgeIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "EnforcementOfficialBadgeIdentification");
    private final static QName _EnforcementOfficialUnavailableSchedule_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "EnforcementOfficialUnavailableSchedule");
    private final static QName _EnforcementOfficialUnit_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "EnforcementOfficialUnit");
    private final static QName _EnforcementUnitName_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "EnforcementUnitName");
    private final static QName _IncidentAugmentation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "IncidentAugmentation");
    private final static QName _IncidentDamagedItem_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "IncidentDamagedItem");
    private final static QName _IncidentGeneralCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "IncidentGeneralCategoryAbstract");
    private final static QName _IncidentLevelAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "IncidentLevelAbstract");
    private final static QName _IncidentLevelCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "IncidentLevelCode");
    private final static QName _IncidentOfficialPresentIndicator_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "IncidentOfficialPresentIndicator");
    private final static QName _IncidentTrafficAccidentInvolvedIndicator_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "IncidentTrafficAccidentInvolvedIndicator");
    private final static QName _IncidentViolatedStatuteAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "IncidentViolatedStatuteAssociation");
    private final static QName _ItemTotalDamageValue_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ItemTotalDamageValue");
    private final static QName _Judge_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "Judge");
    private final static QName _JudicialOfficialBarIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "JudicialOfficialBarIdentification");
    private final static QName _JudicialOfficialBarMembership_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "JudicialOfficialBarMembership");
    private final static QName _JudicialOfficialRegistrationIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "JudicialOfficialRegistrationIdentification");
    private final static QName _JurisdictionANSID20AuthorityCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "JurisdictionANSID20AuthorityCode");
    private final static QName _LocationStateNCICLISCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "LocationStateNCICLISCode");
    private final static QName _Offense_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "Offense");
    private final static QName _OffenseChargeAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "OffenseChargeAssociation");
    private final static QName _OffenseLocationAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "OffenseLocationAssociation");
    private final static QName _OrganizationAlternateName_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "OrganizationAlternateName");
    private final static QName _OrganizationAlternateNameCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "OrganizationAlternateNameCategoryAbstract");
    private final static QName _OrganizationAlternateNameCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "OrganizationAlternateNameCategoryCode");
    private final static QName _OrganizationORIIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "OrganizationORIIdentification");
    private final static QName _PersonAFISIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonAFISIdentification");
    private final static QName _PersonAugmentation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonAugmentation");
    private final static QName _PersonBloodAlcoholContentNumberText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonBloodAlcoholContentNumberText");
    private final static QName _PersonChargeAssociation_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonChargeAssociation");
    private final static QName _PersonEthnicityCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonEthnicityCode");
    private final static QName _PersonEyeColorCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonEyeColorCode");
    private final static QName _PersonFBIIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonFBIIdentification");
    private final static QName _PersonHairColorCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonHairColorCode");
    private final static QName _PersonNameCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonNameCategoryCode");
    private final static QName _PersonRaceCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonRaceCode");
    private final static QName _PersonSexCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonSexCode");
    private final static QName _PersonStateFingerprintIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PersonStateFingerprintIdentification");
    private final static QName _PhysicalFeatureCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "PhysicalFeatureCategoryCode");
    private final static QName _ProtectionOrder_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ProtectionOrder");
    private final static QName _ProtectionOrderConditionAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ProtectionOrderConditionAbstract");
    private final static QName _ProtectionOrderConditionCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ProtectionOrderConditionCode");
    private final static QName _ProtectionOrderConditionText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ProtectionOrderConditionText");
    private final static QName _ProtectionOrderRestrictedPerson_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "ProtectionOrderRestrictedPerson");
    private final static QName _RapSheetTransactionControlIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "RapSheetTransactionControlIdentification");
    private final static QName _RegisteredOffenderIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "RegisteredOffenderIdentification");
    private final static QName _RegisteredSexOffender_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "RegisteredSexOffender");
    private final static QName _Sentence_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "Sentence");
    private final static QName _SentenceAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "SentenceAugmentationPoint");
    private final static QName _SentenceCharge_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "SentenceCharge");
    private final static QName _SentenceDescriptionText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "SentenceDescriptionText");
    private final static QName _SentenceTerm_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "SentenceTerm");
    private final static QName _SeverityLevelDescriptionText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "SeverityLevelDescriptionText");
    private final static QName _Statute_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "Statute");
    private final static QName _StatuteCodeIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "StatuteCodeIdentification");
    private final static QName _StatuteCodeSectionIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "StatuteCodeSectionIdentification");
    private final static QName _StatuteDescriptionText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "StatuteDescriptionText");
    private final static QName _StatuteJurisdiction_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "StatuteJurisdiction");
    private final static QName _StatuteLevelText_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "StatuteLevelText");
    private final static QName _StatuteOffenseIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "StatuteOffenseIdentification");
    private final static QName _SubjectAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "SubjectAugmentationPoint");
    private final static QName _SubjectIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "SubjectIdentification");
    private final static QName _SubjectSupervision_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "SubjectSupervision");
    private final static QName _SupervisionFineAmount_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "SupervisionFineAmount");
    private final static QName _VehicleMakeCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "VehicleMakeCode");
    private final static QName _VehicleModelCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "VehicleModelCode");
    private final static QName _VehicleStyleCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "VehicleStyleCode");
    private final static QName _WarrantExtraditionLimitationAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "WarrantExtraditionLimitationAbstract");
    private final static QName _WarrantExtraditionLimitationCode_QNAME = new QName("http://release.niem.gov/niem/domains/jxdm/6.0/", "WarrantExtraditionLimitationCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.gov.niem.release.niem.domains.jxdm._6
     * 
     */
    public ObjectFactory() {
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
     * Create an instance of {@link ChargeEnhancingFactorType }
     * 
     */
    public ChargeEnhancingFactorType createChargeEnhancingFactorType() {
        return new ChargeEnhancingFactorType();
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
     * Create an instance of {@link ConveyanceRegistrationType }
     * 
     */
    public ConveyanceRegistrationType createConveyanceRegistrationType() {
        return new ConveyanceRegistrationType();
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
     * Create an instance of {@link DriverLicenseType }
     * 
     */
    public DriverLicenseType createDriverLicenseType() {
        return new DriverLicenseType();
    }

    /**
     * Create an instance of {@link DriverLicenseRestrictionType }
     * 
     */
    public DriverLicenseRestrictionType createDriverLicenseRestrictionType() {
        return new DriverLicenseRestrictionType();
    }

    /**
     * Create an instance of {@link DriverLicenseWithdrawalType }
     * 
     */
    public DriverLicenseWithdrawalType createDriverLicenseWithdrawalType() {
        return new DriverLicenseWithdrawalType();
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
     * Create an instance of {@link ViolatedStatuteAssociationType }
     * 
     */
    public ViolatedStatuteAssociationType createViolatedStatuteAssociationType() {
        return new ViolatedStatuteAssociationType();
    }

    /**
     * Create an instance of {@link JudicialOfficialBarMembershipType }
     * 
     */
    public JudicialOfficialBarMembershipType createJudicialOfficialBarMembershipType() {
        return new JudicialOfficialBarMembershipType();
    }

    /**
     * Create an instance of {@link OffenseType }
     * 
     */
    public OffenseType createOffenseType() {
        return new OffenseType();
    }

    /**
     * Create an instance of {@link OffenseChargeAssociationType }
     * 
     */
    public OffenseChargeAssociationType createOffenseChargeAssociationType() {
        return new OffenseChargeAssociationType();
    }

    /**
     * Create an instance of {@link OffenseLocationAssociationType }
     * 
     */
    public OffenseLocationAssociationType createOffenseLocationAssociationType() {
        return new OffenseLocationAssociationType();
    }

    /**
     * Create an instance of {@link OrganizationAlternateNameType }
     * 
     */
    public OrganizationAlternateNameType createOrganizationAlternateNameType() {
        return new OrganizationAlternateNameType();
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
     * Create an instance of {@link ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonNameCategoryCodeType }
     * 
     */
    public ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonNameCategoryCodeType createPersonNameCategoryCodeType() {
        return new ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonNameCategoryCodeType();
    }

    /**
     * Create an instance of {@link ProtectionOrderType }
     * 
     */
    public ProtectionOrderType createProtectionOrderType() {
        return new ProtectionOrderType();
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
     * Create an instance of {@link CourtOrderType }
     * 
     */
    public CourtOrderType createCourtOrderType() {
        return new CourtOrderType();
    }

    /**
     * Create an instance of {@link DriverLicenseBaseType }
     * 
     */
    public DriverLicenseBaseType createDriverLicenseBaseType() {
        return new DriverLicenseBaseType();
    }

    /**
     * Create an instance of {@link DrivingRestrictionType }
     * 
     */
    public DrivingRestrictionType createDrivingRestrictionType() {
        return new DrivingRestrictionType();
    }

    /**
     * Create an instance of {@link ItemRegistrationType }
     * 
     */
    public ItemRegistrationType createItemRegistrationType() {
        return new ItemRegistrationType();
    }

    /**
     * Create an instance of {@link OrganizationAugmentationType }
     * 
     */
    public OrganizationAugmentationType createOrganizationAugmentationType() {
        return new OrganizationAugmentationType();
    }

    /**
     * Create an instance of {@link PersonBloodAlcoholContentAssociationType }
     * 
     */
    public PersonBloodAlcoholContentAssociationType createPersonBloodAlcoholContentAssociationType() {
        return new PersonBloodAlcoholContentAssociationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "AppellateCase")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "AppellateCaseNotice")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "AppellateCaseNoticeReasonText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "AppellateCaseOriginalCase")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "Arrest")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ArrestAgency")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ArrestAgencyRecordIdentification")
    public JAXBElement<IdentificationType> createArrestAgencyRecordIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ArrestAgencyRecordIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ArrestCharge")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ArrestLocation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ArrestOfficial")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ArrestSubject")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ArrestWarrant")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "Booking")
    public JAXBElement<BookingType> createBooking(BookingType value) {
        return new JAXBElement<BookingType>(_Booking_QNAME, BookingType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "BookingAgency")
    public JAXBElement<OrganizationType> createBookingAgency(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_BookingAgency_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "BookingAgencyRecordIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CaseAugmentationPoint")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseCharge")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseCourt")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseCourtEvent")
    public JAXBElement<CourtEventType> createCaseCourtEvent(CourtEventType value) {
        return new JAXBElement<CourtEventType>(_CaseCourtEvent_QNAME, CourtEventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseJudge")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseLineageCase")
    public JAXBElement<CaseType> createCaseLineageCase(CaseType value) {
        return new JAXBElement<CaseType>(_CaseLineageCase_QNAME, CaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseNumberText")
    public JAXBElement<TextType> createCaseNumberText(TextType value) {
        return new JAXBElement<TextType>(_CaseNumberText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseOfficial")
    public JAXBElement<CaseOfficialType> createCaseOfficial(CaseOfficialType value) {
        return new JAXBElement<CaseOfficialType>(_CaseOfficial_QNAME, CaseOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseOfficialAugmentationPoint")
    public JAXBElement<Object> createCaseOfficialAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_CaseOfficialAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseOfficialCaseIdentification")
    public JAXBElement<IdentificationType> createCaseOfficialCaseIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_CaseOfficialCaseIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CaseOtherEntity")
    public JAXBElement<EntityType> createCaseOtherEntity(EntityType value) {
        return new JAXBElement<EntityType>(_CaseOtherEntity_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeAugmentationPoint")
    public JAXBElement<Object> createChargeAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ChargeAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeDegreeText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeDescriptionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeDisposition")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeEnhancingAllegationCharge")
    public JAXBElement<ChargeType> createChargeEnhancingAllegationCharge(ChargeType value) {
        return new JAXBElement<ChargeType>(_ChargeEnhancingAllegationCharge_QNAME, ChargeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeEnhancingFactorType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeEnhancingFactorType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeEnhancingFactor")
    public JAXBElement<ChargeEnhancingFactorType> createChargeEnhancingFactor(ChargeEnhancingFactorType value) {
        return new JAXBElement<ChargeEnhancingFactorType>(_ChargeEnhancingFactor_QNAME, ChargeEnhancingFactorType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeEnhancingFactorText")
    public JAXBElement<TextType> createChargeEnhancingFactorText(TextType value) {
        return new JAXBElement<TextType>(_ChargeEnhancingFactorText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeQualifierText")
    public JAXBElement<TextType> createChargeQualifierText(TextType value) {
        return new JAXBElement<TextType>(_ChargeQualifierText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeSequenceID")
    public JAXBElement<String> createChargeSequenceID(String value) {
        return new JAXBElement<String>(_ChargeSequenceID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SeverityLevelType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SeverityLevelType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeSeverityLevel")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeSpecialAllegationText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ChargeStatute")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "Citation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CitationAgency")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CitationDismissalConditionIndicator")
    public JAXBElement<Boolean> createCitationDismissalConditionIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_CitationDismissalConditionIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CitationDismissalConditionText")
    public JAXBElement<TextType> createCitationDismissalConditionText(TextType value) {
        return new JAXBElement<TextType>(_CitationDismissalConditionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnforcementOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EnforcementOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CitationIssuingOfficial")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CitationSubject")
    public JAXBElement<SubjectType> createCitationSubject(SubjectType value) {
        return new JAXBElement<SubjectType>(_CitationSubject_QNAME, SubjectType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VCOCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VCOCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ConveyanceColorPrimaryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ItemColorAbstract")
    public JAXBElement<VCOCodeType> createConveyanceColorPrimaryCode(VCOCodeType value) {
        return new JAXBElement<VCOCodeType>(_ConveyanceColorPrimaryCode_QNAME, VCOCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConveyanceRegistrationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConveyanceRegistrationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ConveyanceRegistration")
    public JAXBElement<ConveyanceRegistrationType> createConveyanceRegistration(ConveyanceRegistrationType value) {
        return new JAXBElement<ConveyanceRegistrationType>(_ConveyanceRegistration_QNAME, ConveyanceRegistrationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ConveyanceRegistrationPlateCategoryAbstract")
    public JAXBElement<Object> createConveyanceRegistrationPlateCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_ConveyanceRegistrationPlateCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ConveyanceRegistrationPlateCategoryText", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "ConveyanceRegistrationPlateCategoryAbstract")
    public JAXBElement<TextType> createConveyanceRegistrationPlateCategoryText(TextType value) {
        return new JAXBElement<TextType>(_ConveyanceRegistrationPlateCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ConveyanceRegistrationPlateIdentification")
    public JAXBElement<IdentificationType> createConveyanceRegistrationPlateIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ConveyanceRegistrationPlateIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CourtAdministrativeUnitText")
    public JAXBElement<TextType> createCourtAdministrativeUnitText(TextType value) {
        return new JAXBElement<TextType>(_CourtAdministrativeUnitText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtAppearanceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtAppearanceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CourtAppearance")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CourtAppearanceDate")
    public JAXBElement<DateType> createCourtAppearanceDate(DateType value) {
        return new JAXBElement<DateType>(_CourtAppearanceDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CourtAugmentationPoint")
    public JAXBElement<Object> createCourtAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_CourtAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CourtEventAugmentationPoint")
    public JAXBElement<Object> createCourtEventAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_CourtEventAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JudicialOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JudicialOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CourtEventJudge")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CourtEventSchedule")
    public JAXBElement<ScheduleDayType> createCourtEventSchedule(ScheduleDayType value) {
        return new JAXBElement<ScheduleDayType>(_CourtEventSchedule_QNAME, ScheduleDayType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CourtEventSequenceID")
    public JAXBElement<String> createCourtEventSequenceID(String value) {
        return new JAXBElement<String>(_CourtEventSequenceID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CourtName")
    public JAXBElement<TextType> createCourtName(TextType value) {
        return new JAXBElement<TextType>(_CourtName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CourtOrderAugmentationPoint")
    public JAXBElement<Object> createCourtOrderAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_CourtOrderAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DrivingRestrictionCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DrivingRestrictionCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "CrashDrivingRestrictionCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "DrivingRestrictionAbstract")
    public JAXBElement<DrivingRestrictionCodeType> createCrashDrivingRestrictionCode(DrivingRestrictionCodeType value) {
        return new JAXBElement<DrivingRestrictionCodeType>(_CrashDrivingRestrictionCode_QNAME, DrivingRestrictionCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingRestrictionAbstract")
    public JAXBElement<Object> createDrivingRestrictionAbstract(Object value) {
        return new JAXBElement<Object>(_DrivingRestrictionAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverLicenseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriverLicenseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DriverLicense")
    public JAXBElement<DriverLicenseType> createDriverLicense(DriverLicenseType value) {
        return new JAXBElement<DriverLicenseType>(_DriverLicense_QNAME, DriverLicenseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DriverLicenseCommercialClassAbstract")
    public JAXBElement<Object> createDriverLicenseCommercialClassAbstract(Object value) {
        return new JAXBElement<Object>(_DriverLicenseCommercialClassAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverLicenseClassCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriverLicenseClassCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DriverLicenseCommercialClassCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "DriverLicenseCommercialClassAbstract")
    public JAXBElement<DriverLicenseClassCodeType> createDriverLicenseCommercialClassCode(DriverLicenseClassCodeType value) {
        return new JAXBElement<DriverLicenseClassCodeType>(_DriverLicenseCommercialClassCode_QNAME, DriverLicenseClassCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DriverLicenseExpirationDate")
    public JAXBElement<DateType> createDriverLicenseExpirationDate(DateType value) {
        return new JAXBElement<DateType>(_DriverLicenseExpirationDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DriverLicenseIdentification")
    public JAXBElement<IdentificationType> createDriverLicenseIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_DriverLicenseIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DriverLicenseIssueDate")
    public JAXBElement<DateType> createDriverLicenseIssueDate(DateType value) {
        return new JAXBElement<DateType>(_DriverLicenseIssueDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverLicenseRestrictionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriverLicenseRestrictionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DriverLicenseRestriction")
    public JAXBElement<DriverLicenseRestrictionType> createDriverLicenseRestriction(DriverLicenseRestrictionType value) {
        return new JAXBElement<DriverLicenseRestrictionType>(_DriverLicenseRestriction_QNAME, DriverLicenseRestrictionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverLicenseWithdrawalType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriverLicenseWithdrawalType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DriverLicenseWithdrawal")
    public JAXBElement<DriverLicenseWithdrawalType> createDriverLicenseWithdrawal(DriverLicenseWithdrawalType value) {
        return new JAXBElement<DriverLicenseWithdrawalType>(_DriverLicenseWithdrawal_QNAME, DriverLicenseWithdrawalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DriverLicenseWithdrawalEffectiveDate")
    public JAXBElement<DateType> createDriverLicenseWithdrawalEffectiveDate(DateType value) {
        return new JAXBElement<DateType>(_DriverLicenseWithdrawalEffectiveDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingAccidentSeverityAbstract")
    public JAXBElement<Object> createDrivingAccidentSeverityAbstract(Object value) {
        return new JAXBElement<Object>(_DrivingAccidentSeverityAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccidentSeverityCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AccidentSeverityCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingAccidentSeverityCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "DrivingAccidentSeverityAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingIncident")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingIncidentAugmentationPoint")
    public JAXBElement<Object> createDrivingIncidentAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_DrivingIncidentAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingIncidentHazMatAbstract")
    public JAXBElement<Object> createDrivingIncidentHazMatAbstract(Object value) {
        return new JAXBElement<Object>(_DrivingIncidentHazMatAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HazMatCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HazMatCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingIncidentHazMatCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "DrivingIncidentHazMatAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingIncidentLaserDetectionIndicator")
    public JAXBElement<Boolean> createDrivingIncidentLaserDetectionIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_DrivingIncidentLaserDetectionIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpeedMeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SpeedMeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingIncidentLegalSpeedRateMeasure")
    public JAXBElement<SpeedMeasureType> createDrivingIncidentLegalSpeedRateMeasure(SpeedMeasureType value) {
        return new JAXBElement<SpeedMeasureType>(_DrivingIncidentLegalSpeedRateMeasure_QNAME, SpeedMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingIncidentPassengerQuantityText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingIncidentRadarDetectionIndicator")
    public JAXBElement<Boolean> createDrivingIncidentRadarDetectionIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_DrivingIncidentRadarDetectionIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SpeedMeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SpeedMeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingIncidentRecordedSpeedRateMeasure")
    public JAXBElement<SpeedMeasureType> createDrivingIncidentRecordedSpeedRateMeasure(SpeedMeasureType value) {
        return new JAXBElement<SpeedMeasureType>(_DrivingIncidentRecordedSpeedRateMeasure_QNAME, SpeedMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingRestrictionEndDate")
    public JAXBElement<DateType> createDrivingRestrictionEndDate(DateType value) {
        return new JAXBElement<DateType>(_DrivingRestrictionEndDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "DrivingRestrictionText", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "DrivingRestrictionAbstract")
    public JAXBElement<TextType> createDrivingRestrictionText(TextType value) {
        return new JAXBElement<TextType>(_DrivingRestrictionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "EnforcementOfficialBadgeIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "EnforcementOfficialUnavailableSchedule")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "EnforcementOfficialUnit")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "EnforcementUnitName")
    public JAXBElement<TextType> createEnforcementUnitName(TextType value) {
        return new JAXBElement<TextType>(_EnforcementUnitName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncidentAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IncidentAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "IncidentAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "IncidentAugmentationPoint")
    public JAXBElement<IncidentAugmentationType> createIncidentAugmentation(IncidentAugmentationType value) {
        return new JAXBElement<IncidentAugmentationType>(_IncidentAugmentation_QNAME, IncidentAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "IncidentDamagedItem")
    public JAXBElement<ItemType> createIncidentDamagedItem(ItemType value) {
        return new JAXBElement<ItemType>(_IncidentDamagedItem_QNAME, ItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "IncidentGeneralCategoryAbstract")
    public JAXBElement<Object> createIncidentGeneralCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_IncidentGeneralCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "IncidentLevelAbstract")
    public JAXBElement<Object> createIncidentLevelAbstract(Object value) {
        return new JAXBElement<Object>(_IncidentLevelAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseLevelCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseLevelCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "IncidentLevelCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "IncidentLevelAbstract")
    public JAXBElement<OffenseLevelCodeType> createIncidentLevelCode(OffenseLevelCodeType value) {
        return new JAXBElement<OffenseLevelCodeType>(_IncidentLevelCode_QNAME, OffenseLevelCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "IncidentOfficialPresentIndicator")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "IncidentTrafficAccidentInvolvedIndicator")
    public JAXBElement<Boolean> createIncidentTrafficAccidentInvolvedIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncidentTrafficAccidentInvolvedIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViolatedStatuteAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ViolatedStatuteAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "IncidentViolatedStatuteAssociation")
    public JAXBElement<ViolatedStatuteAssociationType> createIncidentViolatedStatuteAssociation(ViolatedStatuteAssociationType value) {
        return new JAXBElement<ViolatedStatuteAssociationType>(_IncidentViolatedStatuteAssociation_QNAME, ViolatedStatuteAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemValueType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemValueType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ItemTotalDamageValue")
    public JAXBElement<ItemValueType> createItemTotalDamageValue(ItemValueType value) {
        return new JAXBElement<ItemValueType>(_ItemTotalDamageValue_QNAME, ItemValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JudicialOfficialType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JudicialOfficialType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "Judge")
    public JAXBElement<JudicialOfficialType> createJudge(JudicialOfficialType value) {
        return new JAXBElement<JudicialOfficialType>(_Judge_QNAME, JudicialOfficialType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "JudicialOfficialBarIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "JudicialOfficialBarMembership")
    public JAXBElement<JudicialOfficialBarMembershipType> createJudicialOfficialBarMembership(JudicialOfficialBarMembershipType value) {
        return new JAXBElement<JudicialOfficialBarMembershipType>(_JudicialOfficialBarMembership_QNAME, JudicialOfficialBarMembershipType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "JudicialOfficialRegistrationIdentification")
    public JAXBElement<IdentificationType> createJudicialOfficialRegistrationIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_JudicialOfficialRegistrationIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JurisdictionAuthorityCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JurisdictionAuthorityCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "JurisdictionANSID20AuthorityCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "JurisdictionAbstract")
    public JAXBElement<JurisdictionAuthorityCodeType> createJurisdictionANSID20AuthorityCode(JurisdictionAuthorityCodeType value) {
        return new JAXBElement<JurisdictionAuthorityCodeType>(_JurisdictionANSID20AuthorityCode_QNAME, JurisdictionAuthorityCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "LocationStateNCICLISCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "StateRepresentation")
    public JAXBElement<CountryCodeType> createLocationStateNCICLISCode(CountryCodeType value) {
        return new JAXBElement<CountryCodeType>(_LocationStateNCICLISCode_QNAME, CountryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "Offense")
    public JAXBElement<OffenseType> createOffense(OffenseType value) {
        return new JAXBElement<OffenseType>(_Offense_QNAME, OffenseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseChargeAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseChargeAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "OffenseChargeAssociation")
    public JAXBElement<OffenseChargeAssociationType> createOffenseChargeAssociation(OffenseChargeAssociationType value) {
        return new JAXBElement<OffenseChargeAssociationType>(_OffenseChargeAssociation_QNAME, OffenseChargeAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OffenseLocationAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OffenseLocationAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "OffenseLocationAssociation")
    public JAXBElement<OffenseLocationAssociationType> createOffenseLocationAssociation(OffenseLocationAssociationType value) {
        return new JAXBElement<OffenseLocationAssociationType>(_OffenseLocationAssociation_QNAME, OffenseLocationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationAlternateNameType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationAlternateNameType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "OrganizationAlternateName")
    public JAXBElement<OrganizationAlternateNameType> createOrganizationAlternateName(OrganizationAlternateNameType value) {
        return new JAXBElement<OrganizationAlternateNameType>(_OrganizationAlternateName_QNAME, OrganizationAlternateNameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "OrganizationAlternateNameCategoryAbstract")
    public JAXBElement<Object> createOrganizationAlternateNameCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_OrganizationAlternateNameCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ecf4.latest.gov.niem.release.niem.niem_core._4.PersonNameCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ecf4.latest.gov.niem.release.niem.niem_core._4.PersonNameCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "OrganizationAlternateNameCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "OrganizationAlternateNameCategoryAbstract")
    public JAXBElement<ecf4.latest.gov.niem.release.niem.niem_core._4.PersonNameCategoryCodeType> createOrganizationAlternateNameCategoryCode(ecf4.latest.gov.niem.release.niem.niem_core._4.PersonNameCategoryCodeType value) {
        return new JAXBElement<ecf4.latest.gov.niem.release.niem.niem_core._4.PersonNameCategoryCodeType>(_OrganizationAlternateNameCategoryCode_QNAME, ecf4.latest.gov.niem.release.niem.niem_core._4.PersonNameCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "OrganizationORIIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonAFISIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonAugmentationPoint")
    public JAXBElement<PersonAugmentationType> createPersonAugmentation(PersonAugmentationType value) {
        return new JAXBElement<PersonAugmentationType>(_PersonAugmentation_QNAME, PersonAugmentationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonBloodAlcoholContentNumberText")
    public JAXBElement<TextType> createPersonBloodAlcoholContentNumberText(TextType value) {
        return new JAXBElement<TextType>(_PersonBloodAlcoholContentNumberText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonChargeAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonChargeAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonChargeAssociation")
    public JAXBElement<PersonChargeAssociationType> createPersonChargeAssociation(PersonChargeAssociationType value) {
        return new JAXBElement<PersonChargeAssociationType>(_PersonChargeAssociation_QNAME, PersonChargeAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonEthnicityCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonEthnicityAbstract")
    public JAXBElement<EthnicityCodeType> createPersonEthnicityCode(EthnicityCodeType value) {
        return new JAXBElement<EthnicityCodeType>(_PersonEthnicityCode_QNAME, EthnicityCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EYECodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EYECodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonEyeColorCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonEyeColorAbstract")
    public JAXBElement<EYECodeType> createPersonEyeColorCode(EYECodeType value) {
        return new JAXBElement<EYECodeType>(_PersonEyeColorCode_QNAME, EYECodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonFBIIdentification")
    public JAXBElement<IdentificationType> createPersonFBIIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonFBIIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HAIRCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HAIRCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonHairColorCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonHairColorAbstract")
    public JAXBElement<HAIRCodeType> createPersonHairColorCode(HAIRCodeType value) {
        return new JAXBElement<HAIRCodeType>(_PersonHairColorCode_QNAME, HAIRCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonNameCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonNameCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonNameCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonNameCategoryAbstract")
    public JAXBElement<ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonNameCategoryCodeType> createPersonNameCategoryCode(ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonNameCategoryCodeType value) {
        return new JAXBElement<ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonNameCategoryCodeType>(_PersonNameCategoryCode_QNAME,ecf4.latest.gov.niem.release.niem.domains.jxdm._6.PersonNameCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RACECodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RACECodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonRaceCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonRaceAbstract")
    public JAXBElement<RACECodeType> createPersonRaceCode(RACECodeType value) {
        return new JAXBElement<RACECodeType>(_PersonRaceCode_QNAME, RACECodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonSexCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonSexAbstract")
    public JAXBElement<SEXCodeType> createPersonSexCode(SEXCodeType value) {
        return new JAXBElement<SEXCodeType>(_PersonSexCode_QNAME, SEXCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PersonStateFingerprintIdentification")
    public JAXBElement<IdentificationType> createPersonStateFingerprintIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonStateFingerprintIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SMTCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SMTCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "PhysicalFeatureCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PhysicalFeatureCategoryAbstract")
    public JAXBElement<SMTCodeType> createPhysicalFeatureCategoryCode(SMTCodeType value) {
        return new JAXBElement<SMTCodeType>(_PhysicalFeatureCategoryCode_QNAME, SMTCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProtectionOrderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProtectionOrderType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ProtectionOrder")
    public JAXBElement<ProtectionOrderType> createProtectionOrder(ProtectionOrderType value) {
        return new JAXBElement<ProtectionOrderType>(_ProtectionOrder_QNAME, ProtectionOrderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ProtectionOrderConditionAbstract")
    public JAXBElement<Object> createProtectionOrderConditionAbstract(Object value) {
        return new JAXBElement<Object>(_ProtectionOrderConditionAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PCOCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PCOCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ProtectionOrderConditionCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "ProtectionOrderConditionAbstract")
    public JAXBElement<PCOCodeType> createProtectionOrderConditionCode(PCOCodeType value) {
        return new JAXBElement<PCOCodeType>(_ProtectionOrderConditionCode_QNAME, PCOCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ProtectionOrderConditionText")
    public JAXBElement<TextType> createProtectionOrderConditionText(TextType value) {
        return new JAXBElement<TextType>(_ProtectionOrderConditionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "ProtectionOrderRestrictedPerson")
    public JAXBElement<PersonType> createProtectionOrderRestrictedPerson(PersonType value) {
        return new JAXBElement<PersonType>(_ProtectionOrderRestrictedPerson_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "RapSheetTransactionControlIdentification")
    public JAXBElement<IdentificationType> createRapSheetTransactionControlIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_RapSheetTransactionControlIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "RegisteredOffenderIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "RegisteredSexOffender")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "Sentence")
    public JAXBElement<SentenceType> createSentence(SentenceType value) {
        return new JAXBElement<SentenceType>(_Sentence_QNAME, SentenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "SentenceAugmentationPoint")
    public JAXBElement<Object> createSentenceAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_SentenceAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ChargeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "SentenceCharge")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "SentenceDescriptionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "SentenceTerm")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "SeverityLevelDescriptionText")
    public JAXBElement<TextType> createSeverityLevelDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_SeverityLevelDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatuteType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "Statute")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "StatuteCodeIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "StatuteCodeSectionIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "StatuteDescriptionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "StatuteJurisdiction")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "StatuteLevelText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "StatuteOffenseIdentification")
    public JAXBElement<IdentificationType> createStatuteOffenseIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_StatuteOffenseIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "SubjectAugmentationPoint")
    public JAXBElement<Object> createSubjectAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_SubjectAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "SubjectIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "SubjectSupervision")
    public JAXBElement<SupervisionType> createSubjectSupervision(SupervisionType value) {
        return new JAXBElement<SupervisionType>(_SubjectSupervision_QNAME, SupervisionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "SupervisionFineAmount")
    public JAXBElement<AmountType> createSupervisionFineAmount(AmountType value) {
        return new JAXBElement<AmountType>(_SupervisionFineAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VMACodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VMACodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "VehicleMakeCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "VehicleMakeAbstract")
    public JAXBElement<VMACodeType> createVehicleMakeCode(VMACodeType value) {
        return new JAXBElement<VMACodeType>(_VehicleMakeCode_QNAME, VMACodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VMOCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VMOCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "VehicleModelCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "VehicleModelAbstract")
    public JAXBElement<VMOCodeType> createVehicleModelCode(VMOCodeType value) {
        return new JAXBElement<VMOCodeType>(_VehicleModelCode_QNAME, VMOCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VSTCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VSTCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "VehicleStyleCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ItemStyleAbstract")
    public JAXBElement<VSTCodeType> createVehicleStyleCode(VSTCodeType value) {
        return new JAXBElement<VSTCodeType>(_VehicleStyleCode_QNAME, VSTCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "WarrantExtraditionLimitationAbstract")
    public JAXBElement<Object> createWarrantExtraditionLimitationAbstract(Object value) {
        return new JAXBElement<Object>(_WarrantExtraditionLimitationAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EXLCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EXLCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", name = "WarrantExtraditionLimitationCode", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", substitutionHeadName = "WarrantExtraditionLimitationAbstract")
    public JAXBElement<EXLCodeType> createWarrantExtraditionLimitationCode(EXLCodeType value) {
        return new JAXBElement<EXLCodeType>(_WarrantExtraditionLimitationCode_QNAME, EXLCodeType.class, null, value);
    }

}
