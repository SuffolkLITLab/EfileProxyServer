package edu.suffolk.litlab.efsp.tyler;

import tyler.efm.IEfmUserService;
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

  private IEfmUserService userPort;
  private TylerVersion version;

  public TylerUserClient(IEfmUserService port, TylerVersion version) {
    this.userPort = port;
    this.version = version;
  }

  public AuthenticateResponseType authenticateUser(AuthenticateRequestType authenticateRequest) {
    return userPort.authenticateUser(authenticateRequest);
  }

  public UpdateUserResponseType updateUser(UpdateUserRequestType updateUserRequest) {
    if (version.equals(TylerVersion.v2022_1)) {
      var user = Conversion.downgrade(updateUserRequest.getUser());
      var verUpdateUserRequest =
          new tyler.efm.v2022_1.services.schema.updateuserrequest.UpdateUserRequestType();
      verUpdateUserRequest.setUser(user);
      return userPort.updateUser(verUpdateUserRequest);
    } else {
      return userPort.updateUser(updateUserRequest);
    }
  }

  public UpdateUserResponseType updateUser(
      tyler.efm.v2022_1.services.schema.updateuserrequest.UpdateUserRequestType updateUserRequest) {
    return userPort.updateUser(updateUserRequest);
  }

  public NotificationPreferencesResponseType getNotificationPreferences() {
    return userPort.getNotificationPreferences();
  }

  public GetUserResponseType getUser(GetUserRequestType getUserRequest) {
    return userPort.getUser(getUserRequest);
  }

  public BaseResponseType selfResendActivationEmail(
      SelfResendActivationEmailRequestType selfResendActivationEmailRequest) {
    return userPort.selfResendActivationEmail(selfResendActivationEmailRequest);
  }

  public ResetPasswordResponseType resetPassword(ResetPasswordRequestType resetPasswordRequest) {
    return userPort.resetPassword(resetPasswordRequest);
  }

  public PasswordQuestionResponseType getPasswordQuestion(
      GetPasswordQuestionRequestType getPasswordQuestionRequest) {
    return userPort.getPasswordQuestion(getPasswordQuestionRequest);
  }

  public ChangePasswordResponseType changePassword(
      ChangePasswordRequestType changePasswordRequest) {
    return userPort.changePassword(changePasswordRequest);
  }

  public BaseResponseType updateNotificationPreferences(
      UpdateNotificationPreferencesRequestType updateNotificationPreferencesRequest) {
    return userPort.updateNotificationPreferences(updateNotificationPreferencesRequest);
  }
}
