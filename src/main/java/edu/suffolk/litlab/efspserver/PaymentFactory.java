package edu.suffolk.litlab.efspserver;

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

  public PaymentMessageType makePaymentMessage(String paymentId) {
    oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.ObjectFactory ecfObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.ObjectFactory();
    PaymentMessageType pmt = ecfObjFac.createPaymentMessageType();
    pmt.setFeeExceptionReasonCode("");
    pmt.setFeeExceptionSupportingText("");
    pmt.setPayerName("");
    pmt.getAllowanceCharge().add(makeAllowanceChargeType(paymentId, true));
    // TODO(brycew-later): Do these need to be filled? With what?
    oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory cacObjFac = 
        new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory();
    pmt.setAddress(cacObjFac.createAddressType());
    pmt.setPayment(cacObjFac.createPaymentType());
    return pmt;
  }
  
  public ProviderChargeType makeProviderChargeType(String paymentId) {
    tyler.ecf.extensions.common.ObjectFactory tylerObjFac = 
        new tyler.ecf.extensions.common.ObjectFactory();
    ProviderChargeType pct = tylerObjFac.createProviderChargeType();
    pct.getAllowanceCharge().add(makeAllowanceChargeType(paymentId, true));
    return pct;
  }
  
  private AllowanceChargeType makeAllowanceChargeType(String paymentId, boolean makeEfmCollectFeeAndTax) {
    oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory cacObjFac = 
        new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory();
    oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ObjectFactory cbcObjFac = 
        new oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ObjectFactory();
    AllowanceChargeType act = cacObjFac.createAllowanceChargeType();
    oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType at = 
        cbcObjFac.createAmountType();
    at.setCurrencyID("USD");
    // TODO(brycew-later): this is the amount that we take as a cut
    BigDecimal ourCut = new BigDecimal(0.00);
    at.setValue(ourCut); 
    act.setAmount(at);
    ChargeIndicatorType cit = cbcObjFac.createChargeIndicatorType();
    cit.setValue(makeEfmCollectFeeAndTax);
    act.setChargeIndicator(cit); 
    if (!makeEfmCollectFeeAndTax) {
      TaxCategoryType tct = cacObjFac.createTaxCategoryType();
      PercentType perc = cbcObjFac.createPercentType();
      BigDecimal taxPerc = new BigDecimal(0.0625);
      perc.setValue(taxPerc); 
      tct.setBaseUnitMeasure(cbcObjFac.createBaseUnitMeasureType()); 
      tct.setPerUnitAmount(cbcObjFac.createPerUnitAmountType()); 
      tct.setTaxExemptionReasonCode(cbcObjFac.createTaxExemptionReasonCodeType()); 
      tct.setTaxExemptionReason(cbcObjFac.createTaxExemptionReasonType());
      tct.setTierRange(cbcObjFac.createTierRangeType());
      tct.setTierRatePercent(cbcObjFac.createTierRatePercentType());
      tct.setPercent(perc);
      act.getTaxCategory().add(tct);
      TaxTotalType ttt = cacObjFac.createTaxTotalType();
      TaxAmountType tax = cbcObjFac.createTaxAmountType();
      tax.setValue(ourCut.multiply(taxPerc));
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
