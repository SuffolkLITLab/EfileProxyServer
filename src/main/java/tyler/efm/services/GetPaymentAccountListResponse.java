
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;


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
 *         &amp;lt;element name="PaymentAccountListResponse" type="{urn:tyler:efm:services:schema:PaymentAccountListResponse}PaymentAccountListResponseType" minOccurs="0"/&amp;gt;
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
    "paymentAccountListResponse"
})
@XmlRootElement(name = "GetPaymentAccountListResponse")
public class GetPaymentAccountListResponse {

    @XmlElement(name = "PaymentAccountListResponse")
    protected PaymentAccountListResponseType paymentAccountListResponse;

    /**
     * Gets the value of the paymentAccountListResponse property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentAccountListResponseType }
     *     
     */
    public PaymentAccountListResponseType getPaymentAccountListResponse() {
        return paymentAccountListResponse;
    }

    /**
     * Sets the value of the paymentAccountListResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentAccountListResponseType }
     *     
     */
    public void setPaymentAccountListResponse(PaymentAccountListResponseType value) {
        this.paymentAccountListResponse = value;
    }

}
