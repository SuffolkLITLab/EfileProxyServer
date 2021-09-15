
package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.domains.humanservices._4.PersonCaseAssociationType;
import ecfv5.gov.niem.release.niem.niem_core._4.TextType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Information about a guardianship, conservatorship, trust, or mental health case.
 * 
 * <p>Java class for FiduciaryCaseAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FiduciaryCaseAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/humanServices/4.0/}PersonCaseAssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/civil}FiduciaryTypeCode"/&gt;
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
@XmlType(name = "FiduciaryCaseAssociationType", propOrder = {
    "fiduciaryTypeCode"
})
public class FiduciaryCaseAssociationType
    extends PersonCaseAssociationType
{

    @XmlElement(name = "FiduciaryTypeCode", required = true)
    protected TextType fiduciaryTypeCode;

    /**
     * Gets the value of the fiduciaryTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFiduciaryTypeCode() {
        return fiduciaryTypeCode;
    }

    /**
     * Sets the value of the fiduciaryTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFiduciaryTypeCode(TextType value) {
        this.fiduciaryTypeCode = value;
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
