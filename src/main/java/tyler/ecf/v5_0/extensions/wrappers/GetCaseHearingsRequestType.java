
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.casehearingrequest.GetCaseHearingsMessageType;


/**
 * <p>Java class for GetCaseHearingsRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetCaseHearingsRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:casehearingrequest}GetCaseHearingsMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetCaseHearingsRequestType", propOrder = {
    "getCaseHearingsMessage"
})
public class GetCaseHearingsRequestType {

    @XmlElement(name = "GetCaseHearingsMessage", namespace = "urn:tyler:ecf:v5.0:extensions:casehearingrequest", required = true)
    protected GetCaseHearingsMessageType getCaseHearingsMessage;

    /**
     * Gets the value of the getCaseHearingsMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetCaseHearingsMessageType }
     *     
     */
    public GetCaseHearingsMessageType getGetCaseHearingsMessage() {
        return getCaseHearingsMessage;
    }

    /**
     * Sets the value of the getCaseHearingsMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetCaseHearingsMessageType }
     *     
     */
    public void setGetCaseHearingsMessage(GetCaseHearingsMessageType value) {
        this.getCaseHearingsMessage = value;
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
