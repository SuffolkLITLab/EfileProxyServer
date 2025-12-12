package edu.suffolk.litlab.efsp.ecf5;

import ecf5.CourtRecordMDEService;
import edu.suffolk.litlab.efsp.tyler.TylerVersion;
import jakarta.xml.ws.BindingProvider;
import java.util.function.Consumer;

public class CourtRecordClient {
  private ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.courtrecordmde
          .CourtRecordMDE
      v2024Port;
  private TylerVersion version;

  public CourtRecordClient(
      CourtRecordMDEService factory, TylerVersion version, Consumer<BindingProvider> setup) {
    this.version = version;
    switch (version) {
      case v2022_1:
        this.v2024Port = factory.getCourtRecordMDE();
        setup.accept((BindingProvider) v2024Port);
        break;
      case v2024_6:
        this.v2024Port = factory.getCourtRecordMDE();
        setup.accept((BindingProvider) v2024Port);
        break;
      case v2025_0:
        this.v2024Port = factory.getCourtRecordMDE();
        setup.accept((BindingProvider) v2024Port);
        break;
      default:
        this.v2024Port = factory.getCourtRecordMDE();
        setup.accept((BindingProvider) v2024Port);
        break;
    }
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .RecordDocketingResponseType
      recordDocketing(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .RecordDocketingRequestType
              body) {
    return v2024Port.recordDocketing(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .GetCaseListResponseType
      getCaseList(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .GetCaseListRequestType
              body) {
    return v2024Port.getCaseList(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .GetDocumentResponseType
      getDocument(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .GetDocumentRequestType
              body) {
    return v2024Port.getDocument(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .GetServiceInformationResponseType
      getServiceInformation(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .GetServiceInformationRequestType
              body) {
    return v2024Port.getServiceInformation(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .AllocateCourtDateResponseType
      allocateCourtDate(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .AllocateCourtDateRequestType
              body) {
    return v2024Port.allocateCourtDate(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .GetCaseResponseType
      getCase(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .GetCaseRequestType
              body) {
    return v2024Port.getCase(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .DocumentStampInformationResponseType
      documentStampInformation(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .DocumentStampInformationRequestType
              body) {
    return v2024Port.documentStampInformation(body);
  }
}
