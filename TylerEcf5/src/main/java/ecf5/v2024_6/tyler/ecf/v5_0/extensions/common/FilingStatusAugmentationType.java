
package tyler.ecf.v5_0.extensions.common;

import gov.niem.release.niem.niem_core._4.DateType;
import gov.niem.release.niem.niem_core._4.TextType;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for FilingStatusAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilingStatusAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}DocketDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}AcceptDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ReviewCommentsText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}RejectReasonCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}GracePeriodExpirationDate" minOccurs="0"/&gt;
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
@XmlType(name = "FilingStatusAugmentationType", propOrder = {
    "docketDate",
    "acceptDate",
    "reviewCommentsText",
    "rejectReasonCode",
    "gracePeriodExpirationDate"
})
public class FilingStatusAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "DocketDate")
    protected DateType docketDate;
    @XmlElement(name = "AcceptDate")
    protected DateType acceptDate;
    @XmlElement(name = "ReviewCommentsText")
    protected TextType reviewCommentsText;
    @XmlElement(name = "RejectReasonCode")
    protected TextType rejectReasonCode;
    @XmlElement(name = "GracePeriodExpirationDate")
    protected DateType gracePeriodExpirationDate;

    /**
     * Gets the value of the docketDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocketDate() {
        return docketDate;
    }

    /**
     * Sets the value of the docketDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocketDate(DateType value) {
        this.docketDate = value;
    }

    /**
     * Gets the value of the acceptDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getAcceptDate() {
        return acceptDate;
    }

    /**
     * Sets the value of the acceptDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setAcceptDate(DateType value) {
        this.acceptDate = value;
    }

    /**
     * Gets the value of the reviewCommentsText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getReviewCommentsText() {
        return reviewCommentsText;
    }

    /**
     * Sets the value of the reviewCommentsText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setReviewCommentsText(TextType value) {
        this.reviewCommentsText = value;
    }

    /**
     * Gets the value of the rejectReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRejectReasonCode() {
        return rejectReasonCode;
    }

    /**
     * Sets the value of the rejectReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRejectReasonCode(TextType value) {
        this.rejectReasonCode = value;
    }

    /**
     * Gets the value of the gracePeriodExpirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getGracePeriodExpirationDate() {
        return gracePeriodExpirationDate;
    }

    /**
     * Sets the value of the gracePeriodExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setGracePeriodExpirationDate(DateType value) {
        this.gracePeriodExpirationDate = value;
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
