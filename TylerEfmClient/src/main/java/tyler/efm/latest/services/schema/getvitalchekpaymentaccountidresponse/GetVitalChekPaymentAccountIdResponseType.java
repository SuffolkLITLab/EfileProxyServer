
package tyler.efm.latest.services.schema.getvitalchekpaymentaccountidresponse;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.latest.services.schema.baseresponse.BaseResponseType;


/**
 * <p>Java class for GetVitalChekPaymentAccountIdResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetVitalChekPaymentAccountIdResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentAccountId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
