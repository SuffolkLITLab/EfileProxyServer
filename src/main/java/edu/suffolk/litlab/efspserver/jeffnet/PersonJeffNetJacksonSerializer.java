package edu.suffolk.litlab.efspserver.jeffnet;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import edu.suffolk.litlab.efspserver.Person;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class PersonJeffNetJacksonSerializer extends StdSerializer<Person> {

  private static final long serialVersionUID = 1L;

  public PersonJeffNetJacksonSerializer(Class<Person> t) {
    super(t);
  }

  @Override
  public void serialize(Person per, JsonGenerator jsonGenerator,
      SerializerProvider serializerProvider) throws IOException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeObjectField("ContactInformation", per.getContactInfo());
    jsonGenerator.writeStringField("PersonName", per.getName().getFullName());
    if (per.getBirthdate().isPresent()) {
      jsonGenerator.writeStringField("PersonBirthDate",
          per.getBirthdate().get().format(DateTimeFormatter.ISO_LOCAL_DATE));
    }
    if (per.getGender().isPresent()) {
      jsonGenerator.writeStringField("Gender", per.getGender().get());
    }
    if (per.getLanguage().isPresent()) {
      jsonGenerator.writeStringField("PersonPrimaryLanguage", per.getLanguage().get());
    }
    jsonGenerator.writeStringField("CaseParticipantRoleCode", per.getRole());
    jsonGenerator.writeStringField("id", per.getIdString());
    jsonGenerator.writeEndObject();
  }
}
