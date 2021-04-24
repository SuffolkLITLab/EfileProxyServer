
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;


/**
 * &lt;p&gt;Java class for RecipientInformationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RecipientInformationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}RecipientName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}RecipientFirmName" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecipientInformationType", propOrder = {
    "recipientName",
    "recipientFirmName"
})
public class RecipientInformationType {

    @XmlElement(name = "RecipientName")
    protected TextType recipientName;
    @XmlElement(name = "RecipientFirmName")
    protected TextType recipientFirmName;

    /**
     * Gets the value of the recipientName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRecipientName() {
        return recipientName;
    }

    /**
     * Sets the value of the recipientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRecipientName(TextType value) {
        this.recipientName = value;
    }

    /**
     * Gets the value of the recipientFirmName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRecipientFirmName() {
        return recipientFirmName;
    }

    /**
     * Sets the value of the recipientFirmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRecipientFirmName(TextType value) {
        this.recipientFirmName = value;
    }

}
