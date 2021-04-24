
package tyler.ecf.extensions.criminal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;


/**
 * &lt;p&gt;Java class for StatuteType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="StatuteType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}StatuteType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}GeneralOffenseText" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Criminal}StatuteTypeText" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatuteType", propOrder = {
    "generalOffenseText",
    "statuteTypeText"
})
public class StatuteType
    extends gov.niem.niem.domains.jxdm._4.StatuteType
{

    @XmlElement(name = "GeneralOffenseText")
    protected TextType generalOffenseText;
    @XmlElement(name = "StatuteTypeText")
    protected TextType statuteTypeText;

    /**
     * Gets the value of the generalOffenseText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getGeneralOffenseText() {
        return generalOffenseText;
    }

    /**
     * Sets the value of the generalOffenseText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setGeneralOffenseText(TextType value) {
        this.generalOffenseText = value;
    }

    /**
     * Gets the value of the statuteTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getStatuteTypeText() {
        return statuteTypeText;
    }

    /**
     * Sets the value of the statuteTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setStatuteTypeText(TextType value) {
        this.statuteTypeText = value;
    }

}
