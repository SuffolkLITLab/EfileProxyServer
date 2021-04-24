
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EmbeddedDocumentBinaryObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for AttachmentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AttachmentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}EmbeddedDocumentBinaryObject" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ExternalReference" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AttachmentType", propOrder = {
    "embeddedDocumentBinaryObject",
    "externalReference"
})
public class AttachmentType {

    @XmlElement(name = "EmbeddedDocumentBinaryObject", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected EmbeddedDocumentBinaryObjectType embeddedDocumentBinaryObject;
    @XmlElement(name = "ExternalReference")
    protected ExternalReferenceType externalReference;

    /**
     * Gets the value of the embeddedDocumentBinaryObject property.
     * 
     * @return
     *     possible object is
     *     {@link EmbeddedDocumentBinaryObjectType }
     *     
     */
    public EmbeddedDocumentBinaryObjectType getEmbeddedDocumentBinaryObject() {
        return embeddedDocumentBinaryObject;
    }

    /**
     * Sets the value of the embeddedDocumentBinaryObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link EmbeddedDocumentBinaryObjectType }
     *     
     */
    public void setEmbeddedDocumentBinaryObject(EmbeddedDocumentBinaryObjectType value) {
        this.embeddedDocumentBinaryObject = value;
    }

    /**
     * Gets the value of the externalReference property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalReferenceType }
     *     
     */
    public ExternalReferenceType getExternalReference() {
        return externalReference;
    }

    /**
     * Sets the value of the externalReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalReferenceType }
     *     
     */
    public void setExternalReference(ExternalReferenceType value) {
        this.externalReference = value;
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
