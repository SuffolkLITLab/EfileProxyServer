
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import ecf4.v2025_0.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A document that has been reviewed through the clerk review process, and that potentially has been or will be reocrded in the court record system.
 * 
 * <p>Java class for ReviewedDocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReviewedDocumentType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentHashText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}DocumentDocketID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SealDocumentIndicator" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
   ecf4.v2025_0.tyler.ecf.extensions.common.ReviewedDocumentType.class
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
