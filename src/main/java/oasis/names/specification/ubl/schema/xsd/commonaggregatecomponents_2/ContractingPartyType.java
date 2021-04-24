
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActivityCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuyerProfileURIType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ContractingPartyTypeCodeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for ContractingPartyType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="ContractingPartyType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ContractingPartyTypeCode" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ActivityCode" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}BuyerProfileURI" minOccurs="0"/&amp;gt;
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
@XmlType(name = "ContractingPartyType", propOrder = {
    "contractingPartyTypeCode",
    "activityCode",
    "buyerProfileURI",
    "party"
})
public class ContractingPartyType {

    @XmlElement(name = "ContractingPartyTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ContractingPartyTypeCodeType contractingPartyTypeCode;
    @XmlElement(name = "ActivityCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ActivityCodeType> activityCode;
    @XmlElement(name = "BuyerProfileURI", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected BuyerProfileURIType buyerProfileURI;
    @XmlElement(name = "Party", required = true)
    protected PartyType party;

    /**
     * Gets the value of the contractingPartyTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link ContractingPartyTypeCodeType }
     *     
     */
    public ContractingPartyTypeCodeType getContractingPartyTypeCode() {
        return contractingPartyTypeCode;
    }

    /**
     * Sets the value of the contractingPartyTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContractingPartyTypeCodeType }
     *     
     */
    public void setContractingPartyTypeCode(ContractingPartyTypeCodeType value) {
        this.contractingPartyTypeCode = value;
    }

    /**
     * Gets the value of the activityCode property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the activityCode property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getActivityCode().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link ActivityCodeType }
     * 
     * 
     */
    public List<ActivityCodeType> getActivityCode() {
        if (activityCode == null) {
            activityCode = new ArrayList<ActivityCodeType>();
        }
        return this.activityCode;
    }

    /**
     * Gets the value of the buyerProfileURI property.
     * 
     * @return
     *     possible object is
     *     {@link BuyerProfileURIType }
     *     
     */
    public BuyerProfileURIType getBuyerProfileURI() {
        return buyerProfileURI;
    }

    /**
     * Sets the value of the buyerProfileURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link BuyerProfileURIType }
     *     
     */
    public void setBuyerProfileURI(BuyerProfileURIType value) {
        this.buyerProfileURI = value;
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
