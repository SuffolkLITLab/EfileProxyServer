
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="GetPaymentAccountResponse" type="{urn:tyler:efm:services:schema:GetPaymentAccountResponse}GetPaymentAccountResponseType" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getPaymentAccountResponse"
})
@XmlRootElement(name = "GetPaymentAccountResponse")
public class GetPaymentAccountResponse {

    @XmlElement(name = "GetPaymentAccountResponse")
    protected GetPaymentAccountResponseType getPaymentAccountResponse;

    /**
     * Gets the value of the getPaymentAccountResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetPaymentAccountResponseType }
     *     
     */
    public GetPaymentAccountResponseType getGetPaymentAccountResponse() {
        return getPaymentAccountResponse;
    }

    /**
     * Sets the value of the getPaymentAccountResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPaymentAccountResponseType }
     *     
     */
    public void setGetPaymentAccountResponse(GetPaymentAccountResponseType value) {
        this.getPaymentAccountResponse = value;
    }

}
