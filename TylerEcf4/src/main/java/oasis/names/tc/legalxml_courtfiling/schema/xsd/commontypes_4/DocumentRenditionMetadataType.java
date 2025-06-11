
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import gov.niem.niem.niem_core._2.DocumentType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Descriptors for a rendition of a Document. This is meant to include all the information about the document that is needed to  enter it into the Document Management System.
 * 
 * <p>Java class for DocumentRenditionMetadataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentRenditionMetadataType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}DocumentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentAttachment" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ColorRelevantIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}RedactedIndicator" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentRenditionMetadataType", propOrder = {
    "documentAttachment",
    "colorRelevantIndicator",
    "redactedIndicator"
})
public class DocumentRenditionMetadataType
    extends DocumentType
{

    @XmlElement(name = "DocumentAttachment", required = true)
    protected List<DocumentAttachmentType> documentAttachment;
    @XmlElement(name = "ColorRelevantIndicator")
    protected Boolean colorRelevantIndicator;
    @XmlElement(name = "RedactedIndicator")
    protected Boolean redactedIndicator;

    /**
     * Gets the value of the documentAttachment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentAttachment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentAttachment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentAttachmentType }
     * 
     * 
     */
    public List<DocumentAttachmentType> getDocumentAttachment() {
        if (documentAttachment == null) {
            documentAttachment = new ArrayList<DocumentAttachmentType>();
        }
        return this.documentAttachment;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
