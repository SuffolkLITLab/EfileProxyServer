
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SequenceNumberIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportExecutionPlanReferenceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportMeansTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportModeCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for TransportationSegmentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="TransportationSegmentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SequenceNumberID"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportExecutionPlanReferenceID"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportModeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportMeansTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportationService"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TransportServiceProviderParty"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CarryingTransportEquipment" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CarryingPackage" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CarryingTransportMeans" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DepartureTransportLocation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}IntermediateTransportLocation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ArrivalTransportLocation" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportationSegmentType", propOrder = {
    "sequenceNumberID",
    "transportExecutionPlanReferenceID",
    "transportModeCode",
    "transportMeansTypeCode",
    "transportationService",
    "transportServiceProviderParty",
    "carryingTransportEquipment",
    "carryingPackage",
    "carryingTransportMeans",
    "departureTransportLocation",
    "intermediateTransportLocation",
    "arrivalTransportLocation"
})
public class TransportationSegmentType {

    @XmlElement(name = "SequenceNumberID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected SequenceNumberIDType sequenceNumberID;
    @XmlElement(name = "TransportExecutionPlanReferenceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TransportExecutionPlanReferenceIDType transportExecutionPlanReferenceID;
    @XmlElement(name = "TransportModeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportModeCodeType transportModeCode;
    @XmlElement(name = "TransportMeansTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportMeansTypeCodeType transportMeansTypeCode;
    @XmlElement(name = "TransportationService", required = true)
    protected TransportationServiceType transportationService;
    @XmlElement(name = "TransportServiceProviderParty", required = true)
    protected PartyType transportServiceProviderParty;
    @XmlElement(name = "CarryingTransportEquipment")
    protected TransportEquipmentType carryingTransportEquipment;
    @XmlElement(name = "CarryingPackage")
    protected PackageType carryingPackage;
    @XmlElement(name = "CarryingTransportMeans")
    protected TransportMeansType carryingTransportMeans;
    @XmlElement(name = "DepartureTransportLocation")
    protected TransportLocationType departureTransportLocation;
    @XmlElement(name = "IntermediateTransportLocation")
    protected List<TransportLocationType> intermediateTransportLocation;
    @XmlElement(name = "ArrivalTransportLocation")
    protected TransportLocationType arrivalTransportLocation;

    /**
     * Gets the value of the sequenceNumberID property.
     * 
     * @return
     *     possible object is
     *     {@link SequenceNumberIDType }
     *     
     */
    public SequenceNumberIDType getSequenceNumberID() {
        return sequenceNumberID;
    }

    /**
     * Sets the value of the sequenceNumberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SequenceNumberIDType }
     *     
     */
    public void setSequenceNumberID(SequenceNumberIDType value) {
        this.sequenceNumberID = value;
    }

    /**
     * Gets the value of the transportExecutionPlanReferenceID property.
     * 
     * @return
     *     possible object is
     *     {@link TransportExecutionPlanReferenceIDType }
     *     
     */
    public TransportExecutionPlanReferenceIDType getTransportExecutionPlanReferenceID() {
        return transportExecutionPlanReferenceID;
    }

    /**
     * Sets the value of the transportExecutionPlanReferenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportExecutionPlanReferenceIDType }
     *     
     */
    public void setTransportExecutionPlanReferenceID(TransportExecutionPlanReferenceIDType value) {
        this.transportExecutionPlanReferenceID = value;
    }

    /**
     * Gets the value of the transportModeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TransportModeCodeType }
     *     
     */
    public TransportModeCodeType getTransportModeCode() {
        return transportModeCode;
    }

    /**
     * Sets the value of the transportModeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportModeCodeType }
     *     
     */
    public void setTransportModeCode(TransportModeCodeType value) {
        this.transportModeCode = value;
    }

    /**
     * Gets the value of the transportMeansTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TransportMeansTypeCodeType }
     *     
     */
    public TransportMeansTypeCodeType getTransportMeansTypeCode() {
        return transportMeansTypeCode;
    }

    /**
     * Sets the value of the transportMeansTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportMeansTypeCodeType }
     *     
     */
    public void setTransportMeansTypeCode(TransportMeansTypeCodeType value) {
        this.transportMeansTypeCode = value;
    }

    /**
     * Gets the value of the transportationService property.
     * 
     * @return
     *     possible object is
     *     {@link TransportationServiceType }
     *     
     */
    public TransportationServiceType getTransportationService() {
        return transportationService;
    }

    /**
     * Sets the value of the transportationService property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationServiceType }
     *     
     */
    public void setTransportationService(TransportationServiceType value) {
        this.transportationService = value;
    }

    /**
     * Gets the value of the transportServiceProviderParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getTransportServiceProviderParty() {
        return transportServiceProviderParty;
    }

    /**
     * Sets the value of the transportServiceProviderParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setTransportServiceProviderParty(PartyType value) {
        this.transportServiceProviderParty = value;
    }

    /**
     * Gets the value of the carryingTransportEquipment property.
     * 
     * @return
     *     possible object is
     *     {@link TransportEquipmentType }
     *     
     */
    public TransportEquipmentType getCarryingTransportEquipment() {
        return carryingTransportEquipment;
    }

    /**
     * Sets the value of the carryingTransportEquipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportEquipmentType }
     *     
     */
    public void setCarryingTransportEquipment(TransportEquipmentType value) {
        this.carryingTransportEquipment = value;
    }

    /**
     * Gets the value of the carryingPackage property.
     * 
     * @return
     *     possible object is
     *     {@link PackageType }
     *     
     */
    public PackageType getCarryingPackage() {
        return carryingPackage;
    }

    /**
     * Sets the value of the carryingPackage property.
     * 
     * @param value
     *     allowed object is
     *     {@link PackageType }
     *     
     */
    public void setCarryingPackage(PackageType value) {
        this.carryingPackage = value;
    }

    /**
     * Gets the value of the carryingTransportMeans property.
     * 
     * @return
     *     possible object is
     *     {@link TransportMeansType }
     *     
     */
    public TransportMeansType getCarryingTransportMeans() {
        return carryingTransportMeans;
    }

    /**
     * Sets the value of the carryingTransportMeans property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportMeansType }
     *     
     */
    public void setCarryingTransportMeans(TransportMeansType value) {
        this.carryingTransportMeans = value;
    }

    /**
     * Gets the value of the departureTransportLocation property.
     * 
     * @return
     *     possible object is
     *     {@link TransportLocationType }
     *     
     */
    public TransportLocationType getDepartureTransportLocation() {
        return departureTransportLocation;
    }

    /**
     * Sets the value of the departureTransportLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportLocationType }
     *     
     */
    public void setDepartureTransportLocation(TransportLocationType value) {
        this.departureTransportLocation = value;
    }

    /**
     * Gets the value of the intermediateTransportLocation property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the intermediateTransportLocation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getIntermediateTransportLocation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TransportLocationType }
     * 
     * 
     */
    public List<TransportLocationType> getIntermediateTransportLocation() {
        if (intermediateTransportLocation == null) {
            intermediateTransportLocation = new ArrayList<TransportLocationType>();
        }
        return this.intermediateTransportLocation;
    }

    /**
     * Gets the value of the arrivalTransportLocation property.
     * 
     * @return
     *     possible object is
     *     {@link TransportLocationType }
     *     
     */
    public TransportLocationType getArrivalTransportLocation() {
        return arrivalTransportLocation;
    }

    /**
     * Sets the value of the arrivalTransportLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportLocationType }
     *     
     */
    public void setArrivalTransportLocation(TransportLocationType value) {
        this.arrivalTransportLocation = value;
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
