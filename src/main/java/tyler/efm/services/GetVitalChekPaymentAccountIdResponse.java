
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.getvitalchekpaymentaccountidresponse.GetVitalChekPaymentAccountIdResponseType;


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
 *         &amp;lt;element name="GetVitalChekPaymentAccountIdResponse" type="{urn:tyler:efm:services:schema:GetVitalChekPaymentAccountIdResponse}GetVitalChekPaymentAccountIdResponseType" minOccurs="0"/&amp;gt;
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
    "getVitalChekPaymentAccountIdResponse"
})
@XmlRootElement(name = "GetVitalChekPaymentAccountIdResponse")
public class GetVitalChekPaymentAccountIdResponse {

    @XmlElement(name = "GetVitalChekPaymentAccountIdResponse")
    protected GetVitalChekPaymentAccountIdResponseType getVitalChekPaymentAccountIdResponse;

    /**
     * Gets the value of the getVitalChekPaymentAccountIdResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetVitalChekPaymentAccountIdResponseType }
     *     
     */
    public GetVitalChekPaymentAccountIdResponseType getGetVitalChekPaymentAccountIdResponse() {
        return getVitalChekPaymentAccountIdResponse;
    }

    /**
     * Sets the value of the getVitalChekPaymentAccountIdResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetVitalChekPaymentAccountIdResponseType }
     *     
     */
    public void setGetVitalChekPaymentAccountIdResponse(GetVitalChekPaymentAccountIdResponseType value) {
        this.getVitalChekPaymentAccountIdResponse = value;
    }

}
