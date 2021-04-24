
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for EnergyWaterSupplyType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="EnergyWaterSupplyType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsumptionReport" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnergyTaxReport" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ConsumptionAverage" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EnergyWaterCorrection" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnergyWaterSupplyType", propOrder = {
    "consumptionReport",
    "energyTaxReport",
    "consumptionAverage",
    "energyWaterCorrection"
})
public class EnergyWaterSupplyType {

    @XmlElement(name = "ConsumptionReport")
    protected List<ConsumptionReportType> consumptionReport;
    @XmlElement(name = "EnergyTaxReport")
    protected List<EnergyTaxReportType> energyTaxReport;
    @XmlElement(name = "ConsumptionAverage")
    protected List<ConsumptionAverageType> consumptionAverage;
    @XmlElement(name = "EnergyWaterCorrection")
    protected List<CorrectionType> energyWaterCorrection;

    /**
     * Gets the value of the consumptionReport property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the consumptionReport property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getConsumptionReport().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionReportType }
     * 
     * 
     */
    public List<ConsumptionReportType> getConsumptionReport() {
        if (consumptionReport == null) {
            consumptionReport = new ArrayList<ConsumptionReportType>();
        }
        return this.consumptionReport;
    }

    /**
     * Gets the value of the energyTaxReport property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the energyTaxReport property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getEnergyTaxReport().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link EnergyTaxReportType }
     * 
     * 
     */
    public List<EnergyTaxReportType> getEnergyTaxReport() {
        if (energyTaxReport == null) {
            energyTaxReport = new ArrayList<EnergyTaxReportType>();
        }
        return this.energyTaxReport;
    }

    /**
     * Gets the value of the consumptionAverage property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the consumptionAverage property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getConsumptionAverage().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ConsumptionAverageType }
     * 
     * 
     */
    public List<ConsumptionAverageType> getConsumptionAverage() {
        if (consumptionAverage == null) {
            consumptionAverage = new ArrayList<ConsumptionAverageType>();
        }
        return this.consumptionAverage;
    }

    /**
     * Gets the value of the energyWaterCorrection property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the energyWaterCorrection property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getEnergyWaterCorrection().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link CorrectionType }
     * 
     * 
     */
    public List<CorrectionType> getEnergyWaterCorrection() {
        if (energyWaterCorrection == null) {
            energyWaterCorrection = new ArrayList<CorrectionType>();
        }
        return this.energyWaterCorrection;
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
