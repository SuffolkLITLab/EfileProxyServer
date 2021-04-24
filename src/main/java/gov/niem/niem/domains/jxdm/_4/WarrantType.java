
package gov.niem.niem.domains.jxdm._4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.fbi._2.EXLCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for WarrantType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="WarrantType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}CourtOrderType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}WarrantExtraditionLimitation" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WarrantType", propOrder = {
    "warrantExtraditionLimitation"
})
public class WarrantType
    extends CourtOrderType
{

    @XmlElementRef(name = "WarrantExtraditionLimitation", namespace = "http://niem.gov/niem/domains/jxdm/4.0", type = JAXBElement.class, required = false)
    protected JAXBElement<?> warrantExtraditionLimitation;

    /**
     * Gets the value of the warrantExtraditionLimitation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EXLCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getWarrantExtraditionLimitation() {
        return warrantExtraditionLimitation;
    }

    /**
     * Sets the value of the warrantExtraditionLimitation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EXLCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setWarrantExtraditionLimitation(JAXBElement<?> value) {
        this.warrantExtraditionLimitation = value;
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
