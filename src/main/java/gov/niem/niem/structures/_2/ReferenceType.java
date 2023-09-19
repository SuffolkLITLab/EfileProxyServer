
package gov.niem.niem.structures._2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The ReferenceType type is the type of all
 *       reference elements within NIEM-conformant schemas. This type provides
 *       a reference attribute, to reference an object defined elsewhere. It
 *       includes an ID, as the link established by a reference element may
 *       need to be identified, and it includes link metadata, as an element
 *       of this type establishes a relationship between its context and the
 *       referenced object. It does not contain metadata, as it does not
 *       itself establish the existence of an object; it relies on a
 *       definition located elsewhere.
 * 
 * <p>Java class for ReferenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ReferenceType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute ref="{http://niem.gov/niem/structures/2.0}id"/&gt;
 *       &lt;attribute ref="{http://niem.gov/niem/structures/2.0}ref"/&gt;
 *       &lt;attribute ref="{http://niem.gov/niem/structures/2.0}linkMetadata"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferenceType")
public class ReferenceType {

    @XmlAttribute(name = "id", namespace = "http://niem.gov/niem/structures/2.0")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "ref", namespace = "http://niem.gov/niem/structures/2.0")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object ref;
    @XmlAttribute(name = "linkMetadata", namespace = "http://niem.gov/niem/structures/2.0")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> linkMetadata;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRef() {
        return ref;
    }

    /**
     * Sets the value of the ref property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRef(Object value) {
        this.ref = value;
    }

    /**
     * Gets the value of the linkMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the linkMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getLinkMetadata() {
        if (linkMetadata == null) {
            linkMetadata = new ArrayList<Object>();
        }
        return this.linkMetadata;
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
