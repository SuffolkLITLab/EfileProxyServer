
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * An augmentation type
 * 
 * <p>Java class for CourtEventAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourtEventAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CourtSchedule" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CourtRoom" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CourtStreet" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CourtCityStateZip" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilingCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}MotionTypeCode" minOccurs="0"/&gt;
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
@XmlType(name = "CourtEventAugmentationType", propOrder = {
    "courtSchedule",
    "courtRoom",
    "courtStreet",
    "courtCityStateZip",
    "filingCode",
    "motionTypeCode"
})
public class CourtEventAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "CourtSchedule")
    protected List<CourtScheduleType> courtSchedule;
    @XmlElement(name = "CourtRoom")
    protected TextType courtRoom;
    @XmlElement(name = "CourtStreet")
    protected TextType courtStreet;
    @XmlElement(name = "CourtCityStateZip")
    protected TextType courtCityStateZip;
    @XmlElement(name = "FilingCode")
    protected TextType filingCode;
    @XmlElement(name = "MotionTypeCode")
    protected TextType motionTypeCode;

    /**
     * Gets the value of the courtSchedule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the courtSchedule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourtSchedule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourtScheduleType }
     * 
     * 
     */
    public List<CourtScheduleType> getCourtSchedule() {
        if (courtSchedule == null) {
            courtSchedule = new ArrayList<CourtScheduleType>();
        }
        return this.courtSchedule;
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
     * Gets the value of the filingCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFilingCode() {
        return filingCode;
    }

    /**
     * Sets the value of the filingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFilingCode(TextType value) {
        this.filingCode = value;
    }

    /**
     * Gets the value of the motionTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getMotionTypeCode() {
        return motionTypeCode;
    }

    /**
     * Sets the value of the motionTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setMotionTypeCode(TextType value) {
        this.motionTypeCode = value;
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
