
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.Time;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ScheduleDayType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ScheduleDayType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ScheduleActivityText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ScheduleDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ScheduleDayEndTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}ScheduleDayStartTime" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ScheduleDayType", propOrder = {
    "scheduleActivityText",
    "scheduleDate",
    "scheduleDayEndTime",
    "scheduleDayStartTime"
})
public class ScheduleDayType
    extends ComplexObjectType
{

    @XmlElement(name = "ScheduleActivityText", nillable = true)
    protected TextType scheduleActivityText;
    @XmlElement(name = "ScheduleDate", nillable = true)
    protected DateType scheduleDate;
    @XmlElement(name = "ScheduleDayEndTime", nillable = true)
    protected Time scheduleDayEndTime;
    @XmlElement(name = "ScheduleDayStartTime", nillable = true)
    protected Time scheduleDayStartTime;

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
     * Gets the value of the scheduleDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getScheduleDate() {
        return scheduleDate;
    }

    /**
     * Sets the value of the scheduleDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setScheduleDate(DateType value) {
        this.scheduleDate = value;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
