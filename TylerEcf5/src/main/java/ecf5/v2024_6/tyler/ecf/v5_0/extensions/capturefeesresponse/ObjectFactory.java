
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.capturefeesresponse;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.capturefeesresponse package. 
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

    private final static QName _CaptureFeesResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:capturefeesresponse", "CaptureFeesResponseMessage");
    private final static QName _CaptureFeesResponseMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:capturefeesresponse", "CaptureFeesResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.capturefeesresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CaptureFeesResponseMessageType }
     * 
     */
    public CaptureFeesResponseMessageType createCaptureFeesResponseMessageType() {
        return new CaptureFeesResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaptureFeesResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaptureFeesResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:capturefeesresponse", name = "CaptureFeesResponseMessage")
    public JAXBElement<CaptureFeesResponseMessageType> createCaptureFeesResponseMessage(CaptureFeesResponseMessageType value) {
        return new JAXBElement<CaptureFeesResponseMessageType>(_CaptureFeesResponseMessage_QNAME, CaptureFeesResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:capturefeesresponse", name = "CaptureFeesResponseMessageAugmentationPoint")
    public JAXBElement<Object> createCaptureFeesResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_CaptureFeesResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
