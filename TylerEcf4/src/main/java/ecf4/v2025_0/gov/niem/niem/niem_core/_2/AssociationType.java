
package ecf4.v2025_0.gov.niem.niem.niem_core._2;

import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.ActivityLocationAssociationType;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.DocumentCourtAssociationType;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.PersonChargeAssociationType;
import ecf4.v2025_0.gov.niem.niem.domains.jxdm._4.ViolatedStatuteAssociationType;
import ecf4.v2025_0.gov.niem.niem.structures._2.ComplexObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import ecf4.v2025_0.oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.PlacementAssociationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;

import ecf4.v2025_0.tyler.ecf.extensions.common.FilingAssociationType;


/**
 * <p>Java class for AssociationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AssociationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssociationType")
@XmlSeeAlso({
    ImmediateFamilyAssociationType.class,
    ActivityConveyanceAssociationType.class,
    OrganizationContactInformationAssociationType.class,
    PersonContactInformationAssociationType.class,
    PersonEmploymentAssociationType.class,
    DriverLicenseAssociationType.class,
    ActivityLocationAssociationType.class,
    DocumentCourtAssociationType.class,
    PersonChargeAssociationType.class,
    ViolatedStatuteAssociationType.class,
    OrganizationAssociationType.class,
    PersonOrganizationAssociationType.class,
    RelatedActivityAssociationType.class,
    PersonAssociationType.class,
    GuardianAssociationType.class,
    PlacementAssociationType.class,
    FilingAssociationType.class
})
public class AssociationType
    extends ComplexObjectType
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
