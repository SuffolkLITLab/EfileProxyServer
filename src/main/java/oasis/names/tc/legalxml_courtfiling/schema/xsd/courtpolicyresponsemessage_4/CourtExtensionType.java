
package oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A schema that defines a court-specific data structure to be substituted for an ECF element.
 * 
 * &lt;p&gt;Java class for CourtExtensionType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CourtExtensionType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}ECFElementName"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}CourtExtensionURI"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourtExtensionType", propOrder = {
    "ecfElementName",
    "courtExtensionURI"
})
public class CourtExtensionType
    extends ComplexObjectType
{

    @XmlElement(name = "ECFElementName", required = true)
    protected TextType ecfElementName;
    @XmlElement(name = "CourtExtensionURI", required = true)
    protected IdentificationType courtExtensionURI;

    /**
     * Gets the value of the ecfElementName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getECFElementName() {
        return ecfElementName;
    }

    /**
     * Sets the value of the ecfElementName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setECFElementName(TextType value) {
        this.ecfElementName = value;
    }

    /**
     * Gets the value of the courtExtensionURI property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getCourtExtensionURI() {
        return courtExtensionURI;
    }

    /**
     * Sets the value of the courtExtensionURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setCourtExtensionURI(IdentificationType value) {
        this.courtExtensionURI = value;
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
