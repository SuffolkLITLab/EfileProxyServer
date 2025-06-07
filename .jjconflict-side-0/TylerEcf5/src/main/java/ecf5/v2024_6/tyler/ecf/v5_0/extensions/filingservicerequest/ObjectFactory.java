
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.filingservicerequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.filingservicerequest package. 
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

    private final static QName _GetFilingServiceMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:filingservicerequest", "GetFilingServiceMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.filingservicerequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFilingServiceMessageType }
     * 
     */
    public GetFilingServiceMessageType createGetFilingServiceMessageType() {
        return new GetFilingServiceMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilingServiceMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetFilingServiceMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:filingservicerequest", name = "GetFilingServiceMessage")
    public JAXBElement<GetFilingServiceMessageType> createGetFilingServiceMessage(GetFilingServiceMessageType value) {
        return new JAXBElement<GetFilingServiceMessageType>(_GetFilingServiceMessage_QNAME, GetFilingServiceMessageType.class, null, value);
    }

}
