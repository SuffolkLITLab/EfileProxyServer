package edu.suffolk.litlab.efsp.server.jeffnet;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import edu.suffolk.litlab.efsp.model.ContactInformation;
import java.io.IOException;

/** Gets as a json object, used to communicate mainly with Jefferson Parish. */
public class ContactInfoJeffNetJacksonSerializer extends StdSerializer<ContactInformation> {

  private static final long serialVersionUID = 1L;

  public ContactInfoJeffNetJacksonSerializer(Class<ContactInformation> t) {
    super(t);
  }

  @Override
  public void serialize(
      ContactInformation info, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    jsonGenerator.writeStartObject();
    if (info.getAddress().isPresent()) {
      jsonGenerator.writeObjectField("Address", info.getAddress().get());
    }
    if (info.getEmail().isPresent()) {
      jsonGenerator.writeStringField("ContactEmailID", info.getEmail().get());
    }
    int i = 0;
    for (String phoneNumber : info.getPhoneNumbers()) {
      if (i == 0) {
        jsonGenerator.writeStringField("PhoneNumber", phoneNumber);
      } else {
        jsonGenerator.writeStringField("PhoneNumber" + i, phoneNumber);
      }
      i += 1;
    }
    jsonGenerator.writeEndObject();
  }
}
