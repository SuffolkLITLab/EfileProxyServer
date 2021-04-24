
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ReferenceType;


/**
 * &lt;p&gt;Java class for RedactionIdentificationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="RedactionIdentificationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}AttachmentReference"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}RedactionID"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RedactionIdentificationType", propOrder = {
    "attachmentReference",
    "redactionID"
})
public class RedactionIdentificationType {

    @XmlElement(name = "AttachmentReference", required = true)
    protected ReferenceType attachmentReference;
    @XmlElement(name = "RedactionID", required = true)
    protected TextType redactionID;

    /**
     * Gets the value of the attachmentReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getAttachmentReference() {
        return attachmentReference;
    }

    /**
     * Sets the value of the attachmentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setAttachmentReference(ReferenceType value) {
        this.attachmentReference = value;
    }

    /**
     * Gets the value of the redactionID property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRedactionID() {
        return redactionID;
    }

    /**
     * Sets the value of the redactionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRedactionID(TextType value) {
        this.redactionID = value;
    }

}
