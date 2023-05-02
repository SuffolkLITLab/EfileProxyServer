
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.GetPolicyResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetPolicyResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPolicyResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}GetPolicyResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPolicyResponseType", propOrder = {
    "getPolicyResponseMessage"
})
public class GetPolicyResponseType {

    @XmlElement(name = "GetPolicyResponseMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse", required = true)
    protected GetPolicyResponseMessageType getPolicyResponseMessage;

    /**
     * Gets the value of the getPolicyResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetPolicyResponseMessageType }
     *     
     */
    public GetPolicyResponseMessageType getGetPolicyResponseMessage() {
        return getPolicyResponseMessage;
    }

    /**
     * Sets the value of the getPolicyResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPolicyResponseMessageType }
     *     
     */
    public void setGetPolicyResponseMessage(GetPolicyResponseMessageType value) {
        this.getPolicyResponseMessage = value;
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
