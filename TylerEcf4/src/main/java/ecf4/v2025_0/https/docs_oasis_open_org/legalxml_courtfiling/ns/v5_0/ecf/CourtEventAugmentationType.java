
package ecf4.v2025_0.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import java.util.ArrayList;
import java.util.List;
import ecf4.v2025_0.gov.niem.release.niem.domains.jxdm._6.CourtEventType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.DateType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.DocumentType;
import ecf4.v2025_0.gov.niem.release.niem.niem_core._4.TextType;
import ecf4.v2025_0.gov.niem.release.niem.structures._4.AugmentationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * An augmentation type
 * 
 * <p>Java class for CourtEventAugmentationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourtEventAugmentationType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/structures/4.0/}AugmentationType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ChildDocket" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ConnectedDocument" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CourtEventActor" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CourtEventEnteredOnDocketDate"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CourtEventLocationText" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CourtEventOnBehalfOfActor" minOccurs="0"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CourtEventTypeCode"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}CourtLocationCode" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}CaseDocketID" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "CourtEventAugmentationType", propOrder = {
    "childDocket",
    "connectedDocument",
    "courtEventActor",
    "courtEventEnteredOnDocketDate",
    "courtEventLocationText",
    "courtEventOnBehalfOfActor",
    "courtEventTypeCode",
    "courtLocationCode",
    "caseDocketID"
})
public class CourtEventAugmentationType
    extends AugmentationType
{

    @XmlElement(name = "ChildDocket")
    protected List<CourtEventType> childDocket;
    @XmlElement(name = "ConnectedDocument", nillable = true)
    protected DocumentType connectedDocument;
    @XmlElement(name = "CourtEventActor")
    protected CourtEventOnBehalfOfActorType courtEventActor;
    @XmlElement(name = "CourtEventEnteredOnDocketDate", required = true)
    protected DateType courtEventEnteredOnDocketDate;
    @XmlElement(name = "CourtEventLocationText")
    protected TextType courtEventLocationText;
    @XmlElement(name = "CourtEventOnBehalfOfActor")
    protected CourtEventActorType courtEventOnBehalfOfActor;
    @XmlElement(name = "CourtEventTypeCode", required = true)
    protected TextType courtEventTypeCode;
    @XmlElementRef(name = "CourtLocationCode", namespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf", type = JAXBElement.class, required = false)
    protected JAXBElement<TextType> courtLocationCode;
    @XmlElement(name = "CaseDocketID", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected List<ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String> caseDocketID;

    /**
     * Gets the value of the childDocket property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the childDocket property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildDocket().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourtEventType }
     * 
     * 
     */
    public List<CourtEventType> getChildDocket() {
        if (childDocket == null) {
            childDocket = new ArrayList<CourtEventType>();
        }
        return this.childDocket;
    }

    /**
     * Gets the value of the connectedDocument property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentType }
     *     
     */
    public DocumentType getConnectedDocument() {
        return connectedDocument;
    }

    /**
     * Sets the value of the connectedDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType }
     *     
     */
    public void setConnectedDocument(DocumentType value) {
        this.connectedDocument = value;
    }

    /**
     * Gets the value of the courtEventActor property.
     * 
     * @return
     *     possible object is
     *     {@link CourtEventOnBehalfOfActorType }
     *     
     */
    public CourtEventOnBehalfOfActorType getCourtEventActor() {
        return courtEventActor;
    }

    /**
     * Sets the value of the courtEventActor property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtEventOnBehalfOfActorType }
     *     
     */
    public void setCourtEventActor(CourtEventOnBehalfOfActorType value) {
        this.courtEventActor = value;
    }

    /**
     * Gets the value of the courtEventEnteredOnDocketDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getCourtEventEnteredOnDocketDate() {
        return courtEventEnteredOnDocketDate;
    }

    /**
     * Sets the value of the courtEventEnteredOnDocketDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setCourtEventEnteredOnDocketDate(DateType value) {
        this.courtEventEnteredOnDocketDate = value;
    }

    /**
     * Gets the value of the courtEventLocationText property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtEventLocationText() {
        return courtEventLocationText;
    }

    /**
     * Sets the value of the courtEventLocationText property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtEventLocationText(TextType value) {
        this.courtEventLocationText = value;
    }

    /**
     * Gets the value of the courtEventOnBehalfOfActor property.
     * 
     * @return
     *     possible object is
     *     {@link CourtEventActorType }
     *     
     */
    public CourtEventActorType getCourtEventOnBehalfOfActor() {
        return courtEventOnBehalfOfActor;
    }

    /**
     * Sets the value of the courtEventOnBehalfOfActor property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtEventActorType }
     *     
     */
    public void setCourtEventOnBehalfOfActor(CourtEventActorType value) {
        this.courtEventOnBehalfOfActor = value;
    }

    /**
     * Gets the value of the courtEventTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtEventTypeCode() {
        return courtEventTypeCode;
    }

    /**
     * Sets the value of the courtEventTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtEventTypeCode(TextType value) {
        this.courtEventTypeCode = value;
    }

    /**
     * Gets the value of the courtLocationCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     
     */
    public JAXBElement<TextType> getCourtLocationCode() {
        return courtLocationCode;
    }

    /**
     * Sets the value of the courtLocationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     {@link JAXBElement }{@code <}{@link TextType }{@code >}
     *     
     */
    public void setCourtLocationCode(JAXBElement<TextType> value) {
        this.courtLocationCode = value;
    }

    /**
     * Gets the value of the caseDocketID property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the caseDocketID property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseDocketID().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String }
     * 
     * 
     */
    public List<ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String> getCaseDocketID() {
        if (caseDocketID == null) {
            caseDocketID = new ArrayList<ecf4.v2025_0.gov.niem.release.niem.proxy.xsd._4.String>();
        }
        return this.caseDocketID;
    }

    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public java.lang.String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
