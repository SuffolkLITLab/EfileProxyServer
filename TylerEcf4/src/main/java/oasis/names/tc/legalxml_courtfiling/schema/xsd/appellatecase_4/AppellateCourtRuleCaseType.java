
package oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4;

import java.util.ArrayList;
import java.util.List;
import gov.niem.niem.niem_core._2.NumericType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Additional information specific to court rule appellate cases.
 * 
 * <p>Java class for AppellateCourtRuleCaseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppellateCourtRuleCaseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}RuleCollectionText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}RuleCollectionNumber" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppellateCourtRuleCaseType", propOrder = {
    "ruleCollectionText",
    "ruleCollectionNumber"
})
public class AppellateCourtRuleCaseType
    extends ComplexObjectType
{

    @XmlElement(name = "RuleCollectionText")
    protected TextType ruleCollectionText;
    @XmlElement(name = "RuleCollectionNumber")
    protected List<NumericType> ruleCollectionNumber;

    /**
     * Gets the value of the ruleCollectionText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getRuleCollectionText() {
        return ruleCollectionText;
    }

    /**
     * Sets the value of the ruleCollectionText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setRuleCollectionText(TextType value) {
        this.ruleCollectionText = value;
    }

    /**
     * Gets the value of the ruleCollectionNumber property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the ruleCollectionNumber property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRuleCollectionNumber().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NumericType }
     * 
     * 
     */
    public List<NumericType> getRuleCollectionNumber() {
        if (ruleCollectionNumber == null) {
            ruleCollectionNumber = new ArrayList<NumericType>();
        }
        return this.ruleCollectionNumber;
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
