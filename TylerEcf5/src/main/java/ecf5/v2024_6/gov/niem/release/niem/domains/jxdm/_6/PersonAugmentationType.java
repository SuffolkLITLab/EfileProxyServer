
package ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for additional information about a person.
 * 
 * <p>Java class for PersonAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}PersonAFISIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}PersonFBIIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}PersonStateFingerprintIdentification" minOccurs="0"/&gt;
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
@XmlType(name = "PersonAugmentationType", propOrder = {
    "personAFISIdentification",
    "personFBIIdentification",
    "personStateFingerprintIdentification"
})
public class PersonAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "PersonAFISIdentification")
    protected IdentificationType personAFISIdentification;
    @XmlElement(name = "PersonFBIIdentification")
    protected IdentificationType personFBIIdentification;
    @XmlElement(name = "PersonStateFingerprintIdentification")
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
