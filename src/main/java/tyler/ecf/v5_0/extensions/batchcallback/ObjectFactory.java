
package tyler.ecf.v5_0.extensions.batchcallback;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.batchcallback package. 
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

    private final static QName _NotifyBatchCompleteMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchcallback", "NotifyBatchCompleteMessage");
    private final static QName _NotifyBatchCompleteMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchcallback", "NotifyBatchCompleteMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.batchcallback
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyBatchCompleteMessageType }
     * 
     */
    public NotifyBatchCompleteMessageType createNotifyBatchCompleteMessageType() {
        return new NotifyBatchCompleteMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyBatchCompleteMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyBatchCompleteMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchcallback", name = "NotifyBatchCompleteMessage")
    public JAXBElement<NotifyBatchCompleteMessageType> createNotifyBatchCompleteMessage(NotifyBatchCompleteMessageType value) {
        return new JAXBElement<NotifyBatchCompleteMessageType>(_NotifyBatchCompleteMessage_QNAME, NotifyBatchCompleteMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchcallback", name = "NotifyBatchCompleteMessageAugmentationPoint")
    public JAXBElement<Object> createNotifyBatchCompleteMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_NotifyBatchCompleteMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
