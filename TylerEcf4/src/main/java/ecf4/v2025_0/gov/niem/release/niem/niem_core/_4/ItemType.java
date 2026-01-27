
package ecf4.v2025_0.gov.niem.release.niem.niem_core._4;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.release.niem.codes.fbi_ncic._4.VCOCodeType;
import ecf4.v2025_0.gov.niem.release.niem.codes.fbi_ncic._4.VSTCodeType;
import ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.GYear;
import ecf4.v2025_0.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ItemAugmentationType;


/**
 * A data type for an article or thing.
 * 
 * <p>Java class for ItemType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ItemDescriptionText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ItemOtherIdentification" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ItemValue" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ItemColorAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ItemModelYearDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ItemStyleAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}ItemAugmentationPoint" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "ItemType", propOrder = {
    "itemDescriptionText",
    "itemOtherIdentification",
    "itemValue",
    "itemColorAbstract",
    "itemModelYearDate",
    "itemStyleAbstract",
    "itemAugmentationPoint"
})
@XmlSeeAlso({
    ConveyanceType.class
})
public class ItemType
    extends ObjectType
{

    @XmlElement(name = "ItemDescriptionText")
    protected TextType itemDescriptionText;
    @XmlElement(name = "ItemOtherIdentification")
    protected IdentificationType itemOtherIdentification;
    @XmlElement(name = "ItemValue")
    protected ItemValueType itemValue;
    @XmlElementRef(name = "ItemColorAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> itemColorAbstract;
    @XmlElement(name = "ItemModelYearDate")
    protected GYear itemModelYearDate;
    @XmlElementRef(name = "ItemStyleAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> itemStyleAbstract;
    @XmlElementRef(name = "ItemAugmentationPoint", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected List<JAXBElement<?>> itemAugmentationPoint;

    /**
     * Gets the value of the itemDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getItemDescriptionText() {
        return itemDescriptionText;
    }

    /**
     * Sets the value of the itemDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setItemDescriptionText(TextType value) {
        this.itemDescriptionText = value;
    }

    /**
     * Gets the value of the itemOtherIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getItemOtherIdentification() {
        return itemOtherIdentification;
    }

    /**
     * Sets the value of the itemOtherIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setItemOtherIdentification(IdentificationType value) {
        this.itemOtherIdentification = value;
    }

    /**
     * Gets the value of the itemValue property.
     * 
     * @return
     *     possible object is
     *     {@link ItemValueType }
     *     
     */
    public ItemValueType getItemValue() {
        return itemValue;
    }

    /**
     * Sets the value of the itemValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemValueType }
     *     
     */
    public void setItemValue(ItemValueType value) {
        this.itemValue = value;
    }

    /**
     * Gets the value of the itemColorAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VCOCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getItemColorAbstract() {
        return itemColorAbstract;
    }

    /**
     * Sets the value of the itemColorAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VCOCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setItemColorAbstract(JAXBElement<?> value) {
        this.itemColorAbstract = value;
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
     * Gets the value of the itemStyleAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VSTCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getItemStyleAbstract() {
        return itemStyleAbstract;
    }

    /**
     * Sets the value of the itemStyleAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VSTCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setItemStyleAbstract(JAXBElement<?> value) {
        this.itemStyleAbstract = value;
    }

    /**
     * Gets the value of the itemAugmentationPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the itemAugmentationPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemAugmentationPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link ItemAugmentationType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getItemAugmentationPoint() {
        if (itemAugmentationPoint == null) {
            itemAugmentationPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.itemAugmentationPoint;
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
