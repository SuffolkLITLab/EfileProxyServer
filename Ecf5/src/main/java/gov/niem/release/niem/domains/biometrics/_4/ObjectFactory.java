
package gov.niem.release.niem.domains.biometrics._4;

import javax.xml.namespace.QName;
import gov.niem.release.niem.niem_core._4.EntityType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.niem.release.niem.domains.biometrics._4 package. 
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

    private final static QName _Biometric_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "Biometric");
    private final static QName _BiometricCapturer_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "BiometricCapturer");
    private final static QName _BiometricClassification_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "BiometricClassification");
    private final static QName _BiometricClassificationCategoryCode_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "BiometricClassificationCategoryCode");
    private final static QName _BiometricDetailAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "BiometricDetailAbstract");
    private final static QName _BiometricImageAbstract_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "BiometricImageAbstract");
    private final static QName _DNAAlleleCall1Text_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "DNAAlleleCall1Text");
    private final static QName _DNAElectropherogramScreenshotImage_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "DNAElectropherogramScreenshotImage");
    private final static QName _DNALocusIdentification_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "DNALocusIdentification");
    private final static QName _DNASTRProfile_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "DNASTRProfile");
    private final static QName _DNASample_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "DNASample");
    private final static QName _FingerprintImage_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "FingerprintImage");
    private final static QName _PhysicalFeatureImage_QNAME = new QName("http://release.niem.gov/niem/domains/biometrics/4.0/", "PhysicalFeatureImage");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.niem.release.niem.domains.biometrics._4
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BiometricDataType }
     * 
     */
    public BiometricDataType createBiometricDataType() {
        return new BiometricDataType();
    }

    /**
     * Create an instance of {@link BiometricClassificationType }
     * 
     */
    public BiometricClassificationType createBiometricClassificationType() {
        return new BiometricClassificationType();
    }

    /**
     * Create an instance of {@link BiometricCategoryCodeType }
     * 
     */
    public BiometricCategoryCodeType createBiometricCategoryCodeType() {
        return new BiometricCategoryCodeType();
    }

    /**
     * Create an instance of {@link ImageType }
     * 
     */
    public ImageType createImageType() {
        return new ImageType();
    }

    /**
     * Create an instance of {@link DNASTRProfileType }
     * 
     */
    public DNASTRProfileType createDNASTRProfileType() {
        return new DNASTRProfileType();
    }

    /**
     * Create an instance of {@link DNASampleType }
     * 
     */
    public DNASampleType createDNASampleType() {
        return new DNASampleType();
    }

    /**
     * Create an instance of {@link FingerprintImageType }
     * 
     */
    public FingerprintImageType createFingerprintImageType() {
        return new FingerprintImageType();
    }

    /**
     * Create an instance of {@link PhysicalFeatureImageType }
     * 
     */
    public PhysicalFeatureImageType createPhysicalFeatureImageType() {
        return new PhysicalFeatureImageType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BiometricDataType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BiometricDataType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "Biometric")
    public JAXBElement<BiometricDataType> createBiometric(BiometricDataType value) {
        return new JAXBElement<BiometricDataType>(_Biometric_QNAME, BiometricDataType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "BiometricCapturer")
    public JAXBElement<EntityType> createBiometricCapturer(EntityType value) {
        return new JAXBElement<EntityType>(_BiometricCapturer_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BiometricClassificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BiometricClassificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "BiometricClassification")
    public JAXBElement<BiometricClassificationType> createBiometricClassification(BiometricClassificationType value) {
        return new JAXBElement<BiometricClassificationType>(_BiometricClassification_QNAME, BiometricClassificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BiometricCategoryCodeType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BiometricCategoryCodeType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "BiometricClassificationCategoryCode")
    public JAXBElement<BiometricCategoryCodeType> createBiometricClassificationCategoryCode(BiometricCategoryCodeType value) {
        return new JAXBElement<BiometricCategoryCodeType>(_BiometricClassificationCategoryCode_QNAME, BiometricCategoryCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "BiometricDetailAbstract")
    public JAXBElement<Object> createBiometricDetailAbstract(Object value) {
        return new JAXBElement<Object>(_BiometricDetailAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "BiometricImageAbstract")
    public JAXBElement<Object> createBiometricImageAbstract(Object value) {
        return new JAXBElement<Object>(_BiometricImageAbstract_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "DNAAlleleCall1Text")
    public JAXBElement<TextType> createDNAAlleleCall1Text(TextType value) {
        return new JAXBElement<TextType>(_DNAAlleleCall1Text_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "DNAElectropherogramScreenshotImage", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", substitutionHeadName = "BiometricImageAbstract")
    public JAXBElement<ImageType> createDNAElectropherogramScreenshotImage(ImageType value) {
        return new JAXBElement<ImageType>(_DNAElectropherogramScreenshotImage_QNAME, ImageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "DNALocusIdentification")
    public JAXBElement<IdentificationType> createDNALocusIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_DNALocusIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DNASTRProfileType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DNASTRProfileType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "DNASTRProfile")
    public JAXBElement<DNASTRProfileType> createDNASTRProfile(DNASTRProfileType value) {
        return new JAXBElement<DNASTRProfileType>(_DNASTRProfile_QNAME, DNASTRProfileType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DNASampleType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DNASampleType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "DNASample", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", substitutionHeadName = "BiometricDetailAbstract")
    public JAXBElement<DNASampleType> createDNASample(DNASampleType value) {
        return new JAXBElement<DNASampleType>(_DNASample_QNAME, DNASampleType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FingerprintImageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link FingerprintImageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "FingerprintImage", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", substitutionHeadName = "BiometricImageAbstract")
    public JAXBElement<FingerprintImageType> createFingerprintImage(FingerprintImageType value) {
        return new JAXBElement<FingerprintImageType>(_FingerprintImage_QNAME, FingerprintImageType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PhysicalFeatureImageType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PhysicalFeatureImageType }{@code >}
     */
    @XmlElementDecl(namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", name = "PhysicalFeatureImage", substitutionHeadNamespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", substitutionHeadName = "BiometricImageAbstract")
    public JAXBElement<PhysicalFeatureImageType> createPhysicalFeatureImage(PhysicalFeatureImageType value) {
        return new JAXBElement<PhysicalFeatureImageType>(_PhysicalFeatureImage_QNAME, PhysicalFeatureImageType.class, null, value);
    }

}
