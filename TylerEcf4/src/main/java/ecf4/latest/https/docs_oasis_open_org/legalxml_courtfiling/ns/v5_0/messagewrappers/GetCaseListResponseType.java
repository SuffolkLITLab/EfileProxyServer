
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers;

import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistresponse.GetCaseListResponseMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetCaseListResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCaseListResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistresponse}GetCaseListResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCaseListResponseType", propOrder = {
    "getCaseListResponseMessage"
})
public class GetCaseListResponseType {

    @XmlElement(name = "GetCaseListResponseMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/caselistresponse", required = true)
    protected GetCaseListResponseMessageType getCaseListResponseMessage;

    /**
     * Gets the value of the getCaseListResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetCaseListResponseMessageType }
     *     
     */
    public GetCaseListResponseMessageType getGetCaseListResponseMessage() {
        return getCaseListResponseMessage;
    }

    /**
     * Sets the value of the getCaseListResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCaseListResponseMessageType }
     *     
     */
    public void setGetCaseListResponseMessage(GetCaseListResponseMessageType value) {
        this.getCaseListResponseMessage = value;
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
