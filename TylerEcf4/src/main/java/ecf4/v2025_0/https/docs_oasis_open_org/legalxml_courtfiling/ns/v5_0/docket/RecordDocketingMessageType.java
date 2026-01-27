
package ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.docket;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.CaseType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.TextType;
import ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.CaseFilingType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ReviewedDocumentType;
import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.FilingMessageType;


/**
 * Message resulting from clerk review and edit of a ReviewFilingMessage.
 * 
 * <p>Java class for RecordDocketingMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RecordDocketingMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CaseFilingType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket}CorrectedCase" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket}FilingReviewCommentsText" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket}SealCaseIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ReviewedConnectedDocument" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ReviewedLeadDocument" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing}FilingMessage"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/docket}RecordDocketingMessageAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "RecordDocketingMessageType", propOrder = {
    "correctedCase",
    "filingReviewCommentsText",
    "sealCaseIndicator",
    "reviewedConnectedDocument",
    "reviewedLeadDocument",
    "filingMessage",
    "recordDocketingMessageAugmentationPoint"
})
public class RecordDocketingMessageType
    extends CaseFilingType
{

    @XmlElement(name = "CorrectedCase")
    protected CaseType correctedCase;
    @XmlElement(name = "FilingReviewCommentsText")
    protected TextType filingReviewCommentsText;
    @XmlElement(name = "SealCaseIndicator")
    protected Boolean sealCaseIndicator;
    @XmlElement(name = "ReviewedConnectedDocument", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", nillable = true)
    protected List<ReviewedDocumentType> reviewedConnectedDocument;
    @XmlElement(name = "ReviewedLeadDocument", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", required = true, nillable = true)
    protected List<ReviewedDocumentType> reviewedLeadDocument;
    @XmlElement(name = "FilingMessage", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/filing", required = true)
    protected FilingMessageType filingMessage;
    @XmlElement(name = "RecordDocketingMessageAugmentationPoint")
    protected List<Object> recordDocketingMessageAugmentationPoint;

    /**
     * Gets the value of the correctedCase property.
     * 
     * @return
     *     possible object is
     *     {@link CaseType }
     *     
     */
    public CaseType getCorrectedCase() {
        return correctedCase;
    }

    /**
     * Sets the value of the correctedCase property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseType }
     *     
     */
    public void setCorrectedCase(CaseType value) {
        this.correctedCase = value;
    }

    /**
     * Gets the value of the filingReviewCommentsText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFilingReviewCommentsText() {
        return filingReviewCommentsText;
    }

    /**
     * Sets the value of the filingReviewCommentsText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFilingReviewCommentsText(TextType value) {
        this.filingReviewCommentsText = value;
    }

    /**
     * Gets the value of the sealCaseIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getSealCaseIndicator() {
        return sealCaseIndicator;
    }

    /**
     * Sets the value of the sealCaseIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSealCaseIndicator(Boolean value) {
        this.sealCaseIndicator = value;
    }

    /**
     * Gets the value of the reviewedConnectedDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
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
     * Gets the value of the reviewedLeadDocument property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the reviewedLeadDocument property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReviewedLeadDocument().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReviewedDocumentType }
     * 
     * 
     */
    public List<ReviewedDocumentType> getReviewedLeadDocument() {
        if (reviewedLeadDocument == null) {
            reviewedLeadDocument = new ArrayList<ReviewedDocumentType>();
        }
        return this.reviewedLeadDocument;
    }

    /**
     * Gets the value of the filingMessage property.
     * 
     * @return
     *     possible object is
     *     {@link FilingMessageType }
     *     
     */
    public FilingMessageType getFilingMessage() {
        return filingMessage;
    }

    /**
     * Sets the value of the filingMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingMessageType }
     *     
     */
    public void setFilingMessage(FilingMessageType value) {
        this.filingMessage = value;
    }

    /**
     * Gets the value of the recordDocketingMessageAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the recordDocketingMessageAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordDocketingMessageAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getRecordDocketingMessageAugmentationPoint() {
        if (recordDocketingMessageAugmentationPoint == null) {
            recordDocketingMessageAugmentationPoint = new ArrayList<Object>();
        }
        return this.recordDocketingMessageAugmentationPoint;
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
