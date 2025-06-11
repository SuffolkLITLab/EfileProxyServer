
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FreightRateClassCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NominationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NominationTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PriorityType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TariffClassCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportServiceCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportationServiceDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TransportationServiceDetailsURIType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Transportation Service. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Transport service details.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Transportation Service&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for TransportationServiceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransportationServiceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportServiceCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TariffClassCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Priority" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FreightRateClassCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportationServiceDescription" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TransportationServiceDetailsURI" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NominationDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NominationTime" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportationServiceType", propOrder = {
    "transportServiceCode",
    "tariffClassCode",
    "priority",
    "freightRateClassCode",
    "transportationServiceDescription",
    "transportationServiceDetailsURI",
    "nominationDate",
    "nominationTime"
})
public class TransportationServiceType {

    @XmlElement(name = "TransportServiceCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected TransportServiceCodeType transportServiceCode;
    @XmlElement(name = "TariffClassCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TariffClassCodeType tariffClassCode;
    @XmlElement(name = "Priority", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PriorityType priority;
    @XmlElement(name = "FreightRateClassCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FreightRateClassCodeType freightRateClassCode;
    @XmlElement(name = "TransportationServiceDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportationServiceDescriptionType transportationServiceDescription;
    @XmlElement(name = "TransportationServiceDetailsURI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TransportationServiceDetailsURIType transportationServiceDetailsURI;
    @XmlElement(name = "NominationDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NominationDateType nominationDate;
    @XmlElement(name = "NominationTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NominationTimeType nominationTime;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Transportation Service. Transport Service Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code which describes the general type of service required for the transportation of goods. Specifically, it identifies the extent of the transportation service, e.g., door-to-door, port-to-port.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Transportation Service&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Transport Service Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link TransportServiceCodeType }
     *     
     */
    public TransportServiceCodeType getTransportServiceCode() {
        return transportServiceCode;
    }

    /**
     * Sets the value of the transportServiceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportServiceCodeType }
     *     
     */
    public void setTransportServiceCode(TransportServiceCodeType value) {
        this.transportServiceCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Transportation Service. Tariff Class Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Specification of a tariff class applicable to a transportation service.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Transportation Service&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Tariff Class Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;ccts:AlternativeBusinessTerms&gt;Tariff Class Specifier&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link TariffClassCodeType }
     *     
     */
    public TariffClassCodeType getTariffClassCode() {
        return tariffClassCode;
    }

    /**
     * Sets the value of the tariffClassCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TariffClassCodeType }
     *     
     */
    public void setTariffClassCode(TariffClassCodeType value) {
        this.tariffClassCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Transportation Service. Priority. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Statement indicating priority of requested transportation service.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Transportation Service&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Priority&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PriorityType }
     *     
     */
    public PriorityType getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link PriorityType }
     *     
     */
    public void setPriority(PriorityType value) {
        this.priority = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Transportation Service. Freight Rate Class Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Code to indicate applicable rate class for freight.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Transportation Service&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Freight Rate Class Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;ccts:AlternativeBusinessTerms&gt;Charge Basis&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link FreightRateClassCodeType }
     *     
     */
    public FreightRateClassCodeType getFreightRateClassCode() {
        return freightRateClassCode;
    }

    /**
     * Sets the value of the freightRateClassCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FreightRateClassCodeType }
     *     
     */
    public void setFreightRateClassCode(FreightRateClassCodeType value) {
        this.freightRateClassCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Transportation Service. Transportation Service Description. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A textual description of the transportation service&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Transportation Service&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Transportation Service Description&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link TransportationServiceDescriptionType }
     *     
     */
    public TransportationServiceDescriptionType getTransportationServiceDescription() {
        return transportationServiceDescription;
    }

    /**
     * Sets the value of the transportationServiceDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationServiceDescriptionType }
     *     
     */
    public void setTransportationServiceDescription(TransportationServiceDescriptionType value) {
        this.transportationServiceDescription = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Transportation Service. Transportation Service Details URI. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An URI to additional specification of the transportation service, e.g. a company website with service specifications&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Transportation Service&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Transportation Service Details URI&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link TransportationServiceDetailsURIType }
     *     
     */
    public TransportationServiceDetailsURIType getTransportationServiceDetailsURI() {
        return transportationServiceDetailsURI;
    }

    /**
     * Sets the value of the transportationServiceDetailsURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransportationServiceDetailsURIType }
     *     
     */
    public void setTransportationServiceDetailsURI(TransportationServiceDetailsURIType value) {
        this.transportationServiceDetailsURI = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Transportation Service. Nomination Date. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The deadline date for which this service has to be booked. For example if this service is executed Wednesday February 16th 2011 at 10 a.m. CET, the Nomination Date might be Tuesday February 15th 2011.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Transportation Service&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Nomination Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link NominationDateType }
     *     
     */
    public NominationDateType getNominationDate() {
        return nominationDate;
    }

    /**
     * Sets the value of the nominationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link NominationDateType }
     *     
     */
    public void setNominationDate(NominationDateType value) {
        this.nominationDate = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Transportation Service. Nomination Time. Time&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The deadline time for which this service has to be booked. For example if this service is executed Wednesday February 16th 2011 at 10 a.m. CET, the Nomination Date might be Tuesday February 15th 2011 and Nomination Time 4 p.m. latest.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Transportation Service&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Nomination Time&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Time&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Time. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link NominationTimeType }
     *     
     */
    public NominationTimeType getNominationTime() {
        return nominationTime;
    }

    /**
     * Sets the value of the nominationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link NominationTimeType }
     *     
     */
    public void setNominationTime(NominationTimeType value) {
        this.nominationTime = value;
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
