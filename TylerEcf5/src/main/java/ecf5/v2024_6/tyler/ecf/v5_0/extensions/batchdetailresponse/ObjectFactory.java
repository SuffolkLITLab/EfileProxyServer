
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchdetailresponse;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchdetailresponse package. 
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

    private final static QName _GetBatchDetailResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchdetailresponse", "GetBatchDetailResponseMessage");
    private final static QName _GetBatchDetailResponseMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchdetailresponse", "GetBatchDetailResponseMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchdetailresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBatchDetailResponseMessageType }
     * 
     */
    public GetBatchDetailResponseMessageType createGetBatchDetailResponseMessageType() {
        return new GetBatchDetailResponseMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBatchDetailResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBatchDetailResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchdetailresponse", name = "GetBatchDetailResponseMessage")
    public JAXBElement<GetBatchDetailResponseMessageType> createGetBatchDetailResponseMessage(GetBatchDetailResponseMessageType value) {
        return new JAXBElement<GetBatchDetailResponseMessageType>(_GetBatchDetailResponseMessage_QNAME, GetBatchDetailResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchdetailresponse", name = "GetBatchDetailResponseMessageAugmentationPoint")
    public JAXBElement<Object> createGetBatchDetailResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetBatchDetailResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
