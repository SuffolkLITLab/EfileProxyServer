
package ecfv5.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ApplicationStatusCodeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CertificateTypeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OriginalJobIDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousJobIDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceIDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RemarksType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to define an application for a Certificate of Origin (CoO).&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for CertificateOfOriginApplicationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CertificateOfOriginApplicationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ReferenceID"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CertificateType"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ApplicationStatusCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OriginalJobID"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PreviousJobID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Remarks" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Shipment"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}EndorserParty" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}PreparationParty"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}IssuerParty"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExporterParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ImporterParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}IssuingCountry"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DocumentDistribution" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupportingDocumentReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Signature" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CertificateOfOriginApplicationType", propOrder = {
    "referenceID",
    "certificateType",
    "applicationStatusCode",
    "originalJobID",
    "previousJobID",
    "remarks",
    "shipment",
    "endorserParty",
    "preparationParty",
    "issuerParty",
    "exporterParty",
    "importerParty",
    "issuingCountry",
    "documentDistribution",
    "supportingDocumentReference",
    "signature"
})
public class CertificateOfOriginApplicationType {

    @XmlElement(name = "ReferenceID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected ReferenceIDType referenceID;
    @XmlElement(name = "CertificateType", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected CertificateTypeType certificateType;
    @XmlElement(name = "ApplicationStatusCode", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ApplicationStatusCodeType applicationStatusCode;
    @XmlElement(name = "OriginalJobID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected OriginalJobIDType originalJobID;
    @XmlElement(name = "PreviousJobID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PreviousJobIDType previousJobID;
    @XmlElement(name = "Remarks", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<RemarksType> remarks;
    @XmlElement(name = "Shipment", required = true)
    protected ShipmentType shipment;
    @XmlElement(name = "EndorserParty", required = true)
    protected List<EndorserPartyType> endorserParty;
    @XmlElement(name = "PreparationParty", required = true)
    protected PartyType preparationParty;
    @XmlElement(name = "IssuerParty", required = true)
    protected PartyType issuerParty;
    @XmlElement(name = "ExporterParty")
    protected PartyType exporterParty;
    @XmlElement(name = "ImporterParty")
    protected PartyType importerParty;
    @XmlElement(name = "IssuingCountry", required = true)
    protected CountryType issuingCountry;
    @XmlElement(name = "DocumentDistribution")
    protected List<DocumentDistributionType> documentDistribution;
    @XmlElement(name = "SupportingDocumentReference")
    protected List<DocumentReferenceType> supportingDocumentReference;
    @XmlElement(name = "Signature")
    protected List<SignatureType> signature;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Reference. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for a reference as part of the CoO application.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Reference&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ReferenceIDType }
     *     
     */
    public ReferenceIDType getReferenceID() {
        return referenceID;
    }

    /**
     * Sets the value of the referenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceIDType }
     *     
     */
    public void setReferenceID(ReferenceIDType value) {
        this.referenceID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Certificate Type. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The type of CoO being applied for (Ordinary, Re-export, Commonwealth Preferential, etc.).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Certificate Type&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CertificateTypeType }
     *     
     */
    public CertificateTypeType getCertificateType() {
        return certificateType;
    }

    /**
     * Sets the value of the certificateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateTypeType }
     *     
     */
    public void setCertificateType(CertificateTypeType value) {
        this.certificateType = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Application Status Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying the status of the application (revision, replacement, etc.).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Application Status Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ApplicationStatusCodeType }
     *     
     */
    public ApplicationStatusCodeType getApplicationStatusCode() {
        return applicationStatusCode;
    }

    /**
     * Sets the value of the applicationStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationStatusCodeType }
     *     
     */
    public void setApplicationStatusCode(ApplicationStatusCodeType value) {
        this.applicationStatusCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Original_ Job Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The latest job number given to the CoO application. This is used by the system to keep track of amendments to or cancellation of any earlier applications.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Original&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Job Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link OriginalJobIDType }
     *     
     */
    public OriginalJobIDType getOriginalJobID() {
        return originalJobID;
    }

    /**
     * Sets the value of the originalJobID property.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalJobIDType }
     *     
     */
    public void setOriginalJobID(OriginalJobIDType value) {
        this.originalJobID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Previous_ Job Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the previous job used in case the application requires query or change.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Previous&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Job Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PreviousJobIDType }
     *     
     */
    public PreviousJobIDType getPreviousJobID() {
        return previousJobID;
    }

    /**
     * Sets the value of the previousJobID property.
     * 
     * @param value
     *     allowed object is
     *     {@link PreviousJobIDType }
     *     
     */
    public void setPreviousJobID(PreviousJobIDType value) {
        this.previousJobID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Remarks. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Remarks by the applicant for the CoO.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Remarks&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the remarks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remarks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemarks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemarksType }
     * 
     * 
     */
    public List<RemarksType> getRemarks() {
        if (remarks == null) {
            remarks = new ArrayList<RemarksType>();
        }
        return this.remarks;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Shipment&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The shipment of goods covered by the CoO.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Shipment&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Shipment&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Shipment&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ShipmentType }
     *     
     */
    public ShipmentType getShipment() {
        return shipment;
    }

    /**
     * Sets the value of the shipment property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipmentType }
     *     
     */
    public void setShipment(ShipmentType value) {
        this.shipment = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Endorser Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A party providing an endorsement to the CoO.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Endorser Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Endorser Party&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Endorser Party&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the endorserParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the endorserParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEndorserParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EndorserPartyType }
     * 
     * 
     */
    public List<EndorserPartyType> getEndorserParty() {
        if (endorserParty == null) {
            endorserParty = new ArrayList<EndorserPartyType>();
        }
        return this.endorserParty;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Preparation_ Party. Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The party (individual, group, or body) that prepared this CoO application.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Preparation&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Party&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Party&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getPreparationParty() {
        return preparationParty;
    }

    /**
     * Sets the value of the preparationParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setPreparationParty(PartyType value) {
        this.preparationParty = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Issuer_ Party. Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The organization authorized to issue the CoO requested by this application.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Issuer&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Party&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Party&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getIssuerParty() {
        return issuerParty;
    }

    /**
     * Sets the value of the issuerParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setIssuerParty(PartyType value) {
        this.issuerParty = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Exporter_ Party. Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The party making an export declaration, or on behalf of which the export declaration is made, and that is the owner of the goods or has similar right of disposal over them at the time when the declaration is accepted.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Exporter&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Party&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Party&lt;/ccts:RepresentationTerm&gt;&lt;ccts:AlternativeBusinessTerms&gt;Exporter (WCO ID 41 and 42)&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getExporterParty() {
        return exporterParty;
    }

    /**
     * Sets the value of the exporterParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setExporterParty(PartyType value) {
        this.exporterParty = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Importer_ Party. Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The party making an import declaration, or on behalf of which a customs clearing agent or other authorized person makes an import declaration. This may include a person who has possession of the goods or to whom the goods are consigned.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Importer&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Party&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Party&lt;/ccts:RepresentationTerm&gt;&lt;ccts:AlternativeBusinessTerms&gt;Importer (WCO ID 39 and 40)&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getImporterParty() {
        return importerParty;
    }

    /**
     * Sets the value of the importerParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setImporterParty(PartyType value) {
        this.importerParty = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Issuing_ Country. Country&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The country where the requested CoO will be issued.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Issuing&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Country&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Country&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Country&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getIssuingCountry() {
        return issuingCountry;
    }

    /**
     * Sets the value of the issuingCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setIssuingCountry(CountryType value) {
        this.issuingCountry = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Document Distribution&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An interested party to which the CoO is to be distributed.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Document Distribution&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Document Distribution&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Document Distribution&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the documentDistribution property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentDistribution property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentDistribution().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentDistributionType }
     * 
     * 
     */
    public List<DocumentDistributionType> getDocumentDistribution() {
        if (documentDistribution == null) {
            documentDistribution = new ArrayList<DocumentDistributionType>();
        }
        return this.documentDistribution;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Supporting_ Document Reference. Document Reference&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A reference to a document supporting this application.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Supporting&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Document Reference&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Document Reference&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Document Reference&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the supportingDocumentReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the supportingDocumentReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSupportingDocumentReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentReferenceType }
     * 
     * 
     */
    public List<DocumentReferenceType> getSupportingDocumentReference() {
        if (supportingDocumentReference == null) {
            supportingDocumentReference = new ArrayList<DocumentReferenceType>();
        }
        return this.supportingDocumentReference;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Certificate Of Origin Application. Signature&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A signature applied to this application.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Certificate Of Origin Application&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Signature&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Signature&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Signature&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the signature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the signature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SignatureType }
     * 
     * 
     */
    public List<SignatureType> getSignature() {
        if (signature == null) {
            signature = new ArrayList<SignatureType>();
        }
        return this.signature;
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
