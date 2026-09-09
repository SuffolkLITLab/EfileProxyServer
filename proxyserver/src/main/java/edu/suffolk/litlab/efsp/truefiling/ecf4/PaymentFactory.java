package edu.suffolk.litlab.efsp.truefiling.ecf4;

import edu.suffolk.litlab.efsp.model.Person;
import edu.suffolk.litlab.efsp.truefiling.Ecf4Helper;
import java.math.BigDecimal;
import java.time.LocalDate;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.PaidAmountType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;

public class PaymentFactory {
  public static PaymentMessageType makePaymentMessage(Person person) {
    var ecfObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.ObjectFactory();
    PaymentMessageType pmt = ecfObjFac.createPaymentMessageType();
    pmt.setFeeExceptionReasonCode("NOT WAIVED");
    pmt.setFeeExceptionSupportingText("");
    pmt.setPayerName(person.getName().makeFullName());
    // TODO(brycew-later): Do these need to be filled? With what?
    var cacObjFac =
        new oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.ObjectFactory();
    pmt.setAddress(cacObjFac.createAddressType());
    var paymentType = cacObjFac.createPaymentType();
    paymentType.setID(Ecf4Helper.convertEcfId("1"));
    paymentType.setPaidDate(Ecf4Helper.convertPaidDate(LocalDate.now()));
    paymentType.setPaidAmount(makePaidAmount(new BigDecimal(0)));
    paymentType.setInstructionID(Ecf4Helper.convertInstructionId("DA"));
    pmt.setPayment(paymentType);
    return pmt;
  }

  private static PaidAmountType makePaidAmount(BigDecimal amt) {
    var amount = new PaidAmountType();
    amount.setCurrencyID("USD");
    amount.setValue(amt);
    return amount;
  }
}
