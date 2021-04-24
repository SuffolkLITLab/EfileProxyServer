
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for TelephoneNumberType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="TelephoneNumberType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}TelephoneNumberRepresentation" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
     *     {@link JAXBElement }{@code <}{@link InternationalTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NANPTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FullTelephoneNumberType }{@code >}
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
     *     {@link JAXBElement }{@code <}{@link InternationalTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link NANPTelephoneNumberType }{@code >}
     *     {@link JAXBElement }{@code <}{@link FullTelephoneNumberType }{@code >}
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
