
package ecf4.latest.tyler.ecf.v5_0.extensions.reservedateresponse;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.reservedateresponse package. 
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

    private final static QName _ReserveDateResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:reservedateresponse", "ReserveDateResponseMessage");
    private final static QName _ReserveDateResponseMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:reservedateresponse", "ReserveDateResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.reservedateresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReserveDateResponseMessageType }
     * 
     */
    public ReserveDateResponseMessageType createReserveDateResponseMessageType() {
        return new ReserveDateResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReserveDateResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReserveDateResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:reservedateresponse", name = "ReserveDateResponseMessage")
    public JAXBElement<ReserveDateResponseMessageType> createReserveDateResponseMessage(ReserveDateResponseMessageType value) {
        return new JAXBElement<ReserveDateResponseMessageType>(_ReserveDateResponseMessage_QNAME, ReserveDateResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:reservedateresponse", name = "ReserveDateResponseMessageAugmentationPoint")
    public JAXBElement<Object> createReserveDateResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ReserveDateResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
