
package ecfv5.gov.niem.release.niem.domains.biometrics._4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecfv5.gov.niem.release.niem.niem_core._4.TextType;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for an autosomal STR, X-STR, and Y-STR DNA profile
 * 
 * <p>Java class for DNASTRProfileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DNASTRProfileType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/biometrics/4.0/}DNALocusIdentification" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/biometrics/4.0/}DNAAlleleCall1Text" maxOccurs="2"/&gt;
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
@XmlType(name = "DNASTRProfileType", propOrder = {
    "dnaLocusIdentification",
    "dnaAlleleCall1Text"
})
public class DNASTRProfileType
    extends ObjectType
{

    @XmlElement(name = "DNALocusIdentification")
    protected List<IdentificationType> dnaLocusIdentification;
    @XmlElement(name = "DNAAlleleCall1Text", required = true)
    protected List<TextType> dnaAlleleCall1Text;

    /**
     * Gets the value of the dnaLocusIdentification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dnaLocusIdentification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDNALocusIdentification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getDNALocusIdentification() {
        if (dnaLocusIdentification == null) {
            dnaLocusIdentification = new ArrayList<IdentificationType>();
        }
        return this.dnaLocusIdentification;
    }

    /**
     * Gets the value of the dnaAlleleCall1Text property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dnaAlleleCall1Text property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDNAAlleleCall1Text().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getDNAAlleleCall1Text() {
        if (dnaAlleleCall1Text == null) {
            dnaAlleleCall1Text = new ArrayList<TextType>();
        }
        return this.dnaAlleleCall1Text;
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
