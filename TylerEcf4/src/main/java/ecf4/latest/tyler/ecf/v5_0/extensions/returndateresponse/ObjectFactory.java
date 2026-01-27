
package ecf4.latest.tyler.ecf.v5_0.extensions.returndateresponse;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DateType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.tyler.ecf.v5_0.extensions.returndateresponse package. 
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

    private final static QName _ReturnDateResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:returndateresponse", "ReturnDateResponseMessage");
    private final static QName _ReturnDateResponseMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:returndateresponse", "ReturnDateResponseMessageAugmentationPoint");
    private final static QName _ReturnDate_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:returndateresponse", "ReturnDate");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf4.latest.tyler.ecf.v5_0.extensions.returndateresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReturnDateResponseMessageType }
     * 
     */
    public ReturnDateResponseMessageType createReturnDateResponseMessageType() {
        return new ReturnDateResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnDateResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReturnDateResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:returndateresponse", name = "ReturnDateResponseMessage")
    public JAXBElement<ReturnDateResponseMessageType> createReturnDateResponseMessage(ReturnDateResponseMessageType value) {
        return new JAXBElement<ReturnDateResponseMessageType>(_ReturnDateResponseMessage_QNAME, ReturnDateResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:returndateresponse", name = "ReturnDateResponseMessageAugmentationPoint")
    public JAXBElement<Object> createReturnDateResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ReturnDateResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:returndateresponse", name = "ReturnDate")
    public JAXBElement<DateType> createReturnDate(DateType value) {
        return new JAXBElement<DateType>(_ReturnDate_QNAME, DateType.class, null, value);
    }

}
