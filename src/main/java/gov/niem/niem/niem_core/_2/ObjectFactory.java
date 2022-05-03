
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.niem.ansi_d20._2.DriverLicenseClassCodeType;
import gov.niem.niem.ansi_d20._2.DrivingRestrictionCodeType;
import gov.niem.niem.ansi_nist._2.FingerprintType;
import gov.niem.niem.fbi._2.EYECodeType;
import gov.niem.niem.fbi._2.EthnicityCodeType;
import gov.niem.niem.fbi._2.HAICodeType;
import gov.niem.niem.fbi._2.RACCodeType;
import gov.niem.niem.fbi._2.SEXCodeType;
import gov.niem.niem.fbi._2.SMTCodeType;
import gov.niem.niem.fbi._2.VCOCodeType;
import gov.niem.niem.fbi._2.VMACodeType;
import gov.niem.niem.fbi._2.VMOCodeType;
import gov.niem.niem.fbi._2.VSTCodeType;
import gov.niem.niem.fips_10_4._2.CountryCodeType;
import gov.niem.niem.fips_6_4._2.USCountyCodeType;
import gov.niem.niem.iso_639_3._2.LanguageCodeType;
import gov.niem.niem.nonauthoritative_code._2.FamilyKinshipCodeType;
import gov.niem.niem.nonauthoritative_code._2.MarriageCategoryCodeType;
import gov.niem.niem.proxy.xsd._2.AnyURI;
import gov.niem.niem.proxy.xsd._2.Base64Binary;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.proxy.xsd._2.Date;
import gov.niem.niem.proxy.xsd._2.DateTime;
import gov.niem.niem.proxy.xsd._2.GYear;
import gov.niem.niem.proxy.xsd._2.String;
import gov.niem.niem.proxy.xsd._2.Time;
import gov.niem.niem.structures._2.ReferenceType;
import gov.niem.niem.unece_rec20_misc._2.LengthCodeType;
import gov.niem.niem.unece_rec20_misc._2.MassCodeType;
import gov.niem.niem.usps_states._2.USStateCodeType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.niem.niem.niem_core._2 package. 
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

    private final static QName _Case_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Case");
    private final static QName _Fingerprint_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Fingerprint");
    private final static QName _EntityRepresentation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EntityRepresentation");
    private final static QName _IdentificationJurisdiction_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IdentificationJurisdiction");
    private final static QName _ActivityReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ActivityReference");
    private final static QName _ActivityDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ActivityDate");
    private final static QName _ActivityDateRepresentation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ActivityDateRepresentation");
    private final static QName _ActivityDateRange_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ActivityDateRange");
    private final static QName _ActivityDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ActivityDescriptionText");
    private final static QName _ActivityDisposition_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ActivityDisposition");
    private final static QName _ActivityIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ActivityIdentification");
    private final static QName _ActivityStatus_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ActivityStatus");
    private final static QName _Address_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Address");
    private final static QName _AddressDeliveryPoint_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressDeliveryPoint");
    private final static QName _AddressDeliveryPointID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressDeliveryPointID");
    private final static QName _AddressDeliveryPointText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressDeliveryPointText");
    private final static QName _AddressFullText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressFullText");
    private final static QName _AddressRepresentation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressRepresentation");
    private final static QName _AddressPrivateMailboxText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressPrivateMailboxText");
    private final static QName _AddressRecipientName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressRecipientName");
    private final static QName _AddressSecondaryUnitText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressSecondaryUnitText");
    private final static QName _Association_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Association");
    private final static QName _Attachment_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Attachment");
    private final static QName _BinaryBase64Object_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BinaryBase64Object");
    private final static QName _BinaryObject_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BinaryObject");
    private final static QName _BinaryCaptureDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BinaryCaptureDate");
    private final static QName _BinaryCapturer_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BinaryCapturer");
    private final static QName _BinaryCategoryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BinaryCategoryText");
    private final static QName _BinaryDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BinaryDescriptionText");
    private final static QName _BinaryFormatStandardName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BinaryFormatStandardName");
    private final static QName _BinaryLocationURI_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BinaryLocationURI");
    private final static QName _BinarySizeValue_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BinarySizeValue");
    private final static QName _Biometric_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Biometric");
    private final static QName _BiometricCapturer_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BiometricCapturer");
    private final static QName _BiometricImage_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "BiometricImage");
    private final static QName _CapabilityDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "CapabilityDescriptionText");
    private final static QName _CaseCategoryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "CaseCategoryText");
    private final static QName _CaseDisposition_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "CaseDisposition");
    private final static QName _CaseDispositionDecision_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "CaseDispositionDecision");
    private final static QName _CaseDispositionFinalDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "CaseDispositionFinalDate");
    private final static QName _CaseDocketID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "CaseDocketID");
    private final static QName _CaseFiling_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "CaseFiling");
    private final static QName _CaseTitleText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "CaseTitleText");
    private final static QName _CaseTrackingID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "CaseTrackingID");
    private final static QName _ContactEmailID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactEmailID");
    private final static QName _ContactMeans_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactMeans");
    private final static QName _ContactEntity_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactEntity");
    private final static QName _ContactEntityDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactEntityDescriptionText");
    private final static QName _ContactFaxNumber_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactFaxNumber");
    private final static QName _ContactTelephoneNumber_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactTelephoneNumber");
    private final static QName _ContactInformationReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactInformationReference");
    private final static QName _ContactInformation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactInformation");
    private final static QName _ContactInformationDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactInformationDescriptionText");
    private final static QName _ContactInformationIsDayIndicator_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactInformationIsDayIndicator");
    private final static QName _ContactInformationIsEmergencyIndicator_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactInformationIsEmergencyIndicator");
    private final static QName _ContactInformationIsEveningIndicator_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactInformationIsEveningIndicator");
    private final static QName _ContactInformationIsHomeIndicator_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactInformationIsHomeIndicator");
    private final static QName _ContactInformationIsNightIndicator_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactInformationIsNightIndicator");
    private final static QName _ContactInformationIsPrimaryIndicator_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactInformationIsPrimaryIndicator");
    private final static QName _ContactInformationIsWorkIndicator_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactInformationIsWorkIndicator");
    private final static QName _ContactMailingAddress_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactMailingAddress");
    private final static QName _ContactResponder_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactResponder");
    private final static QName _ConveyanceReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ConveyanceReference");
    private final static QName _ConveyanceColorPrimaryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ConveyanceColorPrimaryText");
    private final static QName _ItemColor_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ItemColor");
    private final static QName _ConveyanceRegistrationPlateIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ConveyanceRegistrationPlateIdentification");
    private final static QName _DNAImage_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DNAImage");
    private final static QName _DNALocus_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DNALocus");
    private final static QName _DNALocusCategoryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DNALocusCategoryText");
    private final static QName _DNALocusValue_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DNALocusValue");
    private final static QName _Date_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Date");
    private final static QName _DateRepresentation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DateRepresentation");
    private final static QName _DateRange_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DateRange");
    private final static QName _DateTime_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DateTime");
    private final static QName _Disposition_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Disposition");
    private final static QName _DispositionCategoryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DispositionCategoryText");
    private final static QName _DispositionDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DispositionDate");
    private final static QName _DispositionDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DispositionDescriptionText");
    private final static QName _DispositionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DispositionText");
    private final static QName _DocumentReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentReference");
    private final static QName _Document_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Document");
    private final static QName _DocumentApplicationName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentApplicationName");
    private final static QName _DocumentBinary_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentBinary");
    private final static QName _DocumentCategoryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentCategoryText");
    private final static QName _DocumentDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentDescriptionText");
    private final static QName _DocumentEffectiveDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentEffectiveDate");
    private final static QName _DocumentFileControlID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentFileControlID");
    private final static QName _DocumentFiledDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentFiledDate");
    private final static QName _DocumentIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentIdentification");
    private final static QName _DocumentInformationCutOffDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentInformationCutOffDate");
    private final static QName _DocumentLanguage_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentLanguage");
    private final static QName _DocumentLanguageCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentLanguageCode");
    private final static QName _DocumentPostDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentPostDate");
    private final static QName _DocumentReceivedDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentReceivedDate");
    private final static QName _DocumentSequenceID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentSequenceID");
    private final static QName _DocumentStatus_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentStatus");
    private final static QName _DocumentSubmissionFee_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentSubmissionFee");
    private final static QName _DocumentSubmitter_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentSubmitter");
    private final static QName _DocumentTitleText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DocumentTitleText");
    private final static QName _DriverLicenseReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicenseReference");
    private final static QName _DriverLicense_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicense");
    private final static QName _DriverLicenseBase_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicenseBase");
    private final static QName _DriverLicenseCommercialClass_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicenseCommercialClass");
    private final static QName _DriverLicenseCommercialClassCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicenseCommercialClassCode");
    private final static QName _DriverLicenseExpirationDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicenseExpirationDate");
    private final static QName _DriverLicenseIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicenseIdentification");
    private final static QName _DriverLicenseIssueDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicenseIssueDate");
    private final static QName _DriverLicenseRestriction_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicenseRestriction");
    private final static QName _DriverLicenseWithdrawal_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicenseWithdrawal");
    private final static QName _DriverLicenseWithdrawalEffectiveDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DriverLicenseWithdrawalEffectiveDate");
    private final static QName _DrivingRestrictionCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DrivingRestrictionCode");
    private final static QName _DrivingRestrictionValue_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DrivingRestrictionValue");
    private final static QName _DrivingRestrictionEndDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DrivingRestrictionEndDate");
    private final static QName _DrivingRestrictionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DrivingRestrictionText");
    private final static QName _EffectiveDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EffectiveDate");
    private final static QName _EmployeeReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EmployeeReference");
    private final static QName _Employer_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Employer");
    private final static QName _EndDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EndDate");
    private final static QName _EntityReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EntityReference");
    private final static QName _Entity_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Entity");
    private final static QName _EntityOrganizationReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EntityOrganizationReference");
    private final static QName _EntityOrganization_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EntityOrganization");
    private final static QName _EntityPersonReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EntityPersonReference");
    private final static QName _EntityPerson_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EntityPerson");
    private final static QName _FacilityIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "FacilityIdentification");
    private final static QName _FamilyKinshipCategory_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "FamilyKinshipCategory");
    private final static QName _FamilyKinshipCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "FamilyKinshipCode");
    private final static QName _FamilyKinshipText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "FamilyKinshipText");
    private final static QName _FinancialObligationExemptionAmount_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "FinancialObligationExemptionAmount");
    private final static QName _FullTelephoneNumber_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "FullTelephoneNumber");
    private final static QName _TelephoneNumberRepresentation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneNumberRepresentation");
    private final static QName _GuardianAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "GuardianAssociation");
    private final static QName _Identification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Identification");
    private final static QName _IdentificationCategory_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IdentificationCategory");
    private final static QName _IdentificationCategoryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IdentificationCategoryText");
    private final static QName _IdentificationID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IdentificationID");
    private final static QName _IdentificationSourceText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IdentificationSourceText");
    private final static QName _Image_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Image");
    private final static QName _ImmediateFamilyAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ImmediateFamilyAssociation");
    private final static QName _IncidentReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IncidentReference");
    private final static QName _IncidentLocation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IncidentLocation");
    private final static QName _IncidentVehicleAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IncidentVehicleAssociation");
    private final static QName _Insurance_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Insurance");
    private final static QName _InsuranceActiveIndicator_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "InsuranceActiveIndicator");
    private final static QName _InsuranceCarrierName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "InsuranceCarrierName");
    private final static QName _InsuranceCoverageCategory_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "InsuranceCoverageCategory");
    private final static QName _InsuranceCoverageCategoryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "InsuranceCoverageCategoryText");
    private final static QName _InternationalTelephoneNumber_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "InternationalTelephoneNumber");
    private final static QName _Item_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Item");
    private final static QName _ItemDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ItemDescriptionText");
    private final static QName _ItemModelYearDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ItemModelYearDate");
    private final static QName _ItemOtherIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ItemOtherIdentification");
    private final static QName _ItemStyle_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ItemStyle");
    private final static QName _ItemValue_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ItemValue");
    private final static QName _Language_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Language");
    private final static QName _LanguageCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LanguageCode");
    private final static QName _LengthUnitCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LengthUnitCode");
    private final static QName _LocationReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationReference");
    private final static QName _Location_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Location");
    private final static QName _LocationAddress_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationAddress");
    private final static QName _LocationCityName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationCityName");
    private final static QName _LocationCountry_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationCountry");
    private final static QName _LocationCountryFIPS104Code_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationCountryFIPS10-4Code");
    private final static QName _LocationCountryName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationCountryName");
    private final static QName _LocationCounty_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationCounty");
    private final static QName _LocationCountyCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationCountyCode");
    private final static QName _LocationCountyName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationCountyName");
    private final static QName _LocationDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationDescriptionText");
    private final static QName _LocationName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationName");
    private final static QName _LocationPostalCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationPostalCode");
    private final static QName _LocationPostalExtensionCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationPostalExtensionCode");
    private final static QName _LocationRouteName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationRouteName");
    private final static QName _LocationState_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationState");
    private final static QName _LocationStateName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationStateName");
    private final static QName _LocationStateUSPostalServiceCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationStateUSPostalServiceCode");
    private final static QName _LocationStreet_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationStreet");
    private final static QName _MarriageAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "MarriageAssociation");
    private final static QName _Measure_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Measure");
    private final static QName _MeasureText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "MeasureText");
    private final static QName _MeasureValue_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "MeasureValue");
    private final static QName _MeasureUnitText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "MeasureUnitText");
    private final static QName _Metadata_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Metadata");
    private final static QName _NANPTelephoneNumber_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "NANPTelephoneNumber");
    private final static QName _Obligation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Obligation");
    private final static QName _ObligationCategoryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationCategoryText");
    private final static QName _ObligationDue_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationDue");
    private final static QName _ObligationDueAmount_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationDueAmount");
    private final static QName _ObligationEndDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationEndDate");
    private final static QName _ObligationEntity_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationEntity");
    private final static QName _ObligationExemption_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationExemption");
    private final static QName _ObligationExemptionDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationExemptionDescriptionText");
    private final static QName _ObligationPeriodText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationPeriodText");
    private final static QName _ObligationRecipient_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationRecipient");
    private final static QName _ObligationRecurrence_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationRecurrence");
    private final static QName _ObligationRequirementDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationRequirementDescriptionText");
    private final static QName _ObligationStartDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ObligationStartDate");
    private final static QName _OrganizationReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationReference");
    private final static QName _Organization_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Organization");
    private final static QName _OrganizationAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationAssociation");
    private final static QName _OrganizationContactInformationAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationContactInformationAssociation");
    private final static QName _OrganizationIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationIdentification");
    private final static QName _OrganizationLocation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationLocation");
    private final static QName _OrganizationName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationName");
    private final static QName _OrganizationPrimaryContactInformation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationPrimaryContactInformation");
    private final static QName _OrganizationSubUnitName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationSubUnitName");
    private final static QName _OrganizationTaxIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationTaxIdentification");
    private final static QName _OrganizationUnitName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationUnitName");
    private final static QName _PersonReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonReference");
    private final static QName _Person_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Person");
    private final static QName _PersonAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonAssociation");
    private final static QName _PersonBirthDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonBirthDate");
    private final static QName _PersonCapability_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonCapability");
    private final static QName _PersonChildReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonChildReference");
    private final static QName _PersonCitizenship_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonCitizenship");
    private final static QName _PersonCitizenshipFIPS104Code_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonCitizenshipFIPS10-4Code");
    private final static QName _PersonContactInformationAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonContactInformationAssociation");
    private final static QName _PersonDNA_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonDNA");
    private final static QName _PersonDeathDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonDeathDate");
    private final static QName _PersonDependentReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonDependentReference");
    private final static QName _PersonEmploymentAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonEmploymentAssociation");
    private final static QName _PersonEthnicity_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonEthnicity");
    private final static QName _PersonEthnicityCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonEthnicityCode");
    private final static QName _PersonEthnicityText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonEthnicityText");
    private final static QName _PersonEyeColor_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonEyeColor");
    private final static QName _PersonEyeColorCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonEyeColorCode");
    private final static QName _PersonFingerprintSet_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonFingerprintSet");
    private final static QName _PersonFullName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonFullName");
    private final static QName _PersonGangAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonGangAssociation");
    private final static QName _PersonGivenName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonGivenName");
    private final static QName _PersonGuardianReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonGuardianReference");
    private final static QName _PersonHairColor_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonHairColor");
    private final static QName _PersonHairColorCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonHairColorCode");
    private final static QName _PersonHeightMeasure_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonHeightMeasure");
    private final static QName _PersonLanguageEnglishIndicator_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonLanguageEnglishIndicator");
    private final static QName _PersonMaidenName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonMaidenName");
    private final static QName _PersonMiddleName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonMiddleName");
    private final static QName _PersonName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonName");
    private final static QName _PersonNamePrefixText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonNamePrefixText");
    private final static QName _PersonNameSuffixText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonNameSuffixText");
    private final static QName _PersonOrganizationAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonOrganizationAssociation");
    private final static QName _PersonOtherIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonOtherIdentification");
    private final static QName _PersonParentReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonParentReference");
    private final static QName _PersonPhysicalFeature_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonPhysicalFeature");
    private final static QName _PersonPrimaryLanguage_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonPrimaryLanguage");
    private final static QName _PersonRace_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonRace");
    private final static QName _PersonRaceCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonRaceCode");
    private final static QName _PersonRaceText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonRaceText");
    private final static QName _PersonSex_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonSex");
    private final static QName _PersonSexCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonSexCode");
    private final static QName _PersonStateIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonStateIdentification");
    private final static QName _PersonSurName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonSurName");
    private final static QName _PersonTaxIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonTaxIdentification");
    private final static QName _PersonUnionCategory_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonUnionCategory");
    private final static QName _PersonUnionCategoryCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonUnionCategoryCode");
    private final static QName _PersonUnionStatus_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonUnionStatus");
    private final static QName _PersonWeightMeasure_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonWeightMeasure");
    private final static QName _PhysicalFeatureCategory_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PhysicalFeatureCategory");
    private final static QName _PhysicalFeatureCategoryCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PhysicalFeatureCategoryCode");
    private final static QName _PhysicalFeatureCategoryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PhysicalFeatureCategoryText");
    private final static QName _RegistrationJurisdiction_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "RegistrationJurisdiction");
    private final static QName _RelatedCaseAssociation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "RelatedCaseAssociation");
    private final static QName _RoleOf_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "RoleOf");
    private final static QName _RoleOfItemReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "RoleOfItemReference");
    private final static QName _RoleOfOrganizationReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "RoleOfOrganizationReference");
    private final static QName _RoleOfPersonReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "RoleOfPersonReference");
    private final static QName _ScheduleActivityText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ScheduleActivityText");
    private final static QName _ScheduleDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ScheduleDate");
    private final static QName _ScheduleDayEndTime_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ScheduleDayEndTime");
    private final static QName _ScheduleDayStartTime_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ScheduleDayStartTime");
    private final static QName _SensitivityText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "SensitivityText");
    private final static QName _SpeedUnitCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "SpeedUnitCode");
    private final static QName _StartDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StartDate");
    private final static QName _StatusDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StatusDate");
    private final static QName _StatusDescriptionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StatusDescriptionText");
    private final static QName _StatusText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StatusText");
    private final static QName _StreetCategoryText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StreetCategoryText");
    private final static QName _StreetExtensionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StreetExtensionText");
    private final static QName _StreetFullText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StreetFullText");
    private final static QName _StreetName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StreetName");
    private final static QName _StreetNumberText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StreetNumberText");
    private final static QName _StreetPostdirectionalText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StreetPostdirectionalText");
    private final static QName _StreetPredirectionalText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StreetPredirectionalText");
    private final static QName _StructuredAddress_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StructuredAddress");
    private final static QName _Supervision_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Supervision");
    private final static QName _SupervisionCustodyStatus_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "SupervisionCustodyStatus");
    private final static QName _SupervisionFacility_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "SupervisionFacility");
    private final static QName _TelephoneAreaCodeID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneAreaCodeID");
    private final static QName _TelephoneCountryCodeID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneCountryCodeID");
    private final static QName _TelephoneExchangeID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneExchangeID");
    private final static QName _TelephoneLineID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneLineID");
    private final static QName _TelephoneNumber_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneNumber");
    private final static QName _TelephoneNumberFullID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneNumberFullID");
    private final static QName _TelephoneNumberID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneNumberID");
    private final static QName _TelephoneSuffixID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneSuffixID");
    private final static QName _Vehicle_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Vehicle");
    private final static QName _VehicleColorPrimaryCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "VehicleColorPrimaryCode");
    private final static QName _VehicleIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "VehicleIdentification");
    private final static QName _VehicleMakeCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "VehicleMakeCode");
    private final static QName _VehicleModelCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "VehicleModelCode");
    private final static QName _VehicleStyleCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "VehicleStyleCode");
    private final static QName _WeightUnitCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "WeightUnitCode");
    private final static QName _Year_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Year");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.niem.niem.niem_core._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CaseType }
     * 
     */
    public CaseType createCaseType() {
        return new CaseType();
    }

    /**
     * Create an instance of {@link DateRangeType }
     * 
     */
    public DateRangeType createDateRangeType() {
        return new DateRangeType();
    }

    /**
     * Create an instance of {@link IdentificationType }
     * 
     */
    public IdentificationType createIdentificationType() {
        return new IdentificationType();
    }

    /**
     * Create an instance of {@link EntityType }
     * 
     */
    public EntityType createEntityType() {
        return new EntityType();
    }

    /**
     * Create an instance of {@link TextType }
     * 
     */
    public TextType createTextType() {
        return new TextType();
    }

    /**
     * Create an instance of {@link OrganizationType }
     * 
     */
    public OrganizationType createOrganizationType() {
        return new OrganizationType();
    }

    /**
     * Create an instance of {@link IncidentType }
     * 
     */
    public IncidentType createIncidentType() {
        return new IncidentType();
    }

    /**
     * Create an instance of {@link ImageType }
     * 
     */
    public ImageType createImageType() {
        return new ImageType();
    }

    /**
     * Create an instance of {@link RelatedActivityAssociationType }
     * 
     */
    public RelatedActivityAssociationType createRelatedActivityAssociationType() {
        return new RelatedActivityAssociationType();
    }

    /**
     * Create an instance of {@link AmountType }
     * 
     */
    public AmountType createAmountType() {
        return new AmountType();
    }

    /**
     * Create an instance of {@link DocumentType }
     * 
     */
    public DocumentType createDocumentType() {
        return new DocumentType();
    }

    /**
     * Create an instance of {@link DateType }
     * 
     */
    public DateType createDateType() {
        return new DateType();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link DriverLicenseType }
     * 
     */
    public DriverLicenseType createDriverLicenseType() {
        return new DriverLicenseType();
    }

    /**
     * Create an instance of {@link NumericType }
     * 
     */
    public NumericType createNumericType() {
        return new NumericType();
    }

    /**
     * Create an instance of {@link MeasureType }
     * 
     */
    public MeasureType createMeasureType() {
        return new MeasureType();
    }

    /**
     * Create an instance of {@link LocationType }
     * 
     */
    public LocationType createLocationType() {
        return new LocationType();
    }

    /**
     * Create an instance of {@link ScheduleDayType }
     * 
     */
    public ScheduleDayType createScheduleDayType() {
        return new ScheduleDayType();
    }

    /**
     * Create an instance of {@link StatusType }
     * 
     */
    public StatusType createStatusType() {
        return new StatusType();
    }

    /**
     * Create an instance of {@link DriverLicenseAssociationType }
     * 
     */
    public DriverLicenseAssociationType createDriverLicenseAssociationType() {
        return new DriverLicenseAssociationType();
    }

    /**
     * Create an instance of {@link BiometricType }
     * 
     */
    public BiometricType createBiometricType() {
        return new BiometricType();
    }

    /**
     * Create an instance of {@link ItemValueType }
     * 
     */
    public ItemValueType createItemValueType() {
        return new ItemValueType();
    }

    /**
     * Create an instance of {@link JurisdictionType }
     * 
     */
    public JurisdictionType createJurisdictionType() {
        return new JurisdictionType();
    }

    /**
     * Create an instance of {@link SupervisionType }
     * 
     */
    public SupervisionType createSupervisionType() {
        return new SupervisionType();
    }

    /**
     * Create an instance of {@link DispositionType }
     * 
     */
    public DispositionType createDispositionType() {
        return new DispositionType();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link AssociationType }
     * 
     */
    public AssociationType createAssociationType() {
        return new AssociationType();
    }

    /**
     * Create an instance of {@link BinaryType }
     * 
     */
    public BinaryType createBinaryType() {
        return new BinaryType();
    }

    /**
     * Create an instance of {@link NonNegativeDecimalType }
     * 
     */
    public NonNegativeDecimalType createNonNegativeDecimalType() {
        return new NonNegativeDecimalType();
    }

    /**
     * Create an instance of {@link CaseDispositionType }
     * 
     */
    public CaseDispositionType createCaseDispositionType() {
        return new CaseDispositionType();
    }

    /**
     * Create an instance of {@link CaseDispositionDecisionType }
     * 
     */
    public CaseDispositionDecisionType createCaseDispositionDecisionType() {
        return new CaseDispositionDecisionType();
    }

    /**
     * Create an instance of {@link TelephoneNumberType }
     * 
     */
    public TelephoneNumberType createTelephoneNumberType() {
        return new TelephoneNumberType();
    }

    /**
     * Create an instance of {@link ContactInformationType }
     * 
     */
    public ContactInformationType createContactInformationType() {
        return new ContactInformationType();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link DNALocusType }
     * 
     */
    public DNALocusType createDNALocusType() {
        return new DNALocusType();
    }

    /**
     * Create an instance of {@link ApplicationNameType }
     * 
     */
    public ApplicationNameType createApplicationNameType() {
        return new ApplicationNameType();
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
     * Create an instance of {@link DriverLicenseWithdrawalType }
     * 
     */
    public DriverLicenseWithdrawalType createDriverLicenseWithdrawalType() {
        return new DriverLicenseWithdrawalType();
    }

    /**
     * Create an instance of {@link FullTelephoneNumberType }
     * 
     */
    public FullTelephoneNumberType createFullTelephoneNumberType() {
        return new FullTelephoneNumberType();
    }

    /**
     * Create an instance of {@link GuardianAssociationType }
     * 
     */
    public GuardianAssociationType createGuardianAssociationType() {
        return new GuardianAssociationType();
    }

    /**
     * Create an instance of {@link ImmediateFamilyAssociationType }
     * 
     */
    public ImmediateFamilyAssociationType createImmediateFamilyAssociationType() {
        return new ImmediateFamilyAssociationType();
    }

    /**
     * Create an instance of {@link ActivityConveyanceAssociationType }
     * 
     */
    public ActivityConveyanceAssociationType createActivityConveyanceAssociationType() {
        return new ActivityConveyanceAssociationType();
    }

    /**
     * Create an instance of {@link InsuranceType }
     * 
     */
    public InsuranceType createInsuranceType() {
        return new InsuranceType();
    }

    /**
     * Create an instance of {@link InternationalTelephoneNumberType }
     * 
     */
    public InternationalTelephoneNumberType createInternationalTelephoneNumberType() {
        return new InternationalTelephoneNumberType();
    }

    /**
     * Create an instance of {@link ProperNameTextType }
     * 
     */
    public ProperNameTextType createProperNameTextType() {
        return new ProperNameTextType();
    }

    /**
     * Create an instance of {@link StreetType }
     * 
     */
    public StreetType createStreetType() {
        return new StreetType();
    }

    /**
     * Create an instance of {@link PersonUnionAssociationType }
     * 
     */
    public PersonUnionAssociationType createPersonUnionAssociationType() {
        return new PersonUnionAssociationType();
    }

    /**
     * Create an instance of {@link MetadataType }
     * 
     */
    public MetadataType createMetadataType() {
        return new MetadataType();
    }

    /**
     * Create an instance of {@link NANPTelephoneNumberType }
     * 
     */
    public NANPTelephoneNumberType createNANPTelephoneNumberType() {
        return new NANPTelephoneNumberType();
    }

    /**
     * Create an instance of {@link ObligationType }
     * 
     */
    public ObligationType createObligationType() {
        return new ObligationType();
    }

    /**
     * Create an instance of {@link ObligationExemptionType }
     * 
     */
    public ObligationExemptionType createObligationExemptionType() {
        return new ObligationExemptionType();
    }

    /**
     * Create an instance of {@link ObligationRecurrenceType }
     * 
     */
    public ObligationRecurrenceType createObligationRecurrenceType() {
        return new ObligationRecurrenceType();
    }

    /**
     * Create an instance of {@link OrganizationAssociationType }
     * 
     */
    public OrganizationAssociationType createOrganizationAssociationType() {
        return new OrganizationAssociationType();
    }

    /**
     * Create an instance of {@link OrganizationContactInformationAssociationType }
     * 
     */
    public OrganizationContactInformationAssociationType createOrganizationContactInformationAssociationType() {
        return new OrganizationContactInformationAssociationType();
    }

    /**
     * Create an instance of {@link PersonAssociationType }
     * 
     */
    public PersonAssociationType createPersonAssociationType() {
        return new PersonAssociationType();
    }

    /**
     * Create an instance of {@link CapabilityType }
     * 
     */
    public CapabilityType createCapabilityType() {
        return new CapabilityType();
    }

    /**
     * Create an instance of {@link PersonContactInformationAssociationType }
     * 
     */
    public PersonContactInformationAssociationType createPersonContactInformationAssociationType() {
        return new PersonContactInformationAssociationType();
    }

    /**
     * Create an instance of {@link DNAType }
     * 
     */
    public DNAType createDNAType() {
        return new DNAType();
    }

    /**
     * Create an instance of {@link PersonEmploymentAssociationType }
     * 
     */
    public PersonEmploymentAssociationType createPersonEmploymentAssociationType() {
        return new PersonEmploymentAssociationType();
    }

    /**
     * Create an instance of {@link FingerprintSetType }
     * 
     */
    public FingerprintSetType createFingerprintSetType() {
        return new FingerprintSetType();
    }

    /**
     * Create an instance of {@link PersonNameTextType }
     * 
     */
    public PersonNameTextType createPersonNameTextType() {
        return new PersonNameTextType();
    }

    /**
     * Create an instance of {@link PersonOrganizationAssociationType }
     * 
     */
    public PersonOrganizationAssociationType createPersonOrganizationAssociationType() {
        return new PersonOrganizationAssociationType();
    }

    /**
     * Create an instance of {@link LengthMeasureType }
     * 
     */
    public LengthMeasureType createLengthMeasureType() {
        return new LengthMeasureType();
    }

    /**
     * Create an instance of {@link PersonNameType }
     * 
     */
    public PersonNameType createPersonNameType() {
        return new PersonNameType();
    }

    /**
     * Create an instance of {@link PhysicalFeatureType }
     * 
     */
    public PhysicalFeatureType createPhysicalFeatureType() {
        return new PhysicalFeatureType();
    }

    /**
     * Create an instance of {@link PersonLanguageType }
     * 
     */
    public PersonLanguageType createPersonLanguageType() {
        return new PersonLanguageType();
    }

    /**
     * Create an instance of {@link MarriageStatusType }
     * 
     */
    public MarriageStatusType createMarriageStatusType() {
        return new MarriageStatusType();
    }

    /**
     * Create an instance of {@link WeightMeasureType }
     * 
     */
    public WeightMeasureType createWeightMeasureType() {
        return new WeightMeasureType();
    }

    /**
     * Create an instance of {@link StructuredAddressType }
     * 
     */
    public StructuredAddressType createStructuredAddressType() {
        return new StructuredAddressType();
    }

    /**
     * Create an instance of {@link FacilityType }
     * 
     */
    public FacilityType createFacilityType() {
        return new FacilityType();
    }

    /**
     * Create an instance of {@link VehicleType }
     * 
     */
    public VehicleType createVehicleType() {
        return new VehicleType();
    }

    /**
     * Create an instance of {@link ActivityType }
     * 
     */
    public ActivityType createActivityType() {
        return new ActivityType();
    }

    /**
     * Create an instance of {@link ConveyanceType }
     * 
     */
    public ConveyanceType createConveyanceType() {
        return new ConveyanceType();
    }

    /**
     * Create an instance of {@link ItemRegistrationType }
     * 
     */
    public ItemRegistrationType createItemRegistrationType() {
        return new ItemRegistrationType();
    }

    /**
     * Create an instance of {@link PropertyType }
     * 
     */
    public PropertyType createPropertyType() {
        return new PropertyType();
    }

    /**
     * Create an instance of {@link SpeedMeasureType }
     * 
     */
    public SpeedMeasureType createSpeedMeasureType() {
        return new SpeedMeasureType();
    }

    /**
     * Create an instance of {@link TangibleItemType }
     * 
     */
    public TangibleItemType createTangibleItemType() {
        return new TangibleItemType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Case")
    public JAXBElement<CaseType> createCase(CaseType value) {
        return new JAXBElement<CaseType>(_Case_QNAME, CaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FingerprintType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FingerprintType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Fingerprint")
    public JAXBElement<FingerprintType> createFingerprint(FingerprintType value) {
        return new JAXBElement<FingerprintType>(_Fingerprint_QNAME, FingerprintType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EntityRepresentation")
    public JAXBElement<Object> createEntityRepresentation(Object value) {
        return new JAXBElement<Object>(_EntityRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IdentificationJurisdiction")
    public JAXBElement<Object> createIdentificationJurisdiction(Object value) {
        return new JAXBElement<Object>(_IdentificationJurisdiction_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ActivityReference")
    public JAXBElement<ReferenceType> createActivityReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_ActivityReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ActivityDate", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ActivityDateRepresentation")
    public JAXBElement<DateType> createActivityDate(DateType value) {
        return new JAXBElement<DateType>(_ActivityDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ActivityDateRepresentation")
    public JAXBElement<Object> createActivityDateRepresentation(Object value) {
        return new JAXBElement<Object>(_ActivityDateRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ActivityDateRange", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ActivityDateRepresentation")
    public JAXBElement<DateRangeType> createActivityDateRange(DateRangeType value) {
        return new JAXBElement<DateRangeType>(_ActivityDateRange_QNAME, DateRangeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ActivityDescriptionText")
    public JAXBElement<TextType> createActivityDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ActivityDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DispositionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DispositionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ActivityDisposition")
    public JAXBElement<DispositionType> createActivityDisposition(DispositionType value) {
        return new JAXBElement<DispositionType>(_ActivityDisposition_QNAME, DispositionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ActivityIdentification")
    public JAXBElement<IdentificationType> createActivityIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ActivityIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ActivityStatus")
    public JAXBElement<StatusType> createActivityStatus(StatusType value) {
        return new JAXBElement<StatusType>(_ActivityStatus_QNAME, StatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Address")
    public JAXBElement<AddressType> createAddress(AddressType value) {
        return new JAXBElement<AddressType>(_Address_QNAME, AddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressDeliveryPoint")
    public JAXBElement<Object> createAddressDeliveryPoint(Object value) {
        return new JAXBElement<Object>(_AddressDeliveryPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressDeliveryPointID", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressDeliveryPoint")
    public JAXBElement<String> createAddressDeliveryPointID(String value) {
        return new JAXBElement<String>(_AddressDeliveryPointID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressDeliveryPointText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressDeliveryPoint")
    public JAXBElement<TextType> createAddressDeliveryPointText(TextType value) {
        return new JAXBElement<TextType>(_AddressDeliveryPointText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressFullText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressRepresentation")
    public JAXBElement<TextType> createAddressFullText(TextType value) {
        return new JAXBElement<TextType>(_AddressFullText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressRepresentation")
    public JAXBElement<Object> createAddressRepresentation(Object value) {
        return new JAXBElement<Object>(_AddressRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressPrivateMailboxText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressDeliveryPoint")
    public JAXBElement<TextType> createAddressPrivateMailboxText(TextType value) {
        return new JAXBElement<TextType>(_AddressPrivateMailboxText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressRecipientName")
    public JAXBElement<TextType> createAddressRecipientName(TextType value) {
        return new JAXBElement<TextType>(_AddressRecipientName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressSecondaryUnitText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressDeliveryPoint")
    public JAXBElement<TextType> createAddressSecondaryUnitText(TextType value) {
        return new JAXBElement<TextType>(_AddressSecondaryUnitText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Association")
    public JAXBElement<AssociationType> createAssociation(AssociationType value) {
        return new JAXBElement<AssociationType>(_Association_QNAME, AssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinaryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BinaryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Attachment")
    public JAXBElement<BinaryType> createAttachment(BinaryType value) {
        return new JAXBElement<BinaryType>(_Attachment_QNAME, BinaryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Base64Binary }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Base64Binary }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BinaryBase64Object", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "BinaryObject")
    public JAXBElement<Base64Binary> createBinaryBase64Object(Base64Binary value) {
        return new JAXBElement<Base64Binary>(_BinaryBase64Object_QNAME, Base64Binary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BinaryObject")
    public JAXBElement<Object> createBinaryObject(Object value) {
        return new JAXBElement<Object>(_BinaryObject_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BinaryCaptureDate")
    public JAXBElement<DateType> createBinaryCaptureDate(DateType value) {
        return new JAXBElement<DateType>(_BinaryCaptureDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BinaryCapturer")
    public JAXBElement<EntityType> createBinaryCapturer(EntityType value) {
        return new JAXBElement<EntityType>(_BinaryCapturer_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BinaryCategoryText")
    public JAXBElement<TextType> createBinaryCategoryText(TextType value) {
        return new JAXBElement<TextType>(_BinaryCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BinaryDescriptionText")
    public JAXBElement<TextType> createBinaryDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_BinaryDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BinaryFormatStandardName")
    public JAXBElement<TextType> createBinaryFormatStandardName(TextType value) {
        return new JAXBElement<TextType>(_BinaryFormatStandardName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BinaryLocationURI")
    public JAXBElement<AnyURI> createBinaryLocationURI(AnyURI value) {
        return new JAXBElement<AnyURI>(_BinaryLocationURI_QNAME, AnyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BinarySizeValue")
    public JAXBElement<NonNegativeDecimalType> createBinarySizeValue(NonNegativeDecimalType value) {
        return new JAXBElement<NonNegativeDecimalType>(_BinarySizeValue_QNAME, NonNegativeDecimalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BiometricType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BiometricType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Biometric")
    public JAXBElement<BiometricType> createBiometric(BiometricType value) {
        return new JAXBElement<BiometricType>(_Biometric_QNAME, BiometricType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BiometricCapturer")
    public JAXBElement<EntityType> createBiometricCapturer(EntityType value) {
        return new JAXBElement<EntityType>(_BiometricCapturer_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "BiometricImage")
    public JAXBElement<ImageType> createBiometricImage(ImageType value) {
        return new JAXBElement<ImageType>(_BiometricImage_QNAME, ImageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "CapabilityDescriptionText")
    public JAXBElement<TextType> createCapabilityDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_CapabilityDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "CaseCategoryText")
    public JAXBElement<TextType> createCaseCategoryText(TextType value) {
        return new JAXBElement<TextType>(_CaseCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseDispositionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseDispositionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "CaseDisposition", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ActivityDisposition")
    public JAXBElement<CaseDispositionType> createCaseDisposition(CaseDispositionType value) {
        return new JAXBElement<CaseDispositionType>(_CaseDisposition_QNAME, CaseDispositionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseDispositionDecisionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseDispositionDecisionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "CaseDispositionDecision")
    public JAXBElement<CaseDispositionDecisionType> createCaseDispositionDecision(CaseDispositionDecisionType value) {
        return new JAXBElement<CaseDispositionDecisionType>(_CaseDispositionDecision_QNAME, CaseDispositionDecisionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "CaseDispositionFinalDate")
    public JAXBElement<DateType> createCaseDispositionFinalDate(DateType value) {
        return new JAXBElement<DateType>(_CaseDispositionFinalDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "CaseDocketID")
    public JAXBElement<String> createCaseDocketID(String value) {
        return new JAXBElement<String>(_CaseDocketID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "CaseFiling")
    public JAXBElement<DocumentType> createCaseFiling(DocumentType value) {
        return new JAXBElement<DocumentType>(_CaseFiling_QNAME, DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "CaseTitleText")
    public JAXBElement<TextType> createCaseTitleText(TextType value) {
        return new JAXBElement<TextType>(_CaseTitleText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "CaseTrackingID")
    public JAXBElement<String> createCaseTrackingID(String value) {
        return new JAXBElement<String>(_CaseTrackingID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactEmailID", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ContactMeans")
    public JAXBElement<String> createContactEmailID(String value) {
        return new JAXBElement<String>(_ContactEmailID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactMeans")
    public JAXBElement<Object> createContactMeans(Object value) {
        return new JAXBElement<Object>(_ContactMeans_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactEntity")
    public JAXBElement<EntityType> createContactEntity(EntityType value) {
        return new JAXBElement<EntityType>(_ContactEntity_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactEntityDescriptionText")
    public JAXBElement<TextType> createContactEntityDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ContactEntityDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactFaxNumber", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ContactTelephoneNumber")
    public JAXBElement<TelephoneNumberType> createContactFaxNumber(TelephoneNumberType value) {
        return new JAXBElement<TelephoneNumberType>(_ContactFaxNumber_QNAME, TelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactTelephoneNumber", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ContactMeans")
    public JAXBElement<TelephoneNumberType> createContactTelephoneNumber(TelephoneNumberType value) {
        return new JAXBElement<TelephoneNumberType>(_ContactTelephoneNumber_QNAME, TelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactInformationReference")
    public JAXBElement<ReferenceType> createContactInformationReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_ContactInformationReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactInformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ContactInformationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactInformation")
    public JAXBElement<ContactInformationType> createContactInformation(ContactInformationType value) {
        return new JAXBElement<ContactInformationType>(_ContactInformation_QNAME, ContactInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactInformationDescriptionText")
    public JAXBElement<TextType> createContactInformationDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ContactInformationDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactInformationIsDayIndicator")
    public JAXBElement<Boolean> createContactInformationIsDayIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ContactInformationIsDayIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactInformationIsEmergencyIndicator")
    public JAXBElement<Boolean> createContactInformationIsEmergencyIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ContactInformationIsEmergencyIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactInformationIsEveningIndicator")
    public JAXBElement<Boolean> createContactInformationIsEveningIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ContactInformationIsEveningIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactInformationIsHomeIndicator")
    public JAXBElement<Boolean> createContactInformationIsHomeIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ContactInformationIsHomeIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactInformationIsNightIndicator")
    public JAXBElement<Boolean> createContactInformationIsNightIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ContactInformationIsNightIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactInformationIsPrimaryIndicator")
    public JAXBElement<Boolean> createContactInformationIsPrimaryIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ContactInformationIsPrimaryIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactInformationIsWorkIndicator")
    public JAXBElement<Boolean> createContactInformationIsWorkIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ContactInformationIsWorkIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactMailingAddress", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ContactMeans")
    public JAXBElement<AddressType> createContactMailingAddress(AddressType value) {
        return new JAXBElement<AddressType>(_ContactMailingAddress_QNAME, AddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactResponder")
    public JAXBElement<PersonType> createContactResponder(PersonType value) {
        return new JAXBElement<PersonType>(_ContactResponder_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ConveyanceReference")
    public JAXBElement<ReferenceType> createConveyanceReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_ConveyanceReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ConveyanceColorPrimaryText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ItemColor")
    public JAXBElement<TextType> createConveyanceColorPrimaryText(TextType value) {
        return new JAXBElement<TextType>(_ConveyanceColorPrimaryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ItemColor")
    public JAXBElement<Object> createItemColor(Object value) {
        return new JAXBElement<Object>(_ItemColor_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ConveyanceRegistrationPlateIdentification")
    public JAXBElement<IdentificationType> createConveyanceRegistrationPlateIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ConveyanceRegistrationPlateIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DNAImage")
    public JAXBElement<ImageType> createDNAImage(ImageType value) {
        return new JAXBElement<ImageType>(_DNAImage_QNAME, ImageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DNALocusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DNALocusType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DNALocus")
    public JAXBElement<DNALocusType> createDNALocus(DNALocusType value) {
        return new JAXBElement<DNALocusType>(_DNALocus_QNAME, DNALocusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DNALocusCategoryText")
    public JAXBElement<TextType> createDNALocusCategoryText(TextType value) {
        return new JAXBElement<TextType>(_DNALocusCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DNALocusValue")
    public JAXBElement<TextType> createDNALocusValue(TextType value) {
        return new JAXBElement<TextType>(_DNALocusValue_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Date }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Date", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DateRepresentation")
    public JAXBElement<Date> createDate(Date value) {
        return new JAXBElement<Date>(_Date_QNAME, Date.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DateRepresentation")
    public JAXBElement<Object> createDateRepresentation(Object value) {
        return new JAXBElement<Object>(_DateRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DateRange")
    public JAXBElement<DateRangeType> createDateRange(DateRangeType value) {
        return new JAXBElement<DateRangeType>(_DateRange_QNAME, DateRangeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateTime }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DateTime", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DateRepresentation")
    public JAXBElement<DateTime> createDateTime(DateTime value) {
        return new JAXBElement<DateTime>(_DateTime_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DispositionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DispositionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Disposition")
    public JAXBElement<DispositionType> createDisposition(DispositionType value) {
        return new JAXBElement<DispositionType>(_Disposition_QNAME, DispositionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DispositionCategoryText")
    public JAXBElement<TextType> createDispositionCategoryText(TextType value) {
        return new JAXBElement<TextType>(_DispositionCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DispositionDate")
    public JAXBElement<DateType> createDispositionDate(DateType value) {
        return new JAXBElement<DateType>(_DispositionDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DispositionDescriptionText")
    public JAXBElement<TextType> createDispositionDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_DispositionDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DispositionText")
    public JAXBElement<TextType> createDispositionText(TextType value) {
        return new JAXBElement<TextType>(_DispositionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentReference")
    public JAXBElement<ReferenceType> createDocumentReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_DocumentReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Document")
    public JAXBElement<DocumentType> createDocument(DocumentType value) {
        return new JAXBElement<DocumentType>(_Document_QNAME, DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationNameType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ApplicationNameType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentApplicationName")
    public JAXBElement<ApplicationNameType> createDocumentApplicationName(ApplicationNameType value) {
        return new JAXBElement<ApplicationNameType>(_DocumentApplicationName_QNAME, ApplicationNameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinaryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BinaryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentBinary")
    public JAXBElement<BinaryType> createDocumentBinary(BinaryType value) {
        return new JAXBElement<BinaryType>(_DocumentBinary_QNAME, BinaryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentCategoryText")
    public JAXBElement<TextType> createDocumentCategoryText(TextType value) {
        return new JAXBElement<TextType>(_DocumentCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentDescriptionText")
    public JAXBElement<TextType> createDocumentDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_DocumentDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentEffectiveDate")
    public JAXBElement<DateType> createDocumentEffectiveDate(DateType value) {
        return new JAXBElement<DateType>(_DocumentEffectiveDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentFileControlID")
    public JAXBElement<String> createDocumentFileControlID(String value) {
        return new JAXBElement<String>(_DocumentFileControlID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentFiledDate")
    public JAXBElement<DateType> createDocumentFiledDate(DateType value) {
        return new JAXBElement<DateType>(_DocumentFiledDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentIdentification")
    public JAXBElement<IdentificationType> createDocumentIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_DocumentIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentInformationCutOffDate")
    public JAXBElement<DateType> createDocumentInformationCutOffDate(DateType value) {
        return new JAXBElement<DateType>(_DocumentInformationCutOffDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentLanguage")
    public JAXBElement<Object> createDocumentLanguage(Object value) {
        return new JAXBElement<Object>(_DocumentLanguage_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentLanguageCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DocumentLanguage")
    public JAXBElement<LanguageCodeType> createDocumentLanguageCode(LanguageCodeType value) {
        return new JAXBElement<LanguageCodeType>(_DocumentLanguageCode_QNAME, LanguageCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentPostDate")
    public JAXBElement<DateType> createDocumentPostDate(DateType value) {
        return new JAXBElement<DateType>(_DocumentPostDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentReceivedDate")
    public JAXBElement<DateType> createDocumentReceivedDate(DateType value) {
        return new JAXBElement<DateType>(_DocumentReceivedDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentSequenceID")
    public JAXBElement<String> createDocumentSequenceID(String value) {
        return new JAXBElement<String>(_DocumentSequenceID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentStatus")
    public JAXBElement<StatusType> createDocumentStatus(StatusType value) {
        return new JAXBElement<StatusType>(_DocumentStatus_QNAME, StatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentSubmissionFee")
    public JAXBElement<AmountType> createDocumentSubmissionFee(AmountType value) {
        return new JAXBElement<AmountType>(_DocumentSubmissionFee_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentSubmitter")
    public JAXBElement<EntityType> createDocumentSubmitter(EntityType value) {
        return new JAXBElement<EntityType>(_DocumentSubmitter_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DocumentTitleText")
    public JAXBElement<TextType> createDocumentTitleText(TextType value) {
        return new JAXBElement<TextType>(_DocumentTitleText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicenseReference")
    public JAXBElement<ReferenceType> createDriverLicenseReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_DriverLicenseReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverLicenseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriverLicenseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicense")
    public JAXBElement<DriverLicenseType> createDriverLicense(DriverLicenseType value) {
        return new JAXBElement<DriverLicenseType>(_DriverLicense_QNAME, DriverLicenseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverLicenseBaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriverLicenseBaseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicenseBase")
    public JAXBElement<DriverLicenseBaseType> createDriverLicenseBase(DriverLicenseBaseType value) {
        return new JAXBElement<DriverLicenseBaseType>(_DriverLicenseBase_QNAME, DriverLicenseBaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicenseCommercialClass")
    public JAXBElement<Object> createDriverLicenseCommercialClass(Object value) {
        return new JAXBElement<Object>(_DriverLicenseCommercialClass_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverLicenseClassCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriverLicenseClassCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicenseCommercialClassCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DriverLicenseCommercialClass")
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
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicenseExpirationDate")
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
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicenseIdentification")
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
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicenseIssueDate")
    public JAXBElement<DateType> createDriverLicenseIssueDate(DateType value) {
        return new JAXBElement<DateType>(_DriverLicenseIssueDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DrivingRestrictionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DrivingRestrictionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicenseRestriction")
    public JAXBElement<DrivingRestrictionType> createDriverLicenseRestriction(DrivingRestrictionType value) {
        return new JAXBElement<DrivingRestrictionType>(_DriverLicenseRestriction_QNAME, DrivingRestrictionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DriverLicenseWithdrawalType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DriverLicenseWithdrawalType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicenseWithdrawal")
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
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DriverLicenseWithdrawalEffectiveDate")
    public JAXBElement<DateType> createDriverLicenseWithdrawalEffectiveDate(DateType value) {
        return new JAXBElement<DateType>(_DriverLicenseWithdrawalEffectiveDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DrivingRestrictionCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DrivingRestrictionCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DrivingRestrictionCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DrivingRestrictionValue")
    public JAXBElement<DrivingRestrictionCodeType> createDrivingRestrictionCode(DrivingRestrictionCodeType value) {
        return new JAXBElement<DrivingRestrictionCodeType>(_DrivingRestrictionCode_QNAME, DrivingRestrictionCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DrivingRestrictionValue")
    public JAXBElement<Object> createDrivingRestrictionValue(Object value) {
        return new JAXBElement<Object>(_DrivingRestrictionValue_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DrivingRestrictionEndDate")
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
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DrivingRestrictionText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DrivingRestrictionValue")
    public JAXBElement<TextType> createDrivingRestrictionText(TextType value) {
        return new JAXBElement<TextType>(_DrivingRestrictionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EffectiveDate")
    public JAXBElement<DateType> createEffectiveDate(DateType value) {
        return new JAXBElement<DateType>(_EffectiveDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EmployeeReference")
    public JAXBElement<ReferenceType> createEmployeeReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_EmployeeReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Employer")
    public JAXBElement<EntityType> createEmployer(EntityType value) {
        return new JAXBElement<EntityType>(_Employer_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EndDate")
    public JAXBElement<DateType> createEndDate(DateType value) {
        return new JAXBElement<DateType>(_EndDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EntityReference")
    public JAXBElement<ReferenceType> createEntityReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_EntityReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Entity")
    public JAXBElement<EntityType> createEntity(EntityType value) {
        return new JAXBElement<EntityType>(_Entity_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EntityOrganizationReference", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<ReferenceType> createEntityOrganizationReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_EntityOrganizationReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EntityOrganization", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<OrganizationType> createEntityOrganization(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_EntityOrganization_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EntityPersonReference", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<ReferenceType> createEntityPersonReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_EntityPersonReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EntityPerson", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<PersonType> createEntityPerson(PersonType value) {
        return new JAXBElement<PersonType>(_EntityPerson_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "FacilityIdentification")
    public JAXBElement<IdentificationType> createFacilityIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_FacilityIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "FamilyKinshipCategory")
    public JAXBElement<Object> createFamilyKinshipCategory(Object value) {
        return new JAXBElement<Object>(_FamilyKinshipCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FamilyKinshipCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FamilyKinshipCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "FamilyKinshipCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "FamilyKinshipCategory")
    public JAXBElement<FamilyKinshipCodeType> createFamilyKinshipCode(FamilyKinshipCodeType value) {
        return new JAXBElement<FamilyKinshipCodeType>(_FamilyKinshipCode_QNAME, FamilyKinshipCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "FamilyKinshipText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "FamilyKinshipCategory")
    public JAXBElement<TextType> createFamilyKinshipText(TextType value) {
        return new JAXBElement<TextType>(_FamilyKinshipText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "FinancialObligationExemptionAmount")
    public JAXBElement<AmountType> createFinancialObligationExemptionAmount(AmountType value) {
        return new JAXBElement<AmountType>(_FinancialObligationExemptionAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FullTelephoneNumberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FullTelephoneNumberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "FullTelephoneNumber", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "TelephoneNumberRepresentation")
    public JAXBElement<FullTelephoneNumberType> createFullTelephoneNumber(FullTelephoneNumberType value) {
        return new JAXBElement<FullTelephoneNumberType>(_FullTelephoneNumber_QNAME, FullTelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneNumberRepresentation")
    public JAXBElement<Object> createTelephoneNumberRepresentation(Object value) {
        return new JAXBElement<Object>(_TelephoneNumberRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GuardianAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GuardianAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "GuardianAssociation")
    public JAXBElement<GuardianAssociationType> createGuardianAssociation(GuardianAssociationType value) {
        return new JAXBElement<GuardianAssociationType>(_GuardianAssociation_QNAME, GuardianAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Identification")
    public JAXBElement<IdentificationType> createIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_Identification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IdentificationCategory")
    public JAXBElement<Object> createIdentificationCategory(Object value) {
        return new JAXBElement<Object>(_IdentificationCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IdentificationCategoryText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "IdentificationCategory")
    public JAXBElement<TextType> createIdentificationCategoryText(TextType value) {
        return new JAXBElement<TextType>(_IdentificationCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IdentificationID")
    public JAXBElement<String> createIdentificationID(String value) {
        return new JAXBElement<String>(_IdentificationID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IdentificationSourceText")
    public JAXBElement<TextType> createIdentificationSourceText(TextType value) {
        return new JAXBElement<TextType>(_IdentificationSourceText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Image")
    public JAXBElement<ImageType> createImage(ImageType value) {
        return new JAXBElement<ImageType>(_Image_QNAME, ImageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImmediateFamilyAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImmediateFamilyAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ImmediateFamilyAssociation")
    public JAXBElement<ImmediateFamilyAssociationType> createImmediateFamilyAssociation(ImmediateFamilyAssociationType value) {
        return new JAXBElement<ImmediateFamilyAssociationType>(_ImmediateFamilyAssociation_QNAME, ImmediateFamilyAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IncidentReference")
    public JAXBElement<ReferenceType> createIncidentReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_IncidentReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IncidentLocation")
    public JAXBElement<LocationType> createIncidentLocation(LocationType value) {
        return new JAXBElement<LocationType>(_IncidentLocation_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityConveyanceAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActivityConveyanceAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IncidentVehicleAssociation")
    public JAXBElement<ActivityConveyanceAssociationType> createIncidentVehicleAssociation(ActivityConveyanceAssociationType value) {
        return new JAXBElement<ActivityConveyanceAssociationType>(_IncidentVehicleAssociation_QNAME, ActivityConveyanceAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Insurance")
    public JAXBElement<InsuranceType> createInsurance(InsuranceType value) {
        return new JAXBElement<InsuranceType>(_Insurance_QNAME, InsuranceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "InsuranceActiveIndicator")
    public JAXBElement<Boolean> createInsuranceActiveIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_InsuranceActiveIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "InsuranceCarrierName")
    public JAXBElement<TextType> createInsuranceCarrierName(TextType value) {
        return new JAXBElement<TextType>(_InsuranceCarrierName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "InsuranceCoverageCategory")
    public JAXBElement<Object> createInsuranceCoverageCategory(Object value) {
        return new JAXBElement<Object>(_InsuranceCoverageCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "InsuranceCoverageCategoryText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "InsuranceCoverageCategory")
    public JAXBElement<TextType> createInsuranceCoverageCategoryText(TextType value) {
        return new JAXBElement<TextType>(_InsuranceCoverageCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InternationalTelephoneNumberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InternationalTelephoneNumberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "InternationalTelephoneNumber", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "TelephoneNumberRepresentation")
    public JAXBElement<InternationalTelephoneNumberType> createInternationalTelephoneNumber(InternationalTelephoneNumberType value) {
        return new JAXBElement<InternationalTelephoneNumberType>(_InternationalTelephoneNumber_QNAME, InternationalTelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Item")
    public JAXBElement<ItemType> createItem(ItemType value) {
        return new JAXBElement<ItemType>(_Item_QNAME, ItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ItemDescriptionText")
    public JAXBElement<TextType> createItemDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ItemDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GYear }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GYear }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ItemModelYearDate")
    public JAXBElement<GYear> createItemModelYearDate(GYear value) {
        return new JAXBElement<GYear>(_ItemModelYearDate_QNAME, GYear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ItemOtherIdentification")
    public JAXBElement<IdentificationType> createItemOtherIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ItemOtherIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ItemStyle")
    public JAXBElement<Object> createItemStyle(Object value) {
        return new JAXBElement<Object>(_ItemStyle_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemValueType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemValueType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ItemValue")
    public JAXBElement<ItemValueType> createItemValue(ItemValueType value) {
        return new JAXBElement<ItemValueType>(_ItemValue_QNAME, ItemValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Language")
    public JAXBElement<Object> createLanguage(Object value) {
        return new JAXBElement<Object>(_Language_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LanguageCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "Language")
    public JAXBElement<LanguageCodeType> createLanguageCode(LanguageCodeType value) {
        return new JAXBElement<LanguageCodeType>(_LanguageCode_QNAME, LanguageCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LengthCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LengthCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LengthUnitCode")
    public JAXBElement<LengthCodeType> createLengthUnitCode(LengthCodeType value) {
        return new JAXBElement<LengthCodeType>(_LengthUnitCode_QNAME, LengthCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationReference")
    public JAXBElement<ReferenceType> createLocationReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_LocationReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Location")
    public JAXBElement<LocationType> createLocation(LocationType value) {
        return new JAXBElement<LocationType>(_Location_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationAddress")
    public JAXBElement<AddressType> createLocationAddress(AddressType value) {
        return new JAXBElement<AddressType>(_LocationAddress_QNAME, AddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationCityName")
    public JAXBElement<ProperNameTextType> createLocationCityName(ProperNameTextType value) {
        return new JAXBElement<ProperNameTextType>(_LocationCityName_QNAME, ProperNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationCountry")
    public JAXBElement<Object> createLocationCountry(Object value) {
        return new JAXBElement<Object>(_LocationCountry_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationCountryFIPS10-4Code", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "LocationCountry")
    public JAXBElement<CountryCodeType> createLocationCountryFIPS104Code(CountryCodeType value) {
        return new JAXBElement<CountryCodeType>(_LocationCountryFIPS104Code_QNAME, CountryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationCountryName", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "LocationCountry")
    public JAXBElement<ProperNameTextType> createLocationCountryName(ProperNameTextType value) {
        return new JAXBElement<ProperNameTextType>(_LocationCountryName_QNAME, ProperNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationCounty")
    public JAXBElement<Object> createLocationCounty(Object value) {
        return new JAXBElement<Object>(_LocationCounty_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USCountyCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link USCountyCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationCountyCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "LocationCounty")
    public JAXBElement<USCountyCodeType> createLocationCountyCode(USCountyCodeType value) {
        return new JAXBElement<USCountyCodeType>(_LocationCountyCode_QNAME, USCountyCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationCountyName", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "LocationCounty")
    public JAXBElement<ProperNameTextType> createLocationCountyName(ProperNameTextType value) {
        return new JAXBElement<ProperNameTextType>(_LocationCountyName_QNAME, ProperNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationDescriptionText")
    public JAXBElement<TextType> createLocationDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_LocationDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationName")
    public JAXBElement<ProperNameTextType> createLocationName(ProperNameTextType value) {
        return new JAXBElement<ProperNameTextType>(_LocationName_QNAME, ProperNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationPostalCode")
    public JAXBElement<String> createLocationPostalCode(String value) {
        return new JAXBElement<String>(_LocationPostalCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationPostalExtensionCode")
    public JAXBElement<String> createLocationPostalExtensionCode(String value) {
        return new JAXBElement<String>(_LocationPostalExtensionCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationRouteName", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressDeliveryPoint")
    public JAXBElement<TextType> createLocationRouteName(TextType value) {
        return new JAXBElement<TextType>(_LocationRouteName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationState")
    public JAXBElement<Object> createLocationState(Object value) {
        return new JAXBElement<Object>(_LocationState_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationStateName", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "LocationState")
    public JAXBElement<ProperNameTextType> createLocationStateName(ProperNameTextType value) {
        return new JAXBElement<ProperNameTextType>(_LocationStateName_QNAME, ProperNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USStateCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link USStateCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationStateUSPostalServiceCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "LocationState")
    public JAXBElement<USStateCodeType> createLocationStateUSPostalServiceCode(USStateCodeType value) {
        return new JAXBElement<USStateCodeType>(_LocationStateUSPostalServiceCode_QNAME, USStateCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StreetType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StreetType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationStreet", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressDeliveryPoint")
    public JAXBElement<StreetType> createLocationStreet(StreetType value) {
        return new JAXBElement<StreetType>(_LocationStreet_QNAME, StreetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonUnionAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonUnionAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "MarriageAssociation")
    public JAXBElement<PersonUnionAssociationType> createMarriageAssociation(PersonUnionAssociationType value) {
        return new JAXBElement<PersonUnionAssociationType>(_MarriageAssociation_QNAME, PersonUnionAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Measure")
    public JAXBElement<MeasureType> createMeasure(MeasureType value) {
        return new JAXBElement<MeasureType>(_Measure_QNAME, MeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "MeasureText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "MeasureValue")
    public JAXBElement<TextType> createMeasureText(TextType value) {
        return new JAXBElement<TextType>(_MeasureText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "MeasureValue")
    public JAXBElement<Object> createMeasureValue(Object value) {
        return new JAXBElement<Object>(_MeasureValue_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "MeasureUnitText")
    public JAXBElement<TextType> createMeasureUnitText(TextType value) {
        return new JAXBElement<TextType>(_MeasureUnitText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Metadata")
    public JAXBElement<MetadataType> createMetadata(MetadataType value) {
        return new JAXBElement<MetadataType>(_Metadata_QNAME, MetadataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NANPTelephoneNumberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NANPTelephoneNumberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "NANPTelephoneNumber", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "TelephoneNumberRepresentation")
    public JAXBElement<NANPTelephoneNumberType> createNANPTelephoneNumber(NANPTelephoneNumberType value) {
        return new JAXBElement<NANPTelephoneNumberType>(_NANPTelephoneNumber_QNAME, NANPTelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObligationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObligationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Obligation")
    public JAXBElement<ObligationType> createObligation(ObligationType value) {
        return new JAXBElement<ObligationType>(_Obligation_QNAME, ObligationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationCategoryText")
    public JAXBElement<TextType> createObligationCategoryText(TextType value) {
        return new JAXBElement<TextType>(_ObligationCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationDue")
    public JAXBElement<Object> createObligationDue(Object value) {
        return new JAXBElement<Object>(_ObligationDue_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationDueAmount", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ObligationDue")
    public JAXBElement<AmountType> createObligationDueAmount(AmountType value) {
        return new JAXBElement<AmountType>(_ObligationDueAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationEndDate")
    public JAXBElement<DateType> createObligationEndDate(DateType value) {
        return new JAXBElement<DateType>(_ObligationEndDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationEntity")
    public JAXBElement<EntityType> createObligationEntity(EntityType value) {
        return new JAXBElement<EntityType>(_ObligationEntity_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObligationExemptionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObligationExemptionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationExemption")
    public JAXBElement<ObligationExemptionType> createObligationExemption(ObligationExemptionType value) {
        return new JAXBElement<ObligationExemptionType>(_ObligationExemption_QNAME, ObligationExemptionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationExemptionDescriptionText")
    public JAXBElement<TextType> createObligationExemptionDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ObligationExemptionDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationPeriodText")
    public JAXBElement<TextType> createObligationPeriodText(TextType value) {
        return new JAXBElement<TextType>(_ObligationPeriodText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationRecipient")
    public JAXBElement<EntityType> createObligationRecipient(EntityType value) {
        return new JAXBElement<EntityType>(_ObligationRecipient_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObligationRecurrenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ObligationRecurrenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationRecurrence")
    public JAXBElement<ObligationRecurrenceType> createObligationRecurrence(ObligationRecurrenceType value) {
        return new JAXBElement<ObligationRecurrenceType>(_ObligationRecurrence_QNAME, ObligationRecurrenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationRequirementDescriptionText")
    public JAXBElement<TextType> createObligationRequirementDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ObligationRequirementDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ObligationStartDate")
    public JAXBElement<DateType> createObligationStartDate(DateType value) {
        return new JAXBElement<DateType>(_ObligationStartDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationReference")
    public JAXBElement<ReferenceType> createOrganizationReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_OrganizationReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Organization")
    public JAXBElement<OrganizationType> createOrganization(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_Organization_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationAssociation")
    public JAXBElement<OrganizationAssociationType> createOrganizationAssociation(OrganizationAssociationType value) {
        return new JAXBElement<OrganizationAssociationType>(_OrganizationAssociation_QNAME, OrganizationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationContactInformationAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationContactInformationAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationContactInformationAssociation")
    public JAXBElement<OrganizationContactInformationAssociationType> createOrganizationContactInformationAssociation(OrganizationContactInformationAssociationType value) {
        return new JAXBElement<OrganizationContactInformationAssociationType>(_OrganizationContactInformationAssociation_QNAME, OrganizationContactInformationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationIdentification")
    public JAXBElement<IdentificationType> createOrganizationIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_OrganizationIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationLocation")
    public JAXBElement<LocationType> createOrganizationLocation(LocationType value) {
        return new JAXBElement<LocationType>(_OrganizationLocation_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationName")
    public JAXBElement<TextType> createOrganizationName(TextType value) {
        return new JAXBElement<TextType>(_OrganizationName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactInformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ContactInformationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationPrimaryContactInformation")
    public JAXBElement<ContactInformationType> createOrganizationPrimaryContactInformation(ContactInformationType value) {
        return new JAXBElement<ContactInformationType>(_OrganizationPrimaryContactInformation_QNAME, ContactInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationSubUnitName")
    public JAXBElement<TextType> createOrganizationSubUnitName(TextType value) {
        return new JAXBElement<TextType>(_OrganizationSubUnitName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationTaxIdentification")
    public JAXBElement<IdentificationType> createOrganizationTaxIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_OrganizationTaxIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationUnitName")
    public JAXBElement<TextType> createOrganizationUnitName(TextType value) {
        return new JAXBElement<TextType>(_OrganizationUnitName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonReference")
    public JAXBElement<ReferenceType> createPersonReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_PersonReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Person")
    public JAXBElement<PersonType> createPerson(PersonType value) {
        return new JAXBElement<PersonType>(_Person_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonAssociation")
    public JAXBElement<PersonAssociationType> createPersonAssociation(PersonAssociationType value) {
        return new JAXBElement<PersonAssociationType>(_PersonAssociation_QNAME, PersonAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonBirthDate")
    public JAXBElement<DateType> createPersonBirthDate(DateType value) {
        return new JAXBElement<DateType>(_PersonBirthDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CapabilityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CapabilityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonCapability")
    public JAXBElement<CapabilityType> createPersonCapability(CapabilityType value) {
        return new JAXBElement<CapabilityType>(_PersonCapability_QNAME, CapabilityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonChildReference")
    public JAXBElement<ReferenceType> createPersonChildReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_PersonChildReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonCitizenship")
    public JAXBElement<Object> createPersonCitizenship(Object value) {
        return new JAXBElement<Object>(_PersonCitizenship_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonCitizenshipFIPS10-4Code", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonCitizenship")
    public JAXBElement<CountryCodeType> createPersonCitizenshipFIPS104Code(CountryCodeType value) {
        return new JAXBElement<CountryCodeType>(_PersonCitizenshipFIPS104Code_QNAME, CountryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonContactInformationAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonContactInformationAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonContactInformationAssociation")
    public JAXBElement<PersonContactInformationAssociationType> createPersonContactInformationAssociation(PersonContactInformationAssociationType value) {
        return new JAXBElement<PersonContactInformationAssociationType>(_PersonContactInformationAssociation_QNAME, PersonContactInformationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DNAType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DNAType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonDNA")
    public JAXBElement<DNAType> createPersonDNA(DNAType value) {
        return new JAXBElement<DNAType>(_PersonDNA_QNAME, DNAType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonDeathDate")
    public JAXBElement<DateType> createPersonDeathDate(DateType value) {
        return new JAXBElement<DateType>(_PersonDeathDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonDependentReference")
    public JAXBElement<ReferenceType> createPersonDependentReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_PersonDependentReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonEmploymentAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonEmploymentAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonEmploymentAssociation")
    public JAXBElement<PersonEmploymentAssociationType> createPersonEmploymentAssociation(PersonEmploymentAssociationType value) {
        return new JAXBElement<PersonEmploymentAssociationType>(_PersonEmploymentAssociation_QNAME, PersonEmploymentAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonEthnicity")
    public JAXBElement<Object> createPersonEthnicity(Object value) {
        return new JAXBElement<Object>(_PersonEthnicity_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EthnicityCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonEthnicityCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonEthnicity")
    public JAXBElement<EthnicityCodeType> createPersonEthnicityCode(EthnicityCodeType value) {
        return new JAXBElement<EthnicityCodeType>(_PersonEthnicityCode_QNAME, EthnicityCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonEthnicityText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonEthnicity")
    public JAXBElement<TextType> createPersonEthnicityText(TextType value) {
        return new JAXBElement<TextType>(_PersonEthnicityText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonEyeColor")
    public JAXBElement<Object> createPersonEyeColor(Object value) {
        return new JAXBElement<Object>(_PersonEyeColor_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EYECodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EYECodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonEyeColorCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonEyeColor")
    public JAXBElement<EYECodeType> createPersonEyeColorCode(EYECodeType value) {
        return new JAXBElement<EYECodeType>(_PersonEyeColorCode_QNAME, EYECodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FingerprintSetType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FingerprintSetType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonFingerprintSet")
    public JAXBElement<FingerprintSetType> createPersonFingerprintSet(FingerprintSetType value) {
        return new JAXBElement<FingerprintSetType>(_PersonFingerprintSet_QNAME, FingerprintSetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonFullName")
    public JAXBElement<PersonNameTextType> createPersonFullName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonFullName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonOrganizationAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonOrganizationAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonGangAssociation")
    public JAXBElement<PersonOrganizationAssociationType> createPersonGangAssociation(PersonOrganizationAssociationType value) {
        return new JAXBElement<PersonOrganizationAssociationType>(_PersonGangAssociation_QNAME, PersonOrganizationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonGivenName")
    public JAXBElement<PersonNameTextType> createPersonGivenName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonGivenName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonGuardianReference")
    public JAXBElement<ReferenceType> createPersonGuardianReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_PersonGuardianReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonHairColor")
    public JAXBElement<Object> createPersonHairColor(Object value) {
        return new JAXBElement<Object>(_PersonHairColor_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HAICodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link HAICodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonHairColorCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonHairColor")
    public JAXBElement<HAICodeType> createPersonHairColorCode(HAICodeType value) {
        return new JAXBElement<HAICodeType>(_PersonHairColorCode_QNAME, HAICodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LengthMeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LengthMeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonHeightMeasure")
    public JAXBElement<LengthMeasureType> createPersonHeightMeasure(LengthMeasureType value) {
        return new JAXBElement<LengthMeasureType>(_PersonHeightMeasure_QNAME, LengthMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonLanguageEnglishIndicator")
    public JAXBElement<Boolean> createPersonLanguageEnglishIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_PersonLanguageEnglishIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonMaidenName")
    public JAXBElement<PersonNameTextType> createPersonMaidenName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonMaidenName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonMiddleName")
    public JAXBElement<PersonNameTextType> createPersonMiddleName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonMiddleName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonNameType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonName")
    public JAXBElement<PersonNameType> createPersonName(PersonNameType value) {
        return new JAXBElement<PersonNameType>(_PersonName_QNAME, PersonNameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonNamePrefixText")
    public JAXBElement<TextType> createPersonNamePrefixText(TextType value) {
        return new JAXBElement<TextType>(_PersonNamePrefixText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonNameSuffixText")
    public JAXBElement<TextType> createPersonNameSuffixText(TextType value) {
        return new JAXBElement<TextType>(_PersonNameSuffixText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonOrganizationAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonOrganizationAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonOrganizationAssociation")
    public JAXBElement<PersonOrganizationAssociationType> createPersonOrganizationAssociation(PersonOrganizationAssociationType value) {
        return new JAXBElement<PersonOrganizationAssociationType>(_PersonOrganizationAssociation_QNAME, PersonOrganizationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonOtherIdentification")
    public JAXBElement<IdentificationType> createPersonOtherIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonOtherIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonParentReference")
    public JAXBElement<ReferenceType> createPersonParentReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_PersonParentReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhysicalFeatureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PhysicalFeatureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonPhysicalFeature")
    public JAXBElement<PhysicalFeatureType> createPersonPhysicalFeature(PhysicalFeatureType value) {
        return new JAXBElement<PhysicalFeatureType>(_PersonPhysicalFeature_QNAME, PhysicalFeatureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonLanguageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonLanguageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonPrimaryLanguage")
    public JAXBElement<PersonLanguageType> createPersonPrimaryLanguage(PersonLanguageType value) {
        return new JAXBElement<PersonLanguageType>(_PersonPrimaryLanguage_QNAME, PersonLanguageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonRace")
    public JAXBElement<Object> createPersonRace(Object value) {
        return new JAXBElement<Object>(_PersonRace_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RACCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RACCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonRaceCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonRace")
    public JAXBElement<RACCodeType> createPersonRaceCode(RACCodeType value) {
        return new JAXBElement<RACCodeType>(_PersonRaceCode_QNAME, RACCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonRaceText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonRace")
    public JAXBElement<TextType> createPersonRaceText(TextType value) {
        return new JAXBElement<TextType>(_PersonRaceText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonSex")
    public JAXBElement<Object> createPersonSex(Object value) {
        return new JAXBElement<Object>(_PersonSex_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonSexCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonSex")
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
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonStateIdentification")
    public JAXBElement<IdentificationType> createPersonStateIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonStateIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonSurName")
    public JAXBElement<PersonNameTextType> createPersonSurName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonSurName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonTaxIdentification")
    public JAXBElement<IdentificationType> createPersonTaxIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonTaxIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonUnionCategory")
    public JAXBElement<Object> createPersonUnionCategory(Object value) {
        return new JAXBElement<Object>(_PersonUnionCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarriageCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MarriageCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonUnionCategoryCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonUnionCategory")
    public JAXBElement<MarriageCategoryCodeType> createPersonUnionCategoryCode(MarriageCategoryCodeType value) {
        return new JAXBElement<MarriageCategoryCodeType>(_PersonUnionCategoryCode_QNAME, MarriageCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MarriageStatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MarriageStatusType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonUnionStatus")
    public JAXBElement<MarriageStatusType> createPersonUnionStatus(MarriageStatusType value) {
        return new JAXBElement<MarriageStatusType>(_PersonUnionStatus_QNAME, MarriageStatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeightMeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WeightMeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonWeightMeasure")
    public JAXBElement<WeightMeasureType> createPersonWeightMeasure(WeightMeasureType value) {
        return new JAXBElement<WeightMeasureType>(_PersonWeightMeasure_QNAME, WeightMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PhysicalFeatureCategory")
    public JAXBElement<Object> createPhysicalFeatureCategory(Object value) {
        return new JAXBElement<Object>(_PhysicalFeatureCategory_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SMTCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SMTCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PhysicalFeatureCategoryCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PhysicalFeatureCategory")
    public JAXBElement<SMTCodeType> createPhysicalFeatureCategoryCode(SMTCodeType value) {
        return new JAXBElement<SMTCodeType>(_PhysicalFeatureCategoryCode_QNAME, SMTCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PhysicalFeatureCategoryText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PhysicalFeatureCategory")
    public JAXBElement<TextType> createPhysicalFeatureCategoryText(TextType value) {
        return new JAXBElement<TextType>(_PhysicalFeatureCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "RegistrationJurisdiction")
    public JAXBElement<Object> createRegistrationJurisdiction(Object value) {
        return new JAXBElement<Object>(_RegistrationJurisdiction_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RelatedActivityAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RelatedActivityAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "RelatedCaseAssociation")
    public JAXBElement<RelatedActivityAssociationType> createRelatedCaseAssociation(RelatedActivityAssociationType value) {
        return new JAXBElement<RelatedActivityAssociationType>(_RelatedCaseAssociation_QNAME, RelatedActivityAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "RoleOf")
    public JAXBElement<Object> createRoleOf(Object value) {
        return new JAXBElement<Object>(_RoleOf_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "RoleOfItemReference", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "RoleOf")
    public JAXBElement<ReferenceType> createRoleOfItemReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_RoleOfItemReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "RoleOfOrganizationReference", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "RoleOf")
    public JAXBElement<ReferenceType> createRoleOfOrganizationReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_RoleOfOrganizationReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "RoleOfPersonReference", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "RoleOf")
    public JAXBElement<ReferenceType> createRoleOfPersonReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_RoleOfPersonReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ScheduleActivityText")
    public JAXBElement<TextType> createScheduleActivityText(TextType value) {
        return new JAXBElement<TextType>(_ScheduleActivityText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ScheduleDate")
    public JAXBElement<DateType> createScheduleDate(DateType value) {
        return new JAXBElement<DateType>(_ScheduleDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Time }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Time }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ScheduleDayEndTime")
    public JAXBElement<Time> createScheduleDayEndTime(Time value) {
        return new JAXBElement<Time>(_ScheduleDayEndTime_QNAME, Time.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Time }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Time }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ScheduleDayStartTime")
    public JAXBElement<Time> createScheduleDayStartTime(Time value) {
        return new JAXBElement<Time>(_ScheduleDayStartTime_QNAME, Time.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "SensitivityText")
    public JAXBElement<TextType> createSensitivityText(TextType value) {
        return new JAXBElement<TextType>(_SensitivityText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "SpeedUnitCode")
    public JAXBElement<String> createSpeedUnitCode(String value) {
        return new JAXBElement<String>(_SpeedUnitCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StartDate")
    public JAXBElement<DateType> createStartDate(DateType value) {
        return new JAXBElement<DateType>(_StartDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StatusDate")
    public JAXBElement<DateType> createStatusDate(DateType value) {
        return new JAXBElement<DateType>(_StatusDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StatusDescriptionText")
    public JAXBElement<TextType> createStatusDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_StatusDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StatusText")
    public JAXBElement<TextType> createStatusText(TextType value) {
        return new JAXBElement<TextType>(_StatusText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StreetCategoryText")
    public JAXBElement<TextType> createStreetCategoryText(TextType value) {
        return new JAXBElement<TextType>(_StreetCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StreetExtensionText")
    public JAXBElement<TextType> createStreetExtensionText(TextType value) {
        return new JAXBElement<TextType>(_StreetExtensionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StreetFullText")
    public JAXBElement<TextType> createStreetFullText(TextType value) {
        return new JAXBElement<TextType>(_StreetFullText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StreetName")
    public JAXBElement<ProperNameTextType> createStreetName(ProperNameTextType value) {
        return new JAXBElement<ProperNameTextType>(_StreetName_QNAME, ProperNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StreetNumberText")
    public JAXBElement<TextType> createStreetNumberText(TextType value) {
        return new JAXBElement<TextType>(_StreetNumberText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StreetPostdirectionalText")
    public JAXBElement<TextType> createStreetPostdirectionalText(TextType value) {
        return new JAXBElement<TextType>(_StreetPostdirectionalText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StreetPredirectionalText")
    public JAXBElement<TextType> createStreetPredirectionalText(TextType value) {
        return new JAXBElement<TextType>(_StreetPredirectionalText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StructuredAddressType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StructuredAddressType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StructuredAddress", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressRepresentation")
    public JAXBElement<StructuredAddressType> createStructuredAddress(StructuredAddressType value) {
        return new JAXBElement<StructuredAddressType>(_StructuredAddress_QNAME, StructuredAddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SupervisionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SupervisionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Supervision")
    public JAXBElement<SupervisionType> createSupervision(SupervisionType value) {
        return new JAXBElement<SupervisionType>(_Supervision_QNAME, SupervisionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "SupervisionCustodyStatus")
    public JAXBElement<StatusType> createSupervisionCustodyStatus(StatusType value) {
        return new JAXBElement<StatusType>(_SupervisionCustodyStatus_QNAME, StatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FacilityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FacilityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "SupervisionFacility")
    public JAXBElement<FacilityType> createSupervisionFacility(FacilityType value) {
        return new JAXBElement<FacilityType>(_SupervisionFacility_QNAME, FacilityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneAreaCodeID")
    public JAXBElement<String> createTelephoneAreaCodeID(String value) {
        return new JAXBElement<String>(_TelephoneAreaCodeID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneCountryCodeID")
    public JAXBElement<String> createTelephoneCountryCodeID(String value) {
        return new JAXBElement<String>(_TelephoneCountryCodeID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneExchangeID")
    public JAXBElement<String> createTelephoneExchangeID(String value) {
        return new JAXBElement<String>(_TelephoneExchangeID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneLineID")
    public JAXBElement<String> createTelephoneLineID(String value) {
        return new JAXBElement<String>(_TelephoneLineID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneNumber")
    public JAXBElement<TelephoneNumberType> createTelephoneNumber(TelephoneNumberType value) {
        return new JAXBElement<TelephoneNumberType>(_TelephoneNumber_QNAME, TelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneNumberFullID")
    public JAXBElement<String> createTelephoneNumberFullID(String value) {
        return new JAXBElement<String>(_TelephoneNumberFullID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneNumberID")
    public JAXBElement<String> createTelephoneNumberID(String value) {
        return new JAXBElement<String>(_TelephoneNumberID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneSuffixID")
    public JAXBElement<String> createTelephoneSuffixID(String value) {
        return new JAXBElement<String>(_TelephoneSuffixID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VehicleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VehicleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Vehicle")
    public JAXBElement<VehicleType> createVehicle(VehicleType value) {
        return new JAXBElement<VehicleType>(_Vehicle_QNAME, VehicleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VCOCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VCOCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "VehicleColorPrimaryCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ItemColor")
    public JAXBElement<VCOCodeType> createVehicleColorPrimaryCode(VCOCodeType value) {
        return new JAXBElement<VCOCodeType>(_VehicleColorPrimaryCode_QNAME, VCOCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "VehicleIdentification")
    public JAXBElement<IdentificationType> createVehicleIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_VehicleIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VMACodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VMACodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "VehicleMakeCode")
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
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "VehicleModelCode")
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
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "VehicleStyleCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ItemStyle")
    public JAXBElement<VSTCodeType> createVehicleStyleCode(VSTCodeType value) {
        return new JAXBElement<VSTCodeType>(_VehicleStyleCode_QNAME, VSTCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MassCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MassCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "WeightUnitCode")
    public JAXBElement<MassCodeType> createWeightUnitCode(MassCodeType value) {
        return new JAXBElement<MassCodeType>(_WeightUnitCode_QNAME, MassCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GYear }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GYear }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Year", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DateRepresentation")
    public JAXBElement<GYear> createYear(GYear value) {
        return new JAXBElement<GYear>(_Year_QNAME, GYear.class, null, value);
    }

}
