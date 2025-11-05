
package ecf4.latest.gov.niem.release.niem.domains.cbrn._4;

import ecf4.latest.gov.niem.release.niem.codes.cbrncl._4.SystemOperatingModeCodeType;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.DateTime;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a system event.
 * 
 * <p>Java class for SystemEventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SystemEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/domains/cbrn/4.0/}RemarksComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}SystemEventDateTime"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}SystemOperatingModeAbstract"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://release.niem.gov/niem/domains/cbrn/4.0/}systemSimulatedIndicator use="required""/&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SystemEventType", propOrder = {
    "systemEventDateTime",
    "systemOperatingModeAbstract"
})
@XmlSeeAlso({
    MessageStatusType.class
})
public class SystemEventType
    extends RemarksComplexObjectType
{

    @XmlElement(name = "SystemEventDateTime", required = true)
    protected DateTime systemEventDateTime;
    @XmlElementRef(name = "SystemOperatingModeAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class)
    protected JAXBElement<?> systemOperatingModeAbstract;
    @XmlAttribute(name = "systemSimulatedIndicator", namespace = "http://release.niem.gov/niem/domains/cbrn/4.0/", required = true)
    protected boolean systemSimulatedIndicator;

    /**
     * Gets the value of the systemEventDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link DateTime }
     *     
     */
    public DateTime getSystemEventDateTime() {
        return systemEventDateTime;
    }

    /**
     * Sets the value of the systemEventDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTime }
     *     
     */
    public void setSystemEventDateTime(DateTime value) {
        this.systemEventDateTime = value;
    }

    /**
     * Gets the value of the systemOperatingModeAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link SystemOperatingModeCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getSystemOperatingModeAbstract() {
        return systemOperatingModeAbstract;
    }

    /**
     * Sets the value of the systemOperatingModeAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link SystemOperatingModeCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setSystemOperatingModeAbstract(JAXBElement<?> value) {
        this.systemOperatingModeAbstract = value;
    }

    /**
     * Gets the value of the systemSimulatedIndicator property.
     * 
     */
    public boolean isSystemSimulatedIndicator() {
        return systemSimulatedIndicator;
    }

    /**
     * Sets the value of the systemSimulatedIndicator property.
     * 
     */
    public void setSystemSimulatedIndicator(boolean value) {
        this.systemSimulatedIndicator = value;
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
