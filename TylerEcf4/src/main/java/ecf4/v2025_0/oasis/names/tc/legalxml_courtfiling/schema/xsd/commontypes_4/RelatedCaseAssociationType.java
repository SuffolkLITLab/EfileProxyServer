
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import ecf4.v2025_0.gov.niem.niem.niem_core._2.RelatedActivityAssociationType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Case or cases sharing characteristics, such as common parties or events, with this case.
 * 
 * <p>Java class for RelatedCaseAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RelatedCaseAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}RelatedActivityAssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseAssociationTypeCode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelatedCaseAssociationType", propOrder = {
    "caseAssociationTypeCode"
})
public class RelatedCaseAssociationType
    extends RelatedActivityAssociationType
{

    @XmlElement(name = "CaseAssociationTypeCode")
    protected TextType caseAssociationTypeCode;

    /**
     * Gets the value of the caseAssociationTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCaseAssociationTypeCode() {
        return caseAssociationTypeCode;
    }

    /**
     * Sets the value of the caseAssociationTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCaseAssociationTypeCode(TextType value) {
        this.caseAssociationTypeCode = value;
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
