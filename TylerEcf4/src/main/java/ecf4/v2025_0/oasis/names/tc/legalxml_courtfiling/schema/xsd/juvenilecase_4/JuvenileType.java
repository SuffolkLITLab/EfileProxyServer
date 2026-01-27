
package ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.RegisteredOffenderType;
import ecf4.v2025_0.gov.niem.niem.niem_core._2.PersonOrganizationAssociationType;
import ecf4.v2025_0.gov.niem.niem.proxy.xsd._2.Boolean;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.SubjectType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A minor who is the subject of a delinquency or dependency case.
 * 
 * <p>Java class for JuvenileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="JuvenileType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SubjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}PersonGangAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}RegisteredSexOffender" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}GuardianAssociation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}PersonEmancipatedIndicator"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:JuvenileCase-4.0}PlacementAssociation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JuvenileType", propOrder = {
    "personGangAssociation",
    "registeredSexOffender",
    "guardianAssociation",
    "personEmancipatedIndicator",
    "placementAssociation"
})
public class JuvenileType
    extends SubjectType
{

    @XmlElement(name = "PersonGangAssociation", namespace = "http://niem.gov/niem/niem-core/2.0", nillable = true)
    protected List<PersonOrganizationAssociationType> personGangAssociation;
    @XmlElement(name = "RegisteredSexOffender", namespace = "http://niem.gov/niem/domains/jxdm/4.0", nillable = true)
    protected RegisteredOffenderType registeredSexOffender;
    @XmlElement(name = "GuardianAssociation")
    protected List<GuardianAssociationType> guardianAssociation;
    @XmlElement(name = "PersonEmancipatedIndicator", required = true)
    protected Boolean personEmancipatedIndicator;
    @XmlElement(name = "PlacementAssociation")
    protected PlacementAssociationType placementAssociation;

    /**
     * Gets the value of the personGangAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the personGangAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonGangAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonOrganizationAssociationType }
     * 
     * 
     */
    public List<PersonOrganizationAssociationType> getPersonGangAssociation() {
        if (personGangAssociation == null) {
            personGangAssociation = new ArrayList<PersonOrganizationAssociationType>();
        }
        return this.personGangAssociation;
    }

    /**
     * Gets the value of the registeredSexOffender property.
     * 
     * @return
     *     possible object is
     *     {@link RegisteredOffenderType }
     *     
     */
    public RegisteredOffenderType getRegisteredSexOffender() {
        return registeredSexOffender;
    }

    /**
     * Sets the value of the registeredSexOffender property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegisteredOffenderType }
     *     
     */
    public void setRegisteredSexOffender(RegisteredOffenderType value) {
        this.registeredSexOffender = value;
    }

    /**
     * Gets the value of the guardianAssociation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the guardianAssociation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGuardianAssociation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GuardianAssociationType }
     * 
     * 
     */
    public List<GuardianAssociationType> getGuardianAssociation() {
        if (guardianAssociation == null) {
            guardianAssociation = new ArrayList<GuardianAssociationType>();
        }
        return this.guardianAssociation;
    }

    /**
     * Gets the value of the personEmancipatedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getPersonEmancipatedIndicator() {
        return personEmancipatedIndicator;
    }

    /**
     * Sets the value of the personEmancipatedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPersonEmancipatedIndicator(Boolean value) {
        this.personEmancipatedIndicator = value;
    }

    /**
     * Gets the value of the placementAssociation property.
     * 
     * @return
     *     possible object is
     *     {@link PlacementAssociationType }
     *     
     */
    public PlacementAssociationType getPlacementAssociation() {
        return placementAssociation;
    }

    /**
     * Sets the value of the placementAssociation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlacementAssociationType }
     *     
     */
    public void setPlacementAssociation(PlacementAssociationType value) {
        this.placementAssociation = value;
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
