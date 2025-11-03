
package ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationresponsemessage_4;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.niem.niem_core._2.AmountType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationresponsemessage_4 package. 
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

    private final static QName _FeesCalculationAmount_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FeesCalculationResponseMessage-4.0", "FeesCalculationAmount");
    private final static QName _FeesCalculationResponseMessage_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FeesCalculationResponseMessage-4.0", "FeesCalculationResponseMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationresponsemessage_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FeesCalculationResponseMessageType }
     * 
     */
    public FeesCalculationResponseMessageType createFeesCalculationResponseMessageType() {
        return new FeesCalculationResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FeesCalculationResponseMessage-4.0", name = "FeesCalculationAmount")
    public JAXBElement<AmountType> createFeesCalculationAmount(AmountType value) {
        return new JAXBElement<AmountType>(_FeesCalculationAmount_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FeesCalculationResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FeesCalculationResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:FeesCalculationResponseMessage-4.0", name = "FeesCalculationResponseMessage")
    public JAXBElement<FeesCalculationResponseMessageType> createFeesCalculationResponseMessage(FeesCalculationResponseMessageType value) {
        return new JAXBElement<FeesCalculationResponseMessageType>(_FeesCalculationResponseMessage_QNAME, FeesCalculationResponseMessageType.class, null, value);
    }

}
