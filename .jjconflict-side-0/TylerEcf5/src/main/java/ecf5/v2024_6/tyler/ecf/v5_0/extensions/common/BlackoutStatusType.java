
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import ecf5.v2024_6.gov.niem.release.niem.domains.jxdm._6.CourtType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.DateRangeType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for BlackoutStatusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BlackoutStatusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.1/}CaseCourt" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}ReasonDescriptionText"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}BlackoutDate"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BlackoutStatusType", propOrder = {
    "caseCourt",
    "reasonDescriptionText",
    "blackoutDate"
})
public class BlackoutStatusType {

    @XmlElement(name = "CaseCourt", namespace = "http://release.niem.gov/niem/domains/jxdm/6.1/")
    protected CourtType caseCourt;
    @XmlElement(name = "ReasonDescriptionText", required = true)
    protected TextType reasonDescriptionText;
    @XmlElement(name = "BlackoutDate", required = true)
    protected DateRangeType blackoutDate;

    /**
     * Gets the value of the caseCourt property.
     * 
     * @return
     *     possible object is
     *     {@link CourtType }
     *     
     */
    public CourtType getCaseCourt() {
        return caseCourt;
    }

    /**
     * Sets the value of the caseCourt property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtType }
     *     
     */
    public void setCaseCourt(CourtType value) {
        this.caseCourt = value;
    }

    /**
     * Gets the value of the reasonDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getReasonDescriptionText() {
        return reasonDescriptionText;
    }

    /**
     * Sets the value of the reasonDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setReasonDescriptionText(TextType value) {
        this.reasonDescriptionText = value;
    }

    /**
     * Gets the value of the blackoutDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateRangeType }
     *     
     */
    public DateRangeType getBlackoutDate() {
        return blackoutDate;
    }

    /**
     * Sets the value of the blackoutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateRangeType }
     *     
     */
    public void setBlackoutDate(DateRangeType value) {
        this.blackoutDate = value;
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
