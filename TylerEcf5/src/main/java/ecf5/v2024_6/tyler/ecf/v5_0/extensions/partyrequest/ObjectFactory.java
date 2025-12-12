
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.partyrequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.partyrequest package. 
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

    private final static QName _GetPartyMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:partyrequest", "GetPartyMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.partyrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPartyMessageType }
     * 
     */
    public GetPartyMessageType createGetPartyMessageType() {
        return new GetPartyMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPartyMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPartyMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:partyrequest", name = "GetPartyMessage")
    public JAXBElement<GetPartyMessageType> createGetPartyMessage(GetPartyMessageType value) {
        return new JAXBElement<GetPartyMessageType>(_GetPartyMessage_QNAME, GetPartyMessageType.class, null, value);
    }

}
