package ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wsdl.courtschedulingmde;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.5.0-SNAPSHOT-3e40a2387febaf00f47fe893d97ffdf63aaa4626
 * 2021-09-15T00:22:19.711-04:00
 * Generated source version: 3.5.0-SNAPSHOT
 *
 */
@WebService(targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE", name = "CourtSchedulingMDE")
@XmlSeeAlso({ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.datecallback.ObjectFactory.class, ecfv5.gov.niem.release.niem.codes.fbi_ncic._4.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caseresponse.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistrequest.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusresponse.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caselistresponse.ObjectFactory.class, org.w3._2000._09.xmldsig_.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationresponse.ObjectFactory.class, ecfv5.gov.niem.release.niem.codes.iso_4217._4.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.cancel.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filinglistresponse.ObjectFactory.class, ecfv5.tyler.ecf.v5_0.extensions.returndateresponse.ObjectFactory.class, ecfv5.gov.niem.release.niem.proxy.xsd._4.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyresponse.ObjectFactory.class, 
      ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesrequest.ObjectFactory.class, ecfv5.tyler.ecf.v5_0.extensions.returndate.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.stampinformation.ObjectFactory.class, ecfv5.gov.niem.release.niem.codes.cbrncl._4.ObjectFactory.class, ecfv5.gov.niem.release.niem.codes.iso_3166_1._4.ObjectFactory.class, ecfv5.tyler.ecf.v5_0.extensions.reservedateresponse.ObjectFactory.class, 
      ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reservedate.ObjectFactory.class, ecfv5.gov.niem.release.niem.domains.jxdm._6.ObjectFactory.class, oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.stampinformationcallback.ObjectFactory.class, ecfv5.gov.niem.release.niem.domains.biometrics._4.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentresponse.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.docket.ObjectFactory.class, ecfv5.gov.niem.release.niem.codes.fbi_ucr._4.ObjectFactory.class, ecfv5.gov.niem.release.niem.codes.iso_639_3._4.ObjectFactory.class, ecfv5.gov.niem.release.niem.niem_core._4.ObjectFactory.class, ecfv5.gov.niem.release.niem.domains.humanservices._4.ObjectFactory.class, 
      ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.ObjectFactory.class, ecfv5.gov.niem.release.niem.codes.aamva_d20._4.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filinglistrequest.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.scheduleresponse.ObjectFactory.class, ecfv5.gov.niem.release.niem.domains.cbrn._4.ObjectFactory.class, ecfv5.gov.niem.release.niem.codes.unece_rec20._4.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.documentrequest.ObjectFactory.class, un.unece.uncefact.data.specification.corecomponenttypeschemamodule._2.ObjectFactory.class, ecfv5.gov.niem.release.niem.codes.mmucc._4.ObjectFactory.class, 
      ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filing.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.reviewfilingcallback.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.caserequest.ObjectFactory.class, oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory.class, oasis.names.specification.ubl.schema.xsd.unqualifieddatatypes_2.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.civil.ObjectFactory.class, ecfv5.ietf.params.xml.ns.icalendar_2.ObjectFactory.class, ecfv5.gov.niem.release.niem.codes.usps_states._4.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.feesresponse.ObjectFactory.class, ecfv5.gov.niem.release.niem.structures._4.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.allocatedate.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.policyrequest.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.ecf.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.schedulerequest.ObjectFactory.class, ecfv5.tyler.ecf.v5_0.extensions.common.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.serviceinformationrequest.ObjectFactory.class, ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.filingstatusrequest.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CourtSchedulingMDE {

    @WebMethod(operationName = "GetCourtSchedule", action = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE/GetCourtSchedule")
    @WebResult(name = "GetCourtScheduleResponse", targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/MessageWrappers", partName = "body")
    public ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.GetCourtScheduleResponseType getCourtSchedule(

        @WebParam(partName = "body", name = "GetCourtScheduleRequest", targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/MessageWrappers")
        ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.GetCourtScheduleRequestType body
    );

    @WebMethod(operationName = "ReserveCourtDateSync", action = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE/ReserveCourtDateSync")
    @WebResult(name = "ReserveCourtDateSyncResponse", targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/MessageWrappers", partName = "body")
    public ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ReserveCourtDateSyncResponseType reserveCourtDateSync(

        @WebParam(partName = "body", name = "ReserveCourtDateRequest", targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/MessageWrappers")
        ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ReserveCourtDateRequestType body
    );

    @WebMethod(operationName = "NotifyCourtDate", action = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE/NotifyCourtDate")
    @WebResult(name = "NotifyCourtDateResponse", targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/MessageWrappers", partName = "body")
    public ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyCourtDateResponseType notifyCourtDate(

        @WebParam(partName = "body", name = "NotifyCourtDateRequest", targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/MessageWrappers")
        ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.NotifyCourtDateRequestType body
    );

    @WebMethod(operationName = "GetReturnDate", action = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/WSDL/CourtSchedulingMDE/GetReturnDate")
    @WebResult(name = "ReturnDateResponse", targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/MessageWrappers", partName = "body")
    public ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ReturnDateResponseType getReturnDate(

        @WebParam(partName = "body", name = "ReturnDateRequest", targetNamespace = "https://docs.oasis-open.org/legalxml-courtfiling/ns/v5.0/MessageWrappers")
        ecfv5.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.messagewrappers.ReturnDateRequestType body
    );
}
