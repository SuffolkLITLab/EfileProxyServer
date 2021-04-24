
package tyler.ecf.extensions.eventcallbackmessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;


/**
 * &lt;p&gt;Java class for EventVariableType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="EventVariableType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:EventCallbackMessage}EventKey"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:EventCallbackMessage}EventValue"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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

}
