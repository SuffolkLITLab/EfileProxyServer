
package ecf5.v2024_6.tyler.ecf.v5_0.extensions.common;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for HearingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="HearingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingID"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingDescription" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingFlag" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}HearingCommentText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}Setting" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HearingType", propOrder = {
    "hearingID",
    "hearingTypeCode",
    "hearingDescription",
    "hearingFlag",
    "hearingCommentText",
    "setting"
})
public class HearingType {

    @XmlElement(name = "HearingID", required = true)
    protected IdentificationType hearingID;
    @XmlElement(name = "HearingTypeCode")
    protected TextType hearingTypeCode;
    @XmlElement(name = "HearingDescription")
    protected TextType hearingDescription;
    @XmlElement(name = "HearingFlag")
    protected TextType hearingFlag;
    @XmlElement(name = "HearingCommentText")
    protected TextType hearingCommentText;
    @XmlElement(name = "Setting", required = true)
    protected List<SettingType> setting;

    /**
     * Gets the value of the hearingID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getHearingID() {
        return hearingID;
    }

    /**
     * Sets the value of the hearingID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setHearingID(IdentificationType value) {
        this.hearingID = value;
    }

    /**
     * Gets the value of the hearingTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getHearingTypeCode() {
        return hearingTypeCode;
    }

    /**
     * Sets the value of the hearingTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setHearingTypeCode(TextType value) {
        this.hearingTypeCode = value;
    }

    /**
     * Gets the value of the hearingDescription property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getHearingDescription() {
        return hearingDescription;
    }

    /**
     * Sets the value of the hearingDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setHearingDescription(TextType value) {
        this.hearingDescription = value;
    }

    /**
     * Gets the value of the hearingFlag property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getHearingFlag() {
        return hearingFlag;
    }

    /**
     * Sets the value of the hearingFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setHearingFlag(TextType value) {
        this.hearingFlag = value;
    }

    /**
     * Gets the value of the hearingCommentText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getHearingCommentText() {
        return hearingCommentText;
    }

    /**
     * Sets the value of the hearingCommentText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setHearingCommentText(TextType value) {
        this.hearingCommentText = value;
    }

    /**
     * Gets the value of the setting property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the setting property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSetting().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SettingType }
     * 
     * 
     */
    public List<SettingType> getSetting() {
        if (setting == null) {
            setting = new ArrayList<SettingType>();
        }
        return this.setting;
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
