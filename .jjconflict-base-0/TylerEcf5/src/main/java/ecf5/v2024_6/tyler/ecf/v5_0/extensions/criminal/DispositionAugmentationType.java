
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.criminal;

import ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6.JudicialOfficialType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DispositionAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DispositionAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:criminal}DispositionIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}Judge" minOccurs="0"/&gt;
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
@XmlType(name = "DispositionAugmentationType", propOrder = {
    "dispositionIdentification",
    "judge"
})
public class DispositionAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "DispositionIdentification")
    protected IdentificationType dispositionIdentification;
    @XmlElement(name = "Judge", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/")
    protected JudicialOfficialType judge;

    /**
     * Gets the value of the dispositionIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getDispositionIdentification() {
        return dispositionIdentification;
    }

    /**
     * Sets the value of the dispositionIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setDispositionIdentification(IdentificationType value) {
        this.dispositionIdentification = value;
    }

    /**
     * Gets the value of the judge property.
     * 
     * @return
     *     possible object is
     *     {@link JudicialOfficialType }
     *     
     */
    public JudicialOfficialType getJudge() {
        return judge;
    }

    /**
     * Sets the value of the judge property.
     * 
     * @param value
     *     allowed object is
     *     {@link JudicialOfficialType }
     *     
     */
    public void setJudge(JudicialOfficialType value) {
        this.judge = value;
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
