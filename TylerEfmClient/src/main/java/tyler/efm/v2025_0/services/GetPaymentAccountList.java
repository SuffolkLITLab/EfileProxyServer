
package tyler.efm.v2025_0.services;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import tyler.efm.v2025_0.services.schema.getpaymentaccountlistrequest.GetPaymentAccountListRequestType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


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
 *         &lt;element name="GetPaymentAccountListRequest" type="{urn:tyler:efm:services:schema:GetPaymentAccountListRequest}GetPaymentAccountListRequestType" minOccurs="0"/&gt;
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
    "getPaymentAccountListRequest"
})
@XmlRootElement(name = "GetPaymentAccountList")
public class GetPaymentAccountList {

    @XmlElement(name = "GetPaymentAccountListRequest")
    protected GetPaymentAccountListRequestType getPaymentAccountListRequest;

    /**
     * Gets the value of the getPaymentAccountListRequest property.
     * 
     * @return
     *     possible object is
     *     {@link GetPaymentAccountListRequestType }
     *     
     */
    public GetPaymentAccountListRequestType getGetPaymentAccountListRequest() {
        return getPaymentAccountListRequest;
    }

    /**
     * Sets the value of the getPaymentAccountListRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetPaymentAccountListRequestType }
     *     
     */
    public void setGetPaymentAccountListRequest(GetPaymentAccountListRequestType value) {
        this.getPaymentAccountListRequest = value;
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
