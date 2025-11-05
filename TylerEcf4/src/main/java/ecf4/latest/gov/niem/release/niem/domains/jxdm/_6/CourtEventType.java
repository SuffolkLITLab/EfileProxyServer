
package ecf4.latest.gov.niem.release.niem.domains.jxdm._6;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.release.niem.niem_core._4.ActivityType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.ScheduleDayType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a court occurrence.
 * 
 * <p>Java class for CourtEventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourtEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}ActivityType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}CourtEventJudge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}CourtEventSchedule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}CourtEventSequenceID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}CourtEventAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "CourtEventType", propOrder = {
    "courtEventJudge",
    "courtEventSchedule",
    "courtEventSequenceID",
    "courtEventAugmentationPoint"
})
public class CourtEventType
    extends ActivityType
{

    @XmlElement(name = "CourtEventJudge")
    protected List<JudicialOfficialType> courtEventJudge;
    @XmlElement(name = "CourtEventSchedule")
    protected List<ScheduleDayType> courtEventSchedule;
    @XmlElement(name = "CourtEventSequenceID")
    protected ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String courtEventSequenceID;
    @XmlElementRef(name = "CourtEventAugmentationPoint", namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> courtEventAugmentationPoint;

    /**
     * Gets the value of the courtEventJudge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the courtEventJudge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtEventJudge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JudicialOfficialType }
     * 
     * 
     */
    public List<JudicialOfficialType> getCourtEventJudge() {
        if (courtEventJudge == null) {
            courtEventJudge = new ArrayList<JudicialOfficialType>();
        }
        return this.courtEventJudge;
    }

    /**
     * Gets the value of the courtEventSchedule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the courtEventSchedule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtEventSchedule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ScheduleDayType }
     * 
     * 
     */
    public List<ScheduleDayType> getCourtEventSchedule() {
        if (courtEventSchedule == null) {
            courtEventSchedule = new ArrayList<ScheduleDayType>();
        }
        return this.courtEventSchedule;
    }

    /**
     * Gets the value of the courtEventSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String getCourtEventSequenceID() {
        return courtEventSequenceID;
    }

    /**
     * Sets the value of the courtEventSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setCourtEventSequenceID(ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.courtEventSequenceID = value;
    }

    /**
     * Gets the value of the courtEventAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the courtEventAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtEventAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CourtEventAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link ecf4.latest.tyler.ecf.v5_0.extensions.common.CourtEventAugmentationType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getCourtEventAugmentationPoint() {
        if (courtEventAugmentationPoint == null) {
            courtEventAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.courtEventAugmentationPoint;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
