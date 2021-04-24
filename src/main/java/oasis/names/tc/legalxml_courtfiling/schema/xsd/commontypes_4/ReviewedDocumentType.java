
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A document that has been reviewed through the clerk review process, and that potentially has been or will be reocrded in the court record system.
 * 
 * &lt;p&gt;Java class for ReviewedDocumentType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ReviewedDocumentType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentHashText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentDocketID" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SealDocumentIndicator" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReviewedDocumentType", propOrder = {
    "documentHashText",
    "documentDocketID",
    "sealDocumentIndicator"
})
@XmlSeeAlso({
    tyler.ecf.extensions.common.ReviewedDocumentType.class
})
public class ReviewedDocumentType
    extends DocumentType
{

    @XmlElement(name = "DocumentHashText")
    protected TextType documentHashText;
    @XmlElement(name = "DocumentDocketID")
    protected IdentificationType documentDocketID;
    @XmlElement(name = "SealDocumentIndicator")
    protected Boolean sealDocumentIndicator;

    /**
     * Gets the value of the documentHashText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDocumentHashText() {
        return documentHashText;
    }

    /**
     * Sets the value of the documentHashText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDocumentHashText(TextType value) {
        this.documentHashText = value;
    }

    /**
     * Gets the value of the documentDocketID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getDocumentDocketID() {
        return documentDocketID;
    }

    /**
     * Sets the value of the documentDocketID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setDocumentDocketID(IdentificationType value) {
        this.documentDocketID = value;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
