
package ecfv5.gov.niem.release.niem.niem_core._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a North American Numbering Plan telephone number.
 * 
 * <p>Java class for NANPTelephoneNumberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NANPTelephoneNumberType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}TelephoneAreaCodeID"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}TelephoneExchangeID"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}TelephoneLineID"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}TelephoneSuffixID"/&gt;
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
@XmlType(name = "NANPTelephoneNumberType", propOrder = {
    "telephoneAreaCodeID",
    "telephoneExchangeID",
    "telephoneLineID",
    "telephoneSuffixID"
})
public class NANPTelephoneNumberType
    extends ObjectType
{

    @XmlElement(name = "TelephoneAreaCodeID", required = true)
    protected ecfv5.gov.niem.release.niem.proxy.xsd._4.String telephoneAreaCodeID;
    @XmlElement(name = "TelephoneExchangeID", required = true)
    protected ecfv5.gov.niem.release.niem.proxy.xsd._4.String telephoneExchangeID;
    @XmlElement(name = "TelephoneLineID", required = true)
    protected ecfv5.gov.niem.release.niem.proxy.xsd._4.String telephoneLineID;
    @XmlElement(name = "TelephoneSuffixID", required = true)
    protected ecfv5.gov.niem.release.niem.proxy.xsd._4.String telephoneSuffixID;

    /**
     * Gets the value of the telephoneAreaCodeID property.
     * 
     * @return
     *     possible object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecfv5.gov.niem.release.niem.proxy.xsd._4.String getTelephoneAreaCodeID() {
        return telephoneAreaCodeID;
    }

    /**
     * Sets the value of the telephoneAreaCodeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setTelephoneAreaCodeID(ecfv5.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.telephoneAreaCodeID = value;
    }

    /**
     * Gets the value of the telephoneExchangeID property.
     * 
     * @return
     *     possible object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecfv5.gov.niem.release.niem.proxy.xsd._4.String getTelephoneExchangeID() {
        return telephoneExchangeID;
    }

    /**
     * Sets the value of the telephoneExchangeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setTelephoneExchangeID(ecfv5.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.telephoneExchangeID = value;
    }

    /**
     * Gets the value of the telephoneLineID property.
     * 
     * @return
     *     possible object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecfv5.gov.niem.release.niem.proxy.xsd._4.String getTelephoneLineID() {
        return telephoneLineID;
    }

    /**
     * Sets the value of the telephoneLineID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setTelephoneLineID(ecfv5.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.telephoneLineID = value;
    }

    /**
     * Gets the value of the telephoneSuffixID property.
     * 
     * @return
     *     possible object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecfv5.gov.niem.release.niem.proxy.xsd._4.String getTelephoneSuffixID() {
        return telephoneSuffixID;
    }

    /**
     * Sets the value of the telephoneSuffixID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setTelephoneSuffixID(ecfv5.gov.niem.release.niem.proxy.xsd._4.String value) {
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
