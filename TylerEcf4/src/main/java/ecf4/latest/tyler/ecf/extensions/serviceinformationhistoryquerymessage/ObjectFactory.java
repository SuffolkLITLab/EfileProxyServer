
package ecf4.latest.tyler.ecf.extensions.serviceinformationhistoryquerymessage;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.tyler.ecf.extensions.serviceinformationhistoryquerymessage package. 
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

    private final static QName _ServiceInformationHistoryQueryMessage_QNAME = new QName("urn:tyler:ecf:extensions:ServiceInformationHistoryQueryMessage", "ServiceInformationHistoryQueryMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.tyler.ecf.extensions.serviceinformationhistoryquerymessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceInformationHistoryQueryMessageType }
     * 
     */
    public ServiceInformationHistoryQueryMessageType createServiceInformationHistoryQueryMessageType() {
        return new ServiceInformationHistoryQueryMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceInformationHistoryQueryMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceInformationHistoryQueryMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceInformationHistoryQueryMessage", name = "ServiceInformationHistoryQueryMessage")
    public JAXBElement<ServiceInformationHistoryQueryMessageType> createServiceInformationHistoryQueryMessage(ServiceInformationHistoryQueryMessageType value) {
        return new JAXBElement<ServiceInformationHistoryQueryMessageType>(_ServiceInformationHistoryQueryMessage_QNAME, ServiceInformationHistoryQueryMessageType.class, null, value);
    }

}
