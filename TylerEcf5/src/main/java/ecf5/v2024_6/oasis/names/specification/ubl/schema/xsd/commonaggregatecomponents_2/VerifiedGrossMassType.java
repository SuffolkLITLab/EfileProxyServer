
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossMassMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeighingDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeighingDeviceIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeighingDeviceTypeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeighingMethodCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeighingTimeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe a verified gross mass (VGM) measure and its documentation.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:AlternativeBusinessTerms&gt;VGM&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for VerifiedGrossMassType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VerifiedGrossMassType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WeighingDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WeighingTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WeighingMethodCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WeighingDeviceID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}WeighingDeviceType" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}GrossMassMeasure"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}WeighingParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ShipperParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ResponsibleParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentReference" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VerifiedGrossMassType", propOrder = {
    "id",
    "weighingDate",
    "weighingTime",
    "weighingMethodCode",
    "weighingDeviceID",
    "weighingDeviceType",
    "grossMassMeasure",
    "weighingParty",
    "shipperParty",
    "responsibleParty",
    "documentReference"
})
public class VerifiedGrossMassType {

    @XmlElement(name = "ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "WeighingDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected WeighingDateType weighingDate;
    @XmlElement(name = "WeighingTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected WeighingTimeType weighingTime;
    @XmlElement(name = "WeighingMethodCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected WeighingMethodCodeType weighingMethodCode;
    @XmlElement(name = "WeighingDeviceID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected WeighingDeviceIDType weighingDeviceID;
    @XmlElement(name = "WeighingDeviceType", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected WeighingDeviceTypeType weighingDeviceType;
    @XmlElement(name = "GrossMassMeasure", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected GrossMassMeasureType grossMassMeasure;
    @XmlElement(name = "WeighingParty")
    protected PartyType weighingParty;
    @XmlElement(name = "ShipperParty")
    protected PartyType shipperParty;
    @XmlElement(name = "ResponsibleParty")
    protected PartyType responsibleParty;
    @XmlElement(name = "DocumentReference", required = true)
    protected List<DocumentReferenceType> documentReference;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for this mass measure.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
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
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Weighing Date. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The weighing date.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Weighing Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link WeighingDateType }
     *     
     */
    public WeighingDateType getWeighingDate() {
        return weighingDate;
    }

    /**
     * Sets the value of the weighingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeighingDateType }
     *     
     */
    public void setWeighingDate(WeighingDateType value) {
        this.weighingDate = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Weighing Time. Time&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The weighing time.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Weighing Time&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Time&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Time. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link WeighingTimeType }
     *     
     */
    public WeighingTimeType getWeighingTime() {
        return weighingTime;
    }

    /**
     * Sets the value of the weighingTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeighingTimeType }
     *     
     */
    public void setWeighingTime(WeighingTimeType value) {
        this.weighingTime = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Weighing Method Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying the weighing method used (e.g. according the SOLAS Convention).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Weighing Method Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataTypeQualifier&gt;Weighing Method&lt;/ccts:DataTypeQualifier&gt;&lt;ccts:DataType&gt;Weighing Method_ Code. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;1, 2&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link WeighingMethodCodeType }
     *     
     */
    public WeighingMethodCodeType getWeighingMethodCode() {
        return weighingMethodCode;
    }

    /**
     * Sets the value of the weighingMethodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeighingMethodCodeType }
     *     
     */
    public void setWeighingMethodCode(WeighingMethodCodeType value) {
        this.weighingMethodCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Weighing Device Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the weighing device used for executing the weight measurement.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Weighing Device Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;WeighScale-01&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link WeighingDeviceIDType }
     *     
     */
    public WeighingDeviceIDType getWeighingDeviceID() {
        return weighingDeviceID;
    }

    /**
     * Sets the value of the weighingDeviceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeighingDeviceIDType }
     *     
     */
    public void setWeighingDeviceID(WeighingDeviceIDType value) {
        this.weighingDeviceID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Weighing Device Type. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Text describing the weighing device type used for executing the weight measurement.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Weighing Device Type&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Truck Scale, Weighbridge&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link WeighingDeviceTypeType }
     *     
     */
    public WeighingDeviceTypeType getWeighingDeviceType() {
        return weighingDeviceType;
    }

    /**
     * Sets the value of the weighingDeviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeighingDeviceTypeType }
     *     
     */
    public void setWeighingDeviceType(WeighingDeviceTypeType value) {
        this.weighingDeviceType = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Gross_ Mass. Measure&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The total verified gross mass of a packed container which includes the cargo weight, block and bracing materials and container tare.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Gross&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Mass&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Measure&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Measure. Type&lt;/ccts:DataType&gt;&lt;ccts:AlternativeBusinessTerms&gt;VGM&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link GrossMassMeasureType }
     *     
     */
    public GrossMassMeasureType getGrossMassMeasure() {
        return grossMassMeasure;
    }

    /**
     * Sets the value of the grossMassMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link GrossMassMeasureType }
     *     
     */
    public void setGrossMassMeasure(GrossMassMeasureType value) {
        this.grossMassMeasure = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Weighing_ Party. Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The party executing the weight measure.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Weighing&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Party&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Party&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getWeighingParty() {
        return weighingParty;
    }

    /**
     * Sets the value of the weighingParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setWeighingParty(PartyType value) {
        this.weighingParty = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Shipper_ Party. Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The party playing the role of the Shipper (BCO, FF or NVOCC) who is responsible for the VGM (e.g. according the SOLAS Convention).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Shipper&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Party&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Party&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getShipperParty() {
        return shipperParty;
    }

    /**
     * Sets the value of the shipperParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setShipperParty(PartyType value) {
        this.shipperParty = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Responsible_ Party. Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The party responsible for signing the VGM on behalf of the Shipper.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Responsible&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Party&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Party&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getResponsibleParty() {
        return responsibleParty;
    }

    /**
     * Sets the value of the responsibleParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setResponsibleParty(PartyType value) {
        this.responsibleParty = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Verified Gross Mass. Document Reference&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A reference to the VGM documentary evidence.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Verified Gross Mass&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Document Reference&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Document Reference&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Document Reference&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the documentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getDocumentReference() {
        if (documentReference == null) {
            documentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.documentReference;
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
