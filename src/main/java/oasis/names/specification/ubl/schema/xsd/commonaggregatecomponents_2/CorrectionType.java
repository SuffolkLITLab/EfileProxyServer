
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualTemperatureReductionQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionEnergyQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConsumptionWaterQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CorrectionAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CorrectionTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CorrectionTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CorrectionUnitAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DifferenceTemperatureReductionQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GasPressureQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterNumberType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NormalTemperatureReductionQuantityType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for CorrectionType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CorrectionType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CorrectionType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CorrectionTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterNumber" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GasPressureQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ActualTemperatureReductionQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NormalTemperatureReductionQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DifferenceTemperatureReductionQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CorrectionUnitAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionEnergyQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ConsumptionWaterQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CorrectionAmount" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CorrectionType", propOrder = {
    "correctionType",
    "correctionTypeCode",
    "meterNumber",
    "gasPressureQuantity",
    "actualTemperatureReductionQuantity",
    "normalTemperatureReductionQuantity",
    "differenceTemperatureReductionQuantity",
    "description",
    "correctionUnitAmount",
    "consumptionEnergyQuantity",
    "consumptionWaterQuantity",
    "correctionAmount"
})
public class CorrectionType {

    @XmlElement(name = "CorrectionType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CorrectionTypeType correctionType;
    @XmlElement(name = "CorrectionTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CorrectionTypeCodeType correctionTypeCode;
    @XmlElement(name = "MeterNumber", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeterNumberType meterNumber;
    @XmlElement(name = "GasPressureQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected GasPressureQuantityType gasPressureQuantity;
    @XmlElement(name = "ActualTemperatureReductionQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ActualTemperatureReductionQuantityType actualTemperatureReductionQuantity;
    @XmlElement(name = "NormalTemperatureReductionQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NormalTemperatureReductionQuantityType normalTemperatureReductionQuantity;
    @XmlElement(name = "DifferenceTemperatureReductionQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DifferenceTemperatureReductionQuantityType differenceTemperatureReductionQuantity;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected DescriptionType description;
    @XmlElement(name = "CorrectionUnitAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CorrectionUnitAmountType correctionUnitAmount;
    @XmlElement(name = "ConsumptionEnergyQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionEnergyQuantityType consumptionEnergyQuantity;
    @XmlElement(name = "ConsumptionWaterQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ConsumptionWaterQuantityType consumptionWaterQuantity;
    @XmlElement(name = "CorrectionAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CorrectionAmountType correctionAmount;

    /**
     * Gets the value of the correctionType property.
     * 
     * @return
     *     possible object is
     *     {@link CorrectionTypeType }
     *     
     */
    public CorrectionTypeType getCorrectionType() {
        return correctionType;
    }

    /**
     * Sets the value of the correctionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorrectionTypeType }
     *     
     */
    public void setCorrectionType(CorrectionTypeType value) {
        this.correctionType = value;
    }

    /**
     * Gets the value of the correctionTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link CorrectionTypeCodeType }
     *     
     */
    public CorrectionTypeCodeType getCorrectionTypeCode() {
        return correctionTypeCode;
    }

    /**
     * Sets the value of the correctionTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorrectionTypeCodeType }
     *     
     */
    public void setCorrectionTypeCode(CorrectionTypeCodeType value) {
        this.correctionTypeCode = value;
    }

    /**
     * Gets the value of the meterNumber property.
     * 
     * @return
     *     possible object is
     *     {@link MeterNumberType }
     *     
     */
    public MeterNumberType getMeterNumber() {
        return meterNumber;
    }

    /**
     * Sets the value of the meterNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterNumberType }
     *     
     */
    public void setMeterNumber(MeterNumberType value) {
        this.meterNumber = value;
    }

    /**
     * Gets the value of the gasPressureQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link GasPressureQuantityType }
     *     
     */
    public GasPressureQuantityType getGasPressureQuantity() {
        return gasPressureQuantity;
    }

    /**
     * Sets the value of the gasPressureQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link GasPressureQuantityType }
     *     
     */
    public void setGasPressureQuantity(GasPressureQuantityType value) {
        this.gasPressureQuantity = value;
    }

    /**
     * Gets the value of the actualTemperatureReductionQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link ActualTemperatureReductionQuantityType }
     *     
     */
    public ActualTemperatureReductionQuantityType getActualTemperatureReductionQuantity() {
        return actualTemperatureReductionQuantity;
    }

    /**
     * Sets the value of the actualTemperatureReductionQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ActualTemperatureReductionQuantityType }
     *     
     */
    public void setActualTemperatureReductionQuantity(ActualTemperatureReductionQuantityType value) {
        this.actualTemperatureReductionQuantity = value;
    }

    /**
     * Gets the value of the normalTemperatureReductionQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link NormalTemperatureReductionQuantityType }
     *     
     */
    public NormalTemperatureReductionQuantityType getNormalTemperatureReductionQuantity() {
        return normalTemperatureReductionQuantity;
    }

    /**
     * Sets the value of the normalTemperatureReductionQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalTemperatureReductionQuantityType }
     *     
     */
    public void setNormalTemperatureReductionQuantity(NormalTemperatureReductionQuantityType value) {
        this.normalTemperatureReductionQuantity = value;
    }

    /**
     * Gets the value of the differenceTemperatureReductionQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link DifferenceTemperatureReductionQuantityType }
     *     
     */
    public DifferenceTemperatureReductionQuantityType getDifferenceTemperatureReductionQuantity() {
        return differenceTemperatureReductionQuantity;
    }

    /**
     * Sets the value of the differenceTemperatureReductionQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link DifferenceTemperatureReductionQuantityType }
     *     
     */
    public void setDifferenceTemperatureReductionQuantity(DifferenceTemperatureReductionQuantityType value) {
        this.differenceTemperatureReductionQuantity = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link DescriptionType }
     *     
     */
    public DescriptionType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link DescriptionType }
     *     
     */
    public void setDescription(DescriptionType value) {
        this.description = value;
    }

    /**
     * Gets the value of the correctionUnitAmount property.
     * 
     * @return
     *     possible object is
     *     {@link CorrectionUnitAmountType }
     *     
     */
    public CorrectionUnitAmountType getCorrectionUnitAmount() {
        return correctionUnitAmount;
    }

    /**
     * Sets the value of the correctionUnitAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorrectionUnitAmountType }
     *     
     */
    public void setCorrectionUnitAmount(CorrectionUnitAmountType value) {
        this.correctionUnitAmount = value;
    }

    /**
     * Gets the value of the consumptionEnergyQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionEnergyQuantityType }
     *     
     */
    public ConsumptionEnergyQuantityType getConsumptionEnergyQuantity() {
        return consumptionEnergyQuantity;
    }

    /**
     * Sets the value of the consumptionEnergyQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionEnergyQuantityType }
     *     
     */
    public void setConsumptionEnergyQuantity(ConsumptionEnergyQuantityType value) {
        this.consumptionEnergyQuantity = value;
    }

    /**
     * Gets the value of the consumptionWaterQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link ConsumptionWaterQuantityType }
     *     
     */
    public ConsumptionWaterQuantityType getConsumptionWaterQuantity() {
        return consumptionWaterQuantity;
    }

    /**
     * Sets the value of the consumptionWaterQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumptionWaterQuantityType }
     *     
     */
    public void setConsumptionWaterQuantity(ConsumptionWaterQuantityType value) {
        this.consumptionWaterQuantity = value;
    }

    /**
     * Gets the value of the correctionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link CorrectionAmountType }
     *     
     */
    public CorrectionAmountType getCorrectionAmount() {
        return correctionAmount;
    }

    /**
     * Sets the value of the correctionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorrectionAmountType }
     *     
     */
    public void setCorrectionAmount(CorrectionAmountType value) {
        this.correctionAmount = value;
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
