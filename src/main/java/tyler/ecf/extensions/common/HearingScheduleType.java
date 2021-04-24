
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.TextType;


/**
 * &lt;p&gt;Java class for HearingScheduleType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="HearingScheduleType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ScheduleDayStartTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ScheduleDayEndTime" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CourtRoom" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CourtStreet" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}CourtCityStateZip" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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

}
