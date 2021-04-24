
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ComplexObjectType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A name other than an official name used by a person or organization.
 * 
 * &lt;p&gt;Java class for AliasType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AliasType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}AliasAlternateName"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}AliasAlternateNameTypeCode" maxOccurs="unbounded"/&amp;gt;
 *         &amp;lt;choice maxOccurs="unbounded" minOccurs="0"&amp;gt;
 *           &amp;lt;element ref="{http://niem.gov/niem/niem-core/2.0}EntityReference"/&amp;gt;
 *         &amp;lt;/choice&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AliasType", propOrder = {
    "aliasAlternateName",
    "aliasAlternateNameTypeCode",
    "entityReference"
})
public class AliasType
    extends ComplexObjectType
{

    @XmlElement(name = "AliasAlternateName", required = true)
    protected TextType aliasAlternateName;
    @XmlElement(name = "AliasAlternateNameTypeCode", required = true)
    protected List<TextType> aliasAlternateNameTypeCode;
    @XmlElement(name = "EntityReference", namespace = "http://niem.gov/niem/niem-core/2.0")
    protected List<ReferenceType> entityReference;

    /**
     * Gets the value of the aliasAlternateName property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getAliasAlternateName() {
        return aliasAlternateName;
    }

    /**
     * Sets the value of the aliasAlternateName property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setAliasAlternateName(TextType value) {
        this.aliasAlternateName = value;
    }

    /**
     * Gets the value of the aliasAlternateNameTypeCode property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the aliasAlternateNameTypeCode property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAliasAlternateNameTypeCode().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link TextType }
     * 
     * 
     */
    public List<TextType> getAliasAlternateNameTypeCode() {
        if (aliasAlternateNameTypeCode == null) {
            aliasAlternateNameTypeCode = new ArrayList<TextType>();
        }
        return this.aliasAlternateNameTypeCode;
    }

    /**
     * Gets the value of the entityReference property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the entityReference property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getEntityReference().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getEntityReference() {
        if (entityReference == null) {
            entityReference = new ArrayList<ReferenceType>();
        }
        return this.entityReference;
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
