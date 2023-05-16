package edu.suffolk.litlab.efspserver.ecf5;

import edu.suffolk.litlab.efspserver.tyler.TylerConstants;
import https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.PaymentMessageType;
import java.math.BigDecimal;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxCategoryType;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.TaxTotalType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ChargeIndicatorType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaymentIDType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PercentType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.TaxAmountType;
import tyler.ecf.v5_0.extensions.common.ProviderChargeType;

public class PaymentFactory {

  private static final https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.ObjectFactory
      ecfObjFac =
          new https.docs_oasis_open_org.legalxml_courtfiling.ns.v5_0.payment.ObjectFactory();
  private static final gov.niem.release.niem.niem_core._4.ObjectFactory niemObjFac =
      new gov.niem.release.niem.niem_core._4.ObjectFactory();
  private static final oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2
          .ObjectFactory
      cacObjFac =
          new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory();
  private static final oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2
          .ObjectFactory
      cbcObjFac =
          new oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ObjectFactory();
  private static final tyler.ecf.v5_0.extensions.common.ObjectFactory tylerObjFac =
      new tyler.ecf.v5_0.extensions.common.ObjectFactory();

  public static PaymentMessageType makePaymentMessage(String paymentId, String jurisdiction) {
    PaymentMessageType pmt = ecfObjFac.createPaymentMessageType();
    pmt.setCorrectedPaymentIndicator(Ecf5Helper.convertBool(false));
    // pmt.setFeeExceptionReasonCode(Ecf5Helper.convertText(""));
    // pmt.setFeeExceptionSupportingText(Ecf5Helper.convertText(""));
    pmt.setPayer(null);
    pmt.getAllowanceCharge()
        .add(
            edu.suffolk.litlab.efspserver.ecf4.PaymentFactory.makeAllowanceChargeType(
                paymentId, jurisdiction));
    pmt.setAddress(cacObjFac.createAddressType());
    pmt.setPayment(cacObjFac.createPaymentType());
    pmt.setPayer(niemObjFac.createEntityType());
    return pmt;
  }

  public static ProviderChargeType makeProviderChangeType(String paymentId, String jurisdiction) {
    var pct = tylerObjFac.createProviderChargeType();
    pct.setAllowanceCharge(makeAllowanceChargeType(paymentId, jurisdiction));
    return pct;
  }

  public static AllowanceChargeType makeAllowanceChargeType(String paymentId, String jurisdiction) {
    AllowanceChargeType act = cacObjFac.createAllowanceChargeType();
    var at = cbcObjFac.createAmountType();
    at.setCurrencyID("USD");
    at.setValue(TylerConstants.ourCut);
    act.setAmount(at);
    ChargeIndicatorType cit = cbcObjFac.createChargeIndicatorType();
    // BigDecimal.equals is weird about "scale" (i.e. 2.00 != 2.0), so we need to use compareTo.
    // https://docs.oracle.com/javase/7/docs/api/java/math/BigDecimal.html#equals(java.lang.Object)
    boolean makeEfmCollectFeeAndTax =
        true; // (TylerConstants.ourCut.compareTo(BigDecimal.ZERO) > 0);
    cit.setValue(makeEfmCollectFeeAndTax);
    act.setChargeIndicator(cit);
    if (makeEfmCollectFeeAndTax) {
      PercentType perc = cbcObjFac.createPercentType();
      BigDecimal taxPercent = TylerConstants.jurisdictionToTax.get(jurisdiction);
      perc.setValue(taxPercent);
      TaxCategoryType tct = cacObjFac.createTaxCategoryType();
      tct.setPercent(perc);
      // tct.setBaseUnitMeasure(cbcObjFac.createBaseUnitMeasureType());
      // tct.setPerUnitAmount(cbcObjFac.createPerUnitAmountType());
      // tct.setTaxExemptionReasonCode(cbcObjFac.createTaxExemptionReasonCodeType());
      // tct.setTierRange(cbcObjFac.createTierRangeType());
      // tct.setTierRatePercent(cbcObjFac.createTierRatePercentType());
      tct.setTaxScheme(cacObjFac.createTaxSchemeType());
      act.getTaxCategory().add(tct);
      TaxAmountType tax = cbcObjFac.createTaxAmountType();
      var finalAmt = TylerConstants.ourCut.multiply(taxPercent);
      tax.setValue(finalAmt);
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
