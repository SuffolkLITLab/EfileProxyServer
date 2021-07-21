
package oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import gov.niem.niem.domains.jxdm._4.CourtType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.structures._2.ComplexObjectType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.caselistquerymessage_4.CaseListQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.casequerymessage_4.CaseQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.documentquerymessage_4.DocumentQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.FeesCalculationQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.FilingListQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.FilingStatusQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.serviceinformationquerymessage_4.ServiceInformationQueryMessageType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.ecf.extensions.cancelfilingmessage.CancelFilingMessageType;
import tyler.ecf.extensions.filingdetailquerymessage.FilingDetailQueryMessageType;
import tyler.ecf.extensions.filingservicequerymessage.FilingServiceQueryMessageType;
import tyler.ecf.extensions.securecasemessage.SecureCaseMessageType;
import tyler.ecf.extensions.serviceattachcaselistquerymessage.ServiceAttachCaseListQueryMessageType;
import tyler.ecf.extensions.serviceinformationhistoryquerymessage.ServiceInformationHistoryQueryMessageType;
import tyler.ecf.extensions.servicetypesrequestmessage.ServiceTypesRequestMessageType;


/**
 * A message returned synchronously as a response to a query.
 * 
 * <p>Java class for QueryMessageType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryMessageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SendingMDELocationID"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}SendingMDEProfileCode"/&gt;
 *         &lt;element ref="{urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0}QuerySubmitter"/&gt;
 *         &lt;element ref="{http://niem.gov/niem/domains/jxdm/4.0}CaseCourt"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryMessageType", propOrder = {
    "sendingMDELocationID",
    "sendingMDEProfileCode",
    "querySubmitter",
    "caseCourt"
})
@XmlSeeAlso({
    ServiceInformationQueryMessageType.class,
    CancelFilingMessageType.class,
    SecureCaseMessageType.class,
    ServiceTypesRequestMessageType.class,
    CourtPolicyQueryMessageType.class,
    FilingStatusQueryMessageType.class,
    FilingDetailQueryMessageType.class,
    FeesCalculationQueryMessageType.class,
    ServiceAttachCaseListQueryMessageType.class,
    DocumentQueryMessageType.class,
    CaseQueryMessageType.class,
    CaseListQueryMessageType.class,
    ServiceInformationHistoryQueryMessageType.class,
    FilingListQueryMessageType.class,
    FilingServiceQueryMessageType.class
})
public class QueryMessageType
    extends ComplexObjectType
{

    @XmlElement(name = "SendingMDELocationID", required = true)
    protected IdentificationType sendingMDELocationID;
    @XmlElement(name = "SendingMDEProfileCode", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String sendingMDEProfileCode;
    @XmlElement(name = "QuerySubmitter", required = true)
    protected EntityType querySubmitter;
    @XmlElement(name = "CaseCourt", namespace = "http://niem.gov/niem/domains/jxdm/4.0", required = true, nillable = true)
    protected CourtType caseCourt;

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
     * Gets the value of the querySubmitter property.
     * 
     * @return
     *     possible object is
     *     {@link EntityType }
     *     
     */
    public EntityType getQuerySubmitter() {
        return querySubmitter;
    }

    /**
     * Sets the value of the querySubmitter property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityType }
     *     
     */
    public void setQuerySubmitter(EntityType value) {
        this.querySubmitter = value;
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
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
