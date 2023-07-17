package edu.suffolk.litlab.efspserver.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

public class Transaction {

  public String name;
  public UUID filingPartyId;
  public Optional<String> phoneNumber;
  public String email;
  public String acceptedMsgTemplate;
  public String acceptedMsgSubject;
  public String rejectedMsgTemplate;
  public String rejectedMsgSubject;
  public String neutralMsgTemplate;
  public String neutralMsgSubject;
  public UUID transactionId;
  public UUID serverId;
  public String apiKeyUsed;
  public String caseTypeName;
  public String courtId;
  public Timestamp submitted;
  public String caseTitle;
  public String envelopeId;

  public static final String query =
      """
        SELECT name, user_id, phone_number, email, transaction_id, server_id,
            api_key_used, casetype, court_id, submitted, accepted_msg_template,
            accepted_msg_subject, rejected_msg_template, rejected_msg_subject,
            neutral_msg_template, neutral_msg_subject, case_title, envelope_id
        FROM submitted_filings
        WHERE transaction_id = ?""";

  public static Transaction fromResults(ResultSet rs) throws SQLException {
    Transaction trans = new Transaction();
    trans.name = rs.getString(1);
    trans.filingPartyId = (UUID) rs.getObject(2);
    if (rs.getString(3) == null) {
      trans.phoneNumber = Optional.empty();
    } else {
      trans.phoneNumber = Optional.of(rs.getString(3));
    }
    trans.email = rs.getString(4);
    trans.transactionId = (UUID) rs.getObject(5);
    trans.serverId = (UUID) rs.getObject(6);
    trans.apiKeyUsed = rs.getString(7);
    trans.caseTypeName = rs.getString(8);
    trans.courtId = rs.getString(9);
    trans.submitted = rs.getTimestamp(10);
    trans.acceptedMsgTemplate = rs.getString(11);
    trans.acceptedMsgSubject = rs.getString(12);
    trans.rejectedMsgTemplate = rs.getString(13);
    trans.rejectedMsgSubject = rs.getString(14);
    trans.neutralMsgTemplate = rs.getString(15);
    trans.neutralMsgSubject = rs.getString(16);
    trans.caseTitle = rs.getString(17);
    trans.envelopeId = rs.getString(18);
    return trans;
  }
}
