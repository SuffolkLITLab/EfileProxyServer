
package tyler.ecf.v5_0.extensions.servicecallback;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.servicecallback package. 
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

    private final static QName _NotifyServiceCompleteMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicecallback", "NotifyServiceCompleteMessage");
    private final static QName _NotifyServiceCompleteMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicecallback", "NotifyServiceCompleteMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.servicecallback
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyServiceCompleteMessageType }
     * 
     */
    public NotifyServiceCompleteMessageType createNotifyServiceCompleteMessageType() {
        return new NotifyServiceCompleteMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyServiceCompleteMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyServiceCompleteMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicecallback", name = "NotifyServiceCompleteMessage")
    public JAXBElement<NotifyServiceCompleteMessageType> createNotifyServiceCompleteMessage(NotifyServiceCompleteMessageType value) {
        return new JAXBElement<NotifyServiceCompleteMessageType>(_NotifyServiceCompleteMessage_QNAME, NotifyServiceCompleteMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicecallback", name = "NotifyServiceCompleteMessageAugmentationPoint")
    public JAXBElement<Object> createNotifyServiceCompleteMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_NotifyServiceCompleteMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
