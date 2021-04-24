
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumCopiesNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrintQualifierType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for DocumentDistributionType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="DocumentDistributionType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrintQualifier"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumCopiesNumeric"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Party"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentDistributionType", propOrder = {
    "printQualifier",
    "maximumCopiesNumeric",
    "party"
})
public class DocumentDistributionType {

    @XmlElement(name = "PrintQualifier", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PrintQualifierType printQualifier;
    @XmlElement(name = "MaximumCopiesNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected MaximumCopiesNumericType maximumCopiesNumeric;
    @XmlElement(name = "Party", required = true)
    protected PartyType party;

    /**
     * Gets the value of the printQualifier property.
     * 
     * @return
     *     possible object is
     *     {@link PrintQualifierType }
     *     
     */
    public PrintQualifierType getPrintQualifier() {
        return printQualifier;
    }

    /**
     * Sets the value of the printQualifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrintQualifierType }
     *     
     */
    public void setPrintQualifier(PrintQualifierType value) {
        this.printQualifier = value;
    }

    /**
     * Gets the value of the maximumCopiesNumeric property.
     * 
     * @return
     *     possible object is
     *     {@link MaximumCopiesNumericType }
     *     
     */
    public MaximumCopiesNumericType getMaximumCopiesNumeric() {
        return maximumCopiesNumeric;
    }

    /**
     * Sets the value of the maximumCopiesNumeric property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumCopiesNumericType }
     *     
     */
    public void setMaximumCopiesNumeric(MaximumCopiesNumericType value) {
        this.maximumCopiesNumeric = value;
    }

    /**
     * Gets the value of the party property.
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getParty() {
        return party;
    }

    /**
     * Sets the value of the party property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setParty(PartyType value) {
        this.party = value;
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
