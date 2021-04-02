
package tyler.efm.services.schema.getpaymentaccountrequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.baserequest.BaseRequestType;


/**
 * &lt;p&gt;Java class for GetPaymentAccountRequestType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="GetPaymentAccountRequestType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:tyler:efm:services:schema:BaseRequest}BaseRequestType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="PaymentAccountID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetPaymentAccountRequestType", propOrder = {
    "paymentAccountID"
})
public class GetPaymentAccountRequestType
    extends BaseRequestType
{

    @XmlElement(name = "PaymentAccountID")
    protected String paymentAccountID;

    /**
     * Gets the value of the paymentAccountID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentAccountID() {
        return paymentAccountID;
    }

    /**
     * Sets the value of the paymentAccountID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentAccountID(String value) {
        this.paymentAccountID = value;
    }

}
