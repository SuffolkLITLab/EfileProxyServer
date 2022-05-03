
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetGlobalPaymentAccountResponse" type="{urn:tyler:efm:services:schema:GetPaymentAccountResponse}GetPaymentAccountResponseType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getGlobalPaymentAccountResponse"
})
@XmlRootElement(name = "GetGlobalPaymentAccountResponse")
public class GetGlobalPaymentAccountResponse {

    @XmlElement(name = "GetGlobalPaymentAccountResponse")
    protected GetPaymentAccountResponseType getGlobalPaymentAccountResponse;

    /**
     * Gets the value of the getGlobalPaymentAccountResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetPaymentAccountResponseType }
     *     
     */
    public GetPaymentAccountResponseType getGetGlobalPaymentAccountResponse() {
        return getGlobalPaymentAccountResponse;
    }

    /**
     * Sets the value of the getGlobalPaymentAccountResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPaymentAccountResponseType }
     *     
     */
    public void setGetGlobalPaymentAccountResponse(GetPaymentAccountResponseType value) {
        this.getGlobalPaymentAccountResponse = value;
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
