
package tyler.ecf.extensions.eventcallbackmessage;

import gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for EventVariableType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EventVariableType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:EventCallbackMessage}EventKey"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:EventCallbackMessage}EventValue"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventVariableType", propOrder = {
    "eventKey",
    "eventValue"
})
public class EventVariableType {

    @XmlElement(name = "EventKey", required = true)
    protected TextType eventKey;
    @XmlElement(name = "EventValue", required = true)
    protected TextType eventValue;

    /**
     * Gets the value of the eventKey property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getEventKey() {
        return eventKey;
    }

    /**
     * Sets the value of the eventKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setEventKey(TextType value) {
        this.eventKey = value;
    }

    /**
     * Gets the value of the eventValue property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getEventValue() {
        return eventValue;
    }

    /**
     * Sets the value of the eventValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setEventValue(TextType value) {
        this.eventValue = value;
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
