
package tyler.ecf.v5_0.extensions.casehearingresponse;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.casehearingresponse package. 
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

    private final static QName _GetCaseHearingsResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:casehearingresponse", "GetCaseHearingsResponseMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.casehearingresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetCaseHearingsResponseMessageType }
     * 
     */
    public GetCaseHearingsResponseMessageType createGetCaseHearingsResponseMessageType() {
        return new GetCaseHearingsResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCaseHearingsResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCaseHearingsResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:casehearingresponse", name = "GetCaseHearingsResponseMessage")
    public JAXBElement<GetCaseHearingsResponseMessageType> createGetCaseHearingsResponseMessage(GetCaseHearingsResponseMessageType value) {
        return new JAXBElement<GetCaseHearingsResponseMessageType>(_GetCaseHearingsResponseMessage_QNAME, GetCaseHearingsResponseMessageType.class, null, value);
    }

}
