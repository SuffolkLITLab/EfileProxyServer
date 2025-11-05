
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchlistrequest;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchlistrequest package. 
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

    private final static QName _GetBatchListMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchlistrequest", "GetBatchListMessage");
    private final static QName _GetBatchListMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchlistrequest", "GetBatchListMessageAugmentationPoint");
    private final static QName _BatchListQueryCriteria_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchlistrequest", "BatchListQueryCriteria");
    private final static QName _IncludeFirmsBatchIndicator_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:batchlistrequest", "IncludeFirmsBatchIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.batchlistrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBatchListMessageType }
     * 
     */
    public GetBatchListMessageType createGetBatchListMessageType() {
        return new GetBatchListMessageType();
    }

    /**
     * Create an instance of {@link BatchListQueryCriteriaType }
     * 
     */
    public BatchListQueryCriteriaType createBatchListQueryCriteriaType() {
        return new BatchListQueryCriteriaType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBatchListMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBatchListMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchlistrequest", name = "GetBatchListMessage")
    public JAXBElement<GetBatchListMessageType> createGetBatchListMessage(GetBatchListMessageType value) {
        return new JAXBElement<GetBatchListMessageType>(_GetBatchListMessage_QNAME, GetBatchListMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchlistrequest", name = "GetBatchListMessageAugmentationPoint")
    public JAXBElement<Object> createGetBatchListMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetBatchListMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BatchListQueryCriteriaType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BatchListQueryCriteriaType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchlistrequest", name = "BatchListQueryCriteria")
    public JAXBElement<BatchListQueryCriteriaType> createBatchListQueryCriteria(BatchListQueryCriteriaType value) {
        return new JAXBElement<BatchListQueryCriteriaType>(_BatchListQueryCriteria_QNAME, BatchListQueryCriteriaType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:batchlistrequest", name = "IncludeFirmsBatchIndicator")
    public JAXBElement<Boolean> createIncludeFirmsBatchIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_IncludeFirmsBatchIndicator_QNAME, Boolean.class, null, value);
    }

}
