
package ecf4.latest.tyler.ecf.extensions.massachusetts;

import javax.xml.namespace.QName;
import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tyler.ecf.extensions.massachusetts package. 
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

    private final static QName _Component1_QNAME = new QName("urn:tyler:ecf:extensions:Massachusetts", "Component1");
    private final static QName _Component2_QNAME = new QName("urn:tyler:ecf:extensions:Massachusetts", "Component2");
    private final static QName _Component3_QNAME = new QName("urn:tyler:ecf:extensions:Massachusetts", "Component3");
    private final static QName _PartyIndicator_QNAME = new QName("urn:tyler:ecf:extensions:Massachusetts", "PartyIndicator");
    private final static QName _RepresentativeCapacity_QNAME = new QName("urn:tyler:ecf:extensions:Massachusetts", "RepresentativeCapacity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tyler.ecf.extensions.massachusetts
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Component1Type }
     * 
     */
    public Component1Type createComponent1Type() {
        return new Component1Type();
    }

    /**
     * Create an instance of {@link Component2Type }
     * 
     */
    public Component2Type createComponent2Type() {
        return new Component2Type();
    }

    /**
     * Create an instance of {@link Component3Type }
     * 
     */
    public Component3Type createComponent3Type() {
        return new Component3Type();
    }

    /**
     * Create an instance of {@link RepresentativeCapacityType }
     * 
     */
    public RepresentativeCapacityType createRepresentativeCapacityType() {
        return new RepresentativeCapacityType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Component1Type }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Component1Type }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Massachusetts", name = "Component1")
    public JAXBElement<Component1Type> createComponent1(Component1Type value) {
        return new JAXBElement<Component1Type>(_Component1_QNAME, Component1Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Component2Type }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Component2Type }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Massachusetts", name = "Component2")
    public JAXBElement<Component2Type> createComponent2(Component2Type value) {
        return new JAXBElement<Component2Type>(_Component2_QNAME, Component2Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Component3Type }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Component3Type }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Massachusetts", name = "Component3")
    public JAXBElement<Component3Type> createComponent3(Component3Type value) {
        return new JAXBElement<Component3Type>(_Component3_QNAME, Component3Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Massachusetts", name = "PartyIndicator")
    public JAXBElement<Boolean> createPartyIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_PartyIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RepresentativeCapacityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RepresentativeCapacityType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:extensions:Massachusetts", name = "RepresentativeCapacity", substitutionHeadNamespace = "urn:tyler:ecf:extensions:Common", substitutionHeadName = "ExtendedData")
    public JAXBElement<RepresentativeCapacityType> createRepresentativeCapacity(RepresentativeCapacityType value) {
        return new JAXBElement<RepresentativeCapacityType>(_RepresentativeCapacity_QNAME, RepresentativeCapacityType.class, null, value);
    }

}
