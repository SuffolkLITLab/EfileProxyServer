
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reservedate;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.CaseType;
import gov.niem.release.niem.niem_core._4.DateRangeType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Duration;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseFilingType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.common.FilingMessageAugmentationType;


/**
 * A request to allocate a court date on the schedule.
 * 
 * <p>Java class for ReserveCourtDateMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReserveCourtDateMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseFilingType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseParticipantRoleCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Case" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate}EstimatedDuration" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate}PotentialStartTimeRange" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate}ReserveCourtDateMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "ReserveCourtDateMessageType", propOrder = {
    "caseParticipantRoleCode",
    "_case",
    "estimatedDuration",
    "potentialStartTimeRange",
    "reserveCourtDateMessageAugmentationPoint"
})
public class ReserveCourtDateMessageType
    extends CaseFilingType
{

    @XmlElement(name = "CaseParticipantRoleCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf")
    protected TextType caseParticipantRoleCode;
    @XmlElement(name = "Case", namespace = "http://release.niem.gov/niem/niem-core/4.0/", nillable = true)
    protected CaseType _case;
    @XmlElement(name = "EstimatedDuration")
    protected Duration estimatedDuration;
    @XmlElement(name = "PotentialStartTimeRange")
    protected List<DateRangeType> potentialStartTimeRange;
    @XmlElementRef(name = "ReserveCourtDateMessageAugmentationPoint", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/reservedate", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> reserveCourtDateMessageAugmentationPoint;

    /**
     * Gets the value of the caseParticipantRoleCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseParticipantRoleCode() {
        return caseParticipantRoleCode;
    }

    /**
     * Sets the value of the caseParticipantRoleCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseParticipantRoleCode(TextType value) {
        this.caseParticipantRoleCode = value;
    }

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link CaseType }
     *     
     */
    public CaseType getCase() {
        return _case;
    }

    /**
     * Sets the value of the case property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseType }
     *     
     */
    public void setCase(CaseType value) {
        this._case = value;
    }

    /**
     * Gets the value of the estimatedDuration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getEstimatedDuration() {
        return estimatedDuration;
    }

    /**
     * Sets the value of the estimatedDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setEstimatedDuration(Duration value) {
        this.estimatedDuration = value;
    }

    /**
     * Gets the value of the potentialStartTimeRange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the potentialStartTimeRange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPotentialStartTimeRange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DateRangeType }
     * 
     * 
     */
    public List<DateRangeType> getPotentialStartTimeRange() {
        if (potentialStartTimeRange == null) {
            potentialStartTimeRange = new ArrayList<DateRangeType>();
        }
        return this.potentialStartTimeRange;
    }

    /**
     * Gets the value of the reserveCourtDateMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the reserveCourtDateMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReserveCourtDateMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link FilingMessageAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getReserveCourtDateMessageAugmentationPoint() {
        if (reserveCourtDateMessageAugmentationPoint == null) {
            reserveCourtDateMessageAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.reserveCourtDateMessageAugmentationPoint;
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
