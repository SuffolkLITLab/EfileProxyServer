/** */
package edu.suffolk.assemblyLineEfspServer;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import org.apache.cxf.headers.Header;
import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.services.schema.baseresponse.BaseResponseType;
import tyler.efm.services.schema.changepasswordrequest.ChangePasswordRequestType;
import tyler.efm.services.schema.changepasswordresponse.ChangePasswordResponseType;
import tyler.efm.services.schema.common.NotificationType;
import tyler.efm.services.schema.common.UserType;
import tyler.efm.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.services.schema.notificationpreferencesresponse.NotificationPreferencesResponseType;
import tyler.efm.services.schema.registrationrequest.RegistrationRequestType;
import tyler.efm.services.schema.resetpasswordrequest.ResetPasswordRequestType;
import tyler.efm.services.schema.resetpasswordresponse.ResetPasswordResponseType;
import tyler.efm.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType;
import tyler.efm.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType;
import tyler.efm.services.schema.updateuserrequest.UpdateUserRequestType;
import tyler.efm.services.schema.updateuserresponse.UpdateUserResponseType;

/** @author brycew */
public final class EfspServer {

  /** @param args */
  private static final QName SERVICE_NAME = new QName("urn:tyler:efm:services", "EfmUserService");

  public static void testFirmManagement(IEfmFirmService port) throws JAXBException {
    // RegisterUser
    RegistrationRequestType regUser = new RegistrationRequestType();
    regUser.setCity("Galveston");

    // AddUserRole

    // GetUser

    // GetUserList

    // UpdateUser

    // GetNotificationPreferencesList

    // RemoveUser

    // RemoveUserRole

    // ResendActivationEmail

    // ResetUserPassword
  }

  public static void testUserManagement(IEfmUserService port) throws JAXBException {
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail("bwilley@suffolk.edu");
    authReq.setPassword(System.getenv("BRYCE_USER_PASSWORD"));
    AuthenticateResponseType authRes = port.authenticateUser(authReq);

    // GetUser
    GetUserRequestType getUserReq = new GetUserRequestType();
    getUserReq.setUserID(authRes.getUserID());
    ArrayList<Header> headersList = new ArrayList<Header>();
    headersList.add(
        TylerUserNamePassword.MakeHeader(authRes.getEmail(), authRes.getPasswordHash()));
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    ctx.put(Header.HEADER_LIST, headersList);
    GetUserResponseType getUserResp = port.getUser(getUserReq);
    System.out.println(getUserResp.getError().getErrorCode());
    System.out.println(getUserResp.getError().getErrorText());
    UserType user = getUserResp.getUser();
    System.out.println(user);
    if (user != null) {
      System.out.println(user.getEmail());
      System.out.println(user.getFirstName());
      System.out.println(user.getFirmID());
      System.out.println(user.isIsLockedOut());
      System.out.println(user.getLastLoginDate());
    } else {
      System.err.println("Need to be able to get a user to continue test");
      return;
    }

    // UpdateUser
    UpdateUserRequestType updateUser = new UpdateUserRequestType();
    user.setMiddleName("Stephen");
    updateUser.setUser(user);
    UpdateUserResponseType updateUserResp = port.updateUser(updateUser);
    System.out.println("Updated " + updateUserResp.getUserID());

    // Check that user is updated
    GetUserRequestType getNewUser = new GetUserRequestType();
    getNewUser.setUserID(updateUserResp.getUserID());
    GetUserResponseType getNewUserResp = port.getUser(getNewUser);
    System.out.println(
        "Get new user: "
            + getNewUserResp.getError().getErrorCode()
            + " "
            + getNewUserResp.getError().getErrorText());
    UserType newUser = getNewUserResp.getUser();
    if (newUser != null) {
      System.out.println(newUser.getEmail());
      System.out.println(newUser.getFirstName());
      System.out.println(newUser.getFirmID());
      System.out.println(newUser.isIsLockedOut());
      System.out.println(newUser.getLastLoginDate());
    }

    // UpdateNotificationPreferences
    UpdateNotificationPreferencesRequestType updateNotif =
        new UpdateNotificationPreferencesRequestType();
    NotificationType newNotif = new NotificationType();
    newNotif.setCode("SERVICEUNDELIVERABLE");
    updateNotif.getNotification().add(newNotif);

    // GetNotificationPreferences
    NotificationPreferencesResponseType notifResp = port.getNotificationPreferences();
    System.out.println("Notifications: " + notifResp.getNotification().size());
    for (NotificationType notif : notifResp.getNotification()) {
      System.out.println(notif.getCode() + " " + notif.getDescription());
    }

    // ChangePassword
    ChangePasswordRequestType changePass = new ChangePasswordRequestType();
    changePass.setOldPassword(System.getenv("BRYCE_USER_PASSWORD"));
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < 25; i++) {
      Random random = new Random();
      builder.append((char) (random.nextInt((126 - 65) + 1) + 65));
    }
    System.out.println("Changing to " + builder.toString());
    changePass.setNewPassword(builder.toString());
    changePass.setPasswordQuestion("Why no password question?");
    changePass.setPasswordAnswer("They are deprecated");
    ChangePasswordResponseType changePassResp = port.changePassword(changePass);
    System.out.println("New pass stuff: " + changePassResp.getPasswordHash());
    System.out.println("New pass stuff: " + changePassResp.getExpirationDateTime());

    headersList = new ArrayList<Header>();
    headersList.add(
        TylerUserNamePassword.MakeHeader(authRes.getEmail(), changePassResp.getPasswordHash()));
    ctx.put(Header.HEADER_LIST, headersList);

    // Change it back please, lol
    changePass.setOldPassword(builder.toString());
    changePass.setNewPassword(System.getenv("BRYCE_USER_PASSWORD"));
    changePassResp = port.changePassword(changePass);

    headersList = new ArrayList<Header>();
    headersList.add(
        TylerUserNamePassword.MakeHeader(authRes.getEmail(), changePassResp.getPasswordHash()));
    ctx.put(Header.HEADER_LIST, headersList);
  }

  public static void testUserActionManagement(IEfmUserService port, String userEmail) {
    // SelfResendActivationEmail
    SelfResendActivationEmailRequestType resendActiv = new SelfResendActivationEmailRequestType();
    resendActiv.setEmail(userEmail);
    BaseResponseType resendResp = port.selfResendActivationEmail(resendActiv);
    System.out.println("Resend: " + resendResp.getError().getErrorCode());
    System.out.println("Resend: " + resendResp.getError().getErrorText());

    // ResetPassword
    ResetPasswordRequestType resetPasswordReq = new ResetPasswordRequestType();
    resetPasswordReq.setEmail(userEmail);
    ResetPasswordResponseType resetPasswordResp = port.resetPassword(resetPasswordReq);
    System.out.println(resetPasswordResp.getPasswordHash());
    System.out.println(resetPasswordResp.getError().getErrorCode());
    System.out.println(resetPasswordResp.getError().getErrorText());
  }

  public static void main(String[] args) throws JAXBException {
    URL wsdlURL = EfmUserService.WSDL_LOCATION;
    if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
      File wsdlFile = new File(args[0]);
      try {
        if (wsdlFile.exists()) {
          wsdlURL = wsdlFile.toURI().toURL();
        } else {
          wsdlURL = new URL(args[0]);
        }
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }

    EfmUserService ss = new EfmUserService(wsdlURL, SERVICE_NAME);
    IEfmUserService port = ss.getBasicHttpBindingIEfmUserService();
    BindingProvider bp = (BindingProvider) port;
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put("security.username", "bwilley@suffolk.edu");
    ctx.put("security.password", "can-be-anything?");
    ctx.put("security.signature.properties", "client_sign.properties");
    ctx.put("security.callback-handler", ClientCallbackHandler.class.getName());
    ctx.put("security.signature.username", "1");

    // testUserManagement(port);
    testUserActionManagement(port, "bwilley@suffolk.edu");
  }
}
