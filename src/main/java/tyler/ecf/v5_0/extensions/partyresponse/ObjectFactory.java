
package tyler.ecf.v5_0.extensions.partyresponse;

import javax.xml.namespace.QName;
import gov.niem.release.niem.niem_core._4.EntityType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.partyresponse package. 
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

    private final static QName _GetPartyResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:partyresponse", "GetPartyResponseMessage");
    private final static QName _Party_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:partyresponse", "Party");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.partyresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPartyResponseMessageType }
     * 
     */
    public GetPartyResponseMessageType createGetPartyResponseMessageType() {
        return new GetPartyResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPartyResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPartyResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:partyresponse", name = "GetPartyResponseMessage")
    public JAXBElement<GetPartyResponseMessageType> createGetPartyResponseMessage(GetPartyResponseMessageType value) {
        return new JAXBElement<GetPartyResponseMessageType>(_GetPartyResponseMessage_QNAME, GetPartyResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:partyresponse", name = "Party")
    public JAXBElement<EntityType> createParty(EntityType value) {
        return new JAXBElement<EntityType>(_Party_QNAME, EntityType.class, null, value);
    }

}
