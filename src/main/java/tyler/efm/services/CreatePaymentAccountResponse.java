
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType;


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
 *         &amp;lt;element name="CreatePaymentAccountResponse" type="{urn:tyler:efm:services:schema:CreatePaymentAccountResponse}CreatePaymentAccountResponseType" minOccurs="0"/&amp;gt;
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
    "createPaymentAccountResponse"
})
@XmlRootElement(name = "CreatePaymentAccountResponse")
public class CreatePaymentAccountResponse {

    @XmlElement(name = "CreatePaymentAccountResponse")
    protected CreatePaymentAccountResponseType createPaymentAccountResponse;

    /**
     * Gets the value of the createPaymentAccountResponse property.
     * 
     * @return
     *     possible object is
     *     {@link CreatePaymentAccountResponseType }
     *     
     */
    public CreatePaymentAccountResponseType getCreatePaymentAccountResponse() {
        return createPaymentAccountResponse;
    }

    /**
     * Sets the value of the createPaymentAccountResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreatePaymentAccountResponseType }
     *     
     */
    public void setCreatePaymentAccountResponse(CreatePaymentAccountResponseType value) {
        this.createPaymentAccountResponse = value;
    }

}
