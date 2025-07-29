package edu.suffolk.litlab.efsp.server.ecf4;

import java.math.BigDecimal;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import tyler.ecf.extensions.common.ProviderChargeType;

public class PaymentFactory {
  public static PaymentMessageType makePaymentMessage(String paymentId, String jurisdiction) {
    var ecfObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.ObjectFactory();
    PaymentMessageType pmt = ecfObjFac.createPaymentMessageType();
    pmt.setFeeExceptionReasonCode("");
    pmt.setFeeExceptionSupportingText("");
    pmt.setPayerName("");
    pmt.getAllowanceCharge().add(makeAllowanceChargeType(paymentId, jurisdiction));
    // TODO(brycew-later): Do these need to be filled? With what?
    var cacObjFac =
        new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory();
    pmt.setAddress(cacObjFac.createAddressType());
    pmt.setPayment(cacObjFac.createPaymentType());
    return pmt;
  }

  public static ProviderChargeType makeProviderChargeType(String paymentId, String jurisdiction) {
    tyler.ecf.extensions.common.ObjectFactory tylerObjFac =
        new tyler.ecf.extensions.common.ObjectFactory();
    ProviderChargeType pct = tylerObjFac.createProviderChargeType();
    pct.getAllowanceCharge().add(makeAllowanceChargeType(paymentId, jurisdiction));
    return pct;
  }

  private static AllowanceChargeType makeAllowanceChargeType(
      String paymentId, String jurisdiction) {
    var cacObjFac =
        new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory();
    var cbcObjFac =
        new oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ObjectFactory();
    AllowanceChargeType act = cacObjFac.createAllowanceChargeType();
    var at = cbcObjFac.createAmountType();
    at.setCurrencyID("USD");
    at.setValue(TylerConstants.ourCut);
    act.setAmount(at);
    ChargeIndicatorType cit = cbcObjFac.createChargeIndicatorType();
    // BigDecimal.equals is weird about "scale" (i.e. 2.00 != 2.0), so we need to use compareTo.
    // https://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html#equals(java.lang.Object)
    boolean makeEfmCollectFeeAndTax = (TylerConstants.ourCut.compareTo(BigDecimal.ZERO) > 0);
    cit.setValue(makeEfmCollectFeeAndTax);
    act.setChargeIndicator(cit);
    if (makeEfmCollectFeeAndTax) {
      PercentType perc = cbcObjFac.createPercentType();
      BigDecimal taxPercent = TylerConstants.jurisdictionToTax.get(jurisdiction);
      perc.setValue(taxPercent);
      TaxCategoryType tct = cacObjFac.createTaxCategoryType();
      tct.setPercent(perc);
      tct.setBaseUnitMeasure(cbcObjFac.createBaseUnitMeasureType());
      tct.setPerUnitAmount(cbcObjFac.createPerUnitAmountType());
      tct.setTaxExemptionReasonCode(cbcObjFac.createTaxExemptionReasonCodeType());
      tct.setTaxExemptionReason(cbcObjFac.createTaxExemptionReasonType());
      tct.setTierRange(cbcObjFac.createTierRangeType());
      tct.setTierRatePercent(cbcObjFac.createTierRatePercentType());
      act.getTaxCategory().add(tct);
      TaxAmountType tax = cbcObjFac.createTaxAmountType();
      tax.setValue(TylerConstants.ourCut.multiply(taxPercent));
      TaxTotalType ttt = cacObjFac.createTaxTotalType();
      ttt.setTaxAmount(tax);
      act.setTaxTotal(ttt);
    }
    PaymentMeansType pmt = cacObjFac.createPaymentMeansType();
    PaymentIDType pit = cbcObjFac.createPaymentIDType();
    pit.setValue(paymentId);
    pmt.getPaymentID().add(pit);
    pmt.setPaymentMeansCode(cbcObjFac.createPaymentMeansCodeType());
    act.getPaymentMeans().add(pmt);
    return act;
  }
}
