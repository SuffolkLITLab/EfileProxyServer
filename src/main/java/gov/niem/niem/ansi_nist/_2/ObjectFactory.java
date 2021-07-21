
package gov.niem.niem.ansi_nist._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.niem.niem.ansi_nist._2 package. 
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

    private final static QName _FingerPositionCode_QNAME = new QName("http://niem.gov/niem/ansi-nist/2.0", "FingerPositionCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.niem.niem.ansi_nist._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FingerprintType }
     * 
     */
    public FingerprintType createFingerprintType() {
        return new FingerprintType();
    }

    /**
     * Create an instance of {@link FPCCodeType }
     * 
     */
    public FPCCodeType createFPCCodeType() {
        return new FPCCodeType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FPCCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FPCCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/ansi-nist/2.0", name = "FingerPositionCode")
    public JAXBElement<FPCCodeType> createFingerPositionCode(FPCCodeType value) {
        return new JAXBElement<FPCCodeType>(_FingerPositionCode_QNAME, FPCCodeType.class, null, value);
    }

}
