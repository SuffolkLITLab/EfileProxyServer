
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import java.util.ArrayList;
import java.util.List;
import gov.niem.release.niem.niem_core._4.ContactInformationType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.niem_core._4.InsuranceType;
import gov.niem.release.niem.niem_core._4.PersonEmploymentAssociationType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PersonAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseParticipantRoleCode" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CasePartySelfRepresentationIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ElectronicServiceInformation" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ParticipantID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ContactInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Insurance" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonEmploymentAssociation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonAugmentationType", propOrder = {
    "caseParticipantRoleCode",
    "casePartySelfRepresentationIndicator",
    "electronicServiceInformation",
    "participantID",
    "contactInformation",
    "insurance",
    "personEmploymentAssociation"
})
public class PersonAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "CaseParticipantRoleCode")
    protected List<TextType> caseParticipantRoleCode;
    @XmlElement(name = "CasePartySelfRepresentationIndicator")
    protected Boolean casePartySelfRepresentationIndicator;
    @XmlElement(name = "ElectronicServiceInformation")
    protected ElectronicServiceInformationType electronicServiceInformation;
    @XmlElement(name = "ParticipantID")
    protected IdentificationType participantID;
    @XmlElement(name = "ContactInformation", namespace = "http://release.niem.gov/niem/niem-core/4.0/", nillable = true)
    protected List<ContactInformationType> contactInformation;
    @XmlElement(name = "Insurance", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected List<InsuranceType> insurance;
    @XmlElement(name = "PersonEmploymentAssociation", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected PersonEmploymentAssociationType personEmploymentAssociation;

    /**
     * Gets the value of the caseParticipantRoleCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseParticipantRoleCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseParticipantRoleCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getCaseParticipantRoleCode() {
        if (caseParticipantRoleCode == null) {
            caseParticipantRoleCode = new ArrayList<TextType>();
        }
        return this.caseParticipantRoleCode;
    }

    /**
     * Gets the value of the casePartySelfRepresentationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getCasePartySelfRepresentationIndicator() {
        return casePartySelfRepresentationIndicator;
    }

    /**
     * Sets the value of the casePartySelfRepresentationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCasePartySelfRepresentationIndicator(Boolean value) {
        this.casePartySelfRepresentationIndicator = value;
    }

    /**
     * Gets the value of the electronicServiceInformation property.
     * 
     * @return
     *     possible object is
     *     {@link ElectronicServiceInformationType }
     *     
     */
    public ElectronicServiceInformationType getElectronicServiceInformation() {
        return electronicServiceInformation;
    }

    /**
     * Sets the value of the electronicServiceInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElectronicServiceInformationType }
     *     
     */
    public void setElectronicServiceInformation(ElectronicServiceInformationType value) {
        this.electronicServiceInformation = value;
    }

    /**
     * Gets the value of the participantID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getParticipantID() {
        return participantID;
    }

    /**
     * Sets the value of the participantID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setParticipantID(IdentificationType value) {
        this.participantID = value;
    }

    /**
     * Gets the value of the contactInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the contactInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactInformationType }
     * 
     * 
     */
    public List<ContactInformationType> getContactInformation() {
        if (contactInformation == null) {
            contactInformation = new ArrayList<ContactInformationType>();
        }
        return this.contactInformation;
    }

    /**
     * Gets the value of the insurance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the insurance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInsurance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InsuranceType }
     * 
     * 
     */
    public List<InsuranceType> getInsurance() {
        if (insurance == null) {
            insurance = new ArrayList<InsuranceType>();
        }
        return this.insurance;
    }

    /**
     * Gets the value of the personEmploymentAssociation property.
     * 
     * @return
     *     possible object is
     *     {@link PersonEmploymentAssociationType }
     *     
     */
    public PersonEmploymentAssociationType getPersonEmploymentAssociation() {
        return personEmploymentAssociation;
    }

    /**
     * Sets the value of the personEmploymentAssociation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonEmploymentAssociationType }
     *     
     */
    public void setPersonEmploymentAssociation(PersonEmploymentAssociationType value) {
        this.personEmploymentAssociation = value;
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
