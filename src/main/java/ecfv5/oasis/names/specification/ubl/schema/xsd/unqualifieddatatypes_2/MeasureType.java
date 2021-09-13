
package ecfv5.oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AltitudeMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseUnitMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeableWeightMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ComparedValueMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DurationMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossTonnageMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossVolumeMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossWeightMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatitudeDegreesMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatitudeMinutesMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LeadTimeMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LoadingLengthMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeDegreesMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeMinutesMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetNetWeightMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetTonnageMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetVolumeMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetWeightMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PostEventNotificationDurationMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreEventNotificationDurationMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceValueMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TareWeightMeasureType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueMeasureType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT0000013&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Measure. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A numeric value determined by measuring an object using a specified unit of measure.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Measure&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PropertyTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Type&lt;/ccts:PropertyTermName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;decimal&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 * 
 * <p>Java class for MeasureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MeasureType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;restriction base="&lt;urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2&gt;MeasureType"&gt;
 *       &lt;attribute name="unitCode" use="required" type="{http://www.w3.org/2001/XMLSchema}normalizedString" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeasureType")
@XmlSeeAlso({
    AltitudeMeasureType.class,
    BaseUnitMeasureType.class,
    ChargeableWeightMeasureType.class,
    ComparedValueMeasureType.class,
    DurationMeasureType.class,
    GrossTonnageMeasureType.class,
    GrossVolumeMeasureType.class,
    GrossWeightMeasureType.class,
    LatitudeDegreesMeasureType.class,
    LatitudeMinutesMeasureType.class,
    LeadTimeMeasureType.class,
    LoadingLengthMeasureType.class,
    LongitudeDegreesMeasureType.class,
    LongitudeMinutesMeasureType.class,
    MaximumMeasureType.class,
    ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeasureType.class,
    MinimumMeasureType.class,
    NetNetWeightMeasureType.class,
    NetTonnageMeasureType.class,
    NetVolumeMeasureType.class,
    NetWeightMeasureType.class,
    PostEventNotificationDurationMeasureType.class,
    PreEventNotificationDurationMeasureType.class,
    SourceValueMeasureType.class,
    TareWeightMeasureType.class,
    ValueMeasureType.class
})
public class MeasureType
    extends ecfv5.un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.MeasureType
{


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
