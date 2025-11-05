
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.recordreceipt;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.recordreceipt package. 
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

    private final static QName _RecordReceiptMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:recordreceipt", "RecordReceiptMessageAugmentationPoint");
    private final static QName _RecordReceiptMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:recordreceipt", "RecordReceiptMessage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.recordreceipt
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RecordReceiptMessageType }
     * 
     */
    public RecordReceiptMessageType createRecordReceiptMessageType() {
        return new RecordReceiptMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:recordreceipt", name = "RecordReceiptMessageAugmentationPoint")
    public JAXBElement<Object> createRecordReceiptMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_RecordReceiptMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RecordReceiptMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RecordReceiptMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:recordreceipt", name = "RecordReceiptMessage")
    public JAXBElement<RecordReceiptMessageType> createRecordReceiptMessage(RecordReceiptMessageType value) {
        return new JAXBElement<RecordReceiptMessageType>(_RecordReceiptMessage_QNAME, RecordReceiptMessageType.class, null, value);
    }

}
