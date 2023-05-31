
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.IdentificationType;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for MessageStatusAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MessageStatusAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentFiledDate"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BatchIdentification" minOccurs="0"/&gt;
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
@XmlType(name = "MessageStatusAugmentationType", propOrder = {
    "documentFiledDate",
    "batchIdentification"
})
public class MessageStatusAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "DocumentFiledDate", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true)
    protected DateType documentFiledDate;
    @XmlElement(name = "BatchIdentification")
    protected IdentificationType batchIdentification;

    /**
     * Gets the value of the documentFiledDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentFiledDate() {
        return documentFiledDate;
    }

    /**
     * Sets the value of the documentFiledDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentFiledDate(DateType value) {
        this.documentFiledDate = value;
    }

    /**
     * Gets the value of the batchIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getBatchIdentification() {
        return batchIdentification;
    }

    /**
     * Sets the value of the batchIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setBatchIdentification(IdentificationType value) {
        this.batchIdentification = value;
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
