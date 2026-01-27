
package ecf4.latest.tyler.ecf.extensions.securecasemessage;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.tyler.ecf.extensions.securecasemessage package. 
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

    private final static QName _SecureCaseMessage_QNAME = new QName("urn:tyler:ecf:extensions:SecureCaseMessage", "SecureCaseMessage");
    private final static QName _IsSecured_QNAME = new QName("urn:tyler:ecf:extensions:SecureCaseMessage", "IsSecured");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.tyler.ecf.extensions.securecasemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SecureCaseMessageType }
     * 
     */
    public SecureCaseMessageType createSecureCaseMessageType() {
        return new SecureCaseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SecureCaseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SecureCaseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:SecureCaseMessage", name = "SecureCaseMessage")
    public JAXBElement<SecureCaseMessageType> createSecureCaseMessage(SecureCaseMessageType value) {
        return new JAXBElement<SecureCaseMessageType>(_SecureCaseMessage_QNAME, SecureCaseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:SecureCaseMessage", name = "IsSecured")
    public JAXBElement<Boolean> createIsSecured(Boolean value) {
        return new JAXBElement<Boolean>(_IsSecured_QNAME, Boolean.class, null, value);
    }

}
