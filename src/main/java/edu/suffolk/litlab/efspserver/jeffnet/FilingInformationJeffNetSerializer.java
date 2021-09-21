package edu.suffolk.litlab.efspserver.jeffnet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import edu.suffolk.litlab.efspserver.FilingInformation;
import edu.suffolk.litlab.efspserver.Person;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FilingInformationJeffNetSerializer extends StdSerializer<FilingInformation> {

  private static final long serialVersionUID = 1L;

  protected FilingInformationJeffNetSerializer(Class<FilingInformation> t) {
    super(t);
  }

  @Override
  public void serialize(FilingInformation info, JsonGenerator gen, SerializerProvider provider)
      throws IOException {
    CaseInfo caseInfo = new CaseInfo();
    caseInfo.caseCourt = info.getCourtLocation();
    caseInfo.caseCategory = info.getCaseCategory().ecfcasetype;
    caseInfo.caseType = info.getCaseType();
    caseInfo.caseSubtype = info.getCaseSubtype();
    caseInfo.participants = new ArrayList<Person>();
    caseInfo.participants.addAll(info.getDefendants());
    caseInfo.participants.addAll(info.getPlaintiffs());

    SendingMde mde = new SendingMde();
    mde.ourUrl = ServiceHelpers.BASE_URL;

    Callback callbackObj = new Callback();
    String filingUid = UUID.randomUUID().toString();
    callbackObj.id = filingUid;
    callbackObj.callbackUrl = ServiceHelpers.REST_CALLBACK_URL.formatted(info.getCourtLocation());

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
