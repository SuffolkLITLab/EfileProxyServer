
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for ReviewedDocumentAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReviewedDocumentAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}IsNewFiling" minOccurs="0"/&gt;
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
@XmlType(name = "ReviewedDocumentAugmentationType", propOrder = {
    "documentIdentification",
    "isNewFiling"
})
public class ReviewedDocumentAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "DocumentIdentification", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected IdentificationType documentIdentification;
    @XmlElement(name = "IsNewFiling")
    protected Boolean isNewFiling;

    /**
     * Gets the value of the documentIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getDocumentIdentification() {
        return documentIdentification;
    }

    /**
     * Sets the value of the documentIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setDocumentIdentification(IdentificationType value) {
        this.documentIdentification = value;
    }

    /**
     * Gets the value of the isNewFiling property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIsNewFiling() {
        return isNewFiling;
    }

    /**
     * Sets the value of the isNewFiling property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsNewFiling(Boolean value) {
        this.isNewFiling = value;
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
