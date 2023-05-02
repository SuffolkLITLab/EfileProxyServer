
package gov.niem.release.niem.domains.jxdm._6;

import gov.niem.release.niem.niem_core._4.ItemType;
import gov.niem.release.niem.niem_core._4.OffenseLevelCodeType;
import gov.niem.release.niem.proxy.xsd._4.Boolean;
import gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * A data type for additional information about an incident.
 * 
 * <p>Java class for IncidentAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="IncidentAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}IncidentGeneralCategoryAbstract" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}IncidentDamagedItem" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}IncidentOfficialPresentIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}IncidentTrafficAccidentInvolvedIndicator" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}IncidentLevelAbstract" minOccurs="0"/&gt;
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
@XmlType(name = "IncidentAugmentationType", propOrder = {
    "incidentGeneralCategoryAbstract",
    "incidentDamagedItem",
    "incidentOfficialPresentIndicator",
    "incidentTrafficAccidentInvolvedIndicator",
    "incidentLevelAbstract"
})
public class IncidentAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "IncidentGeneralCategoryAbstract")
    protected Object incidentGeneralCategoryAbstract;
    @XmlElement(name = "IncidentDamagedItem")
    protected ItemType incidentDamagedItem;
    @XmlElement(name = "IncidentOfficialPresentIndicator")
    protected Boolean incidentOfficialPresentIndicator;
    @XmlElement(name = "IncidentTrafficAccidentInvolvedIndicator")
    protected Boolean incidentTrafficAccidentInvolvedIndicator;
    @XmlElementRef(name = "IncidentLevelAbstract", namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<?> incidentLevelAbstract;

    /**
     * Gets the value of the incidentGeneralCategoryAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getIncidentGeneralCategoryAbstract() {
        return incidentGeneralCategoryAbstract;
    }

    /**
     * Sets the value of the incidentGeneralCategoryAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setIncidentGeneralCategoryAbstract(Object value) {
        this.incidentGeneralCategoryAbstract = value;
    }

    /**
     * Gets the value of the incidentDamagedItem property.
     * 
     * @return
     *     possible object is
     *     {@link ItemType }
     *     
     */
    public ItemType getIncidentDamagedItem() {
        return incidentDamagedItem;
    }

    /**
     * Sets the value of the incidentDamagedItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemType }
     *     
     */
    public void setIncidentDamagedItem(ItemType value) {
        this.incidentDamagedItem = value;
    }

    /**
     * Gets the value of the incidentOfficialPresentIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIncidentOfficialPresentIndicator() {
        return incidentOfficialPresentIndicator;
    }

    /**
     * Sets the value of the incidentOfficialPresentIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncidentOfficialPresentIndicator(Boolean value) {
        this.incidentOfficialPresentIndicator = value;
    }

    /**
     * Gets the value of the incidentTrafficAccidentInvolvedIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getIncidentTrafficAccidentInvolvedIndicator() {
        return incidentTrafficAccidentInvolvedIndicator;
    }

    /**
     * Sets the value of the incidentTrafficAccidentInvolvedIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIncidentTrafficAccidentInvolvedIndicator(Boolean value) {
        this.incidentTrafficAccidentInvolvedIndicator = value;
    }

    /**
     * Gets the value of the incidentLevelAbstract property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link OffenseLevelCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public JAXBElement<?> getIncidentLevelAbstract() {
        return incidentLevelAbstract;
    }

    /**
     * Sets the value of the incidentLevelAbstract property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link OffenseLevelCodeType }{@code >}
     *     {@link JAXBElement }{@code <}{@link Object }{@code >}
     *     
     */
    public void setIncidentLevelAbstract(JAXBElement<?> value) {
        this.incidentLevelAbstract = value;
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
