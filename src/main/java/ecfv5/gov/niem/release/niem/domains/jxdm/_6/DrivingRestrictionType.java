
package ecfv5.gov.niem.release.niem.domains.jxdm._6;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.codes.mmucc._4.DrivingRestrictionCodeType;
import ecfv5.gov.niem.release.niem.niem_core._4.DateType;
import ecfv5.gov.niem.release.niem.niem_core._4.TextType;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a restriction applicable to a driver permit or license.
 * 
 * <p>Java class for DrivingRestrictionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DrivingRestrictionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}DrivingRestrictionAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}DrivingRestrictionEndDate" minOccurs="0"/&gt;
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
@XmlType(name = "DrivingRestrictionType", propOrder = {
    "drivingRestrictionAbstract",
    "drivingRestrictionEndDate"
})
@XmlSeeAlso({
    DriverLicenseRestrictionType.class
})
public class DrivingRestrictionType
    extends ObjectType
{

    @XmlElementRef(name = "DrivingRestrictionAbstract", namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> drivingRestrictionAbstract;
    @XmlElement(name = "DrivingRestrictionEndDate")
    protected DateType drivingRestrictionEndDate;

    /**
     * Gets the value of the drivingRestrictionAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DrivingRestrictionCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDrivingRestrictionAbstract() {
        return drivingRestrictionAbstract;
    }

    /**
     * Sets the value of the drivingRestrictionAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DrivingRestrictionCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDrivingRestrictionAbstract(JAXBElement<?> value) {
        this.drivingRestrictionAbstract = value;
    }

    /**
     * Gets the value of the drivingRestrictionEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDrivingRestrictionEndDate() {
        return drivingRestrictionEndDate;
    }

    /**
     * Sets the value of the drivingRestrictionEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDrivingRestrictionEndDate(DateType value) {
        this.drivingRestrictionEndDate = value;
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
