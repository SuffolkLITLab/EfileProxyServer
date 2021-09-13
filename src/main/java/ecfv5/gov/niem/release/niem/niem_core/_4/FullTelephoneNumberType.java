
package ecfv5.gov.niem.release.niem.niem_core._4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a full telephone number.
 * 
 * <p>Java class for FullTelephoneNumberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FullTelephoneNumberType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}TelephoneNumberFullID" minOccurs="0"/&gt;
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
@XmlType(name = "FullTelephoneNumberType", propOrder = {
    "telephoneNumberFullID",
    "telephoneSuffixID"
})
public class FullTelephoneNumberType
    extends ObjectType
{

    @XmlElement(name = "TelephoneNumberFullID")
    protected ecfv5.gov.niem.release.niem.proxy.xsd._4.String telephoneNumberFullID;
    @XmlElement(name = "TelephoneSuffixID")
    protected ecfv5.gov.niem.release.niem.proxy.xsd._4.String telephoneSuffixID;

    /**
     * Gets the value of the telephoneNumberFullID property.
     * 
     * @return
     *     possible object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecfv5.gov.niem.release.niem.proxy.xsd._4.String getTelephoneNumberFullID() {
        return telephoneNumberFullID;
    }

    /**
     * Sets the value of the telephoneNumberFullID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setTelephoneNumberFullID(ecfv5.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.telephoneNumberFullID = value;
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
