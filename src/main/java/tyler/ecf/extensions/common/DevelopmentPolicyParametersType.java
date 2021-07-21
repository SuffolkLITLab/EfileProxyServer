
package tyler.ecf.extensions.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for DevelopmentPolicyParametersType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DevelopmentPolicyParametersType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyResponseMessage-4.0}DevelopmentPolicyParametersType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}TimeoutMinutes"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}TimeoutResetHour"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
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
