
package gov.niem.release.niem.niem_core._4;

import javax.xml.namespace.QName;
import gov.niem.release.niem.codes.iso_3166_1._4.CountryAlpha2CodeType;
import gov.niem.release.niem.codes.iso_4217._4.CurrencyCodeType;
import gov.niem.release.niem.codes.iso_639_3._4.LanguageCodeType;
import gov.niem.release.niem.codes.unece_rec20._4.LengthCodeType;
import gov.niem.release.niem.codes.unece_rec20._4.MassCodeType;
import gov.niem.release.niem.codes.unece_rec20._4.VelocityCodeType;
import gov.niem.release.niem.codes.usps_states._4.USStateCodeType;
import gov.niem.release.niem.proxy.xsd._4.AnyURI;
import gov.niem.release.niem.proxy.xsd._4.Base64Binary;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.proxy.xsd._4.Date;
import gov.niem.release.niem.proxy.xsd._4.DateTime;
import gov.niem.release.niem.proxy.xsd._4.Decimal;
import gov.niem.release.niem.proxy.xsd._4.GYear;
import gov.niem.release.niem.proxy.xsd._4.String;
import gov.niem.release.niem.proxy.xsd._4.Time;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.niem.release.niem.niem_core._4 package. 
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

    private final static QName _IdentificationCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "IdentificationCategoryAbstract");
    private final static QName _CaseAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "CaseAugmentationPoint");
    private final static QName _DocumentAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentAugmentationPoint");
    private final static QName _PersonAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonAugmentationPoint");
    private final static QName _MeasureUnitAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "MeasureUnitAbstract");
    private final static QName _OrganizationAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "OrganizationAugmentationPoint");
    private final static QName _PersonEyeColorAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonEyeColorAbstract");
    private final static QName _PersonHairColorAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonHairColorAbstract");
    private final static QName _PersonSexAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonSexAbstract");
    private final static QName _PhysicalFeatureCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PhysicalFeatureCategoryAbstract");
    private final static QName _ItemColorAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ItemColorAbstract");
    private final static QName _VehicleMakeAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "VehicleMakeAbstract");
    private final static QName _VehicleModelAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "VehicleModelAbstract");
    private final static QName _SystemOperatingModeAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "SystemOperatingModeAbstract");
    private final static QName _IncidentAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "IncidentAugmentationPoint");
    private final static QName _JurisdictionAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "JurisdictionAbstract");
    private final static QName _StateRepresentation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StateRepresentation");
    private final static QName _PersonEthnicityAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonEthnicityAbstract");
    private final static QName _PersonNameCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonNameCategoryAbstract");
    private final static QName _PersonRaceAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonRaceAbstract");
    private final static QName _ItemStyleAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ItemStyleAbstract");
    private final static QName _DocumentAssociationAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentAssociationAugmentationPoint");
    private final static QName _ItemAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ItemAugmentationPoint");
    private final static QName _OrganizationAssociationAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "OrganizationAssociationAugmentationPoint");
    private final static QName _PersonAssociationAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonAssociationAugmentationPoint");
    private final static QName _PersonOrganizationAssociationAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonOrganizationAssociationAugmentationPoint");
    private final static QName _RelatedActivityAssociationAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "RelatedActivityAssociationAugmentationPoint");
    private final static QName _Activity_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Activity");
    private final static QName _ActivityDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ActivityDate");
    private final static QName _ActivityDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ActivityDescriptionText");
    private final static QName _ActivityDisposition_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ActivityDisposition");
    private final static QName _ActivityIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ActivityIdentification");
    private final static QName _ActivityStatus_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ActivityStatus");
    private final static QName _Address_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Address");
    private final static QName _LocationAddressAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationAddressAbstract");
    private final static QName _AddressDeliveryPointAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "AddressDeliveryPointAbstract");
    private final static QName _AddressDeliveryPointID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "AddressDeliveryPointID");
    private final static QName _AddressFullText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "AddressFullText");
    private final static QName _AddressRecipientName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "AddressRecipientName");
    private final static QName _Amount_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Amount");
    private final static QName _AssociationDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "AssociationDescriptionText");
    private final static QName _Attachment_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Attachment");
    private final static QName _Base64BinaryObject_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Base64BinaryObject");
    private final static QName _BinaryObjectAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "BinaryObjectAbstract");
    private final static QName _BinaryCapturer_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "BinaryCapturer");
    private final static QName _BinaryDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "BinaryDescriptionText");
    private final static QName _BinaryFormatText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "BinaryFormatText");
    private final static QName _BinaryID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "BinaryID");
    private final static QName _BinarySizeValue_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "BinarySizeValue");
    private final static QName _BinaryURI_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "BinaryURI");
    private final static QName _CapabilityDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "CapabilityDescriptionText");
    private final static QName _Case_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Case");
    private final static QName _CaseDisposition_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "CaseDisposition");
    private final static QName _CaseDispositionFinalDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "CaseDispositionFinalDate");
    private final static QName _CaseDocketID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "CaseDocketID");
    private final static QName _CaseTitleText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "CaseTitleText");
    private final static QName _ContactAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactAbstract");
    private final static QName _ContactEmailID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactEmailID");
    private final static QName _ContactMeansAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactMeansAbstract");
    private final static QName _ContactEntity_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactEntity");
    private final static QName _ContactEntityDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactEntityDescriptionText");
    private final static QName _ContactInformation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactInformation");
    private final static QName _ContactInformationAvailabilityAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactInformationAvailabilityAbstract");
    private final static QName _ContactInformationAvailabilityCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactInformationAvailabilityCode");
    private final static QName _ContactInformationDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactInformationDescriptionText");
    private final static QName _ContactMailingAddress_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactMailingAddress");
    private final static QName _ContactResponder_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactResponder");
    private final static QName _ContactTelephoneNumber_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ContactTelephoneNumber");
    private final static QName _ConveyanceColorPrimaryText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ConveyanceColorPrimaryText");
    private final static QName _CountryRepresentation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "CountryRepresentation");
    private final static QName _CurrencyAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "CurrencyAbstract");
    private final static QName _CurrencyCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "CurrencyCode");
    private final static QName _CurrencyText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "CurrencyText");
    private final static QName _Date_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Date");
    private final static QName _DateRepresentation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DateRepresentation");
    private final static QName _DateRange_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DateRange");
    private final static QName _DateTime_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DateTime");
    private final static QName _DispositionCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DispositionCategoryAbstract");
    private final static QName _DispositionCategoryText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DispositionCategoryText");
    private final static QName _DispositionDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DispositionDate");
    private final static QName _DispositionDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DispositionDescriptionText");
    private final static QName _Document_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Document");
    private final static QName _DocumentAssociation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentAssociation");
    private final static QName _DocumentCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentCategoryAbstract");
    private final static QName _DocumentCategoryText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentCategoryText");
    private final static QName _DocumentDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentDescriptionText");
    private final static QName _DocumentEffectiveDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentEffectiveDate");
    private final static QName _DocumentFileControlID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentFileControlID");
    private final static QName _DocumentFiledDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentFiledDate");
    private final static QName _DocumentIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentIdentification");
    private final static QName _DocumentInformationCutOffDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentInformationCutOffDate");
    private final static QName _DocumentLanguageAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentLanguageAbstract");
    private final static QName _DocumentLanguageCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentLanguageCode");
    private final static QName _DocumentPostDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentPostDate");
    private final static QName _DocumentReceivedDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentReceivedDate");
    private final static QName _DocumentSequenceID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentSequenceID");
    private final static QName _DocumentSoftwareName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentSoftwareName");
    private final static QName _DocumentSubmitter_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentSubmitter");
    private final static QName _DocumentTitleText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "DocumentTitleText");
    private final static QName _EffectiveDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "EffectiveDate");
    private final static QName _Employee_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Employee");
    private final static QName _Employer_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Employer");
    private final static QName _EndDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "EndDate");
    private final static QName _EntityItem_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "EntityItem");
    private final static QName _EntityRepresentation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "EntityRepresentation");
    private final static QName _EntityOrganization_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "EntityOrganization");
    private final static QName _EntityPerson_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "EntityPerson");
    private final static QName _ExpirationDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ExpirationDate");
    private final static QName _FacilityIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "FacilityIdentification");
    private final static QName _FacilityName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "FacilityName");
    private final static QName _FinancialObligationExemptionAmount_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "FinancialObligationExemptionAmount");
    private final static QName _FullTelephoneNumber_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "FullTelephoneNumber");
    private final static QName _TelephoneNumberAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "TelephoneNumberAbstract");
    private final static QName _IdentificationCategoryDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "IdentificationCategoryDescriptionText");
    private final static QName _IdentificationID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "IdentificationID");
    private final static QName _IdentificationJurisdiction_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "IdentificationJurisdiction");
    private final static QName _IdentificationSourceText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "IdentificationSourceText");
    private final static QName _IncidentLocation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "IncidentLocation");
    private final static QName _Insurance_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Insurance");
    private final static QName _InsuranceActiveIndicator_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "InsuranceActiveIndicator");
    private final static QName _InsuranceCarrierName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "InsuranceCarrierName");
    private final static QName _InsuranceCoverageCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "InsuranceCoverageCategoryAbstract");
    private final static QName _InsuranceCoverageCategoryText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "InsuranceCoverageCategoryText");
    private final static QName _InternationalTelephoneNumber_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "InternationalTelephoneNumber");
    private final static QName _ItemColorDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ItemColorDescriptionText");
    private final static QName _ItemDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ItemDescriptionText");
    private final static QName _ItemModelYearDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ItemModelYearDate");
    private final static QName _ItemOtherIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ItemOtherIdentification");
    private final static QName _ItemStyleText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ItemStyleText");
    private final static QName _ItemValue_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ItemValue");
    private final static QName _ItemValueAmount_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ItemValueAmount");
    private final static QName _JurisdictionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "JurisdictionText");
    private final static QName _LanguageAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LanguageAbstract");
    private final static QName _LanguageCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LanguageCode");
    private final static QName _LastUpdatedDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LastUpdatedDate");
    private final static QName _LengthUnitAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LengthUnitAbstract");
    private final static QName _LengthUnitCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LengthUnitCode");
    private final static QName _Location_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Location");
    private final static QName _LocationCityName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationCityName");
    private final static QName _LocationCountry_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationCountry");
    private final static QName _LocationCountryName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationCountryName");
    private final static QName _LocationCountyAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationCountyAbstract");
    private final static QName _LocationCountyName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationCountyName");
    private final static QName _LocationDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationDescriptionText");
    private final static QName _LocationName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationName");
    private final static QName _LocationPostalCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationPostalCode");
    private final static QName _LocationPostalExtensionCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationPostalExtensionCode");
    private final static QName _LocationState_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationState");
    private final static QName _LocationStateName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationStateName");
    private final static QName _LocationStateUSPostalServiceCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationStateUSPostalServiceCode");
    private final static QName _LocationStreet_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "LocationStreet");
    private final static QName _MeasureDecimalValue_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "MeasureDecimalValue");
    private final static QName _MeasurePointAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "MeasurePointAbstract");
    private final static QName _MeasureValueAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "MeasureValueAbstract");
    private final static QName _Metadata_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Metadata");
    private final static QName _NANPTelephoneNumber_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "NANPTelephoneNumber");
    private final static QName _ObligationCategoryText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationCategoryText");
    private final static QName _ObligationDateRange_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationDateRange");
    private final static QName _ObligationDueAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationDueAbstract");
    private final static QName _ObligationDueAmount_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationDueAmount");
    private final static QName _ObligationEntity_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationEntity");
    private final static QName _ObligationExemption_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationExemption");
    private final static QName _ObligationExemptionDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationExemptionDescriptionText");
    private final static QName _ObligationPeriodText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationPeriodText");
    private final static QName _ObligationRecipient_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationRecipient");
    private final static QName _ObligationRecurrence_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationRecurrence");
    private final static QName _ObligationRequirementDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ObligationRequirementDescriptionText");
    private final static QName _Organization_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Organization");
    private final static QName _OrganizationAssociation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "OrganizationAssociation");
    private final static QName _OrganizationIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "OrganizationIdentification");
    private final static QName _OrganizationLocation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "OrganizationLocation");
    private final static QName _OrganizationName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "OrganizationName");
    private final static QName _OrganizationPrimaryContactInformation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "OrganizationPrimaryContactInformation");
    private final static QName _OrganizationSubUnitName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "OrganizationSubUnitName");
    private final static QName _OrganizationTaxIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "OrganizationTaxIdentification");
    private final static QName _OrganizationUnitName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "OrganizationUnitName");
    private final static QName _Person_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Person");
    private final static QName _PersonAssociation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonAssociation");
    private final static QName _PersonBirthDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonBirthDate");
    private final static QName _PersonCapability_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonCapability");
    private final static QName _PersonCitizenshipAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonCitizenshipAbstract");
    private final static QName _PersonCitizenshipISO3166Alpha2Code_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonCitizenshipISO3166Alpha2Code");
    private final static QName _PersonDeathDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonDeathDate");
    private final static QName _PersonDisunion_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonDisunion");
    private final static QName _PersonDisunionDecreeIndicator_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonDisunionDecreeIndicator");
    private final static QName _PersonEmploymentAssociation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonEmploymentAssociation");
    private final static QName _PersonEthnicityText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonEthnicityText");
    private final static QName _PersonFullName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonFullName");
    private final static QName _PersonGivenName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonGivenName");
    private final static QName _PersonHeightMeasure_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonHeightMeasure");
    private final static QName _PersonLanguageEnglishIndicator_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonLanguageEnglishIndicator");
    private final static QName _PersonMaidenName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonMaidenName");
    private final static QName _PersonMiddleName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonMiddleName");
    private final static QName _PersonName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonName");
    private final static QName _PersonNamePrefixText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonNamePrefixText");
    private final static QName _PersonNameSuffixText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonNameSuffixText");
    private final static QName _PersonOrganizationAssociation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonOrganizationAssociation");
    private final static QName _PersonOtherIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonOtherIdentification");
    private final static QName _PersonPhysicalFeature_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonPhysicalFeature");
    private final static QName _PersonPrimaryLanguage_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonPrimaryLanguage");
    private final static QName _PersonRaceText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonRaceText");
    private final static QName _PersonStateIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonStateIdentification");
    private final static QName _PersonSurName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonSurName");
    private final static QName _PersonTaxIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonTaxIdentification");
    private final static QName _PersonUnionAssociation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonUnionAssociation");
    private final static QName _PersonUnionCategoryAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonUnionCategoryAbstract");
    private final static QName _PersonUnionCategoryCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonUnionCategoryCode");
    private final static QName _PersonUnionLocation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonUnionLocation");
    private final static QName _PersonUnionSeparation_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonUnionSeparation");
    private final static QName _PersonWeightMeasure_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PersonWeightMeasure");
    private final static QName _PrimaryDocument_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "PrimaryDocument");
    private final static QName _RoleOfAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "RoleOfAbstract");
    private final static QName _RoleOfItem_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "RoleOfItem");
    private final static QName _RoleOfOrganization_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "RoleOfOrganization");
    private final static QName _RoleOfPerson_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "RoleOfPerson");
    private final static QName _ScheduleActivityText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ScheduleActivityText");
    private final static QName _ScheduleDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ScheduleDate");
    private final static QName _ScheduleDayAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ScheduleDayAbstract");
    private final static QName _ScheduleDayEndTime_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ScheduleDayEndTime");
    private final static QName _ScheduleDayStartTime_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "ScheduleDayStartTime");
    private final static QName _SensitivityText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "SensitivityText");
    private final static QName _SpeedUnitAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "SpeedUnitAbstract");
    private final static QName _SpeedUnitCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "SpeedUnitCode");
    private final static QName _StartDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StartDate");
    private final static QName _StatusAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StatusAbstract");
    private final static QName _StatusDate_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StatusDate");
    private final static QName _StatusDescriptionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StatusDescriptionText");
    private final static QName _StatusText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StatusText");
    private final static QName _StreetCategoryText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StreetCategoryText");
    private final static QName _StreetExtensionText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StreetExtensionText");
    private final static QName _StreetFullText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StreetFullText");
    private final static QName _StreetName_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StreetName");
    private final static QName _StreetNumberText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StreetNumberText");
    private final static QName _StreetPostdirectionalText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StreetPostdirectionalText");
    private final static QName _StreetPredirectionalText_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "StreetPredirectionalText");
    private final static QName _SupervisionCustodyStatus_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "SupervisionCustodyStatus");
    private final static QName _SupervisionFacility_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "SupervisionFacility");
    private final static QName _TelephoneAreaCodeID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "TelephoneAreaCodeID");
    private final static QName _TelephoneCountryCodeID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "TelephoneCountryCodeID");
    private final static QName _TelephoneExchangeID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "TelephoneExchangeID");
    private final static QName _TelephoneLineID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "TelephoneLineID");
    private final static QName _TelephoneNumberFullID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "TelephoneNumberFullID");
    private final static QName _TelephoneNumberID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "TelephoneNumberID");
    private final static QName _TelephoneSuffixID_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "TelephoneSuffixID");
    private final static QName _Vehicle_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "Vehicle");
    private final static QName _VehicleAugmentationPoint_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "VehicleAugmentationPoint");
    private final static QName _VehicleIdentification_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "VehicleIdentification");
    private final static QName _WeightUnitAbstract_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "WeightUnitAbstract");
    private final static QName _WeightUnitCode_QNAME = new QName("http://release.niem.gov/niem/niem-core/4.0/", "WeightUnitCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.niem.release.niem.niem_core._4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DateType }
     * 
     */
    public DateType createDateType() {
        return new DateType();
    }

    /**
     * Create an instance of {@link TextType }
     * 
     */
    public TextType createTextType() {
        return new TextType();
    }

    /**
     * Create an instance of {@link VehicleType }
     * 
     */
    public VehicleType createVehicleType() {
        return new VehicleType();
    }

    /**
     * Create an instance of {@link AmountType }
     * 
     */
    public AmountType createAmountType() {
        return new AmountType();
    }

    /**
     * Create an instance of {@link IdentificationType }
     * 
     */
    public IdentificationType createIdentificationType() {
        return new IdentificationType();
    }

    /**
     * Create an instance of {@link NonNegativeDecimalType }
     * 
     */
    public NonNegativeDecimalType createNonNegativeDecimalType() {
        return new NonNegativeDecimalType();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link DispositionType }
     * 
     */
    public DispositionType createDispositionType() {
        return new DispositionType();
    }

    /**
     * Create an instance of {@link DocumentType }
     * 
     */
    public DocumentType createDocumentType() {
        return new DocumentType();
    }

    /**
     * Create an instance of {@link OrganizationType }
     * 
     */
    public OrganizationType createOrganizationType() {
        return new OrganizationType();
    }

    /**
     * Create an instance of {@link EntityType }
     * 
     */
    public EntityType createEntityType() {
        return new EntityType();
    }

    /**
     * Create an instance of {@link CaseType }
     * 
     */
    public CaseType createCaseType() {
        return new CaseType();
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
     * Create an instance of {@link SpeedMeasureType }
     * 
     */
    public SpeedMeasureType createSpeedMeasureType() {
        return new SpeedMeasureType();
    }

    /**
     * Create an instance of {@link ItemType }
     * 
     */
    public ItemType createItemType() {
        return new ItemType();
    }

    /**
     * Create an instance of {@link OffenseLevelCodeType }
     * 
     */
    public OffenseLevelCodeType createOffenseLevelCodeType() {
        return new OffenseLevelCodeType();
    }

    /**
     * Create an instance of {@link ItemValueType }
     * 
     */
    public ItemValueType createItemValueType() {
        return new ItemValueType();
    }

    /**
     * Create an instance of {@link PersonNameCategoryCodeType }
     * 
     */
    public PersonNameCategoryCodeType createPersonNameCategoryCodeType() {
        return new PersonNameCategoryCodeType();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
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
     * Create an instance of {@link StatusType }
     * 
     */
    public StatusType createStatusType() {
        return new StatusType();
    }

    /**
     * Create an instance of {@link ActivityType }
     * 
     */
    public ActivityType createActivityType() {
        return new ActivityType();
    }

    /**
     * Create an instance of {@link BinaryType }
     * 
     */
    public BinaryType createBinaryType() {
        return new BinaryType();
    }

    /**
     * Create an instance of {@link CaseDispositionType }
     * 
     */
    public CaseDispositionType createCaseDispositionType() {
        return new CaseDispositionType();
    }

    /**
     * Create an instance of {@link ContactInformationType }
     * 
     */
    public ContactInformationType createContactInformationType() {
        return new ContactInformationType();
    }

    /**
     * Create an instance of {@link ContactInformationAvailabilityCodeType }
     * 
     */
    public ContactInformationAvailabilityCodeType createContactInformationAvailabilityCodeType() {
        return new ContactInformationAvailabilityCodeType();
    }

    /**
     * Create an instance of {@link TelephoneNumberType }
     * 
     */
    public TelephoneNumberType createTelephoneNumberType() {
        return new TelephoneNumberType();
    }

    /**
     * Create an instance of {@link DateRangeType }
     * 
     */
    public DateRangeType createDateRangeType() {
        return new DateRangeType();
    }

    /**
     * Create an instance of {@link DocumentAssociationType }
     * 
     */
    public DocumentAssociationType createDocumentAssociationType() {
        return new DocumentAssociationType();
    }

    /**
     * Create an instance of {@link SoftwareNameType }
     * 
     */
    public SoftwareNameType createSoftwareNameType() {
        return new SoftwareNameType();
    }

    /**
     * Create an instance of {@link ProperNameTextType }
     * 
     */
    public ProperNameTextType createProperNameTextType() {
        return new ProperNameTextType();
    }

    /**
     * Create an instance of {@link FullTelephoneNumberType }
     * 
     */
    public FullTelephoneNumberType createFullTelephoneNumberType() {
        return new FullTelephoneNumberType();
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
     * Create an instance of {@link CountryType }
     * 
     */
    public CountryType createCountryType() {
        return new CountryType();
    }

    /**
     * Create an instance of {@link StateType }
     * 
     */
    public StateType createStateType() {
        return new StateType();
    }

    /**
     * Create an instance of {@link StreetType }
     * 
     */
    public StreetType createStreetType() {
        return new StreetType();
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
     * Create an instance of {@link PersonDisunionType }
     * 
     */
    public PersonDisunionType createPersonDisunionType() {
        return new PersonDisunionType();
    }

    /**
     * Create an instance of {@link PersonEmploymentAssociationType }
     * 
     */
    public PersonEmploymentAssociationType createPersonEmploymentAssociationType() {
        return new PersonEmploymentAssociationType();
    }

    /**
     * Create an instance of {@link PersonNameTextType }
     * 
     */
    public PersonNameTextType createPersonNameTextType() {
        return new PersonNameTextType();
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
     * Create an instance of {@link PersonOrganizationAssociationType }
     * 
     */
    public PersonOrganizationAssociationType createPersonOrganizationAssociationType() {
        return new PersonOrganizationAssociationType();
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
     * Create an instance of {@link PersonUnionAssociationType }
     * 
     */
    public PersonUnionAssociationType createPersonUnionAssociationType() {
        return new PersonUnionAssociationType();
    }

    /**
     * Create an instance of {@link PersonUnionCategoryCodeType }
     * 
     */
    public PersonUnionCategoryCodeType createPersonUnionCategoryCodeType() {
        return new PersonUnionCategoryCodeType();
    }

    /**
     * Create an instance of {@link PersonUnionSeparationType }
     * 
     */
    public PersonUnionSeparationType createPersonUnionSeparationType() {
        return new PersonUnionSeparationType();
    }

    /**
     * Create an instance of {@link WeightMeasureType }
     * 
     */
    public WeightMeasureType createWeightMeasureType() {
        return new WeightMeasureType();
    }

    /**
     * Create an instance of {@link FacilityType }
     * 
     */
    public FacilityType createFacilityType() {
        return new FacilityType();
    }

    /**
     * Create an instance of {@link AssociationType }
     * 
     */
    public AssociationType createAssociationType() {
        return new AssociationType();
    }

    /**
     * Create an instance of {@link ConveyanceType }
     * 
     */
    public ConveyanceType createConveyanceType() {
        return new ConveyanceType();
    }

    /**
     * Create an instance of {@link IncidentType }
     * 
     */
    public IncidentType createIncidentType() {
        return new IncidentType();
    }

    /**
     * Create an instance of {@link MeasureType }
     * 
     */
    public MeasureType createMeasureType() {
        return new MeasureType();
    }

    /**
     * Create an instance of {@link NumericType }
     * 
     */
    public NumericType createNumericType() {
        return new NumericType();
    }

    /**
     * Create an instance of {@link ObligationType }
     * 
     */
    public ObligationType createObligationType() {
        return new ObligationType();
    }

    /**
     * Create an instance of {@link RelatedActivityAssociationType }
     * 
     */
    public RelatedActivityAssociationType createRelatedActivityAssociationType() {
        return new RelatedActivityAssociationType();
    }

    /**
     * Create an instance of {@link ScheduleType }
     * 
     */
    public ScheduleType createScheduleType() {
        return new ScheduleType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "IdentificationCategoryAbstract")
    public JAXBElement<Object> createIdentificationCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_IdentificationCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "CaseAugmentationPoint")
    public JAXBElement<Object> createCaseAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_CaseAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentAugmentationPoint")
    public JAXBElement<Object> createDocumentAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_DocumentAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonAugmentationPoint")
    public JAXBElement<Object> createPersonAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_PersonAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "MeasureUnitAbstract")
    public JAXBElement<Object> createMeasureUnitAbstract(Object value) {
        return new JAXBElement<Object>(_MeasureUnitAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "OrganizationAugmentationPoint")
    public JAXBElement<Object> createOrganizationAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_OrganizationAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonEyeColorAbstract")
    public JAXBElement<Object> createPersonEyeColorAbstract(Object value) {
        return new JAXBElement<Object>(_PersonEyeColorAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonHairColorAbstract")
    public JAXBElement<Object> createPersonHairColorAbstract(Object value) {
        return new JAXBElement<Object>(_PersonHairColorAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonSexAbstract")
    public JAXBElement<Object> createPersonSexAbstract(Object value) {
        return new JAXBElement<Object>(_PersonSexAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PhysicalFeatureCategoryAbstract")
    public JAXBElement<Object> createPhysicalFeatureCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_PhysicalFeatureCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ItemColorAbstract")
    public JAXBElement<Object> createItemColorAbstract(Object value) {
        return new JAXBElement<Object>(_ItemColorAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "VehicleMakeAbstract")
    public JAXBElement<Object> createVehicleMakeAbstract(Object value) {
        return new JAXBElement<Object>(_VehicleMakeAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "VehicleModelAbstract")
    public JAXBElement<Object> createVehicleModelAbstract(Object value) {
        return new JAXBElement<Object>(_VehicleModelAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "SystemOperatingModeAbstract")
    public JAXBElement<Object> createSystemOperatingModeAbstract(Object value) {
        return new JAXBElement<Object>(_SystemOperatingModeAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "IncidentAugmentationPoint")
    public JAXBElement<Object> createIncidentAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_IncidentAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "JurisdictionAbstract")
    public JAXBElement<Object> createJurisdictionAbstract(Object value) {
        return new JAXBElement<Object>(_JurisdictionAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StateRepresentation")
    public JAXBElement<Object> createStateRepresentation(Object value) {
        return new JAXBElement<Object>(_StateRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonEthnicityAbstract")
    public JAXBElement<Object> createPersonEthnicityAbstract(Object value) {
        return new JAXBElement<Object>(_PersonEthnicityAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonNameCategoryAbstract")
    public JAXBElement<Object> createPersonNameCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_PersonNameCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonRaceAbstract")
    public JAXBElement<Object> createPersonRaceAbstract(Object value) {
        return new JAXBElement<Object>(_PersonRaceAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ItemStyleAbstract")
    public JAXBElement<Object> createItemStyleAbstract(Object value) {
        return new JAXBElement<Object>(_ItemStyleAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentAssociationAugmentationPoint")
    public JAXBElement<Object> createDocumentAssociationAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_DocumentAssociationAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ItemAugmentationPoint")
    public JAXBElement<Object> createItemAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ItemAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "OrganizationAssociationAugmentationPoint")
    public JAXBElement<Object> createOrganizationAssociationAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_OrganizationAssociationAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonAssociationAugmentationPoint")
    public JAXBElement<Object> createPersonAssociationAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_PersonAssociationAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonOrganizationAssociationAugmentationPoint")
    public JAXBElement<Object> createPersonOrganizationAssociationAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_PersonOrganizationAssociationAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "RelatedActivityAssociationAugmentationPoint")
    public JAXBElement<Object> createRelatedActivityAssociationAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_RelatedActivityAssociationAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActivityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActivityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Activity")
    public JAXBElement<ActivityType> createActivity(ActivityType value) {
        return new JAXBElement<ActivityType>(_Activity_QNAME, ActivityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ActivityDate")
    public JAXBElement<DateType> createActivityDate(DateType value) {
        return new JAXBElement<DateType>(_ActivityDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ActivityDescriptionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ActivityDisposition")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ActivityIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ActivityStatus")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Address", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "LocationAddressAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationAddressAbstract")
    public JAXBElement<Object> createLocationAddressAbstract(Object value) {
        return new JAXBElement<Object>(_LocationAddressAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "AddressDeliveryPointAbstract")
    public JAXBElement<Object> createAddressDeliveryPointAbstract(Object value) {
        return new JAXBElement<Object>(_AddressDeliveryPointAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "AddressDeliveryPointID", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "AddressDeliveryPointAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "AddressFullText")
    public JAXBElement<TextType> createAddressFullText(TextType value) {
        return new JAXBElement<TextType>(_AddressFullText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "AddressRecipientName")
    public JAXBElement<TextType> createAddressRecipientName(TextType value) {
        return new JAXBElement<TextType>(_AddressRecipientName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Amount")
    public JAXBElement<Decimal> createAmount(Decimal value) {
        return new JAXBElement<Decimal>(_Amount_QNAME, Decimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "AssociationDescriptionText")
    public JAXBElement<TextType> createAssociationDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_AssociationDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BinaryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BinaryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Attachment")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Base64BinaryObject", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "BinaryObjectAbstract")
    public JAXBElement<Base64Binary> createBase64BinaryObject(Base64Binary value) {
        return new JAXBElement<Base64Binary>(_Base64BinaryObject_QNAME, Base64Binary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "BinaryObjectAbstract")
    public JAXBElement<Object> createBinaryObjectAbstract(Object value) {
        return new JAXBElement<Object>(_BinaryObjectAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "BinaryCapturer")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "BinaryDescriptionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "BinaryFormatText")
    public JAXBElement<TextType> createBinaryFormatText(TextType value) {
        return new JAXBElement<TextType>(_BinaryFormatText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "BinaryID")
    public JAXBElement<String> createBinaryID(String value) {
        return new JAXBElement<String>(_BinaryID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "BinarySizeValue")
    public JAXBElement<NonNegativeDecimalType> createBinarySizeValue(NonNegativeDecimalType value) {
        return new JAXBElement<NonNegativeDecimalType>(_BinarySizeValue_QNAME, NonNegativeDecimalType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AnyURI }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "BinaryURI")
    public JAXBElement<AnyURI> createBinaryURI(AnyURI value) {
        return new JAXBElement<AnyURI>(_BinaryURI_QNAME, AnyURI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "CapabilityDescriptionText")
    public JAXBElement<TextType> createCapabilityDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_CapabilityDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Case")
    public JAXBElement<CaseType> createCase(CaseType value) {
        return new JAXBElement<CaseType>(_Case_QNAME, CaseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseDispositionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseDispositionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "CaseDisposition", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ActivityDisposition")
    public JAXBElement<CaseDispositionType> createCaseDisposition(CaseDispositionType value) {
        return new JAXBElement<CaseDispositionType>(_CaseDisposition_QNAME, CaseDispositionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "CaseDispositionFinalDate")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "CaseDocketID")
    public JAXBElement<String> createCaseDocketID(String value) {
        return new JAXBElement<String>(_CaseDocketID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "CaseTitleText")
    public JAXBElement<TextType> createCaseTitleText(TextType value) {
        return new JAXBElement<TextType>(_CaseTitleText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactAbstract")
    public JAXBElement<Object> createContactAbstract(Object value) {
        return new JAXBElement<Object>(_ContactAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactEmailID", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ContactMeansAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactMeansAbstract")
    public JAXBElement<Object> createContactMeansAbstract(Object value) {
        return new JAXBElement<Object>(_ContactMeansAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactEntity", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ContactAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactEntityDescriptionText")
    public JAXBElement<TextType> createContactEntityDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ContactEntityDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactInformationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ContactInformationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactInformation")
    public JAXBElement<ContactInformationType> createContactInformation(ContactInformationType value) {
        return new JAXBElement<ContactInformationType>(_ContactInformation_QNAME, ContactInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactInformationAvailabilityAbstract")
    public JAXBElement<Object> createContactInformationAvailabilityAbstract(Object value) {
        return new JAXBElement<Object>(_ContactInformationAvailabilityAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactInformationAvailabilityCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ContactInformationAvailabilityCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactInformationAvailabilityCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ContactInformationAvailabilityAbstract")
    public JAXBElement<ContactInformationAvailabilityCodeType> createContactInformationAvailabilityCode(ContactInformationAvailabilityCodeType value) {
        return new JAXBElement<ContactInformationAvailabilityCodeType>(_ContactInformationAvailabilityCode_QNAME, ContactInformationAvailabilityCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactInformationDescriptionText")
    public JAXBElement<TextType> createContactInformationDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ContactInformationDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactMailingAddress", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ContactMeansAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactResponder")
    public JAXBElement<PersonType> createContactResponder(PersonType value) {
        return new JAXBElement<PersonType>(_ContactResponder_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ContactTelephoneNumber", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ContactMeansAbstract")
    public JAXBElement<TelephoneNumberType> createContactTelephoneNumber(TelephoneNumberType value) {
        return new JAXBElement<TelephoneNumberType>(_ContactTelephoneNumber_QNAME, TelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ConveyanceColorPrimaryText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ItemColorAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "CountryRepresentation")
    public JAXBElement<Object> createCountryRepresentation(Object value) {
        return new JAXBElement<Object>(_CountryRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "CurrencyAbstract")
    public JAXBElement<Object> createCurrencyAbstract(Object value) {
        return new JAXBElement<Object>(_CurrencyAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CurrencyCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CurrencyCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "CurrencyCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CurrencyAbstract")
    public JAXBElement<CurrencyCodeType> createCurrencyCode(CurrencyCodeType value) {
        return new JAXBElement<CurrencyCodeType>(_CurrencyCode_QNAME, CurrencyCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "CurrencyText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CurrencyAbstract")
    public JAXBElement<TextType> createCurrencyText(TextType value) {
        return new JAXBElement<TextType>(_CurrencyText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Date }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Date", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "DateRepresentation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DateRepresentation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DateRange", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "DateRepresentation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DateTime", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "DateRepresentation")
    public JAXBElement<DateTime> createDateTime(DateTime value) {
        return new JAXBElement<DateTime>(_DateTime_QNAME, DateTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DispositionCategoryAbstract")
    public JAXBElement<Object> createDispositionCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_DispositionCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DispositionCategoryText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "DispositionCategoryAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DispositionDate")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DispositionDescriptionText")
    public JAXBElement<TextType> createDispositionDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_DispositionDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Document")
    public JAXBElement<DocumentType> createDocument(DocumentType value) {
        return new JAXBElement<DocumentType>(_Document_QNAME, DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentAssociation")
    public JAXBElement<DocumentAssociationType> createDocumentAssociation(DocumentAssociationType value) {
        return new JAXBElement<DocumentAssociationType>(_DocumentAssociation_QNAME, DocumentAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentCategoryAbstract")
    public JAXBElement<Object> createDocumentCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_DocumentCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentCategoryText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "DocumentCategoryAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentDescriptionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentEffectiveDate")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentFileControlID")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentFiledDate")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentInformationCutOffDate")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentLanguageAbstract")
    public JAXBElement<Object> createDocumentLanguageAbstract(Object value) {
        return new JAXBElement<Object>(_DocumentLanguageAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentLanguageCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "DocumentLanguageAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentPostDate")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentReceivedDate")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentSequenceID")
    public JAXBElement<String> createDocumentSequenceID(String value) {
        return new JAXBElement<String>(_DocumentSequenceID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SoftwareNameType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SoftwareNameType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentSoftwareName")
    public JAXBElement<SoftwareNameType> createDocumentSoftwareName(SoftwareNameType value) {
        return new JAXBElement<SoftwareNameType>(_DocumentSoftwareName_QNAME, SoftwareNameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentSubmitter")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "DocumentTitleText")
    public JAXBElement<TextType> createDocumentTitleText(TextType value) {
        return new JAXBElement<TextType>(_DocumentTitleText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "EffectiveDate")
    public JAXBElement<DateType> createEffectiveDate(DateType value) {
        return new JAXBElement<DateType>(_EffectiveDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Employee")
    public JAXBElement<PersonType> createEmployee(PersonType value) {
        return new JAXBElement<PersonType>(_Employee_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Employer")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "EndDate")
    public JAXBElement<DateType> createEndDate(DateType value) {
        return new JAXBElement<DateType>(_EndDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "EntityItem", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<ItemType> createEntityItem(ItemType value) {
        return new JAXBElement<ItemType>(_EntityItem_QNAME, ItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "EntityRepresentation")
    public JAXBElement<Object> createEntityRepresentation(Object value) {
        return new JAXBElement<Object>(_EntityRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "EntityOrganization", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "EntityRepresentation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "EntityPerson", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<PersonType> createEntityPerson(PersonType value) {
        return new JAXBElement<PersonType>(_EntityPerson_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ExpirationDate")
    public JAXBElement<DateType> createExpirationDate(DateType value) {
        return new JAXBElement<DateType>(_ExpirationDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "FacilityIdentification")
    public JAXBElement<IdentificationType> createFacilityIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_FacilityIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "FacilityName")
    public JAXBElement<ProperNameTextType> createFacilityName(ProperNameTextType value) {
        return new JAXBElement<ProperNameTextType>(_FacilityName_QNAME, ProperNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "FinancialObligationExemptionAmount")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "FullTelephoneNumber", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "TelephoneNumberAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "TelephoneNumberAbstract")
    public JAXBElement<Object> createTelephoneNumberAbstract(Object value) {
        return new JAXBElement<Object>(_TelephoneNumberAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "IdentificationCategoryDescriptionText")
    public JAXBElement<TextType> createIdentificationCategoryDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_IdentificationCategoryDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "IdentificationID")
    public JAXBElement<String> createIdentificationID(String value) {
        return new JAXBElement<String>(_IdentificationID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JurisdictionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link JurisdictionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "IdentificationJurisdiction")
    public JAXBElement<JurisdictionType> createIdentificationJurisdiction(JurisdictionType value) {
        return new JAXBElement<JurisdictionType>(_IdentificationJurisdiction_QNAME, JurisdictionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "IdentificationSourceText")
    public JAXBElement<TextType> createIdentificationSourceText(TextType value) {
        return new JAXBElement<TextType>(_IdentificationSourceText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "IncidentLocation")
    public JAXBElement<LocationType> createIncidentLocation(LocationType value) {
        return new JAXBElement<LocationType>(_IncidentLocation_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsuranceType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Insurance")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "InsuranceActiveIndicator")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "InsuranceCarrierName")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "InsuranceCoverageCategoryAbstract")
    public JAXBElement<Object> createInsuranceCoverageCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_InsuranceCoverageCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "InsuranceCoverageCategoryText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "InsuranceCoverageCategoryAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "InternationalTelephoneNumber", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "TelephoneNumberAbstract")
    public JAXBElement<InternationalTelephoneNumberType> createInternationalTelephoneNumber(InternationalTelephoneNumberType value) {
        return new JAXBElement<InternationalTelephoneNumberType>(_InternationalTelephoneNumber_QNAME, InternationalTelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ItemColorDescriptionText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ItemColorAbstract")
    public JAXBElement<TextType> createItemColorDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ItemColorDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ItemDescriptionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ItemModelYearDate")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ItemOtherIdentification")
    public JAXBElement<IdentificationType> createItemOtherIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ItemOtherIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ItemStyleText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ItemStyleAbstract")
    public JAXBElement<TextType> createItemStyleText(TextType value) {
        return new JAXBElement<TextType>(_ItemStyleText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemValueType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemValueType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ItemValue")
    public JAXBElement<ItemValueType> createItemValue(ItemValueType value) {
        return new JAXBElement<ItemValueType>(_ItemValue_QNAME, ItemValueType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ItemValueAmount")
    public JAXBElement<AmountType> createItemValueAmount(AmountType value) {
        return new JAXBElement<AmountType>(_ItemValueAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "JurisdictionText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "JurisdictionAbstract")
    public JAXBElement<TextType> createJurisdictionText(TextType value) {
        return new JAXBElement<TextType>(_JurisdictionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LanguageAbstract")
    public JAXBElement<Object> createLanguageAbstract(Object value) {
        return new JAXBElement<Object>(_LanguageAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LanguageCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LanguageCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "LanguageAbstract")
    public JAXBElement<LanguageCodeType> createLanguageCode(LanguageCodeType value) {
        return new JAXBElement<LanguageCodeType>(_LanguageCode_QNAME, LanguageCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LastUpdatedDate")
    public JAXBElement<DateType> createLastUpdatedDate(DateType value) {
        return new JAXBElement<DateType>(_LastUpdatedDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LengthUnitAbstract")
    public JAXBElement<Object> createLengthUnitAbstract(Object value) {
        return new JAXBElement<Object>(_LengthUnitAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LengthCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LengthCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LengthUnitCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "LengthUnitAbstract")
    public JAXBElement<LengthCodeType> createLengthUnitCode(LengthCodeType value) {
        return new JAXBElement<LengthCodeType>(_LengthUnitCode_QNAME, LengthCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Location")
    public JAXBElement<LocationType> createLocation(LocationType value) {
        return new JAXBElement<LocationType>(_Location_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationCityName")
    public JAXBElement<ProperNameTextType> createLocationCityName(ProperNameTextType value) {
        return new JAXBElement<ProperNameTextType>(_LocationCityName_QNAME, ProperNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CountryType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationCountry")
    public JAXBElement<CountryType> createLocationCountry(CountryType value) {
        return new JAXBElement<CountryType>(_LocationCountry_QNAME, CountryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationCountryName", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CountryRepresentation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationCountyAbstract")
    public JAXBElement<Object> createLocationCountyAbstract(Object value) {
        return new JAXBElement<Object>(_LocationCountyAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationCountyName", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "LocationCountyAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationDescriptionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationName")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationPostalCode")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationPostalExtensionCode")
    public JAXBElement<String> createLocationPostalExtensionCode(String value) {
        return new JAXBElement<String>(_LocationPostalExtensionCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationState")
    public JAXBElement<StateType> createLocationState(StateType value) {
        return new JAXBElement<StateType>(_LocationState_QNAME, StateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationStateName", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "StateRepresentation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationStateUSPostalServiceCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "StateRepresentation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "LocationStreet", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "AddressDeliveryPointAbstract")
    public JAXBElement<StreetType> createLocationStreet(StreetType value) {
        return new JAXBElement<StreetType>(_LocationStreet_QNAME, StreetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "MeasureDecimalValue", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "MeasurePointAbstract")
    public JAXBElement<Decimal> createMeasureDecimalValue(Decimal value) {
        return new JAXBElement<Decimal>(_MeasureDecimalValue_QNAME, Decimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "MeasurePointAbstract", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "MeasureValueAbstract")
    public JAXBElement<Object> createMeasurePointAbstract(Object value) {
        return new JAXBElement<Object>(_MeasurePointAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "MeasureValueAbstract")
    public JAXBElement<Object> createMeasureValueAbstract(Object value) {
        return new JAXBElement<Object>(_MeasureValueAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MetadataType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Metadata")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "NANPTelephoneNumber", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "TelephoneNumberAbstract")
    public JAXBElement<NANPTelephoneNumberType> createNANPTelephoneNumber(NANPTelephoneNumberType value) {
        return new JAXBElement<NANPTelephoneNumberType>(_NANPTelephoneNumber_QNAME, NANPTelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationCategoryText")
    public JAXBElement<TextType> createObligationCategoryText(TextType value) {
        return new JAXBElement<TextType>(_ObligationCategoryText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateRangeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationDateRange")
    public JAXBElement<DateRangeType> createObligationDateRange(DateRangeType value) {
        return new JAXBElement<DateRangeType>(_ObligationDateRange_QNAME, DateRangeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationDueAbstract")
    public JAXBElement<Object> createObligationDueAbstract(Object value) {
        return new JAXBElement<Object>(_ObligationDueAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationDueAmount", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ObligationDueAbstract")
    public JAXBElement<AmountType> createObligationDueAmount(AmountType value) {
        return new JAXBElement<AmountType>(_ObligationDueAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationEntity")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationExemption")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationExemptionDescriptionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationPeriodText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationRecipient")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationRecurrence")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ObligationRequirementDescriptionText")
    public JAXBElement<TextType> createObligationRequirementDescriptionText(TextType value) {
        return new JAXBElement<TextType>(_ObligationRequirementDescriptionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Organization")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "OrganizationAssociation")
    public JAXBElement<OrganizationAssociationType> createOrganizationAssociation(OrganizationAssociationType value) {
        return new JAXBElement<OrganizationAssociationType>(_OrganizationAssociation_QNAME, OrganizationAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "OrganizationIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "OrganizationLocation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "OrganizationName")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "OrganizationPrimaryContactInformation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "OrganizationSubUnitName")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "OrganizationTaxIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "OrganizationUnitName")
    public JAXBElement<TextType> createOrganizationUnitName(TextType value) {
        return new JAXBElement<TextType>(_OrganizationUnitName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Person")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonAssociation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonBirthDate")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonCapability")
    public JAXBElement<CapabilityType> createPersonCapability(CapabilityType value) {
        return new JAXBElement<CapabilityType>(_PersonCapability_QNAME, CapabilityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonCitizenshipAbstract")
    public JAXBElement<Object> createPersonCitizenshipAbstract(Object value) {
        return new JAXBElement<Object>(_PersonCitizenshipAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryAlpha2CodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CountryAlpha2CodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonCitizenshipISO3166Alpha2Code", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonCitizenshipAbstract")
    public JAXBElement<CountryAlpha2CodeType> createPersonCitizenshipISO3166Alpha2Code(CountryAlpha2CodeType value) {
        return new JAXBElement<CountryAlpha2CodeType>(_PersonCitizenshipISO3166Alpha2Code_QNAME, CountryAlpha2CodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonDeathDate")
    public JAXBElement<DateType> createPersonDeathDate(DateType value) {
        return new JAXBElement<DateType>(_PersonDeathDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonDisunionType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonDisunionType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonDisunion")
    public JAXBElement<PersonDisunionType> createPersonDisunion(PersonDisunionType value) {
        return new JAXBElement<PersonDisunionType>(_PersonDisunion_QNAME, PersonDisunionType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonDisunionDecreeIndicator")
    public JAXBElement<Boolean> createPersonDisunionDecreeIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_PersonDisunionDecreeIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonEmploymentAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonEmploymentAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonEmploymentAssociation")
    public JAXBElement<PersonEmploymentAssociationType> createPersonEmploymentAssociation(PersonEmploymentAssociationType value) {
        return new JAXBElement<PersonEmploymentAssociationType>(_PersonEmploymentAssociation_QNAME, PersonEmploymentAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonEthnicityText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonEthnicityAbstract")
    public JAXBElement<TextType> createPersonEthnicityText(TextType value) {
        return new JAXBElement<TextType>(_PersonEthnicityText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonFullName")
    public JAXBElement<PersonNameTextType> createPersonFullName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonFullName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonGivenName")
    public JAXBElement<PersonNameTextType> createPersonGivenName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonGivenName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LengthMeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LengthMeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonHeightMeasure")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonLanguageEnglishIndicator")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonMaidenName")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonMiddleName")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonName")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonNamePrefixText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonNameSuffixText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonOrganizationAssociation")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonOtherIdentification")
    public JAXBElement<IdentificationType> createPersonOtherIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonOtherIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhysicalFeatureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PhysicalFeatureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonPhysicalFeature")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonPrimaryLanguage")
    public JAXBElement<PersonLanguageType> createPersonPrimaryLanguage(PersonLanguageType value) {
        return new JAXBElement<PersonLanguageType>(_PersonPrimaryLanguage_QNAME, PersonLanguageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonRaceText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonRaceAbstract")
    public JAXBElement<TextType> createPersonRaceText(TextType value) {
        return new JAXBElement<TextType>(_PersonRaceText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonStateIdentification")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonSurName")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonTaxIdentification")
    public JAXBElement<IdentificationType> createPersonTaxIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonTaxIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonUnionAssociationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonUnionAssociationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonUnionAssociation")
    public JAXBElement<PersonUnionAssociationType> createPersonUnionAssociation(PersonUnionAssociationType value) {
        return new JAXBElement<PersonUnionAssociationType>(_PersonUnionAssociation_QNAME, PersonUnionAssociationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonUnionCategoryAbstract")
    public JAXBElement<Object> createPersonUnionCategoryAbstract(Object value) {
        return new JAXBElement<Object>(_PersonUnionCategoryAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonUnionCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonUnionCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonUnionCategoryCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "PersonUnionCategoryAbstract")
    public JAXBElement<PersonUnionCategoryCodeType> createPersonUnionCategoryCode(PersonUnionCategoryCodeType value) {
        return new JAXBElement<PersonUnionCategoryCodeType>(_PersonUnionCategoryCode_QNAME, PersonUnionCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonUnionLocation")
    public JAXBElement<LocationType> createPersonUnionLocation(LocationType value) {
        return new JAXBElement<LocationType>(_PersonUnionLocation_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonUnionSeparationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonUnionSeparationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonUnionSeparation")
    public JAXBElement<PersonUnionSeparationType> createPersonUnionSeparation(PersonUnionSeparationType value) {
        return new JAXBElement<PersonUnionSeparationType>(_PersonUnionSeparation_QNAME, PersonUnionSeparationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WeightMeasureType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link WeightMeasureType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PersonWeightMeasure")
    public JAXBElement<WeightMeasureType> createPersonWeightMeasure(WeightMeasureType value) {
        return new JAXBElement<WeightMeasureType>(_PersonWeightMeasure_QNAME, WeightMeasureType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DocumentType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "PrimaryDocument")
    public JAXBElement<DocumentType> createPrimaryDocument(DocumentType value) {
        return new JAXBElement<DocumentType>(_PrimaryDocument_QNAME, DocumentType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "RoleOfAbstract")
    public JAXBElement<Object> createRoleOfAbstract(Object value) {
        return new JAXBElement<Object>(_RoleOfAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ItemType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "RoleOfItem", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "RoleOfAbstract")
    public JAXBElement<ItemType> createRoleOfItem(ItemType value) {
        return new JAXBElement<ItemType>(_RoleOfItem_QNAME, ItemType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "RoleOfOrganization", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "RoleOfAbstract")
    public JAXBElement<OrganizationType> createRoleOfOrganization(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_RoleOfOrganization_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "RoleOfPerson", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "RoleOfAbstract")
    public JAXBElement<PersonType> createRoleOfPerson(PersonType value) {
        return new JAXBElement<PersonType>(_RoleOfPerson_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ScheduleActivityText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ScheduleDate", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "ScheduleDayAbstract")
    public JAXBElement<DateType> createScheduleDate(DateType value) {
        return new JAXBElement<DateType>(_ScheduleDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ScheduleDayAbstract")
    public JAXBElement<Object> createScheduleDayAbstract(Object value) {
        return new JAXBElement<Object>(_ScheduleDayAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Time }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Time }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ScheduleDayEndTime")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "ScheduleDayStartTime")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "SensitivityText")
    public JAXBElement<TextType> createSensitivityText(TextType value) {
        return new JAXBElement<TextType>(_SensitivityText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "SpeedUnitAbstract")
    public JAXBElement<Object> createSpeedUnitAbstract(Object value) {
        return new JAXBElement<Object>(_SpeedUnitAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VelocityCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link VelocityCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "SpeedUnitCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "SpeedUnitAbstract")
    public JAXBElement<VelocityCodeType> createSpeedUnitCode(VelocityCodeType value) {
        return new JAXBElement<VelocityCodeType>(_SpeedUnitCode_QNAME, VelocityCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StartDate")
    public JAXBElement<DateType> createStartDate(DateType value) {
        return new JAXBElement<DateType>(_StartDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StatusAbstract")
    public JAXBElement<Object> createStatusAbstract(Object value) {
        return new JAXBElement<Object>(_StatusAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StatusDate")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StatusDescriptionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StatusText", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "StatusAbstract")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StreetCategoryText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StreetExtensionText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StreetFullText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StreetName")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StreetNumberText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StreetPostdirectionalText")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "StreetPredirectionalText")
    public JAXBElement<TextType> createStreetPredirectionalText(TextType value) {
        return new JAXBElement<TextType>(_StreetPredirectionalText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "SupervisionCustodyStatus")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "SupervisionFacility")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "TelephoneAreaCodeID")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "TelephoneCountryCodeID")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "TelephoneExchangeID")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "TelephoneLineID")
    public JAXBElement<String> createTelephoneLineID(String value) {
        return new JAXBElement<String>(_TelephoneLineID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "TelephoneNumberFullID")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "TelephoneNumberID")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "TelephoneSuffixID")
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
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "Vehicle")
    public JAXBElement<VehicleType> createVehicle(VehicleType value) {
        return new JAXBElement<VehicleType>(_Vehicle_QNAME, VehicleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "VehicleAugmentationPoint")
    public JAXBElement<Object> createVehicleAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_VehicleAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "VehicleIdentification")
    public JAXBElement<IdentificationType> createVehicleIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_VehicleIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "WeightUnitAbstract")
    public JAXBElement<Object> createWeightUnitAbstract(Object value) {
        return new JAXBElement<Object>(_WeightUnitAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MassCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link MassCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/niem-core/4.0/", name = "WeightUnitCode", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "WeightUnitAbstract")
    public JAXBElement<MassCodeType> createWeightUnitCode(MassCodeType value) {
        return new JAXBElement<MassCodeType>(_WeightUnitCode_QNAME, MassCodeType.class, null, value);
    }

}
