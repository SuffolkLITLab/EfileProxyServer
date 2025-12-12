
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.allocatedate;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.domains.humanservices._4.ChildSupportEnforcementCaseType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.CaseType;
import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseFilingType;
import ecf5.v2024_6.ietf.params.xml.ns.icalendar_2.IcalendarType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.FilingMessageAugmentationType;


/**
 * A request to allocate a court date on the schedule.
 * 
 * <p>Java class for AllocateCourtDateMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AllocateCourtDateMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseFilingType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/allocatedate}AllocateCourtDateMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Case" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}icalendar" minOccurs="0"/&gt;
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
@XmlType(name = "AllocateCourtDateMessageType", propOrder = {
    "allocateCourtDateMessageAugmentationPoint",
    "_case",
    "icalendar"
})
public class AllocateCourtDateMessageType
    extends CaseFilingType
{

    @XmlElementRef(name = "AllocateCourtDateMessageAugmentationPoint", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/allocatedate", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> allocateCourtDateMessageAugmentationPoint;
    @XmlElementRef(name = "Case", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends CaseType> _case;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0")
    protected IcalendarType icalendar;

    /**
     * Gets the value of the allocateCourtDateMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the allocateCourtDateMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllocateCourtDateMessageAugmentationPoint().add(newItem);
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
    public List<JAXBElement<?>> getAllocateCourtDateMessageAugmentationPoint() {
        if (allocateCourtDateMessageAugmentationPoint == null) {
            allocateCourtDateMessageAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.allocateCourtDateMessageAugmentationPoint;
    }

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ChildSupportEnforcementCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     *     
     */
    public JAXBElement<? extends CaseType> getCase() {
        return _case;
    }

    /**
     * Sets the value of the case property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ChildSupportEnforcementCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     *     
     */
    public void setCase(JAXBElement<? extends CaseType> value) {
        this._case = value;
    }

    /**
     * Gets the value of the icalendar property.
     * 
     * @return
     *     possible object is
     *     {@link IcalendarType }
     *     
     */
    public IcalendarType getIcalendar() {
        return icalendar;
    }

    /**
     * Sets the value of the icalendar property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcalendarType }
     *     
     */
    public void setIcalendar(IcalendarType value) {
        this.icalendar = value;
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
