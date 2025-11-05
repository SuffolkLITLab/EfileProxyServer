
package ecf4.latest.gov.niem.niem.domains.jxdm._4;

import ecf4.latest.gov.niem.niem.niem_core._2.OrganizationType;
import ecf4.latest.gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for EnforcementUnitType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnforcementUnitType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}OrganizationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}EnforcementUnitName" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnforcementUnitType", propOrder = {
    "enforcementUnitName"
})
public class EnforcementUnitType
    extends OrganizationType
{

    @XmlElement(name = "EnforcementUnitName", nillable = true)
    protected TextType enforcementUnitName;

    /**
     * Gets the value of the enforcementUnitName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getEnforcementUnitName() {
        return enforcementUnitName;
    }

    /**
     * Sets the value of the enforcementUnitName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setEnforcementUnitName(TextType value) {
        this.enforcementUnitName = value;
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
