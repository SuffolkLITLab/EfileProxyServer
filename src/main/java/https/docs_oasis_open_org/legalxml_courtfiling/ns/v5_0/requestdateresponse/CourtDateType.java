
package https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.requestdateresponse;

import gov.niem.release.niem.domains.humanservices._4.ChildSupportEnforcementCaseType;
import gov.niem.release.niem.niem_core._4.CaseType;
import gov.niem.release.niem.structures._4.ObjectType;
import ietf.params.xml.ns.icalendar_2.IcalendarType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * <p>Java class for CourtDateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourtDateType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}ObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}Case" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:ietf:params:xml:ns:icalendar-2.0}icalendar" minOccurs="0"/&gt;
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
@XmlType(name = "CourtDateType", propOrder = {
    "_case",
    "icalendar"
})
public class CourtDateType
    extends ObjectType
{

    @XmlElementRef(name = "Case", namespace = "http://release.niem.gov/niem/niem-core/4.0/", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends CaseType> _case;
    @XmlElement(namespace = "urn:ietf:params:xml:ns:icalendar-2.0")
    protected IcalendarType icalendar;

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ChildSupportEnforcementCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     *     
     */
    public JAXBElement<? extends CaseType> getCase() {
        return _case;
    }

    /**
     * Sets the value of the case property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ChildSupportEnforcementCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     *     
     */
    public void setCase(JAXBElement<? extends CaseType> value) {
        this._case = value;
    }

    /**
     * Gets the value of the icalendar property.
     * 
     * @return
     *     possible object is
     *     {@link IcalendarType }
     *     
     */
    public IcalendarType getIcalendar() {
        return icalendar;
    }

    /**
     * Sets the value of the icalendar property.
     * 
     * @param value
     *     allowed object is
     *     {@link IcalendarType }
     *     
     */
    public void setIcalendar(IcalendarType value) {
        this.icalendar = value;
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
