package edu.suffolk.litlab.efsp.ecf5;

import ecf5.TylerCourtRecordMDEService;
import edu.suffolk.litlab.efsp.tyler.TylerVersion;
import jakarta.xml.ws.BindingProvider;
import java.util.function.Consumer;

public class TylerCourtRecordClient {
  private ecf5.v2024_6.tyler.ecf.v5_0.extensions.tylercourtrecordmde.TylerCourtRecordMDE v2024Port;
  private TylerVersion version;

  public TylerCourtRecordClient(
      TylerCourtRecordMDEService factory, TylerVersion version, Consumer<BindingProvider> setup) {
    this.version = version;
    switch (version) {
      case v2022_1:
        this.v2024Port = factory.getTylerCourtRecordMDE();
        break;
      case v2024_6:
        this.v2024Port = factory.getTylerCourtRecordMDE();
        break;
      case v2025_0:
        this.v2024Port = factory.getTylerCourtRecordMDE();
        break;
      default:
        this.v2024Port = factory.getTylerCourtRecordMDE();
        break;
    }
  }

  public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.UpdateDocumentResponseType updateDocument(
      ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.UpdateDocumentRequestType body) {
    return v2024Port.updateDocument(body);
  }

  public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.RecordServiceResponseType recordService(
      ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.RecordServiceRequestType body) {
    return v2024Port.recordService(body);
  }

  public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.RecordReceiptResponseType recordReceipt(
      ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.RecordReceiptRequestType body) {
    return v2024Port.recordReceipt(body);
  }

  public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetPartyResponseType getParty(
      ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetPartyRequestType body) {
    return v2024Port.getParty(body);
  }

  public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetCaseHearingsResponseType
      getCaseHearings(
          ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetCaseHearingsRequestType body) {
    return v2024Port.getCaseHearings(body);
  }

  public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.SecureCaseResponseType secureCase(
      ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.SecureCaseRequestType body) {
    return v2024Port.secureCase(body);
  }

  public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetServiceInformationHistoryResponseType
      getServiceInformationHistory(
          ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetServiceInformationHistoryRequestType
              body) {
    return v2024Port.getServiceInformationHistory(body);
  }

  public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetServiceCaseListResponseType
      getServiceCaseList(
          ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetServiceCaseListRequestType body) {
    return v2024Port.getServiceCaseList(body);
  }

  public ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetPartyListResponseType getPartyList(
      ecf5.v2024_6.tyler.ecf.v5_0.extensions.wrappers.GetPartyListRequestType body) {
    return v2024Port.getPartyList(body);
  }
}
