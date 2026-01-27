
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.ChargeType;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.CitationType;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.CourtAppearanceType;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.ViolatedStatuteAssociationType;
import ecf4.v2025_0.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.tyler.ecf.extensions.common.CitationAugmentationType;


/**
 * A charge issued by a law enforcement officer for a "violation" requiring the person charged to plead guilty to the charge or to appear in court to contest the charge. A citation is issued in lieu of an arrest and booking. "Violations" are a subset of "charges" for which a law enforcement officer is authorized to issue a citation in lieu of arrest and booking. Examples: traffic ticket, parking ticket or ticket issued for some other ordinance violation such as barking dog or illegal dumping. 
 * 
 * <p>Java class for CitationCaseAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CitationCaseAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}Citation"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseCharge" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}ViolatedStatuteAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CourtAppearance" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}CitationSubject" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}Vehicle" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;choice minOccurs="0"&gt;
 *           &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}DrivingIncident"/&gt;
 *           &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0}ParkingViolation"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CitationCaseAugmentationType", propOrder = {
    "citation",
    "caseCharge",
    "violatedStatuteAssociation",
    "courtAppearance",
    "citationSubject",
    "vehicle",
    "drivingIncident",
    "parkingViolation"
})
@XmlSeeAlso({
    CitationAugmentationType.class
})
public class CitationCaseAugmentationType
    extends ComplexObjectType
{

    @XmlElement(name = "Citation", namespace = "http://niem.gov/niem/domains/jxdm/4.0", required = true, nillable = true)
    protected CitationType citation;
    @XmlElement(name = "CaseCharge", namespace = "http://niem.gov/niem/domains/jxdm/4.0", nillable = true)
    protected List<ChargeType> caseCharge;
    @XmlElement(name = "ViolatedStatuteAssociation", namespace = "http://niem.gov/niem/domains/jxdm/4.0", nillable = true)
    protected List<ViolatedStatuteAssociationType> violatedStatuteAssociation;
    @XmlElement(name = "CourtAppearance", namespace = "http://niem.gov/niem/domains/jxdm/4.0", nillable = true)
    protected CourtAppearanceType courtAppearance;
    @XmlElement(name = "CitationSubject")
    protected SubjectType citationSubject;
    @XmlElementRef(name = "Vehicle", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CitationCase-4.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.VehicleType>> vehicle;
    @XmlElement(name = "DrivingIncident")
    protected DrivingIncidentType drivingIncident;
    @XmlElement(name = "ParkingViolation")
    protected ParkingViolationType parkingViolation;

    /**
     * Gets the value of the citation property.
     * 
     * @return
     *     possible object is
     *     {@link CitationType }
     *     
     */
    public CitationType getCitation() {
        return citation;
    }

    /**
     * Sets the value of the citation property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitationType }
     *     
     */
    public void setCitation(CitationType value) {
        this.citation = value;
    }

    /**
     * Gets the value of the caseCharge property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseCharge property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseCharge().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargeType }
     * 
     * 
     */
    public List<ChargeType> getCaseCharge() {
        if (caseCharge == null) {
            caseCharge = new ArrayList<ChargeType>();
        }
        return this.caseCharge;
    }

    /**
     * Gets the value of the violatedStatuteAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the violatedStatuteAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getViolatedStatuteAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ViolatedStatuteAssociationType }
     * 
     * 
     */
    public List<ViolatedStatuteAssociationType> getViolatedStatuteAssociation() {
        if (violatedStatuteAssociation == null) {
            violatedStatuteAssociation = new ArrayList<ViolatedStatuteAssociationType>();
        }
        return this.violatedStatuteAssociation;
    }

    /**
     * Gets the value of the courtAppearance property.
     * 
     * @return
     *     possible object is
     *     {@link CourtAppearanceType }
     *     
     */
    public CourtAppearanceType getCourtAppearance() {
        return courtAppearance;
    }

    /**
     * Sets the value of the courtAppearance property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtAppearanceType }
     *     
     */
    public void setCourtAppearance(CourtAppearanceType value) {
        this.courtAppearance = value;
    }

    /**
     * Gets the value of the citationSubject property.
     * 
     * @return
     *     possible object is
     *     {@link SubjectType }
     *     
     */
    public SubjectType getCitationSubject() {
        return citationSubject;
    }

    /**
     * Sets the value of the citationSubject property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubjectType }
     *     
     */
    public void setCitationSubject(SubjectType value) {
        this.citationSubject = value;
    }

    /**
     * Gets the value of the vehicle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the vehicle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVehicle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.VehicleType }{@code >}
     * {@link JAXBElement }{@code <}{@link ecf4.v2025_0.tyler.ecf.extensions.common.VehicleType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.VehicleType>> getVehicle() {
        if (vehicle == null) {
            vehicle = new ArrayList<JAXBElement<? extends ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.VehicleType>>();
        }
        return this.vehicle;
    }

    /**
     * Gets the value of the drivingIncident property.
     * 
     * @return
     *     possible object is
     *     {@link DrivingIncidentType }
     *     
     */
    public DrivingIncidentType getDrivingIncident() {
        return drivingIncident;
    }

    /**
     * Sets the value of the drivingIncident property.
     * 
     * @param value
     *     allowed object is
     *     {@link DrivingIncidentType }
     *     
     */
    public void setDrivingIncident(DrivingIncidentType value) {
        this.drivingIncident = value;
    }

    /**
     * Gets the value of the parkingViolation property.
     * 
     * @return
     *     possible object is
     *     {@link ParkingViolationType }
     *     
     */
    public ParkingViolationType getParkingViolation() {
        return parkingViolation;
    }

    /**
     * Sets the value of the parkingViolation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParkingViolationType }
     *     
     */
    public void setParkingViolation(ParkingViolationType value) {
        this.parkingViolation = value;
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
