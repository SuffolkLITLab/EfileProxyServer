
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil;

import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.PersonType;
import gov.niem.release.niem.structures._4.ObjectType;
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
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}Decedent"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}WillFilingDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}PersonDeathDate"/&gt;
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
@XmlType(name = "DecedentEstateCaseType", propOrder = {
    "decedent",
    "willFilingDate",
    "personDeathDate"
})
public class DecedentEstateCaseType
    extends ObjectType
{

    @XmlElement(name = "Decedent", required = true, nillable = true)
    protected PersonType decedent;
    @XmlElement(name = "WillFilingDate")
    protected DateType willFilingDate;
    @XmlElement(name = "PersonDeathDate", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true)
    protected DateType personDeathDate;

    /**
     * Gets the value of the decedent property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getDecedent() {
        return decedent;
    }

    /**
     * Sets the value of the decedent property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setDecedent(PersonType value) {
        this.decedent = value;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
