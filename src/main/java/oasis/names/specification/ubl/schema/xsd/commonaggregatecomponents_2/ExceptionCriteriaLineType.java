
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CollaborationPriorityCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExceptionResolutionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExceptionStatusCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NoteType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PerformanceMetricTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SupplyChainActivityTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ThresholdQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ThresholdValueComparisonCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ExceptionCriteriaLineType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ExceptionCriteriaLineType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Note" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ThresholdValueComparisonCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ThresholdQuantity"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExceptionStatusCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CollaborationPriorityCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExceptionResolutionCode" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SupplyChainActivityTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PerformanceMetricTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EffectivePeriod" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupplyItem" maxOccurs="unbounded"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ForecastExceptionCriteriaLine" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExceptionCriteriaLineType", propOrder = {
    "id",
    "note",
    "thresholdValueComparisonCode",
    "thresholdQuantity",
    "exceptionStatusCode",
    "collaborationPriorityCode",
    "exceptionResolutionCode",
    "supplyChainActivityTypeCode",
    "performanceMetricTypeCode",
    "effectivePeriod",
    "supplyItem",
    "forecastExceptionCriteriaLine"
})
public class ExceptionCriteriaLineType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected IDType id;
    @XmlElement(name = "Note", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<NoteType> note;
    @XmlElement(name = "ThresholdValueComparisonCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ThresholdValueComparisonCodeType thresholdValueComparisonCode;
    @XmlElement(name = "ThresholdQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ThresholdQuantityType thresholdQuantity;
    @XmlElement(name = "ExceptionStatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExceptionStatusCodeType exceptionStatusCode;
    @XmlElement(name = "CollaborationPriorityCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CollaborationPriorityCodeType collaborationPriorityCode;
    @XmlElement(name = "ExceptionResolutionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ExceptionResolutionCodeType> exceptionResolutionCode;
    @XmlElement(name = "SupplyChainActivityTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SupplyChainActivityTypeCodeType supplyChainActivityTypeCode;
    @XmlElement(name = "PerformanceMetricTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PerformanceMetricTypeCodeType performanceMetricTypeCode;
    @XmlElement(name = "EffectivePeriod")
    protected PeriodType effectivePeriod;
    @XmlElement(name = "SupplyItem", required = true)
    protected List<ItemType> supplyItem;
    @XmlElement(name = "ForecastExceptionCriteriaLine")
    protected ForecastExceptionCriteriaLineType forecastExceptionCriteriaLine;

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
     * Gets the value of the note property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the note property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getNote().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link NoteType }
     * 
     * 
     */
    public List<NoteType> getNote() {
        if (note == null) {
            note = new ArrayList<NoteType>();
        }
        return this.note;
    }

    /**
     * Gets the value of the thresholdValueComparisonCode property.
     * 
     * @return
     *     possible object is
     *     {@link ThresholdValueComparisonCodeType }
     *     
     */
    public ThresholdValueComparisonCodeType getThresholdValueComparisonCode() {
        return thresholdValueComparisonCode;
    }

    /**
     * Sets the value of the thresholdValueComparisonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThresholdValueComparisonCodeType }
     *     
     */
    public void setThresholdValueComparisonCode(ThresholdValueComparisonCodeType value) {
        this.thresholdValueComparisonCode = value;
    }

    /**
     * Gets the value of the thresholdQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link ThresholdQuantityType }
     *     
     */
    public ThresholdQuantityType getThresholdQuantity() {
        return thresholdQuantity;
    }

    /**
     * Sets the value of the thresholdQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThresholdQuantityType }
     *     
     */
    public void setThresholdQuantity(ThresholdQuantityType value) {
        this.thresholdQuantity = value;
    }

    /**
     * Gets the value of the exceptionStatusCode property.
     * 
     * @return
     *     possible object is
     *     {@link ExceptionStatusCodeType }
     *     
     */
    public ExceptionStatusCodeType getExceptionStatusCode() {
        return exceptionStatusCode;
    }

    /**
     * Sets the value of the exceptionStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExceptionStatusCodeType }
     *     
     */
    public void setExceptionStatusCode(ExceptionStatusCodeType value) {
        this.exceptionStatusCode = value;
    }

    /**
     * Gets the value of the collaborationPriorityCode property.
     * 
     * @return
     *     possible object is
     *     {@link CollaborationPriorityCodeType }
     *     
     */
    public CollaborationPriorityCodeType getCollaborationPriorityCode() {
        return collaborationPriorityCode;
    }

    /**
     * Sets the value of the collaborationPriorityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CollaborationPriorityCodeType }
     *     
     */
    public void setCollaborationPriorityCode(CollaborationPriorityCodeType value) {
        this.collaborationPriorityCode = value;
    }

    /**
     * Gets the value of the exceptionResolutionCode property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the exceptionResolutionCode property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getExceptionResolutionCode().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ExceptionResolutionCodeType }
     * 
     * 
     */
    public List<ExceptionResolutionCodeType> getExceptionResolutionCode() {
        if (exceptionResolutionCode == null) {
            exceptionResolutionCode = new ArrayList<ExceptionResolutionCodeType>();
        }
        return this.exceptionResolutionCode;
    }

    /**
     * Gets the value of the supplyChainActivityTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link SupplyChainActivityTypeCodeType }
     *     
     */
    public SupplyChainActivityTypeCodeType getSupplyChainActivityTypeCode() {
        return supplyChainActivityTypeCode;
    }

    /**
     * Sets the value of the supplyChainActivityTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplyChainActivityTypeCodeType }
     *     
     */
    public void setSupplyChainActivityTypeCode(SupplyChainActivityTypeCodeType value) {
        this.supplyChainActivityTypeCode = value;
    }

    /**
     * Gets the value of the performanceMetricTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link PerformanceMetricTypeCodeType }
     *     
     */
    public PerformanceMetricTypeCodeType getPerformanceMetricTypeCode() {
        return performanceMetricTypeCode;
    }

    /**
     * Sets the value of the performanceMetricTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformanceMetricTypeCodeType }
     *     
     */
    public void setPerformanceMetricTypeCode(PerformanceMetricTypeCodeType value) {
        this.performanceMetricTypeCode = value;
    }

    /**
     * Gets the value of the effectivePeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getEffectivePeriod() {
        return effectivePeriod;
    }

    /**
     * Sets the value of the effectivePeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setEffectivePeriod(PeriodType value) {
        this.effectivePeriod = value;
    }

    /**
     * Gets the value of the supplyItem property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the supplyItem property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getSupplyItem().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ItemType }
     * 
     * 
     */
    public List<ItemType> getSupplyItem() {
        if (supplyItem == null) {
            supplyItem = new ArrayList<ItemType>();
        }
        return this.supplyItem;
    }

    /**
     * Gets the value of the forecastExceptionCriteriaLine property.
     * 
     * @return
     *     possible object is
     *     {@link ForecastExceptionCriteriaLineType }
     *     
     */
    public ForecastExceptionCriteriaLineType getForecastExceptionCriteriaLine() {
        return forecastExceptionCriteriaLine;
    }

    /**
     * Sets the value of the forecastExceptionCriteriaLine property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForecastExceptionCriteriaLineType }
     *     
     */
    public void setForecastExceptionCriteriaLine(ForecastExceptionCriteriaLineType value) {
        this.forecastExceptionCriteriaLine = value;
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
