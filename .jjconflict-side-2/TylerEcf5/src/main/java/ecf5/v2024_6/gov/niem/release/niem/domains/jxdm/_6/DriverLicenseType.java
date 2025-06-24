
package ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6;

import ecf5.v2024_6.gov.niem.release.niem.codes.aamva_d20._4.DriverLicenseClassCodeType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a license issued to a person granting driving privileges.
 * 
 * <p>Java class for DriverLicenseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DriverLicenseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/jxdm/6.1/}DriverLicenseBaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DriverLicenseCommercialClassAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DriverLicenseWithdrawal" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}DriverLicenseRestriction" minOccurs="0"/&gt;
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
@XmlType(name = "DriverLicenseType", propOrder = {
    "driverLicenseCommercialClassAbstract",
    "driverLicenseWithdrawal",
    "driverLicenseRestriction"
})
public class DriverLicenseType
    extends DriverLicenseBaseType
{

    @XmlElementRef(name = "DriverLicenseCommercialClassAbstract", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> driverLicenseCommercialClassAbstract;
    @XmlElement(name = "DriverLicenseWithdrawal")
    protected DriverLicenseWithdrawalType driverLicenseWithdrawal;
    @XmlElement(name = "DriverLicenseRestriction")
    protected DriverLicenseRestrictionType driverLicenseRestriction;

    /**
     * Gets the value of the driverLicenseCommercialClassAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DriverLicenseClassCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDriverLicenseCommercialClassAbstract() {
        return driverLicenseCommercialClassAbstract;
    }

    /**
     * Sets the value of the driverLicenseCommercialClassAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DriverLicenseClassCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDriverLicenseCommercialClassAbstract(JAXBElement<?> value) {
        this.driverLicenseCommercialClassAbstract = value;
    }

    /**
     * Gets the value of the driverLicenseWithdrawal property.
     * 
     * @return
     *     possible object is
     *     {@link DriverLicenseWithdrawalType }
     *     
     */
    public DriverLicenseWithdrawalType getDriverLicenseWithdrawal() {
        return driverLicenseWithdrawal;
    }

    /**
     * Sets the value of the driverLicenseWithdrawal property.
     * 
     * @param value
     *     allowed object is
     *     {@link DriverLicenseWithdrawalType }
     *     
     */
    public void setDriverLicenseWithdrawal(DriverLicenseWithdrawalType value) {
        this.driverLicenseWithdrawal = value;
    }

    /**
     * Gets the value of the driverLicenseRestriction property.
     * 
     * @return
     *     possible object is
     *     {@link DriverLicenseRestrictionType }
     *     
     */
    public DriverLicenseRestrictionType getDriverLicenseRestriction() {
        return driverLicenseRestriction;
    }

    /**
     * Sets the value of the driverLicenseRestriction property.
     * 
     * @param value
     *     allowed object is
     *     {@link DriverLicenseRestrictionType }
     *     
     */
    public void setDriverLicenseRestriction(DriverLicenseRestrictionType value) {
        this.driverLicenseRestriction = value;
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
