
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeliveredQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestMeterQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestMeterReadingDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterReadingCommentsType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterReadingMethodCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterReadingMethodType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterReadingTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterReadingTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousMeterQuantityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousMeterReadingDateType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for MeterReadingType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="MeterReadingType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterReadingType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterReadingTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreviousMeterReadingDate"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreviousMeterQuantity"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestMeterReadingDate"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestMeterQuantity"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterReadingMethod" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterReadingMethodCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterReadingComments" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeliveredQuantity"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterReadingType", propOrder = {
    "meterReadingType",
    "meterReadingTypeCode",
    "previousMeterReadingDate",
    "previousMeterQuantity",
    "latestMeterReadingDate",
    "latestMeterQuantity",
    "meterReadingMethod",
    "meterReadingMethodCode",
    "meterReadingComments",
    "deliveredQuantity"
})
public class MeterReadingType {

    @XmlElement(name = "MeterReadingType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeterReadingTypeType meterReadingType;
    @XmlElement(name = "MeterReadingTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeterReadingTypeCodeType meterReadingTypeCode;
    @XmlElement(name = "PreviousMeterReadingDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PreviousMeterReadingDateType previousMeterReadingDate;
    @XmlElement(name = "PreviousMeterQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PreviousMeterQuantityType previousMeterQuantity;
    @XmlElement(name = "LatestMeterReadingDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected LatestMeterReadingDateType latestMeterReadingDate;
    @XmlElement(name = "LatestMeterQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected LatestMeterQuantityType latestMeterQuantity;
    @XmlElement(name = "MeterReadingMethod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeterReadingMethodType meterReadingMethod;
    @XmlElement(name = "MeterReadingMethodCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MeterReadingMethodCodeType meterReadingMethodCode;
    @XmlElement(name = "MeterReadingComments", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<MeterReadingCommentsType> meterReadingComments;
    @XmlElement(name = "DeliveredQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected DeliveredQuantityType deliveredQuantity;

    /**
     * Gets the value of the meterReadingType property.
     * 
     * @return
     *     possible object is
     *     {@link MeterReadingTypeType }
     *     
     */
    public MeterReadingTypeType getMeterReadingType() {
        return meterReadingType;
    }

    /**
     * Sets the value of the meterReadingType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterReadingTypeType }
     *     
     */
    public void setMeterReadingType(MeterReadingTypeType value) {
        this.meterReadingType = value;
    }

    /**
     * Gets the value of the meterReadingTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link MeterReadingTypeCodeType }
     *     
     */
    public MeterReadingTypeCodeType getMeterReadingTypeCode() {
        return meterReadingTypeCode;
    }

    /**
     * Sets the value of the meterReadingTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterReadingTypeCodeType }
     *     
     */
    public void setMeterReadingTypeCode(MeterReadingTypeCodeType value) {
        this.meterReadingTypeCode = value;
    }

    /**
     * Gets the value of the previousMeterReadingDate property.
     * 
     * @return
     *     possible object is
     *     {@link PreviousMeterReadingDateType }
     *     
     */
    public PreviousMeterReadingDateType getPreviousMeterReadingDate() {
        return previousMeterReadingDate;
    }

    /**
     * Sets the value of the previousMeterReadingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousMeterReadingDateType }
     *     
     */
    public void setPreviousMeterReadingDate(PreviousMeterReadingDateType value) {
        this.previousMeterReadingDate = value;
    }

    /**
     * Gets the value of the previousMeterQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link PreviousMeterQuantityType }
     *     
     */
    public PreviousMeterQuantityType getPreviousMeterQuantity() {
        return previousMeterQuantity;
    }

    /**
     * Sets the value of the previousMeterQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousMeterQuantityType }
     *     
     */
    public void setPreviousMeterQuantity(PreviousMeterQuantityType value) {
        this.previousMeterQuantity = value;
    }

    /**
     * Gets the value of the latestMeterReadingDate property.
     * 
     * @return
     *     possible object is
     *     {@link LatestMeterReadingDateType }
     *     
     */
    public LatestMeterReadingDateType getLatestMeterReadingDate() {
        return latestMeterReadingDate;
    }

    /**
     * Sets the value of the latestMeterReadingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestMeterReadingDateType }
     *     
     */
    public void setLatestMeterReadingDate(LatestMeterReadingDateType value) {
        this.latestMeterReadingDate = value;
    }

    /**
     * Gets the value of the latestMeterQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link LatestMeterQuantityType }
     *     
     */
    public LatestMeterQuantityType getLatestMeterQuantity() {
        return latestMeterQuantity;
    }

    /**
     * Sets the value of the latestMeterQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestMeterQuantityType }
     *     
     */
    public void setLatestMeterQuantity(LatestMeterQuantityType value) {
        this.latestMeterQuantity = value;
    }

    /**
     * Gets the value of the meterReadingMethod property.
     * 
     * @return
     *     possible object is
     *     {@link MeterReadingMethodType }
     *     
     */
    public MeterReadingMethodType getMeterReadingMethod() {
        return meterReadingMethod;
    }

    /**
     * Sets the value of the meterReadingMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterReadingMethodType }
     *     
     */
    public void setMeterReadingMethod(MeterReadingMethodType value) {
        this.meterReadingMethod = value;
    }

    /**
     * Gets the value of the meterReadingMethodCode property.
     * 
     * @return
     *     possible object is
     *     {@link MeterReadingMethodCodeType }
     *     
     */
    public MeterReadingMethodCodeType getMeterReadingMethodCode() {
        return meterReadingMethodCode;
    }

    /**
     * Sets the value of the meterReadingMethodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MeterReadingMethodCodeType }
     *     
     */
    public void setMeterReadingMethodCode(MeterReadingMethodCodeType value) {
        this.meterReadingMethodCode = value;
    }

    /**
     * Gets the value of the meterReadingComments property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the meterReadingComments property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getMeterReadingComments().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link MeterReadingCommentsType }
     * 
     * 
     */
    public List<MeterReadingCommentsType> getMeterReadingComments() {
        if (meterReadingComments == null) {
            meterReadingComments = new ArrayList<MeterReadingCommentsType>();
        }
        return this.meterReadingComments;
    }

    /**
     * Gets the value of the deliveredQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link DeliveredQuantityType }
     *     
     */
    public DeliveredQuantityType getDeliveredQuantity() {
        return deliveredQuantity;
    }

    /**
     * Sets the value of the deliveredQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link DeliveredQuantityType }
     *     
     */
    public void setDeliveredQuantity(DeliveredQuantityType value) {
        this.deliveredQuantity = value;
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
