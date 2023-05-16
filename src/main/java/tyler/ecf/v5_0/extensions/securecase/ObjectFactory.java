
package tyler.ecf.v5_0.extensions.securecase;

import javax.xml.namespace.QName;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.securecase package. 
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

    private final static QName _SecureCaseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:securecase", "SecureCaseMessage");
    private final static QName _IsSecure_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:securecase", "IsSecure");
    private final static QName _SecureCaseMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:securecase", "SecureCaseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.securecase
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:securecase", name = "SecureCaseMessage")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:securecase", name = "IsSecure")
    public JAXBElement<Boolean> createIsSecure(Boolean value) {
        return new JAXBElement<Boolean>(_IsSecure_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:securecase", name = "SecureCaseMessageAugmentationPoint")
    public JAXBElement<Object> createSecureCaseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_SecureCaseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
