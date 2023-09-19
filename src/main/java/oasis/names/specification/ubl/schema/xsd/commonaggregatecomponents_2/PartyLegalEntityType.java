
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyLegalFormCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CompanyLiquidationStatusCodeType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CorporateStockAmountType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FullyPaidSharesIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationExpirationDateType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SoleProprietorshipIndicatorType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Information directly relating to the legal registration that is applicable to a party.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for PartyLegalEntityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PartyLegalEntityType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationName" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CompanyID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RegistrationExpirationDate" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CompanyLegalFormCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}SoleProprietorshipIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CompanyLiquidationStatusCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}CorporateStockAmount" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}FullyPaidSharesIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RegistrationAddress" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}CorporateRegistrationScheme" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}HeadParty" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ShareholderParty" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PartyLegalEntityType", propOrder = {
    "registrationName",
    "companyID",
    "registrationDate",
    "registrationExpirationDate",
    "companyLegalFormCode",
    "soleProprietorshipIndicator",
    "companyLiquidationStatusCode",
    "corporateStockAmount",
    "fullyPaidSharesIndicator",
    "registrationAddress",
    "corporateRegistrationScheme",
    "headParty",
    "shareholderParty"
})
public class PartyLegalEntityType {

    @XmlElement(name = "RegistrationName", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationNameType registrationName;
    @XmlElement(name = "CompanyID", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CompanyIDType companyID;
    @XmlElement(name = "RegistrationDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationDateType registrationDate;
    @XmlElement(name = "RegistrationExpirationDate", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RegistrationExpirationDateType registrationExpirationDate;
    @XmlElement(name = "CompanyLegalFormCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CompanyLegalFormCodeType companyLegalFormCode;
    @XmlElement(name = "SoleProprietorshipIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected SoleProprietorshipIndicatorType soleProprietorshipIndicator;
    @XmlElement(name = "CompanyLiquidationStatusCode", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CompanyLiquidationStatusCodeType companyLiquidationStatusCode;
    @XmlElement(name = "CorporateStockAmount", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected CorporateStockAmountType corporateStockAmount;
    @XmlElement(name = "FullyPaidSharesIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected FullyPaidSharesIndicatorType fullyPaidSharesIndicator;
    @XmlElement(name = "RegistrationAddress")
    protected AddressType registrationAddress;
    @XmlElement(name = "CorporateRegistrationScheme")
    protected CorporateRegistrationSchemeType corporateRegistrationScheme;
    @XmlElement(name = "HeadParty")
    protected PartyType headParty;
    @XmlElement(name = "ShareholderParty")
    protected List<ShareholderPartyType> shareholderParty;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Registration_ Name. Name&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The name of a party as registered with the legal authority.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Registration&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Name&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Name&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Name. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Microsoft Corporation&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link RegistrationNameType }
     *     
     */
    public RegistrationNameType getRegistrationName() {
        return registrationName;
    }

    /**
     * Sets the value of the registrationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationNameType }
     *     
     */
    public void setRegistrationName(RegistrationNameType value) {
        this.registrationName = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Company Identifier. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Identifies a company as registered with the company registration scheme.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Company Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;ccts:AlternativeBusinessTerms&gt;Business Registration Number, Company Number&lt;/ccts:AlternativeBusinessTerms&gt;&lt;ccts:Examples&gt;3556625&lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CompanyIDType }
     *     
     */
    public CompanyIDType getCompanyID() {
        return companyID;
    }

    /**
     * Sets the value of the companyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyIDType }
     *     
     */
    public void setCompanyID(CompanyIDType value) {
        this.companyID = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Registration_ Date. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The registration date of the CompanyID.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Registration&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link RegistrationDateType }
     *     
     */
    public RegistrationDateType getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the value of the registrationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationDateType }
     *     
     */
    public void setRegistrationDate(RegistrationDateType value) {
        this.registrationDate = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Registration Expiration_ Date. Date&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The expiration date, e.g. for Import/Export licenses.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Registration Expiration&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Date&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Date&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Date. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link RegistrationExpirationDateType }
     *     
     */
    public RegistrationExpirationDateType getRegistrationExpirationDate() {
        return registrationExpirationDate;
    }

    /**
     * Sets the value of the registrationExpirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrationExpirationDateType }
     *     
     */
    public void setRegistrationExpirationDate(RegistrationExpirationDateType value) {
        this.registrationExpirationDate = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Company Legal Form Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The company legal status, expressed as a code.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Company Legal Form Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;ccts:AlternativeBusinessTerms&gt;Legal Status&lt;/ccts:AlternativeBusinessTerms&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CompanyLegalFormCodeType }
     *     
     */
    public CompanyLegalFormCodeType getCompanyLegalFormCode() {
        return companyLegalFormCode;
    }

    /**
     * Sets the value of the companyLegalFormCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyLegalFormCodeType }
     *     
     */
    public void setCompanyLegalFormCode(CompanyLegalFormCodeType value) {
        this.companyLegalFormCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Sole Proprietorship Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator to state if the company is owned and controlled by one person (true) or more (false)&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Sole Proprietorship Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link SoleProprietorshipIndicatorType }
     *     
     */
    public SoleProprietorshipIndicatorType getSoleProprietorshipIndicator() {
        return soleProprietorshipIndicator;
    }

    /**
     * Sets the value of the soleProprietorshipIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoleProprietorshipIndicatorType }
     *     
     */
    public void setSoleProprietorshipIndicator(SoleProprietorshipIndicatorType value) {
        this.soleProprietorshipIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Company Liquidation Status Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The company liquidation status, expressed as a code.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Company Liquidation Status Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CompanyLiquidationStatusCodeType }
     *     
     */
    public CompanyLiquidationStatusCodeType getCompanyLiquidationStatusCode() {
        return companyLiquidationStatusCode;
    }

    /**
     * Sets the value of the companyLiquidationStatusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyLiquidationStatusCodeType }
     *     
     */
    public void setCompanyLiquidationStatusCode(CompanyLiquidationStatusCodeType value) {
        this.companyLiquidationStatusCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Corporate Stock_ Amount. Amount&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The Capital Stock (equities) of a corporate.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Corporate Stock&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Amount&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Amount&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Amount. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CorporateStockAmountType }
     *     
     */
    public CorporateStockAmountType getCorporateStockAmount() {
        return corporateStockAmount;
    }

    /**
     * Sets the value of the corporateStockAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorporateStockAmountType }
     *     
     */
    public void setCorporateStockAmount(CorporateStockAmountType value) {
        this.corporateStockAmount = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Fully Paid Shares Indicator. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An indicator to state that all shares of the corporate stock have been paid by shareholders.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Fully Paid Shares Indicator&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link FullyPaidSharesIndicatorType }
     *     
     */
    public FullyPaidSharesIndicatorType getFullyPaidSharesIndicator() {
        return fullyPaidSharesIndicator;
    }

    /**
     * Sets the value of the fullyPaidSharesIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link FullyPaidSharesIndicatorType }
     *     
     */
    public void setFullyPaidSharesIndicator(FullyPaidSharesIndicatorType value) {
        this.fullyPaidSharesIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Registration_ Address. Address&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Associates with the registered address of the party within a Corporate Registration Scheme.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Registration&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Address&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Address&lt;/ccts:AssociatedObjectClass&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getRegistrationAddress() {
        return registrationAddress;
    }

    /**
     * Sets the value of the registrationAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setRegistrationAddress(AddressType value) {
        this.registrationAddress = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Corporate Registration Scheme&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Associates the party with a Corporate Registration Scheme.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Corporate Registration Scheme&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Corporate Registration Scheme&lt;/ccts:AssociatedObjectClass&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link CorporateRegistrationSchemeType }
     *     
     */
    public CorporateRegistrationSchemeType getCorporateRegistrationScheme() {
        return corporateRegistrationScheme;
    }

    /**
     * Sets the value of the corporateRegistrationScheme property.
     * 
     * @param value
     *     allowed object is
     *     {@link CorporateRegistrationSchemeType }
     *     
     */
    public void setCorporateRegistrationScheme(CorporateRegistrationSchemeType value) {
        this.corporateRegistrationScheme = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Head_ Party. Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An associationt to the Head Party.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Head&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Party&lt;/ccts:AssociatedObjectClass&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PartyType }
     *     
     */
    public PartyType getHeadParty() {
        return headParty;
    }

    /**
     * Sets the value of the headParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyType }
     *     
     */
    public void setHeadParty(PartyType value) {
        this.headParty = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Party Legal Entity. Shareholder Party&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Information about the shareholder.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Party Legal Entity&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Shareholder Party&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Shareholder Party&lt;/ccts:AssociatedObjectClass&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the shareholderParty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the shareholderParty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShareholderParty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShareholderPartyType }
     * 
     * 
     */
    public List<ShareholderPartyType> getShareholderParty() {
        if (shareholderParty == null) {
            shareholderParty = new ArrayList<ShareholderPartyType>();
        }
        return this.shareholderParty;
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
