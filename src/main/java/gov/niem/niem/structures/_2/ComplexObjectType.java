
package gov.niem.niem.structures._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import gov.niem.niem.ansi_nist._2.FingerprintType;
import gov.niem.niem.domains.jxdm._4.ChargeType;
import gov.niem.niem.domains.jxdm._4.CourtAppearanceType;
import gov.niem.niem.domains.jxdm._4.EnforcementOfficialType;
import gov.niem.niem.domains.jxdm._4.JudicialOfficialBarMembershipType;
import gov.niem.niem.domains.jxdm._4.JudicialOfficialType;
import gov.niem.niem.domains.jxdm._4.RegisteredOffenderType;
import gov.niem.niem.domains.jxdm._4.SeverityLevelType;
import gov.niem.niem.domains.jxdm._4.StatuteType;
import gov.niem.niem.domains.jxdm._4.SubjectType;
import gov.niem.niem.domains.jxdm._4.VictimType;
import gov.niem.niem.niem_core._2.ActivityType;
import gov.niem.niem.niem_core._2.AddressType;
import gov.niem.niem.niem_core._2.AssociationType;
import gov.niem.niem.niem_core._2.BinaryType;
import gov.niem.niem.niem_core._2.BiometricType;
import gov.niem.niem.niem_core._2.CapabilityType;
import gov.niem.niem.niem_core._2.CaseDispositionDecisionType;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.DNALocusType;
import gov.niem.niem.niem_core._2.DNAType;
import gov.niem.niem.niem_core._2.DateRangeType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.DispositionType;
import gov.niem.niem.niem_core._2.DocumentType;
import gov.niem.niem.niem_core._2.DriverLicenseBaseType;
import gov.niem.niem.niem_core._2.DrivingRestrictionType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.FacilityType;
import gov.niem.niem.niem_core._2.FingerprintSetType;
import gov.niem.niem.niem_core._2.FullTelephoneNumberType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.InsuranceType;
import gov.niem.niem.niem_core._2.InternationalTelephoneNumberType;
import gov.niem.niem.niem_core._2.ItemRegistrationType;
import gov.niem.niem.niem_core._2.ItemType;
import gov.niem.niem.niem_core._2.ItemValueType;
import gov.niem.niem.niem_core._2.JurisdictionType;
import gov.niem.niem.niem_core._2.LocationType;
import gov.niem.niem.niem_core._2.MeasureType;
import gov.niem.niem.niem_core._2.NANPTelephoneNumberType;
import gov.niem.niem.niem_core._2.ObligationExemptionType;
import gov.niem.niem.niem_core._2.ObligationType;
import gov.niem.niem.niem_core._2.OrganizationType;
import gov.niem.niem.niem_core._2.PersonLanguageType;
import gov.niem.niem.niem_core._2.PersonNameType;
import gov.niem.niem.niem_core._2.PersonType;
import gov.niem.niem.niem_core._2.PhysicalFeatureType;
import gov.niem.niem.niem_core._2.PropertyType;
import gov.niem.niem.niem_core._2.ScheduleDayType;
import gov.niem.niem.niem_core._2.StatusType;
import gov.niem.niem.niem_core._2.StreetType;
import gov.niem.niem.niem_core._2.StructuredAddressType;
import gov.niem.niem.niem_core._2.SupervisionType;
import gov.niem.niem.niem_core._2.TelephoneNumberType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseAddedPartyType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseRemovedPartyType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCivilCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCourtRuleCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseParticipantType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryCriteriaType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseAugmentationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.DecedentEstateCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.FiduciaryCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.AliasType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseAugmentationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CourtEventActorType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CourtEventOnBehalfOfActorType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.DocumentSignatureType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicServiceInformationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.SignatureType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtCodelistType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtExtensionType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.PublicKeyInformationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.RuntimePolicyParametersType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseChildSupportPetitionType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseViolencePetitionType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.DependencyAllegationType;
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
 * &lt;p&gt;Java class for ComplexObjectType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ComplexObjectType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;attribute ref="{http://niem.gov/niem/structures/2.0}id"/&amp;gt;
 *       &amp;lt;attribute ref="{http://niem.gov/niem/structures/2.0}metadata"/&amp;gt;
 *       &amp;lt;attribute ref="{http://niem.gov/niem/structures/2.0}linkMetadata"/&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplexObjectType")
@XmlSeeAlso({
    DateType.class,
    DateRangeType.class,
    CaseParticipantType.class,
    StatuteType.class,
    DependencyAllegationType.class,
    AliasType.class,
    CourtEventActorType.class,
    CourtEventOnBehalfOfActorType.class,
    DocumentSignatureType.class,
    ElectronicServiceInformationType.class,
    ErrorType.class,
    SignatureType.class,
    AddressType.class,
    BiometricType.class,
    BinaryType.class,
    CaseDispositionDecisionType.class,
    TelephoneNumberType.class,
    ContactInformationType.class,
    DNALocusType.class,
    DriverLicenseBaseType.class,
    DrivingRestrictionType.class,
    FullTelephoneNumberType.class,
    LocationType.class,
    InsuranceType.class,
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
    DomesticCaseChildSupportPetitionType.class,
    DomesticCaseViolencePetitionType.class,
    ObligationType.class,
    AppellateCaseAddedPartyType.class,
    AppellateCaseRemovedPartyType.class,
    AppellateCivilCaseType.class,
    AppellateCourtRuleCaseType.class,
    StatusType.class,
    DecedentEstateCaseType.class,
    FiduciaryCaseType.class,
    CourtCodelistType.class,
    CourtExtensionType.class,
    PublicKeyInformationType.class,
    RuntimePolicyParametersType.class,
    CaseQueryCriteriaType.class,
    ChargeType.class,
    EnforcementOfficialType.class,
    DispositionType.class,
    SeverityLevelType.class,
    CourtAppearanceType.class,
    JudicialOfficialType.class,
    OrganizationType.class,
    JudicialOfficialBarMembershipType.class,
    RegisteredOffenderType.class,
    VictimType.class,
    DevelopmentPolicyParametersType.class,
    CapabilityType.class,
    AssociationType.class,
    ItemType.class,
    CitationCaseAugmentationType.class,
    PersonType.class,
    EntityType.class,
    CaseAugmentationType.class,
    IdentificationType.class,
    FingerprintType.class,
    ActivityType.class,
    SubjectType.class,
    QueryResponseMessageType.class,
    QueryMessageType.class,
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the metadata property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getMetadata().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the linkMetadata property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getLinkMetadata().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
