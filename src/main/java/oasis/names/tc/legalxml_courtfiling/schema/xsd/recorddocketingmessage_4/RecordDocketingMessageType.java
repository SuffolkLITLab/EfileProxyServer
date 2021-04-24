
package oasis.names.tc.legalxml_courtfiling.schema.xsd.recorddocketingmessage_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.CourtType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ElectronicFilingMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Message resulting from clerk review and edit of a CoreFilingMessage.
 * 
 * &lt;p&gt;Java class for RecordDocketingMessageType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RecordDocketingMessageType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ElectronicFilingMessageType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseCourt"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}CaseTrackingID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ReviewedLeadDocument"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ReviewedConnectedDocument" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingMessage-4.0}SealCaseIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:RecordDocketingMessage-4.0}FilingReviewCommentsText" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RecordDocketingMessageType", propOrder = {
    "caseCourt",
    "caseTrackingID",
    "reviewedLeadDocument",
    "reviewedConnectedDocument",
    "sealCaseIndicator",
    "filingReviewCommentsText"
})
public class RecordDocketingMessageType
    extends ElectronicFilingMessageType
{

    @XmlElement(name = "CaseCourt", namespace = "http://niem.gov/niem/domains/jxdm/4.0", required = true, nillable = true)
    protected CourtType caseCourt;
    @XmlElement(name = "CaseTrackingID", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected gov.niem.niem.proxy.xsd._2.String caseTrackingID;
    @XmlElementRef(name = "ReviewedLeadDocument", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", type = JAXBElement.class)
    protected JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType> reviewedLeadDocument;
    @XmlElementRef(name = "ReviewedConnectedDocument", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType>> reviewedConnectedDocument;
    @XmlElement(name = "SealCaseIndicator")
    protected Boolean sealCaseIndicator;
    @XmlElement(name = "FilingReviewCommentsText")
    protected TextType filingReviewCommentsText;

    /**
     * Gets the value of the caseCourt property.
     * 
     * @return
     *     possible object is
     *     {@link CourtType }
     *     
     */
    public CourtType getCaseCourt() {
        return caseCourt;
    }

    /**
     * Sets the value of the caseCourt property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtType }
     *     
     */
    public void setCaseCourt(CourtType value) {
        this.caseCourt = value;
    }

    /**
     * Gets the value of the caseTrackingID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getCaseTrackingID() {
        return caseTrackingID;
    }

    /**
     * Sets the value of the caseTrackingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setCaseTrackingID(gov.niem.niem.proxy.xsd._2.String value) {
        this.caseTrackingID = value;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
