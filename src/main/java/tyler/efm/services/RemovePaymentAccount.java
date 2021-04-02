
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType;


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
 *         &amp;lt;element name="RemovePaymentAccountRequest" type="{urn:tyler:efm:services:schema:RemovePaymentAccountRequest}RemovePaymentAccountRequestType" minOccurs="0"/&amp;gt;
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
    "removePaymentAccountRequest"
})
@XmlRootElement(name = "RemovePaymentAccount")
public class RemovePaymentAccount {

    @XmlElement(name = "RemovePaymentAccountRequest")
    protected RemovePaymentAccountRequestType removePaymentAccountRequest;

    /**
     * Gets the value of the removePaymentAccountRequest property.
     * 
     * @return
     *     possible object is
     *     {@link RemovePaymentAccountRequestType }
     *     
     */
    public RemovePaymentAccountRequestType getRemovePaymentAccountRequest() {
        return removePaymentAccountRequest;
    }

    /**
     * Sets the value of the removePaymentAccountRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemovePaymentAccountRequestType }
     *     
     */
    public void setRemovePaymentAccountRequest(RemovePaymentAccountRequestType value) {
        this.removePaymentAccountRequest = value;
    }

}
