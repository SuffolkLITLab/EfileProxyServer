
package ecf4.latest.tyler.ecf.extensions.filingdetailquerymessage;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.tyler.ecf.extensions.filingdetailquerymessage package. 
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

    private final static QName _FilingDetailQueryMessage_QNAME = new QName("urn:tyler:ecf:extensions:FilingDetailQueryMessage", "FilingDetailQueryMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.tyler.ecf.extensions.filingdetailquerymessage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FilingDetailQueryMessageType }
     * 
     */
    public FilingDetailQueryMessageType createFilingDetailQueryMessageType() {
        return new FilingDetailQueryMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FilingDetailQueryMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FilingDetailQueryMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:FilingDetailQueryMessage", name = "FilingDetailQueryMessage")
    public JAXBElement<FilingDetailQueryMessageType> createFilingDetailQueryMessage(FilingDetailQueryMessageType value) {
        return new JAXBElement<FilingDetailQueryMessageType>(_FilingDetailQueryMessage_QNAME, FilingDetailQueryMessageType.class, null, value);
    }

}
