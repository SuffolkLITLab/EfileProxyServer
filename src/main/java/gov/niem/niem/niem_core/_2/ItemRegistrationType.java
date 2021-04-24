
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ItemRegistrationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ItemRegistrationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}RegistrationJurisdiction" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemRegistrationType", propOrder = {
    "registrationJurisdiction"
})
public class ItemRegistrationType
    extends ComplexObjectType
{

    @XmlElement(name = "RegistrationJurisdiction")
    protected Object registrationJurisdiction;

    /**
     * Gets the value of the registrationJurisdiction property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRegistrationJurisdiction() {
        return registrationJurisdiction;
    }

    /**
     * Sets the value of the registrationJurisdiction property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRegistrationJurisdiction(Object value) {
        this.registrationJurisdiction = value;
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
