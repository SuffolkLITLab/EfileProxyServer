
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.securecase.SecureCaseMessageType;


/**
 * <p>Java class for SecureCaseRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SecureCaseRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:securecase}SecureCaseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SecureCaseRequestType", propOrder = {
    "secureCaseMessage"
})
public class SecureCaseRequestType {

    @XmlElement(name = "SecureCaseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:securecase", required = true)
    protected SecureCaseMessageType secureCaseMessage;

    /**
     * Gets the value of the secureCaseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link SecureCaseMessageType }
     *     
     */
    public SecureCaseMessageType getSecureCaseMessage() {
        return secureCaseMessage;
    }

    /**
     * Sets the value of the secureCaseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecureCaseMessageType }
     *     
     */
    public void setSecureCaseMessage(SecureCaseMessageType value) {
        this.secureCaseMessage = value;
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
