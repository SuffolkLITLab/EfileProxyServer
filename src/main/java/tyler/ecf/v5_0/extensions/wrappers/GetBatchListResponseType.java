
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.batchlistresponse.GetBatchListResponseMessageType;


/**
 * <p>Java class for GetBatchListResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBatchListResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchlistresponse}GetBatchListResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBatchListResponseType", propOrder = {
    "getBatchListResponseMessage"
})
public class GetBatchListResponseType {

    @XmlElement(name = "GetBatchListResponseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:batchlistresponse", required = true)
    protected GetBatchListResponseMessageType getBatchListResponseMessage;

    /**
     * Gets the value of the getBatchListResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetBatchListResponseMessageType }
     *     
     */
    public GetBatchListResponseMessageType getGetBatchListResponseMessage() {
        return getBatchListResponseMessage;
    }

    /**
     * Sets the value of the getBatchListResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetBatchListResponseMessageType }
     *     
     */
    public void setGetBatchListResponseMessage(GetBatchListResponseMessageType value) {
        this.getBatchListResponseMessage = value;
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
