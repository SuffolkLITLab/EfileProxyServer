package edu.suffolk.litlab.efspserver.ecf5;

import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.PaymentMessageType;
import tyler.ecf.v5_0.extensions.common.ProviderChargeType;

public class PaymentFactory {

  private static final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.ObjectFactory
      ecfObjFac =
          new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.ObjectFactory();
  private static final oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2
          .ObjectFactory
      cacObjFac =
          new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory();
  private static final tyler.ecf.v5_0.extensions.common.ObjectFactory tylerObjFac =
      new tyler.ecf.v5_0.extensions.common.ObjectFactory();

  public static PaymentMessageType makePaymentMessage(String paymentId, String jurisdiction) {
    PaymentMessageType pmt = ecfObjFac.createPaymentMessageType();
    pmt.setFeeExceptionReasonCode(Ecf5Helper.convertText(""));
    pmt.setFeeExceptionSupportingText(Ecf5Helper.convertText(""));
    pmt.setPayer(null);
    pmt.getAllowanceCharge()
        .add(
            edu.suffolk.litlab.efspserver.ecf4.PaymentFactory.makeAllowanceChargeType(
                paymentId, jurisdiction));
    pmt.setAddress(cacObjFac.createAddressType());
    pmt.setPayment(cacObjFac.createPaymentType());
    return pmt;
  }

  public static ProviderChargeType makeProviderChangeType(String paymentId, String jurisdiction) {
    var pct = tylerObjFac.createProviderChargeType();
    // TODO(brycew): refactor to not reference ECF4?
    pct.setAllowanceCharge(
        edu.suffolk.litlab.efspserver.ecf4.PaymentFactory.makeAllowanceChargeType(
            paymentId, jurisdiction));
    return pct;
  }
}
