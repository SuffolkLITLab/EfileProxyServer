
package oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4;

import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.PersonNameTextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information about a case administering and distributing the assets of a testate or intestate decedent.
 * 
 * <p>Java class for DecedentEstateCaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DecedentEstateCaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonFullName"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonDeathDate"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CivilCase-4.0}WillFilingDate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DecedentEstateCaseType", propOrder = {
    "personFullName",
    "personDeathDate",
    "willFilingDate"
})
public class DecedentEstateCaseType
    extends ComplexObjectType
{

    @XmlElement(name = "PersonFullName", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected PersonNameTextType personFullName;
    @XmlElement(name = "PersonDeathDate", namespace = "http://niem.gov/niem/niem-core/2.0", required = true, nillable = true)
    protected DateType personDeathDate;
    @XmlElement(name = "WillFilingDate")
    protected DateType willFilingDate;

    /**
     * Gets the value of the personFullName property.
     * 
     * @return
     *     possible object is
     *     {@link PersonNameTextType }
     *     
     */
    public PersonNameTextType getPersonFullName() {
        return personFullName;
    }

    /**
     * Sets the value of the personFullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonNameTextType }
     *     
     */
    public void setPersonFullName(PersonNameTextType value) {
        this.personFullName = value;
    }

    /**
     * Gets the value of the personDeathDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getPersonDeathDate() {
        return personDeathDate;
    }

    /**
     * Sets the value of the personDeathDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setPersonDeathDate(DateType value) {
        this.personDeathDate = value;
    }

    /**
     * Gets the value of the willFilingDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getWillFilingDate() {
        return willFilingDate;
    }

    /**
     * Sets the value of the willFilingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setWillFilingDate(DateType value) {
        this.willFilingDate = value;
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
