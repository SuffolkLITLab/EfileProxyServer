
package ecf4.latest.gov.niem.release.niem.niem_core._4;

import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
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
 * A data type for a representation of an identity.
 * 
 * <p>Java class for IdentificationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IdentificationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}IdentificationID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}IdentificationJurisdiction" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}IdentificationCategoryAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}IdentificationSourceText" minOccurs="0"/&gt;
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
@XmlType(name = "IdentificationType", propOrder = {
    "identificationID",
    "identificationJurisdiction",
    "identificationCategoryAbstract",
    "identificationSourceText"
})
public class IdentificationType
    extends ObjectType
{

    @XmlElement(name = "IdentificationID")
    protected ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String identificationID;
    @XmlElement(name = "IdentificationJurisdiction")
    protected JurisdictionType identificationJurisdiction;
    @XmlElementRef(name = "IdentificationCategoryAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> identificationCategoryAbstract;
    @XmlElement(name = "IdentificationSourceText")
    protected TextType identificationSourceText;

    /**
     * Gets the value of the identificationID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String getIdentificationID() {
        return identificationID;
    }

    /**
     * Sets the value of the identificationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setIdentificationID(ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.identificationID = value;
    }

    /**
     * Gets the value of the identificationJurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link JurisdictionType }
     *     
     */
    public JurisdictionType getIdentificationJurisdiction() {
        return identificationJurisdiction;
    }

    /**
     * Sets the value of the identificationJurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link JurisdictionType }
     *     
     */
    public void setIdentificationJurisdiction(JurisdictionType value) {
        this.identificationJurisdiction = value;
    }

    /**
     * Gets the value of the identificationCategoryAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getIdentificationCategoryAbstract() {
        return identificationCategoryAbstract;
    }

    /**
     * Sets the value of the identificationCategoryAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link NormalizedString }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setIdentificationCategoryAbstract(JAXBElement<?> value) {
        this.identificationCategoryAbstract = value;
    }

    /**
     * Gets the value of the identificationSourceText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getIdentificationSourceText() {
        return identificationSourceText;
    }

    /**
     * Sets the value of the identificationSourceText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setIdentificationSourceText(TextType value) {
        this.identificationSourceText = value;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
