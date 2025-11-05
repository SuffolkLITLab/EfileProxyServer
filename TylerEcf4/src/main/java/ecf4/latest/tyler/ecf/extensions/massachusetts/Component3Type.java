
package ecf4.latest.tyler.ecf.extensions.massachusetts;

import ecf4.latest.gov.niem.niem.proxy.xsd._2.Boolean;
import ecf4.latest.gov.niem.niem.structures._2.ReferenceType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for Component3Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Component3Type"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonReference"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Massachusetts}PartyIndicator"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Component3Type", propOrder = {
    "personReference",
    "partyIndicator"
})
public class Component3Type {

    @XmlElement(name = "PersonReference", namespace = "http://niem.gov/niem/niem-core/2.0", required = true)
    protected ReferenceType personReference;
    @XmlElement(name = "PartyIndicator", required = true)
    protected Boolean partyIndicator;

    /**
     * Gets the value of the personReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getPersonReference() {
        return personReference;
    }

    /**
     * Sets the value of the personReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setPersonReference(ReferenceType value) {
        this.personReference = value;
    }

    /**
     * Gets the value of the partyIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getPartyIndicator() {
        return partyIndicator;
    }

    /**
     * Sets the value of the partyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPartyIndicator(Boolean value) {
        this.partyIndicator = value;
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
