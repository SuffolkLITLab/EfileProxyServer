
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
 *         &amp;lt;element name="CreateGlobalPaymentAccount" type="{urn:tyler:efm:services:schema:CreatePaymentAccountResponse}CreatePaymentAccountResponseType" minOccurs="0"/&amp;gt;
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
    "createGlobalPaymentAccount"
})
@XmlRootElement(name = "CreateGlobalPaymentAccountResponse")
public class CreateGlobalPaymentAccountResponse {

    @XmlElement(name = "CreateGlobalPaymentAccount")
    protected CreatePaymentAccountResponseType createGlobalPaymentAccount;

    /**
     * Gets the value of the createGlobalPaymentAccount property.
     * 
     * @return
     *     possible object is
     *     {@link CreatePaymentAccountResponseType }
     *     
     */
    public CreatePaymentAccountResponseType getCreateGlobalPaymentAccount() {
        return createGlobalPaymentAccount;
    }

    /**
     * Sets the value of the createGlobalPaymentAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreatePaymentAccountResponseType }
     *     
     */
    public void setCreateGlobalPaymentAccount(CreatePaymentAccountResponseType value) {
        this.createGlobalPaymentAccount = value;
    }

}
