
package tyler.ecf.extensions.notifyreceiptmessage;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.IdentificationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4.BankruptcyCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.FilingStatusType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.JuvenileCaseType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.common.ReviewedDocumentType;


/**
 * <p>Java class for NotifyReceiptMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NotifyReceiptMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentFiledDate"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentIdentification"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentPostDate"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SendingMDELocationID"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SendingMDEProfileCode"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}Case"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}FilingStatus"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ReviewedLeadDocument"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ReviewedConnectedDocument" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NotifyReceiptMessageType", propOrder = {
    "documentFiledDate",
    "documentIdentification",
    "documentPostDate",
    "sendingMDELocationID",
    "sendingMDEProfileCode",
    "_case",
    "filingStatus",
    "reviewedLeadDocument",
    "reviewedConnectedDocument"
})
public class NotifyReceiptMessageType {

    @XmlElement(name = "DocumentFiledDate", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected DateType documentFiledDate;
    @XmlElement(name = "DocumentIdentification", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected IdentificationType documentIdentification;
    @XmlElement(name = "DocumentPostDate", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected DateType documentPostDate;
    @XmlElement(name = "SendingMDELocationID", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    protected IdentificationType sendingMDELocationID;
    @XmlElement(name = "SendingMDEProfileCode", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String sendingMDEProfileCode;
    @XmlElementRef(name = "Case", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class)
    protected JAXBElement<? extends CaseType> _case;
    @XmlElement(name = "FilingStatus", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    protected FilingStatusType filingStatus;
    @XmlElement(name = "ReviewedLeadDocument", namespace = "urn:tyler:ecf:extensions:Common", required = true)
    protected ReviewedDocumentType reviewedLeadDocument;
    @XmlElement(name = "ReviewedConnectedDocument", namespace = "urn:tyler:ecf:extensions:Common")
    protected List<ReviewedDocumentType> reviewedConnectedDocument;

    /**
     * Gets the value of the documentFiledDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentFiledDate() {
        return documentFiledDate;
    }

    /**
     * Sets the value of the documentFiledDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentFiledDate(DateType value) {
        this.documentFiledDate = value;
    }

    /**
     * Gets the value of the documentIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getDocumentIdentification() {
        return documentIdentification;
    }

    /**
     * Sets the value of the documentIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setDocumentIdentification(IdentificationType value) {
        this.documentIdentification = value;
    }

    /**
     * Gets the value of the documentPostDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentPostDate() {
        return documentPostDate;
    }

    /**
     * Sets the value of the documentPostDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentPostDate(DateType value) {
        this.documentPostDate = value;
    }

    /**
     * Gets the value of the sendingMDELocationID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getSendingMDELocationID() {
        return sendingMDELocationID;
    }

    /**
     * Sets the value of the sendingMDELocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setSendingMDELocationID(IdentificationType value) {
        this.sendingMDELocationID = value;
    }

    /**
     * Gets the value of the sendingMDEProfileCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendingMDEProfileCode() {
        return sendingMDEProfileCode;
    }

    /**
     * Sets the value of the sendingMDEProfileCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendingMDEProfileCode(String value) {
        this.sendingMDEProfileCode = value;
    }

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
     * Gets the value of the filingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FilingStatusType }
     *     
     */
    public FilingStatusType getFilingStatus() {
        return filingStatus;
    }

    /**
     * Sets the value of the filingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingStatusType }
     *     
     */
    public void setFilingStatus(FilingStatusType value) {
        this.filingStatus = value;
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
