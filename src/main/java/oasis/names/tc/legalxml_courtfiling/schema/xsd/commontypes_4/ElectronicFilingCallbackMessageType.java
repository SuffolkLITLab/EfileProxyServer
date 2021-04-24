
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.CaseType;
import gov.niem.niem.niem_core._2.DateType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4.BankruptcyCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.JuvenileCaseType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingcallbackmessage_4.RecordDocketingCallbackMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4.ReviewFilingCallbackMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The asynchronous message returned by the Filing Review MDE to the filing assembly MDE conveying information on the court's actions on the documents submitted for filing in the FilingReviewMessage.
 * 
 * &lt;p&gt;Java class for ElectronicFilingCallbackMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ElectronicFilingCallbackMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseFilingType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}Case"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}FilingCompletionDate" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}FilingStatus"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ReviewedLeadDocument"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ReviewedConnectedDocument" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectronicFilingCallbackMessageType", propOrder = {
    "_case",
    "filingCompletionDate",
    "filingStatus",
    "reviewedLeadDocument",
    "reviewedConnectedDocument"
})
@XmlSeeAlso({
    ReviewFilingCallbackMessageType.class,
    RecordDocketingCallbackMessageType.class
})
public abstract class ElectronicFilingCallbackMessageType
    extends CaseFilingType
{

    @XmlElementRef(name = "Case", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class)
    protected JAXBElement<? extends CaseType> _case;
    @XmlElement(name = "FilingCompletionDate")
    protected DateType filingCompletionDate;
    @XmlElement(name = "FilingStatus", required = true)
    protected FilingStatusType filingStatus;
    @XmlElementRef(name = "ReviewedLeadDocument", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", type = JAXBElement.class)
    protected JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType> reviewedLeadDocument;
    @XmlElementRef(name = "ReviewedConnectedDocument", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType>> reviewedConnectedDocument;

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CivilCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CriminalCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CitationCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DomesticCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BankruptcyCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CaseType }{@code >}
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
     *     {@link JAXBElement }{@code <}{@link CivilCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CriminalCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CitationCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DomesticCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BankruptcyCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     *     
     */
    public void setCase(JAXBElement<? extends CaseType> value) {
        this._case = value;
    }

    /**
     * Gets the value of the filingCompletionDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getFilingCompletionDate() {
        return filingCompletionDate;
    }

    /**
     * Sets the value of the filingCompletionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setFilingCompletionDate(DateType value) {
        this.filingCompletionDate = value;
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
     *     {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.ReviewedDocumentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType }{@code >}
     *     
     */
    public JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType> getReviewedLeadDocument() {
        return reviewedLeadDocument;
    }

    /**
     * Sets the value of the reviewedLeadDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.ReviewedDocumentType }{@code >}
     *     {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType }{@code >}
     *     
     */
    public void setReviewedLeadDocument(JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType> value) {
        this.reviewedLeadDocument = value;
    }

    /**
     * Gets the value of the reviewedConnectedDocument property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the reviewedConnectedDocument property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getReviewedConnectedDocument().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link tyler.ecf.extensions.common.ReviewedDocumentType }{@code >}
     * {@link JAXBElement }{@code <}{@link oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType>> getReviewedConnectedDocument() {
        if (reviewedConnectedDocument == null) {
            reviewedConnectedDocument = new ArrayList<JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType>>();
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
