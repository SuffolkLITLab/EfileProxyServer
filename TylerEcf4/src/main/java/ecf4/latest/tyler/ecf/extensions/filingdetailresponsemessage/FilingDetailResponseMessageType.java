
package ecf4.latest.tyler.ecf.extensions.filingdetailresponsemessage;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.niem.niem_core._2.CaseType;
import ecf4.latest.gov.niem.niem.niem_core._2.DateType;
import ecf4.latest.gov.niem.niem.niem_core._2.EntityType;
import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4.BankruptcyCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.FilingStatusType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.JuvenileCaseType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.latest.tyler.ecf.extensions.common.DocumentType;
import ecf4.latest.tyler.ecf.extensions.common.PaymentType;
import ecf4.latest.tyler.ecf.extensions.common.ProcedureRemedyType;


/**
 * A court's response to a FilingDetailQueryMessage.
 * 
 * <p>Java class for FilingDetailResponseMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingDetailResponseMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QueryResponseMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:FilingDetailResponseMessage}FilingSubmissionDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}Case" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}ProcedureRemedy" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:FilingDetailResponseMessage}EnvelopeFees" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}Payment" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentSubmitter" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}FilingStatus"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:FilingDetailResponseMessage}FilingAcceptDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DocumentPostDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:FilingDetailResponseMessage}ServiceRecipientDetail" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:FilingDetailResponseMessage}FilingFees" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilingLeadDocument" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilingAssociationParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilingDetailResponseMessageType", propOrder = {
    "filingSubmissionDate",
    "_case",
    "procedureRemedy",
    "envelopeFees",
    "payment",
    "documentIdentification",
    "documentSubmitter",
    "filingStatus",
    "filingAcceptDate",
    "documentPostDate",
    "serviceRecipientDetail",
    "filingFees",
    "filingLeadDocument",
    "filingAssociationParty"
})
public class FilingDetailResponseMessageType
    extends QueryResponseMessageType
{

    @XmlElement(name = "FilingSubmissionDate")
    protected DateType filingSubmissionDate;
    @XmlElementRef(name = "Case", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends CaseType> _case;
    @XmlElement(name = "ProcedureRemedy", namespace = "urn:tyler:ecf:extensions:Common")
    protected ProcedureRemedyType procedureRemedy;
    @XmlElement(name = "EnvelopeFees")
    protected List<ChargeType> envelopeFees;
    @XmlElement(name = "Payment", namespace = "urn:tyler:ecf:extensions:Common")
    protected PaymentType payment;
    @XmlElement(name = "DocumentIdentification", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected List<IdentificationType> documentIdentification;
    @XmlElement(name = "DocumentSubmitter", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected EntityType documentSubmitter;
    @XmlElement(name = "FilingStatus", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    protected FilingStatusType filingStatus;
    @XmlElement(name = "FilingAcceptDate")
    protected DateType filingAcceptDate;
    @XmlElement(name = "DocumentPostDate", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected DateType documentPostDate;
    @XmlElement(name = "ServiceRecipientDetail")
    protected List<ServiceRecipientDetailType> serviceRecipientDetail;
    @XmlElement(name = "FilingFees")
    protected List<ChargeType> filingFees;
    @XmlElement(name = "FilingLeadDocument", namespace = "urn:tyler:ecf:extensions:Common")
    protected List<DocumentType> filingLeadDocument;
    @XmlElement(name = "FilingAssociationParty", namespace = "urn:tyler:ecf:extensions:Common")
    protected List<IdentificationType> filingAssociationParty;

    /**
     * Gets the value of the filingSubmissionDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getFilingSubmissionDate() {
        return filingSubmissionDate;
    }

    /**
     * Sets the value of the filingSubmissionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setFilingSubmissionDate(DateType value) {
        this.filingSubmissionDate = value;
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
     * Gets the value of the procedureRemedy property.
     * 
     * @return
     *     possible object is
     *     {@link ProcedureRemedyType }
     *     
     */
    public ProcedureRemedyType getProcedureRemedy() {
        return procedureRemedy;
    }

    /**
     * Sets the value of the procedureRemedy property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcedureRemedyType }
     *     
     */
    public void setProcedureRemedy(ProcedureRemedyType value) {
        this.procedureRemedy = value;
    }

    /**
     * Gets the value of the envelopeFees property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the envelopeFees property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvelopeFees().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargeType }
     * 
     * 
     */
    public List<ChargeType> getEnvelopeFees() {
        if (envelopeFees == null) {
            envelopeFees = new ArrayList<ChargeType>();
        }
        return this.envelopeFees;
    }

    /**
     * Gets the value of the payment property.
     * 
     * @return
     *     possible object is
     *     {@link PaymentType }
     *     
     */
    public PaymentType getPayment() {
        return payment;
    }

    /**
     * Sets the value of the payment property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentType }
     *     
     */
    public void setPayment(PaymentType value) {
        this.payment = value;
    }

    /**
     * Gets the value of the documentIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getDocumentIdentification() {
        if (documentIdentification == null) {
            documentIdentification = new ArrayList<IdentificationType>();
        }
        return this.documentIdentification;
    }

    /**
     * Gets the value of the documentSubmitter property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getDocumentSubmitter() {
        return documentSubmitter;
    }

    /**
     * Sets the value of the documentSubmitter property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setDocumentSubmitter(EntityType value) {
        this.documentSubmitter = value;
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
     * Gets the value of the filingAcceptDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getFilingAcceptDate() {
        return filingAcceptDate;
    }

    /**
     * Sets the value of the filingAcceptDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setFilingAcceptDate(DateType value) {
        this.filingAcceptDate = value;
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
     * Gets the value of the serviceRecipientDetail property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the serviceRecipientDetail property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceRecipientDetail().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceRecipientDetailType }
     * 
     * 
     */
    public List<ServiceRecipientDetailType> getServiceRecipientDetail() {
        if (serviceRecipientDetail == null) {
            serviceRecipientDetail = new ArrayList<ServiceRecipientDetailType>();
        }
        return this.serviceRecipientDetail;
    }

    /**
     * Gets the value of the filingFees property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the filingFees property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilingFees().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargeType }
     * 
     * 
     */
    public List<ChargeType> getFilingFees() {
        if (filingFees == null) {
            filingFees = new ArrayList<ChargeType>();
        }
        return this.filingFees;
    }

    /**
     * Gets the value of the filingLeadDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the filingLeadDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilingLeadDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentType }
     * 
     * 
     */
    public List<DocumentType> getFilingLeadDocument() {
        if (filingLeadDocument == null) {
            filingLeadDocument = new ArrayList<DocumentType>();
        }
        return this.filingLeadDocument;
    }

    /**
     * Gets the value of the filingAssociationParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the filingAssociationParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilingAssociationParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getFilingAssociationParty() {
        if (filingAssociationParty == null) {
            filingAssociationParty = new ArrayList<IdentificationType>();
        }
        return this.filingAssociationParty;
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
