
package ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf;

import java.util.ArrayList;
import java.util.List;
import ecf4.latest.gov.niem.release.niem.domains.jxdm._6.CourtType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DateType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.DocumentType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.EntityType;
import ecf4.latest.gov.niem.release.niem.niem_core._4.IdentificationType;
import ecf4.latest.gov.niem.release.niem.proxy.xsd._4.NormalizedString;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.allocatedate.AllocateCourtDateMessageType;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.datecallback.NotifyCourtDateMessageType;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.docket.RecordDocketingMessageType;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.FilingMessageType;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reservedate.ReserveCourtDateMessageType;
import ecf4.latest.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.stampinformation.DocumentStampInformationMessageType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import ecf4.latest.tyler.ecf.v5_0.extensions.returndate.ReturnDateMessageType;


/**
 * The core information contained in an ECF 5.0 message.
 * 
 * <p>Java class for CaseFilingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CaseFilingType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://release.niem.gov/niem/niem-core/4.0/}DocumentType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}DocumentFiler" maxOccurs="unbounded"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}SendingMDELocationID"/&gt;
 *         &lt;element ref="{https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/ecf}ServiceInteractionProfileCode"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/domains/jxdm/6.0/}CaseCourt"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentInformationCutOffDate" minOccurs="0"/&gt;
 *         &lt;element ref="{http://release.niem.gov/niem/niem-core/4.0/}DocumentPostDate"/&gt;
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
@XmlType(name = "CaseFilingType", propOrder = {
    "documentFiler",
    "sendingMDELocationID",
    "serviceInteractionProfileCode",
    "caseCourt",
    "documentInformationCutOffDate",
    "documentPostDate"
})
@XmlSeeAlso({
    AllocateCourtDateMessageType.class,
    NotifyCourtDateMessageType.class,
    RecordDocketingMessageType.class,
    FilingMessageType.class,
    ReserveCourtDateMessageType.class,
    RequestMessageType.class,
    DocumentStampInformationMessageType.class,
    CallbackMessageType.class,
    ReturnDateMessageType.class,
    ResponseMessageType.class
})
public class CaseFilingType
    extends DocumentType
{

    @XmlElement(name = "DocumentFiler", required = true)
    protected List<EntityType> documentFiler;
    @XmlElement(name = "SendingMDELocationID", required = true)
    protected IdentificationType sendingMDELocationID;
    @XmlElement(name = "ServiceInteractionProfileCode", required = true)
    protected NormalizedString serviceInteractionProfileCode;
    @XmlElement(name = "CaseCourt", namespace = "http://release.niem.gov/niem/domains/jxdm/6.0/", required = true)
    protected CourtType caseCourt;
    @XmlElement(name = "DocumentInformationCutOffDate", namespace = "http://release.niem.gov/niem/niem-core/4.0/")
    protected DateType documentInformationCutOffDate;
    @XmlElement(name = "DocumentPostDate", namespace = "http://release.niem.gov/niem/niem-core/4.0/", required = true)
    protected DateType documentPostDate;

    /**
     * Gets the value of the documentFiler property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the documentFiler property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentFiler().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EntityType }
     * 
     * 
     */
    public List<EntityType> getDocumentFiler() {
        if (documentFiler == null) {
            documentFiler = new ArrayList<EntityType>();
        }
        return this.documentFiler;
    }

    /**
     * Gets the value of the sendingMDELocationID property.
     * 
     * @return
     *     possible object is
     *     {@link IdentificationType }
     *     
     */
    public IdentificationType getSendingMDELocationID() {
        return sendingMDELocationID;
    }

    /**
     * Sets the value of the sendingMDELocationID property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentificationType }
     *     
     */
    public void setSendingMDELocationID(IdentificationType value) {
        this.sendingMDELocationID = value;
    }

    /**
     * Gets the value of the serviceInteractionProfileCode property.
     * 
     * @return
     *     possible object is
     *     {@link NormalizedString }
     *     
     */
    public NormalizedString getServiceInteractionProfileCode() {
        return serviceInteractionProfileCode;
    }

    /**
     * Sets the value of the serviceInteractionProfileCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link NormalizedString }
     *     
     */
    public void setServiceInteractionProfileCode(NormalizedString value) {
        this.serviceInteractionProfileCode = value;
    }

    /**
     * Gets the value of the caseCourt property.
     * 
     * @return
     *     possible object is
     *     {@link CourtType }
     *     
     */
    public CourtType getCaseCourt() {
        return caseCourt;
    }

    /**
     * Sets the value of the caseCourt property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourtType }
     *     
     */
    public void setCaseCourt(CourtType value) {
        this.caseCourt = value;
    }

    /**
     * Gets the value of the documentInformationCutOffDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentInformationCutOffDate() {
        return documentInformationCutOffDate;
    }

    /**
     * Sets the value of the documentInformationCutOffDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentInformationCutOffDate(DateType value) {
        this.documentInformationCutOffDate = value;
    }

    /**
     * Gets the value of the documentPostDate property.
     * 
     * @return
     *     possible object is
     *     {@link DateType }
     *     
     */
    public DateType getDocumentPostDate() {
        return documentPostDate;
    }

    /**
     * Sets the value of the documentPostDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateType }
     *     
     */
    public void setDocumentPostDate(DateType value) {
        this.documentPostDate = value;
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
