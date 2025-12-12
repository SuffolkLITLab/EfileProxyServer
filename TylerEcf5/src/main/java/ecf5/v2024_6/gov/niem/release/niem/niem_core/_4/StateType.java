
package ecf5.v2024_6.gov.niem.release.niem.niem_core._4;

import ecf5.v2024_6.gov.niem.release.niem.codes.fbi_ncic._4.CountryCodeType;
import ecf5.v2024_6.gov.niem.release.niem.codes.usps_states._4.USStateCodeType;
import ecf5.v2024_6.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a state, commonwealth, province, or other such geopolitical subdivision of a country.
 * 
 * <p>Java class for StateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}StateRepresentation" minOccurs="0"/&gt;
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
@XmlType(name = "StateType", propOrder = {
    "stateRepresentation"
})
public class StateType
    extends ObjectType
{

    @XmlElementRef(name = "StateRepresentation", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> stateRepresentation;

    /**
     * Gets the value of the stateRepresentation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link USStateCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getStateRepresentation() {
        return stateRepresentation;
    }

    /**
     * Sets the value of the stateRepresentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CountryCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link USStateCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setStateRepresentation(JAXBElement<?> value) {
        this.stateRepresentation = value;
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
