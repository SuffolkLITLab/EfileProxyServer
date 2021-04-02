
package tyler.efm.services.schema.getvitalchekpaymentaccountidresponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.baseresponse.BaseResponseType;


/**
 * &lt;p&gt;Java class for GetVitalChekPaymentAccountIdResponseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="GetVitalChekPaymentAccountIdResponseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="PaymentAccountId" type="{http://www.w3.org/2001/XMLSchema}int"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetVitalChekPaymentAccountIdResponseType", propOrder = {
    "paymentAccountId"
})
public class GetVitalChekPaymentAccountIdResponseType
    extends BaseResponseType
{

    @XmlElement(name = "PaymentAccountId")
    protected int paymentAccountId;

    /**
     * Gets the value of the paymentAccountId property.
     * 
     */
    public int getPaymentAccountId() {
        return paymentAccountId;
    }

    /**
     * Sets the value of the paymentAccountId property.
     * 
     */
    public void setPaymentAccountId(int value) {
        this.paymentAccountId = value;
    }

}
