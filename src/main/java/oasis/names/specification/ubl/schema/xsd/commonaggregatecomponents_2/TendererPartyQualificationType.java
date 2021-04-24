
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InterestedProcurementLotsIDType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for TendererPartyQualificationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="TendererPartyQualificationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InterestedProcurementLotsID" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}MainQualifyingParty"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}AdditionalQualifyingParty" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TendererPartyQualificationType", propOrder = {
    "interestedProcurementLotsID",
    "mainQualifyingParty",
    "additionalQualifyingParty"
})
public class TendererPartyQualificationType {

    @XmlElement(name = "InterestedProcurementLotsID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<InterestedProcurementLotsIDType> interestedProcurementLotsID;
    @XmlElement(name = "MainQualifyingParty", required = true)
    protected QualifyingPartyType mainQualifyingParty;
    @XmlElement(name = "AdditionalQualifyingParty")
    protected List<QualifyingPartyType> additionalQualifyingParty;

    /**
     * Gets the value of the interestedProcurementLotsID property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the interestedProcurementLotsID property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getInterestedProcurementLotsID().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link InterestedProcurementLotsIDType }
     * 
     * 
     */
    public List<InterestedProcurementLotsIDType> getInterestedProcurementLotsID() {
        if (interestedProcurementLotsID == null) {
            interestedProcurementLotsID = new ArrayList<InterestedProcurementLotsIDType>();
        }
        return this.interestedProcurementLotsID;
    }

    /**
     * Gets the value of the mainQualifyingParty property.
     * 
     * @return
     *     possible object is
     *     {@link QualifyingPartyType }
     *     
     */
    public QualifyingPartyType getMainQualifyingParty() {
        return mainQualifyingParty;
    }

    /**
     * Sets the value of the mainQualifyingParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link QualifyingPartyType }
     *     
     */
    public void setMainQualifyingParty(QualifyingPartyType value) {
        this.mainQualifyingParty = value;
    }

    /**
     * Gets the value of the additionalQualifyingParty property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the additionalQualifyingParty property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getAdditionalQualifyingParty().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link QualifyingPartyType }
     * 
     * 
     */
    public List<QualifyingPartyType> getAdditionalQualifyingParty() {
        if (additionalQualifyingParty == null) {
            additionalQualifyingParty = new ArrayList<QualifyingPartyType>();
        }
        return this.additionalQualifyingParty;
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
