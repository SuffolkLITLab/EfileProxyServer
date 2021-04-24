
package tyler.ecf.extensions.servicetypesresponsemessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * &lt;p&gt;Java class for ServiceTypeType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ServiceTypeType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:ServiceTypesResponseMessage}ServiceCodeID"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:ServiceTypesResponseMessage}Description"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:ServiceTypesResponseMessage}IsEmailRequired"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:ServiceTypesResponseMessage}IsStreetAddressRequired"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceTypeType", propOrder = {
    "serviceCodeID",
    "description",
    "isEmailRequired",
    "isStreetAddressRequired"
})
public class ServiceTypeType {

    @XmlElement(name = "ServiceCodeID", required = true)
    protected TextType serviceCodeID;
    @XmlElement(name = "Description", required = true)
    protected TextType description;
    @XmlElement(name = "IsEmailRequired", required = true)
    protected Boolean isEmailRequired;
    @XmlElement(name = "IsStreetAddressRequired", required = true)
    protected Boolean isStreetAddressRequired;

    /**
     * Gets the value of the serviceCodeID property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getServiceCodeID() {
        return serviceCodeID;
    }

    /**
     * Sets the value of the serviceCodeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setServiceCodeID(TextType value) {
        this.serviceCodeID = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDescription(TextType value) {
        this.description = value;
    }

    /**
     * Gets the value of the isEmailRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsEmailRequired() {
        return isEmailRequired;
    }

    /**
     * Sets the value of the isEmailRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsEmailRequired(Boolean value) {
        this.isEmailRequired = value;
    }

    /**
     * Gets the value of the isStreetAddressRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsStreetAddressRequired() {
        return isStreetAddressRequired;
    }

    /**
     * Sets the value of the isStreetAddressRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsStreetAddressRequired(Boolean value) {
        this.isStreetAddressRequired = value;
    }

}
