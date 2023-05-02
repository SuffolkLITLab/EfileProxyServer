
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.DriverLicenseType;
import gov.niem.niem.niem_core._2.PersonContactInformationAssociationType;
import gov.niem.niem.structures._2.AugmentationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Additional information about a person.
 * 
 * <p>Java class for PersonAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}PersonDriverLicense" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}PersonInsurance" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ElectronicServiceInformation" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ContactInformation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonContactInformationAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonAugmentationType", propOrder = {
    "personDriverLicense",
    "personInsurance",
    "electronicServiceInformation",
    "contactInformation",
    "personContactInformationAssociation"
})
public class PersonAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "PersonDriverLicense")
    protected DriverLicenseType personDriverLicense;
    @XmlElement(name = "PersonInsurance")
    protected List<InsuranceType> personInsurance;
    @XmlElement(name = "ElectronicServiceInformation")
    protected ElectronicServiceInformationType electronicServiceInformation;
    @XmlElement(name = "ContactInformation", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected List<ContactInformationType> contactInformation;
    @XmlElement(name = "PersonContactInformationAssociation", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected List<PersonContactInformationAssociationType> personContactInformationAssociation;

    /**
     * Gets the value of the personDriverLicense property.
     * 
     * @return
     *     possible object is
     *     {@link DriverLicenseType }
     *     
     */
    public DriverLicenseType getPersonDriverLicense() {
        return personDriverLicense;
    }

    /**
     * Sets the value of the personDriverLicense property.
     * 
     * @param value
     *     allowed object is
     *     {@link DriverLicenseType }
     *     
     */
    public void setPersonDriverLicense(DriverLicenseType value) {
        this.personDriverLicense = value;
    }

    /**
     * Gets the value of the personInsurance property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personInsurance property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonInsurance().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InsuranceType }
     * 
     * 
     */
    public List<InsuranceType> getPersonInsurance() {
        if (personInsurance == null) {
            personInsurance = new ArrayList<InsuranceType>();
        }
        return this.personInsurance;
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
     * Gets the value of the contactInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
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
     * Gets the value of the personContactInformationAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personContactInformationAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonContactInformationAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonContactInformationAssociationType }
     * 
     * 
     */
    public List<PersonContactInformationAssociationType> getPersonContactInformationAssociation() {
        if (personContactInformationAssociation == null) {
            personContactInformationAssociation = new ArrayList<PersonContactInformationAssociationType>();
        }
        return this.personContactInformationAssociation;
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
