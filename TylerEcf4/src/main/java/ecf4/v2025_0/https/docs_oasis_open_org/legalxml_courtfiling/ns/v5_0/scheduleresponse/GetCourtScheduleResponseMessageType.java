
package ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.scheduleresponse;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ResponseMessageType;
import ecf4.v2025_0.ietf.params.xml.ns.icalendar_2.IcalendarType;


/**
 * The schedule of upcoming events in a court
 * 
 * <p>Java class for GetCourtScheduleResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCourtScheduleResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}icalendar" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/scheduleresponse}GetCourtScheduleResponseMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "GetCourtScheduleResponseMessageType", propOrder = {
    "icalendar",
    "getCourtScheduleResponseMessageAugmentationPoint"
})
public class GetCourtScheduleResponseMessageType
    extends ResponseMessageType
{

    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0")
    protected IcalendarType icalendar;
    @XmlElement(name = "GetCourtScheduleResponseMessageAugmentationPoint")
    protected List<Object> getCourtScheduleResponseMessageAugmentationPoint;

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
     * Gets the value of the getCourtScheduleResponseMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the getCourtScheduleResponseMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGetCourtScheduleResponseMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getGetCourtScheduleResponseMessageAugmentationPoint() {
        if (getCourtScheduleResponseMessageAugmentationPoint == null) {
            getCourtScheduleResponseMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.getCourtScheduleResponseMessageAugmentationPoint;
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
