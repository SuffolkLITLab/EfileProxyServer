
package ecf4.latest.gov.niem.release.niem.niem_core._4;

import ecf4.latest.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an international telephone number.
 * 
 * <p>Java class for InternationalTelephoneNumberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InternationalTelephoneNumberType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}TelephoneCountryCodeID"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}TelephoneNumberID"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}TelephoneSuffixID" minOccurs="0"/&gt;
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
@XmlType(name = "InternationalTelephoneNumberType", propOrder = {
    "telephoneCountryCodeID",
    "telephoneNumberID",
    "telephoneSuffixID"
})
public class InternationalTelephoneNumberType
    extends ObjectType
{

    @XmlElement(name = "TelephoneCountryCodeID", required = true)
    protected ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String telephoneCountryCodeID;
    @XmlElement(name = "TelephoneNumberID", required = true)
    protected ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String telephoneNumberID;
    @XmlElement(name = "TelephoneSuffixID")
    protected ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String telephoneSuffixID;

    /**
     * Gets the value of the telephoneCountryCodeID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String getTelephoneCountryCodeID() {
        return telephoneCountryCodeID;
    }

    /**
     * Sets the value of the telephoneCountryCodeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setTelephoneCountryCodeID(ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.telephoneCountryCodeID = value;
    }

    /**
     * Gets the value of the telephoneNumberID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String getTelephoneNumberID() {
        return telephoneNumberID;
    }

    /**
     * Sets the value of the telephoneNumberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setTelephoneNumberID(ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.telephoneNumberID = value;
    }

    /**
     * Gets the value of the telephoneSuffixID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String getTelephoneSuffixID() {
        return telephoneSuffixID;
    }

    /**
     * Sets the value of the telephoneSuffixID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setTelephoneSuffixID(ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String value) {
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
