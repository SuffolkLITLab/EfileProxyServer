
package ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.EntityType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.StatusType;
import ecf5.v2024_6.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The disposition of a document after review.
 * 
 * <p>Java class for DocumentReviewDispositionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentReviewDispositionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentAddedInReviewIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentReviewStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentReviewer" minOccurs="0"/&gt;
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
@XmlType(name = "DocumentReviewDispositionType", propOrder = {
    "documentAddedInReviewIndicator",
    "documentReviewStatus",
    "documentReviewer"
})
public class DocumentReviewDispositionType
    extends ObjectType
{

    @XmlElement(name = "DocumentAddedInReviewIndicator")
    protected Boolean documentAddedInReviewIndicator;
    @XmlElement(name = "DocumentReviewStatus")
    protected StatusType documentReviewStatus;
    @XmlElement(name = "DocumentReviewer")
    protected EntityType documentReviewer;

    /**
     * Gets the value of the documentAddedInReviewIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getDocumentAddedInReviewIndicator() {
        return documentAddedInReviewIndicator;
    }

    /**
     * Sets the value of the documentAddedInReviewIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDocumentAddedInReviewIndicator(Boolean value) {
        this.documentAddedInReviewIndicator = value;
    }

    /**
     * Gets the value of the documentReviewStatus property.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getDocumentReviewStatus() {
        return documentReviewStatus;
    }

    /**
     * Sets the value of the documentReviewStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setDocumentReviewStatus(StatusType value) {
        this.documentReviewStatus = value;
    }

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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
