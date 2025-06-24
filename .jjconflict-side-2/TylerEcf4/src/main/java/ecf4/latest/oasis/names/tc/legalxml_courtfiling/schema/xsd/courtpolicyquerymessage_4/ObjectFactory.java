
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4 package. 
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

    private final static QName _CourtPolicyQueryMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyQueryMessage-4.0", "CourtPolicyQueryMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CourtPolicyQueryMessageType }
     * 
     */
    public CourtPolicyQueryMessageType createCourtPolicyQueryMessageType() {
        return new CourtPolicyQueryMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CourtPolicyQueryMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CourtPolicyQueryMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyQueryMessage-4.0", name = "CourtPolicyQueryMessage")
    public JAXBElement<CourtPolicyQueryMessageType> createCourtPolicyQueryMessage(CourtPolicyQueryMessageType value) {
        return new JAXBElement<CourtPolicyQueryMessageType>(_CourtPolicyQueryMessage_QNAME, CourtPolicyQueryMessageType.class, null, value);
    }

}
