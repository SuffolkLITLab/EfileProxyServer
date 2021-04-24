
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;


/**
 * &lt;p&gt;Java class for CourtEventType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CourtEventType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}FilingCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}MotionTypeCode" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourtEventType", propOrder = {
    "filingCode",
    "motionTypeCode"
})
public class CourtEventType {

    @XmlElement(name = "FilingCode")
    protected TextType filingCode;
    @XmlElement(name = "MotionTypeCode")
    protected TextType motionTypeCode;

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

}
