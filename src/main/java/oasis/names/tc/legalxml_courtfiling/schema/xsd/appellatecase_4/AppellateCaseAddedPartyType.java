
package oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Party added to the appeal that was not  a party in the original case.  For instance, the attorney in the original case may appeal sanctions against the attorney by the court.
 * 
 * <p>Java class for AppellateCaseAddedPartyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AppellateCaseAddedPartyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:AppellateCase-4.0}AppellateCasePartyAddedReasonText" minOccurs="0"/&gt;
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
@XmlType(name = "AppellateCaseAddedPartyType", propOrder = {
    "appellateCasePartyAddedReasonText",
    "appellateCaseParty"
})
public class AppellateCaseAddedPartyType
    extends ComplexObjectType
{

    @XmlElement(name = "AppellateCasePartyAddedReasonText")
    protected TextType appellateCasePartyAddedReasonText;
    @XmlElement(name = "AppellateCaseParty", required = true)
    protected EntityType appellateCaseParty;

    /**
     * Gets the value of the appellateCasePartyAddedReasonText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAppellateCasePartyAddedReasonText() {
        return appellateCasePartyAddedReasonText;
    }

    /**
     * Sets the value of the appellateCasePartyAddedReasonText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAppellateCasePartyAddedReasonText(TextType value) {
        this.appellateCasePartyAddedReasonText = value;
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
