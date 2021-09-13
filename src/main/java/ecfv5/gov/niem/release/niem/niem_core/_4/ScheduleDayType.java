
package ecfv5.gov.niem.release.niem.niem_core._4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.proxy.xsd._4.Time;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a plan or agenda for the activities of a day.
 * 
 * <p>Java class for ScheduleDayType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ScheduleDayType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ScheduleActivityText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ScheduleDayAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ScheduleDayStartTime" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ScheduleDayEndTime" minOccurs="0"/&gt;
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
@XmlType(name = "ScheduleDayType", propOrder = {
    "scheduleActivityText",
    "scheduleDayAbstract",
    "scheduleDayStartTime",
    "scheduleDayEndTime"
})
public class ScheduleDayType
    extends ObjectType
{

    @XmlElement(name = "ScheduleActivityText")
    protected TextType scheduleActivityText;
    @XmlElementRef(name = "ScheduleDayAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> scheduleDayAbstract;
    @XmlElement(name = "ScheduleDayStartTime")
    protected Time scheduleDayStartTime;
    @XmlElement(name = "ScheduleDayEndTime")
    protected Time scheduleDayEndTime;

    /**
     * Gets the value of the scheduleActivityText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getScheduleActivityText() {
        return scheduleActivityText;
    }

    /**
     * Sets the value of the scheduleActivityText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setScheduleActivityText(TextType value) {
        this.scheduleActivityText = value;
    }

    /**
     * Gets the value of the scheduleDayAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DateType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getScheduleDayAbstract() {
        return scheduleDayAbstract;
    }

    /**
     * Sets the value of the scheduleDayAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DateType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setScheduleDayAbstract(JAXBElement<?> value) {
        this.scheduleDayAbstract = value;
    }

    /**
     * Gets the value of the scheduleDayStartTime property.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getScheduleDayStartTime() {
        return scheduleDayStartTime;
    }

    /**
     * Sets the value of the scheduleDayStartTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setScheduleDayStartTime(Time value) {
        this.scheduleDayStartTime = value;
    }

    /**
     * Gets the value of the scheduleDayEndTime property.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getScheduleDayEndTime() {
        return scheduleDayEndTime;
    }

    /**
     * Sets the value of the scheduleDayEndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setScheduleDayEndTime(Time value) {
        this.scheduleDayEndTime = value;
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
