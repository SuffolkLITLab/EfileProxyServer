
package ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caseresponse.GetCaseResponseMessageType;


/**
 * <p>Java class for GetCaseResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCaseResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caseresponse}GetCaseResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCaseResponseType", propOrder = {
    "getCaseResponseMessage"
})
public class GetCaseResponseType {

    @XmlElement(name = "GetCaseResponseMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caseresponse", required = true)
    protected GetCaseResponseMessageType getCaseResponseMessage;

    /**
     * Gets the value of the getCaseResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetCaseResponseMessageType }
     *     
     */
    public GetCaseResponseMessageType getGetCaseResponseMessage() {
        return getCaseResponseMessage;
    }

    /**
     * Sets the value of the getCaseResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCaseResponseMessageType }
     *     
     */
    public void setGetCaseResponseMessage(GetCaseResponseMessageType value) {
        this.getCaseResponseMessage = value;
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
