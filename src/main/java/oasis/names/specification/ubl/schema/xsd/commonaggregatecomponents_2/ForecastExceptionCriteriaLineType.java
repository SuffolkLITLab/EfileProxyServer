
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ComparisonDataSourceCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DataSourceCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ForecastPurposeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ForecastTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TimeDeltaDaysQuantityType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ForecastExceptionCriteriaLineType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ForecastExceptionCriteriaLineType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ForecastPurposeCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ForecastTypeCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ComparisonDataSourceCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DataSourceCode"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TimeDeltaDaysQuantity" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForecastExceptionCriteriaLineType", propOrder = {
    "forecastPurposeCode",
    "forecastTypeCode",
    "comparisonDataSourceCode",
    "dataSourceCode",
    "timeDeltaDaysQuantity"
})
public class ForecastExceptionCriteriaLineType {

    @XmlElement(name = "ForecastPurposeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ForecastPurposeCodeType forecastPurposeCode;
    @XmlElement(name = "ForecastTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ForecastTypeCodeType forecastTypeCode;
    @XmlElement(name = "ComparisonDataSourceCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ComparisonDataSourceCodeType comparisonDataSourceCode;
    @XmlElement(name = "DataSourceCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected DataSourceCodeType dataSourceCode;
    @XmlElement(name = "TimeDeltaDaysQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TimeDeltaDaysQuantityType timeDeltaDaysQuantity;

    /**
     * Gets the value of the forecastPurposeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ForecastPurposeCodeType }
     *     
     */
    public ForecastPurposeCodeType getForecastPurposeCode() {
        return forecastPurposeCode;
    }

    /**
     * Sets the value of the forecastPurposeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForecastPurposeCodeType }
     *     
     */
    public void setForecastPurposeCode(ForecastPurposeCodeType value) {
        this.forecastPurposeCode = value;
    }

    /**
     * Gets the value of the forecastTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ForecastTypeCodeType }
     *     
     */
    public ForecastTypeCodeType getForecastTypeCode() {
        return forecastTypeCode;
    }

    /**
     * Sets the value of the forecastTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ForecastTypeCodeType }
     *     
     */
    public void setForecastTypeCode(ForecastTypeCodeType value) {
        this.forecastTypeCode = value;
    }

    /**
     * Gets the value of the comparisonDataSourceCode property.
     * 
     * @return
     *     possible object is
     *     {@link ComparisonDataSourceCodeType }
     *     
     */
    public ComparisonDataSourceCodeType getComparisonDataSourceCode() {
        return comparisonDataSourceCode;
    }

    /**
     * Sets the value of the comparisonDataSourceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ComparisonDataSourceCodeType }
     *     
     */
    public void setComparisonDataSourceCode(ComparisonDataSourceCodeType value) {
        this.comparisonDataSourceCode = value;
    }

    /**
     * Gets the value of the dataSourceCode property.
     * 
     * @return
     *     possible object is
     *     {@link DataSourceCodeType }
     *     
     */
    public DataSourceCodeType getDataSourceCode() {
        return dataSourceCode;
    }

    /**
     * Sets the value of the dataSourceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSourceCodeType }
     *     
     */
    public void setDataSourceCode(DataSourceCodeType value) {
        this.dataSourceCode = value;
    }

    /**
     * Gets the value of the timeDeltaDaysQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link TimeDeltaDaysQuantityType }
     *     
     */
    public TimeDeltaDaysQuantityType getTimeDeltaDaysQuantity() {
        return timeDeltaDaysQuantity;
    }

    /**
     * Sets the value of the timeDeltaDaysQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeDeltaDaysQuantityType }
     *     
     */
    public void setTimeDeltaDaysQuantity(TimeDeltaDaysQuantityType value) {
        this.timeDeltaDaysQuantity = value;
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
