
package ecf4.latest.gov.niem.release.niem.domains.biometrics._4;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.release.niem.niem_core._4.EntityType;
import ecf4.latest.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a representation of the identifying Biometric in.
 * 
 * <p>Java class for BiometricDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BiometricDataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/biometrics/4.0/}BiometricClassification"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/biometrics/4.0/}BiometricDetailAbstract" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/biometrics/4.0/}BiometricImageAbstract" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/biometrics/4.0/}BiometricCapturer" minOccurs="0"/&gt;
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
@XmlType(name = "BiometricDataType", propOrder = {
    "biometricClassification",
    "biometricDetailAbstract",
    "biometricImageAbstract",
    "biometricCapturer"
})
public class BiometricDataType
    extends ObjectType
{

    @XmlElement(name = "BiometricClassification", required = true)
    protected BiometricClassificationType biometricClassification;
    @XmlElementRef(name = "BiometricDetailAbstract", namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> biometricDetailAbstract;
    @XmlElementRef(name = "BiometricImageAbstract", namespace = "http://release.niem.gov/niem/domains/biometrics/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> biometricImageAbstract;
    @XmlElement(name = "BiometricCapturer")
    protected EntityType biometricCapturer;

    /**
     * Gets the value of the biometricClassification property.
     * 
     * @return
     *     possible object is
     *     {@link BiometricClassificationType }
     *     
     */
    public BiometricClassificationType getBiometricClassification() {
        return biometricClassification;
    }

    /**
     * Sets the value of the biometricClassification property.
     * 
     * @param value
     *     allowed object is
     *     {@link BiometricClassificationType }
     *     
     */
    public void setBiometricClassification(BiometricClassificationType value) {
        this.biometricClassification = value;
    }

    /**
     * Gets the value of the biometricDetailAbstract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the biometricDetailAbstract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBiometricDetailAbstract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link DNASampleType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getBiometricDetailAbstract() {
        if (biometricDetailAbstract == null) {
            biometricDetailAbstract = new ArrayList<JAXBElement<?>>();
        }
        return this.biometricDetailAbstract;
    }

    /**
     * Gets the value of the biometricImageAbstract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the biometricImageAbstract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBiometricImageAbstract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link FingerprintImageType }{@code >}
     * {@link JAXBElement }{@code <}{@link ImageType }{@code >}
     * {@link JAXBElement }{@code <}{@link PhysicalFeatureImageType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getBiometricImageAbstract() {
        if (biometricImageAbstract == null) {
            biometricImageAbstract = new ArrayList<JAXBElement<?>>();
        }
        return this.biometricImageAbstract;
    }

    /**
     * Gets the value of the biometricCapturer property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getBiometricCapturer() {
        return biometricCapturer;
    }

    /**
     * Sets the value of the biometricCapturer property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setBiometricCapturer(EntityType value) {
        this.biometricCapturer = value;
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
