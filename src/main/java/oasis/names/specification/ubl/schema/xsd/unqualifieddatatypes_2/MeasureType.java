
package oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AltitudeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BaseUnitMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeableWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ComparedValueMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ConditionValueMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DurationMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GrossWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatitudeDegreesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatitudeMinutesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LeadTimeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LoadingLengthMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeDegreesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LongitudeMinutesMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetNetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetVolumeMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NetWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceValueMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TareWeightMeasureType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValueMeasureType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * &lt;p&gt;Java class for MeasureType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="MeasureType"&amp;gt;
 *   &amp;lt;simpleContent&amp;gt;
 *     &amp;lt;extension base="&amp;lt;urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2&amp;gt;MeasureType"&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/simpleContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
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
    ConditionValueMeasureType.class,
    DurationMeasureType.class,
    GrossVolumeMeasureType.class,
    GrossWeightMeasureType.class,
    LatitudeDegreesMeasureType.class,
    LatitudeMinutesMeasureType.class,
    LeadTimeMeasureType.class,
    LoadingLengthMeasureType.class,
    LongitudeDegreesMeasureType.class,
    LongitudeMinutesMeasureType.class,
    MaximumMeasureType.class,
    oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MeasureType.class,
    MinimumMeasureType.class,
    NetNetWeightMeasureType.class,
    NetVolumeMeasureType.class,
    NetWeightMeasureType.class,
    SourceValueMeasureType.class,
    TareWeightMeasureType.class,
    ValueMeasureType.class
})
public class MeasureType
    extends un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.MeasureType
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
