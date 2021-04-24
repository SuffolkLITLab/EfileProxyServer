
package oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.PersonAssociationType;
import gov.niem.niem.niem_core._2.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Description of a person's relationship to the fiduciary (e.g., the initiating party).
 * 
 * &lt;p&gt;Java class for PersonFiduciaryAssociationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="PersonFiduciaryAssociationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}PersonAssociationType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0}PersonFiduciaryAssociationTypeText"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonFiduciaryAssociationType", propOrder = {
    "personFiduciaryAssociationTypeText"
})
public class PersonFiduciaryAssociationType
    extends PersonAssociationType
{

    @XmlElement(name = "PersonFiduciaryAssociationTypeText", required = true)
    protected TextType personFiduciaryAssociationTypeText;

    /**
     * Gets the value of the personFiduciaryAssociationTypeText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getPersonFiduciaryAssociationTypeText() {
        return personFiduciaryAssociationTypeText;
    }

    /**
     * Sets the value of the personFiduciaryAssociationTypeText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setPersonFiduciaryAssociationTypeText(TextType value) {
        this.personFiduciaryAssociationTypeText = value;
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
