
package tyler.ecf.extensions.criminal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for StatuteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StatuteType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}StatuteType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Criminal}GeneralOffenseText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Criminal}StatuteTypeText" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
