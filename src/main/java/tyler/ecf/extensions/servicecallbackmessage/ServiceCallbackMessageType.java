
package tyler.ecf.extensions.servicecallbackmessage;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.DateType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4.BankruptcyCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseFilingType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicServiceInformationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.JuvenileCaseType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.common.FilerInformationType;
import tyler.ecf.extensions.common.RecipientInformationType;
import tyler.ecf.extensions.common.ReviewedDocumentType;
import tyler.ecf.extensions.common.SubmitterInformationType;


/**
 * <p>Java class for ServiceCallbackMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceCallbackMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseFilingType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}Case"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ServiceDate"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ElectronicServiceInformation"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilerInformation"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}RecipientInformation"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}SubmitterInformation"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ReviewedLeadDocument"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ReviewedConnectedDocument" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceCallbackMessageType", propOrder = {
    "_case",
    "serviceDate",
    "electronicServiceInformation",
    "filerInformation",
    "recipientInformation",
    "submitterInformation",
    "reviewedLeadDocument",
    "reviewedConnectedDocument"
})
public class ServiceCallbackMessageType
    extends CaseFilingType
{

    @XmlElementRef(name = "Case", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class)
    protected JAXBElement<? extends CaseType> _case;
    @XmlElement(name = "ServiceDate", namespace = "urn:tyler:ecf:extensions:Common", required = true)
    protected DateType serviceDate;
    @XmlElement(name = "ElectronicServiceInformation", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    protected ElectronicServiceInformationType electronicServiceInformation;
    @XmlElement(name = "FilerInformation", namespace = "urn:tyler:ecf:extensions:Common", required = true)
    protected FilerInformationType filerInformation;
    @XmlElement(name = "RecipientInformation", namespace = "urn:tyler:ecf:extensions:Common", required = true)
    protected RecipientInformationType recipientInformation;
    @XmlElement(name = "SubmitterInformation", namespace = "urn:tyler:ecf:extensions:Common", required = true)
    protected SubmitterInformationType submitterInformation;
    @XmlElement(name = "ReviewedLeadDocument", namespace = "urn:tyler:ecf:extensions:Common", required = true)
    protected ReviewedDocumentType reviewedLeadDocument;
    @XmlElement(name = "ReviewedConnectedDocument", namespace = "urn:tyler:ecf:extensions:Common")
    protected List<ReviewedDocumentType> reviewedConnectedDocument;

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BankruptcyCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CitationCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CivilCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CriminalCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DomesticCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
     *     
     */
    public JAXBElement<? extends CaseType> getCase() {
        return _case;
    }

    /**
     * Sets the value of the case property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BankruptcyCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CitationCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CivilCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CriminalCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DomesticCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
     *     
     */
    public void setCase(JAXBElement<? extends CaseType> value) {
        this._case = value;
    }

    /**
     * Gets the value of the serviceDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getServiceDate() {
        return serviceDate;
    }

    /**
     * Sets the value of the serviceDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setServiceDate(DateType value) {
        this.serviceDate = value;
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
     * Gets the value of the filerInformation property.
     * 
     * @return
     *     possible object is
     *     {@link FilerInformationType }
     *     
     */
    public FilerInformationType getFilerInformation() {
        return filerInformation;
    }

    /**
     * Sets the value of the filerInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilerInformationType }
     *     
     */
    public void setFilerInformation(FilerInformationType value) {
        this.filerInformation = value;
    }

    /**
     * Gets the value of the recipientInformation property.
     * 
     * @return
     *     possible object is
     *     {@link RecipientInformationType }
     *     
     */
    public RecipientInformationType getRecipientInformation() {
        return recipientInformation;
    }

    /**
     * Sets the value of the recipientInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecipientInformationType }
     *     
     */
    public void setRecipientInformation(RecipientInformationType value) {
        this.recipientInformation = value;
    }

    /**
     * Gets the value of the submitterInformation property.
     * 
     * @return
     *     possible object is
     *     {@link SubmitterInformationType }
     *     
     */
    public SubmitterInformationType getSubmitterInformation() {
        return submitterInformation;
    }

    /**
     * Sets the value of the submitterInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link SubmitterInformationType }
     *     
     */
    public void setSubmitterInformation(SubmitterInformationType value) {
        this.submitterInformation = value;
    }

    /**
     * Gets the value of the reviewedLeadDocument property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewedDocumentType }
     *     
     */
    public ReviewedDocumentType getReviewedLeadDocument() {
        return reviewedLeadDocument;
    }

    /**
     * Sets the value of the reviewedLeadDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewedDocumentType }
     *     
     */
    public void setReviewedLeadDocument(ReviewedDocumentType value) {
        this.reviewedLeadDocument = value;
    }

    /**
     * Gets the value of the reviewedConnectedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reviewedConnectedDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReviewedConnectedDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReviewedDocumentType }
     * 
     * 
     */
    public List<ReviewedDocumentType> getReviewedConnectedDocument() {
        if (reviewedConnectedDocument == null) {
            reviewedConnectedDocument = new ArrayList<ReviewedDocumentType>();
        }
        return this.reviewedConnectedDocument;
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
