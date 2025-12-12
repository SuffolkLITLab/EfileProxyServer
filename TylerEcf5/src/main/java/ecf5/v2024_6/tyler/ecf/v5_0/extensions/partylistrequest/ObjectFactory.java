
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.partylistrequest;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.EntityType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.partylistrequest package. 
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

    private final static QName _GetPartyListMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:partylistrequest", "GetPartyListMessage");
    private final static QName _Party_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:partylistrequest", "Party");
    private final static QName _MaxNumberOfResults_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:partylistrequest", "MaxNumberOfResults");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.partylistrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetPartyListMessageType }
     * 
     */
    public GetPartyListMessageType createGetPartyListMessageType() {
        return new GetPartyListMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPartyListMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetPartyListMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:partylistrequest", name = "GetPartyListMessage")
    public JAXBElement<GetPartyListMessageType> createGetPartyListMessage(GetPartyListMessageType value) {
        return new JAXBElement<GetPartyListMessageType>(_GetPartyListMessage_QNAME, GetPartyListMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:partylistrequest", name = "Party")
    public JAXBElement<EntityType> createParty(EntityType value) {
        return new JAXBElement<EntityType>(_Party_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:partylistrequest", name = "MaxNumberOfResults")
    public JAXBElement<NonNegativeDecimalType> createMaxNumberOfResults(NonNegativeDecimalType value) {
        return new JAXBElement<NonNegativeDecimalType>(_MaxNumberOfResults_QNAME, NonNegativeDecimalType.class, null, value);
    }

}
