
package ecf4.v2025_0.gov.niem.release.niem.niem_core._4;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.DocumentAssociationAugmentationType;


/**
 * A data type for a relationship between documents.
 * 
 * <p>Java class for DocumentAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PrimaryDocument" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentAssociationAugmentationPoint"/&gt;
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
@XmlType(name = "DocumentAssociationType", propOrder = {
    "primaryDocument",
    "documentAssociationAugmentationPoint"
})
public class DocumentAssociationType
    extends AssociationType
{

    @XmlElement(name = "PrimaryDocument", nillable = true)
    protected DocumentType primaryDocument;
    @XmlElementRef(name = "DocumentAssociationAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class)
    protected JAXBElement<?> documentAssociationAugmentationPoint;

    /**
     * Gets the value of the primaryDocument property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentType }
     *     
     */
    public DocumentType getPrimaryDocument() {
        return primaryDocument;
    }

    /**
     * Sets the value of the primaryDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType }
     *     
     */
    public void setPrimaryDocument(DocumentType value) {
        this.primaryDocument = value;
    }

    /**
     * Gets the value of the documentAssociationAugmentationPoint property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DocumentAssociationAugmentationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDocumentAssociationAugmentationPoint() {
        return documentAssociationAugmentationPoint;
    }

    /**
     * Sets the value of the documentAssociationAugmentationPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DocumentAssociationAugmentationType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDocumentAssociationAugmentationPoint(JAXBElement<?> value) {
        this.documentAssociationAugmentationPoint = value;
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
