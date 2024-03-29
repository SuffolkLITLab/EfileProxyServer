//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0.1 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.04.16 at 04:29:27 PM UTC 
//


package org.oasis_open.docs.codelist.ns.genericode._1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * An individual code list metadata value.
 * 
 * <p>Java class for Value complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Value"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Annotation" type="{http://docs.oasis-open.org/codelist/ns/genericode/1.0/}Annotation" minOccurs="0"/&gt;
 *         &lt;group ref="{http://docs.oasis-open.org/codelist/ns/genericode/1.0/}ValueChoice" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attGroup ref="{http://docs.oasis-open.org/codelist/ns/genericode/1.0/}ColumnReference"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Value", propOrder = {
    "annotation",
    "simpleValue",
    "complexValue"
})
public class Value {

    @XmlElement(name = "Annotation")
    protected Annotation annotation;
    @XmlElement(name = "SimpleValue")
    protected SimpleValue simpleValue;
    @XmlElement(name = "ComplexValue")
    protected AnyOtherContent complexValue;
    @XmlAttribute(name = "ColumnRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object columnRef;

    /**
     * Gets the value of the annotation property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation }
     *     
     */
    public Annotation getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation }
     *     
     */
    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    /**
     * Gets the value of the simpleValue property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleValue }
     *     
     */
    public SimpleValue getSimpleValue() {
        return simpleValue;
    }

    /**
     * Sets the value of the simpleValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleValue }
     *     
     */
    public void setSimpleValue(SimpleValue value) {
        this.simpleValue = value;
    }

    /**
     * Gets the value of the complexValue property.
     * 
     * @return
     *     possible object is
     *     {@link AnyOtherContent }
     *     
     */
    public AnyOtherContent getComplexValue() {
        return complexValue;
    }

    /**
     * Sets the value of the complexValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnyOtherContent }
     *     
     */
    public void setComplexValue(AnyOtherContent value) {
        this.complexValue = value;
    }

    /**
     * Gets the value of the columnRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getColumnRef() {
        return columnRef;
    }

    /**
     * Sets the value of the columnRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setColumnRef(Object value) {
        this.columnRef = value;
    }

}
