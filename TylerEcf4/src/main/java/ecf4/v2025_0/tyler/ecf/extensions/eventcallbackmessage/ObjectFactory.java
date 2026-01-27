
package ecf4.v2025_0.tyler.ecf.extensions.eventcallbackmessage;

import javax.xml.namespace.QName;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.eventcallbackmessage package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EventCallbackMessage_QNAME = new QName("urn:tyler:ecf:extensions:EventCallbackMessage", "EventCallbackMessage");
    private final static QName _EventTypeCode_QNAME = new QName("urn:tyler:ecf:extensions:EventCallbackMessage", "EventTypeCode");
    private final static QName _Event_QNAME = new QName("urn:tyler:ecf:extensions:EventCallbackMessage", "Event");
    private final static QName _EventVariable_QNAME = new QName("urn:tyler:ecf:extensions:EventCallbackMessage", "EventVariable");
    private final static QName _EventKey_QNAME = new QName("urn:tyler:ecf:extensions:EventCallbackMessage", "EventKey");
    private final static QName _EventValue_QNAME = new QName("urn:tyler:ecf:extensions:EventCallbackMessage", "EventValue");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.eventcallbackmessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EventCallbackMessageType }
     * 
     */
    public EventCallbackMessageType createEventCallbackMessageType() {
        return new EventCallbackMessageType();
    }

    /**
     * Create an instance of {@link EventType }
     * 
     */
    public EventType createEventType() {
        return new EventType();
    }

    /**
     * Create an instance of {@link EventVariableType }
     * 
     */
    public EventVariableType createEventVariableType() {
        return new EventVariableType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventCallbackMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EventCallbackMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:EventCallbackMessage", name = "EventCallbackMessage")
    public JAXBElement<EventCallbackMessageType> createEventCallbackMessage(EventCallbackMessageType value) {
        return new JAXBElement<EventCallbackMessageType>(_EventCallbackMessage_QNAME, EventCallbackMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:EventCallbackMessage", name = "EventTypeCode")
    public JAXBElement<TextType> createEventTypeCode(TextType value) {
        return new JAXBElement<TextType>(_EventTypeCode_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EventType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:EventCallbackMessage", name = "Event")
    public JAXBElement<EventType> createEvent(EventType value) {
        return new JAXBElement<EventType>(_Event_QNAME, EventType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EventVariableType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EventVariableType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:EventCallbackMessage", name = "EventVariable")
    public JAXBElement<EventVariableType> createEventVariable(EventVariableType value) {
        return new JAXBElement<EventVariableType>(_EventVariable_QNAME, EventVariableType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:EventCallbackMessage", name = "EventKey")
    public JAXBElement<TextType> createEventKey(TextType value) {
        return new JAXBElement<TextType>(_EventKey_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:EventCallbackMessage", name = "EventValue")
    public JAXBElement<TextType> createEventValue(TextType value) {
        return new JAXBElement<TextType>(_EventValue_QNAME, TextType.class, null, value);
    }

}
