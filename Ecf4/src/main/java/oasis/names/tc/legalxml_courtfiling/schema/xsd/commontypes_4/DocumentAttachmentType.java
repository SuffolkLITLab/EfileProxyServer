
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import gov.niem.niem.niem_core._2.BinaryType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information describing an attachment included within an ECF 4.0 base message. An attachment can be a binary file representing the document to be filed, an XML document, a digital signature, or other MIME file.
 * 
 * <p>Java class for DocumentAttachmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentAttachmentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}BinaryType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}AttachmentSequenceID" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentAttachmentType", propOrder = {
    "attachmentSequenceID"
})
public class DocumentAttachmentType
    extends BinaryType
{

    @XmlElement(name = "AttachmentSequenceID")
    protected gov.niem.niem.proxy.xsd._2.String attachmentSequenceID;

    /**
     * Gets the value of the attachmentSequenceID property.
     * 
     * @return
     *     possible object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public gov.niem.niem.proxy.xsd._2.String getAttachmentSequenceID() {
        return attachmentSequenceID;
    }

    /**
     * Sets the value of the attachmentSequenceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link gov.niem.niem.proxy.xsd._2.String }
     *     
     */
    public void setAttachmentSequenceID(gov.niem.niem.proxy.xsd._2.String value) {
        this.attachmentSequenceID = value;
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
