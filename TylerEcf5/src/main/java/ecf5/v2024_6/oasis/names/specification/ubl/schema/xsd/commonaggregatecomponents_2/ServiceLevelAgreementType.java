
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AvailabilityTimePercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FridayAvailabilityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumDataLossDurationMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumIncidentNotificationDurationMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeanTimeToRecoverDurationMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumDownTimeScheduleDurationMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumResponseTimeDurationMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MondayAvailabilityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SaturdayAvailabilityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ServiceTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ServiceTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SundayAvailabilityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ThursdayAvailabilityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TuesdayAvailabilityIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WednesdayAvailabilityIndicatorType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe a service level agreement which regulates the quality, availability and responsibilities of digital services.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:AlternativeBusinessTerms&gt;SLA&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ServiceLevelAgreementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceLevelAgreementType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ServiceTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ServiceType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AvailabilityTimePercent" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MondayAvailabilityIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TuesdayAvailabilityIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WednesdayAvailabilityIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ThursdayAvailabilityIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FridayAvailabilityIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SaturdayAvailabilityIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SundayAvailabilityIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumResponseTimeDurationMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumDownTimeScheduleDurationMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumIncidentNotificationDurationMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumDataLossDurationMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeanTimeToRecoverDurationMeasure" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ServiceAvailabilityPeriod" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ServiceMaintenancePeriod" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceLevelAgreementType", propOrder = {
    "id",
    "serviceTypeCode",
    "serviceType",
    "availabilityTimePercent",
    "mondayAvailabilityIndicator",
    "tuesdayAvailabilityIndicator",
    "wednesdayAvailabilityIndicator",
    "thursdayAvailabilityIndicator",
    "fridayAvailabilityIndicator",
    "saturdayAvailabilityIndicator",
    "sundayAvailabilityIndicator",
    "minimumResponseTimeDurationMeasure",
    "minimumDownTimeScheduleDurationMeasure",
    "maximumIncidentNotificationDurationMeasure",
    "maximumDataLossDurationMeasure",
    "meanTimeToRecoverDurationMeasure",
    "serviceAvailabilityPeriod",
    "serviceMaintenancePeriod"
})
public class ServiceLevelAgreementType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "ServiceTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ServiceTypeCodeType serviceTypeCode;
    @XmlElement(name = "ServiceType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ServiceTypeType> serviceType;
    @XmlElement(name = "AvailabilityTimePercent", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected AvailabilityTimePercentType availabilityTimePercent;
    @XmlElement(name = "MondayAvailabilityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MondayAvailabilityIndicatorType mondayAvailabilityIndicator;
    @XmlElement(name = "TuesdayAvailabilityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TuesdayAvailabilityIndicatorType tuesdayAvailabilityIndicator;
    @XmlElement(name = "WednesdayAvailabilityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected WednesdayAvailabilityIndicatorType wednesdayAvailabilityIndicator;
    @XmlElement(name = "ThursdayAvailabilityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ThursdayAvailabilityIndicatorType thursdayAvailabilityIndicator;
    @XmlElement(name = "FridayAvailabilityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FridayAvailabilityIndicatorType fridayAvailabilityIndicator;
    @XmlElement(name = "SaturdayAvailabilityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SaturdayAvailabilityIndicatorType saturdayAvailabilityIndicator;
    @XmlElement(name = "SundayAvailabilityIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SundayAvailabilityIndicatorType sundayAvailabilityIndicator;
    @XmlElement(name = "MinimumResponseTimeDurationMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumResponseTimeDurationMeasureType minimumResponseTimeDurationMeasure;
    @XmlElement(name = "MinimumDownTimeScheduleDurationMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumDownTimeScheduleDurationMeasureType minimumDownTimeScheduleDurationMeasure;
    @XmlElement(name = "MaximumIncidentNotificationDurationMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumIncidentNotificationDurationMeasureType maximumIncidentNotificationDurationMeasure;
    @XmlElement(name = "MaximumDataLossDurationMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumDataLossDurationMeasureType maximumDataLossDurationMeasure;
    @XmlElement(name = "MeanTimeToRecoverDurationMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeanTimeToRecoverDurationMeasureType meanTimeToRecoverDurationMeasure;
    @XmlElement(name = "ServiceAvailabilityPeriod")
    protected List<PeriodType> serviceAvailabilityPeriod;
    @XmlElement(name = "ServiceMaintenancePeriod")
    protected List<PeriodType> serviceMaintenancePeriod;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for this service level agreement.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Service Type Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A specific type of service subject to this service level agreement.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Service Type Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;AP, SMP&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ServiceTypeCodeType }
     *     
     */
    public ServiceTypeCodeType getServiceTypeCode() {
        return serviceTypeCode;
    }

    /**
     * Sets the value of the serviceTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceTypeCodeType }
     *     
     */
    public void setServiceTypeCode(ServiceTypeCodeType value) {
        this.serviceTypeCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Service Type. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A specific type of service subject to this service level agreement, expressed as text.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Service Type&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the serviceType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the serviceType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceTypeType }
     * 
     * 
     */
    public List<ServiceTypeType> getServiceType() {
        if (serviceType == null) {
            serviceType = new ArrayList<ServiceTypeType>();
        }
        return this.serviceType;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Availability_ Time Percent. Percent&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The availability percentage (e.g. 98.5% of the time).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Availability&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Time Percent&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Percent&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Percent. Type&lt;/ccts:DataType&gt;&lt;ccts:AlternativeBusinessTerms&gt;Time Service Factor&lt;/ccts:AlternativeBusinessTerms&gt;&lt;ccts:Examples&gt;98.5&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link AvailabilityTimePercentType }
     *     
     */
    public AvailabilityTimePercentType getAvailabilityTimePercent() {
        return availabilityTimePercent;
    }

    /**
     * Sets the value of the availabilityTimePercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailabilityTimePercentType }
     *     
     */
    public void setAvailabilityTimePercent(AvailabilityTimePercentType value) {
        this.availabilityTimePercent = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Monday Availability_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Indicates whether this service is available on monday (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Monday Availability&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MondayAvailabilityIndicatorType }
     *     
     */
    public MondayAvailabilityIndicatorType getMondayAvailabilityIndicator() {
        return mondayAvailabilityIndicator;
    }

    /**
     * Sets the value of the mondayAvailabilityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link MondayAvailabilityIndicatorType }
     *     
     */
    public void setMondayAvailabilityIndicator(MondayAvailabilityIndicatorType value) {
        this.mondayAvailabilityIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Tuesday Availability_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Indicates whether this service is available on tuesday (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Tuesday Availability&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link TuesdayAvailabilityIndicatorType }
     *     
     */
    public TuesdayAvailabilityIndicatorType getTuesdayAvailabilityIndicator() {
        return tuesdayAvailabilityIndicator;
    }

    /**
     * Sets the value of the tuesdayAvailabilityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link TuesdayAvailabilityIndicatorType }
     *     
     */
    public void setTuesdayAvailabilityIndicator(TuesdayAvailabilityIndicatorType value) {
        this.tuesdayAvailabilityIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Wednesday Availability_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Indicates whether this service is available on wednesday (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Wednesday Availability&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link WednesdayAvailabilityIndicatorType }
     *     
     */
    public WednesdayAvailabilityIndicatorType getWednesdayAvailabilityIndicator() {
        return wednesdayAvailabilityIndicator;
    }

    /**
     * Sets the value of the wednesdayAvailabilityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link WednesdayAvailabilityIndicatorType }
     *     
     */
    public void setWednesdayAvailabilityIndicator(WednesdayAvailabilityIndicatorType value) {
        this.wednesdayAvailabilityIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Thursday Availability_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Indicates whether this service is available on thursday (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Thursday Availability&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ThursdayAvailabilityIndicatorType }
     *     
     */
    public ThursdayAvailabilityIndicatorType getThursdayAvailabilityIndicator() {
        return thursdayAvailabilityIndicator;
    }

    /**
     * Sets the value of the thursdayAvailabilityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThursdayAvailabilityIndicatorType }
     *     
     */
    public void setThursdayAvailabilityIndicator(ThursdayAvailabilityIndicatorType value) {
        this.thursdayAvailabilityIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Friday Availability_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Indicates whether this service is available on friday (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Friday Availability&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link FridayAvailabilityIndicatorType }
     *     
     */
    public FridayAvailabilityIndicatorType getFridayAvailabilityIndicator() {
        return fridayAvailabilityIndicator;
    }

    /**
     * Sets the value of the fridayAvailabilityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link FridayAvailabilityIndicatorType }
     *     
     */
    public void setFridayAvailabilityIndicator(FridayAvailabilityIndicatorType value) {
        this.fridayAvailabilityIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Saturday Availability_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Indicates whether this service is available on saturday (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Saturday Availability&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link SaturdayAvailabilityIndicatorType }
     *     
     */
    public SaturdayAvailabilityIndicatorType getSaturdayAvailabilityIndicator() {
        return saturdayAvailabilityIndicator;
    }

    /**
     * Sets the value of the saturdayAvailabilityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaturdayAvailabilityIndicatorType }
     *     
     */
    public void setSaturdayAvailabilityIndicator(SaturdayAvailabilityIndicatorType value) {
        this.saturdayAvailabilityIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Sunday Availability_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Indicates whether this service is available on sunday (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Sunday Availability&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link SundayAvailabilityIndicatorType }
     *     
     */
    public SundayAvailabilityIndicatorType getSundayAvailabilityIndicator() {
        return sundayAvailabilityIndicator;
    }

    /**
     * Sets the value of the sundayAvailabilityIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link SundayAvailabilityIndicatorType }
     *     
     */
    public void setSundayAvailabilityIndicator(SundayAvailabilityIndicatorType value) {
        this.sundayAvailabilityIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Minimum_ Response Time Duration. Measure&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The response time for aknowledgment (e.g. to send a receipt to a sending Access Point within 300 seconds).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Minimum&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Response Time Duration&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Measure&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Measure. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;300&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MinimumResponseTimeDurationMeasureType }
     *     
     */
    public MinimumResponseTimeDurationMeasureType getMinimumResponseTimeDurationMeasure() {
        return minimumResponseTimeDurationMeasure;
    }

    /**
     * Sets the value of the minimumResponseTimeDurationMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumResponseTimeDurationMeasureType }
     *     
     */
    public void setMinimumResponseTimeDurationMeasure(MinimumResponseTimeDurationMeasureType value) {
        this.minimumResponseTimeDurationMeasure = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Minimum_ Down Time Schedule Duration. Measure&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The minimum down time schedule for programmed maintenance (e.g. scheduled 3 days before).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Minimum&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Down Time Schedule Duration&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Measure&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Measure. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;3&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MinimumDownTimeScheduleDurationMeasureType }
     *     
     */
    public MinimumDownTimeScheduleDurationMeasureType getMinimumDownTimeScheduleDurationMeasure() {
        return minimumDownTimeScheduleDurationMeasure;
    }

    /**
     * Sets the value of the minimumDownTimeScheduleDurationMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumDownTimeScheduleDurationMeasureType }
     *     
     */
    public void setMinimumDownTimeScheduleDurationMeasure(MinimumDownTimeScheduleDurationMeasureType value) {
        this.minimumDownTimeScheduleDurationMeasure = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Maximum_ Incident Notification Duration. Measure&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The maximum length of time between the occurrence of an incident and the issuance of a notification (e.g. within 4 hours).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Maximum&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Incident Notification Duration&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Measure&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Measure. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;4&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MaximumIncidentNotificationDurationMeasureType }
     *     
     */
    public MaximumIncidentNotificationDurationMeasureType getMaximumIncidentNotificationDurationMeasure() {
        return maximumIncidentNotificationDurationMeasure;
    }

    /**
     * Sets the value of the maximumIncidentNotificationDurationMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumIncidentNotificationDurationMeasureType }
     *     
     */
    public void setMaximumIncidentNotificationDurationMeasure(MaximumIncidentNotificationDurationMeasureType value) {
        this.maximumIncidentNotificationDurationMeasure = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Maximum_ Data Loss Duration. Measure&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The maximum data loss permitted (e.g. last 24 hours).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Maximum&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Data Loss Duration&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Measure&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Measure. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;24&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MaximumDataLossDurationMeasureType }
     *     
     */
    public MaximumDataLossDurationMeasureType getMaximumDataLossDurationMeasure() {
        return maximumDataLossDurationMeasure;
    }

    /**
     * Sets the value of the maximumDataLossDurationMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumDataLossDurationMeasureType }
     *     
     */
    public void setMaximumDataLossDurationMeasure(MaximumDataLossDurationMeasureType value) {
        this.maximumDataLossDurationMeasure = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Mean_ Time To Recover Duration. Measure&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The time taken to recover after an outage of service (e.g. 3 hours).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Mean&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Time To Recover Duration&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Measure&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Measure. Type&lt;/ccts:DataType&gt;&lt;ccts:AlternativeBusinessTerms&gt;MTTR&lt;/ccts:AlternativeBusinessTerms&gt;&lt;ccts:Examples&gt;3&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MeanTimeToRecoverDurationMeasureType }
     *     
     */
    public MeanTimeToRecoverDurationMeasureType getMeanTimeToRecoverDurationMeasure() {
        return meanTimeToRecoverDurationMeasure;
    }

    /**
     * Sets the value of the meanTimeToRecoverDurationMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeanTimeToRecoverDurationMeasureType }
     *     
     */
    public void setMeanTimeToRecoverDurationMeasure(MeanTimeToRecoverDurationMeasureType value) {
        this.meanTimeToRecoverDurationMeasure = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Service Availability_ Period. Period&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The period for which the service is available.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Service Availability&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Period&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Period&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Period&lt;/ccts:RepresentationTerm&gt;&lt;ccts:AlternativeBusinessTerms&gt;Uptime&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the serviceAvailabilityPeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the serviceAvailabilityPeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceAvailabilityPeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodType }
     * 
     * 
     */
    public List<PeriodType> getServiceAvailabilityPeriod() {
        if (serviceAvailabilityPeriod == null) {
            serviceAvailabilityPeriod = new ArrayList<PeriodType>();
        }
        return this.serviceAvailabilityPeriod;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Service Level Agreement. Service Maintenance_ Period. Period&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The period of time designated in advance by the technical staff, during which preventive maintenance that could cause disruption of service may be performed.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Service Level Agreement&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Service Maintenance&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Period&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Period&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Period&lt;/ccts:RepresentationTerm&gt;&lt;ccts:AlternativeBusinessTerms&gt;Downtime&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the serviceMaintenancePeriod property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the serviceMaintenancePeriod property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceMaintenancePeriod().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PeriodType }
     * 
     * 
     */
    public List<PeriodType> getServiceMaintenancePeriod() {
        if (serviceMaintenancePeriod == null) {
            serviceMaintenancePeriod = new ArrayList<PeriodType>();
        }
        return this.serviceMaintenancePeriod;
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
