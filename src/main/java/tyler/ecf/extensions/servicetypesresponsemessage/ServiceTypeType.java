
package tyler.ecf.extensions.servicetypesresponsemessage;

import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ServiceTypeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceTypeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:ServiceTypesResponseMessage}ServiceCodeID"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:ServiceTypesResponseMessage}Description"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:ServiceTypesResponseMessage}IsEmailRequired"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:ServiceTypesResponseMessage}IsStreetAddressRequired"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
