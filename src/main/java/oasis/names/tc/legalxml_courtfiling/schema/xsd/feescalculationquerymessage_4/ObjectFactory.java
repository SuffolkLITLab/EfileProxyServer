
package oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4 package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
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

    private final static QName _FeesCalculationQueryMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FeesCalculationQueryMessage-4.0", "FeesCalculationQueryMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FeesCalculationQueryMessageType }
     * 
     */
    public FeesCalculationQueryMessageType createFeesCalculationQueryMessageType() {
        return new FeesCalculationQueryMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeesCalculationQueryMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeesCalculationQueryMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FeesCalculationQueryMessage-4.0", name = "FeesCalculationQueryMessage")
    public JAXBElement<FeesCalculationQueryMessageType> createFeesCalculationQueryMessage(FeesCalculationQueryMessageType value) {
        return new JAXBElement<FeesCalculationQueryMessageType>(_FeesCalculationQueryMessage_QNAME, FeesCalculationQueryMessageType.class, null, value);
    }

}
