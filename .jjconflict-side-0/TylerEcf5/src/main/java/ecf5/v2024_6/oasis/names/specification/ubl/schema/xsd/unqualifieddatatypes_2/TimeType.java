
package ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDeliveryTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDespatchTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualPickupTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AwardTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CallTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ComparisonForecastIssueTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EarliestPickupTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EffectiveTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDeliveryTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDespatchTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpiryTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GuaranteedDespatchTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LastRevisionTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestDeliveryTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestPickupTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestReplyTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ManufactureTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NominationTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OccurrenceTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaidTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegisteredTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedDespatchTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredDeliveryTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResolutionTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResponseTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RevisionTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceForecastIssueTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidationTimeType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeighingTimeType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT0000010&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Time. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;An instance of time that occurs every day.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Time&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
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
    LatestReplyTimeType.class,
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
    ValidationTimeType.class,
    WeighingTimeType.class
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
