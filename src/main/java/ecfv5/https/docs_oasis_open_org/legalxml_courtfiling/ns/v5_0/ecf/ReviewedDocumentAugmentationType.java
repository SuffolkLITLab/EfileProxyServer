
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.niem_core._4.DocumentAssociationType;
import ecfv5.gov.niem.release.niem.niem_core._4.EntityType;
import ecfv5.gov.niem.release.niem.niem_core._4.StatusType;
import ecfv5.gov.niem.release.niem.proxy.xsd._4.Boolean;
import ecfv5.gov.niem.release.niem.structures._4.AugmentationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * An augmentation type
 * 
 * <p>Java class for ReviewedDocumentAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReviewedDocumentAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentReviewStatus" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentReviewer" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}SealDocumentIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}CaseDocketID" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentAssociation" minOccurs="0"/&gt;
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
@XmlType(name = "ReviewedDocumentAugmentationType", propOrder = {
    "documentReviewStatus",
    "documentReviewer",
    "sealDocumentIndicator",
    "caseDocketID",
    "documentAssociation"
})
public class ReviewedDocumentAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "DocumentReviewStatus")
    protected StatusType documentReviewStatus;
    @XmlElement(name = "DocumentReviewer")
    protected EntityType documentReviewer;
    @XmlElement(name = "SealDocumentIndicator")
    protected Boolean sealDocumentIndicator;
    @XmlElement(name = "CaseDocketID", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected ecfv5.gov.niem.release.niem.proxy.xsd._4.String caseDocketID;
    @XmlElement(name = "DocumentAssociation", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected DocumentAssociationType documentAssociation;

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
     * Gets the value of the sealDocumentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getSealDocumentIndicator() {
        return sealDocumentIndicator;
    }

    /**
     * Sets the value of the sealDocumentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSealDocumentIndicator(Boolean value) {
        this.sealDocumentIndicator = value;
    }

    /**
     * Gets the value of the caseDocketID property.
     * 
     * @return
     *     possible object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecfv5.gov.niem.release.niem.proxy.xsd._4.String getCaseDocketID() {
        return caseDocketID;
    }

    /**
     * Sets the value of the caseDocketID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecfv5.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setCaseDocketID(ecfv5.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.caseDocketID = value;
    }

    /**
     * Gets the value of the documentAssociation property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentAssociationType }
     *     
     */
    public DocumentAssociationType getDocumentAssociation() {
        return documentAssociation;
    }

    /**
     * Sets the value of the documentAssociation property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentAssociationType }
     *     
     */
    public void setDocumentAssociation(DocumentAssociationType value) {
        this.documentAssociation = value;
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
