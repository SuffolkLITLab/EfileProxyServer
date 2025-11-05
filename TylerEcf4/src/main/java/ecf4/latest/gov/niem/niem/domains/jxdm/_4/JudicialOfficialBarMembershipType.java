
package ecf4.latest.gov.niem.niem.domains.jxdm._4;

import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import ecf4.latest.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for JudicialOfficialBarMembershipType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JudicialOfficialBarMembershipType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}JudicialOfficialBarIdentification" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JudicialOfficialBarMembershipType", propOrder = {
    "judicialOfficialBarIdentification"
})
public class JudicialOfficialBarMembershipType
    extends ComplexObjectType
{

    @XmlElement(name = "JudicialOfficialBarIdentification", nillable = true)
    protected IdentificationType judicialOfficialBarIdentification;

    /**
     * Gets the value of the judicialOfficialBarIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getJudicialOfficialBarIdentification() {
        return judicialOfficialBarIdentification;
    }

    /**
     * Sets the value of the judicialOfficialBarIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setJudicialOfficialBarIdentification(IdentificationType value) {
        this.judicialOfficialBarIdentification = value;
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
