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
    var newAuth = Conversion.convert(tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType.class, oldAuth);
    assertThat(newAuth.getEmail()).isEqualTo(oldAuth.getEmail());
  }

  @Test
  public void allRequests() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    ArrayList<Class<?>> v2022_classes = new ArrayList<>();
    v2022_classes.add(tyler.efm.v2022_1.services.schema.authenticaterequest.AuthenticateRequestType.class);
    v2022_classes.add(tyler.efm.v2022_1.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType.class);
    v2022_classes.add(tyler.efm.v2022_1.services.schema.registrationrequest.RegistrationRequestType.class);
    v2022_classes.add(tyler.efm.v2022_1.services.schema.registrationresponse.RegistrationResponseType.class);
    ArrayList<Class<?>> v2025_classes = new ArrayList<>();
    v2025_classes.add(tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType.class);
    v2025_classes.add(tyler.efm.latest.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType.class);
    v2025_classes.add(tyler.efm.latest.services.schema.registrationrequest.RegistrationRequestType.class);
    v2025_classes.add(tyler.efm.latest.services.schema.registrationresponse.RegistrationResponseType.class);
    for (int i = 0; i < v2022_classes.size(); i++ ) {
      var oldObj = v2022_classes.get(i).getDeclaredConstructor().newInstance();
      var newObj = Conversion.convert(v2025_classes.get(i), oldObj);
      var replacementObj = Conversion.convert(v2022_classes.get(i), newObj);
      assertThat(EqualsBuilder.reflectionEquals(oldObj, replacementObj)).isTrue();
    }
  }

  @Test
  public void allEnums() {
    var oldReg = tyler.efm.v2022_1.services.schema.common.RegistrationType.FIRM_ADMINISTRATOR;
    var newReg = Conversion.convert(tyler.efm.latest.services.schema.common.RegistrationType.class, oldReg);
    assertThat(newReg.value()).isEqualTo(oldReg.value());
  }
}
