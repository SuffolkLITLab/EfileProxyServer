
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.partylistresponse.GetPartyListResponseMessageType;


/**
 * <p>Java class for GetPartyListResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPartyListResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:partylistresponse}GetPartyListResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPartyListResponseType", propOrder = {
    "getPartyListResponseMessage"
})
public class GetPartyListResponseType {

    @XmlElement(name = "GetPartyListResponseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:partylistresponse", required = true)
    protected GetPartyListResponseMessageType getPartyListResponseMessage;

    /**
     * Gets the value of the getPartyListResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetPartyListResponseMessageType }
     *     
     */
    public GetPartyListResponseMessageType getGetPartyListResponseMessage() {
        return getPartyListResponseMessage;
    }

    /**
     * Sets the value of the getPartyListResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPartyListResponseMessageType }
     *     
     */
    public void setGetPartyListResponseMessage(GetPartyListResponseMessageType value) {
        this.getPartyListResponseMessage = value;
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
