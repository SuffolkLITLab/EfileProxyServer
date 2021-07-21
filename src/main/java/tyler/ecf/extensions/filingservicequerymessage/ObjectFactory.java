
package tyler.ecf.extensions.filingservicequerymessage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.filingservicequerymessage package. 
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

    private final static QName _FilingServiceQueryMessage_QNAME = new QName("urn:tyler:ecf:extensions:FilingServiceQueryMessage", "FilingServiceQueryMessage");
    private final static QName _ServiceContactIdentification_QNAME = new QName("urn:tyler:ecf:extensions:FilingServiceQueryMessage", "ServiceContactIdentification");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.filingservicequerymessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FilingServiceQueryMessageType }
     * 
     */
    public FilingServiceQueryMessageType createFilingServiceQueryMessageType() {
        return new FilingServiceQueryMessageType();
    }

    /**
     * Create an instance of {@link ServiceContactIdentificationType }
     * 
     */
    public ServiceContactIdentificationType createServiceContactIdentificationType() {
        return new ServiceContactIdentificationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingServiceQueryMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingServiceQueryMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingServiceQueryMessage", name = "FilingServiceQueryMessage")
    public JAXBElement<FilingServiceQueryMessageType> createFilingServiceQueryMessage(FilingServiceQueryMessageType value) {
        return new JAXBElement<FilingServiceQueryMessageType>(_FilingServiceQueryMessage_QNAME, FilingServiceQueryMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceContactIdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceContactIdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingServiceQueryMessage", name = "ServiceContactIdentification")
    public JAXBElement<ServiceContactIdentificationType> createServiceContactIdentification(ServiceContactIdentificationType value) {
        return new JAXBElement<ServiceContactIdentificationType>(_ServiceContactIdentification_QNAME, ServiceContactIdentificationType.class, null, value);
    }

}
