
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import ecf4.latest.gov.niem.release.niem.niem_core._4.BinaryType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DocumentType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.TextType;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Descriptors for a rendition of a Document. This is meant to include all the information about the document that is needed to  enter it into the Document Management System.
 * 
 * <p>Java class for DocumentRenditionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentRenditionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}DocumentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}MultimediaDataMIMEKindText" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ColorRelevantIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentRenditionHash" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentSignature" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RedactedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Attachment"/&gt;
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
@XmlType(name = "DocumentRenditionType", propOrder = {
    "multimediaDataMIMEKindText",
    "colorRelevantIndicator",
    "documentRenditionHash",
    "documentSignature",
    "redactedIndicator",
    "attachment"
})
public class DocumentRenditionType
    extends DocumentType
{

    @XmlElement(name = "MultimediaDataMIMEKindText", namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/")
    protected ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String multimediaDataMIMEKindText;
    @XmlElement(name = "ColorRelevantIndicator")
    protected Boolean colorRelevantIndicator;
    @XmlElement(name = "DocumentRenditionHash")
    protected TextType documentRenditionHash;
    @XmlElement(name = "DocumentSignature")
    protected DocumentSignatureType documentSignature;
    @XmlElement(name = "RedactedIndicator")
    protected Boolean redactedIndicator;
    @XmlElement(name = "Attachment", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true)
    protected BinaryType attachment;

    /**
     * Gets the value of the multimediaDataMIMEKindText property.
     * 
     * @return
     *     possible object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String getMultimediaDataMIMEKindText() {
        return multimediaDataMIMEKindText;
    }

    /**
     * Sets the value of the multimediaDataMIMEKindText property.
     * 
     * @param value
     *     allowed object is
     *     {@link ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String }
     *     
     */
    public void setMultimediaDataMIMEKindText(ecf4.latest.gov.niem.release.niem.proxy.xsd._4.String value) {
        this.multimediaDataMIMEKindText = value;
    }

    /**
     * Gets the value of the colorRelevantIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getColorRelevantIndicator() {
        return colorRelevantIndicator;
    }

    /**
     * Sets the value of the colorRelevantIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setColorRelevantIndicator(Boolean value) {
        this.colorRelevantIndicator = value;
    }

    /**
     * Gets the value of the documentRenditionHash property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDocumentRenditionHash() {
        return documentRenditionHash;
    }

    /**
     * Sets the value of the documentRenditionHash property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDocumentRenditionHash(TextType value) {
        this.documentRenditionHash = value;
    }

    /**
     * Gets the value of the documentSignature property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentSignatureType }
     *     
     */
    public DocumentSignatureType getDocumentSignature() {
        return documentSignature;
    }

    /**
     * Sets the value of the documentSignature property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentSignatureType }
     *     
     */
    public void setDocumentSignature(DocumentSignatureType value) {
        this.documentSignature = value;
    }

    /**
     * Gets the value of the redactedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getRedactedIndicator() {
        return redactedIndicator;
    }

    /**
     * Sets the value of the redactedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRedactedIndicator(Boolean value) {
        this.redactedIndicator = value;
    }

    /**
     * Gets the value of the attachment property.
     * 
     * @return
     *     possible object is
     *     {@link BinaryType }
     *     
     */
    public BinaryType getAttachment() {
        return attachment;
    }

    /**
     * Sets the value of the attachment property.
     * 
     * @param value
     *     allowed object is
     *     {@link BinaryType }
     *     
     */
    public void setAttachment(BinaryType value) {
        this.attachment = value;
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
