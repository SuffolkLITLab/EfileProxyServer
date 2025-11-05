
package ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BudgetYearNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CalculationSequenceNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpectedValueNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FrozenPeriodDaysNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineCountNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LineNumberNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumCopiesNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumLotsAwardedNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumLotsSubmittedNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumNumberNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumOriginalsNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumPaymentInstructionsNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MaximumValueNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumNumberNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MinimumValueNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MultiplierFactorNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OrderIntervalDaysNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OrderQuantityIncrementNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PackSizeNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReminderSequenceNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResidentOccupantsNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResponseNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SequenceNumericType;
import ecf5.v2024_6.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.WeightNumericType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT0000014&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Numeric. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Numeric information that is assigned or is determined by calculation, counting, or sequencing. It does not require a unit of quantity or unit of measure.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Numeric&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 * 
 * <p>Java class for NumericType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NumericType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;urn:un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2&gt;NumericType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumericType")
@XmlSeeAlso({
    BudgetYearNumericType.class,
    CalculationSequenceNumericType.class,
    ExpectedValueNumericType.class,
    FrozenPeriodDaysNumericType.class,
    LineCountNumericType.class,
    LineNumberNumericType.class,
    MaximumCopiesNumericType.class,
    MaximumLotsAwardedNumericType.class,
    MaximumLotsSubmittedNumericType.class,
    MaximumNumberNumericType.class,
    MaximumOriginalsNumericType.class,
    MaximumPaymentInstructionsNumericType.class,
    MaximumValueNumericType.class,
    MinimumNumberNumericType.class,
    MinimumValueNumericType.class,
    MultiplierFactorNumericType.class,
    OrderIntervalDaysNumericType.class,
    OrderQuantityIncrementNumericType.class,
    PackSizeNumericType.class,
    ReminderSequenceNumericType.class,
    ResidentOccupantsNumericType.class,
    ResponseNumericType.class,
    SequenceNumericType.class,
    WeightNumericType.class
})
public class NumericType
    extends ecf5.v2024_6.un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.NumericType
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
