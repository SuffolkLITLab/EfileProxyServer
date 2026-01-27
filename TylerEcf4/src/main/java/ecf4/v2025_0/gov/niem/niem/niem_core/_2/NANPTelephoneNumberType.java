
package ecf4.v2025_0.gov.niem.niem.niem_core._2;

import ecf4.v2025_0.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for NANPTelephoneNumberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NANPTelephoneNumberType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}TelephoneAreaCodeID"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}TelephoneExchangeID"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}TelephoneLineID"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}TelephoneSuffixID" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
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
    extends ComplexObjectType
{

    @XmlElement(name = "TelephoneAreaCodeID", required = true, nillable = true)
    protected ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String telephoneAreaCodeID;
    @XmlElement(name = "TelephoneExchangeID", required = true, nillable = true)
    protected ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String telephoneExchangeID;
    @XmlElement(name = "TelephoneLineID", required = true, nillable = true)
    protected ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String telephoneLineID;
    @XmlElement(name = "TelephoneSuffixID", nillable = true)
    protected ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String telephoneSuffixID;

    /**
     * Gets the value of the telephoneAreaCodeID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String getTelephoneAreaCodeID() {
        return telephoneAreaCodeID;
    }

    /**
     * Sets the value of the telephoneAreaCodeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setTelephoneAreaCodeID(ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String value) {
        this.telephoneAreaCodeID = value;
    }

    /**
     * Gets the value of the telephoneExchangeID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String getTelephoneExchangeID() {
        return telephoneExchangeID;
    }

    /**
     * Sets the value of the telephoneExchangeID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setTelephoneExchangeID(ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String value) {
        this.telephoneExchangeID = value;
    }

    /**
     * Gets the value of the telephoneLineID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String getTelephoneLineID() {
        return telephoneLineID;
    }

    /**
     * Sets the value of the telephoneLineID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setTelephoneLineID(ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String value) {
        this.telephoneLineID = value;
    }

    /**
     * Gets the value of the telephoneSuffixID property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String getTelephoneSuffixID() {
        return telephoneSuffixID;
    }

    /**
     * Sets the value of the telephoneSuffixID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setTelephoneSuffixID(ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.String value) {
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
