
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.ChargeDispositionType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DispositionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DispositionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DispositionDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DispositionDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DispositionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DispositionCategoryText" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DispositionType", propOrder = {
    "dispositionDate",
    "dispositionDescriptionText",
    "dispositionText",
    "dispositionCategoryText"
})
@XmlSeeAlso({
    ChargeDispositionType.class,
    CaseDispositionType.class
})
public class DispositionType
    extends ComplexObjectType
{

    @XmlElement(name = "DispositionDate", nillable = true)
    protected DateType dispositionDate;
    @XmlElement(name = "DispositionDescriptionText", nillable = true)
    protected TextType dispositionDescriptionText;
    @XmlElement(name = "DispositionText", nillable = true)
    protected TextType dispositionText;
    @XmlElement(name = "DispositionCategoryText", nillable = true)
    protected TextType dispositionCategoryText;

    /**
     * Gets the value of the dispositionDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDispositionDate() {
        return dispositionDate;
    }

    /**
     * Sets the value of the dispositionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDispositionDate(DateType value) {
        this.dispositionDate = value;
    }

    /**
     * Gets the value of the dispositionDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDispositionDescriptionText() {
        return dispositionDescriptionText;
    }

    /**
     * Sets the value of the dispositionDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDispositionDescriptionText(TextType value) {
        this.dispositionDescriptionText = value;
    }

    /**
     * Gets the value of the dispositionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDispositionText() {
        return dispositionText;
    }

    /**
     * Sets the value of the dispositionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDispositionText(TextType value) {
        this.dispositionText = value;
    }

    /**
     * Gets the value of the dispositionCategoryText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDispositionCategoryText() {
        return dispositionCategoryText;
    }

    /**
     * Sets the value of the dispositionCategoryText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDispositionCategoryText(TextType value) {
        this.dispositionCategoryText = value;
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
