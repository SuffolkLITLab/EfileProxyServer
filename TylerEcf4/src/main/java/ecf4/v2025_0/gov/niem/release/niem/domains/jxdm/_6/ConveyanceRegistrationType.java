
package ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6;

import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a registration of a conveyance with an authority.
 * 
 * <p>Java class for ConveyanceRegistrationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConveyanceRegistrationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/jxdm/6.0/}ItemRegistrationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ConveyanceRegistrationPlateIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}ConveyanceRegistrationPlateCategoryAbstract" minOccurs="0"/&gt;
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
@XmlType(name = "ConveyanceRegistrationType", propOrder = {
    "conveyanceRegistrationPlateIdentification",
    "conveyanceRegistrationPlateCategoryAbstract"
})
public class ConveyanceRegistrationType
    extends ItemRegistrationType
{

    @XmlElement(name = "ConveyanceRegistrationPlateIdentification")
    protected IdentificationType conveyanceRegistrationPlateIdentification;
    @XmlElementRef(name = "ConveyanceRegistrationPlateCategoryAbstract", namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> conveyanceRegistrationPlateCategoryAbstract;

    /**
     * Gets the value of the conveyanceRegistrationPlateIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getConveyanceRegistrationPlateIdentification() {
        return conveyanceRegistrationPlateIdentification;
    }

    /**
     * Sets the value of the conveyanceRegistrationPlateIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setConveyanceRegistrationPlateIdentification(IdentificationType value) {
        this.conveyanceRegistrationPlateIdentification = value;
    }

    /**
     * Gets the value of the conveyanceRegistrationPlateCategoryAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getConveyanceRegistrationPlateCategoryAbstract() {
        return conveyanceRegistrationPlateCategoryAbstract;
    }

    /**
     * Sets the value of the conveyanceRegistrationPlateCategoryAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setConveyanceRegistrationPlateCategoryAbstract(JAXBElement<?> value) {
        this.conveyanceRegistrationPlateCategoryAbstract = value;
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
