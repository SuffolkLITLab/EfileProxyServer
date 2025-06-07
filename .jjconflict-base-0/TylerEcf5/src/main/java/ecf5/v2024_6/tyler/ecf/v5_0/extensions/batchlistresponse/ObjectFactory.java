
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchlistresponse;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AmountType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.NonNegativeDecimalType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchlistresponse package. 
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

    private final static QName _GetBatchListResponseMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchlistresponse", "GetBatchListResponseMessage");
    private final static QName _GetBatchListResponseMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchlistresponse", "GetBatchListResponseMessageAugmentationPoint");
    private final static QName _Batch_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchlistresponse", "Batch");
    private final static QName _TotalFees_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchlistresponse", "TotalFees");
    private final static QName _BatchSize_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchlistresponse", "BatchSize");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchlistresponse
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBatchListResponseMessageType }
     * 
     */
    public GetBatchListResponseMessageType createGetBatchListResponseMessageType() {
        return new GetBatchListResponseMessageType();
    }

    /**
     * Create an instance of {@link BatchType }
     * 
     */
    public BatchType createBatchType() {
        return new BatchType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBatchListResponseMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBatchListResponseMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchlistresponse", name = "GetBatchListResponseMessage")
    public JAXBElement<GetBatchListResponseMessageType> createGetBatchListResponseMessage(GetBatchListResponseMessageType value) {
        return new JAXBElement<GetBatchListResponseMessageType>(_GetBatchListResponseMessage_QNAME, GetBatchListResponseMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchlistresponse", name = "GetBatchListResponseMessageAugmentationPoint")
    public JAXBElement<Object> createGetBatchListResponseMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetBatchListResponseMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BatchType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchlistresponse", name = "Batch")
    public JAXBElement<BatchType> createBatch(BatchType value) {
        return new JAXBElement<BatchType>(_Batch_QNAME, BatchType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AmountType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchlistresponse", name = "TotalFees")
    public JAXBElement<AmountType> createTotalFees(AmountType value) {
        return new JAXBElement<AmountType>(_TotalFees_QNAME, AmountType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link NonNegativeDecimalType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchlistresponse", name = "BatchSize")
    public JAXBElement<NonNegativeDecimalType> createBatchSize(NonNegativeDecimalType value) {
        return new JAXBElement<NonNegativeDecimalType>(_BatchSize_QNAME, NonNegativeDecimalType.class, null, value);
    }

}
