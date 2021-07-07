package edu.suffolk.litlab.efspserver;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

public class Transaction {

  String name;
  UUID filingPartyId;
  Optional<String> phoneNumber;
  String email;
  UUID transactionId;
  String caseType;
  Timestamp submitted;
}
