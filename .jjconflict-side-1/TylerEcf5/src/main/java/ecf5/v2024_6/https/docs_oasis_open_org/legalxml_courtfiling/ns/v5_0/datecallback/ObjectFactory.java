
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.datecallback;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.datecallback package. 
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

    private final static QName _NotifyCourtDateMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/datecallback", "NotifyCourtDateMessage");
    private final static QName _NotifyCourtDateMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/datecallback", "NotifyCourtDateMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.datecallback
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyCourtDateMessageType }
     * 
     */
    public NotifyCourtDateMessageType createNotifyCourtDateMessageType() {
        return new NotifyCourtDateMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyCourtDateMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyCourtDateMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/datecallback", name = "NotifyCourtDateMessage")
    public JAXBElement<NotifyCourtDateMessageType> createNotifyCourtDateMessage(NotifyCourtDateMessageType value) {
        return new JAXBElement<NotifyCourtDateMessageType>(_NotifyCourtDateMessage_QNAME, NotifyCourtDateMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/datecallback", name = "NotifyCourtDateMessageAugmentationPoint")
    public JAXBElement<Object> createNotifyCourtDateMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_NotifyCourtDateMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
