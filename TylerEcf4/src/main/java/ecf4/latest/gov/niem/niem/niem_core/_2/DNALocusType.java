
package ecf4.latest.gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DNALocusType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DNALocusType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DNALocusCategoryText" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DNALocusValue" maxOccurs="2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DNALocusType", propOrder = {
    "dnaLocusCategoryText",
    "dnaLocusValue"
})
public class DNALocusType
    extends ComplexObjectType
{

    @XmlElement(name = "DNALocusCategoryText", nillable = true)
    protected TextType dnaLocusCategoryText;
    @XmlElement(name = "DNALocusValue", required = true, nillable = true)
    protected List<TextType> dnaLocusValue;

    /**
     * Gets the value of the dnaLocusCategoryText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDNALocusCategoryText() {
        return dnaLocusCategoryText;
    }

    /**
     * Sets the value of the dnaLocusCategoryText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDNALocusCategoryText(TextType value) {
        this.dnaLocusCategoryText = value;
    }

    /**
     * Gets the value of the dnaLocusValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the dnaLocusValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDNALocusValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getDNALocusValue() {
        if (dnaLocusValue == null) {
            dnaLocusValue = new ArrayList<TextType>();
        }
        return this.dnaLocusValue;
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
