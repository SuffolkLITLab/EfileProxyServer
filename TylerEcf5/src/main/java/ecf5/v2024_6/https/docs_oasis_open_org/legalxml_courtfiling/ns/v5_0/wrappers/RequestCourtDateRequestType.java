
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers;

import ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdaterequest.RequestCourtDateRequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RequestCourtDateRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestCourtDateRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdaterequest}RequestCourtDateRequestMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestCourtDateRequestType", propOrder = {
    "requestCourtDateRequestMessage"
})
public class RequestCourtDateRequestType {

    @XmlElement(name = "RequestCourtDateRequestMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdaterequest", required = true)
    protected RequestCourtDateRequestMessageType requestCourtDateRequestMessage;

    /**
     * Gets the value of the requestCourtDateRequestMessage property.
     * 
     * @return
     *     possible object is
     *     {@link RequestCourtDateRequestMessageType }
     *     
     */
    public RequestCourtDateRequestMessageType getRequestCourtDateRequestMessage() {
        return requestCourtDateRequestMessage;
    }

    /**
     * Sets the value of the requestCourtDateRequestMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestCourtDateRequestMessageType }
     *     
     */
    public void setRequestCourtDateRequestMessage(RequestCourtDateRequestMessageType value) {
        this.requestCourtDateRequestMessage = value;
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
