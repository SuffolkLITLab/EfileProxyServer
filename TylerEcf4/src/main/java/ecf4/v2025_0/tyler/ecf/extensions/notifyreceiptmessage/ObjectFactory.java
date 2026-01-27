
package ecf4.v2025_0.tyler.ecf.extensions.notifyreceiptmessage;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.notifyreceiptmessage package. 
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

    private final static QName _NotifyReceiptMessage_QNAME = new QName("urn:tyler:ecf:extensions:NotifyReceiptMessage", "NotifyReceiptMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.notifyreceiptmessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link NotifyReceiptMessageType }
     * 
     */
    public NotifyReceiptMessageType createNotifyReceiptMessageType() {
        return new NotifyReceiptMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NotifyReceiptMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NotifyReceiptMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:NotifyReceiptMessage", name = "NotifyReceiptMessage")
    public JAXBElement<NotifyReceiptMessageType> createNotifyReceiptMessage(NotifyReceiptMessageType value) {
        return new JAXBElement<NotifyReceiptMessageType>(_NotifyReceiptMessage_QNAME, NotifyReceiptMessageType.class, null, value);
    }

}
