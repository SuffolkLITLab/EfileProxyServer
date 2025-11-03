
package ecf4.latest.gov.niem.niem.structures._2;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.niem.ansi_nist._2.FingerprintType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.ChargeType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.CourtAppearanceType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.EnforcementOfficialType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.JudicialOfficialBarMembershipType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.JudicialOfficialType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.RegisteredOffenderType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.SeverityLevelType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.StatuteType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.SubjectType;
import ecf4.latest.gov.niem.niem.domains.jxdm._4.VictimType;
import ecf4.latest.gov.niem.niem.niem_core._2.ActivityType;
import ecf4.latest.gov.niem.niem.niem_core._2.AddressType;
import ecf4.latest.gov.niem.niem.niem_core._2.AssociationType;
import ecf4.latest.gov.niem.niem.niem_core._2.BinaryType;
import ecf4.latest.gov.niem.niem.niem_core._2.BiometricType;
import ecf4.latest.gov.niem.niem.niem_core._2.CapabilityType;
import ecf4.latest.gov.niem.niem.niem_core._2.CaseDispositionDecisionType;
import ecf4.latest.gov.niem.niem.niem_core._2.ContactInformationType;
import ecf4.latest.gov.niem.niem.niem_core._2.DNALocusType;
import ecf4.latest.gov.niem.niem.niem_core._2.DNAType;
import ecf4.latest.gov.niem.niem.niem_core._2.DateRangeType;
import ecf4.latest.gov.niem.niem.niem_core._2.DateType;
import ecf4.latest.gov.niem.niem.niem_core._2.DispositionType;
import ecf4.latest.gov.niem.niem.niem_core._2.DocumentType;
import ecf4.latest.gov.niem.niem.niem_core._2.DriverLicenseBaseType;
import ecf4.latest.gov.niem.niem.niem_core._2.DrivingRestrictionType;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import ecf4.latest.gov.niem.niem.niem_core._2.FacilityType;
import ecf4.latest.gov.niem.niem.niem_core._2.FingerprintSetType;
import ecf4.latest.gov.niem.niem.niem_core._2.FullTelephoneNumberType;
import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.latest.gov.niem.niem.niem_core._2.InsuranceType;
import ecf4.latest.gov.niem.niem.niem_core._2.InternationalTelephoneNumberType;
import ecf4.latest.gov.niem.niem.niem_core._2.ItemRegistrationType;
import ecf4.latest.gov.niem.niem.niem_core._2.ItemType;
import ecf4.latest.gov.niem.niem.niem_core._2.ItemValueType;
import ecf4.latest.gov.niem.niem.niem_core._2.JurisdictionType;
import ecf4.latest.gov.niem.niem.niem_core._2.LocationType;
import ecf4.latest.gov.niem.niem.niem_core._2.MeasureType;
import ecf4.latest.gov.niem.niem.niem_core._2.NANPTelephoneNumberType;
import ecf4.latest.gov.niem.niem.niem_core._2.ObligationExemptionType;
import ecf4.latest.gov.niem.niem.niem_core._2.ObligationType;
import ecf4.latest.gov.niem.niem.niem_core._2.OrganizationType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonLanguageType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonNameType;
import ecf4.latest.gov.niem.niem.niem_core._2.PersonType;
import ecf4.latest.gov.niem.niem.niem_core._2.PhysicalFeatureType;
import ecf4.latest.gov.niem.niem.niem_core._2.PropertyType;
import ecf4.latest.gov.niem.niem.niem_core._2.ScheduleDayType;
import ecf4.latest.gov.niem.niem.niem_core._2.StatusType;
import ecf4.latest.gov.niem.niem.niem_core._2.StreetType;
import ecf4.latest.gov.niem.niem.niem_core._2.StructuredAddressType;
import ecf4.latest.gov.niem.niem.niem_core._2.SupervisionType;
import ecf4.latest.gov.niem.niem.niem_core._2.TelephoneNumberType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseAddedPartyType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseRemovedPartyType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCivilCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCourtRuleCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseParticipantType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryCriteriaType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseAugmentationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.DecedentEstateCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.FiduciaryCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.AliasType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseAugmentationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CourtEventActorType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CourtEventOnBehalfOfActorType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentSignatureType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicServiceInformationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.SignatureType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtCodelistType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtExtensionType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.PublicKeyInformationType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.RuntimePolicyParametersType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseChildSupportPetitionType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseViolencePetitionType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.DependencyAllegationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The ComplexObjectType type provides a base class
 *       for object definition, association definitions, and external adapter
 *       type definitions. An instance of one of these types may have an ID.
 *       It may have metadata as it establishes the existence of an object
 *       (maybe a conceptual object). It may also have link metadata, as an
 *       element of one of these types establishes a relationship between its
 *       value and its context.
 * 
 * <p>Java class for ComplexObjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComplexObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute ref="{http://niem.gov/niem/structures/2.0}id"/&gt;
 *       &lt;attribute ref="{http://niem.gov/niem/structures/2.0}metadata"/&gt;
 *       &lt;attribute ref="{http://niem.gov/niem/structures/2.0}linkMetadata"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplexObjectType")
@XmlSeeAlso({
    DateType.class,
    DateRangeType.class,
    AddressType.class,
    BiometricType.class,
    CaseDispositionDecisionType.class,
    TelephoneNumberType.class,
    ContactInformationType.class,
    DNALocusType.class,
    DriverLicenseBaseType.class,
    DrivingRestrictionType.class,
    FullTelephoneNumberType.class,
    LocationType.class,
    InternationalTelephoneNumberType.class,
    ItemValueType.class,
    StreetType.class,
    NANPTelephoneNumberType.class,
    ObligationExemptionType.class,
    DNAType.class,
    FingerprintSetType.class,
    PersonNameType.class,
    PhysicalFeatureType.class,
    PersonLanguageType.class,
    StructuredAddressType.class,
    SupervisionType.class,
    FacilityType.class,
    ItemRegistrationType.class,
    JurisdictionType.class,
    PropertyType.class,
    ScheduleDayType.class,
    MeasureType.class,
    DecedentEstateCaseType.class,
    FiduciaryCaseType.class,
    EnforcementOfficialType.class,
    DispositionType.class,
    SeverityLevelType.class,
    CourtAppearanceType.class,
    JudicialOfficialBarMembershipType.class,
    RegisteredOffenderType.class,
    VictimType.class,
    AliasType.class,
    JudicialOfficialType.class,
    CourtEventActorType.class,
    CourtEventOnBehalfOfActorType.class,
    BinaryType.class,
    DocumentSignatureType.class,
    ElectronicServiceInformationType.class,
    OrganizationType.class,
    ErrorType.class,
    InsuranceType.class,
    SignatureType.class,
    AppellateCaseAddedPartyType.class,
    AppellateCaseRemovedPartyType.class,
    AppellateCivilCaseType.class,
    AppellateCourtRuleCaseType.class,
    FingerprintType.class,
    DomesticCaseChildSupportPetitionType.class,
    DomesticCaseViolencePetitionType.class,
    ObligationType.class,
    DependencyAllegationType.class,
    SubjectType.class,
    CaseParticipantType.class,
    CaseQueryCriteriaType.class,
    CourtCodelistType.class,
    CourtExtensionType.class,
    PublicKeyInformationType.class,
    RuntimePolicyParametersType.class,
    DevelopmentPolicyParametersType.class,
    CapabilityType.class,
    AssociationType.class,
    ItemType.class,
    CitationCaseAugmentationType.class,
    ActivityType.class,
    PersonType.class,
    CaseAugmentationType.class,
    IdentificationType.class,
    StatusType.class,
    ChargeType.class,
    StatuteType.class,
    QueryMessageType.class,
    QueryResponseMessageType.class,
    EntityType.class,
    DocumentType.class
})
public abstract class ComplexObjectType {

    @XmlAttribute(name = "id", namespace = "http://niem.gov/niem/structures/2.0")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "metadata", namespace = "http://niem.gov/niem/structures/2.0")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> metadata;
    @XmlAttribute(name = "linkMetadata", namespace = "http://niem.gov/niem/structures/2.0")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> linkMetadata;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the metadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getMetadata() {
        if (metadata == null) {
            metadata = new ArrayList<Object>();
        }
        return this.metadata;
    }

    /**
     * Gets the value of the linkMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the linkMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getLinkMetadata() {
        if (linkMetadata == null) {
            linkMetadata = new ArrayList<Object>();
        }
        return this.linkMetadata;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
