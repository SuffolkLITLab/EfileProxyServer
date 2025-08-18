package edu.suffolk.litlab.efsp.server.utils;

import org.apache.cxf.interceptor.AbstractOutDatabindingInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;

/** Clears all MDC entries after our business logic finishes running. */
public class ObservabilityResetInterceptor extends AbstractOutDatabindingInterceptor {

  public ObservabilityResetInterceptor() {
    // See https://cxf.apache.org/docs/interceptors.html for phase descriptions
    super(Phase.POST_LOGICAL);
  }

  @Override
  public void handleMessage(Message message) throws Fault {
    MDCWrappers.removeAllMDCs();
  }
}
