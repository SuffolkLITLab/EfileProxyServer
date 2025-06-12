
package ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CalAddressParamType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalAddressParamType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:ietf:params:xml:ns:icalendar-2.0}BaseParameterType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}cal-address"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalAddressParamType", propOrder = {
    "calAddress"
})
@XmlSeeAlso({
    SentByParamType.class
})
public class CalAddressParamType
    extends BaseParameterType
{

    @XmlElement(name = "cal-address", required = true)
    protected String calAddress;

    /**
     * Gets the value of the calAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCalAddress() {
        return calAddress;
    }

    /**
     * Sets the value of the calAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCalAddress(String value) {
        this.calAddress = value;
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
