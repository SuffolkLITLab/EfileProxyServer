
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.capturefeesrequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.capturefeesrequest package. 
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

    private final static QName _CaptureFeesMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:capturefeesrequest", "CaptureFeesMessage");
    private final static QName _CaptureFeesMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:capturefeesrequest", "CaptureFeesMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.capturefeesrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CaptureFeesMessageType }
     * 
     */
    public CaptureFeesMessageType createCaptureFeesMessageType() {
        return new CaptureFeesMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaptureFeesMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaptureFeesMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:capturefeesrequest", name = "CaptureFeesMessage")
    public JAXBElement<CaptureFeesMessageType> createCaptureFeesMessage(CaptureFeesMessageType value) {
        return new JAXBElement<CaptureFeesMessageType>(_CaptureFeesMessage_QNAME, CaptureFeesMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:capturefeesrequest", name = "CaptureFeesMessageAugmentationPoint")
    public JAXBElement<Object> createCaptureFeesMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_CaptureFeesMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
