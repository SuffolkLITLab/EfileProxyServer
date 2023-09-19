
package gov.niem.niem.niem_core._2;

import gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for TelephoneNumberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TelephoneNumberType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}TelephoneNumberRepresentation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TelephoneNumberType", propOrder = {
    "telephoneNumberRepresentation"
})
public class TelephoneNumberType
    extends ComplexObjectType
{

    @XmlElementRef(name = "TelephoneNumberRepresentation", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> telephoneNumberRepresentation;

    /**
     * Gets the value of the telephoneNumberRepresentation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FullTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link InternationalTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NANPTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getTelephoneNumberRepresentation() {
        return telephoneNumberRepresentation;
    }

    /**
     * Sets the value of the telephoneNumberRepresentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FullTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link InternationalTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NANPTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setTelephoneNumberRepresentation(JAXBElement<?> value) {
        this.telephoneNumberRepresentation = value;
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
