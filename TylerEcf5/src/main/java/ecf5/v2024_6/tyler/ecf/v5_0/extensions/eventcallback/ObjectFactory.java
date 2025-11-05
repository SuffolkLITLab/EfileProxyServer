
package tyler.ecf.v5_0.extensions.eventcallback;

import javax.xml.namespace.QName;
import gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.eventcallback package. 
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

    private final static QName _NotifyEventMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:eventcallback", "NotifyEventMessage");
    private final static QName _EventTypeCode_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:eventcallback", "EventTypeCode");
    private final static QName _Event_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:eventcallback", "Event");
    private final static QName _EventVariable_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:eventcallback", "EventVariable");
    private final static QName _EventKey_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:eventcallback", "EventKey");
    private final static QName _EventValue_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:eventcallback", "EventValue");
    private final static QName _NotifyEventMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:eventcallback", "NotifyEventMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.eventcallback
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyEventMessageType }
     * 
     */
    public NotifyEventMessageType createNotifyEventMessageType() {
        return new NotifyEventMessageType();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyEventMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyEventMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:eventcallback", name = "NotifyEventMessage")
    public JAXBElement<NotifyEventMessageType> createNotifyEventMessage(NotifyEventMessageType value) {
        return new JAXBElement<NotifyEventMessageType>(_NotifyEventMessage_QNAME, NotifyEventMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:eventcallback", name = "EventTypeCode")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:eventcallback", name = "Event")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:eventcallback", name = "EventVariable")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:eventcallback", name = "EventKey")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:eventcallback", name = "EventValue")
    public JAXBElement<TextType> createEventValue(TextType value) {
        return new JAXBElement<TextType>(_EventValue_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:eventcallback", name = "NotifyEventMessageAugmentationPoint")
    public JAXBElement<Object> createNotifyEventMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_NotifyEventMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
