
package ecfv5.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IDType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ImportanceCodeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ListValueType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameCodeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TestMethodType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueQualifierType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueQuantityType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ABIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Details&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A class to describe a specific property of an item.&lt;/ccts:Definition&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;/ccts:Component&gt;
 * </pre>
 * 
 * 
 * <p>Java class for ItemPropertyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ItemPropertyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ID" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Name"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}NameCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}TestMethod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}Value" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValueQuantity" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ValueQualifier" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ImportanceCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2}ListValue" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}UsabilityPeriod" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ItemPropertyGroup" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}RangeDimension" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2}ItemPropertyRange" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ItemPropertyType", propOrder = {
    "id",
    "name",
    "nameCode",
    "testMethod",
    "value",
    "valueQuantity",
    "valueQualifier",
    "importanceCode",
    "listValue",
    "usabilityPeriod",
    "itemPropertyGroup",
    "rangeDimension",
    "itemPropertyRange"
})
public class ItemPropertyType {

    @XmlElement(name = "ID", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected IDType id;
    @XmlElement(name = "Name", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2", required = true)
    protected NameType name;
    @XmlElement(name = "NameCode", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected NameCodeType nameCode;
    @XmlElement(name = "TestMethod", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected TestMethodType testMethod;
    @XmlElement(name = "Value", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValueType value;
    @XmlElement(name = "ValueQuantity", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ValueQuantityType valueQuantity;
    @XmlElement(name = "ValueQualifier", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ValueQualifierType> valueQualifier;
    @XmlElement(name = "ImportanceCode", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected ImportanceCodeType importanceCode;
    @XmlElement(name = "ListValue", namespace = "urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    protected List<ListValueType> listValue;
    @XmlElement(name = "UsabilityPeriod")
    protected PeriodType usabilityPeriod;
    @XmlElement(name = "ItemPropertyGroup")
    protected List<ItemPropertyGroupType> itemPropertyGroup;
    @XmlElement(name = "RangeDimension")
    protected DimensionType rangeDimension;
    @XmlElement(name = "ItemPropertyRange")
    protected ItemPropertyRangeType itemPropertyRange;

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Identifier&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;An identifier for this property of an item.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Identifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Identifier&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Identifier. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link IDType }
     *     
     */
    public IDType getID() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link IDType }
     *     
     */
    public void setID(IDType value) {
        this.id = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Name&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The name of this item property.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Name&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Name&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Name. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;Energy Rating , Collar Size , Fat Content &lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link NameType }
     *     
     */
    public NameType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameType }
     *     
     */
    public void setName(NameType value) {
        this.name = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Name Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The name of this item property, expressed as a code.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Name Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link NameCodeType }
     *     
     */
    public NameCodeType getNameCode() {
        return nameCode;
    }

    /**
     * Sets the value of the nameCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NameCodeType }
     *     
     */
    public void setNameCode(NameCodeType value) {
        this.nameCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Test Method. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The method of testing the value of this item property.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Test Method&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;100 watts , 15 European , 20% +/- 5% &lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link TestMethodType }
     *     
     */
    public TestMethodType getTestMethod() {
        return testMethod;
    }

    /**
     * Sets the value of the testMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link TestMethodType }
     *     
     */
    public void setTestMethod(TestMethodType value) {
        this.testMethod = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Value. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The value of this item property, expressed as text.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Value&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;ccts:Examples&gt;100 watts , 15 European , 20% +/- 5% &lt;/ccts:Examples&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ValueType }
     *     
     */
    public ValueType getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueType }
     *     
     */
    public void setValue(ValueType value) {
        this.value = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Value_ Quantity. Quantity&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The value of this item property, expressed as a quantity.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Value&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Quantity&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Quantity&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Quantity. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ValueQuantityType }
     *     
     */
    public ValueQuantityType getValueQuantity() {
        return valueQuantity;
    }

    /**
     * Sets the value of the valueQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValueQuantityType }
     *     
     */
    public void setValueQuantity(ValueQuantityType value) {
        this.valueQuantity = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Value Qualifier. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;Text qualifying the value of the property.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Value Qualifier&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the valueQualifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the valueQualifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValueQualifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValueQualifierType }
     * 
     * 
     */
    public List<ValueQualifierType> getValueQualifier() {
        if (valueQualifier == null) {
            valueQualifier = new ArrayList<ValueQualifierType>();
        }
        return this.valueQualifier;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Importance Code. Code&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A code signifying the importance of this property in using it to describe a related Item.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Importance Code&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Code&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Code. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ImportanceCodeType }
     *     
     */
    public ImportanceCodeType getImportanceCode() {
        return importanceCode;
    }

    /**
     * Sets the value of the importanceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImportanceCodeType }
     *     
     */
    public void setImportanceCode(ImportanceCodeType value) {
        this.importanceCode = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;BBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. List Value. Text&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The value expressed as a text in case the property is a value in a list. For example, a colour.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;List Value&lt;/ccts:PropertyTerm&gt;&lt;ccts:RepresentationTerm&gt;Text&lt;/ccts:RepresentationTerm&gt;&lt;ccts:DataType&gt;Text. Type&lt;/ccts:DataType&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the listValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListValueType }
     * 
     * 
     */
    public List<ListValueType> getListValue() {
        if (listValue == null) {
            listValue = new ArrayList<ListValueType>();
        }
        return this.listValue;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Usability_ Period. Period&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The period during which this item property is valid.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Usability&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Period&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Period&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Period&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link PeriodType }
     *     
     */
    public PeriodType getUsabilityPeriod() {
        return usabilityPeriod;
    }

    /**
     * Sets the value of the usabilityPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link PeriodType }
     *     
     */
    public void setUsabilityPeriod(PeriodType value) {
        this.usabilityPeriod = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Item Property Group&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A description of the property group to which this item property belongs.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..n&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Item Property Group&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Item Property Group&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Item Property Group&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * Gets the value of the itemPropertyGroup property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemPropertyGroup property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemPropertyGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemPropertyGroupType }
     * 
     * 
     */
    public List<ItemPropertyGroupType> getItemPropertyGroup() {
        if (itemPropertyGroup == null) {
            itemPropertyGroup = new ArrayList<ItemPropertyGroupType>();
        }
        return this.itemPropertyGroup;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Range_ Dimension. Dimension&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;The range of values for the dimensions of this property.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTermQualifier&gt;Range&lt;/ccts:PropertyTermQualifier&gt;&lt;ccts:PropertyTerm&gt;Dimension&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Dimension&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Dimension&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link DimensionType }
     *     
     */
    public DimensionType getRangeDimension() {
        return rangeDimension;
    }

    /**
     * Sets the value of the rangeDimension property.
     * 
     * @param value
     *     allowed object is
     *     {@link DimensionType }
     *     
     */
    public void setRangeDimension(DimensionType value) {
        this.rangeDimension = value;
    }

    /**
     * 
     * <pre>
     * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Component xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cac="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2" xmlns:cbc="urn:ecfv5.oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;&lt;ccts:ComponentType&gt;ASBIE&lt;/ccts:ComponentType&gt;&lt;ccts:DictionaryEntryName&gt;Item Property. Item Property Range&lt;/ccts:DictionaryEntryName&gt;&lt;ccts:Definition&gt;A range of values for this item property.&lt;/ccts:Definition&gt;&lt;ccts:Cardinality&gt;0..1&lt;/ccts:Cardinality&gt;&lt;ccts:ObjectClass&gt;Item Property&lt;/ccts:ObjectClass&gt;&lt;ccts:PropertyTerm&gt;Item Property Range&lt;/ccts:PropertyTerm&gt;&lt;ccts:AssociatedObjectClass&gt;Item Property Range&lt;/ccts:AssociatedObjectClass&gt;&lt;ccts:RepresentationTerm&gt;Item Property Range&lt;/ccts:RepresentationTerm&gt;&lt;/ccts:Component&gt;
     * </pre>
     * 
     * 
     * @return
     *     possible object is
     *     {@link ItemPropertyRangeType }
     *     
     */
    public ItemPropertyRangeType getItemPropertyRange() {
        return itemPropertyRange;
    }

    /**
     * Sets the value of the itemPropertyRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemPropertyRangeType }
     *     
     */
    public void setItemPropertyRange(ItemPropertyRangeType value) {
        this.itemPropertyRange = value;
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
