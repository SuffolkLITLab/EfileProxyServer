
package tyler.efm.latest.services.schema.paymentaccounttypelistresponse;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.latest.services.schema.baseresponse.BaseResponseType;
import tyler.efm.latest.services.schema.common.PaymentAccountTypeType;


/**
 * <p>Java class for PaymentAccountTypeListResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PaymentAccountTypeListResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:efm:services:schema:BaseResponse}BaseResponseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PaymentAccountType" type="{urn:tyler:efm:services:schema:Common}PaymentAccountTypeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentAccountTypeListResponseType", propOrder = {
    "paymentAccountType"
})
public class PaymentAccountTypeListResponseType
    extends BaseResponseType
{

    @XmlElement(name = "PaymentAccountType")
    protected List<PaymentAccountTypeType> paymentAccountType;

    /**
     * Gets the value of the paymentAccountType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the paymentAccountType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentAccountType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentAccountTypeType }
     * 
     * 
     */
    public List<PaymentAccountTypeType> getPaymentAccountType() {
        if (paymentAccountType == null) {
            paymentAccountType = new ArrayList<PaymentAccountTypeType>();
        }
        return this.paymentAccountType;
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
