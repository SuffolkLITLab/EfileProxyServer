
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for FilerAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilerAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}FilerInformation"/&gt;
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
@XmlType(name = "FilerAugmentationType", propOrder = {
    "filerInformation"
})
public class FilerAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "FilerInformation", required = true)
    protected FilerInformationType filerInformation;

    /**
     * Gets the value of the filerInformation property.
     * 
     * @return
     *     possible object is
     *     {@link FilerInformationType }
     *     
     */
    public FilerInformationType getFilerInformation() {
        return filerInformation;
    }

    /**
     * Sets the value of the filerInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilerInformationType }
     *     
     */
    public void setFilerInformation(FilerInformationType value) {
        this.filerInformation = value;
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
