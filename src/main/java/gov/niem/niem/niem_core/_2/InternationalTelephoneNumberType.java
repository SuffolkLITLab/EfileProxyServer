
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for InternationalTelephoneNumberType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="InternationalTelephoneNumberType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}TelephoneCountryCodeID"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}TelephoneNumberID"/&amp;gt;
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
@XmlType(name = "InternationalTelephoneNumberType", propOrder = {
    "telephoneCountryCodeID",
    "telephoneNumberID",
    "telephoneSuffixID"
})
public class InternationalTelephoneNumberType
    extends ComplexObjectType
{

    @XmlElement(name = "TelephoneCountryCodeID", required = true, nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String telephoneCountryCodeID;
    @XmlElement(name = "TelephoneNumberID", required = true, nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String telephoneNumberID;
    @XmlElement(name = "TelephoneSuffixID", nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String telephoneSuffixID;

    /**
     * Gets the value of the telephoneCountryCodeID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getTelephoneCountryCodeID() {
        return telephoneCountryCodeID;
    }

    /**
     * Sets the value of the telephoneCountryCodeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setTelephoneCountryCodeID(gov.niem.niem.proxy.xsd._2.String value) {
        this.telephoneCountryCodeID = value;
    }

    /**
     * Gets the value of the telephoneNumberID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getTelephoneNumberID() {
        return telephoneNumberID;
    }

    /**
     * Sets the value of the telephoneNumberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setTelephoneNumberID(gov.niem.niem.proxy.xsd._2.String value) {
        this.telephoneNumberID = value;
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
