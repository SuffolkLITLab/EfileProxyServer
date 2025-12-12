
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ActionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ContactAction"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ActionTimestamp" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FirmID" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionType", propOrder = {
    "contactAction",
    "actionTimestamp",
    "firmID"
})
public class ActionType {

    @XmlElement(name = "ContactAction", required = true)
    protected TextType contactAction;
    @XmlElement(name = "ActionTimestamp")
    protected DateType actionTimestamp;
    @XmlElement(name = "FirmID")
    protected TextType firmID;

    /**
     * Gets the value of the contactAction property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getContactAction() {
        return contactAction;
    }

    /**
     * Sets the value of the contactAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setContactAction(TextType value) {
        this.contactAction = value;
    }

    /**
     * Gets the value of the actionTimestamp property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getActionTimestamp() {
        return actionTimestamp;
    }

    /**
     * Sets the value of the actionTimestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setActionTimestamp(DateType value) {
        this.actionTimestamp = value;
    }

    /**
     * Gets the value of the firmID property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFirmID() {
        return firmID;
    }

    /**
     * Sets the value of the firmID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFirmID(TextType value) {
        this.firmID = value;
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
