
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DirectionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.JourneyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNationalityIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNationalityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TradeServiceCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportMeansTypeCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for TransportMeansType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="TransportMeansType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}JourneyID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationNationalityID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationNationality" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DirectionCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportMeansTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TradeServiceCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Stowage" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AirTransport" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RoadTransport" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RailTransport" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MaritimeTransport" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OwnerParty" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OperatorParty" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportMeansType", propOrder = {
    "journeyID",
    "registrationNationalityID",
    "registrationNationality",
    "directionCode",
    "transportMeansTypeCode",
    "tradeServiceCode",
    "stowage",
    "airTransport",
    "roadTransport",
    "railTransport",
    "maritimeTransport",
    "ownerParty",
    "operatorParty"
})
public class TransportMeansType {

    @XmlElement(name = "JourneyID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected JourneyIDType journeyID;
    @XmlElement(name = "RegistrationNationalityID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationNationalityIDType registrationNationalityID;
    @XmlElement(name = "RegistrationNationality", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<RegistrationNationalityType> registrationNationality;
    @XmlElement(name = "DirectionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DirectionCodeType directionCode;
    @XmlElement(name = "TransportMeansTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportMeansTypeCodeType transportMeansTypeCode;
    @XmlElement(name = "TradeServiceCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TradeServiceCodeType tradeServiceCode;
    @XmlElement(name = "Stowage")
    protected StowageType stowage;
    @XmlElement(name = "AirTransport")
    protected AirTransportType airTransport;
    @XmlElement(name = "RoadTransport")
    protected RoadTransportType roadTransport;
    @XmlElement(name = "RailTransport")
    protected RailTransportType railTransport;
    @XmlElement(name = "MaritimeTransport")
    protected MaritimeTransportType maritimeTransport;
    @XmlElement(name = "OwnerParty")
    protected PartyType ownerParty;
    @XmlElement(name = "OperatorParty")
    protected List<PartyType> operatorParty;

    /**
     * Gets the value of the journeyID property.
     * 
     * @return
     *     possible object is
     *     {@link JourneyIDType }
     *     
     */
    public JourneyIDType getJourneyID() {
        return journeyID;
    }

    /**
     * Sets the value of the journeyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JourneyIDType }
     *     
     */
    public void setJourneyID(JourneyIDType value) {
        this.journeyID = value;
    }

    /**
     * Gets the value of the registrationNationalityID property.
     * 
     * @return
     *     possible object is
     *     {@link RegistrationNationalityIDType }
     *     
     */
    public RegistrationNationalityIDType getRegistrationNationalityID() {
        return registrationNationalityID;
    }

    /**
     * Sets the value of the registrationNationalityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationNationalityIDType }
     *     
     */
    public void setRegistrationNationalityID(RegistrationNationalityIDType value) {
        this.registrationNationalityID = value;
    }

    /**
     * Gets the value of the registrationNationality property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the registrationNationality property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRegistrationNationality().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link RegistrationNationalityType }
     * 
     * 
     */
    public List<RegistrationNationalityType> getRegistrationNationality() {
        if (registrationNationality == null) {
            registrationNationality = new ArrayList<RegistrationNationalityType>();
        }
        return this.registrationNationality;
    }

    /**
     * Gets the value of the directionCode property.
     * 
     * @return
     *     possible object is
     *     {@link DirectionCodeType }
     *     
     */
    public DirectionCodeType getDirectionCode() {
        return directionCode;
    }

    /**
     * Sets the value of the directionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link DirectionCodeType }
     *     
     */
    public void setDirectionCode(DirectionCodeType value) {
        this.directionCode = value;
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
     * Gets the value of the tradeServiceCode property.
     * 
     * @return
     *     possible object is
     *     {@link TradeServiceCodeType }
     *     
     */
    public TradeServiceCodeType getTradeServiceCode() {
        return tradeServiceCode;
    }

    /**
     * Sets the value of the tradeServiceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TradeServiceCodeType }
     *     
     */
    public void setTradeServiceCode(TradeServiceCodeType value) {
        this.tradeServiceCode = value;
    }

    /**
     * Gets the value of the stowage property.
     * 
     * @return
     *     possible object is
     *     {@link StowageType }
     *     
     */
    public StowageType getStowage() {
        return stowage;
    }

    /**
     * Sets the value of the stowage property.
     * 
     * @param value
     *     allowed object is
     *     {@link StowageType }
     *     
     */
    public void setStowage(StowageType value) {
        this.stowage = value;
    }

    /**
     * Gets the value of the airTransport property.
     * 
     * @return
     *     possible object is
     *     {@link AirTransportType }
     *     
     */
    public AirTransportType getAirTransport() {
        return airTransport;
    }

    /**
     * Sets the value of the airTransport property.
     * 
     * @param value
     *     allowed object is
     *     {@link AirTransportType }
     *     
     */
    public void setAirTransport(AirTransportType value) {
        this.airTransport = value;
    }

    /**
     * Gets the value of the roadTransport property.
     * 
     * @return
     *     possible object is
     *     {@link RoadTransportType }
     *     
     */
    public RoadTransportType getRoadTransport() {
        return roadTransport;
    }

    /**
     * Sets the value of the roadTransport property.
     * 
     * @param value
     *     allowed object is
     *     {@link RoadTransportType }
     *     
     */
    public void setRoadTransport(RoadTransportType value) {
        this.roadTransport = value;
    }

    /**
     * Gets the value of the railTransport property.
     * 
     * @return
     *     possible object is
     *     {@link RailTransportType }
     *     
     */
    public RailTransportType getRailTransport() {
        return railTransport;
    }

    /**
     * Sets the value of the railTransport property.
     * 
     * @param value
     *     allowed object is
     *     {@link RailTransportType }
     *     
     */
    public void setRailTransport(RailTransportType value) {
        this.railTransport = value;
    }

    /**
     * Gets the value of the maritimeTransport property.
     * 
     * @return
     *     possible object is
     *     {@link MaritimeTransportType }
     *     
     */
    public MaritimeTransportType getMaritimeTransport() {
        return maritimeTransport;
    }

    /**
     * Sets the value of the maritimeTransport property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaritimeTransportType }
     *     
     */
    public void setMaritimeTransport(MaritimeTransportType value) {
        this.maritimeTransport = value;
    }

    /**
     * Gets the value of the ownerParty property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getOwnerParty() {
        return ownerParty;
    }

    /**
     * Sets the value of the ownerParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setOwnerParty(PartyType value) {
        this.ownerParty = value;
    }

    /**
     * Gets the value of the operatorParty property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the operatorParty property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getOperatorParty().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link PartyType }
     * 
     * 
     */
    public List<PartyType> getOperatorParty() {
        if (operatorParty == null) {
            operatorParty = new ArrayList<PartyType>();
        }
        return this.operatorParty;
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
