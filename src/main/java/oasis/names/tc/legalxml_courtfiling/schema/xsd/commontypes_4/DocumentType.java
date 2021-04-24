
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A Lead document that is the pleading, motion or order that is the main document in a Filing or a Connected Document. A Lead Document may have Connected Documents, which are "appendices" or "exhibits" that are intended for filing only in the context of the Lead Document.
 * 
 * &lt;p&gt;Java class for DocumentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DocumentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}DocumentType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentMetadata"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentRendition" maxOccurs="unbounded"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", propOrder = {
    "documentMetadata",
    "documentRendition"
})
@XmlSeeAlso({
    CourtEventDocumentType.class,
    tyler.ecf.extensions.common.DocumentType.class,
    ReviewedDocumentType.class
})
public class DocumentType
    extends gov.niem.niem.niem_core._2.DocumentType
{

    @XmlElement(name = "DocumentMetadata", required = true)
    protected DocumentMetadataType documentMetadata;
    @XmlElement(name = "DocumentRendition", required = true)
    protected List<DocumentRenditionType> documentRendition;

    /**
     * Gets the value of the documentMetadata property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentMetadataType }
     *     
     */
    public DocumentMetadataType getDocumentMetadata() {
        return documentMetadata;
    }

    /**
     * Sets the value of the documentMetadata property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentMetadataType }
     *     
     */
    public void setDocumentMetadata(DocumentMetadataType value) {
        this.documentMetadata = value;
    }

    /**
     * Gets the value of the documentRendition property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the documentRendition property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getDocumentRendition().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link DocumentRenditionType }
     * 
     * 
     */
    public List<DocumentRenditionType> getDocumentRendition() {
        if (documentRendition == null) {
            documentRendition = new ArrayList<DocumentRenditionType>();
        }
        return this.documentRendition;
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
