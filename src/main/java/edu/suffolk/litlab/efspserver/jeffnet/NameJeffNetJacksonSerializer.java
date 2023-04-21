package edu.suffolk.litlab.efspserver.jeffnet;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import edu.suffolk.litlab.efspserver.Name;
import java.io.IOException;

public class NameJeffNetJacksonSerializer extends StdSerializer<Name> {

  private static final long serialVersionUID = 1L;

  public NameJeffNetJacksonSerializer(Class<Name> t) {
    super(t);
  }

  @Override
  public void serialize(
      Name name, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
      throws IOException {
    jsonGenerator.writeString(name.getFullName());
  }
}
