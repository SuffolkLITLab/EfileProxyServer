
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.IdentificationType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.JuvenileType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Additional information about a subject.
 * 
 * &lt;p&gt;Java class for SubjectType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="SubjectType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}SubjectType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}PersonAugmentation" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SubjectICEIdentification" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubjectType", propOrder = {
    "personAugmentation",
    "subjectICEIdentification"
})
@XmlSeeAlso({
    oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.SubjectType.class,
    JuvenileType.class
})
public class SubjectType
    extends gov.niem.niem.domains.jxdm._4.SubjectType
{

    @XmlElement(name = "PersonAugmentation")
    protected PersonAugmentationType personAugmentation;
    @XmlElement(name = "SubjectICEIdentification")
    protected IdentificationType subjectICEIdentification;

    /**
     * Gets the value of the personAugmentation property.
     * 
     * @return
     *     possible object is
     *     {@link PersonAugmentationType }
     *     
     */
    public PersonAugmentationType getPersonAugmentation() {
        return personAugmentation;
    }

    /**
     * Sets the value of the personAugmentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonAugmentationType }
     *     
     */
    public void setPersonAugmentation(PersonAugmentationType value) {
        this.personAugmentation = value;
    }

    /**
     * Gets the value of the subjectICEIdentification property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getSubjectICEIdentification() {
        return subjectICEIdentification;
    }

    /**
     * Sets the value of the subjectICEIdentification property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setSubjectICEIdentification(IdentificationType value) {
        this.subjectICEIdentification = value;
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
