
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetworkIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ParticipantIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TestIndicatorType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Delivery Channel. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe a delivery channel.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Delivery Channel&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for DeliveryChannelType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DeliveryChannelType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetworkID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ParticipantID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TestIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DigitalCertificate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}DigitalMessageDelivery" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeliveryChannelType", propOrder = {
    "networkID",
    "participantID",
    "testIndicator",
    "digitalCertificate",
    "digitalMessageDelivery"
})
public class DeliveryChannelType {

    @XmlElement(name = "NetworkID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NetworkIDType networkID;
    @XmlElement(name = "ParticipantID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ParticipantIDType participantID;
    @XmlElement(name = "TestIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TestIndicatorType testIndicator;
    @XmlElement(name = "DigitalCertificate")
    protected CertificateType digitalCertificate;
    @XmlElement(name = "DigitalMessageDelivery")
    protected MessageDeliveryType digitalMessageDelivery;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Delivery Channel. Network Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the network where messages are delivered (e.g. a business network).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Delivery Channel&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Network Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;OpenPEPPOL&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link NetworkIDType }
     *     
     */
    public NetworkIDType getNetworkID() {
        return networkID;
    }

    /**
     * Sets the value of the networkID property.
     * 
     * @param value
     *     allowed object is
     *     {@link NetworkIDType }
     *     
     */
    public void setNetworkID(NetworkIDType value) {
        this.networkID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Delivery Channel. Participant Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for a registered participant in the network (e.g. according a precise scheme such as IT:VAT, DK:CVR, GLN).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Delivery Channel&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Participant Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;5790002221134&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ParticipantIDType }
     *     
     */
    public ParticipantIDType getParticipantID() {
        return participantID;
    }

    /**
     * Sets the value of the participantID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantIDType }
     *     
     */
    public void setParticipantID(ParticipantIDType value) {
        this.participantID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Delivery Channel. Test_ Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator that the channel is a test channel (true).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Delivery Channel&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Test&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link TestIndicatorType }
     *     
     */
    public TestIndicatorType getTestIndicator() {
        return testIndicator;
    }

    /**
     * Sets the value of the testIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestIndicatorType }
     *     
     */
    public void setTestIndicator(TestIndicatorType value) {
        this.testIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Delivery Channel. Digital_ Certificate. Certificate&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A digital certificate associated with this delivery channel.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Delivery Channel&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Digital&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Certificate&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Certificate&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Certificate&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CertificateType }
     *     
     */
    public CertificateType getDigitalCertificate() {
        return digitalCertificate;
    }

    /**
     * Sets the value of the digitalCertificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link CertificateType }
     *     
     */
    public void setDigitalCertificate(CertificateType value) {
        this.digitalCertificate = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Delivery Channel. Digital_ Message Delivery. Message Delivery&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A digital message delivery associated with this delivery channel (aka routing information).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Delivery Channel&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Digital&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Message Delivery&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Message Delivery&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Message Delivery&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MessageDeliveryType }
     *     
     */
    public MessageDeliveryType getDigitalMessageDelivery() {
        return digitalMessageDelivery;
    }

    /**
     * Sets the value of the digitalMessageDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageDeliveryType }
     *     
     */
    public void setDigitalMessageDelivery(MessageDeliveryType value) {
        this.digitalMessageDelivery = value;
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
