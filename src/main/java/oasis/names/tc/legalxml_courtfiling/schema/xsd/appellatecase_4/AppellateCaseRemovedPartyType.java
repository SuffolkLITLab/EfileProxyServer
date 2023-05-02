
package oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Party to the original case that is not party to the appeal.
 * 
 * <p>Java class for AppellateCaseRemovedPartyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppellateCaseRemovedPartyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}AppellateCasePartyRemovedReasonText" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}AppellateCaseParty"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppellateCaseRemovedPartyType", propOrder = {
    "appellateCasePartyRemovedReasonText",
    "appellateCaseParty"
})
public class AppellateCaseRemovedPartyType
    extends ComplexObjectType
{

    @XmlElement(name = "AppellateCasePartyRemovedReasonText")
    protected TextType appellateCasePartyRemovedReasonText;
    @XmlElement(name = "AppellateCaseParty", required = true)
    protected EntityType appellateCaseParty;

    /**
     * Gets the value of the appellateCasePartyRemovedReasonText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAppellateCasePartyRemovedReasonText() {
        return appellateCasePartyRemovedReasonText;
    }

    /**
     * Sets the value of the appellateCasePartyRemovedReasonText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAppellateCasePartyRemovedReasonText(TextType value) {
        this.appellateCasePartyRemovedReasonText = value;
    }

    /**
     * Gets the value of the appellateCaseParty property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getAppellateCaseParty() {
        return appellateCaseParty;
    }

    /**
     * Sets the value of the appellateCaseParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setAppellateCaseParty(EntityType value) {
        this.appellateCaseParty = value;
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
