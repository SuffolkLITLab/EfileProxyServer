
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.returndate;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.returndate package. 
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

    private final static QName _ReturnDateMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:returndate", "ReturnDateMessageAugmentationPoint");
    private final static QName _ReturnDateMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:returndate", "ReturnDateMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.returndate
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReturnDateMessageType }
     * 
     */
    public ReturnDateMessageType createReturnDateMessageType() {
        return new ReturnDateMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:returndate", name = "ReturnDateMessageAugmentationPoint")
    public JAXBElement<Object> createReturnDateMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_ReturnDateMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReturnDateMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReturnDateMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:returndate", name = "ReturnDateMessage")
    public JAXBElement<ReturnDateMessageType> createReturnDateMessage(ReturnDateMessageType value) {
        return new JAXBElement<ReturnDateMessageType>(_ReturnDateMessage_QNAME, ReturnDateMessageType.class, null, value);
    }

}
