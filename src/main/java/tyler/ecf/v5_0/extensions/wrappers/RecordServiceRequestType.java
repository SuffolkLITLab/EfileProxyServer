
package tyler.ecf.v5_0.extensions.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.v5_0.extensions.recordservice.RecordServiceMessageType;


/**
 * <p>Java class for RecordServiceRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordServiceRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:recordservice}RecordServiceMessage"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordServiceRequestType", propOrder = {
    "recordServiceMessage"
})
public class RecordServiceRequestType {

    @XmlElement(name = "RecordServiceMessage", namespace = "urn:tyler:ecf:v5.0:extensions:recordservice", required = true)
    protected RecordServiceMessageType recordServiceMessage;

    /**
     * Gets the value of the recordServiceMessage property.
     * 
     * @return
     *     possible object is
     *     {@link RecordServiceMessageType }
     *     
     */
    public RecordServiceMessageType getRecordServiceMessage() {
        return recordServiceMessage;
    }

    /**
     * Sets the value of the recordServiceMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordServiceMessageType }
     *     
     */
    public void setRecordServiceMessage(RecordServiceMessageType value) {
        this.recordServiceMessage = value;
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
