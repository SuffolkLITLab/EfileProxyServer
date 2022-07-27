package edu.suffolk.litlab.efspserver.jeffnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.LegalIssuesTaxonomyCodes;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class FilingInformationJeffNetSerializer extends StdSerializer<FilingInformation> {

  private static final long serialVersionUID = 1L;
  private LegalIssuesTaxonomyCodes taxonomyCodes;

  protected FilingInformationJeffNetSerializer(Class<FilingInformation> t, 
      LegalIssuesTaxonomyCodes taxonomyCodes) {
    super(t);
    this.taxonomyCodes = taxonomyCodes;
  }

  @Override
  public void serialize(FilingInformation info, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    CaseInfo caseInfo = new CaseInfo();
    caseInfo.caseCourt = info.getCourtLocation();
    Set<String> ecfs = taxonomyCodes.allEcfCaseTypes(Arrays.asList(info.getCaseCategoryCode().split(", ")));
    if (ecfs.size() == 1) {
      caseInfo.caseCategory = ecfs.iterator().next();
    } else {
      caseInfo.caseCategory = info.getCaseCategoryCode();
    }
    caseInfo.caseType = info.getCaseTypeCode();
    caseInfo.caseSubtype = info.getCaseSubtypeCode();
    caseInfo.participants = new ArrayList<Person>();
    caseInfo.participants.addAll(info.getNewDefendants());
    caseInfo.participants.addAll(info.getNewPlaintiffs());

    SendingMde mde = new SendingMde();
    mde.ourUrl = ServiceHelpers.EXTERNAL_URL;

    Callback callbackObj = new Callback();
    String filingUid = UUID.randomUUID().toString();
    callbackObj.id = filingUid;
    callbackObj.callbackUrl = ServiceHelpers.REST_CALLBACK_URL.formatted("louisiana", info.getCourtLocation());

    gen.writeStartObject();
    gen.writeObjectField("SendingMDELocationID", mde);
    gen.writeObjectField("CaseInfo", caseInfo);
    gen.writeObjectField("Callback", callbackObj);
    gen.writeObjectField("FilingLeadDocument", info.getFilings().get(0));
    gen.writeEndObject();
  }

  private class CaseInfo {
    @JsonProperty("CaseCourt")
    String caseCourt;

    @JsonProperty("CaseCategoryText")
    String caseCategory;

    @JsonProperty("CaseTypeText")
    String caseType;

    @JsonProperty("CaseSubTypeText")
    String caseSubtype;

    @JsonProperty("CaseParticipants")
    List<Person> participants;
  }

  private class SendingMde {
    @JsonProperty("IdentificationID")
    String ourUrl;
  }

  private class Callback {
    @JsonProperty("Url")
    String callbackUrl;

    @JsonProperty("Id")
    String id;
  }

}
