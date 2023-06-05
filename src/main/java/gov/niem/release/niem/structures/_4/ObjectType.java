
package gov.niem.release.niem.structures._4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import gov.niem.release.niem.domains.biometrics._4.BiometricClassificationType;
import gov.niem.release.niem.domains.biometrics._4.BiometricDataType;
import gov.niem.release.niem.domains.biometrics._4.DNASTRProfileType;
import gov.niem.release.niem.domains.biometrics._4.DNASampleType;
import gov.niem.release.niem.domains.cbrn._4.MessageContentErrorType;
import gov.niem.release.niem.domains.cbrn._4.MessageErrorType;
import gov.niem.release.niem.domains.cbrn._4.RemarksComplexObjectType;
import gov.niem.release.niem.domains.humanservices._4.ChildType;
import gov.niem.release.niem.domains.humanservices._4.JuvenileType;
import gov.niem.release.niem.domains.jxdm._6.ChargeEnhancingFactorType;
import gov.niem.release.niem.domains.jxdm._6.ChargeType;
import gov.niem.release.niem.domains.jxdm._6.CourtAppearanceType;
import gov.niem.release.niem.domains.jxdm._6.DriverLicenseBaseType;
import gov.niem.release.niem.domains.jxdm._6.DrivingRestrictionType;
import gov.niem.release.niem.domains.jxdm._6.EnforcementOfficialType;
import gov.niem.release.niem.domains.jxdm._6.ItemRegistrationType;
import gov.niem.release.niem.domains.jxdm._6.JudicialOfficialBarMembershipType;
import gov.niem.release.niem.domains.jxdm._6.JudicialOfficialType;
import gov.niem.release.niem.domains.jxdm._6.OrganizationAlternateNameType;
import gov.niem.release.niem.domains.jxdm._6.RegisteredOffenderType;
import gov.niem.release.niem.domains.jxdm._6.SeverityLevelType;
import gov.niem.release.niem.domains.jxdm._6.StatuteType;
import gov.niem.release.niem.domains.jxdm._6.SubjectType;
import gov.niem.release.niem.niem_core._4.ActivityType;
import gov.niem.release.niem.niem_core._4.AddressType;
import gov.niem.release.niem.niem_core._4.AmountType;
import gov.niem.release.niem.niem_core._4.BinaryType;
import gov.niem.release.niem.niem_core._4.CapabilityType;
import gov.niem.release.niem.niem_core._4.ContactInformationType;
import gov.niem.release.niem.niem_core._4.CountryType;
import gov.niem.release.niem.niem_core._4.DateRangeType;
import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.DispositionType;
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.FacilityType;
import gov.niem.release.niem.niem_core._4.FullTelephoneNumberType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.InsuranceType;
import gov.niem.release.niem.niem_core._4.InternationalTelephoneNumberType;
import gov.niem.release.niem.niem_core._4.ItemType;
import gov.niem.release.niem.niem_core._4.ItemValueType;
import gov.niem.release.niem.niem_core._4.JurisdictionType;
import gov.niem.release.niem.niem_core._4.LocationType;
import gov.niem.release.niem.niem_core._4.MeasureType;
import gov.niem.release.niem.niem_core._4.NANPTelephoneNumberType;
import gov.niem.release.niem.niem_core._4.ObligationExemptionType;
import gov.niem.release.niem.niem_core._4.ObligationRecurrenceType;
import gov.niem.release.niem.niem_core._4.ObligationType;
import gov.niem.release.niem.niem_core._4.OrganizationType;
import gov.niem.release.niem.niem_core._4.PersonLanguageType;
import gov.niem.release.niem.niem_core._4.PersonNameType;
import gov.niem.release.niem.niem_core._4.PersonType;
import gov.niem.release.niem.niem_core._4.PhysicalFeatureType;
import gov.niem.release.niem.niem_core._4.ScheduleDayType;
import gov.niem.release.niem.niem_core._4.ScheduleType;
import gov.niem.release.niem.niem_core._4.StateType;
import gov.niem.release.niem.niem_core._4.StatusType;
import gov.niem.release.niem.niem_core._4.StreetType;
import gov.niem.release.niem.niem_core._4.TelephoneNumberType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest.CaseListQueryCriteriaType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest.CaseQueryCriteriaType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.DecedentEstateCaseType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CourtEventActorType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CourtEventOnBehalfOfActorType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentReviewDispositionType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentReviewType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentSignatureType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ElectronicServiceInformationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest.FilingStatusQueryCriteriaType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.DevelopmentPolicyType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.ExtensionType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.MajorDesignElementType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.RuntimePolicyType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.SupportedCaseCategoriesType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.SupportedOperationsType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.SupportedServiceInteractionProfilesType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.SupportedSignatureProfilesType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.batchdetailrequest.BatchDetailQueryCriteriaType;
import tyler.ecf.v5_0.extensions.batchlistrequest.BatchListQueryCriteriaType;
import tyler.ecf.v5_0.extensions.batchlistresponse.BatchType;
import tyler.ecf.v5_0.extensions.common.AddressAugmentationType;
import tyler.ecf.v5_0.extensions.common.AttachmentAugmentationType;
import tyler.ecf.v5_0.extensions.common.CaseListQueryCriteriaAugmentationType;
import tyler.ecf.v5_0.extensions.common.ElectronicServiceAugmentationType;
import tyler.ecf.v5_0.extensions.common.FilingListQueryCriteriaAugmentationType;
import tyler.ecf.v5_0.extensions.common.FilingStatusAugmentationType;
import tyler.ecf.v5_0.extensions.common.MatchingFilingAugmentationType;
import tyler.ecf.v5_0.extensions.common.PagingAugmentationType;
import tyler.ecf.v5_0.extensions.common.PhysicalFeatureAugmentationType;
import tyler.ecf.v5_0.extensions.common.ReferenceType;
import tyler.ecf.v5_0.extensions.common.VehicleAugmentationType;
import tyler.ecf.v5_0.extensions.criminal.CitationAugmentationType;
import tyler.ecf.v5_0.extensions.criminal.DispositionAugmentationType;
import tyler.ecf.v5_0.extensions.criminal.StatuteAugmentationType;


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
    AmountType.class,
    ReferenceType.class,
    AddressType.class,
    IdentificationType.class,
    EntityType.class,
    BatchDetailQueryCriteriaType.class,
    FilingStatusQueryCriteriaType.class,
    BatchListQueryCriteriaType.class,
    BatchType.class,
    MessageErrorType.class,
    MessageContentErrorType.class,
    RemarksComplexObjectType.class,
    CaseListQueryCriteriaType.class,
    LocationType.class,
    EnforcementOfficialType.class,
    SubjectType.class,
    ChargeEnhancingFactorType.class,
    SeverityLevelType.class,
    StatuteType.class,
    CourtAppearanceType.class,
    JudicialOfficialType.class,
    ScheduleDayType.class,
    OrganizationType.class,
    ItemValueType.class,
    JudicialOfficialBarMembershipType.class,
    OrganizationAlternateNameType.class,
    PersonType.class,
    RegisteredOffenderType.class,
    JurisdictionType.class,
    DriverLicenseBaseType.class,
    DrivingRestrictionType.class,
    ItemRegistrationType.class,
    ChildType.class,
    JuvenileType.class,
    FacilityType.class,
    DocumentReviewType.class,
    CourtEventOnBehalfOfActorType.class,
    CourtEventActorType.class,
    https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentType.class,
    DocumentReviewDispositionType.class,
    DocumentSignatureType.class,
    ElectronicServiceInformationType.class,
    StatusType.class,
    DispositionType.class,
    ContactInformationType.class,
    TelephoneNumberType.class,
    DateRangeType.class,
    FullTelephoneNumberType.class,
    InsuranceType.class,
    InternationalTelephoneNumberType.class,
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
    ActivityType.class,
    ItemType.class,
    MeasureType.class,
    ObligationType.class,
    ScheduleType.class,
    DecedentEstateCaseType.class,
    DevelopmentPolicyType.class,
    MajorDesignElementType.class,
    RuntimePolicyType.class,
    SupportedCaseCategoriesType.class,
    SupportedOperationsType.class,
    SupportedServiceInteractionProfilesType.class,
    SupportedSignatureProfilesType.class,
    ExtensionType.class,
    CaseQueryCriteriaType.class,
    BiometricDataType.class,
    BiometricClassificationType.class,
    DNASTRProfileType.class,
    DNASampleType.class,
    BinaryType.class,
    gov.niem.release.niem.niem_core._4.DocumentType.class,
    ChargeType.class
})
public abstract class ObjectType {

    @XmlElementRef(name = "ObjectAugmentationPoint", namespace = "http://release.niem.gov/niem/structures/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> objectAugmentationPoint;
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
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link AddressAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link AttachmentAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link CaseListQueryCriteriaAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link ElectronicServiceAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link FilingListQueryCriteriaAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link FilingStatusAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link MatchingFilingAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link PagingAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link PhysicalFeatureAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link VehicleAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link CitationAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link DispositionAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link StatuteAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getObjectAugmentationPoint() {
        if (objectAugmentationPoint == null) {
            objectAugmentationPoint = new ArrayList<JAXBElement<?>>();
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
