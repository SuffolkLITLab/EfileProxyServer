package edu.suffolk.litlab.efsp.server.ecf4;

import ecf4.latest.gov.niem.niem.niem_core._2.BinaryType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.CardAccountType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.PaymentMeansType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AllowanceChargeReasonType;
import ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.AmountType;
import ecf4.latest.tyler.ecf.extensions.common.ReviewedDocumentType;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Supplier;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Builders;
import net.jqwik.api.Combinators;
import net.jqwik.api.Provide;
import net.jqwik.api.domains.DomainContextBase;

public class ReviewedFilingExamples extends DomainContextBase {

  private static final ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2
          .ObjectFactory
      commonOf =
          new ecf4.latest.oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2
              .ObjectFactory();

  private static final DatatypeFactory dateFactory = DatatypeFactory.newDefaultInstance();

  static final Supplier<Arbitrary<String>> strs = () -> Arbitraries.strings().injectNull(0.2);

  @Provide
  public Arbitrary<ReviewedDocumentType> docs() {
    return Combinators.combine(strs.get(), strs.get(), strs.get(), strs.get())
        .as(
            (str1, str2, str3, str4) -> {
              var doc = new ReviewedDocumentType();
              doc.setDocumentDescriptionText(Ecf4Helper.convertText(str1));
              doc.setDocumentBinary(new BinaryType());
              doc.getDocumentBinary().setBinaryDescriptionText(Ecf4Helper.convertText(str2));
              doc.setFilingReviewCommentsText(Ecf4Helper.convertText(str3));
              doc.setRejectReasonText(Ecf4Helper.convertText(str4));

              return doc;
            });
  }

  @Provide
  public Arbitrary<AllowanceChargeType> charges() {
    Arbitrary<String> currencyIds =
        Arbitraries.strings().withCharRange('A', 'Z').ofMinLength(2).ofMaxLength(3).injectNull(0.2);

    Arbitrary<AmountType> amounts =
        Combinators.combine(currencyIds, Arbitraries.bigDecimals())
            .as(
                (id, value) -> {
                  var amount = new AmountType();
                  amount.setCurrencyID(id);
                  amount.setValue(value);
                  return amount;
                });
    Arbitrary<String> reasons = strs.get();
    Arbitrary<List<PaymentMeansType>> means = paymentMeans().injectNull(0.2).list().ofMaxSize(3);
    return Builders.withBuilder(() -> new AllowanceChargeType())
        .use(amounts)
        .inSetter(AllowanceChargeType::setAmount)
        .use(reasons)
        .in(
            (charge, r) -> {
              var reasonType = new AllowanceChargeReasonType();
              reasonType.setLanguageID("en");
              reasonType.setValue(r);
              charge.setAllowanceChargeReason(reasonType);
              return charge;
            })
        .use(means)
        .in(
            (charge, meanList) -> {
              charge.getPaymentMeans().addAll(meanList);
              return charge;
            })
        .build();
  }

  @Provide
  public Arbitrary<PaymentMeansType> paymentMeans() {
    Arbitrary<String> cardTypes = strs.get();
    Arbitrary<String> idTypes = strs.get();
    Arbitrary<XMLGregorianCalendar> dates = dates();

    return Builders.withBuilder(() -> new CardAccountType())
        .use(cardTypes)
        .in(
            (acct, card) -> {
              var code = commonOf.createCardTypeCodeType();
              code.setValue(card);
              acct.setCardTypeCode(code);
              return acct;
            })
        .use(idTypes)
        .in(
            (acct, id) -> {
              var number = commonOf.createPrimaryAccountNumberIDType();
              number.setValue(id);
              acct.setPrimaryAccountNumberID(number);
              return acct;
            })
        .use(dates)
        .withProbability(0.5)
        .in(
            (acct, date) -> {
              var expiryDate = commonOf.createExpiryDateType();
              expiryDate.setValue(date);
              acct.setExpiryDate(expiryDate);
              return acct;
            })
        .build()
        .map(
            acct -> {
              var means = new PaymentMeansType();
              means.setCardAccount(acct);
              return means;
            });
  }

  @Provide
  private Arbitrary<XMLGregorianCalendar> dates() {
    // most dates between 1970 and 2028
    return Arbitraries.longs()
        .lessOrEqual(740842)
        .greaterOrEqual(-400_000)
        .map(LocalDate::ofEpochDay)
        .map(
            date -> {
              GregorianCalendar cal = new GregorianCalendar();
              // TODO(#47): DEFAULT TIMEZONE IS WRONG: how should LocalDate +
              // GregorianCalendar operate?
              cal.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), 0, 0, 0);
              XMLGregorianCalendar x = dateFactory.newXMLGregorianCalendar(cal);
              return x;
            });
  }
}
