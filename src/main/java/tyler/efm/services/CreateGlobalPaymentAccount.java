
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;


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
 *         &amp;lt;element name="CreateGlobalPaymentAccountRequest" type="{urn:tyler:efm:services:schema:CreatePaymentAccountRequest}CreatePaymentAccountRequestType" minOccurs="0"/&amp;gt;
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
    "createGlobalPaymentAccountRequest"
})
@XmlRootElement(name = "CreateGlobalPaymentAccount")
public class CreateGlobalPaymentAccount {

    @XmlElement(name = "CreateGlobalPaymentAccountRequest")
    protected CreatePaymentAccountRequestType createGlobalPaymentAccountRequest;

    /**
     * Gets the value of the createGlobalPaymentAccountRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CreatePaymentAccountRequestType }
     *     
     */
    public CreatePaymentAccountRequestType getCreateGlobalPaymentAccountRequest() {
        return createGlobalPaymentAccountRequest;
    }

    /**
     * Sets the value of the createGlobalPaymentAccountRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreatePaymentAccountRequestType }
     *     
     */
    public void setCreateGlobalPaymentAccountRequest(CreatePaymentAccountRequestType value) {
        this.createGlobalPaymentAccountRequest = value;
    }

}
