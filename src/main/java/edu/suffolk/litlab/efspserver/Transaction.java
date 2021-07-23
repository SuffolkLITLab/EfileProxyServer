package edu.suffolk.litlab.efspserver;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

public class Transaction {

  public String name;
  public UUID filingPartyId;
  public Optional<String> phoneNumber;
  public String email;
  public UUID transactionId;
  public String apiKeyUsed;
  public String caseType;
  public String courtId;
  public Timestamp submitted;
}
