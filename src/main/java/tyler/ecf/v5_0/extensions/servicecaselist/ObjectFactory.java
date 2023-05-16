
package tyler.ecf.v5_0.extensions.servicecaselist;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.v5_0.extensions.servicecaselist package. 
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

    private final static QName _GetServiceCaseListMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicecaselist", "GetServiceCaseListMessage");
    private final static QName _GetServiceCaseListMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicecaselist", "GetServiceCaseListMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.v5_0.extensions.servicecaselist
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServiceCaseListMessageType }
     * 
     */
    public GetServiceCaseListMessageType createGetServiceCaseListMessageType() {
        return new GetServiceCaseListMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceCaseListMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetServiceCaseListMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicecaselist", name = "GetServiceCaseListMessage")
    public JAXBElement<GetServiceCaseListMessageType> createGetServiceCaseListMessage(GetServiceCaseListMessageType value) {
        return new JAXBElement<GetServiceCaseListMessageType>(_GetServiceCaseListMessage_QNAME, GetServiceCaseListMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicecaselist", name = "GetServiceCaseListMessageAugmentationPoint")
    public JAXBElement<Object> createGetServiceCaseListMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetServiceCaseListMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
