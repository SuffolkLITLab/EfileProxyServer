
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.tyler.ecf.extensions.common.PersonFilerType;


/**
 * Additional information about a person.
 * 
 * <p>Java class for PersonType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}PersonType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}PersonAugmentation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonType", propOrder = {
    "personAugmentation"
})
@XmlSeeAlso({
    PersonFilerType.class
})
public class PersonType
    extends ecf4.v2025_0.gov.niem.niem.niem_core._2.PersonType
{

    @XmlElement(name = "PersonAugmentation")
    protected PersonAugmentationType personAugmentation;

    /**
     * Gets the value of the personAugmentation property.
     * 
     * @return
     *     possible object is
     *     {@link PersonAugmentationType }
     *     
     */
    public PersonAugmentationType getPersonAugmentation() {
        return personAugmentation;
    }

    /**
     * Sets the value of the personAugmentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonAugmentationType }
     *     
     */
    public void setPersonAugmentation(PersonAugmentationType value) {
        this.personAugmentation = value;
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
