
package gov.niem.niem.niem_core._2;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.nonauthoritative_code._2.MarriageCategoryCodeType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.MarriageAssociationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for PersonUnionAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PersonUnionAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}PersonAssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonUnionCategory" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonUnionStatus" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonUnionAssociationType", propOrder = {
    "personUnionCategory",
    "personUnionStatus"
})
@XmlSeeAlso({
    MarriageAssociationType.class
})
public class PersonUnionAssociationType
    extends PersonAssociationType
{

    @XmlElementRef(name = "PersonUnionCategory", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> personUnionCategory;
    @XmlElement(name = "PersonUnionStatus", nillable = true)
    protected MarriageStatusType personUnionStatus;

    /**
     * Gets the value of the personUnionCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link MarriageCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getPersonUnionCategory() {
        return personUnionCategory;
    }

    /**
     * Sets the value of the personUnionCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link MarriageCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setPersonUnionCategory(JAXBElement<?> value) {
        this.personUnionCategory = value;
    }

    /**
     * Gets the value of the personUnionStatus property.
     * 
     * @return
     *     possible object is
     *     {@link MarriageStatusType }
     *     
     */
    public MarriageStatusType getPersonUnionStatus() {
        return personUnionStatus;
    }

    /**
     * Sets the value of the personUnionStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link MarriageStatusType }
     *     
     */
    public void setPersonUnionStatus(MarriageStatusType value) {
        this.personUnionStatus = value;
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
