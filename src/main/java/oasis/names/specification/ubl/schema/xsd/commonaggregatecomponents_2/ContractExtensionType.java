
package oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumNumberNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumNumberNumericType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OptionsDescriptionType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RenewalsIndicatorType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Contract Extension. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe possible extensions to a contract.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Contract Extension&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ContractExtensionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContractExtensionType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}OptionsDescription" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MinimumNumberNumeric" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}MaximumNumberNumeric" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}RenewalsIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}OptionValidityPeriod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}Renewal" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContractExtensionType", propOrder = {
    "optionsDescription",
    "minimumNumberNumeric",
    "maximumNumberNumeric",
    "renewalsIndicator",
    "optionValidityPeriod",
    "renewal"
})
public class ContractExtensionType {

    @XmlElement(name = "OptionsDescription", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<OptionsDescriptionType> optionsDescription;
    @XmlElement(name = "MinimumNumberNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MinimumNumberNumericType minimumNumberNumeric;
    @XmlElement(name = "MaximumNumberNumeric", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected MaximumNumberNumericType maximumNumberNumeric;
    @XmlElement(name = "RenewalsIndicator", namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected RenewalsIndicatorType renewalsIndicator;
    @XmlElement(name = "OptionValidityPeriod")
    protected PeriodType optionValidityPeriod;
    @XmlElement(name = "Renewal")
    protected List<RenewalType> renewal;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Contract Extension. Options Description. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A description for the possible options that can be carried out during the execution of the contract.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Contract Extension&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Options Description&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the optionsDescription property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the optionsDescription property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOptionsDescription().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OptionsDescriptionType }
     * 
     * 
     */
    public List<OptionsDescriptionType> getOptionsDescription() {
        if (optionsDescription == null) {
            optionsDescription = new ArrayList<OptionsDescriptionType>();
        }
        return this.optionsDescription;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Contract Extension. Minimum_ Number. Numeric&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The fixed minimum number of contract extensions or renewals.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Contract Extension&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Minimum&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Number&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Numeric&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Numeric. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MinimumNumberNumericType }
     *     
     */
    public MinimumNumberNumericType getMinimumNumberNumeric() {
        return minimumNumberNumeric;
    }

    /**
     * Sets the value of the minimumNumberNumeric property.
     * 
     * @param value
     *     allowed object is
     *     {@link MinimumNumberNumericType }
     *     
     */
    public void setMinimumNumberNumeric(MinimumNumberNumericType value) {
        this.minimumNumberNumeric = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Contract Extension. Maximum_ Number. Numeric&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The maximum allowed number of contract extensions.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Contract Extension&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Maximum&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Number&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Numeric&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Numeric. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link MaximumNumberNumericType }
     *     
     */
    public MaximumNumberNumericType getMaximumNumberNumeric() {
        return maximumNumberNumeric;
    }

    /**
     * Sets the value of the maximumNumberNumeric property.
     * 
     * @param value
     *     allowed object is
     *     {@link MaximumNumberNumericType }
     *     
     */
    public void setMaximumNumberNumeric(MaximumNumberNumericType value) {
        this.maximumNumberNumeric = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Contract Extension. Renewals. Indicator&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Indicates that the contract can be extended using renewals.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Contract Extension&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Renewals&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Indicator&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Indicator. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link RenewalsIndicatorType }
     *     
     */
    public RenewalsIndicatorType getRenewalsIndicator() {
        return renewalsIndicator;
    }

    /**
     * Sets the value of the renewalsIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link RenewalsIndicatorType }
     *     
     */
    public void setRenewalsIndicator(RenewalsIndicatorType value) {
        this.renewalsIndicator = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Contract Extension. Option Validity_ Period. Period&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The period during which the option for extending the contract is available.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Contract Extension&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Option Validity&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Period&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Period&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Period&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getOptionValidityPeriod() {
        return optionValidityPeriod;
    }

    /**
     * Sets the value of the optionValidityPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setOptionValidityPeriod(PeriodType value) {
        this.optionValidityPeriod = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Contract Extension. Renewal&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The period allowed for each contract extension.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Contract Extension&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Renewal&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Renewal&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Renewal&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the renewal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the renewal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRenewal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RenewalType }
     * 
     * 
     */
    public List<RenewalType> getRenewal() {
        if (renewal == null) {
            renewal = new ArrayList<RenewalType>();
        }
        return this.renewal;
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
