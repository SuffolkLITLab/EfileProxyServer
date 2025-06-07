
package ecf4.latest.gov.niem.niem.appinfo._2;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ecf4.latest.gov.niem.niem.appinfo._2 package. 
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

    private final static QName _ConformantIndicator_QNAME = new QName("http://niem.gov/niem/appinfo/2.0", "ConformantIndicator");
    private final static QName _ExternalAdapterTypeIndicator_QNAME = new QName("http://niem.gov/niem/appinfo/2.0", "ExternalAdapterTypeIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:ecf4.latest.gov.niem.niem.appinfo._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Resource }
     * 
     */
    public Resource createResource() {
        return new Resource();
    }

    /**
     * Create an instance of {@link Deprecated }
     * 
     */
    public Deprecated createDeprecated() {
        return new Deprecated();
    }

    /**
     * Create an instance of {@link Base }
     * 
     */
    public Base createBase() {
        return new Base();
    }

    /**
     * Create an instance of {@link ReferenceTarget }
     * 
     */
    public ReferenceTarget createReferenceTarget() {
        return new ReferenceTarget();
    }

    /**
     * Create an instance of {@link AppliesTo }
     * 
     */
    public AppliesTo createAppliesTo() {
        return new AppliesTo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/appinfo/2.0", name = "ConformantIndicator")
    public JAXBElement<Boolean> createConformantIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ConformantIndicator_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/appinfo/2.0", name = "ExternalAdapterTypeIndicator")
    public JAXBElement<Boolean> createExternalAdapterTypeIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_ExternalAdapterTypeIndicator_QNAME, Boolean.class, null, value);
    }

}
