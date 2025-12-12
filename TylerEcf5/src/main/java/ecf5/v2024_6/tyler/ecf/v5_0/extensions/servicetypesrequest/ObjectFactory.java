
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.servicetypesrequest;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.servicetypesrequest package. 
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

    private final static QName _GetServiceTypesMessage_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicetypesrequest", "GetServiceTypesMessage");
    private final static QName _GetServiceTypesMessageAugmentationPoint_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:servicetypesrequest", "GetServiceTypesMessageAugmentationPoint");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.servicetypesrequest
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetServiceTypesMessageType }
     * 
     */
    public GetServiceTypesMessageType createGetServiceTypesMessageType() {
        return new GetServiceTypesMessageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceTypesMessageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetServiceTypesMessageType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesrequest", name = "GetServiceTypesMessage")
    public JAXBElement<GetServiceTypesMessageType> createGetServiceTypesMessage(GetServiceTypesMessageType value) {
        return new JAXBElement<GetServiceTypesMessageType>(_GetServiceTypesMessage_QNAME, GetServiceTypesMessageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:servicetypesrequest", name = "GetServiceTypesMessageAugmentationPoint")
    public JAXBElement<Object> createGetServiceTypesMessageAugmentationPoint(Object value) {
        return new JAXBElement<Object>(_GetServiceTypesMessageAugmentationPoint_QNAME, Object.class, null, value);
    }

}
