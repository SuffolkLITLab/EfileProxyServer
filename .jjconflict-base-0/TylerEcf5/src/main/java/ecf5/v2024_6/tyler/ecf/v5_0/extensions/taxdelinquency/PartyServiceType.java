
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.taxdelinquency;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.common.ReferenceType;


/**
 * <p>Java class for PartyServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartyServiceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PartyReference"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:taxdelinquency}ServiceTypeCode"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:taxdelinquency}DeliveryMethodCode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyServiceType", propOrder = {
    "partyReference",
    "serviceTypeCode",
    "deliveryMethodCode"
})
public class PartyServiceType {

    @XmlElement(name = "PartyReference", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected ReferenceType partyReference;
    @XmlElement(name = "ServiceTypeCode", required = true)
    protected TextType serviceTypeCode;
    @XmlElement(name = "DeliveryMethodCode", required = true)
    protected TextType deliveryMethodCode;

    /**
     * Gets the value of the partyReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getPartyReference() {
        return partyReference;
    }

    /**
     * Sets the value of the partyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setPartyReference(ReferenceType value) {
        this.partyReference = value;
    }

    /**
     * Gets the value of the serviceTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getServiceTypeCode() {
        return serviceTypeCode;
    }

    /**
     * Sets the value of the serviceTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setServiceTypeCode(TextType value) {
        this.serviceTypeCode = value;
    }

    /**
     * Gets the value of the deliveryMethodCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDeliveryMethodCode() {
        return deliveryMethodCode;
    }

    /**
     * Sets the value of the deliveryMethodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDeliveryMethodCode(TextType value) {
        this.deliveryMethodCode = value;
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
