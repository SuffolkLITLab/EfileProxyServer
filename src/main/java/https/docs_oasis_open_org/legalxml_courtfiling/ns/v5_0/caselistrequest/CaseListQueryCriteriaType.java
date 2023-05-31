
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest;

import gov.niem.release.niem.niem_core._4.DateRangeType;
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.StatusType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CaseListQueryCriteriaType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseListQueryCriteriaType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest}CaseParticipant" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseCategoryCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ActivityStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DateRange" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseListQueryCriteriaType", propOrder = {
    "caseParticipant",
    "caseCategoryCode",
    "activityStatus",
    "dateRange"
})
public class CaseListQueryCriteriaType
    extends ObjectType
{

    @XmlElement(name = "CaseParticipant")
    protected EntityType caseParticipant;
    @XmlElement(name = "CaseCategoryCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected TextType caseCategoryCode;
    @XmlElement(name = "ActivityStatus", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected StatusType activityStatus;
    @XmlElement(name = "DateRange", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected DateRangeType dateRange;

    /**
     * Gets the value of the caseParticipant property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getCaseParticipant() {
        return caseParticipant;
    }

    /**
     * Sets the value of the caseParticipant property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setCaseParticipant(EntityType value) {
        this.caseParticipant = value;
    }

    /**
     * Gets the value of the caseCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseCategoryCode() {
        return caseCategoryCode;
    }

    /**
     * Sets the value of the caseCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseCategoryCode(TextType value) {
        this.caseCategoryCode = value;
    }

    /**
     * Gets the value of the activityStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getActivityStatus() {
        return activityStatus;
    }

    /**
     * Sets the value of the activityStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setActivityStatus(StatusType value) {
        this.activityStatus = value;
    }

    /**
     * Gets the value of the dateRange property.
     * 
     * @return
     *     possible object is
     *     {@link DateRangeType }
     *     
     */
    public DateRangeType getDateRange() {
        return dateRange;
    }

    /**
     * Sets the value of the dateRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRangeType }
     *     
     */
    public void setDateRange(DateRangeType value) {
        this.dateRange = value;
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
