
package ecf5.v2024_6.gov.niem.release.niem.niem_core._4;

import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a geophysical location described by postal information.
 * 
 * <p>Java class for AddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AddressType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}AddressFullText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}AddressDeliveryPointAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}AddressRecipientName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}LocationCityName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}LocationCountyAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}LocationState" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}LocationCountry" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}LocationPostalCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}LocationPostalExtensionCode" minOccurs="0"/&gt;
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
@XmlType(name = "AddressType", propOrder = {
    "addressFullText",
    "addressDeliveryPointAbstract",
    "addressRecipientName",
    "locationCityName",
    "locationCountyAbstract",
    "locationState",
    "locationCountry",
    "locationPostalCode",
    "locationPostalExtensionCode"
})
public class AddressType
    extends ObjectType
{

    @XmlElement(name = "AddressFullText")
    protected TextType addressFullText;
    @XmlElementRef(name = "AddressDeliveryPointAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> addressDeliveryPointAbstract;
    @XmlElement(name = "AddressRecipientName")
    protected TextType addressRecipientName;
    @XmlElement(name = "LocationCityName")
    protected ProperNameTextType locationCityName;
    @XmlElementRef(name = "LocationCountyAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> locationCountyAbstract;
    @XmlElement(name = "LocationState")
    protected StateType locationState;
    @XmlElement(name = "LocationCountry")
    protected CountryType locationCountry;
    @XmlElement(name = "LocationPostalCode")
    protected ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String locationPostalCode;
    @XmlElement(name = "LocationPostalExtensionCode")
    protected ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String locationPostalExtensionCode;

    /**
     * Gets the value of the addressFullText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAddressFullText() {
        return addressFullText;
    }

    /**
     * Sets the value of the addressFullText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAddressFullText(TextType value) {
        this.addressFullText = value;
    }

    /**
     * Gets the value of the addressDeliveryPointAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StreetType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getAddressDeliveryPointAbstract() {
        return addressDeliveryPointAbstract;
    }

    /**
     * Sets the value of the addressDeliveryPointAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StreetType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setAddressDeliveryPointAbstract(JAXBElement<?> value) {
        this.addressDeliveryPointAbstract = value;
    }

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
     * Gets the value of the locationCountyAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getLocationCountyAbstract() {
        return locationCountyAbstract;
    }

    /**
     * Sets the value of the locationCountyAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setLocationCountyAbstract(JAXBElement<?> value) {
        this.locationCountyAbstract = value;
    }

    /**
     * Gets the value of the locationState property.
     * 
     * @return
     *     possible object is
     *     {@link StateType }
     *     
     */
    public StateType getLocationState() {
        return locationState;
    }

    /**
     * Sets the value of the locationState property.
     * 
     * @param value
     *     allowed object is
     *     {@link StateType }
     *     
     */
    public void setLocationState(StateType value) {
        this.locationState = value;
    }

    /**
     * Gets the value of the locationCountry property.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getLocationCountry() {
        return locationCountry;
    }

    /**
     * Sets the value of the locationCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setLocationCountry(CountryType value) {
        this.locationCountry = value;
    }

    /**
     * Gets the value of the locationPostalCode property.
     * 
     * @return
     *     possible object is
     *     {@link ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String getLocationPostalCode() {
        return locationPostalCode;
    }

    /**
     * Sets the value of the locationPostalCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setLocationPostalCode(ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.locationPostalCode = value;
    }

    /**
     * Gets the value of the locationPostalExtensionCode property.
     * 
     * @return
     *     possible object is
     *     {@link ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String getLocationPostalExtensionCode() {
        return locationPostalExtensionCode;
    }

    /**
     * Sets the value of the locationPostalExtensionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setLocationPostalExtensionCode(ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.String value) {
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
