
package tyler.ecf.extensions.cancelfilingresponsemessage;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.cancelfilingresponsemessage package. 
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

    private final static QName _CancelFilingResponseMessage_QNAME = new QName("urn:tyler:ecf:extensions:CancelFilingResponseMessage", "CancelFilingResponseMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.cancelfilingresponsemessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CancelFilingResponseMessageType }
     * 
     */
    public CancelFilingResponseMessageType createCancelFilingResponseMessageType() {
        return new CancelFilingResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelFilingResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CancelFilingResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:CancelFilingResponseMessage", name = "CancelFilingResponseMessage")
    public JAXBElement<CancelFilingResponseMessageType> createCancelFilingResponseMessage(CancelFilingResponseMessageType value) {
        return new JAXBElement<CancelFilingResponseMessageType>(_CancelFilingResponseMessage_QNAME, CancelFilingResponseMessageType.class, null, value);
    }

}
