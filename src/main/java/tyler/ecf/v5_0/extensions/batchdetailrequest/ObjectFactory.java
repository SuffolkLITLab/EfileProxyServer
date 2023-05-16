
package tyler.ecf.v5_0.extensions.batchdetailrequest;

import javax.xml.namespace.QName;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.batchdetailrequest package. 
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

    private final static QName _GetBatchDetailMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchdetailrequest", "GetBatchDetailMessage");
    private final static QName _GetBatchDetailMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchdetailrequest", "GetBatchDetailMessageAugmentationPoint");
    private final static QName _BatchDetailQueryCriteria_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchdetailrequest", "BatchDetailQueryCriteria");
    private final static QName _IncludeEnvelopeDetailsIndicator_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchdetailrequest", "IncludeEnvelopeDetailsIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.batchdetailrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBatchDetailMessageType }
     * 
     */
    public GetBatchDetailMessageType createGetBatchDetailMessageType() {
        return new GetBatchDetailMessageType();
    }

    /**
     * Create an instance of {@link BatchDetailQueryCriteriaType }
     * 
     */
    public BatchDetailQueryCriteriaType createBatchDetailQueryCriteriaType() {
        return new BatchDetailQueryCriteriaType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBatchDetailMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBatchDetailMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchdetailrequest", name = "GetBatchDetailMessage")
    public JAXBElement<GetBatchDetailMessageType> createGetBatchDetailMessage(GetBatchDetailMessageType value) {
        return new JAXBElement<GetBatchDetailMessageType>(_GetBatchDetailMessage_QNAME, GetBatchDetailMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchdetailrequest", name = "GetBatchDetailMessageAugmentationPoint")
    public JAXBElement<Object> createGetBatchDetailMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetBatchDetailMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchDetailQueryCriteriaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BatchDetailQueryCriteriaType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchdetailrequest", name = "BatchDetailQueryCriteria")
    public JAXBElement<BatchDetailQueryCriteriaType> createBatchDetailQueryCriteria(BatchDetailQueryCriteriaType value) {
        return new JAXBElement<BatchDetailQueryCriteriaType>(_BatchDetailQueryCriteria_QNAME, BatchDetailQueryCriteriaType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchdetailrequest", name = "IncludeEnvelopeDetailsIndicator")
    public JAXBElement<Boolean> createIncludeEnvelopeDetailsIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncludeEnvelopeDetailsIndicator_QNAME, Boolean.class, null, value);
    }

}
