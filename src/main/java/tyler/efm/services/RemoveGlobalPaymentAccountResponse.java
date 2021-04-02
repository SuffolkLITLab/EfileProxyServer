
package tyler.efm.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.baseresponse.BaseResponseType;


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
 *         &amp;lt;element name="RemoveGlobalPaymentAccountResponse" type="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType" minOccurs="0"/&amp;gt;
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
    "removeGlobalPaymentAccountResponse"
})
@XmlRootElement(name = "RemoveGlobalPaymentAccountResponse")
public class RemoveGlobalPaymentAccountResponse {

    @XmlElement(name = "RemoveGlobalPaymentAccountResponse")
    protected BaseResponseType removeGlobalPaymentAccountResponse;

    /**
     * Gets the value of the removeGlobalPaymentAccountResponse property.
     * 
     * @return
     *     possible object is
     *     {@link BaseResponseType }
     *     
     */
    public BaseResponseType getRemoveGlobalPaymentAccountResponse() {
        return removeGlobalPaymentAccountResponse;
    }

    /**
     * Sets the value of the removeGlobalPaymentAccountResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link BaseResponseType }
     *     
     */
    public void setRemoveGlobalPaymentAccountResponse(BaseResponseType value) {
        this.removeGlobalPaymentAccountResponse = value;
    }

}
