
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.Boolean;


/**
 * &lt;p&gt;Java class for CapabilityType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="CapabilityType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/niem-core/2.0}CapabilityType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}IAmThisUserIndicator"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CapabilityType", propOrder = {
    "iAmThisUserIndicator"
})
public class CapabilityType
    extends gov.niem.niem.niem_core._2.CapabilityType
{

    @XmlElement(name = "IAmThisUserIndicator", required = true)
    protected Boolean iAmThisUserIndicator;

    /**
     * Gets the value of the iAmThisUserIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIAmThisUserIndicator() {
        return iAmThisUserIndicator;
    }

    /**
     * Sets the value of the iAmThisUserIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIAmThisUserIndicator(Boolean value) {
        this.iAmThisUserIndicator = value;
    }

}
