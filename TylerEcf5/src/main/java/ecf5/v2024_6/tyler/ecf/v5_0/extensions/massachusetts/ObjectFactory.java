
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.massachusetts;

import javax.xml.namespace.QName;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf5.v2024_6.tyler.ecf.v5_0.extensions.massachusetts package. 
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

    private final static QName _Component1_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:massachusetts", "Component1");
    private final static QName _Component2_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:massachusetts", "Component2");
    private final static QName _Component3_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:massachusetts", "Component3");
    private final static QName _IsCaseParty_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:massachusetts", "IsCaseParty");
    private final static QName _CaseAugmentation_QNAME = new QName("urn:tyler:ecf:v5.0:extensions:massachusetts", "CaseAugmentation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ecf5.v2024_6.tyler.ecf.v5_0.extensions.massachusetts
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
     * Create an instance of {@link CaseAugmentationType }
     * 
     */
    public CaseAugmentationType createCaseAugmentationType() {
        return new CaseAugmentationType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Component1Type }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Component1Type }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:massachusetts", name = "Component1")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:massachusetts", name = "Component2")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:massachusetts", name = "Component3")
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
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:massachusetts", name = "IsCaseParty")
    public JAXBElement<Boolean> createIsCaseParty(Boolean value) {
        return new JAXBElement<Boolean>(_IsCaseParty_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CaseAugmentationType }{@code >}
     */
    @XmlElementDecl(namespace = "urn:tyler:ecf:v5.0:extensions:massachusetts", name = "CaseAugmentation", substitutionHeadNamespace = "http://release.niem.gov/niem/niem-core/4.0/", substitutionHeadName = "CaseAugmentationPoint")
    public JAXBElement<CaseAugmentationType> createCaseAugmentation(CaseAugmentationType value) {
        return new JAXBElement<CaseAugmentationType>(_CaseAugmentation_QNAME, CaseAugmentationType.class, null, value);
    }

}
