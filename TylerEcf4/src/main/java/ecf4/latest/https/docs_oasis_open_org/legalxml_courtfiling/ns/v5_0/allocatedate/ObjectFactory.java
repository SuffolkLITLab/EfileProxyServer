
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.allocatedate;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.allocatedate package. 
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

    private final static QName _AllocateCourtDateMessageAugmentationPoint_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/allocatedate", "AllocateCourtDateMessageAugmentationPoint");
    private final static QName _AllocateCourtDateMessage_QNAME = new QName("https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/allocatedate", "AllocateCourtDateMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.allocatedate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AllocateCourtDateMessageType }
     * 
     */
    public AllocateCourtDateMessageType createAllocateCourtDateMessageType() {
        return new AllocateCourtDateMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/allocatedate", name = "AllocateCourtDateMessageAugmentationPoint")
    public JAXBElement<Object> createAllocateCourtDateMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_AllocateCourtDateMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AllocateCourtDateMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AllocateCourtDateMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/allocatedate", name = "AllocateCourtDateMessage")
    public JAXBElement<AllocateCourtDateMessageType> createAllocateCourtDateMessage(AllocateCourtDateMessageType value) {
        return new JAXBElement<AllocateCourtDateMessageType>(_AllocateCourtDateMessage_QNAME, AllocateCourtDateMessageType.class, null, value);
    }

}
