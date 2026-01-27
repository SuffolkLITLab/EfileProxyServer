
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest.GetCaseRequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetCaseRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCaseRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest}GetCaseRequestMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCaseRequestType", propOrder = {
    "getCaseRequestMessage"
})
public class GetCaseRequestType {

    @XmlElement(name = "GetCaseRequestMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caserequest", required = true)
    protected GetCaseRequestMessageType getCaseRequestMessage;

    /**
     * Gets the value of the getCaseRequestMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetCaseRequestMessageType }
     *     
     */
    public GetCaseRequestMessageType getGetCaseRequestMessage() {
        return getCaseRequestMessage;
    }

    /**
     * Sets the value of the getCaseRequestMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCaseRequestMessageType }
     *     
     */
    public void setGetCaseRequestMessage(GetCaseRequestMessageType value) {
        this.getCaseRequestMessage = value;
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
