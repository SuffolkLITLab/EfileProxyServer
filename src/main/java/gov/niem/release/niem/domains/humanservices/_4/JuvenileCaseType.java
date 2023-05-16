
package gov.niem.release.niem.domains.humanservices._4;

import gov.niem.release.niem.niem_core._4.CaseType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a juvenile case.
 * 
 * <p>Java class for JuvenileCaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JuvenileCaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}CaseType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}Juvenile"/&gt;
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
@XmlType(name = "JuvenileCaseType", propOrder = {
    "juvenile"
})
public class JuvenileCaseType
    extends CaseType
{

    @XmlElement(name = "Juvenile", required = true)
    protected JuvenileType juvenile;

    /**
     * Gets the value of the juvenile property.
     * 
     * @return
     *     possible object is
     *     {@link JuvenileType }
     *     
     */
    public JuvenileType getJuvenile() {
        return juvenile;
    }

    /**
     * Sets the value of the juvenile property.
     * 
     * @param value
     *     allowed object is
     *     {@link JuvenileType }
     *     
     */
    public void setJuvenile(JuvenileType value) {
        this.juvenile = value;
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
