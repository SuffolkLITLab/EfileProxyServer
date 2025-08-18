package edu.suffolk.litlab.efsp.server.setup.tyler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

import edu.suffolk.litlab.efsp.db.UserDatabase;
import edu.suffolk.litlab.efsp.db.model.Transaction;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.server.ecf4.Ecf4Helper;
import edu.suffolk.litlab.efsp.server.ecf4.ReviewedFilingExamples;
import edu.suffolk.litlab.efsp.server.services.api.UpdateMessageStatus;
import edu.suffolk.litlab.efsp.server.utils.OrgMessageSender;
import gov.niem.niem.niem_core._2.IdentificationType;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Group;
import net.jqwik.api.Property;
import net.jqwik.api.domains.Domain;
import net.jqwik.api.lifecycle.BeforeProperty;
import net.jqwik.api.lifecycle.BeforeTry;
import oasis.names.specification.ubl.schema.xsd.commonaggregatecomponents_2.AllowanceChargeType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.FilingStatusType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.paymentmessage_4.PaymentMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.reviewfilingcallbackmessage_4.ReviewFilingCallbackMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4.NotifyFilingReviewCompleteRequestMessageType;
import org.junit.jupiter.api.DisplayName;
import tyler.ecf.extensions.common.ReviewedDocumentType;

public class OasisEcfWsCallbackTest {

  private static final gov.niem.niem.niem_core._2.ObjectFactory niemOf =
      new gov.niem.niem.niem_core._2.ObjectFactory();
  private static final oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory
      civilOf = new oasis.names.tc.legalxml_courtfiling.schema.xsd.civilcase_4.ObjectFactory();
  private static final oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory
      commonOf = new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();

  private OasisEcfWsCallback cb;
  private CodeDatabase mockCd;
  private UserDatabase mockUd;
  private OrgMessageSender mockSender;

  @BeforeProperty
  public void setUp() {
    mockCd = mock(CodeDatabase.class);
    mockUd = mock(UserDatabase.class);
  }

  @Group
  @DisplayName("`notifyFilingReviewComplete`")
  class NotifyFilingReviewCompleteTest {

    private final UUID filingId = UUID.fromString("12345678-1234-1234-1234-12345678abcd");
    private final String userEmail = "bob@example.com";
    private final String docketNumber = "2022CR0001";
    private final String repNumber = "1234567";
    private final String caseTitle = "Brown vs Brown";
    private final String courtId = "adams";

    private String sentMsg;
    private UpdateMessageStatus status;

    @BeforeTry
    public void setUp() throws SQLException {
      mockSender = mock(OrgMessageSender.class);

      cb = new OasisEcfWsCallback(() -> mockCd, () -> mockUd, mockSender);

      var trans = new Transaction();
      trans.name = "Bob Brown";
      trans.phoneNumber = Optional.empty();
      trans.email = userEmail;
      trans.transactionId = filingId;
      trans.courtId = courtId;
      trans.caseTitle = caseTitle;
      trans.serverId = UUID.randomUUID();
      when(mockUd.findTransaction(eq(filingId))).thenReturn(Optional.of(trans));

      var courtInfo = new CourtLocationInfo();
      courtInfo.code = courtId;
      courtInfo.name = "Adams County";
      courtInfo.showreturnonreject = false;
      when(mockCd.getFullLocationInfo(eq(courtId))).thenReturn(Optional.of(courtInfo));
      when(mockSender.sendMessage(
              any(),
              any(),
              nullable(String.class),
              nullable(String.class),
              nullable(String.class),
              nullable(String.class),
              nullable(String.class)))
          .thenReturn(true);
    }

    @Example
    public void testFailedShouldNotSendEmail() throws SQLException {
      // Just make sure we don't throw exceptions
      cb.notifyFilingReviewComplete(null);
      cb.notifyFilingReviewComplete(new NotifyFilingReviewCompleteRequestMessageType());
      cb.notifyFilingReviewComplete(makeNullIdMsg());

      when(mockCd.getFullLocationInfo(eq(courtId))).thenReturn(Optional.empty());
      cb.notifyFilingReviewComplete(makeMsg(null, null));

      when(mockUd.findTransaction(eq(filingId))).thenReturn(Optional.empty());
      cb.notifyFilingReviewComplete(makeMsg(null, null));

      verifyNoInteractions(mockSender);
    }

    @Example
    public void testSuccessfulPlain() {
      when(mockSender.sendMessage(
              any(),
              any(),
              nullable(String.class),
              nullable(String.class),
              nullable(String.class),
              nullable(String.class),
              nullable(String.class)))
          .thenAnswer(
              (invoc) -> {
                status = invoc.getArgument(1, UpdateMessageStatus.class);
                sentMsg = invoc.getArgument(3, String.class);
                return true;
              });

      cb.notifyFilingReviewComplete(makeMsg(null, null));

      assertThat(sentMsg).isEqualTo("\nfiling has been accepted by the court");
      assertThat(status).isEqualTo(UpdateMessageStatus.ACCEPTED);
    }

    @Property
    @Domain(ReviewedFilingExamples.class)
    public void testSuccessfulResponse(
        @ForAll AllowanceChargeType charge, @ForAll ReviewedDocumentType doc) {
      cb.notifyFilingReviewComplete(makeMsg(charge, doc));

      verify(mockSender)
          .sendMessage(
              any(),
              any(),
              nullable(String.class),
              nullable(String.class),
              nullable(String.class),
              nullable(String.class),
              nullable(String.class));
    }

    // TODO: add a J case aug
    private NotifyFilingReviewCompleteRequestMessageType makeMsg(
        AllowanceChargeType charge, ReviewedDocumentType doc) {
      var msg = new NotifyFilingReviewCompleteRequestMessageType();
      msg.setReviewFilingCallbackMessage(makeMsgType(doc));
      var paymentMsg = new PaymentMessageType();
      paymentMsg.getAllowanceCharge().add(charge);
      msg.setPaymentReceiptMessage(paymentMsg);
      return msg;
    }

    private NotifyFilingReviewCompleteRequestMessageType makeNullIdMsg() {
      var msg = new NotifyFilingReviewCompleteRequestMessageType();
      var rev = new ReviewFilingCallbackMessageType();
      rev.setDocumentFiledDate(Ecf4Helper.convertDate(LocalDate.of(2025, 07, 04)));
      rev.getDocumentIdentification().add(null);
      msg.setReviewFilingCallbackMessage(rev);
      var paymentMsg = new PaymentMessageType();
      paymentMsg.getAllowanceCharge().add(null);
      msg.setPaymentReceiptMessage(paymentMsg);
      return msg;
    }

    private ReviewFilingCallbackMessageType makeMsgType(ReviewedDocumentType doc) {
      var msg = new ReviewFilingCallbackMessageType();
      msg.setDocumentFiledDate(Ecf4Helper.convertDate(LocalDate.of(2025, 07, 04)));
      var idType = new IdentificationType();
      idType.setIdentificationID(Ecf4Helper.convertString(filingId.toString()));
      idType.setIdentificationCategory(
          niemOf.createIdentificationCategoryText(Ecf4Helper.convertText("FILINGID")));
      msg.getDocumentIdentification().add(idType);

      msg.setReviewedLeadDocument(commonOf.createReviewedLeadDocument(doc));
      // TODO: connected too?

      var sendingLocation = new IdentificationType();
      sendingLocation.setIdentificationID(Ecf4Helper.convertString("http://filingreviewmde.com"));
      msg.setSendingMDELocationID(sendingLocation);

      var civilCase = civilOf.createCivilCaseType();
      civilCase.setCaseTrackingID(Ecf4Helper.convertString(repNumber));
      civilCase.setCaseDocketID(Ecf4Helper.convertString(docketNumber));
      civilCase.setCaseTitleText(Ecf4Helper.convertText("Brown vs Brown"));
      civilCase.setCaseCategoryText(Ecf4Helper.convertText("1234"));
      msg.setCase(civilOf.createCivilCase(civilCase));

      var filingStatus = new FilingStatusType();
      filingStatus.setFilingStatusCode("accepted");
      filingStatus
          .getStatusDescriptionText()
          .add(Ecf4Helper.convertText("filing has been accepted by the court"));
      msg.setFilingStatus(filingStatus);

      return msg;
    }
  }
}
