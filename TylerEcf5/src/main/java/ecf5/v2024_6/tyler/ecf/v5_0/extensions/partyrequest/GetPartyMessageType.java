
package tyler.ecf.v5_0.extensions.partyrequest;

import gov.niem.release.niem.niem_core._4.IdentificationType;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.RequestMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for GetPartyMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetPartyMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}RequestMessageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:v5.0:extensions:common}PartyIdentification"/&gt;
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
@XmlType(name = "GetPartyMessageType", propOrder = {
    "partyIdentification"
})
public class GetPartyMessageType
    extends RequestMessageType
{

    @XmlElement(name = "PartyIdentification", namespace = "urn:tyler:ecf:v5.0:extensions:common", required = true)
    protected IdentificationType partyIdentification;

    /**
     * Gets the value of the partyIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getPartyIdentification() {
        return partyIdentification;
    }

    /**
     * Sets the value of the partyIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setPartyIdentification(IdentificationType value) {
        this.partyIdentification = value;
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
