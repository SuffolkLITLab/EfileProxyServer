
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdateresponse.RequestCourtDateResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for RequestCourtDateResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestCourtDateResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdateresponse}RequestCourtDateResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestCourtDateResponseType", propOrder = {
    "requestCourtDateResponseMessage"
})
public class RequestCourtDateResponseType {

    @XmlElement(name = "RequestCourtDateResponseMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/requestdateresponse", required = true)
    protected RequestCourtDateResponseMessageType requestCourtDateResponseMessage;

    /**
     * Gets the value of the requestCourtDateResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link RequestCourtDateResponseMessageType }
     *     
     */
    public RequestCourtDateResponseMessageType getRequestCourtDateResponseMessage() {
        return requestCourtDateResponseMessage;
    }

    /**
     * Sets the value of the requestCourtDateResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestCourtDateResponseMessageType }
     *     
     */
    public void setRequestCourtDateResponseMessage(RequestCourtDateResponseMessageType value) {
        this.requestCourtDateResponseMessage = value;
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
