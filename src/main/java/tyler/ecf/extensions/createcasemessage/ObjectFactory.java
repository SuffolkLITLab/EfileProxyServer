
package tyler.ecf.extensions.createcasemessage;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.createcasemessage package. 
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

    private final static QName _CreateCaseMessage_QNAME = new QName("urn:tyler:ecf:extensions:CreateCaseMessage", "CreateCaseMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.createcasemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateCaseMessageType }
     * 
     */
    public CreateCaseMessageType createCreateCaseMessageType() {
        return new CreateCaseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCaseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateCaseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:CreateCaseMessage", name = "CreateCaseMessage")
    public JAXBElement<CreateCaseMessageType> createCreateCaseMessage(CreateCaseMessageType value) {
        return new JAXBElement<CreateCaseMessageType>(_CreateCaseMessage_QNAME, CreateCaseMessageType.class, null, value);
    }

}
