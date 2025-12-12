
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.updatefeesrequest.UpdateFeesMessageType;


/**
 * <p>Java class for UpdateFeesRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFeesRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:updatefeesrequest}UpdateFeesMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateFeesRequestType", propOrder = {
    "updateFeesMessage"
})
public class UpdateFeesRequestType {

    @XmlElement(name = "UpdateFeesMessage", namespace = "urn:tyler:ecf:v5.0:extensions:updatefeesrequest", required = true)
    protected UpdateFeesMessageType updateFeesMessage;

    /**
     * Gets the value of the updateFeesMessage property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateFeesMessageType }
     *     
     */
    public UpdateFeesMessageType getUpdateFeesMessage() {
        return updateFeesMessage;
    }

    /**
     * Sets the value of the updateFeesMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateFeesMessageType }
     *     
     */
    public void setUpdateFeesMessage(UpdateFeesMessageType value) {
        this.updateFeesMessage = value;
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
