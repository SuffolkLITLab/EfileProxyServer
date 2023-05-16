
package gov.niem.release.niem.domains.humanservices._4;

import gov.niem.release.niem.domains.jxdm._6.ChargeType;
import gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for allegations of juvenile abuse or neglect.
 * 
 * <p>Java class for JuvenileAbuseNeglectAllegationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JuvenileAbuseNeglectAllegationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/jxdm/6.1/}ChargeType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}AbuseNeglectAllegationCategoryText" minOccurs="0"/&gt;
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
@XmlType(name = "JuvenileAbuseNeglectAllegationType", propOrder = {
    "abuseNeglectAllegationCategoryText"
})
public class JuvenileAbuseNeglectAllegationType
    extends ChargeType
{

    @XmlElement(name = "AbuseNeglectAllegationCategoryText")
    protected TextType abuseNeglectAllegationCategoryText;

    /**
     * Gets the value of the abuseNeglectAllegationCategoryText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAbuseNeglectAllegationCategoryText() {
        return abuseNeglectAllegationCategoryText;
    }

    /**
     * Sets the value of the abuseNeglectAllegationCategoryText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAbuseNeglectAllegationCategoryText(TextType value) {
        this.abuseNeglectAllegationCategoryText = value;
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
