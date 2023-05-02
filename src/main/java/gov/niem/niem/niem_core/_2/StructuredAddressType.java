
package gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.fips_10_4._2.CountryCodeType;
import gov.niem.niem.fips_6_4._2.USCountyCodeType;
import gov.niem.niem.structures._2.ComplexObjectType;
import gov.niem.niem.usps_states._2.USStateCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for StructuredAddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StructuredAddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}AddressRecipientName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}AddressDeliveryPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}LocationCityName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}LocationCounty" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}LocationState" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}LocationCountry" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}LocationPostalCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}LocationPostalExtensionCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredAddressType", propOrder = {
    "addressRecipientName",
    "addressDeliveryPoint",
    "locationCityName",
    "locationCounty",
    "locationState",
    "locationCountry",
    "locationPostalCode",
    "locationPostalExtensionCode"
})
public class StructuredAddressType
    extends ComplexObjectType
{

    @XmlElement(name = "AddressRecipientName", nillable = true)
    protected TextType addressRecipientName;
    @XmlElementRef(name = "AddressDeliveryPoint", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> addressDeliveryPoint;
    @XmlElement(name = "LocationCityName", nillable = true)
    protected ProperNameTextType locationCityName;
    @XmlElementRef(name = "LocationCounty", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> locationCounty;
    @XmlElementRef(name = "LocationState", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> locationState;
    @XmlElementRef(name = "LocationCountry", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> locationCountry;
    @XmlElement(name = "LocationPostalCode", nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String locationPostalCode;
    @XmlElement(name = "LocationPostalExtensionCode", nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String locationPostalExtensionCode;

    /**
     * Gets the value of the addressRecipientName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAddressRecipientName() {
        return addressRecipientName;
    }

    /**
     * Sets the value of the addressRecipientName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAddressRecipientName(TextType value) {
        this.addressRecipientName = value;
    }

    /**
     * Gets the value of the addressDeliveryPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressDeliveryPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressDeliveryPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link StreetType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link gov.niem.niem.proxy.xsd._2.String }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getAddressDeliveryPoint() {
        if (addressDeliveryPoint == null) {
            addressDeliveryPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.addressDeliveryPoint;
    }

    /**
     * Gets the value of the locationCityName property.
     * 
     * @return
     *     possible object is
     *     {@link ProperNameTextType }
     *     
     */
    public ProperNameTextType getLocationCityName() {
        return locationCityName;
    }

    /**
     * Sets the value of the locationCityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProperNameTextType }
     *     
     */
    public void setLocationCityName(ProperNameTextType value) {
        this.locationCityName = value;
    }

    /**
     * Gets the value of the locationCounty property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link USCountyCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getLocationCounty() {
        return locationCounty;
    }

    /**
     * Sets the value of the locationCounty property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link USCountyCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setLocationCounty(JAXBElement<?> value) {
        this.locationCounty = value;
    }

    /**
     * Gets the value of the locationState property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link USStateCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getLocationState() {
        return locationState;
    }

    /**
     * Sets the value of the locationState property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link USStateCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setLocationState(JAXBElement<?> value) {
        this.locationState = value;
    }

    /**
     * Gets the value of the locationCountry property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getLocationCountry() {
        return locationCountry;
    }

    /**
     * Sets the value of the locationCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setLocationCountry(JAXBElement<?> value) {
        this.locationCountry = value;
    }

    /**
     * Gets the value of the locationPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getLocationPostalCode() {
        return locationPostalCode;
    }

    /**
     * Sets the value of the locationPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setLocationPostalCode(gov.niem.niem.proxy.xsd._2.String value) {
        this.locationPostalCode = value;
    }

    /**
     * Gets the value of the locationPostalExtensionCode property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getLocationPostalExtensionCode() {
        return locationPostalExtensionCode;
    }

    /**
     * Sets the value of the locationPostalExtensionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setLocationPostalExtensionCode(gov.niem.niem.proxy.xsd._2.String value) {
        this.locationPostalExtensionCode = value;
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
