
package ecf4.latest.tyler.ecf.extensions.massachusetts;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.latest.tyler.ecf.extensions.common.ExtendedDataType;


/**
 * <p>Java class for RepresentativeCapacityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RepresentativeCapacityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:tyler:ecf:extensions:Common}ExtendedDataType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Massachusetts}Component1"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Massachusetts}Component2"/&gt;
 *         &lt;element ref="{urn:tyler:ecf:extensions:Massachusetts}Component3"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepresentativeCapacityType", propOrder = {
    "component1",
    "component2",
    "component3"
})
public class RepresentativeCapacityType
    extends ExtendedDataType
{

    @XmlElement(name = "Component1", required = true)
    protected Component1Type component1;
    @XmlElement(name = "Component2", required = true)
    protected Component2Type component2;
    @XmlElement(name = "Component3", required = true)
    protected Component3Type component3;

    /**
     * Gets the value of the component1 property.
     * 
     * @return
     *     possible object is
     *     {@link Component1Type }
     *     
     */
    public Component1Type getComponent1() {
        return component1;
    }

    /**
     * Sets the value of the component1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Component1Type }
     *     
     */
    public void setComponent1(Component1Type value) {
        this.component1 = value;
    }

    /**
     * Gets the value of the component2 property.
     * 
     * @return
     *     possible object is
     *     {@link Component2Type }
     *     
     */
    public Component2Type getComponent2() {
        return component2;
    }

    /**
     * Sets the value of the component2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Component2Type }
     *     
     */
    public void setComponent2(Component2Type value) {
        this.component2 = value;
    }

    /**
     * Gets the value of the component3 property.
     * 
     * @return
     *     possible object is
     *     {@link Component3Type }
     *     
     */
    public Component3Type getComponent3() {
        return component3;
    }

    /**
     * Sets the value of the component3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Component3Type }
     *     
     */
    public void setComponent3(Component3Type value) {
        this.component3 = value;
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
