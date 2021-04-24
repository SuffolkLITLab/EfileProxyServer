
package tyler.ecf.extensions.eventcallbackmessage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;


/**
 * The message returned from the Court Record MDE to the Filing Review MDE when the case has been created.
 * 
 * &lt;p&gt;Java class for EventCallbackMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="EventCallbackMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SendingMDELocationID"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SendingMDEProfileCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:EventCallbackMessage}EventTypeCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:EventCallbackMessage}Event"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EventCallbackMessageType", propOrder = {
    "sendingMDELocationID",
    "sendingMDEProfileCode",
    "eventTypeCode",
    "event"
})
public class EventCallbackMessageType {

    @XmlElement(name = "SendingMDELocationID", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    protected IdentificationType sendingMDELocationID;
    @XmlElement(name = "SendingMDEProfileCode", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String sendingMDEProfileCode;
    @XmlElement(name = "EventTypeCode", required = true)
    protected TextType eventTypeCode;
    @XmlElement(name = "Event", required = true)
    protected EventType event;

    /**
     * Gets the value of the sendingMDELocationID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getSendingMDELocationID() {
        return sendingMDELocationID;
    }

    /**
     * Sets the value of the sendingMDELocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setSendingMDELocationID(IdentificationType value) {
        this.sendingMDELocationID = value;
    }

    /**
     * Gets the value of the sendingMDEProfileCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendingMDEProfileCode() {
        return sendingMDEProfileCode;
    }

    /**
     * Sets the value of the sendingMDEProfileCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendingMDEProfileCode(String value) {
        this.sendingMDEProfileCode = value;
    }

    /**
     * Gets the value of the eventTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getEventTypeCode() {
        return eventTypeCode;
    }

    /**
     * Sets the value of the eventTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setEventTypeCode(TextType value) {
        this.eventTypeCode = value;
    }

    /**
     * Gets the value of the event property.
     * 
     * @return
     *     possible object is
     *     {@link EventType }
     *     
     */
    public EventType getEvent() {
        return event;
    }

    /**
     * Sets the value of the event property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventType }
     *     
     */
    public void setEvent(EventType value) {
        this.event = value;
    }

}
