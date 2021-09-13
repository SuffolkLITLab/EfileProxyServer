
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.domains.biometrics._4.BiometricDataType;
import ecfv5.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecfv5.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecfv5.gov.niem.release.niem.structures._4.AugmentationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * An augmentation type
 * 
 * <p>Java class for SubjectAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubjectAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/biometrics/4.0/}Biometric" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}SubjectWarrantIssuedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}RapSheetTransactionControlIdentification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubjectAugmentationType", propOrder = {
    "biometric",
    "subjectWarrantIssuedIndicator",
    "rapSheetTransactionControlIdentification"
})
public class SubjectAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "Biometric", namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/")
    protected BiometricDataType biometric;
    @XmlElement(name = "SubjectWarrantIssuedIndicator")
    protected Boolean subjectWarrantIssuedIndicator;
    @XmlElement(name = "RapSheetTransactionControlIdentification", namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/")
    protected IdentificationType rapSheetTransactionControlIdentification;

    /**
     * Gets the value of the biometric property.
     * 
     * @return
     *     possible object is
     *     {@link BiometricDataType }
     *     
     */
    public BiometricDataType getBiometric() {
        return biometric;
    }

    /**
     * Sets the value of the biometric property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiometricDataType }
     *     
     */
    public void setBiometric(BiometricDataType value) {
        this.biometric = value;
    }

    /**
     * Gets the value of the subjectWarrantIssuedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getSubjectWarrantIssuedIndicator() {
        return subjectWarrantIssuedIndicator;
    }

    /**
     * Sets the value of the subjectWarrantIssuedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSubjectWarrantIssuedIndicator(Boolean value) {
        this.subjectWarrantIssuedIndicator = value;
    }

    /**
     * Gets the value of the rapSheetTransactionControlIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getRapSheetTransactionControlIdentification() {
        return rapSheetTransactionControlIdentification;
    }

    /**
     * Sets the value of the rapSheetTransactionControlIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setRapSheetTransactionControlIdentification(IdentificationType value) {
        this.rapSheetTransactionControlIdentification = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
