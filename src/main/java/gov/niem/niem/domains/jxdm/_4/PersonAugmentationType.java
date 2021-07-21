
package gov.niem.niem.domains.jxdm._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.BiometricType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.structures._2.AugmentationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PersonAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}PersonAFISIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}PersonFBIIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}PersonPalmPrint" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}PersonStateFingerprintIdentification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonAugmentationType", propOrder = {
    "personAFISIdentification",
    "personFBIIdentification",
    "personPalmPrint",
    "personStateFingerprintIdentification"
})
public class PersonAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "PersonAFISIdentification", nillable = true)
    protected IdentificationType personAFISIdentification;
    @XmlElement(name = "PersonFBIIdentification", nillable = true)
    protected IdentificationType personFBIIdentification;
    @XmlElement(name = "PersonPalmPrint", nillable = true)
    protected BiometricType personPalmPrint;
    @XmlElement(name = "PersonStateFingerprintIdentification", nillable = true)
    protected IdentificationType personStateFingerprintIdentification;

    /**
     * Gets the value of the personAFISIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getPersonAFISIdentification() {
        return personAFISIdentification;
    }

    /**
     * Sets the value of the personAFISIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setPersonAFISIdentification(IdentificationType value) {
        this.personAFISIdentification = value;
    }

    /**
     * Gets the value of the personFBIIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getPersonFBIIdentification() {
        return personFBIIdentification;
    }

    /**
     * Sets the value of the personFBIIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setPersonFBIIdentification(IdentificationType value) {
        this.personFBIIdentification = value;
    }

    /**
     * Gets the value of the personPalmPrint property.
     * 
     * @return
     *     possible object is
     *     {@link BiometricType }
     *     
     */
    public BiometricType getPersonPalmPrint() {
        return personPalmPrint;
    }

    /**
     * Sets the value of the personPalmPrint property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiometricType }
     *     
     */
    public void setPersonPalmPrint(BiometricType value) {
        this.personPalmPrint = value;
    }

    /**
     * Gets the value of the personStateFingerprintIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getPersonStateFingerprintIdentification() {
        return personStateFingerprintIdentification;
    }

    /**
     * Sets the value of the personStateFingerprintIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setPersonStateFingerprintIdentification(IdentificationType value) {
        this.personStateFingerprintIdentification = value;
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
