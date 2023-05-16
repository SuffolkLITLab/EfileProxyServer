
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.casehearingresponse.GetCaseHearingsResponseMessageType;


/**
 * <p>Java class for GetCaseHearingsResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCaseHearingsResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:casehearingresponse}GetCaseHearingsResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCaseHearingsResponseType", propOrder = {
    "getCaseHearingsResponseMessage"
})
public class GetCaseHearingsResponseType {

    @XmlElement(name = "GetCaseHearingsResponseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:casehearingresponse", required = true)
    protected GetCaseHearingsResponseMessageType getCaseHearingsResponseMessage;

    /**
     * Gets the value of the getCaseHearingsResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetCaseHearingsResponseMessageType }
     *     
     */
    public GetCaseHearingsResponseMessageType getGetCaseHearingsResponseMessage() {
        return getCaseHearingsResponseMessage;
    }

    /**
     * Sets the value of the getCaseHearingsResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCaseHearingsResponseMessageType }
     *     
     */
    public void setGetCaseHearingsResponseMessage(GetCaseHearingsResponseMessageType value) {
        this.getCaseHearingsResponseMessage = value;
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
