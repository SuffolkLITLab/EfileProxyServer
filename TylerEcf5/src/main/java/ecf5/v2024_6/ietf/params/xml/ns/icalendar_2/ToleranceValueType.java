
package ietf.params.xml.ns.icalendar_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 *          A tolerance value is a set of durations which indicate the allowed
 *          tolerance for the indicated value, e.g. startafter=PT5M indicates that
 *          5 minutes late is acceptable. 
 *       
 * 
 * <p>Java class for ToleranceValueType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ToleranceValueType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="startbefore" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
 *         &lt;element name="startafter" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
 *         &lt;element name="endbefore" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
 *         &lt;element name="endafter" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
 *         &lt;element name="durationlong" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
 *         &lt;element name="durationshort" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
 *         &lt;element name="precision" type="{urn:ietf:params:xml:ns:icalendar-2.0}DurationValueType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ToleranceValueType", propOrder = {
    "startbefore",
    "startafter",
    "endbefore",
    "endafter",
    "durationlong",
    "durationshort",
    "precision"
})
public class ToleranceValueType {

    protected String startbefore;
    protected String startafter;
    protected String endbefore;
    protected String endafter;
    protected String durationlong;
    protected String durationshort;
    protected String precision;

    /**
     * Gets the value of the startbefore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartbefore() {
        return startbefore;
    }

    /**
     * Sets the value of the startbefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartbefore(String value) {
        this.startbefore = value;
    }

    /**
     * Gets the value of the startafter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartafter() {
        return startafter;
    }

    /**
     * Sets the value of the startafter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartafter(String value) {
        this.startafter = value;
    }

    /**
     * Gets the value of the endbefore property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndbefore() {
        return endbefore;
    }

    /**
     * Sets the value of the endbefore property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndbefore(String value) {
        this.endbefore = value;
    }

    /**
     * Gets the value of the endafter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndafter() {
        return endafter;
    }

    /**
     * Sets the value of the endafter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndafter(String value) {
        this.endafter = value;
    }

    /**
     * Gets the value of the durationlong property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDurationlong() {
        return durationlong;
    }

    /**
     * Sets the value of the durationlong property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDurationlong(String value) {
        this.durationlong = value;
    }

    /**
     * Gets the value of the durationshort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDurationshort() {
        return durationshort;
    }

    /**
     * Sets the value of the durationshort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDurationshort(String value) {
        this.durationshort = value;
    }

    /**
     * Gets the value of the precision property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrecision() {
        return precision;
    }

    /**
     * Sets the value of the precision property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrecision(String value) {
        this.precision = value;
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
