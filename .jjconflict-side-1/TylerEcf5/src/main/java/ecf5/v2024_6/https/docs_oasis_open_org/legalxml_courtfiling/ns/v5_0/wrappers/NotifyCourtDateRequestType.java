
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers;

import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.datecallback.NotifyCourtDateMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for NotifyCourtDateRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyCourtDateRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/datecallback}NotifyCourtDateMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotifyCourtDateRequestType", propOrder = {
    "notifyCourtDateMessage"
})
public class NotifyCourtDateRequestType {

    @XmlElement(name = "NotifyCourtDateMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/datecallback", required = true)
    protected NotifyCourtDateMessageType notifyCourtDateMessage;

    /**
     * Gets the value of the notifyCourtDateMessage property.
     * 
     * @return
     *     possible object is
     *     {@link NotifyCourtDateMessageType }
     *     
     */
    public NotifyCourtDateMessageType getNotifyCourtDateMessage() {
        return notifyCourtDateMessage;
    }

    /**
     * Sets the value of the notifyCourtDateMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotifyCourtDateMessageType }
     *     
     */
    public void setNotifyCourtDateMessage(NotifyCourtDateMessageType value) {
        this.notifyCourtDateMessage = value;
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
