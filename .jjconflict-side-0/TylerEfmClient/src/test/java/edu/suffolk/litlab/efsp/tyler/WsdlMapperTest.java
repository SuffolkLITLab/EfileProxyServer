package edu.suffolk.litlab.efsp.tyler;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.xml.bind.JAXBElement;
import java.lang.reflect.InvocationTargetException;
import javax.xml.namespace.QName;
import org.junit.jupiter.api.Test;

public class WsdlMapperTest {

  private WsdlMapper mapper = new WsdlMapperImpl();

  @Test
  public void testAuth() {
    var newAuth =
        new tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType();
    newAuth.setEmail("idk@idk.com");
    var oldAuth = mapper.toV2022(newAuth);
    assertThat(newAuth.getEmail()).isEqualTo(oldAuth.getEmail());
  }

  @Test
  public void allRequests()
      throws InstantiationException,
          IllegalAccessException,
          IllegalArgumentException,
          InvocationTargetException,
          NoSuchMethodException,
          SecurityException {
    {
      var newObj =
          new tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType();
      newObj.setEmail("test3@example.com");
      var oldObj = mapper.toV2022(newObj);
      assertThat(newObj.getEmail()).isEqualTo(oldObj.getEmail());
    }
    {
      var newObj =
          new tyler.efm.latest.services.schema.updatenotificationpreferencesrequest
              .UpdateNotificationPreferencesRequestType();
      var notifyType = new tyler.efm.latest.services.schema.common.NotificationType();
      notifyType.setCode("Wow a code");
      newObj.getNotification().add(notifyType);
      var oldObj = mapper.toV2022(newObj);
      assertThat(newObj.getNotification()).hasSize(oldObj.getNotification().size());
      assertThat(newObj.getNotification().get(0).getCode()).isEqualTo("Wow a code");
    }
    {
      var newObj =
          new tyler.efm.latest.services.schema.registrationrequest.RegistrationRequestType();
      newObj.setCity("Boston");
      var oldObj = mapper.toV2022(newObj);
      assertThat(newObj.getCity()).isEqualTo(oldObj.getCity());
    }
    {
      var oldObj =
          new tyler.efm.v2022_1.services.schema.registrationresponse.RegistrationResponseType();
      oldObj.setFirmID("abc-123");
      var newObj = mapper.toLatest(oldObj);
      assertThat(newObj.getFirmID()).isEqualTo(oldObj.getFirmID());
    }
  }

  @Test
  public void allEnums() {
    var oldReg = tyler.efm.v2022_1.services.schema.common.RegistrationType.FIRM_ADMINISTRATOR;
    var newReg = mapper.toLatest(oldReg);
    assertThat(newReg.value()).isEqualTo(oldReg.value());
  }

  @Test
  public void testPaymentAccountTypeList() {
    var oldResp =
        new tyler.efm.v2022_1.services.schema.paymentaccounttypelistresponse
            .PaymentAccountTypeListResponseType();
    var oldType = new tyler.efm.v2022_1.services.schema.common.PaymentAccountTypeType();
    oldType.setCode("Wow");
    var codeId = new JAXBElement<Integer>(new QName("idk"), Integer.class, 67);
    oldType.setCodeId(codeId);
    oldType.setDescription("A test code");
    oldResp.getPaymentAccountType().add(oldType);

    var newResp = mapper.toLatest(oldResp);
    assertThat(newResp.getPaymentAccountType()).hasSize(1);
    assertThat(newResp.getPaymentAccountType().get(0).getDescription()).isEqualTo("A test code");
    assertThat(newResp.getPaymentAccountType().get(0).getCodeId().getValue()).isEqualTo(67);
  }

  @Test
  public void testNewUser() {
    var oldType = new tyler.efm.v2022_1.services.schema.common.UserType();
    oldType.setEmail("test2@example.com");
    oldType.setFirstName("Bobbert");
    var roleLoc = new tyler.efm.v2022_1.services.schema.common.RoleLocationType();
    roleLoc.setLocation("Boston");
    roleLoc.setRoleName(tyler.efm.v2022_1.services.schema.common.RoleType.FIRM_ADMIN);
    oldType.getRole().add(roleLoc);

    var newType = mapper.toLatest(oldType);
    assertThat(newType.getEmail()).isEqualTo("test2@example.com");
    assertThat(newType.getFirstName()).isEqualTo("Bobbert");
    assertThat(newType.getRole()).hasSize(1);
    assertThat(newType.getRole().get(0).getRoleName())
        .isEqualTo(tyler.efm.latest.services.schema.common.RoleType.FIRM_ADMIN);
  }

  @Test
  public void testSomeOtherList() {
    var oldResp =
        new tyler.efm.v2022_1.services.schema.paymentaccountlistresponse
            .PaymentAccountListResponseType();
    var oldType = new tyler.efm.v2022_1.services.schema.common.PaymentAccountType();
    oldType.setAccountName("The Account Name");
    oldType.setCardLast4("1234");
    oldResp.getPaymentAccount().add(oldType);

    var mapper = new WsdlMapperImpl();
    var newResp = mapper.toLatest(oldResp);
    assertThat(newResp.getPaymentAccount()).hasSize(1);
    assertThat(newResp.getPaymentAccount().get(0).getCardLast4()).isEqualTo("1234");
  }

  @Test
  public void testJaxElements() {
    var oldType =
        new tyler.efm.v2022_1.services.schema.attorneylistresponse.AttorneyListResponseType();
    var errorType = new tyler.efm.v2022_1.services.schema.common.ErrorType();
    errorType.setErrorCode("error:123");
    oldType.setError(errorType);
    var attorney = new tyler.efm.v2022_1.services.schema.common.AttorneyType();
    attorney.setAttorneyID("456-def");
    attorney.setBarNumber("56rac");
    oldType.getAttorney().add(attorney);

    var newType = mapper.toLatest(oldType);
    assertThat(newType.getError().getErrorCode()).isEqualTo("error:123");
    assertThat(newType.getAttorney()).hasSize(1);
    assertThat(newType.getAttorney().get(0).getBarNumber()).isEqualTo("56rac");
  }
}
