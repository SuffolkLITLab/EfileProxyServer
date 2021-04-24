
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalStreetNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AddressFormatCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AddressTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BlockNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuildingNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuildingNumberType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CityNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CitySubdivisionNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CountrySubentityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DepartmentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DistrictType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FloorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InhouseMailType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarkAttentionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarkCareType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PlotIdentificationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PostalZoneType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PostboxType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RoomType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StreetNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TimezoneOffsetType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for AddressType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AddressType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AddressTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AddressFormatCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Postbox" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Floor" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Room" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}StreetName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdditionalStreetName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BlockName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BuildingName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BuildingNumber" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InhouseMail" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Department" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MarkAttention" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MarkCare" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PlotIdentification" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CitySubdivisionName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CityName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PostalZone" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CountrySubentity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CountrySubentityCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Region" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}District" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TimezoneOffset" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AddressLine" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Country" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LocationCoordinate" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddressType", propOrder = {
    "id",
    "addressTypeCode",
    "addressFormatCode",
    "postbox",
    "floor",
    "room",
    "streetName",
    "additionalStreetName",
    "blockName",
    "buildingName",
    "buildingNumber",
    "inhouseMail",
    "department",
    "markAttention",
    "markCare",
    "plotIdentification",
    "citySubdivisionName",
    "cityName",
    "postalZone",
    "countrySubentity",
    "countrySubentityCode",
    "region",
    "district",
    "timezoneOffset",
    "addressLine",
    "country",
    "locationCoordinate"
})
public class AddressType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "AddressTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AddressTypeCodeType addressTypeCode;
    @XmlElement(name = "AddressFormatCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AddressFormatCodeType addressFormatCode;
    @XmlElement(name = "Postbox", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PostboxType postbox;
    @XmlElement(name = "Floor", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FloorType floor;
    @XmlElement(name = "Room", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RoomType room;
    @XmlElement(name = "StreetName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected StreetNameType streetName;
    @XmlElement(name = "AdditionalStreetName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AdditionalStreetNameType additionalStreetName;
    @XmlElement(name = "BlockName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BlockNameType blockName;
    @XmlElement(name = "BuildingName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BuildingNameType buildingName;
    @XmlElement(name = "BuildingNumber", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BuildingNumberType buildingNumber;
    @XmlElement(name = "InhouseMail", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InhouseMailType inhouseMail;
    @XmlElement(name = "Department", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DepartmentType department;
    @XmlElement(name = "MarkAttention", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MarkAttentionType markAttention;
    @XmlElement(name = "MarkCare", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MarkCareType markCare;
    @XmlElement(name = "PlotIdentification", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PlotIdentificationType plotIdentification;
    @XmlElement(name = "CitySubdivisionName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CitySubdivisionNameType citySubdivisionName;
    @XmlElement(name = "CityName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CityNameType cityName;
    @XmlElement(name = "PostalZone", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PostalZoneType postalZone;
    @XmlElement(name = "CountrySubentity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CountrySubentityType countrySubentity;
    @XmlElement(name = "CountrySubentityCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CountrySubentityCodeType countrySubentityCode;
    @XmlElement(name = "Region", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegionType region;
    @XmlElement(name = "District", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DistrictType district;
    @XmlElement(name = "TimezoneOffset", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TimezoneOffsetType timezoneOffset;
    @XmlElement(name = "AddressLine")
    protected List<AddressLineType> addressLine;
    @XmlElement(name = "Country")
    protected CountryType country;
    @XmlElement(name = "LocationCoordinate")
    protected List<LocationCoordinateType> locationCoordinate;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * Gets the value of the addressTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link AddressTypeCodeType }
     *     
     */
    public AddressTypeCodeType getAddressTypeCode() {
        return addressTypeCode;
    }

    /**
     * Sets the value of the addressTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressTypeCodeType }
     *     
     */
    public void setAddressTypeCode(AddressTypeCodeType value) {
        this.addressTypeCode = value;
    }

    /**
     * Gets the value of the addressFormatCode property.
     * 
     * @return
     *     possible object is
     *     {@link AddressFormatCodeType }
     *     
     */
    public AddressFormatCodeType getAddressFormatCode() {
        return addressFormatCode;
    }

    /**
     * Sets the value of the addressFormatCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressFormatCodeType }
     *     
     */
    public void setAddressFormatCode(AddressFormatCodeType value) {
        this.addressFormatCode = value;
    }

    /**
     * Gets the value of the postbox property.
     * 
     * @return
     *     possible object is
     *     {@link PostboxType }
     *     
     */
    public PostboxType getPostbox() {
        return postbox;
    }

    /**
     * Sets the value of the postbox property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostboxType }
     *     
     */
    public void setPostbox(PostboxType value) {
        this.postbox = value;
    }

    /**
     * Gets the value of the floor property.
     * 
     * @return
     *     possible object is
     *     {@link FloorType }
     *     
     */
    public FloorType getFloor() {
        return floor;
    }

    /**
     * Sets the value of the floor property.
     * 
     * @param value
     *     allowed object is
     *     {@link FloorType }
     *     
     */
    public void setFloor(FloorType value) {
        this.floor = value;
    }

    /**
     * Gets the value of the room property.
     * 
     * @return
     *     possible object is
     *     {@link RoomType }
     *     
     */
    public RoomType getRoom() {
        return room;
    }

    /**
     * Sets the value of the room property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoomType }
     *     
     */
    public void setRoom(RoomType value) {
        this.room = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link StreetNameType }
     *     
     */
    public StreetNameType getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link StreetNameType }
     *     
     */
    public void setStreetName(StreetNameType value) {
        this.streetName = value;
    }

    /**
     * Gets the value of the additionalStreetName property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalStreetNameType }
     *     
     */
    public AdditionalStreetNameType getAdditionalStreetName() {
        return additionalStreetName;
    }

    /**
     * Sets the value of the additionalStreetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalStreetNameType }
     *     
     */
    public void setAdditionalStreetName(AdditionalStreetNameType value) {
        this.additionalStreetName = value;
    }

    /**
     * Gets the value of the blockName property.
     * 
     * @return
     *     possible object is
     *     {@link BlockNameType }
     *     
     */
    public BlockNameType getBlockName() {
        return blockName;
    }

    /**
     * Sets the value of the blockName property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlockNameType }
     *     
     */
    public void setBlockName(BlockNameType value) {
        this.blockName = value;
    }

    /**
     * Gets the value of the buildingName property.
     * 
     * @return
     *     possible object is
     *     {@link BuildingNameType }
     *     
     */
    public BuildingNameType getBuildingName() {
        return buildingName;
    }

    /**
     * Sets the value of the buildingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuildingNameType }
     *     
     */
    public void setBuildingName(BuildingNameType value) {
        this.buildingName = value;
    }

    /**
     * Gets the value of the buildingNumber property.
     * 
     * @return
     *     possible object is
     *     {@link BuildingNumberType }
     *     
     */
    public BuildingNumberType getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * Sets the value of the buildingNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuildingNumberType }
     *     
     */
    public void setBuildingNumber(BuildingNumberType value) {
        this.buildingNumber = value;
    }

    /**
     * Gets the value of the inhouseMail property.
     * 
     * @return
     *     possible object is
     *     {@link InhouseMailType }
     *     
     */
    public InhouseMailType getInhouseMail() {
        return inhouseMail;
    }

    /**
     * Sets the value of the inhouseMail property.
     * 
     * @param value
     *     allowed object is
     *     {@link InhouseMailType }
     *     
     */
    public void setInhouseMail(InhouseMailType value) {
        this.inhouseMail = value;
    }

    /**
     * Gets the value of the department property.
     * 
     * @return
     *     possible object is
     *     {@link DepartmentType }
     *     
     */
    public DepartmentType getDepartment() {
        return department;
    }

    /**
     * Sets the value of the department property.
     * 
     * @param value
     *     allowed object is
     *     {@link DepartmentType }
     *     
     */
    public void setDepartment(DepartmentType value) {
        this.department = value;
    }

    /**
     * Gets the value of the markAttention property.
     * 
     * @return
     *     possible object is
     *     {@link MarkAttentionType }
     *     
     */
    public MarkAttentionType getMarkAttention() {
        return markAttention;
    }

    /**
     * Sets the value of the markAttention property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkAttentionType }
     *     
     */
    public void setMarkAttention(MarkAttentionType value) {
        this.markAttention = value;
    }

    /**
     * Gets the value of the markCare property.
     * 
     * @return
     *     possible object is
     *     {@link MarkCareType }
     *     
     */
    public MarkCareType getMarkCare() {
        return markCare;
    }

    /**
     * Sets the value of the markCare property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkCareType }
     *     
     */
    public void setMarkCare(MarkCareType value) {
        this.markCare = value;
    }

    /**
     * Gets the value of the plotIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link PlotIdentificationType }
     *     
     */
    public PlotIdentificationType getPlotIdentification() {
        return plotIdentification;
    }

    /**
     * Sets the value of the plotIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlotIdentificationType }
     *     
     */
    public void setPlotIdentification(PlotIdentificationType value) {
        this.plotIdentification = value;
    }

    /**
     * Gets the value of the citySubdivisionName property.
     * 
     * @return
     *     possible object is
     *     {@link CitySubdivisionNameType }
     *     
     */
    public CitySubdivisionNameType getCitySubdivisionName() {
        return citySubdivisionName;
    }

    /**
     * Sets the value of the citySubdivisionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitySubdivisionNameType }
     *     
     */
    public void setCitySubdivisionName(CitySubdivisionNameType value) {
        this.citySubdivisionName = value;
    }

    /**
     * Gets the value of the cityName property.
     * 
     * @return
     *     possible object is
     *     {@link CityNameType }
     *     
     */
    public CityNameType getCityName() {
        return cityName;
    }

    /**
     * Sets the value of the cityName property.
     * 
     * @param value
     *     allowed object is
     *     {@link CityNameType }
     *     
     */
    public void setCityName(CityNameType value) {
        this.cityName = value;
    }

    /**
     * Gets the value of the postalZone property.
     * 
     * @return
     *     possible object is
     *     {@link PostalZoneType }
     *     
     */
    public PostalZoneType getPostalZone() {
        return postalZone;
    }

    /**
     * Sets the value of the postalZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostalZoneType }
     *     
     */
    public void setPostalZone(PostalZoneType value) {
        this.postalZone = value;
    }

    /**
     * Gets the value of the countrySubentity property.
     * 
     * @return
     *     possible object is
     *     {@link CountrySubentityType }
     *     
     */
    public CountrySubentityType getCountrySubentity() {
        return countrySubentity;
    }

    /**
     * Sets the value of the countrySubentity property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountrySubentityType }
     *     
     */
    public void setCountrySubentity(CountrySubentityType value) {
        this.countrySubentity = value;
    }

    /**
     * Gets the value of the countrySubentityCode property.
     * 
     * @return
     *     possible object is
     *     {@link CountrySubentityCodeType }
     *     
     */
    public CountrySubentityCodeType getCountrySubentityCode() {
        return countrySubentityCode;
    }

    /**
     * Sets the value of the countrySubentityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountrySubentityCodeType }
     *     
     */
    public void setCountrySubentityCode(CountrySubentityCodeType value) {
        this.countrySubentityCode = value;
    }

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link RegionType }
     *     
     */
    public RegionType getRegion() {
        return region;
    }

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegionType }
     *     
     */
    public void setRegion(RegionType value) {
        this.region = value;
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link DistrictType }
     *     
     */
    public DistrictType getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link DistrictType }
     *     
     */
    public void setDistrict(DistrictType value) {
        this.district = value;
    }

    /**
     * Gets the value of the timezoneOffset property.
     * 
     * @return
     *     possible object is
     *     {@link TimezoneOffsetType }
     *     
     */
    public TimezoneOffsetType getTimezoneOffset() {
        return timezoneOffset;
    }

    /**
     * Sets the value of the timezoneOffset property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimezoneOffsetType }
     *     
     */
    public void setTimezoneOffset(TimezoneOffsetType value) {
        this.timezoneOffset = value;
    }

    /**
     * Gets the value of the addressLine property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the addressLine property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAddressLine().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link AddressLineType }
     * 
     * 
     */
    public List<AddressLineType> getAddressLine() {
        if (addressLine == null) {
            addressLine = new ArrayList<AddressLineType>();
        }
        return this.addressLine;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setCountry(CountryType value) {
        this.country = value;
    }

    /**
     * Gets the value of the locationCoordinate property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the locationCoordinate property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getLocationCoordinate().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link LocationCoordinateType }
     * 
     * 
     */
    public List<LocationCoordinateType> getLocationCoordinate() {
        if (locationCoordinate == null) {
            locationCoordinate = new ArrayList<LocationCoordinateType>();
        }
        return this.locationCoordinate;
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
