
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.updatefeesresponse.UpdateFeesResponseMessageType;


/**
 * <p>Java class for UpdateFeesResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UpdateFeesResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:updatefeesresponse}UpdateFeesResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UpdateFeesResponseType", propOrder = {
    "updateFeesResponseMessage"
})
public class UpdateFeesResponseType {

    @XmlElement(name = "UpdateFeesResponseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:updatefeesresponse", required = true)
    protected UpdateFeesResponseMessageType updateFeesResponseMessage;

    /**
     * Gets the value of the updateFeesResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link UpdateFeesResponseMessageType }
     *     
     */
    public UpdateFeesResponseMessageType getUpdateFeesResponseMessage() {
        return updateFeesResponseMessage;
    }

    /**
     * Sets the value of the updateFeesResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdateFeesResponseMessageType }
     *     
     */
    public void setUpdateFeesResponseMessage(UpdateFeesResponseMessageType value) {
        this.updateFeesResponseMessage = value;
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
