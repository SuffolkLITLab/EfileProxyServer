
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedOverallContractQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FeeDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProcurementSubTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ProcurementTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.QualityControlCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedDeliveryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredFeeAmountType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ProcurementProjectType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ProcurementProjectType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Name" maxOccurs="unbounded"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Description" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProcurementTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ProcurementSubTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}QualityControlCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequiredFeeAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FeeDescription" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RequestedDeliveryDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EstimatedOverallContractQuantity" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}BudgetAmount" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequiredCommodityClassification" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RealizedLocation" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PlannedPeriod" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ContractExtension" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RequestForTenderLine" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcurementProjectType", propOrder = {
    "id",
    "name",
    "description",
    "procurementTypeCode",
    "procurementSubTypeCode",
    "qualityControlCode",
    "requiredFeeAmount",
    "feeDescription",
    "requestedDeliveryDate",
    "estimatedOverallContractQuantity",
    "budgetAmount",
    "requiredCommodityClassification",
    "realizedLocation",
    "plannedPeriod",
    "contractExtension",
    "requestForTenderLine"
})
public class ProcurementProjectType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "Name", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected List<NameType> name;
    @XmlElement(name = "Description", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<DescriptionType> description;
    @XmlElement(name = "ProcurementTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ProcurementTypeCodeType procurementTypeCode;
    @XmlElement(name = "ProcurementSubTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ProcurementSubTypeCodeType procurementSubTypeCode;
    @XmlElement(name = "QualityControlCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected QualityControlCodeType qualityControlCode;
    @XmlElement(name = "RequiredFeeAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequiredFeeAmountType requiredFeeAmount;
    @XmlElement(name = "FeeDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<FeeDescriptionType> feeDescription;
    @XmlElement(name = "RequestedDeliveryDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RequestedDeliveryDateType requestedDeliveryDate;
    @XmlElement(name = "EstimatedOverallContractQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EstimatedOverallContractQuantityType estimatedOverallContractQuantity;
    @XmlElement(name = "BudgetAmount")
    protected BudgetAmountType budgetAmount;
    @XmlElement(name = "RequiredCommodityClassification")
    protected List<CommodityClassificationType> requiredCommodityClassification;
    @XmlElement(name = "RealizedLocation")
    protected List<LocationType> realizedLocation;
    @XmlElement(name = "PlannedPeriod")
    protected PeriodType plannedPeriod;
    @XmlElement(name = "ContractExtension")
    protected ContractExtensionType contractExtension;
    @XmlElement(name = "RequestForTenderLine")
    protected List<RequestForTenderLineType> requestForTenderLine;

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
     * Gets the value of the name property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the name property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getName().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link NameType }
     * 
     * 
     */
    public List<NameType> getName() {
        if (name == null) {
            name = new ArrayList<NameType>();
        }
        return this.name;
    }

    /**
     * Gets the value of the description property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the description property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDescription().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DescriptionType }
     * 
     * 
     */
    public List<DescriptionType> getDescription() {
        if (description == null) {
            description = new ArrayList<DescriptionType>();
        }
        return this.description;
    }

    /**
     * Gets the value of the procurementTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ProcurementTypeCodeType }
     *     
     */
    public ProcurementTypeCodeType getProcurementTypeCode() {
        return procurementTypeCode;
    }

    /**
     * Sets the value of the procurementTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcurementTypeCodeType }
     *     
     */
    public void setProcurementTypeCode(ProcurementTypeCodeType value) {
        this.procurementTypeCode = value;
    }

    /**
     * Gets the value of the procurementSubTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ProcurementSubTypeCodeType }
     *     
     */
    public ProcurementSubTypeCodeType getProcurementSubTypeCode() {
        return procurementSubTypeCode;
    }

    /**
     * Sets the value of the procurementSubTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcurementSubTypeCodeType }
     *     
     */
    public void setProcurementSubTypeCode(ProcurementSubTypeCodeType value) {
        this.procurementSubTypeCode = value;
    }

    /**
     * Gets the value of the qualityControlCode property.
     * 
     * @return
     *     possible object is
     *     {@link QualityControlCodeType }
     *     
     */
    public QualityControlCodeType getQualityControlCode() {
        return qualityControlCode;
    }

    /**
     * Sets the value of the qualityControlCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualityControlCodeType }
     *     
     */
    public void setQualityControlCode(QualityControlCodeType value) {
        this.qualityControlCode = value;
    }

    /**
     * Gets the value of the requiredFeeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link RequiredFeeAmountType }
     *     
     */
    public RequiredFeeAmountType getRequiredFeeAmount() {
        return requiredFeeAmount;
    }

    /**
     * Sets the value of the requiredFeeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequiredFeeAmountType }
     *     
     */
    public void setRequiredFeeAmount(RequiredFeeAmountType value) {
        this.requiredFeeAmount = value;
    }

    /**
     * Gets the value of the feeDescription property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the feeDescription property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getFeeDescription().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link FeeDescriptionType }
     * 
     * 
     */
    public List<FeeDescriptionType> getFeeDescription() {
        if (feeDescription == null) {
            feeDescription = new ArrayList<FeeDescriptionType>();
        }
        return this.feeDescription;
    }

    /**
     * Gets the value of the requestedDeliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link RequestedDeliveryDateType }
     *     
     */
    public RequestedDeliveryDateType getRequestedDeliveryDate() {
        return requestedDeliveryDate;
    }

    /**
     * Sets the value of the requestedDeliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestedDeliveryDateType }
     *     
     */
    public void setRequestedDeliveryDate(RequestedDeliveryDateType value) {
        this.requestedDeliveryDate = value;
    }

    /**
     * Gets the value of the estimatedOverallContractQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link EstimatedOverallContractQuantityType }
     *     
     */
    public EstimatedOverallContractQuantityType getEstimatedOverallContractQuantity() {
        return estimatedOverallContractQuantity;
    }

    /**
     * Sets the value of the estimatedOverallContractQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimatedOverallContractQuantityType }
     *     
     */
    public void setEstimatedOverallContractQuantity(EstimatedOverallContractQuantityType value) {
        this.estimatedOverallContractQuantity = value;
    }

    /**
     * Gets the value of the budgetAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BudgetAmountType }
     *     
     */
    public BudgetAmountType getBudgetAmount() {
        return budgetAmount;
    }

    /**
     * Sets the value of the budgetAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BudgetAmountType }
     *     
     */
    public void setBudgetAmount(BudgetAmountType value) {
        this.budgetAmount = value;
    }

    /**
     * Gets the value of the requiredCommodityClassification property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the requiredCommodityClassification property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRequiredCommodityClassification().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CommodityClassificationType }
     * 
     * 
     */
    public List<CommodityClassificationType> getRequiredCommodityClassification() {
        if (requiredCommodityClassification == null) {
            requiredCommodityClassification = new ArrayList<CommodityClassificationType>();
        }
        return this.requiredCommodityClassification;
    }

    /**
     * Gets the value of the realizedLocation property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the realizedLocation property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRealizedLocation().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link LocationType }
     * 
     * 
     */
    public List<LocationType> getRealizedLocation() {
        if (realizedLocation == null) {
            realizedLocation = new ArrayList<LocationType>();
        }
        return this.realizedLocation;
    }

    /**
     * Gets the value of the plannedPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getPlannedPeriod() {
        return plannedPeriod;
    }

    /**
     * Sets the value of the plannedPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setPlannedPeriod(PeriodType value) {
        this.plannedPeriod = value;
    }

    /**
     * Gets the value of the contractExtension property.
     * 
     * @return
     *     possible object is
     *     {@link ContractExtensionType }
     *     
     */
    public ContractExtensionType getContractExtension() {
        return contractExtension;
    }

    /**
     * Sets the value of the contractExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractExtensionType }
     *     
     */
    public void setContractExtension(ContractExtensionType value) {
        this.contractExtension = value;
    }

    /**
     * Gets the value of the requestForTenderLine property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the requestForTenderLine property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getRequestForTenderLine().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link RequestForTenderLineType }
     * 
     * 
     */
    public List<RequestForTenderLineType> getRequestForTenderLine() {
        if (requestForTenderLine == null) {
            requestForTenderLine = new ArrayList<RequestForTenderLineType>();
        }
        return this.requestForTenderLine;
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
