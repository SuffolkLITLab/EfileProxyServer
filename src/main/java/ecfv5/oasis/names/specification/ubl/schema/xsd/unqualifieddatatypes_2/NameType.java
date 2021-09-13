
package ecfv5.oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AdditionalStreetNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AliasNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BlockNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BrandNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BuildingNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CategoryNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CityNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CitySubdivisionNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FamilyNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FileNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FirstNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.HolderNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.MiddleNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ModelNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OtherNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RetailEventNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RoamingPartnerNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ServiceNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StreetNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TechnicalNameType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.VesselNameType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecfv5.un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.TextType;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT0000020&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Name. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;A character string that constitutes the distinctive designation of a person, place, thing or concept.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Name&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 * 
 * <p>Java class for NameType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NameType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2&gt;TextType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NameType")
@XmlSeeAlso({
    AdditionalStreetNameType.class,
    AliasNameType.class,
    BlockNameType.class,
    BrandNameType.class,
    BuildingNameType.class,
    CategoryNameType.class,
    CityNameType.class,
    CitySubdivisionNameType.class,
    FamilyNameType.class,
    FileNameType.class,
    FirstNameType.class,
    HolderNameType.class,
    MiddleNameType.class,
    ModelNameType.class,
    ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NameType.class,
    OtherNameType.class,
    RegistrationNameType.class,
    RetailEventNameType.class,
    RoamingPartnerNameType.class,
    ServiceNameType.class,
    StreetNameType.class,
    TechnicalNameType.class,
    VesselNameType.class
})
public class NameType
    extends TextType
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
