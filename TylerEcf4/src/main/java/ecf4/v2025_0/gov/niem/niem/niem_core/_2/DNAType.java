
package ecf4.v2025_0.gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DNAType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DNAType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DNALocus" maxOccurs="14" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}DNAImage" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DNAType", propOrder = {
    "dnaLocus",
    "dnaImage"
})
public class DNAType
    extends ComplexObjectType
{

    @XmlElement(name = "DNALocus", nillable = true)
    protected List<DNALocusType> dnaLocus;
    @XmlElement(name = "DNAImage", nillable = true)
    protected ImageType dnaImage;

    /**
     * Gets the value of the dnaLocus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the dnaLocus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDNALocus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DNALocusType }
     * 
     * 
     */
    public List<DNALocusType> getDNALocus() {
        if (dnaLocus == null) {
            dnaLocus = new ArrayList<DNALocusType>();
        }
        return this.dnaLocus;
    }

    /**
     * Gets the value of the dnaImage property.
     * 
     * @return
     *     possible object is
     *     {@link ImageType }
     *     
     */
    public ImageType getDNAImage() {
        return dnaImage;
    }

    /**
     * Sets the value of the dnaImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageType }
     *     
     */
    public void setDNAImage(ImageType value) {
        this.dnaImage = value;
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
