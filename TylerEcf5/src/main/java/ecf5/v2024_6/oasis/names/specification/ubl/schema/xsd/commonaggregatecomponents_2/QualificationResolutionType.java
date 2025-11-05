
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdmissionCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExclusionReasonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResolutionDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResolutionTimeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResolutionType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Qualification Resolution. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe the acceptance or rejection of an economic operator in a tendering process.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Qualification Resolution&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for QualificationResolutionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QualificationResolutionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}AdmissionCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExclusionReason" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Resolution" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ResolutionDate"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ResolutionTime" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ProcurementProjectLot" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QualificationResolutionType", propOrder = {
    "admissionCode",
    "exclusionReason",
    "resolution",
    "resolutionDate",
    "resolutionTime",
    "procurementProjectLot"
})
public class QualificationResolutionType {

    @XmlElement(name = "AdmissionCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected AdmissionCodeType admissionCode;
    @XmlElement(name = "ExclusionReason", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ExclusionReasonType> exclusionReason;
    @XmlElement(name = "Resolution", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ResolutionType> resolution;
    @XmlElement(name = "ResolutionDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ResolutionDateType resolutionDate;
    @XmlElement(name = "ResolutionTime", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ResolutionTimeType resolutionTime;
    @XmlElement(name = "ProcurementProjectLot")
    protected ProcurementProjectLotType procurementProjectLot;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Qualification Resolution. Admission Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator that the economic operator has been accepted into the tendering process (true) or rejected from the tendering process (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Qualification Resolution&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Admission Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link AdmissionCodeType }
     *     
     */
    public AdmissionCodeType getAdmissionCode() {
        return admissionCode;
    }

    /**
     * Sets the value of the admissionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdmissionCodeType }
     *     
     */
    public void setAdmissionCode(AdmissionCodeType value) {
        this.admissionCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Qualification Resolution. Exclusion Reason. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Text describing a reason for an exclusion from the tendering process.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Qualification Resolution&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Exclusion Reason&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the exclusionReason property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the exclusionReason property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExclusionReason().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ExclusionReasonType }
     * 
     * 
     */
    public List<ExclusionReasonType> getExclusionReason() {
        if (exclusionReason == null) {
            exclusionReason = new ArrayList<ExclusionReasonType>();
        }
        return this.exclusionReason;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Qualification Resolution. Resolution. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Text describing this qualification resolution.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Qualification Resolution&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Resolution&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the resolution property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the resolution property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResolution().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ResolutionType }
     * 
     * 
     */
    public List<ResolutionType> getResolution() {
        if (resolution == null) {
            resolution = new ArrayList<ResolutionType>();
        }
        return this.resolution;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Qualification Resolution. Resolution Date. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The date on which this qualification resolution was formalized.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Qualification Resolution&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Resolution Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ResolutionDateType }
     *     
     */
    public ResolutionDateType getResolutionDate() {
        return resolutionDate;
    }

    /**
     * Sets the value of the resolutionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResolutionDateType }
     *     
     */
    public void setResolutionDate(ResolutionDateType value) {
        this.resolutionDate = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Qualification Resolution. Resolution Time. Time&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The time at which this qualification resolution was formalized.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Qualification Resolution&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Resolution Time&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Time&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Time. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ResolutionTimeType }
     *     
     */
    public ResolutionTimeType getResolutionTime() {
        return resolutionTime;
    }

    /**
     * Sets the value of the resolutionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResolutionTimeType }
     *     
     */
    public void setResolutionTime(ResolutionTimeType value) {
        this.resolutionTime = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Qualification Resolution. Procurement Project Lot&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The Procurement project lot to which this tenderer is accepted or rejected.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Qualification Resolution&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Procurement Project Lot&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Procurement Project Lot&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Procurement Project Lot&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ProcurementProjectLotType }
     *     
     */
    public ProcurementProjectLotType getProcurementProjectLot() {
        return procurementProjectLot;
    }

    /**
     * Sets the value of the procurementProjectLot property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcurementProjectLotType }
     *     
     */
    public void setProcurementProjectLot(ProcurementProjectLotType value) {
        this.procurementProjectLot = value;
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
