
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.Boolean;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for InsuranceType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="InsuranceType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}InsuranceCarrierName" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}InsuranceActiveIndicator" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}InsuranceCoverageCategory" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsuranceType", propOrder = {
    "insuranceCarrierName",
    "insuranceActiveIndicator",
    "insuranceCoverageCategory"
})
@XmlSeeAlso({
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.InsuranceType.class
})
public class InsuranceType
    extends ComplexObjectType
{

    @XmlElement(name = "InsuranceCarrierName", nillable = true)
    protected TextType insuranceCarrierName;
    @XmlElement(name = "InsuranceActiveIndicator", nillable = true)
    protected Boolean insuranceActiveIndicator;
    @XmlElementRef(name = "InsuranceCoverageCategory", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> insuranceCoverageCategory;

    /**
     * Gets the value of the insuranceCarrierName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getInsuranceCarrierName() {
        return insuranceCarrierName;
    }

    /**
     * Sets the value of the insuranceCarrierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setInsuranceCarrierName(TextType value) {
        this.insuranceCarrierName = value;
    }

    /**
     * Gets the value of the insuranceActiveIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getInsuranceActiveIndicator() {
        return insuranceActiveIndicator;
    }

    /**
     * Sets the value of the insuranceActiveIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInsuranceActiveIndicator(Boolean value) {
        this.insuranceActiveIndicator = value;
    }

    /**
     * Gets the value of the insuranceCoverageCategory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getInsuranceCoverageCategory() {
        return insuranceCoverageCategory;
    }

    /**
     * Sets the value of the insuranceCoverageCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setInsuranceCoverageCategory(JAXBElement<?> value) {
        this.insuranceCoverageCategory = value;
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
