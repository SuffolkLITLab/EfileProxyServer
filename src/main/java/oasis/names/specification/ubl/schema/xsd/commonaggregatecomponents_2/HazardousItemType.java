
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalInformationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CategoryNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EmergencyProceduresCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardClassIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HazardousCategoryCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LowerOrangeHazardPlacardIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MarkingIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MedicalFirstAidGuideCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PlacardEndorsementType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PlacardNotationType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TechnicalNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UNDGCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.UpperOrangeHazardPlacardIDType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for HazardousItemType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="HazardousItemType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PlacardNotation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PlacardEndorsement" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdditionalInformation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UNDGCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EmergencyProceduresCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MedicalFirstAidGuideCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TechnicalName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CategoryName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HazardousCategoryCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}UpperOrangeHazardPlacardID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LowerOrangeHazardPlacardID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MarkingID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HazardClassID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetWeightMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetVolumeMeasure" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Quantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContactParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SecondaryHazard" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HazardousGoodsTransit" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EmergencyTemperature" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}FlashpointTemperature" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalTemperature" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HazardousItemType", propOrder = {
    "id",
    "placardNotation",
    "placardEndorsement",
    "additionalInformation",
    "undgCode",
    "emergencyProceduresCode",
    "medicalFirstAidGuideCode",
    "technicalName",
    "categoryName",
    "hazardousCategoryCode",
    "upperOrangeHazardPlacardID",
    "lowerOrangeHazardPlacardID",
    "markingID",
    "hazardClassID",
    "netWeightMeasure",
    "netVolumeMeasure",
    "quantity",
    "contactParty",
    "secondaryHazard",
    "hazardousGoodsTransit",
    "emergencyTemperature",
    "flashpointTemperature",
    "additionalTemperature"
})
public class HazardousItemType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "PlacardNotation", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PlacardNotationType placardNotation;
    @XmlElement(name = "PlacardEndorsement", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PlacardEndorsementType placardEndorsement;
    @XmlElement(name = "AdditionalInformation", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AdditionalInformationType additionalInformation;
    @XmlElement(name = "UNDGCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UNDGCodeType undgCode;
    @XmlElement(name = "EmergencyProceduresCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EmergencyProceduresCodeType emergencyProceduresCode;
    @XmlElement(name = "MedicalFirstAidGuideCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MedicalFirstAidGuideCodeType medicalFirstAidGuideCode;
    @XmlElement(name = "TechnicalName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TechnicalNameType technicalName;
    @XmlElement(name = "CategoryName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CategoryNameType categoryName;
    @XmlElement(name = "HazardousCategoryCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HazardousCategoryCodeType hazardousCategoryCode;
    @XmlElement(name = "UpperOrangeHazardPlacardID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected UpperOrangeHazardPlacardIDType upperOrangeHazardPlacardID;
    @XmlElement(name = "LowerOrangeHazardPlacardID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LowerOrangeHazardPlacardIDType lowerOrangeHazardPlacardID;
    @XmlElement(name = "MarkingID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MarkingIDType markingID;
    @XmlElement(name = "HazardClassID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HazardClassIDType hazardClassID;
    @XmlElement(name = "NetWeightMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetWeightMeasureType netWeightMeasure;
    @XmlElement(name = "NetVolumeMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetVolumeMeasureType netVolumeMeasure;
    @XmlElement(name = "Quantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QuantityType quantity;
    @XmlElement(name = "ContactParty")
    protected PartyType contactParty;
    @XmlElement(name = "SecondaryHazard")
    protected List<SecondaryHazardType> secondaryHazard;
    @XmlElement(name = "HazardousGoodsTransit")
    protected List<HazardousGoodsTransitType> hazardousGoodsTransit;
    @XmlElement(name = "EmergencyTemperature")
    protected TemperatureType emergencyTemperature;
    @XmlElement(name = "FlashpointTemperature")
    protected TemperatureType flashpointTemperature;
    @XmlElement(name = "AdditionalTemperature")
    protected List<TemperatureType> additionalTemperature;

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
     * Gets the value of the placardNotation property.
     * 
     * @return
     *     possible object is
     *     {@link PlacardNotationType }
     *     
     */
    public PlacardNotationType getPlacardNotation() {
        return placardNotation;
    }

    /**
     * Sets the value of the placardNotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacardNotationType }
     *     
     */
    public void setPlacardNotation(PlacardNotationType value) {
        this.placardNotation = value;
    }

    /**
     * Gets the value of the placardEndorsement property.
     * 
     * @return
     *     possible object is
     *     {@link PlacardEndorsementType }
     *     
     */
    public PlacardEndorsementType getPlacardEndorsement() {
        return placardEndorsement;
    }

    /**
     * Sets the value of the placardEndorsement property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacardEndorsementType }
     *     
     */
    public void setPlacardEndorsement(PlacardEndorsementType value) {
        this.placardEndorsement = value;
    }

    /**
     * Gets the value of the additionalInformation property.
     * 
     * @return
     *     possible object is
     *     {@link AdditionalInformationType }
     *     
     */
    public AdditionalInformationType getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditionalInformationType }
     *     
     */
    public void setAdditionalInformation(AdditionalInformationType value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the undgCode property.
     * 
     * @return
     *     possible object is
     *     {@link UNDGCodeType }
     *     
     */
    public UNDGCodeType getUNDGCode() {
        return undgCode;
    }

    /**
     * Sets the value of the undgCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link UNDGCodeType }
     *     
     */
    public void setUNDGCode(UNDGCodeType value) {
        this.undgCode = value;
    }

    /**
     * Gets the value of the emergencyProceduresCode property.
     * 
     * @return
     *     possible object is
     *     {@link EmergencyProceduresCodeType }
     *     
     */
    public EmergencyProceduresCodeType getEmergencyProceduresCode() {
        return emergencyProceduresCode;
    }

    /**
     * Sets the value of the emergencyProceduresCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmergencyProceduresCodeType }
     *     
     */
    public void setEmergencyProceduresCode(EmergencyProceduresCodeType value) {
        this.emergencyProceduresCode = value;
    }

    /**
     * Gets the value of the medicalFirstAidGuideCode property.
     * 
     * @return
     *     possible object is
     *     {@link MedicalFirstAidGuideCodeType }
     *     
     */
    public MedicalFirstAidGuideCodeType getMedicalFirstAidGuideCode() {
        return medicalFirstAidGuideCode;
    }

    /**
     * Sets the value of the medicalFirstAidGuideCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MedicalFirstAidGuideCodeType }
     *     
     */
    public void setMedicalFirstAidGuideCode(MedicalFirstAidGuideCodeType value) {
        this.medicalFirstAidGuideCode = value;
    }

    /**
     * Gets the value of the technicalName property.
     * 
     * @return
     *     possible object is
     *     {@link TechnicalNameType }
     *     
     */
    public TechnicalNameType getTechnicalName() {
        return technicalName;
    }

    /**
     * Sets the value of the technicalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TechnicalNameType }
     *     
     */
    public void setTechnicalName(TechnicalNameType value) {
        this.technicalName = value;
    }

    /**
     * Gets the value of the categoryName property.
     * 
     * @return
     *     possible object is
     *     {@link CategoryNameType }
     *     
     */
    public CategoryNameType getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the value of the categoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link CategoryNameType }
     *     
     */
    public void setCategoryName(CategoryNameType value) {
        this.categoryName = value;
    }

    /**
     * Gets the value of the hazardousCategoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link HazardousCategoryCodeType }
     *     
     */
    public HazardousCategoryCodeType getHazardousCategoryCode() {
        return hazardousCategoryCode;
    }

    /**
     * Sets the value of the hazardousCategoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardousCategoryCodeType }
     *     
     */
    public void setHazardousCategoryCode(HazardousCategoryCodeType value) {
        this.hazardousCategoryCode = value;
    }

    /**
     * Gets the value of the upperOrangeHazardPlacardID property.
     * 
     * @return
     *     possible object is
     *     {@link UpperOrangeHazardPlacardIDType }
     *     
     */
    public UpperOrangeHazardPlacardIDType getUpperOrangeHazardPlacardID() {
        return upperOrangeHazardPlacardID;
    }

    /**
     * Sets the value of the upperOrangeHazardPlacardID property.
     * 
     * @param value
     *     allowed object is
     *     {@link UpperOrangeHazardPlacardIDType }
     *     
     */
    public void setUpperOrangeHazardPlacardID(UpperOrangeHazardPlacardIDType value) {
        this.upperOrangeHazardPlacardID = value;
    }

    /**
     * Gets the value of the lowerOrangeHazardPlacardID property.
     * 
     * @return
     *     possible object is
     *     {@link LowerOrangeHazardPlacardIDType }
     *     
     */
    public LowerOrangeHazardPlacardIDType getLowerOrangeHazardPlacardID() {
        return lowerOrangeHazardPlacardID;
    }

    /**
     * Sets the value of the lowerOrangeHazardPlacardID property.
     * 
     * @param value
     *     allowed object is
     *     {@link LowerOrangeHazardPlacardIDType }
     *     
     */
    public void setLowerOrangeHazardPlacardID(LowerOrangeHazardPlacardIDType value) {
        this.lowerOrangeHazardPlacardID = value;
    }

    /**
     * Gets the value of the markingID property.
     * 
     * @return
     *     possible object is
     *     {@link MarkingIDType }
     *     
     */
    public MarkingIDType getMarkingID() {
        return markingID;
    }

    /**
     * Sets the value of the markingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarkingIDType }
     *     
     */
    public void setMarkingID(MarkingIDType value) {
        this.markingID = value;
    }

    /**
     * Gets the value of the hazardClassID property.
     * 
     * @return
     *     possible object is
     *     {@link HazardClassIDType }
     *     
     */
    public HazardClassIDType getHazardClassID() {
        return hazardClassID;
    }

    /**
     * Sets the value of the hazardClassID property.
     * 
     * @param value
     *     allowed object is
     *     {@link HazardClassIDType }
     *     
     */
    public void setHazardClassID(HazardClassIDType value) {
        this.hazardClassID = value;
    }

    /**
     * Gets the value of the netWeightMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link NetWeightMeasureType }
     *     
     */
    public NetWeightMeasureType getNetWeightMeasure() {
        return netWeightMeasure;
    }

    /**
     * Sets the value of the netWeightMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetWeightMeasureType }
     *     
     */
    public void setNetWeightMeasure(NetWeightMeasureType value) {
        this.netWeightMeasure = value;
    }

    /**
     * Gets the value of the netVolumeMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link NetVolumeMeasureType }
     *     
     */
    public NetVolumeMeasureType getNetVolumeMeasure() {
        return netVolumeMeasure;
    }

    /**
     * Sets the value of the netVolumeMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetVolumeMeasureType }
     *     
     */
    public void setNetVolumeMeasure(NetVolumeMeasureType value) {
        this.netVolumeMeasure = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link QuantityType }
     *     
     */
    public QuantityType getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *     
     */
    public void setQuantity(QuantityType value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the contactParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getContactParty() {
        return contactParty;
    }

    /**
     * Sets the value of the contactParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setContactParty(PartyType value) {
        this.contactParty = value;
    }

    /**
     * Gets the value of the secondaryHazard property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the secondaryHazard property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSecondaryHazard().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link SecondaryHazardType }
     * 
     * 
     */
    public List<SecondaryHazardType> getSecondaryHazard() {
        if (secondaryHazard == null) {
            secondaryHazard = new ArrayList<SecondaryHazardType>();
        }
        return this.secondaryHazard;
    }

    /**
     * Gets the value of the hazardousGoodsTransit property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the hazardousGoodsTransit property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getHazardousGoodsTransit().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link HazardousGoodsTransitType }
     * 
     * 
     */
    public List<HazardousGoodsTransitType> getHazardousGoodsTransit() {
        if (hazardousGoodsTransit == null) {
            hazardousGoodsTransit = new ArrayList<HazardousGoodsTransitType>();
        }
        return this.hazardousGoodsTransit;
    }

    /**
     * Gets the value of the emergencyTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureType }
     *     
     */
    public TemperatureType getEmergencyTemperature() {
        return emergencyTemperature;
    }

    /**
     * Sets the value of the emergencyTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureType }
     *     
     */
    public void setEmergencyTemperature(TemperatureType value) {
        this.emergencyTemperature = value;
    }

    /**
     * Gets the value of the flashpointTemperature property.
     * 
     * @return
     *     possible object is
     *     {@link TemperatureType }
     *     
     */
    public TemperatureType getFlashpointTemperature() {
        return flashpointTemperature;
    }

    /**
     * Sets the value of the flashpointTemperature property.
     * 
     * @param value
     *     allowed object is
     *     {@link TemperatureType }
     *     
     */
    public void setFlashpointTemperature(TemperatureType value) {
        this.flashpointTemperature = value;
    }

    /**
     * Gets the value of the additionalTemperature property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the additionalTemperature property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAdditionalTemperature().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TemperatureType }
     * 
     * 
     */
    public List<TemperatureType> getAdditionalTemperature() {
        if (additionalTemperature == null) {
            additionalTemperature = new ArrayList<TemperatureType>();
        }
        return this.additionalTemperature;
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
