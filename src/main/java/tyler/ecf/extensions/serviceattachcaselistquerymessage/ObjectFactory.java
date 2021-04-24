
package tyler.ecf.extensions.serviceattachcaselistquerymessage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.niem.niem_core._2.IdentificationType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.serviceattachcaselistquerymessage package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _ServiceContactIdentification_QNAME = new QName("urn:tyler:ecf:extensions:ServiceAttachCaseListQueryMessage", "ServiceContactIdentification");
    private final static QName _ServiceAttachCaseListQueryMessage_QNAME = new QName("urn:tyler:ecf:extensions:ServiceAttachCaseListQueryMessage", "ServiceAttachCaseListQueryMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.serviceattachcaselistquerymessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceAttachCaseListQueryMessageType }
     * 
     */
    public ServiceAttachCaseListQueryMessageType createServiceAttachCaseListQueryMessageType() {
        return new ServiceAttachCaseListQueryMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceAttachCaseListQueryMessage", name = "ServiceContactIdentification")
    public JAXBElement<IdentificationType> createServiceContactIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_ServiceContactIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceAttachCaseListQueryMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceAttachCaseListQueryMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:ServiceAttachCaseListQueryMessage", name = "ServiceAttachCaseListQueryMessage")
    public JAXBElement<ServiceAttachCaseListQueryMessageType> createServiceAttachCaseListQueryMessage(ServiceAttachCaseListQueryMessageType value) {
        return new JAXBElement<ServiceAttachCaseListQueryMessageType>(_ServiceAttachCaseListQueryMessage_QNAME, ServiceAttachCaseListQueryMessageType.class, null, value);
    }

}
