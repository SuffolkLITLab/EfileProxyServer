
package ecf4.latest.tyler.ecf.extensions.servicetypesrequestmessage;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.tyler.ecf.extensions.servicetypesrequestmessage package. 
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

    private final static QName _ServiceTypesRequestMessage_QNAME = new QName("urn:tyler:ecf:extensions:ServiceTypesRequestMessage", "ServiceTypesRequestMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.tyler.ecf.extensions.servicetypesrequestmessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceTypesRequestMessageType }
     * 
     */
    public ServiceTypesRequestMessageType createServiceTypesRequestMessageType() {
        return new ServiceTypesRequestMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceTypesRequestMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceTypesRequestMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceTypesRequestMessage", name = "ServiceTypesRequestMessage")
    public JAXBElement<ServiceTypesRequestMessageType> createServiceTypesRequestMessage(ServiceTypesRequestMessageType value) {
        return new JAXBElement<ServiceTypesRequestMessageType>(_ServiceTypesRequestMessage_QNAME, ServiceTypesRequestMessageType.class, null, value);
    }

}
