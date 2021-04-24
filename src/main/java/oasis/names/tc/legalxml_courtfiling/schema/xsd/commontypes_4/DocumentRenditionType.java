
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DocumentType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A rendition or version of a Document.
 * 
 * &lt;p&gt;Java class for DocumentRenditionType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DocumentRenditionType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}DocumentType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentSignature" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentRenditionMetadata"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the documentSignature property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDocumentSignature().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
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
