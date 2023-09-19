
package tyler.ecf.extensions.common;

import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for HearingScheduleType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HearingScheduleType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ScheduleDayStartTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ScheduleDayEndTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}CourtRoom" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}CourtStreet" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}CourtCityStateZip" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HearingScheduleType", propOrder = {
    "scheduleDayStartTime",
    "scheduleDayEndTime",
    "courtRoom",
    "courtStreet",
    "courtCityStateZip"
})
public class HearingScheduleType {

    @XmlElement(name = "ScheduleDayStartTime")
    protected DateType scheduleDayStartTime;
    @XmlElement(name = "ScheduleDayEndTime")
    protected DateType scheduleDayEndTime;
    @XmlElement(name = "CourtRoom")
    protected TextType courtRoom;
    @XmlElement(name = "CourtStreet")
    protected TextType courtStreet;
    @XmlElement(name = "CourtCityStateZip")
    protected TextType courtCityStateZip;

    /**
     * Gets the value of the scheduleDayStartTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getScheduleDayStartTime() {
        return scheduleDayStartTime;
    }

    /**
     * Sets the value of the scheduleDayStartTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setScheduleDayStartTime(DateType value) {
        this.scheduleDayStartTime = value;
    }

    /**
     * Gets the value of the scheduleDayEndTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getScheduleDayEndTime() {
        return scheduleDayEndTime;
    }

    /**
     * Sets the value of the scheduleDayEndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setScheduleDayEndTime(DateType value) {
        this.scheduleDayEndTime = value;
    }

    /**
     * Gets the value of the courtRoom property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtRoom() {
        return courtRoom;
    }

    /**
     * Sets the value of the courtRoom property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtRoom(TextType value) {
        this.courtRoom = value;
    }

    /**
     * Gets the value of the courtStreet property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtStreet() {
        return courtStreet;
    }

    /**
     * Sets the value of the courtStreet property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtStreet(TextType value) {
        this.courtStreet = value;
    }

    /**
     * Gets the value of the courtCityStateZip property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtCityStateZip() {
        return courtCityStateZip;
    }

    /**
     * Sets the value of the courtCityStateZip property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtCityStateZip(TextType value) {
        this.courtCityStateZip = value;
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
