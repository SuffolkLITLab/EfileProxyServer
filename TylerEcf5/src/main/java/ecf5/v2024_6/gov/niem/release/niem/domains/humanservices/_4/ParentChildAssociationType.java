
package ecf5.v2024_6.gov.niem.release.niem.domains.humanservices._4;

import java.util.ArrayList;
import java.util.List;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.AssociationType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.PersonType;
import ecf5.v2024_6.gov.niem.release.niem.niem_core._4.TextType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an association between a child and a person who is in a parent role toward that child.
 * 
 * <p>Java class for ParentChildAssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParentChildAssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}AssociationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}Child"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}Parent" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}ParentChildKinshipCategoryAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/humanServices/4.1/}BiologicalParentDeterminationDescriptionText" minOccurs="0"/&gt;
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
@XmlType(name = "ParentChildAssociationType", propOrder = {
    "child",
    "parent",
    "parentChildKinshipCategoryAbstract",
    "biologicalParentDeterminationDescriptionText"
})
public class ParentChildAssociationType
    extends AssociationType
{

    @XmlElement(name = "Child", required = true)
    protected ChildType child;
    @XmlElement(name = "Parent", required = true, nillable = true)
    protected List<PersonType> parent;
    @XmlElementRef(name = "ParentChildKinshipCategoryAbstract", namespace = "http://release.niem.gov/niem/domains/humanServices/4.1/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> parentChildKinshipCategoryAbstract;
    @XmlElement(name = "BiologicalParentDeterminationDescriptionText")
    protected TextType biologicalParentDeterminationDescriptionText;

    /**
     * Gets the value of the child property.
     * 
     * @return
     *     possible object is
     *     {@link ChildType }
     *     
     */
    public ChildType getChild() {
        return child;
    }

    /**
     * Sets the value of the child property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChildType }
     *     
     */
    public void setChild(ChildType value) {
        this.child = value;
    }

    /**
     * Gets the value of the parent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the parent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonType }
     * 
     * 
     */
    public List<PersonType> getParent() {
        if (parent == null) {
            parent = new ArrayList<PersonType>();
        }
        return this.parent;
    }

    /**
     * Gets the value of the parentChildKinshipCategoryAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ParentChildKinshipCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getParentChildKinshipCategoryAbstract() {
        return parentChildKinshipCategoryAbstract;
    }

    /**
     * Sets the value of the parentChildKinshipCategoryAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ParentChildKinshipCategoryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setParentChildKinshipCategoryAbstract(JAXBElement<?> value) {
        this.parentChildKinshipCategoryAbstract = value;
    }

    /**
     * Gets the value of the biologicalParentDeterminationDescriptionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getBiologicalParentDeterminationDescriptionText() {
        return biologicalParentDeterminationDescriptionText;
    }

    /**
     * Sets the value of the biologicalParentDeterminationDescriptionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setBiologicalParentDeterminationDescriptionText(TextType value) {
        this.biologicalParentDeterminationDescriptionText = value;
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
