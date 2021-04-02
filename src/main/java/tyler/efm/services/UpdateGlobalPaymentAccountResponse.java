
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.updatepaymentaccountresponse.UpdatePaymentAccountResponseType;


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
 *         &amp;lt;element name="UpdateGlobalPaymentAccountResponse" type="{urn:tyler:efm:services:schema:UpdatePaymentAccountResponse}UpdatePaymentAccountResponseType" minOccurs="0"/&amp;gt;
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
    "updateGlobalPaymentAccountResponse"
})
@XmlRootElement(name = "UpdateGlobalPaymentAccountResponse")
public class UpdateGlobalPaymentAccountResponse {

    @XmlElement(name = "UpdateGlobalPaymentAccountResponse")
    protected UpdatePaymentAccountResponseType updateGlobalPaymentAccountResponse;

    /**
     * Gets the value of the updateGlobalPaymentAccountResponse property.
     * 
     * @return
     *     possible object is
     *     {@link UpdatePaymentAccountResponseType }
     *     
     */
    public UpdatePaymentAccountResponseType getUpdateGlobalPaymentAccountResponse() {
        return updateGlobalPaymentAccountResponse;
    }

    /**
     * Sets the value of the updateGlobalPaymentAccountResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpdatePaymentAccountResponseType }
     *     
     */
    public void setUpdateGlobalPaymentAccountResponse(UpdatePaymentAccountResponseType value) {
        this.updateGlobalPaymentAccountResponse = value;
    }

}
