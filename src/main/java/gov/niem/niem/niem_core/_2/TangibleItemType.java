
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.fbi._2.VCOCodeType;
import gov.niem.niem.fbi._2.VSTCodeType;
import gov.niem.niem.proxy.xsd._2.GYear;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for TangibleItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TangibleItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}ItemType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ItemColor" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ItemModelYearDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}ItemStyle" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TangibleItemType", propOrder = {
    "itemColor",
    "itemModelYearDate",
    "itemStyle"
})
@XmlSeeAlso({
    ConveyanceType.class
})
public class TangibleItemType
    extends ItemType
{

    @XmlElementRef(name = "ItemColor", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> itemColor;
    @XmlElement(name = "ItemModelYearDate", nillable = true)
    protected GYear itemModelYearDate;
    @XmlElementRef(name = "ItemStyle", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> itemStyle;

    /**
     * Gets the value of the itemColor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VCOCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getItemColor() {
        return itemColor;
    }

    /**
     * Sets the value of the itemColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VCOCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setItemColor(JAXBElement<?> value) {
        this.itemColor = value;
    }

    /**
     * Gets the value of the itemModelYearDate property.
     * 
     * @return
     *     possible object is
     *     {@link GYear }
     *     
     */
    public GYear getItemModelYearDate() {
        return itemModelYearDate;
    }

    /**
     * Sets the value of the itemModelYearDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link GYear }
     *     
     */
    public void setItemModelYearDate(GYear value) {
        this.itemModelYearDate = value;
    }

    /**
     * Gets the value of the itemStyle property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VSTCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getItemStyle() {
        return itemStyle;
    }

    /**
     * Sets the value of the itemStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VSTCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setItemStyle(JAXBElement<?> value) {
        this.itemStyle = value;
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
