
package tyler.ecf.v5_0.extensions.reviewenvelopecallback;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.reviewenvelopecallback package. 
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

    private final static QName _NotifyEnvelopeCompleteMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:reviewenvelopecallback", "NotifyEnvelopeCompleteMessage");
    private final static QName _NotifyEnvelopeCompleteMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:reviewenvelopecallback", "NotifyEnvelopeCompleteMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.reviewenvelopecallback
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyEnvelopeCompleteMessageType }
     * 
     */
    public NotifyEnvelopeCompleteMessageType createNotifyEnvelopeCompleteMessageType() {
        return new NotifyEnvelopeCompleteMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyEnvelopeCompleteMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyEnvelopeCompleteMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:reviewenvelopecallback", name = "NotifyEnvelopeCompleteMessage")
    public JAXBElement<NotifyEnvelopeCompleteMessageType> createNotifyEnvelopeCompleteMessage(NotifyEnvelopeCompleteMessageType value) {
        return new JAXBElement<NotifyEnvelopeCompleteMessageType>(_NotifyEnvelopeCompleteMessage_QNAME, NotifyEnvelopeCompleteMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:reviewenvelopecallback", name = "NotifyEnvelopeCompleteMessageAugmentationPoint")
    public JAXBElement<Object> createNotifyEnvelopeCompleteMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_NotifyEnvelopeCompleteMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
