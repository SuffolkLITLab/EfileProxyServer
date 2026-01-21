package edu.suffolk.litlab.efsp.tyler;

import static edu.suffolk.litlab.efsp.tyler.TylerVersion.v2022_1;

import jakarta.xml.ws.BindingProvider;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tyler.efm.EfmUserService;
import tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.latest.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.latest.services.schema.baseresponse.BaseResponseType;
import tyler.efm.latest.services.schema.changepasswordrequest.ChangePasswordRequestType;
import tyler.efm.latest.services.schema.changepasswordresponse.ChangePasswordResponseType;
import tyler.efm.latest.services.schema.getpasswordquestionrequest.GetPasswordQuestionRequestType;
import tyler.efm.latest.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.latest.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.latest.services.schema.notificationpreferencesresponse.NotificationPreferencesResponseType;
import tyler.efm.latest.services.schema.passwordquestionresponse.PasswordQuestionResponseType;
import tyler.efm.latest.services.schema.resetpasswordrequest.ResetPasswordRequestType;
import tyler.efm.latest.services.schema.resetpasswordresponse.ResetPasswordResponseType;
import tyler.efm.latest.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType;
import tyler.efm.latest.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType;
import tyler.efm.latest.services.schema.updateuserrequest.UpdateUserRequestType;
import tyler.efm.latest.services.schema.updateuserresponse.UpdateUserResponseType;

public class TylerUserClient {
  public static final Logger log = LoggerFactory.getLogger(TylerUserClient.class);

  private final tyler.efm.latest.services.IEfmUserService latestPort;
  private final tyler.efm.v2022_1.services.IEfmUserService v2022Port;
  private final TylerVersion version;

  private static final WsdlMapper mapper = new WsdlMapperImpl();

  public TylerUserClient(
      EfmUserService factory, TylerVersion version, Consumer<BindingProvider> setup) {
    this.version = version;
    switch (version) {
      case v2022_1:
        this.latestPort = null;
        this.v2022Port = factory.getBasicHttpBindingV2022IEfmUserService();
        setup.accept((BindingProvider) v2022Port);
        break;
      case v2024_6:
        this.latestPort = factory.getBasicHttpBindingIEfmUserService();
        this.v2022Port = null;
        setup.accept((BindingProvider) latestPort);
        break;
      case v2025_0:
        this.latestPort = factory.getBasicHttpBindingIEfmUserService();
        this.v2022Port = null;
        setup.accept((BindingProvider) latestPort);
        break;
      default:
        this.latestPort = null;
        this.v2022Port = null;
        break;
    }
    ;
  }

  public AuthenticateResponseType authenticateUser(AuthenticateRequestType authenticateRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.authenticateUser(mapper.toV2022(authenticateRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.authenticateUser(authenticateRequest);
    }
  }

  public UpdateUserResponseType updateUser(UpdateUserRequestType updateUserRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.updateUser(mapper.toV2022(updateUserRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.updateUser(updateUserRequest);
    }
  }

  public NotificationPreferencesResponseType getNotificationPreferences() {
    if (version == v2022_1) {
      return mapper.toLatest(v2022Port.getNotificationPreferences());
    } else {
      return latestPort.getNotificationPreferences();
    }
  }

  public GetUserResponseType getUser(GetUserRequestType getUserRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getUser(mapper.toV2022(getUserRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.getUser(getUserRequest);
    }
  }

  public BaseResponseType selfResendActivationEmail(
      SelfResendActivationEmailRequestType selfResendActivationEmailRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.selfResendActivationEmail(mapper.toV2022(selfResendActivationEmailRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.selfResendActivationEmail(selfResendActivationEmailRequest);
    }
  }

  public ResetPasswordResponseType resetPassword(ResetPasswordRequestType resetPasswordRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.resetPassword(mapper.toV2022(resetPasswordRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.resetPassword(resetPasswordRequest);
    }
  }

  public PasswordQuestionResponseType getPasswordQuestion(
      GetPasswordQuestionRequestType getPasswordQuestionRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.getPasswordQuestion(mapper.toV2022(getPasswordQuestionRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.getPasswordQuestion(getPasswordQuestionRequest);
    }
  }

  public ChangePasswordResponseType changePassword(
      ChangePasswordRequestType changePasswordRequest) {
    if (version == v2022_1) {
      var resp = v2022Port.changePassword(mapper.toV2022(changePasswordRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.changePassword(changePasswordRequest);
    }
  }

  public BaseResponseType updateNotificationPreferences(
      UpdateNotificationPreferencesRequestType updateNotificationPreferencesRequest) {
    if (version == v2022_1) {
      var resp =
          v2022Port.updateNotificationPreferences(
              mapper.toV2022(updateNotificationPreferencesRequest));
      return mapper.toLatest(resp);
    } else {
      return latestPort.updateNotificationPreferences(updateNotificationPreferencesRequest);
    }
  }
}
