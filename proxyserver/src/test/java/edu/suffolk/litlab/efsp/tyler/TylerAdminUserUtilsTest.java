package edu.suffolk.litlab.efsp.tyler;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import edu.suffolk.litlab.efsp.model.Person;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import tyler.efm.latest.services.schema.common.ErrorType;
import tyler.efm.latest.services.schema.common.UserType;
import tyler.efm.latest.services.schema.getuserresponse.GetUserResponseType;

public class TylerAdminUserUtilsTest {
  private static MockedStatic<TylerClients> mockClients;
  private static TylerUserClient tylerUserClient;

  @BeforeAll
  public static void init() {
    tylerUserClient = mock(TylerUserClient.class);
    TylerUserFactory userFactory = mock(TylerUserFactory.class);
    when(userFactory.makeUserClient(any())).thenReturn(tylerUserClient);

    mockClients = Mockito.mockStatic(TylerClients.class);
    mockClients
        .when(() -> TylerClients.getEfmUserFactory(any()))
        .thenReturn(Optional.of(userFactory));
  }

  @AfterAll
  public static void deinit() {
    mockClients.close();
  }

  @Test
  public void canParseToPerson() {
    GetUserResponseType soapResp = new GetUserResponseType();
    var user = new UserType();
    user.setEmail("bob@example.com");
    user.setFirstName("Bob");
    user.setLastName("Jones");
    soapResp.setUser(user);
    var err = new ErrorType();
    err.setErrorCode("0");
    soapResp.setError(err);
    when(tylerUserClient.getUser(any())).thenReturn(soapResp);

    Person person = TylerAdminUserUtils.getUser(tylerUserClient, "abc123");
    assertThat(person.getContactInfo().getEmail()).contains("bob@example.com");
    assertThat(person.getName().getFullName()).isEqualTo("Bob Jones");
  }

  @Test
  public void canParseNoPerson() {
    GetUserResponseType soapResp = new GetUserResponseType();
    var err = new ErrorType();
    err.setErrorCode("1");
    soapResp.setError(err);
    when(tylerUserClient.getUser(any())).thenReturn(soapResp);

    Person person = TylerAdminUserUtils.getUser(tylerUserClient, "abc123");
    assertThat(person.getContactInfo().getEmail()).isEmpty();
    assertThat(person.getName().getFullName()).isEqualTo("");
  }
}
