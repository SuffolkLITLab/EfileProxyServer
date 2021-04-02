
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType;


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
 *         &amp;lt;element name="UpdateGlobalPaymentAccountRequest" type="{urn:tyler:efm:services:schema:UpdatePaymentAccountRequest}UpdatePaymentAccountRequestType" minOccurs="0"/&amp;gt;
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
    "updateGlobalPaymentAccountRequest"
})
@XmlRootElement(name = "UpdateGlobalPaymentAccount")
public class UpdateGlobalPaymentAccount {

    @XmlElement(name = "UpdateGlobalPaymentAccountRequest")
    protected UpdatePaymentAccountRequestType updateGlobalPaymentAccountRequest;

    /**
     * Gets the value of the updateGlobalPaymentAccountRequest property.
     * 
     * @return
     *     possible object is
     *     {@link UpdatePaymentAccountRequestType }
     *     
     */
    public UpdatePaymentAccountRequestType getUpdateGlobalPaymentAccountRequest() {
        return updateGlobalPaymentAccountRequest;
    }

    /**
     * Sets the value of the updateGlobalPaymentAccountRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdatePaymentAccountRequestType }
     *     
     */
    public void setUpdateGlobalPaymentAccountRequest(UpdatePaymentAccountRequestType value) {
        this.updateGlobalPaymentAccountRequest = value;
    }

}
