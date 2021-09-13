
package ecfv5.gov.niem.release.niem.niem_core._4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.domains.jxdm._6.ChargeDispositionType;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a result or outcome that is the product of handling, processing, or finalizing something.
 * 
 * <p>Java class for DispositionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DispositionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DispositionCategoryAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DispositionDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DispositionDescriptionText" minOccurs="0"/&gt;
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
@XmlType(name = "DispositionType", propOrder = {
    "dispositionCategoryAbstract",
    "dispositionDate",
    "dispositionDescriptionText"
})
@XmlSeeAlso({
    ChargeDispositionType.class,
    CaseDispositionType.class
})
public class DispositionType
    extends ObjectType
{

    @XmlElementRef(name = "DispositionCategoryAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> dispositionCategoryAbstract;
    @XmlElement(name = "DispositionDate")
    protected DateType dispositionDate;
    @XmlElement(name = "DispositionDescriptionText")
    protected TextType dispositionDescriptionText;

    /**
     * Gets the value of the dispositionCategoryAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDispositionCategoryAbstract() {
        return dispositionCategoryAbstract;
    }

    /**
     * Sets the value of the dispositionCategoryAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDispositionCategoryAbstract(JAXBElement<?> value) {
        this.dispositionCategoryAbstract = value;
    }

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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
