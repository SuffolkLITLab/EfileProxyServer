
package ecf4.v2025_0.gov.niem.niem.domains.screening._2;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.TextType;
import ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.Boolean;
import ecf4.v2025_0.gov.niem.niem.structures._2.AugmentationType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for MarriageAssociationAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MarriageAssociationAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/screening/2.0}DivorceDecreeIndicator" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/screening/2.0}MarriageCityName" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MarriageAssociationAugmentationType", propOrder = {
    "divorceDecreeIndicator",
    "marriageCityName"
})
public class MarriageAssociationAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "DivorceDecreeIndicator", nillable = true)
    protected List<Boolean> divorceDecreeIndicator;
    @XmlElement(name = "MarriageCityName", nillable = true)
    protected List<TextType> marriageCityName;

    /**
     * Gets the value of the divorceDecreeIndicator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the divorceDecreeIndicator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDivorceDecreeIndicator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Boolean }
     * 
     * 
     */
    public List<Boolean> getDivorceDecreeIndicator() {
        if (divorceDecreeIndicator == null) {
            divorceDecreeIndicator = new ArrayList<Boolean>();
        }
        return this.divorceDecreeIndicator;
    }

    /**
     * Gets the value of the marriageCityName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the marriageCityName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMarriageCityName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getMarriageCityName() {
        if (marriageCityName == null) {
            marriageCityName = new ArrayList<TextType>();
        }
        return this.marriageCityName;
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
