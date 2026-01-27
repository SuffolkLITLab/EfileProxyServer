
package ecf4.v2025_0.gov.niem.release.niem.niem_core._4;

import ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.Boolean;
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


/**
 * A data type for coverage by a contract whereby one party agrees to indemnify or guarantee another against loss by a specified contingent event or peril.
 * 
 * <p>Java class for InsuranceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InsuranceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}InsuranceCarrierName" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}InsuranceActiveIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}InsuranceCoverageCategoryAbstract" minOccurs="0"/&gt;
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
@XmlType(name = "InsuranceType", propOrder = {
    "insuranceCarrierName",
    "insuranceActiveIndicator",
    "insuranceCoverageCategoryAbstract"
})
@XmlSeeAlso({
   ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.InsuranceType.class
})
public class InsuranceType
    extends ObjectType
{

    @XmlElement(name = "InsuranceCarrierName")
    protected TextType insuranceCarrierName;
    @XmlElement(name = "InsuranceActiveIndicator")
    protected Boolean insuranceActiveIndicator;
    @XmlElementRef(name = "InsuranceCoverageCategoryAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> insuranceCoverageCategoryAbstract;

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
     * Gets the value of the insuranceCoverageCategoryAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getInsuranceCoverageCategoryAbstract() {
        return insuranceCoverageCategoryAbstract;
    }

    /**
     * Sets the value of the insuranceCoverageCategoryAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setInsuranceCoverageCategoryAbstract(JAXBElement<?> value) {
        this.insuranceCoverageCategoryAbstract = value;
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
