
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.TextType;
import gov.niem.niem.structures._2.ReferenceType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * Details about an event on the court calendar.
 * 
 * <p>Java class for CourtEventType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourtEventType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/domains/jxdm/4.0}CourtEventType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}ChildDocketReference" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CourtEventEnteredOnDocketDate"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CourtEventTypeCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CourtEventDocument" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CourtEventDocumentReference" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CourtEventActor" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CourtEventOnBehalfOfActor" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CourtEventLocationCode" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}CourtEventLocationText" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourtEventType", propOrder = {
    "childDocketReference",
    "courtEventEnteredOnDocketDate",
    "courtEventTypeCode",
    "courtEventDocument",
    "courtEventDocumentReference",
    "courtEventActor",
    "courtEventOnBehalfOfActor",
    "courtEventLocationCode",
    "courtEventLocationText"
})
public class CourtEventType
    extends gov.niem.niem.domains.jxdm._4.CourtEventType
{

    @XmlElement(name = "ChildDocketReference")
    protected List<ReferenceType> childDocketReference;
    @XmlElement(name = "CourtEventEnteredOnDocketDate", required = true)
    protected DateType courtEventEnteredOnDocketDate;
    @XmlElement(name = "CourtEventTypeCode", required = true)
    protected TextType courtEventTypeCode;
    @XmlElement(name = "CourtEventDocument")
    protected CourtEventDocumentType courtEventDocument;
    @XmlElement(name = "CourtEventDocumentReference")
    protected ReferenceType courtEventDocumentReference;
    @XmlElement(name = "CourtEventActor")
    protected CourtEventActorType courtEventActor;
    @XmlElement(name = "CourtEventOnBehalfOfActor")
    protected CourtEventOnBehalfOfActorType courtEventOnBehalfOfActor;
    @XmlElement(name = "CourtEventLocationCode")
    protected TextType courtEventLocationCode;
    @XmlElement(name = "CourtEventLocationText")
    protected TextType courtEventLocationText;

    /**
     * Gets the value of the childDocketReference property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childDocketReference property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildDocketReference().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferenceType }
     * 
     * 
     */
    public List<ReferenceType> getChildDocketReference() {
        if (childDocketReference == null) {
            childDocketReference = new ArrayList<ReferenceType>();
        }
        return this.childDocketReference;
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
     * Gets the value of the courtEventDocument property.
     * 
     * @return
     *     possible object is
     *     {@link CourtEventDocumentType }
     *     
     */
    public CourtEventDocumentType getCourtEventDocument() {
        return courtEventDocument;
    }

    /**
     * Sets the value of the courtEventDocument property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtEventDocumentType }
     *     
     */
    public void setCourtEventDocument(CourtEventDocumentType value) {
        this.courtEventDocument = value;
    }

    /**
     * Gets the value of the courtEventDocumentReference property.
     * 
     * @return
     *     possible object is
     *     {@link ReferenceType }
     *     
     */
    public ReferenceType getCourtEventDocumentReference() {
        return courtEventDocumentReference;
    }

    /**
     * Sets the value of the courtEventDocumentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReferenceType }
     *     
     */
    public void setCourtEventDocumentReference(ReferenceType value) {
        this.courtEventDocumentReference = value;
    }

    /**
     * Gets the value of the courtEventActor property.
     * 
     * @return
     *     possible object is
     *     {@link CourtEventActorType }
     *     
     */
    public CourtEventActorType getCourtEventActor() {
        return courtEventActor;
    }

    /**
     * Sets the value of the courtEventActor property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtEventActorType }
     *     
     */
    public void setCourtEventActor(CourtEventActorType value) {
        this.courtEventActor = value;
    }

    /**
     * Gets the value of the courtEventOnBehalfOfActor property.
     * 
     * @return
     *     possible object is
     *     {@link CourtEventOnBehalfOfActorType }
     *     
     */
    public CourtEventOnBehalfOfActorType getCourtEventOnBehalfOfActor() {
        return courtEventOnBehalfOfActor;
    }

    /**
     * Sets the value of the courtEventOnBehalfOfActor property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtEventOnBehalfOfActorType }
     *     
     */
    public void setCourtEventOnBehalfOfActor(CourtEventOnBehalfOfActorType value) {
        this.courtEventOnBehalfOfActor = value;
    }

    /**
     * Gets the value of the courtEventLocationCode property.
     * 
     * @return
     *     possible object is
     *     {@link TextType }
     *     
     */
    public TextType getCourtEventLocationCode() {
        return courtEventLocationCode;
    }

    /**
     * Sets the value of the courtEventLocationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextType }
     *     
     */
    public void setCourtEventLocationCode(TextType value) {
        this.courtEventLocationCode = value;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
