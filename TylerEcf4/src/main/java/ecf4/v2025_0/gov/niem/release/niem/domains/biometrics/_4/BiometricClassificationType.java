
package ecf4.v2025_0.gov.niem.release.niem.domains.biometrics._4;

import ecf4.v2025_0.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for the classification of the kind of the Biometric information in the message.
 * 
 * <p>Java class for BiometricClassificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BiometricClassificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/biometrics/4.0/}BiometricClassificationCategoryCode"/&gt;
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
@XmlType(name = "BiometricClassificationType", propOrder = {
    "biometricClassificationCategoryCode"
})
public class BiometricClassificationType
    extends ObjectType
{

    @XmlElement(name = "BiometricClassificationCategoryCode", required = true)
    protected BiometricCategoryCodeType biometricClassificationCategoryCode;

    /**
     * Gets the value of the biometricClassificationCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link BiometricCategoryCodeType }
     *     
     */
    public BiometricCategoryCodeType getBiometricClassificationCategoryCode() {
        return biometricClassificationCategoryCode;
    }

    /**
     * Sets the value of the biometricClassificationCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiometricCategoryCodeType }
     *     
     */
    public void setBiometricClassificationCategoryCode(BiometricCategoryCodeType value) {
        this.biometricClassificationCategoryCode = value;
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
