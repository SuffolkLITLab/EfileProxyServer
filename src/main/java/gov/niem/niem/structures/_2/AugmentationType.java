
package gov.niem.niem.structures._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import gov.niem.niem.domains.jxdm._4.CaseAugmentationType;
import gov.niem.niem.domains.jxdm._4.IncidentAugmentationType;
import gov.niem.niem.domains.jxdm._4.PropertyAugmentationType;
import gov.niem.niem.domains.screening._2.MarriageAssociationAugmentationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The AugmentationType type is a base type for all
 *       augmentations. An augmentation may have metadata and an ID, but may
 *       not have link metadata, as it does not establish a relationship
 *       between its value and its context. The individual element contents of
 *       an augmentation, however, do establish a relationship between the
 *       context of the augmentation and the values of the individual
 *       elements.
 * 
 * &lt;p&gt;Java class for AugmentationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AugmentationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;attribute ref="{http://niem.gov/niem/structures/2.0}id"/&amp;gt;
 *       &amp;lt;attribute ref="{http://niem.gov/niem/structures/2.0}metadata"/&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AugmentationType")
@XmlSeeAlso({
    MarriageAssociationAugmentationType.class,
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.OrganizationAugmentationType.class,
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonAugmentationType.class,
    CaseAugmentationType.class,
    IncidentAugmentationType.class,
    gov.niem.niem.domains.jxdm._4.OrganizationAugmentationType.class,
    gov.niem.niem.domains.jxdm._4.PersonAugmentationType.class,
    PropertyAugmentationType.class
})
public abstract class AugmentationType {

    @XmlAttribute(name = "id", namespace = "http://niem.gov/niem/structures/2.0")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "metadata", namespace = "http://niem.gov/niem/structures/2.0")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> metadata;

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
     * Gets the value of the metadata property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the metadata property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getMetadata().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getMetadata() {
        if (metadata == null) {
            metadata = new ArrayList<Object>();
        }
        return this.metadata;
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
