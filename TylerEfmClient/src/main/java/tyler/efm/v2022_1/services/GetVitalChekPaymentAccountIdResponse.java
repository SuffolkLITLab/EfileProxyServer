
package tyler.efm.v2022_1.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.v2022_1.services.schema.getvitalchekpaymentaccountidresponse.GetVitalChekPaymentAccountIdResponseType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetVitalChekPaymentAccountIdResponse" type="{urn:tyler:efm:services:schema:GetVitalChekPaymentAccountIdResponse}GetVitalChekPaymentAccountIdResponseType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getVitalChekPaymentAccountIdResponse"
})
@XmlRootElement(name = "GetVitalChekPaymentAccountIdResponse")
public class GetVitalChekPaymentAccountIdResponse {

    @XmlElement(name = "GetVitalChekPaymentAccountIdResponse")
    protected GetVitalChekPaymentAccountIdResponseType getVitalChekPaymentAccountIdResponse;

    /**
     * Gets the value of the getVitalChekPaymentAccountIdResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GetVitalChekPaymentAccountIdResponseType }
     *     
     */
    public GetVitalChekPaymentAccountIdResponseType getGetVitalChekPaymentAccountIdResponse() {
        return getVitalChekPaymentAccountIdResponse;
    }

    /**
     * Sets the value of the getVitalChekPaymentAccountIdResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetVitalChekPaymentAccountIdResponseType }
     *     
     */
    public void setGetVitalChekPaymentAccountIdResponse(GetVitalChekPaymentAccountIdResponseType value) {
        this.getVitalChekPaymentAccountIdResponse = value;
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
