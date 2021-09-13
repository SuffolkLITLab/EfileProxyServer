
package ecfv5.oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.datatype.XMLGregorianCalendar;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDeliveryDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualDespatchDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ActualPickupDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ApprovalDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AvailabilityDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AwardDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BestBeforeDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.BirthDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.CallDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ComparisonForecastIssueDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DueDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EarliestPickupDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EffectiveDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EndDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDeliveryDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.EstimatedDespatchDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ExpiryDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.FirstShipmentAvailibilityDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.GuaranteedDespatchDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.InstallmentDueDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.IssueDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LastRevisionDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestDeliveryDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestMeterReadingDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestPickupDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestProposalAcceptanceDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.LatestSecurityClearanceDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ManufactureDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.NominationDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.OccurrenceDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaidDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentDueDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PlannedDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PreviousMeterReadingDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReceivedDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ReferenceDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegisteredDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RegistrationExpirationDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedDeliveryDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedDespatchDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequestedPublicationDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RequiredDeliveryDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResolutionDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ResponseDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.RevisionDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SourceForecastIssueDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.StartDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubmissionDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.SubmissionDueDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxPointDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidationDateType;
import ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ValidityStartDateType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


/**
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:UniqueID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UBLUDT000009&lt;/ccts:UniqueID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:CategoryCode xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;UDT&lt;/ccts:CategoryCode&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:DictionaryEntryName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Date. Type&lt;/ccts:DictionaryEntryName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:VersionID xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;1.0&lt;/ccts:VersionID&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:Definition xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;One calendar day according the Gregorian calendar.&lt;/ccts:Definition&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:RepresentationTermName xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;Date&lt;/ccts:RepresentationTermName&gt;
 * </pre>
 * 
 * <pre>
 * &lt;?xml version="1.0" encoding="UTF-8"?&gt;&lt;ccts:PrimitiveType xmlns:ccts="urn:un:unece:uncefact:documentation:2" xmlns:ccts-cct="urn:ecfv5.un:unece:uncefact:data:specification:CoreComponentTypeSchemaModule:2" xmlns:xsd="http://www.w3.org/2001/XMLSchema"&gt;string&lt;/ccts:PrimitiveType&gt;
 * </pre>
 * 
 * 
 * <p>Java class for DateType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DateType"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema&gt;date"&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateType", propOrder = {
    "value"
})
@XmlSeeAlso({
    ActualDeliveryDateType.class,
    ActualDespatchDateType.class,
    ActualPickupDateType.class,
    ApprovalDateType.class,
    AvailabilityDateType.class,
    AwardDateType.class,
    BestBeforeDateType.class,
    BirthDateType.class,
    CallDateType.class,
    ComparisonForecastIssueDateType.class,
    ecfv5.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.DateType.class,
    DueDateType.class,
    EarliestPickupDateType.class,
    EffectiveDateType.class,
    EndDateType.class,
    EstimatedDeliveryDateType.class,
    EstimatedDespatchDateType.class,
    ExpiryDateType.class,
    FirstShipmentAvailibilityDateType.class,
    GuaranteedDespatchDateType.class,
    InstallmentDueDateType.class,
    IssueDateType.class,
    LastRevisionDateType.class,
    LatestDeliveryDateType.class,
    LatestMeterReadingDateType.class,
    LatestPickupDateType.class,
    LatestProposalAcceptanceDateType.class,
    LatestSecurityClearanceDateType.class,
    ManufactureDateType.class,
    NominationDateType.class,
    OccurrenceDateType.class,
    PaidDateType.class,
    PaymentDueDateType.class,
    PlannedDateType.class,
    PreviousMeterReadingDateType.class,
    ReceivedDateType.class,
    ReferenceDateType.class,
    RegisteredDateType.class,
    RegistrationDateType.class,
    RegistrationExpirationDateType.class,
    RequestedDeliveryDateType.class,
    RequestedDespatchDateType.class,
    RequestedPublicationDateType.class,
    RequiredDeliveryDateType.class,
    ResolutionDateType.class,
    ResponseDateType.class,
    RevisionDateType.class,
    SourceForecastIssueDateType.class,
    StartDateType.class,
    SubmissionDateType.class,
    SubmissionDueDateType.class,
    TaxPointDateType.class,
    ValidationDateType.class,
    ValidityStartDateType.class
})
public class DateType {

    @XmlValue
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar value;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setValue(XMLGregorianCalendar value) {
        this.value = value;
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
