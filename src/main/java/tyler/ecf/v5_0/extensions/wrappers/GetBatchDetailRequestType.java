
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.batchdetailrequest.GetBatchDetailMessageType;


/**
 * <p>Java class for GetBatchDetailRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetBatchDetailRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:batchdetailrequest}GetBatchDetailMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBatchDetailRequestType", propOrder = {
    "getBatchDetailMessage"
})
public class GetBatchDetailRequestType {

    @XmlElement(name = "GetBatchDetailMessage", namespace = "urn:tyler:ecf:v5.0:extensions:batchdetailrequest", required = true)
    protected GetBatchDetailMessageType getBatchDetailMessage;

    /**
     * Gets the value of the getBatchDetailMessage property.
     * 
     * @return
     *     possible object is
     *     {@link GetBatchDetailMessageType }
     *     
     */
    public GetBatchDetailMessageType getGetBatchDetailMessage() {
        return getBatchDetailMessage;
    }

    /**
     * Sets the value of the getBatchDetailMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetBatchDetailMessageType }
     *     
     */
    public void setGetBatchDetailMessage(GetBatchDetailMessageType value) {
        this.getBatchDetailMessage = value;
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
