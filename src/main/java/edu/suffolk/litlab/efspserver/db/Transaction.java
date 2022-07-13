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
  public String rejectedMsgTemplate;
  public String neutralMsgTemplate;
  public UUID transactionId;
  public UUID serverId;
  public String apiKeyUsed;
  public String caseType;
  public String courtId;
  public Timestamp submitted;

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
    trans.caseType = rs.getString(8);
    trans.courtId = rs.getString(9);
    trans.submitted = rs.getTimestamp(10);
    trans.acceptedMsgTemplate = rs.getString(11);
    trans.rejectedMsgTemplate = rs.getString(12);
    trans.neutralMsgTemplate = rs.getString(13);
    return trans;
  }
}
