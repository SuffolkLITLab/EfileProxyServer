
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchdetailresponse.GetBatchDetailResponseMessageType;


/**
 * <p>Java class for GetBatchDetailResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBatchDetailResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchdetailresponse}GetBatchDetailResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBatchDetailResponseType", propOrder = {
    "getBatchDetailResponseMessage"
})
public class GetBatchDetailResponseType {

    @XmlElement(name = "GetBatchDetailResponseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:batchdetailresponse", required = true)
    protected GetBatchDetailResponseMessageType getBatchDetailResponseMessage;

    /**
     * Gets the value of the getBatchDetailResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetBatchDetailResponseMessageType }
     *     
     */
    public GetBatchDetailResponseMessageType getGetBatchDetailResponseMessage() {
        return getBatchDetailResponseMessage;
    }

    /**
     * Sets the value of the getBatchDetailResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetBatchDetailResponseMessageType }
     *     
     */
    public void setGetBatchDetailResponseMessage(GetBatchDetailResponseMessageType value) {
        this.getBatchDetailResponseMessage = value;
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
