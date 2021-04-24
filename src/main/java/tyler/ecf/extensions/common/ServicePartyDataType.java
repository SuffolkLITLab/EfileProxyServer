
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.structures._2.ReferenceType;


/**
 * &lt;p&gt;Java class for ServicePartyDataType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ServicePartyDataType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:tyler:ecf:extensions:Common}ExtendedDataType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}PartyReference"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}ServiceReference"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServicePartyDataType", propOrder = {
    "partyReference",
    "serviceReference"
})
public class ServicePartyDataType
    extends ExtendedDataType
{

    @XmlElement(name = "PartyReference", required = true)
    protected ReferenceType partyReference;
    @XmlElement(name = "ServiceReference", required = true)
    protected ReferenceType serviceReference;

    /**
     * Gets the value of the partyReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getPartyReference() {
        return partyReference;
    }

    /**
     * Sets the value of the partyReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setPartyReference(ReferenceType value) {
        this.partyReference = value;
    }

    /**
     * Gets the value of the serviceReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getServiceReference() {
        return serviceReference;
    }

    /**
     * Sets the value of the serviceReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setServiceReference(ReferenceType value) {
        this.serviceReference = value;
    }

}
