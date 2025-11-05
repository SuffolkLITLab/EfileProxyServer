
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.eventcallback.NotifyEventMessageType;


/**
 * <p>Java class for NotifyEventRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyEventRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:eventcallback}NotifyEventMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotifyEventRequestType", propOrder = {
    "notifyEventMessage"
})
public class NotifyEventRequestType {

    @XmlElement(name = "NotifyEventMessage", namespace = "urn:tyler:ecf:v5.0:extensions:eventcallback", required = true)
    protected NotifyEventMessageType notifyEventMessage;

    /**
     * Gets the value of the notifyEventMessage property.
     * 
     * @return
     *     possible object is
     *     {@link NotifyEventMessageType }
     *     
     */
    public NotifyEventMessageType getNotifyEventMessage() {
        return notifyEventMessage;
    }

    /**
     * Sets the value of the notifyEventMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotifyEventMessageType }
     *     
     */
    public void setNotifyEventMessage(NotifyEventMessageType value) {
        this.notifyEventMessage = value;
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
