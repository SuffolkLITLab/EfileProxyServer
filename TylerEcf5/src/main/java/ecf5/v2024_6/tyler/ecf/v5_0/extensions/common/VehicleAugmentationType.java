
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.VehicleType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for VehicleAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PartyReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}VehicleTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RegistrationNumber" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RegistrationStateName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}CommercialVehicleIndicator"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HazardousLoadIndicator"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}AdditionalVehicle" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RegistrationDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}VehicleNumberAbstract" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HighOccupancyIndicator" minOccurs="0"/&gt;
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
@XmlType(name = "VehicleAugmentationType", propOrder = {
    "partyReference",
    "vehicleTypeCode",
    "registrationNumber",
    "registrationStateName",
    "commercialVehicleIndicator",
    "hazardousLoadIndicator",
    "additionalVehicle",
    "registrationDate",
    "vehicleNumberAbstract",
    "highOccupancyIndicator"
})
public class VehicleAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "PartyReference")
    protected ReferenceType partyReference;
    @XmlElement(name = "VehicleTypeCode")
    protected TextType vehicleTypeCode;
    @XmlElement(name = "RegistrationNumber")
    protected NormalizedString registrationNumber;
    @XmlElement(name = "RegistrationStateName")
    protected NormalizedString registrationStateName;
    @XmlElement(name = "CommercialVehicleIndicator", required = true)
    protected Boolean commercialVehicleIndicator;
    @XmlElement(name = "HazardousLoadIndicator", required = true)
    protected Boolean hazardousLoadIndicator;
    @XmlElement(name = "AdditionalVehicle")
    protected List<VehicleType> additionalVehicle;
    @XmlElement(name = "RegistrationDate")
    protected VehicleRegistrationDateType registrationDate;
    @XmlElementRef(name = "VehicleNumberAbstract", namespace = "urn:tyler:ecf:v5.0:extensions:common", type = JAXBElement.class, required = false)
    protected List<JAXBElement<TextType>> vehicleNumberAbstract;
    @XmlElement(name = "HighOccupancyIndicator")
    protected Boolean highOccupancyIndicator;

    /**
     * Gets the value of the partyReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getPartyReference() {
        return partyReference;
    }

    /**
     * Sets the value of the partyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setPartyReference(ReferenceType value) {
        this.partyReference = value;
    }

    /**
     * Gets the value of the vehicleTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getVehicleTypeCode() {
        return vehicleTypeCode;
    }

    /**
     * Sets the value of the vehicleTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setVehicleTypeCode(TextType value) {
        this.vehicleTypeCode = value;
    }

    /**
     * Gets the value of the registrationNumber property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Sets the value of the registrationNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setRegistrationNumber(NormalizedString value) {
        this.registrationNumber = value;
    }

    /**
     * Gets the value of the registrationStateName property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getRegistrationStateName() {
        return registrationStateName;
    }

    /**
     * Sets the value of the registrationStateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setRegistrationStateName(NormalizedString value) {
        this.registrationStateName = value;
    }

    /**
     * Gets the value of the commercialVehicleIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getCommercialVehicleIndicator() {
        return commercialVehicleIndicator;
    }

    /**
     * Sets the value of the commercialVehicleIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCommercialVehicleIndicator(Boolean value) {
        this.commercialVehicleIndicator = value;
    }

    /**
     * Gets the value of the hazardousLoadIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getHazardousLoadIndicator() {
        return hazardousLoadIndicator;
    }

    /**
     * Sets the value of the hazardousLoadIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHazardousLoadIndicator(Boolean value) {
        this.hazardousLoadIndicator = value;
    }

    /**
     * Gets the value of the additionalVehicle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the additionalVehicle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalVehicle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VehicleType }
     * 
     * 
     */
    public List<VehicleType> getAdditionalVehicle() {
        if (additionalVehicle == null) {
            additionalVehicle = new ArrayList<VehicleType>();
        }
        return this.additionalVehicle;
    }

    /**
     * Gets the value of the registrationDate property.
     * 
     * @return
     *     possible object is
     *     {@link VehicleRegistrationDateType }
     *     
     */
    public VehicleRegistrationDateType getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the value of the registrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleRegistrationDateType }
     *     
     */
    public void setRegistrationDate(VehicleRegistrationDateType value) {
        this.registrationDate = value;
    }

    /**
     * Gets the value of the vehicleNumberAbstract property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the vehicleNumberAbstract property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicleNumberAbstract().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * {@link JAXBElement }{@code <}{@link TextType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<TextType>> getVehicleNumberAbstract() {
        if (vehicleNumberAbstract == null) {
            vehicleNumberAbstract = new ArrayList<JAXBElement<TextType>>();
        }
        return this.vehicleNumberAbstract;
    }

    /**
     * Gets the value of the highOccupancyIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getHighOccupancyIndicator() {
        return highOccupancyIndicator;
    }

    /**
     * Sets the value of the highOccupancyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setHighOccupancyIndicator(Boolean value) {
        this.highOccupancyIndicator = value;
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
