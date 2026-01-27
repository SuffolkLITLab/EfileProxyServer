
package ecf4.v2025_0.gov.niem.release.niem.structures._4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import ecf4.v2025_0.gov.niem.release.niem.domains.biometrics._4.BiometricClassificationType;
import ecf4.v2025_0.gov.niem.release.niem.domains.biometrics._4.BiometricDataType;
import ecf4.v2025_0.gov.niem.release.niem.domains.biometrics._4.DNASTRProfileType;
import ecf4.v2025_0.gov.niem.release.niem.domains.biometrics._4.DNASampleType;
import ecf4.v2025_0.gov.niem.release.niem.domains.cbrn._4.MessageContentErrorType;
import ecf4.v2025_0.gov.niem.release.niem.domains.cbrn._4.MessageErrorType;
import ecf4.v2025_0.gov.niem.release.niem.domains.cbrn._4.RemarksComplexObjectType;
import ecf4.v2025_0.gov.niem.release.niem.domains.humanservices._4.ChildType;
import ecf4.v2025_0.gov.niem.release.niem.domains.humanservices._4.JuvenileType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.ChargeEnhancingFactorType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.ChargeType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.CourtAppearanceType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.DriverLicenseBaseType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.DrivingRestrictionType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.EnforcementOfficialType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.ItemRegistrationType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.JudicialOfficialBarMembershipType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.JudicialOfficialType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.OrganizationAlternateNameType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.RegisteredOffenderType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.SeverityLevelType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.StatuteType;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.SubjectType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ActivityType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.AddressType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.AmountType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.BinaryType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.CapabilityType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ContactInformationType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.CountryType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.DateRangeType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.DateType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.DispositionType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.DocumentType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.EntityType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.FacilityType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.FullTelephoneNumberType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.InsuranceType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.InternationalTelephoneNumberType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ItemType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ItemValueType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.JurisdictionType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.LocationType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.MeasureType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.NANPTelephoneNumberType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ObligationExemptionType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ObligationRecurrenceType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ObligationType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.OrganizationType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.PersonLanguageType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.PersonNameType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.PersonType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.PhysicalFeatureType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ScheduleDayType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.ScheduleType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.StateType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.StatusType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.StreetType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.TelephoneNumberType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest.CaseQueryCriteriaType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.DecedentEstateCaseType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CourtEventActorType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CourtEventOnBehalfOfActorType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentSignatureType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ElectronicServiceInformationType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.PaymentMessageType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.DevelopmentPolicyType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.ExtensionType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.MajorDesignElementType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.RuntimePolicyType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.SupportedCaseCategoriesType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.SupportedOperationsType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.SupportedServiceInteractionProfilesType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.SupportedSignatureProfilesType;
import ecf4.v2025_0.tyler.ecf.v5_0.extensions.common.FilingReferenceType;


/**
 * <p>Java class for ObjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ObjectType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/structures/4.0/}ObjectAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/4.0/}id"/&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/4.0/}ref"/&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/4.0/}uri"/&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/4.0/}metadata"/&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/4.0/}relationshipMetadata"/&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ObjectType", propOrder = {
    "objectAugmentationPoint"
})
@XmlSeeAlso({
    DateType.class,
    ChildType.class,
    JuvenileType.class,
    PersonType.class,
    FacilityType.class,
    IdentificationType.class,
    AddressType.class,
    EntityType.class,
    ContactInformationType.class,
    TelephoneNumberType.class,
    DateRangeType.class,
    AmountType.class,
    FullTelephoneNumberType.class,
    JurisdictionType.class,
    LocationType.class,
    InternationalTelephoneNumberType.class,
    ItemValueType.class,
    CountryType.class,
    StateType.class,
    StreetType.class,
    NANPTelephoneNumberType.class,
    ObligationExemptionType.class,
    ObligationRecurrenceType.class,
    CapabilityType.class,
    PersonNameType.class,
    PhysicalFeatureType.class,
    PersonLanguageType.class,
    ItemType.class,
    ObligationType.class,
    ScheduleDayType.class,
    ScheduleType.class,
    MeasureType.class,
    CaseQueryCriteriaType.class,
    ChargeType.class,
    EnforcementOfficialType.class,
    SubjectType.class,
    DispositionType.class,
    ChargeEnhancingFactorType.class,
    SeverityLevelType.class,
    StatuteType.class,
    CourtAppearanceType.class,
    JudicialOfficialType.class,
    OrganizationType.class,
    JudicialOfficialBarMembershipType.class,
    OrganizationAlternateNameType.class,
    RegisteredOffenderType.class,
    ActivityType.class,
    DriverLicenseBaseType.class,
    DrivingRestrictionType.class,
    ItemRegistrationType.class,
    FilingReferenceType.class,
    MessageErrorType.class,
    MessageContentErrorType.class,
    RemarksComplexObjectType.class,
    BiometricDataType.class,
    BiometricClassificationType.class,
    DNASTRProfileType.class,
    DNASampleType.class,
    BinaryType.class,
    DevelopmentPolicyType.class,
    MajorDesignElementType.class,
    RuntimePolicyType.class,
    SupportedCaseCategoriesType.class,
    SupportedOperationsType.class,
    SupportedServiceInteractionProfilesType.class,
    SupportedSignatureProfilesType.class,
    ExtensionType.class,
    CourtEventOnBehalfOfActorType.class,
    CourtEventActorType.class,
    DocumentSignatureType.class,
    ElectronicServiceInformationType.class,
    StatusType.class,
    InsuranceType.class,
    DecedentEstateCaseType.class,
    PaymentMessageType.class,
    DocumentType.class
})
public abstract class ObjectType {

    @XmlElement(name = "ObjectAugmentationPoint")
    protected List<Object> objectAugmentationPoint;
    @XmlAttribute(name = "id", namespace = "http://release.niem.gov/niem/structures/4.0/")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "ref", namespace = "http://release.niem.gov/niem/structures/4.0/")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object ref;
    @XmlAttribute(name = "uri", namespace = "http://release.niem.gov/niem/structures/4.0/")
    @XmlSchemaType(name = "anyURI")
    protected String uri;
    @XmlAttribute(name = "metadata", namespace = "http://release.niem.gov/niem/structures/4.0/")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> metadata;
    @XmlAttribute(name = "relationshipMetadata", namespace = "http://release.niem.gov/niem/structures/4.0/")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> relationshipMetadata;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the objectAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the objectAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getObjectAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getObjectAugmentationPoint() {
        if (objectAugmentationPoint == null) {
            objectAugmentationPoint = new ArrayList<Object>();
        }
        return this.objectAugmentationPoint;
    }

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
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRef(Object value) {
        this.ref = value;
    }

    /**
     * Gets the value of the uri property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUri() {
        return uri;
    }

    /**
     * Sets the value of the uri property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUri(String value) {
        this.uri = value;
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
     * Gets the value of the relationshipMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the relationshipMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelationshipMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getRelationshipMetadata() {
        if (relationshipMetadata == null) {
            relationshipMetadata = new ArrayList<Object>();
        }
        return this.relationshipMetadata;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
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
