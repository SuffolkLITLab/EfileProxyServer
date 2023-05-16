
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.capturefeesrequest.CaptureFeesMessageType;


/**
 * <p>Java class for CaptureFeesRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaptureFeesRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:capturefeesrequest}CaptureFeesMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaptureFeesRequestType", propOrder = {
    "captureFeesMessage"
})
public class CaptureFeesRequestType {

    @XmlElement(name = "CaptureFeesMessage", namespace = "urn:tyler:ecf:v5.0:extensions:capturefeesrequest", required = true)
    protected CaptureFeesMessageType captureFeesMessage;

    /**
     * Gets the value of the captureFeesMessage property.
     * 
     * @return
     *     possible object is
     *     {@link CaptureFeesMessageType }
     *     
     */
    public CaptureFeesMessageType getCaptureFeesMessage() {
        return captureFeesMessage;
    }

    /**
     * Sets the value of the captureFeesMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaptureFeesMessageType }
     *     
     */
    public void setCaptureFeesMessage(CaptureFeesMessageType value) {
        this.captureFeesMessage = value;
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
