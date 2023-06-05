
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.servicecallback.NotifyServiceCompleteMessageType;


/**
 * <p>Java class for NotifyServiceCompleteRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyServiceCompleteRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:servicecallback}NotifyServiceCompleteMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotifyServiceCompleteRequestType", propOrder = {
    "notifyServiceCompleteMessage"
})
public class NotifyServiceCompleteRequestType {

    @XmlElement(name = "NotifyServiceCompleteMessage", namespace = "urn:tyler:ecf:v5.0:extensions:servicecallback", required = true)
    protected NotifyServiceCompleteMessageType notifyServiceCompleteMessage;

    /**
     * Gets the value of the notifyServiceCompleteMessage property.
     * 
     * @return
     *     possible object is
     *     {@link NotifyServiceCompleteMessageType }
     *     
     */
    public NotifyServiceCompleteMessageType getNotifyServiceCompleteMessage() {
        return notifyServiceCompleteMessage;
    }

    /**
     * Sets the value of the notifyServiceCompleteMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotifyServiceCompleteMessageType }
     *     
     */
    public void setNotifyServiceCompleteMessage(NotifyServiceCompleteMessageType value) {
        this.notifyServiceCompleteMessage = value;
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
