
package ecfv5.oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDeliveryTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDespatchTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualPickupTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AwardTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CallTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ComparisonForecastIssueTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EarliestPickupTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EffectiveTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDeliveryTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDespatchTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpiryTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GuaranteedDespatchTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LastRevisionTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestDeliveryTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestPickupTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ManufactureTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NominationTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OccurrenceTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaidTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegisteredTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedDespatchTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredDeliveryTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResolutionTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResponseTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RevisionTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceForecastIssueTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartTimeType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidationTimeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT0000010&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Time. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;An instance of time that occurs every day.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Time&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 * 
 * <p>Java class for TimeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TimeType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;time"&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TimeType", propOrder = {
    "value"
})
@XmlSeeAlso({
    ActualDeliveryTimeType.class,
    ActualDespatchTimeType.class,
    ActualPickupTimeType.class,
    AwardTimeType.class,
    CallTimeType.class,
    ComparisonForecastIssueTimeType.class,
    EarliestPickupTimeType.class,
    EffectiveTimeType.class,
    EndTimeType.class,
    EstimatedDeliveryTimeType.class,
    EstimatedDespatchTimeType.class,
    ExpiryTimeType.class,
    GuaranteedDespatchTimeType.class,
    IssueTimeType.class,
    LastRevisionTimeType.class,
    LatestDeliveryTimeType.class,
    LatestPickupTimeType.class,
    ManufactureTimeType.class,
    NominationTimeType.class,
    OccurrenceTimeType.class,
    PaidTimeType.class,
    ReferenceTimeType.class,
    RegisteredTimeType.class,
    RequestedDespatchTimeType.class,
    RequiredDeliveryTimeType.class,
    ResolutionTimeType.class,
    ResponseTimeType.class,
    RevisionTimeType.class,
    SourceForecastIssueTimeType.class,
    StartTimeType.class,
    ValidationTimeType.class
})
public class TimeType {

    @XmlValue
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar value;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValue(XMLGregorianCalendar value) {
        this.value = value;
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
