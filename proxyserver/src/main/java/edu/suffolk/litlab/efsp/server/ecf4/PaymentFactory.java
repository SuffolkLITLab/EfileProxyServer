package edu.suffolk.litlab.efsp.server.ecf4;

import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeIndicatorType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentIDType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import ecf4.latest.tyler.ecf.extensions.common.ProviderChargeType;
import edu.suffolk.litlab.efsp.Jurisdiction;
import java.math.BigDecimal;

public class PaymentFactory {
  public static PaymentMessageType makePaymentMessage(String paymentId, Jurisdiction jurisdiction) {
    var ecfObjFac =
        new ecf4.latest.oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4
            .ObjectFactory();
    PaymentMessageType pmt = ecfObjFac.createPaymentMessageType();
    pmt.setFeeExceptionReasonCode("");
    pmt.setFeeExceptionSupportingText("");
    pmt.setPayerName("");
    pmt.getAllowanceCharge().add(makeAllowanceChargeType(paymentId, jurisdiction));
    // TODO(brycew-later): Do these need to be filled? With what?
    var cacObjFac =
        new ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2
            .ObjectFactory();
    pmt.setAddress(cacObjFac.createAddressType());
    pmt.setPayment(cacObjFac.createPaymentType());
    return pmt;
  }

  public static ProviderChargeType makeProviderChargeType(
      String paymentId, Jurisdiction jurisdiction) {
    ecf4.latest.tyler.ecf.extensions.common.ObjectFactory tylerObjFac =
        new ecf4.latest.tyler.ecf.extensions.common.ObjectFactory();
    ProviderChargeType pct = tylerObjFac.createProviderChargeType();
    pct.getAllowanceCharge().add(makeAllowanceChargeType(paymentId, jurisdiction));
    return pct;
  }

  private static AllowanceChargeType makeAllowanceChargeType(
      String paymentId, Jurisdiction jurisdiction) {
    var cacObjFac =
        new ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2
            .ObjectFactory();
    var cbcObjFac =
        new ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2
            .ObjectFactory();
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
      // tct.setTaxExemptionReasonCode(cbcObjFac.createTaxExemptionReasonType());
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
