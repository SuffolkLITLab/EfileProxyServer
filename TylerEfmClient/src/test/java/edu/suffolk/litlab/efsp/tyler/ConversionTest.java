package edu.suffolk.litlab.efsp.tyler;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;

public class ConversionTest {
  @Test
  public void testAuth() {
    var oldAuth = new tyler.efm.v2022_1.services.schema.authenticaterequest.AuthenticateRequestType();
    oldAuth.setEmail("idk@idk.com");
    var newAuth = new tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType();
    Conversion.convert(newAuth, oldAuth);
    assertThat(oldAuth.getEmail()).isEqualTo(newAuth.getEmail());
  }

  @Test
  public void allRequets() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    ArrayList<Class<?>> v2022_classes = new ArrayList<>();
    v2022_classes.add(tyler.efm.v2022_1.services.schema.authenticaterequest.AuthenticateRequestType.class);
    v2022_classes.add(tyler.efm.v2022_1.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType.class);
    ArrayList<Class<?>> v2025_classes = new ArrayList<>();
    v2025_classes.add(tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType.class);
    v2025_classes.add(tyler.efm.latest.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType.class);
    for (int i = 0; i < v2022_classes.size(); i++ ) {
      var newObj = v2025_classes.get(i).getDeclaredConstructor().newInstance();
      var oldObj = v2022_classes.get(i).getDeclaredConstructor().newInstance();
      var replacementObj = v2022_classes.get(i).getDeclaredConstructor().newInstance();
      newObj = Conversion.convert(newObj, oldObj);
      replacementObj = Conversion.convert(replacementObj, newObj);
      assertThat(EqualsBuilder.reflectionEquals(oldObj, replacementObj)).isTrue();
    }
  }
}
