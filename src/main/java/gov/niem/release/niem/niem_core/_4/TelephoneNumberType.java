
package gov.niem.release.niem.niem_core._4;

import gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a telephone number for a telecommunication device.
 * 
 * <p>Java class for TelephoneNumberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TelephoneNumberType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}TelephoneNumberAbstract" minOccurs="0"/&gt;
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
@XmlType(name = "TelephoneNumberType", propOrder = {
    "telephoneNumberAbstract"
})
public class TelephoneNumberType
    extends ObjectType
{

    @XmlElementRef(name = "TelephoneNumberAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> telephoneNumberAbstract;

    /**
     * Gets the value of the telephoneNumberAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FullTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link InternationalTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NANPTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getTelephoneNumberAbstract() {
        return telephoneNumberAbstract;
    }

    /**
     * Sets the value of the telephoneNumberAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FullTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link InternationalTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NANPTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setTelephoneNumberAbstract(JAXBElement<?> value) {
        this.telephoneNumberAbstract = value;
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
