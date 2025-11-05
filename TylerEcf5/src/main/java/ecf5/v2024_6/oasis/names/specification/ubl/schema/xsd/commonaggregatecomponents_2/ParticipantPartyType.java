
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InitiatingPartyIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrivatePartyIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PublicPartyIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ServiceProviderPartyIndicatorType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Participant Party. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe a participant party.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Participant Party&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ParticipantPartyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ParticipantPartyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}InitiatingPartyIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrivatePartyIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PublicPartyIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ServiceProviderPartyIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Party"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}LegalContact" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}TechnicalContact" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}SupportContact" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CommercialContact" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParticipantPartyType", propOrder = {
    "initiatingPartyIndicator",
    "privatePartyIndicator",
    "publicPartyIndicator",
    "serviceProviderPartyIndicator",
    "party",
    "legalContact",
    "technicalContact",
    "supportContact",
    "commercialContact"
})
public class ParticipantPartyType {

    @XmlElement(name = "InitiatingPartyIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected InitiatingPartyIndicatorType initiatingPartyIndicator;
    @XmlElement(name = "PrivatePartyIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PrivatePartyIndicatorType privatePartyIndicator;
    @XmlElement(name = "PublicPartyIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected PublicPartyIndicatorType publicPartyIndicator;
    @XmlElement(name = "ServiceProviderPartyIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ServiceProviderPartyIndicatorType serviceProviderPartyIndicator;
    @XmlElement(name = "Party", required = true)
    protected PartyType party;
    @XmlElement(name = "LegalContact")
    protected ContactType legalContact;
    @XmlElement(name = "TechnicalContact")
    protected ContactType technicalContact;
    @XmlElement(name = "SupportContact")
    protected ContactType supportContact;
    @XmlElement(name = "CommercialContact")
    protected ContactType commercialContact;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Participant Party. Initiating Party_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator that this party is playing the role of the initiator within a transaction (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Participant Party&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Initiating Party&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link InitiatingPartyIndicatorType }
     *     
     */
    public InitiatingPartyIndicatorType getInitiatingPartyIndicator() {
        return initiatingPartyIndicator;
    }

    /**
     * Sets the value of the initiatingPartyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitiatingPartyIndicatorType }
     *     
     */
    public void setInitiatingPartyIndicator(InitiatingPartyIndicatorType value) {
        this.initiatingPartyIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Participant Party. Private Party_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator that this party is a private entity (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Participant Party&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Private Party&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PrivatePartyIndicatorType }
     *     
     */
    public PrivatePartyIndicatorType getPrivatePartyIndicator() {
        return privatePartyIndicator;
    }

    /**
     * Sets the value of the privatePartyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrivatePartyIndicatorType }
     *     
     */
    public void setPrivatePartyIndicator(PrivatePartyIndicatorType value) {
        this.privatePartyIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Participant Party. Public Party_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator that this party is a public (governmental) entity (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Participant Party&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Public Party&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PublicPartyIndicatorType }
     *     
     */
    public PublicPartyIndicatorType getPublicPartyIndicator() {
        return publicPartyIndicator;
    }

    /**
     * Sets the value of the publicPartyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicPartyIndicatorType }
     *     
     */
    public void setPublicPartyIndicator(PublicPartyIndicatorType value) {
        this.publicPartyIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Participant Party. Service Provider Party_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator that this party is a service provider (true) or not (false).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Participant Party&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Service Provider Party&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ServiceProviderPartyIndicatorType }
     *     
     */
    public ServiceProviderPartyIndicatorType getServiceProviderPartyIndicator() {
        return serviceProviderPartyIndicator;
    }

    /**
     * Sets the value of the serviceProviderPartyIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceProviderPartyIndicatorType }
     *     
     */
    public void setServiceProviderPartyIndicator(ServiceProviderPartyIndicatorType value) {
        this.serviceProviderPartyIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Participant Party. Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The participant party itself.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Participant Party&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Party&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Party&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
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
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Participant Party. Legal_ Contact. Contact&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A legal contact associated to this participant for sending legal notices.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Participant Party&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Legal&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Contact&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Contact&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Contact&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getLegalContact() {
        return legalContact;
    }

    /**
     * Sets the value of the legalContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setLegalContact(ContactType value) {
        this.legalContact = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Participant Party. Technical_ Contact. Contact&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A technical contact associated to this participant.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Participant Party&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Technical&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Contact&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Contact&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Contact&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getTechnicalContact() {
        return technicalContact;
    }

    /**
     * Sets the value of the technicalContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setTechnicalContact(ContactType value) {
        this.technicalContact = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Participant Party. Support_ Contact. Contact&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A support contact associated to this participant.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Participant Party&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Support&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Contact&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Contact&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Contact&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getSupportContact() {
        return supportContact;
    }

    /**
     * Sets the value of the supportContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setSupportContact(ContactType value) {
        this.supportContact = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Participant Party. Commercial_ Contact. Contact&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A commercial contact associated to this participant.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Participant Party&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Commercial&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Contact&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Contact&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Contact&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ContactType }
     *     
     */
    public ContactType getCommercialContact() {
        return commercialContact;
    }

    /**
     * Sets the value of the commercialContact property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactType }
     *     
     */
    public void setCommercialContact(ContactType value) {
        this.commercialContact = value;
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
