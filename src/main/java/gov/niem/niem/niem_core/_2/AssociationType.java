
package gov.niem.niem.niem_core._2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.domains.jxdm._4.ActivityLocationAssociationType;
import gov.niem.niem.domains.jxdm._4.DocumentCourtAssociationType;
import gov.niem.niem.domains.jxdm._4.PersonChargeAssociationType;
import gov.niem.niem.domains.jxdm._4.ViolatedStatuteAssociationType;
import gov.niem.niem.structures._2.ComplexObjectType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.PlacementAssociationType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.common.FilingAssociationType;


/**
 * &lt;p&gt;Java class for AssociationType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="AssociationType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AssociationType")
@XmlSeeAlso({
    PlacementAssociationType.class,
    GuardianAssociationType.class,
    ImmediateFamilyAssociationType.class,
    ActivityConveyanceAssociationType.class,
    OrganizationAssociationType.class,
    OrganizationContactInformationAssociationType.class,
    PersonContactInformationAssociationType.class,
    PersonEmploymentAssociationType.class,
    PersonOrganizationAssociationType.class,
    RelatedActivityAssociationType.class,
    DriverLicenseAssociationType.class,
    PersonAssociationType.class,
    ActivityLocationAssociationType.class,
    DocumentCourtAssociationType.class,
    PersonChargeAssociationType.class,
    ViolatedStatuteAssociationType.class,
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