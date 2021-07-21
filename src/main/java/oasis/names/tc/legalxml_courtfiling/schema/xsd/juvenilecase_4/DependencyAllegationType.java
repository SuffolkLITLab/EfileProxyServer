
package oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The grounds for declaring a minor child to be a ward of the state because of the neglect or abuse of the minor child's parents or guardians.
 * 
 * <p>Java class for DependencyAllegationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DependencyAllegationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}DependencyAllegationCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}DependencyAllegationText" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DependencyAllegationType", propOrder = {
    "dependencyAllegationCode",
    "dependencyAllegationText"
})
public class DependencyAllegationType
    extends ComplexObjectType
{

    @XmlElement(name = "DependencyAllegationCode")
    protected TextType dependencyAllegationCode;
    @XmlElement(name = "DependencyAllegationText")
    protected TextType dependencyAllegationText;

    /**
     * Gets the value of the dependencyAllegationCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDependencyAllegationCode() {
        return dependencyAllegationCode;
    }

    /**
     * Sets the value of the dependencyAllegationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDependencyAllegationCode(TextType value) {
        this.dependencyAllegationCode = value;
    }

    /**
     * Gets the value of the dependencyAllegationText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getDependencyAllegationText() {
        return dependencyAllegationText;
    }

    /**
     * Sets the value of the dependencyAllegationText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setDependencyAllegationText(TextType value) {
        this.dependencyAllegationText = value;
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
