
package ecf4.latest.tyler.ecf.extensions.createcasecallbackmessage;

import ecf4.latest.gov.niem.niem.niem_core._2.CaseType;
import ecf4.latest.gov.niem.niem.niem_core._2.IdentificationType;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.NormalizedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.appellatecase_4.AppellateCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.bankruptcycase_4.BankruptcyCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.citationcase_4.CitationCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.CivilCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.FilingStatusType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.criminalcase_4.CriminalCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.domesticcase_4.DomesticCaseType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.juvenilecase_4.JuvenileCaseType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * The message returned from the Court Record MDE to the Filing Review MDE when the case has been created.
 * 
 * <p>Java class for CreateCaseCallbackMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateCaseCallbackMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SendingMDELocationID"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SendingMDEProfileCode"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}Case"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}FilingStatus"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateCaseCallbackMessageType", propOrder = {
    "sendingMDELocationID",
    "sendingMDEProfileCode",
    "_case",
    "filingStatus"
})
public class CreateCaseCallbackMessageType {

    @XmlElement(name = "SendingMDELocationID", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    protected IdentificationType sendingMDELocationID;
    @XmlElement(name = "SendingMDEProfileCode", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String sendingMDEProfileCode;
    @XmlElementRef(name = "Case", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class)
    protected JAXBElement<? extends CaseType> _case;
    @XmlElement(name = "FilingStatus", namespace = "urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0", required = true)
    protected FilingStatusType filingStatus;

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
     * Gets the value of the sendingMDEProfileCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSendingMDEProfileCode() {
        return sendingMDEProfileCode;
    }

    /**
     * Sets the value of the sendingMDEProfileCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSendingMDEProfileCode(String value) {
        this.sendingMDEProfileCode = value;
    }

    /**
     * Gets the value of the case property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BankruptcyCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CitationCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CivilCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CriminalCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DomesticCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
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
     *     {@link JAXBElement }{@code <}{@link CaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link AppellateCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link BankruptcyCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CitationCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CivilCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link CriminalCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link DomesticCaseType }{@code >}
     *     {@link JAXBElement }{@code <}{@link JuvenileCaseType }{@code >}
     *     
     */
    public void setCase(JAXBElement<? extends CaseType> value) {
        this._case = value;
    }

    /**
     * Gets the value of the filingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link FilingStatusType }
     *     
     */
    public FilingStatusType getFilingStatus() {
        return filingStatus;
    }

    /**
     * Sets the value of the filingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link FilingStatusType }
     *     
     */
    public void setFilingStatus(FilingStatusType value) {
        this.filingStatus = value;
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
