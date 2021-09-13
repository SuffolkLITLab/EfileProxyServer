
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.niem_core._4.DateRangeType;
import ecfv5.gov.niem.release.niem.niem_core._4.EntityType;
import ecfv5.gov.niem.release.niem.niem_core._4.StatusType;
import ecfv5.gov.niem.release.niem.niem_core._4.TextType;
import ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * This is a query for a list of cases that match a set of criteria including case participants, case classification, case status, and date of the case was initiated.
 * 
 * <p>Java class for GetCaseListRequestMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCaseListRequestMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest}CaseParticipant" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseCategoryCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ActivityStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DateRange" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistrequest}GetCaseListRequestMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetCaseListRequestMessageType", propOrder = {
    "caseParticipant",
    "caseCategoryCode",
    "activityStatus",
    "dateRange",
    "getCaseListRequestMessageAugmentationPoint"
})
public class GetCaseListRequestMessageType
    extends RequestMessageType
{

    @XmlElement(name = "CaseParticipant")
    protected EntityType caseParticipant;
    @XmlElement(name = "CaseCategoryCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected TextType caseCategoryCode;
    @XmlElement(name = "ActivityStatus", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected StatusType activityStatus;
    @XmlElement(name = "DateRange", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected DateRangeType dateRange;
    @XmlElement(name = "GetCaseListRequestMessageAugmentationPoint")
    protected List<Object> getCaseListRequestMessageAugmentationPoint;

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
     * Gets the value of the getCaseListRequestMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the getCaseListRequestMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCaseListRequestMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetCaseListRequestMessageAugmentationPoint() {
        if (getCaseListRequestMessageAugmentationPoint == null) {
            getCaseListRequestMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getCaseListRequestMessageAugmentationPoint;
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
