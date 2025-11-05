
package ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DeliveredQuantityType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestMeterQuantityType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestMeterReadingDateType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestMeterReadingMethodCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestMeterReadingMethodType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterReadingCommentsType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterReadingTypeCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeterReadingTypeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousMeterQuantityType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousMeterReadingDateType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousMeterReadingMethodCodeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousMeterReadingMethodType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe a meter reading.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for MeterReadingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeterReadingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterReadingType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterReadingTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreviousMeterReadingDate"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreviousMeterQuantity"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestMeterReadingDate"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestMeterQuantity"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreviousMeterReadingMethod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreviousMeterReadingMethodCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestMeterReadingMethod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}LatestMeterReadingMethodCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MeterReadingComments" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}DeliveredQuantity"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterReadingType", propOrder = {
    "id",
    "meterReadingType",
    "meterReadingTypeCode",
    "previousMeterReadingDate",
    "previousMeterQuantity",
    "latestMeterReadingDate",
    "latestMeterQuantity",
    "previousMeterReadingMethod",
    "previousMeterReadingMethodCode",
    "latestMeterReadingMethod",
    "latestMeterReadingMethodCode",
    "meterReadingComments",
    "deliveredQuantity"
})
public class MeterReadingType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
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
    @XmlElement(name = "PreviousMeterReadingMethod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PreviousMeterReadingMethodType previousMeterReadingMethod;
    @XmlElement(name = "PreviousMeterReadingMethodCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PreviousMeterReadingMethodCodeType previousMeterReadingMethodCode;
    @XmlElement(name = "LatestMeterReadingMethod", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatestMeterReadingMethodType latestMeterReadingMethod;
    @XmlElement(name = "LatestMeterReadingMethodCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected LatestMeterReadingMethodCodeType latestMeterReadingMethodCode;
    @XmlElement(name = "MeterReadingComments", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<MeterReadingCommentsType> meterReadingComments;
    @XmlElement(name = "DeliveredQuantity", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected DeliveredQuantityType deliveredQuantity;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for this meter reading.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;7411013716x&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
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
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Meter Reading Type. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The type of this meter reading, expressed as text.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Meter Reading Type&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Electricity&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Meter Reading Type Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The type of this meter reading, expressed as a code.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Meter Reading Type Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Electricity&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Previous_ Meter Reading Date. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The date of the previous meter reading.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Previous&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Meter Reading Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;2006-09-01&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Previous_ Meter Quantity. Quantity&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The quantity of the previous meter reading.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Previous&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Meter Quantity&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Quantity&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Quantity. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;122604.00&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Latest_ Meter Reading Date. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The date of the latest meter reading.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Latest&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Meter Reading Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;2006-09-01&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Latest_ Meter Quantity. Quantity&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The quantity of the latest meter reading.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Latest&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Meter Quantity&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Quantity&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Quantity. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;128365.00&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Previous Meter Reading_ Method. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The method used for the previous meter reading, expressed as text.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Previous Meter Reading&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Method&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Manuel&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PreviousMeterReadingMethodType }
     *     
     */
    public PreviousMeterReadingMethodType getPreviousMeterReadingMethod() {
        return previousMeterReadingMethod;
    }

    /**
     * Sets the value of the previousMeterReadingMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousMeterReadingMethodType }
     *     
     */
    public void setPreviousMeterReadingMethod(PreviousMeterReadingMethodType value) {
        this.previousMeterReadingMethod = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Previous Meter Reading_ Method Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The method used for the previous meter reading, expressed as a code.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Previous Meter Reading&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Method Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Estimated&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PreviousMeterReadingMethodCodeType }
     *     
     */
    public PreviousMeterReadingMethodCodeType getPreviousMeterReadingMethodCode() {
        return previousMeterReadingMethodCode;
    }

    /**
     * Sets the value of the previousMeterReadingMethodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousMeterReadingMethodCodeType }
     *     
     */
    public void setPreviousMeterReadingMethodCode(PreviousMeterReadingMethodCodeType value) {
        this.previousMeterReadingMethodCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Latest Meter Reading_ Method. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The method used for the latest meter reading, expressed as text.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Latest Meter Reading&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Method&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Manuel&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link LatestMeterReadingMethodType }
     *     
     */
    public LatestMeterReadingMethodType getLatestMeterReadingMethod() {
        return latestMeterReadingMethod;
    }

    /**
     * Sets the value of the latestMeterReadingMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestMeterReadingMethodType }
     *     
     */
    public void setLatestMeterReadingMethod(LatestMeterReadingMethodType value) {
        this.latestMeterReadingMethod = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Latest Meter Reading_ Method Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The method used for the latest meter reading, expressed as a code.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Latest Meter Reading&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Method Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Estimated&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link LatestMeterReadingMethodCodeType }
     *     
     */
    public LatestMeterReadingMethodCodeType getLatestMeterReadingMethodCode() {
        return latestMeterReadingMethodCode;
    }

    /**
     * Sets the value of the latestMeterReadingMethodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link LatestMeterReadingMethodCodeType }
     *     
     */
    public void setLatestMeterReadingMethodCode(LatestMeterReadingMethodCodeType value) {
        this.latestMeterReadingMethodCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Meter Reading_ Comments. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Text containing comments on this meter reading.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Meter Reading&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Comments&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;The last stated meterstand is estimated&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the meterReadingComments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the meterReadingComments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMeterReadingComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Meter Reading. Delivered_ Quantity. Quantity&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Consumption in the period from PreviousMeterReadingDate to LatestMeterReadingDate.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Meter Reading&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Delivered&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Quantity&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Quantity&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Quantity. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
