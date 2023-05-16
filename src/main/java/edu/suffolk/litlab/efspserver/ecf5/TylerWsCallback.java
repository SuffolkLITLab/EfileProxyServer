package edu.suffolk.litlab.efspserver.ecf5;

import gov.niem.release.niem.codes.cbrncl._4.CredentialsAuthenticatedCodeSimpleType;
import gov.niem.release.niem.codes.cbrncl._4.CredentialsAuthenticatedCodeType;
import gov.niem.release.niem.codes.cbrncl._4.MessageStatusCodeSimpleType;
import gov.niem.release.niem.codes.cbrncl._4.MessageStatusCodeType;
import gov.niem.release.niem.domains.cbrn._4.MessageContentErrorType;
import gov.niem.release.niem.domains.cbrn._4.MessageErrorType;
import gov.niem.release.niem.domains.cbrn._4.MessageStatusType;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.ecf.v5_0.extensions.tylerfilingassemblymde.TylerFilingAssemblyMDE;
import tyler.ecf.v5_0.extensions.wrappers.CaptureFeesRequestType;
import tyler.ecf.v5_0.extensions.wrappers.CaptureFeesResponseType;
import tyler.ecf.v5_0.extensions.wrappers.NotifyBatchCompleteRequestType;
import tyler.ecf.v5_0.extensions.wrappers.NotifyBatchCompleteResponseType;
import tyler.ecf.v5_0.extensions.wrappers.NotifyEnvelopeCompleteRequestType;
import tyler.ecf.v5_0.extensions.wrappers.NotifyEnvelopeCompleteResponseType;
import tyler.ecf.v5_0.extensions.wrappers.NotifyEventRequestType;
import tyler.ecf.v5_0.extensions.wrappers.NotifyEventResponseType;
import tyler.ecf.v5_0.extensions.wrappers.NotifyServiceCompleteRequestType;
import tyler.ecf.v5_0.extensions.wrappers.NotifyServiceCompleteResponseType;
import tyler.ecf.v5_0.extensions.wrappers.UpdateFeesRequestType;
import tyler.ecf.v5_0.extensions.wrappers.UpdateFeesResponseType;

public class TylerWsCallback implements TylerFilingAssemblyMDE {
  private static Logger log = LoggerFactory.getLogger(TylerWsCallback.class);
  private static final tyler.ecf.v5_0.extensions.wrappers.ObjectFactory wrappersObjFac =
      new tyler.ecf.v5_0.extensions.wrappers.ObjectFactory();

  @Override
  public NotifyEventResponseType notifyEvent(NotifyEventRequestType eventCallbackMessage) {
    log.info("Full NotifyEvent msg" + eventCallbackMessage);
    // TODO(brycew): not going to do anything with for now
    var resp = wrappersObjFac.createNotifyEventResponseType();
    resp.setMessageStatus(ok());
    return resp;
  }

  @Override
  public NotifyServiceCompleteResponseType notifyServiceComplete(
      NotifyServiceCompleteRequestType serviceCallbackMessage) {
    log.info(
        "Full NotifyServiceComplete msg: "
            + Ecf5Helper.objectToXmlStrOrError(
                serviceCallbackMessage, NotifyServiceCompleteRequestType.class));
    // TODO(brycew): not going to do anything with for now
    var resp = wrappersObjFac.createNotifyServiceCompleteResponseType();
    resp.setMessageStatus(ok());
    return resp;
  }

  @Override
  public CaptureFeesResponseType captureFees(CaptureFeesRequestType body) {
    // TODO(brycew) Auto-generated method stub
    // What does this mean?
    return null;
  }

  @Override
  public NotifyBatchCompleteResponseType notifyBatchComplete(NotifyBatchCompleteRequestType body) {
    // NOTE(brycew): not implementing, empty stub so SOAP stuff works
    return null;
  }

  @Override
  public UpdateFeesResponseType updateFees(UpdateFeesRequestType body) {
    // TODO(brycew): Auto-generated method stub
    // Docs say "an operation to update fees changed during review in CMS", so likely when the clerk
    // changes the
    // fees on a filing.
    return null;
  }

  @Override
  public NotifyEnvelopeCompleteResponseType notifyEnvelopeComplete(
      NotifyEnvelopeCompleteRequestType body) {
    // TODO(brycew): how is this different from review complete?
    return null;
  }

  private static MessageStatusType ok() {
    MessageStatusType st = common();
    MessageStatusCodeType ct = new MessageStatusCodeType();
    ct.setValue(MessageStatusCodeSimpleType.SUCCESS);
    st.setMessageStatusCode(ct);
    MessageContentErrorType contentError = new MessageContentErrorType();
    MessageErrorType errType = new MessageErrorType();
    errType.setErrorCodeText(Ecf5Helper.convertText("0"));
    contentError.setErrorDescription(errType);
    st.getMessageContentError().add(contentError);
    return st;
  }

  private static MessageStatusType common() {
    MessageStatusType st = new MessageStatusType();
    st.setSystemSimulatedIndicator(false);
    st.setSystemEventDateTime(Ecf5Helper.convertProxyDate(LocalDateTime.now()));
    CredentialsAuthenticatedCodeType act = new CredentialsAuthenticatedCodeType();
    act.setValue(CredentialsAuthenticatedCodeSimpleType.AUTHENTICATED);
    st.setCredentialsAuthenticatedCode(act);
    // SystemOperatingModeCodeType mct = new SystemOperatingModeCodeType();
    // mct.setValue(SystemOperatingModeCodeSimpleType.OPS);
    var statusFac = new gov.niem.release.niem.domains.cbrn._4.ObjectFactory();
    st.setSystemOperatingModeAbstract(statusFac.createCredentialsAuthenticatedCode(act));
    st.setResendRequestIndicator(Ecf5Helper.convertBool(false));
    MessageErrorType okHandling = new MessageErrorType();
    okHandling.setErrorCodeText(Ecf5Helper.convertText("0"));
    st.setMessageHandlingError(okHandling);
    return st;
  }
}
