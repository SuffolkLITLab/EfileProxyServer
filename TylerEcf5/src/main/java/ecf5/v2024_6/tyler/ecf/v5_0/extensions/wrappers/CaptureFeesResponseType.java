
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.capturefeesresponse.CaptureFeesResponseMessageType;


/**
 * <p>Java class for CaptureFeesResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaptureFeesResponseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:capturefeesresponse}CaptureFeesResponseMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaptureFeesResponseType", propOrder = {
    "captureFeesResponseMessage"
})
public class CaptureFeesResponseType {

    @XmlElement(name = "CaptureFeesResponseMessage", namespace = "urn:tyler:ecf:v5.0:extensions:capturefeesresponse", required = true)
    protected CaptureFeesResponseMessageType captureFeesResponseMessage;

    /**
     * Gets the value of the captureFeesResponseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link CaptureFeesResponseMessageType }
     *     
     */
    public CaptureFeesResponseMessageType getCaptureFeesResponseMessage() {
        return captureFeesResponseMessage;
    }

    /**
     * Sets the value of the captureFeesResponseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaptureFeesResponseMessageType }
     *     
     */
    public void setCaptureFeesResponseMessage(CaptureFeesResponseMessageType value) {
        this.captureFeesResponseMessage = value;
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
