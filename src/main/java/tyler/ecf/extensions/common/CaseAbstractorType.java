
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.AmountType;
import gov.niem.niem.niem_core._2.TextType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.CaseParticipantType;


/**
 * Additional information about an abstractor.
 * 
 * &lt;p&gt;Java class for CaseAbstractorType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CaseAbstractorType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CaseParticipantType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}AbstractorName"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}Fees"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CaseAbstractorType", propOrder = {
    "abstractorName",
    "fees"
})
public class CaseAbstractorType
    extends CaseParticipantType
{

    @XmlElement(name = "AbstractorName", required = true)
    protected TextType abstractorName;
    @XmlElement(name = "Fees", required = true)
    protected AmountType fees;

    /**
     * Gets the value of the abstractorName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAbstractorName() {
        return abstractorName;
    }

    /**
     * Sets the value of the abstractorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAbstractorName(TextType value) {
        this.abstractorName = value;
    }

    /**
     * Gets the value of the fees property.
     * 
     * @return
     *     possible object is
     *     {@link AmountType }
     *     
     */
    public AmountType getFees() {
        return fees;
    }

    /**
     * Sets the value of the fees property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountType }
     *     
     */
    public void setFees(AmountType value) {
        this.fees = value;
    }

}
