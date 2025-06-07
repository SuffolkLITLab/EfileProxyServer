
package ecf5.v2024_6.gov.niem.release.niem.structures._4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6.IncidentAugmentationType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentAssociationAugmentationType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ItemAugmentationType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.OrganizationAssociationAugmentationType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.PersonAssociationAugmentationType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.PersonOrganizationAssociationAugmentationType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RelatedActivityAssociationAugmentationType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.SignatureAugmentationType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.SubjectAugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyAttribute;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.AddressAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.AttachmentAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.CaseJudgeAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.CaseListQueryCriteriaAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.DocumentSecurityAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.ElectronicServiceAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.FilerAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.FilingListQueryCriteriaAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.FilingMessageAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.FilingStatusAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.GetCaseListRequestMessageAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.GetCaseRequestAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.GetFilingStatusRequestMessageAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.GetPolicyResponseMessageAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.MatchingFilingAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.NotifyDocketingCompleteMessageAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.PagingAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.PhysicalFeatureAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.SchedulingAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.StatusDocumentAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.VehicleAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.criminal.ChargeAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.criminal.CitationAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.criminal.DispositionAugmentationType;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.criminal.StatuteAugmentationType;


/**
 * <p>Java class for AugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/4.0/}id"/&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/4.0/}ref"/&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/4.0/}uri"/&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/structures/4.0/}metadata"/&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AugmentationType")
@XmlSeeAlso({
    ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseAugmentationType.class,
    ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseOfficialAugmentationType.class,
    ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CourtEventAugmentationType.class,
    DocumentAssociationAugmentationType.class,
    ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentAugmentationType.class,
    ItemAugmentationType.class,
    ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.MessageStatusAugmentationType.class,
    OrganizationAssociationAugmentationType.class,
    ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.OrganizationAugmentationType.class,
    PersonAssociationAugmentationType.class,
    ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.PersonAugmentationType.class,
    PersonOrganizationAssociationAugmentationType.class,
    RelatedActivityAssociationAugmentationType.class,
    ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ReviewedDocumentAugmentationType.class,
    SignatureAugmentationType.class,
    SubjectAugmentationType.class,
    ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6.CaseAugmentationType.class,
    IncidentAugmentationType.class,
    ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6.PersonAugmentationType.class,
    ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6.OrganizationAugmentationType.class,
    AddressAugmentationType.class,
    AttachmentAugmentationType.class,
    ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.CaseAugmentationType.class,
    CaseJudgeAugmentationType.class,
    CaseListQueryCriteriaAugmentationType.class,
    ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.CaseOfficialAugmentationType.class,
    ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.CourtEventAugmentationType.class,
    ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.DocumentAugmentationType.class,
    DocumentSecurityAugmentationType.class,
    ElectronicServiceAugmentationType.class,
    FilerAugmentationType.class,
    FilingListQueryCriteriaAugmentationType.class,
    FilingStatusAugmentationType.class,
    GetCaseListRequestMessageAugmentationType.class,
    GetCaseRequestAugmentationType.class,
    GetFilingStatusRequestMessageAugmentationType.class,
    GetPolicyResponseMessageAugmentationType.class,
    MatchingFilingAugmentationType.class,
    ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.MessageStatusAugmentationType.class,
    NotifyDocketingCompleteMessageAugmentationType.class,
    ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.OrganizationAugmentationType.class,
    PagingAugmentationType.class,
    ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.PersonAugmentationType.class,
    PhysicalFeatureAugmentationType.class,
    FilingMessageAugmentationType.class,
    ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.ReviewedDocumentAugmentationType.class,
    SchedulingAugmentationType.class,
    StatusDocumentAugmentationType.class,
    VehicleAugmentationType.class,
    ChargeAugmentationType.class,
    CitationAugmentationType.class,
    DispositionAugmentationType.class,
    StatuteAugmentationType.class,
    ecf5.v2024_6.tyler.ecf.v5_0.extensions.taxdelinquency.CaseAugmentationType.class,
    ecf5.v2024_6.tyler.ecf.v5_0.extensions.massachusetts.CaseAugmentationType.class,
    ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.CaseAugmentationType.class
})
public abstract class AugmentationType {

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
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

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
