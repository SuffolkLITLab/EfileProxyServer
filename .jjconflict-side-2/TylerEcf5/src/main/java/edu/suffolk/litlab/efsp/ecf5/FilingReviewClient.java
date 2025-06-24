package edu.suffolk.litlab.efsp.ecf5;

import ecf5.FilingReviewMDEService;
import edu.suffolk.litlab.efsp.tyler.TylerVersion;
import jakarta.xml.ws.BindingProvider;
import java.util.function.Consumer;

public class FilingReviewClient {
  private ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0wsdl.filingreviewmde
          .FilingReviewMDE
      v2024Port;
  private TylerVersion version;

  public FilingReviewClient(
      FilingReviewMDEService factory, TylerVersion version, Consumer<BindingProvider> setup) {
    this.version = version;
    switch (version) {
      case v2022_1:
        this.v2024Port = factory.getFilingReviewMDE();
        setup.accept((BindingProvider) v2024Port);
        break;
      case v2024_6:
        this.v2024Port = factory.getFilingReviewMDE();
        setup.accept((BindingProvider) v2024Port);
        break;
      case v2025_0:
        this.v2024Port = factory.getFilingReviewMDE();
        setup.accept((BindingProvider) v2024Port);
        break;
      default:
        this.v2024Port = factory.getFilingReviewMDE();
        setup.accept((BindingProvider) v2024Port);
        break;
    }
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .NotifyDocumentStampInformationResponseType
      notifyDocumentStampInformation(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .NotifyDocumentStampInformationRequestType
              body) {
    return v2024Port.notifyDocumentStampInformation(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .ReviewFilingResponseType
      reviewFiling(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .ReviewFilingRequestType
              body) {
    return v2024Port.reviewFiling(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .GetFeesCalculationResponseType
      getFeesCalculation(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .GetFeesCalculationRequestType
              body) {
    return v2024Port.getFeesCalculation(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .CancelFilingResponseType
      cancelFiling(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .CancelFilingRequestType
              body) {
    return v2024Port.cancelFiling(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .GetFilingStatusResponseType
      getFilingStatus(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .GetFilingStatusRequestType
              body) {
    return v2024Port.getFilingStatus(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .NotifyDocketingCompleteResponseType
      notifyDocketingComplete(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .NotifyDocketingCompleteRequestType
              body) {
    return v2024Port.notifyDocketingComplete(body);
  }

  public ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
          .GetFilingListResponseType
      getFilingList(
          ecf5.v2024_6.https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.wrappers
                  .GetFilingListRequestType
              body) {
    return v2024Port.getFilingList(body);
  }
}
