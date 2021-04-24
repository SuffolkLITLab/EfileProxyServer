
package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.Date;
import gov.niem.niem.proxy.xsd._2.DateTime;
import gov.niem.niem.proxy.xsd._2.GYear;
import gov.niem.niem.structures._2.ComplexObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for DateType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DateType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}DateRepresentation"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateType", propOrder = {
    "dateRepresentation"
})
public class DateType
    extends ComplexObjectType
{

    @XmlElementRef(name = "DateRepresentation", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class)
    protected JAXBElement<?> dateRepresentation;

    /**
     * Gets the value of the dateRepresentation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link DateTime }{@code >}
     *     {@link JAXBElement }{@code <}{@link GYear }{@code >}
     *     {@link JAXBElement }{@code <}{@link Date }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getDateRepresentation() {
        return dateRepresentation;
    }

    /**
     * Sets the value of the dateRepresentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link DateTime }{@code >}
     *     {@link JAXBElement }{@code <}{@link GYear }{@code >}
     *     {@link JAXBElement }{@code <}{@link Date }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setDateRepresentation(JAXBElement<?> value) {
        this.dateRepresentation = value;
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
