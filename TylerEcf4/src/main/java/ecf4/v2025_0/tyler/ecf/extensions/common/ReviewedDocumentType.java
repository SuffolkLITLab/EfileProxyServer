
package ecf4.v2025_0.tyler.ecf.extensions.common;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.DateType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.EntityType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ReviewedDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReviewedDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ReviewedDocumentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentReviewer" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentReviewDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilingReviewCommentsText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}RejectReasonText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}WaiverIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}DocumentAttachmentIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilingIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReviewedDocumentType", propOrder = {
    "documentReviewer",
    "documentReviewDate",
    "filingReviewCommentsText",
    "rejectReasonText",
    "waiverIndicator",
    "documentAttachmentIdentification",
    "filingIdentification"
})
public class ReviewedDocumentType
    extends ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ReviewedDocumentType
{

    @XmlElement(name = "DocumentReviewer")
    protected EntityType documentReviewer;
    @XmlElement(name = "DocumentReviewDate")
    protected DateType documentReviewDate;
    @XmlElement(name = "FilingReviewCommentsText")
    protected TextType filingReviewCommentsText;
    @XmlElement(name = "RejectReasonText")
    protected TextType rejectReasonText;
    @XmlElement(name = "WaiverIndicator")
    protected Boolean waiverIndicator;
    @XmlElement(name = "DocumentAttachmentIdentification")
    protected List<DocumentAttachmentIdentificationType> documentAttachmentIdentification;
    @XmlElement(name = "FilingIdentification")
    protected List<FilingIdentificationType> filingIdentification;

    /**
     * Gets the value of the documentReviewer property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getDocumentReviewer() {
        return documentReviewer;
    }

    /**
     * Sets the value of the documentReviewer property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setDocumentReviewer(EntityType value) {
        this.documentReviewer = value;
    }

    /**
     * Gets the value of the documentReviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentReviewDate() {
        return documentReviewDate;
    }

    /**
     * Sets the value of the documentReviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentReviewDate(DateType value) {
        this.documentReviewDate = value;
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
     * Gets the value of the rejectReasonText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRejectReasonText() {
        return rejectReasonText;
    }

    /**
     * Sets the value of the rejectReasonText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRejectReasonText(TextType value) {
        this.rejectReasonText = value;
    }

    /**
     * Gets the value of the waiverIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getWaiverIndicator() {
        return waiverIndicator;
    }

    /**
     * Sets the value of the waiverIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setWaiverIndicator(Boolean value) {
        this.waiverIndicator = value;
    }

    /**
     * Gets the value of the documentAttachmentIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentAttachmentIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentAttachmentIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentAttachmentIdentificationType }
     * 
     * 
     */
    public List<DocumentAttachmentIdentificationType> getDocumentAttachmentIdentification() {
        if (documentAttachmentIdentification == null) {
            documentAttachmentIdentification = new ArrayList<DocumentAttachmentIdentificationType>();
        }
        return this.documentAttachmentIdentification;
    }

    /**
     * Gets the value of the filingIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the filingIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFilingIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FilingIdentificationType }
     * 
     * 
     */
    public List<FilingIdentificationType> getFilingIdentification() {
        if (filingIdentification == null) {
            filingIdentification = new ArrayList<FilingIdentificationType>();
        }
        return this.filingIdentification;
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
