
package tyler.ecf.extensions.serviceattachcaselistresponsemessage;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.serviceattachcaselistresponsemessage package. 
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

    private final static QName _ServiceAttachCaseListResponseMessage_QNAME = new QName("urn:tyler:ecf:extensions:ServiceAttachCaseListResponseMessage", "ServiceAttachCaseListResponseMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.serviceattachcaselistresponsemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceAttachCaseListResponseMessageType }
     * 
     */
    public ServiceAttachCaseListResponseMessageType createServiceAttachCaseListResponseMessageType() {
        return new ServiceAttachCaseListResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceAttachCaseListResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceAttachCaseListResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceAttachCaseListResponseMessage", name = "ServiceAttachCaseListResponseMessage")
    public JAXBElement<ServiceAttachCaseListResponseMessageType> createServiceAttachCaseListResponseMessage(ServiceAttachCaseListResponseMessageType value) {
        return new JAXBElement<ServiceAttachCaseListResponseMessageType>(_ServiceAttachCaseListResponseMessage_QNAME, ServiceAttachCaseListResponseMessageType.class, null, value);
    }

}
