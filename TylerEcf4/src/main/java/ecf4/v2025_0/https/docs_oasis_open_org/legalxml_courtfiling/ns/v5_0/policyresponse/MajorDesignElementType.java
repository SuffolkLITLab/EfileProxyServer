
package ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse;

import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import ecf4.v2025_0.gov.niem.release.niem.structures._4.ObjectType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * An ECF Major Design Element (MDE)
 * 
 * <p>Java class for MajorDesignElementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MajorDesignElementType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}MajorDesignElementLocationID"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}MajorDesignElementTypeCode"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}SupportedOperations"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/policyresponse}SupportedServiceInteractionProfiles"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='urn:us:gov:ic:ntk urn:us:gov:ic:ism'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MajorDesignElementType", propOrder = {
    "majorDesignElementLocationID",
    "majorDesignElementTypeCode",
    "supportedOperations",
    "supportedServiceInteractionProfiles"
})
public class MajorDesignElementType
    extends ObjectType
{

    @XmlElement(name = "MajorDesignElementLocationID", required = true)
    protected IdentificationType majorDesignElementLocationID;
    @XmlElement(name = "MajorDesignElementTypeCode", required = true)
    protected NormalizedString majorDesignElementTypeCode;
    @XmlElement(name = "SupportedOperations", required = true)
    protected SupportedOperationsType supportedOperations;
    @XmlElement(name = "SupportedServiceInteractionProfiles", required = true)
    protected SupportedServiceInteractionProfilesType supportedServiceInteractionProfiles;

    /**
     * Gets the value of the majorDesignElementLocationID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getMajorDesignElementLocationID() {
        return majorDesignElementLocationID;
    }

    /**
     * Sets the value of the majorDesignElementLocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setMajorDesignElementLocationID(IdentificationType value) {
        this.majorDesignElementLocationID = value;
    }

    /**
     * Gets the value of the majorDesignElementTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getMajorDesignElementTypeCode() {
        return majorDesignElementTypeCode;
    }

    /**
     * Sets the value of the majorDesignElementTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setMajorDesignElementTypeCode(NormalizedString value) {
        this.majorDesignElementTypeCode = value;
    }

    /**
     * Gets the value of the supportedOperations property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedOperationsType }
     *     
     */
    public SupportedOperationsType getSupportedOperations() {
        return supportedOperations;
    }

    /**
     * Sets the value of the supportedOperations property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedOperationsType }
     *     
     */
    public void setSupportedOperations(SupportedOperationsType value) {
        this.supportedOperations = value;
    }

    /**
     * Gets the value of the supportedServiceInteractionProfiles property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedServiceInteractionProfilesType }
     *     
     */
    public SupportedServiceInteractionProfilesType getSupportedServiceInteractionProfiles() {
        return supportedServiceInteractionProfiles;
    }

    /**
     * Sets the value of the supportedServiceInteractionProfiles property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedServiceInteractionProfilesType }
     *     
     */
    public void setSupportedServiceInteractionProfiles(SupportedServiceInteractionProfilesType value) {
        this.supportedServiceInteractionProfiles = value;
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
