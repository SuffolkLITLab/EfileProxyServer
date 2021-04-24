
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for FullTelephoneNumberType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="FullTelephoneNumberType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}TelephoneNumberFullID"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}TelephoneSuffixID" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FullTelephoneNumberType", propOrder = {
    "telephoneNumberFullID",
    "telephoneSuffixID"
})
public class FullTelephoneNumberType
    extends ComplexObjectType
{

    @XmlElement(name = "TelephoneNumberFullID", required = true, nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String telephoneNumberFullID;
    @XmlElement(name = "TelephoneSuffixID", nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String telephoneSuffixID;

    /**
     * Gets the value of the telephoneNumberFullID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getTelephoneNumberFullID() {
        return telephoneNumberFullID;
    }

    /**
     * Sets the value of the telephoneNumberFullID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setTelephoneNumberFullID(gov.niem.niem.proxy.xsd._2.String value) {
        this.telephoneNumberFullID = value;
    }

    /**
     * Gets the value of the telephoneSuffixID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getTelephoneSuffixID() {
        return telephoneSuffixID;
    }

    /**
     * Sets the value of the telephoneSuffixID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setTelephoneSuffixID(gov.niem.niem.proxy.xsd._2.String value) {
        this.telephoneSuffixID = value;
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
