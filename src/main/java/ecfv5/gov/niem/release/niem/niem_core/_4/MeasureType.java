
package ecfv5.gov.niem.release.niem.niem_core._4;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ecfv5.gov.niem.release.niem.proxy.xsd._4.Decimal;
import ecfv5.gov.niem.release.niem.structures._4.ObjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for a measurement.
 * 
 * <p>Java class for MeasureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeasureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}MeasureValueAbstract"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}MeasureUnitAbstract" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasureType", propOrder = {
    "measureValueAbstract",
    "measureUnitAbstract"
})
@XmlSeeAlso({
    SpeedMeasureType.class,
    LengthMeasureType.class,
    WeightMeasureType.class
})
public class MeasureType
    extends ObjectType
{

    @XmlElementRef(name = "MeasureValueAbstract", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class)
    protected JAXBElement<?> measureValueAbstract;
    @XmlElement(name = "MeasureUnitAbstract")
    protected Object measureUnitAbstract;

    /**
     * Gets the value of the measureValueAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getMeasureValueAbstract() {
        return measureValueAbstract;
    }

    /**
     * Sets the value of the measureValueAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Decimal }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setMeasureValueAbstract(JAXBElement<?> value) {
        this.measureValueAbstract = value;
    }

    /**
     * Gets the value of the measureUnitAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getMeasureUnitAbstract() {
        return measureUnitAbstract;
    }

    /**
     * Sets the value of the measureUnitAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setMeasureUnitAbstract(Object value) {
        this.measureUnitAbstract = value;
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
