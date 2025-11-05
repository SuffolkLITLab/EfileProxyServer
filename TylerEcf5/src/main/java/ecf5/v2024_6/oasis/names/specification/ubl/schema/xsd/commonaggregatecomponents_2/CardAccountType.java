
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CV2IDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CardChipCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CardTypeCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChipApplicationIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpiryDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HolderNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueNumberIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssuerIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetworkIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PrimaryAccountNumberIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidityStartDateType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to define a credit card, debit card, or charge card account.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for CardAccountType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardAccountType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}PrimaryAccountNumberID"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NetworkID"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CardTypeCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValidityStartDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ExpiryDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}IssuerID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}IssueNumberID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CV2ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CardChipCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ChipApplicationID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}HolderName" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAccountType", propOrder = {
    "primaryAccountNumberID",
    "networkID",
    "cardTypeCode",
    "validityStartDate",
    "expiryDate",
    "issuerID",
    "issueNumberID",
    "cv2ID",
    "cardChipCode",
    "chipApplicationID",
    "holderName"
})
public class CardAccountType {

    @XmlElement(name = "PrimaryAccountNumberID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected PrimaryAccountNumberIDType primaryAccountNumberID;
    @XmlElement(name = "NetworkID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected NetworkIDType networkID;
    @XmlElement(name = "CardTypeCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CardTypeCodeType cardTypeCode;
    @XmlElement(name = "ValidityStartDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValidityStartDateType validityStartDate;
    @XmlElement(name = "ExpiryDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ExpiryDateType expiryDate;
    @XmlElement(name = "IssuerID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IssuerIDType issuerID;
    @XmlElement(name = "IssueNumberID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IssueNumberIDType issueNumberID;
    @XmlElement(name = "CV2ID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CV2IDType cv2ID;
    @XmlElement(name = "CardChipCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CardChipCodeType cardChipCode;
    @XmlElement(name = "ChipApplicationID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ChipApplicationIDType chipApplicationID;
    @XmlElement(name = "HolderName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected HolderNameType holderName;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Primary_ Account Number. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier of the card (e.g., the Primary Account Number (PAN)).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Primary&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Account Number&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;4558 XXXX XXXX XXXX (a real card number)&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PrimaryAccountNumberIDType }
     *     
     */
    public PrimaryAccountNumberIDType getPrimaryAccountNumberID() {
        return primaryAccountNumberID;
    }

    /**
     * Sets the value of the primaryAccountNumberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryAccountNumberIDType }
     *     
     */
    public void setPrimaryAccountNumberID(PrimaryAccountNumberIDType value) {
        this.primaryAccountNumberID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Network. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the financial service network provider of the card.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Network&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;VISA, MasterCard, American Express&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
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
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Card Type Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A mutually agreed code signifying the type of card. Examples of types are "debit", "credit" and "purchasing"&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Card Type Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Debit Card, Credit Card, Procurement Card&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CardTypeCodeType }
     *     
     */
    public CardTypeCodeType getCardTypeCode() {
        return cardTypeCode;
    }

    /**
     * Sets the value of the cardTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardTypeCodeType }
     *     
     */
    public void setCardTypeCode(CardTypeCodeType value) {
        this.cardTypeCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Validity Start Date. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The date from which the card is valid.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Validity Start Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ValidityStartDateType }
     *     
     */
    public ValidityStartDateType getValidityStartDate() {
        return validityStartDate;
    }

    /**
     * Sets the value of the validityStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidityStartDateType }
     *     
     */
    public void setValidityStartDate(ValidityStartDateType value) {
        this.validityStartDate = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Expiry Date. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The date on which the card expires.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Expiry Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ExpiryDateType }
     *     
     */
    public ExpiryDateType getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExpiryDateType }
     *     
     */
    public void setExpiryDate(ExpiryDateType value) {
        this.expiryDate = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Issuer. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the institution issuing the card.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Issuer&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link IssuerIDType }
     *     
     */
    public IssuerIDType getIssuerID() {
        return issuerID;
    }

    /**
     * Sets the value of the issuerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IssuerIDType }
     *     
     */
    public void setIssuerID(IssuerIDType value) {
        this.issuerID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Issue Number. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the card, specified by the issuer.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Issue Number&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link IssueNumberIDType }
     *     
     */
    public IssueNumberIDType getIssueNumberID() {
        return issueNumberID;
    }

    /**
     * Sets the value of the issueNumberID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IssueNumberIDType }
     *     
     */
    public void setIssueNumberID(IssueNumberIDType value) {
        this.issueNumberID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. CV2. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for the Card Verification Value (often found on the reverse of the card itself).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;CV2&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CV2IDType }
     *     
     */
    public CV2IDType getCV2ID() {
        return cv2ID;
    }

    /**
     * Sets the value of the cv2ID property.
     * 
     * @param value
     *     allowed object is
     *     {@link CV2IDType }
     *     
     */
    public void setCV2ID(CV2IDType value) {
        this.cv2ID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Card Chip Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A mutually agreed code to distinguish between CHIP and MAG STRIPE cards.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Card Chip Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataTypeQualifier&gt;Chip&lt;/ccts:DataTypeQualifier&gt;&lt;ccts:DataType&gt;Chip_ Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CardChipCodeType }
     *     
     */
    public CardChipCodeType getCardChipCode() {
        return cardChipCode;
    }

    /**
     * Sets the value of the cardChipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardChipCodeType }
     *     
     */
    public void setCardChipCode(CardChipCodeType value) {
        this.cardChipCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Chip_ Application. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier on the chip card for the application that provides the quoted information; an AID (application ID).&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Chip&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Application&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ChipApplicationIDType }
     *     
     */
    public ChipApplicationIDType getChipApplicationID() {
        return chipApplicationID;
    }

    /**
     * Sets the value of the chipApplicationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChipApplicationIDType }
     *     
     */
    public void setChipApplicationID(ChipApplicationIDType value) {
        this.chipApplicationID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Card Account. Holder. Name&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The name of the cardholder.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Card Account&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Holder&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Name&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Name. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link HolderNameType }
     *     
     */
    public HolderNameType getHolderName() {
        return holderName;
    }

    /**
     * Sets the value of the holderName property.
     * 
     * @param value
     *     allowed object is
     *     {@link HolderNameType }
     *     
     */
    public void setHolderName(HolderNameType value) {
        this.holderName = value;
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
