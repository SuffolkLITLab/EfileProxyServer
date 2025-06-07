
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DocumentReviewType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentReviewType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}Document" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentReviewDisposition"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ReviewedDocument"/&gt;
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
@XmlType(name = "DocumentReviewType", propOrder = {
    "document",
    "documentReviewDisposition",
    "reviewedDocument"
})
public class DocumentReviewType
    extends ObjectType
{

    @XmlElement(name = "Document", nillable = true)
    protected DocumentType document;
    @XmlElement(name = "DocumentReviewDisposition", required = true)
    protected DocumentReviewDispositionType documentReviewDisposition;
    @XmlElement(name = "ReviewedDocument", required = true, nillable = true)
    protected ReviewedDocumentType reviewedDocument;

    /**
     * Gets the value of the document property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentType }
     *     
     */
    public DocumentType getDocument() {
        return document;
    }

    /**
     * Sets the value of the document property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType }
     *     
     */
    public void setDocument(DocumentType value) {
        this.document = value;
    }

    /**
     * Gets the value of the documentReviewDisposition property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReviewDispositionType }
     *     
     */
    public DocumentReviewDispositionType getDocumentReviewDisposition() {
        return documentReviewDisposition;
    }

    /**
     * Sets the value of the documentReviewDisposition property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReviewDispositionType }
     *     
     */
    public void setDocumentReviewDisposition(DocumentReviewDispositionType value) {
        this.documentReviewDisposition = value;
    }

    /**
     * Gets the value of the reviewedDocument property.
     * 
     * @return
     *     possible object is
     *     {@link ReviewedDocumentType }
     *     
     */
    public ReviewedDocumentType getReviewedDocument() {
        return reviewedDocument;
    }

    /**
     * Sets the value of the reviewedDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReviewedDocumentType }
     *     
     */
    public void setReviewedDocument(ReviewedDocumentType value) {
        this.reviewedDocument = value;
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
