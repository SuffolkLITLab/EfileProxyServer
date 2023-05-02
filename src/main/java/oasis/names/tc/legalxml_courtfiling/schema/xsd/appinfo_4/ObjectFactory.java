
package oasis.names.tc.legalxml_courtfiling.schema.xsd.appinfo_4;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the oasis.names.tc.legalxml_courtfiling.schema.xsd.appinfo_4 package. 
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

    private final static QName _CourtPolicyDefinedCodeIndicator_QNAME = new QName("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppInfo-4.0", "CourtPolicyDefinedCodeIndicator");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: oasis.names.tc.legalxml_courtfiling.schema.xsd.appinfo_4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CodeListReference }
     * 
     */
    public CodeListReference createCodeListReference() {
        return new CodeListReference();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppInfo-4.0", name = "CourtPolicyDefinedCodeIndicator")
    public JAXBElement<Boolean> createCourtPolicyDefinedCodeIndicator(Boolean value) {
        return new JAXBElement<Boolean>(_CourtPolicyDefinedCodeIndicator_QNAME, Boolean.class, null, value);
    }

}
