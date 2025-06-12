
package tyler.ecf.extensions.common;

import gov.niem.niem.niem_core._2.TextType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for FilerInformationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FilerInformationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FilerName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Common}FirmName" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FilerInformationType", propOrder = {
    "filerName",
    "firmName"
})
public class FilerInformationType {

    @XmlElement(name = "FilerName")
    protected TextType filerName;
    @XmlElement(name = "FirmName")
    protected TextType firmName;

    /**
     * Gets the value of the filerName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFilerName() {
        return filerName;
    }

    /**
     * Sets the value of the filerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFilerName(TextType value) {
        this.filerName = value;
    }

    /**
     * Gets the value of the firmName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getFirmName() {
        return firmName;
    }

    /**
     * Sets the value of the firmName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setFirmName(TextType value) {
        this.firmName = value;
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
