
package gov.niem.release.niem.domains.jxdm._6;

import gov.niem.release.niem.niem_core._4.AssociationType;
import gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an association that links a person to a Blood Alcohol Content (BAC) Test reading, measured due to a related activity such as an arrest or a driving incident.
 * 
 * <p>Java class for PersonBloodAlcoholContentAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonBloodAlcoholContentAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}PersonBloodAlcoholContentNumberText" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonBloodAlcoholContentAssociationType", propOrder = {
    "personBloodAlcoholContentNumberText"
})
public class PersonBloodAlcoholContentAssociationType
    extends AssociationType
{

    @XmlElement(name = "PersonBloodAlcoholContentNumberText")
    protected TextType personBloodAlcoholContentNumberText;

    /**
     * Gets the value of the personBloodAlcoholContentNumberText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPersonBloodAlcoholContentNumberText() {
        return personBloodAlcoholContentNumberText;
    }

    /**
     * Sets the value of the personBloodAlcoholContentNumberText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPersonBloodAlcoholContentNumberText(TextType value) {
        this.personBloodAlcoholContentNumberText = value;
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
