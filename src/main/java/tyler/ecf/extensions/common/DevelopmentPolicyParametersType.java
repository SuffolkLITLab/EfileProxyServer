
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * &lt;p&gt;Java class for DevelopmentPolicyParametersType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DevelopmentPolicyParametersType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}DevelopmentPolicyParametersType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}TimeoutMinutes"/&amp;gt;
 *         &amp;lt;element ref="{urn:tyler:ecf:extensions:Common}TimeoutResetHour"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DevelopmentPolicyParametersType", propOrder = {
    "timeoutMinutes",
    "timeoutResetHour"
})
public class DevelopmentPolicyParametersType
    extends oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.DevelopmentPolicyParametersType
{

    @XmlElement(name = "TimeoutMinutes")
    protected int timeoutMinutes;
    @XmlElement(name = "TimeoutResetHour", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar timeoutResetHour;

    /**
     * Gets the value of the timeoutMinutes property.
     * 
     */
    public int getTimeoutMinutes() {
        return timeoutMinutes;
    }

    /**
     * Sets the value of the timeoutMinutes property.
     * 
     */
    public void setTimeoutMinutes(int value) {
        this.timeoutMinutes = value;
    }

    /**
     * Gets the value of the timeoutResetHour property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTimeoutResetHour() {
        return timeoutResetHour;
    }

    /**
     * Sets the value of the timeoutResetHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTimeoutResetHour(XMLGregorianCalendar value) {
        this.timeoutResetHour = value;
    }

}
