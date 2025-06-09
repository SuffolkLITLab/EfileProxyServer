
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import gov.niem.niem.niem_core._2.DocumentType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A rendition or version of a Document.
 * 
 * <p>Java class for DocumentRenditionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentRenditionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}DocumentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentSignature" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentRenditionMetadata"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentRenditionType", propOrder = {
    "documentSignature",
    "documentRenditionMetadata"
})
public class DocumentRenditionType
    extends DocumentType
{

    @XmlElement(name = "DocumentSignature")
    protected List<DocumentSignatureType> documentSignature;
    @XmlElement(name = "DocumentRenditionMetadata", required = true)
    protected DocumentRenditionMetadataType documentRenditionMetadata;

    /**
     * Gets the value of the documentSignature property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentSignature property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentSignature().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentSignatureType }
     * 
     * 
     */
    public List<DocumentSignatureType> getDocumentSignature() {
        if (documentSignature == null) {
            documentSignature = new ArrayList<DocumentSignatureType>();
        }
        return this.documentSignature;
    }

    /**
     * Gets the value of the documentRenditionMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentRenditionMetadataType }
     *     
     */
    public DocumentRenditionMetadataType getDocumentRenditionMetadata() {
        return documentRenditionMetadata;
    }

    /**
     * Sets the value of the documentRenditionMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentRenditionMetadataType }
     *     
     */
    public void setDocumentRenditionMetadata(DocumentRenditionMetadataType value) {
        this.documentRenditionMetadata = value;
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
