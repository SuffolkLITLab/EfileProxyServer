package edu.suffolk.litlab.efspserver;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import edu.suffolk.litlab.efspserver.codes.CaseCategory;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.NameAndCode;
import edu.suffolk.litlab.efspserver.services.ServiceHelpers;
import gov.niem.niem.fips_10_4._2.CountryCodeSimpleType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.TextType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.PersonType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.QueryResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.CoreFilingMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.FeesCalculationQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationresponsemessage_4.FeesCalculationResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.FilingListQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.FilingListResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistresponsemessage_4.MatchingFilingType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.FilingStatusQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusresponsemessage_4.FilingStatusResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import org.apache.cxf.headers.Header;
import tyler.ecf.extensions.cancelfilingmessage.CancelFilingMessageType;
import tyler.ecf.extensions.cancelfilingresponsemessage.CancelFilingResponseMessageType;
import tyler.ecf.extensions.common.FilingTypeType;
import tyler.ecf.extensions.filingdetailquerymessage.FilingDetailQueryMessageType;
import tyler.ecf.extensions.filingdetailresponsemessage.FilingDetailResponseMessageType;
import tyler.efm.services.EfmFirmService;
import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.adduserrolerequest.AddUserRoleRequestType;
import tyler.efm.services.schema.attachservicecontactrequest.AttachServiceContactRequestType;
import tyler.efm.services.schema.attorneylistresponse.AttorneyListResponseType;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.services.schema.baseresponse.BaseResponseType;
import tyler.efm.services.schema.changepasswordrequest.ChangePasswordRequestType;
import tyler.efm.services.schema.changepasswordresponse.ChangePasswordResponseType;
import tyler.efm.services.schema.common.AttorneyType;
import tyler.efm.services.schema.common.NotificationType;
import tyler.efm.services.schema.common.PaymentAccountType;
import tyler.efm.services.schema.common.PaymentAccountTypeType;
import tyler.efm.services.schema.common.RegistrationType;
import tyler.efm.services.schema.common.RoleType;
import tyler.efm.services.schema.common.ServiceContactType;
import tyler.efm.services.schema.common.UserType;
import tyler.efm.services.schema.createattorneyrequest.CreateAttorneyRequestType;
import tyler.efm.services.schema.createattorneyresponse.CreateAttorneyResponseType;
import tyler.efm.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;
import tyler.efm.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType;
import tyler.efm.services.schema.createservicecontactrequest.CreateServiceContactRequestType;
import tyler.efm.services.schema.createservicecontactresponse.CreateServiceContactResponseType;
import tyler.efm.services.schema.detachservicecontactrequest.DetachServiceContactRequestType;
import tyler.efm.services.schema.getattorneyrequest.GetAttorneyRequestType;
import tyler.efm.services.schema.getattorneyresponse.GetAttorneyResponseType;
import tyler.efm.services.schema.getfirmresponse.GetFirmResponseType;
import tyler.efm.services.schema.getservicecontactrequest.GetServiceContactRequestType;
import tyler.efm.services.schema.getservicecontactresponse.GetServiceContactResponseType;
import tyler.efm.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.services.schema.notificationpreferencesresponse.NotificationPreferencesResponseType;
import tyler.efm.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;
import tyler.efm.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType;
import tyler.efm.services.schema.registrationrequest.RegistrationRequestType;
import tyler.efm.services.schema.registrationresponse.RegistrationResponseType;
import tyler.efm.services.schema.removeattorneyrequest.RemoveAttorneyRequestType;
import tyler.efm.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType;
import tyler.efm.services.schema.removeservicecontactrequest.RemoveServiceContactRequestType;
import tyler.efm.services.schema.removeuserrequest.RemoveUserRequestType;
import tyler.efm.services.schema.removeuserrolerequest.RemoveUserRoleRequestType;
import tyler.efm.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType;
import tyler.efm.services.schema.resetpasswordrequest.ResetPasswordRequestType;
import tyler.efm.services.schema.resetpasswordresponse.ResetPasswordResponseType;
import tyler.efm.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType;
import tyler.efm.services.schema.servicecontactlistresponse.ServiceContactListResponseType;
import tyler.efm.services.schema.updateattorneyrequest.UpdateAttorneyRequestType;
import tyler.efm.services.schema.updateattorneyresponse.UpdateAttorneyResponseType;
import tyler.efm.services.schema.updatefirmrequest.UpdateFirmRequestType;
import tyler.efm.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType;
import tyler.efm.services.schema.updateservicecontactrequest.UpdateServiceContactRequestType;
import tyler.efm.services.schema.updateservicecontactresponse.UpdateServiceContactResponseType;
import tyler.efm.services.schema.updateuserrequest.UpdateUserRequestType;
import tyler.efm.services.schema.updateuserresponse.UpdateUserResponseType;
import tyler.efm.services.schema.userlistresponse.UserListResponseType;
import tyler.efm.wsdl.webservicesprofile_implementation_4_0.FilingReviewMDEService;

public final class EfmClient {

  private static final QName USER_SERVICE_NAME = new QName("urn:tyler:efm:services",
      "EfmUserService");
  private static final QName FIRM_SERVICE_NAME = new QName("urn:tyler:efm:services",
      "EfmFirmService");

  /** Returns true on errors from the Tyler / Admin side of the API. */
  public static boolean checkErrors(BaseResponseType resp) {
    if (!resp.getError().getErrorCode().equals("0")) {
      System.err.println(
          "Error!: " + resp.getError().getErrorCode() + ": " + resp.getError().getErrorText());
      return true;
    }
    return false;
  }

  /** Returns true if error are present from the Oasis side of the API. */
  public static boolean checkErrors(QueryResponseMessageType resp) {
    if (resp.getError().size() > 0) {
      for (ErrorType error : resp.getError()) {
        if (error.getErrorCode().getValue().equals("0")) {
          continue;
        }
        System.err.println(
            "Errors!: " + error.getErrorCode().getValue() + ": " + error.getErrorText().getValue());
        return true;
      }
    }
    return false;
  }

  public static void testFirmManagement(IEfmUserService userPort, IEfmFirmService firmPort)
      throws JAXBException {
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail("bwilley@suffolk.edu");
    authReq.setPassword(System.getenv("BRYCE_USER_PASSWORD"));
    AuthenticateResponseType authRes = userPort.authenticateUser(authReq);

    List<Header> headersList = Arrays
        .asList(TylerUserNamePassword.makeHeader(authRes.getEmail(), authRes.getPasswordHash()));
    ((BindingProvider) firmPort).getRequestContext().put(Header.HEADER_LIST, headersList);
    ((BindingProvider) userPort).getRequestContext().put(Header.HEADER_LIST, headersList);

    GetFirmResponseType firm = firmPort.getFirm();
    System.out.println("Firm info: " + firm.getFirm().getFirmID() + ", "
        + firm.getFirm().getFirmName() + ", " + firm.getFirm().getPhoneNumber() + ", "
        + firm.getFirm().getAddress().getAddressLine1());
    final String oldNumber = firm.getFirm().getPhoneNumber();
    firm.getFirm().setPhoneNumber("1234567890");
    UpdateFirmRequestType update = new UpdateFirmRequestType();
    update.setFirm(firm.getFirm());
    firmPort.updateFirm(update);
    firm = firmPort.getFirm();
    System.out.println("Firm's updated phone is: " + firm.getFirm().getPhoneNumber());
    // Change it back
    firm.getFirm().setPhoneNumber(oldNumber);
    update = new UpdateFirmRequestType();
    update.setFirm(firm.getFirm());
    firmPort.updateFirm(update);

    // RegisterUser
    RegistrationRequestType regUser = new RegistrationRequestType();
    regUser.setEmail("bryce.steven.willey+tylertesting@gmail.com");
    regUser.setFirstName("Bryce");
    regUser.setMiddleName("Steven");
    regUser.setLastName("Wiley");
    regUser.setPassword("testingPassword1@");
    regUser.setPasswordQuestion("Again, password Qs are deprecated");
    regUser.setPasswordAnswer("Yes, lol");
    regUser.setCountryCode("US");
    regUser.setCity("Houston");
    regUser.setPhoneNumber("4093563492");
    regUser.setRegistrationType(RegistrationType.FIRM_ADMIN_NEW_MEMBER);
    // RegistrationType.INDIVIDUAL doesn't let you have any control over the user or
    // let you delete
    // the account in any way
    regUser.setStateCode("TX");
    regUser.setZipCode("77098");
    regUser.setStreetAddressLine1("123 Fake St");
    regUser.setStreetAddressLine2("Apt 1");
    regUser.setFirmName(firm.getFirm().getFirmName());
    RegistrationResponseType userRes = firmPort.registerUser(regUser);
    System.out.println("New user errors: " + userRes.getError().getErrorCode() + ", "
        + userRes.getError().getErrorText());
    System.out.println("New User for gmail: " + userRes.getUserID() + ", " + userRes.getFirmID()
        + ", " + userRes.getExpirationDateTime());

    // ResendActivationEmail
    ResendActivationEmailRequestType newEmail = new ResendActivationEmailRequestType();
    newEmail.setUserID(userRes.getUserID());
    BaseResponseType newEmailRes = firmPort.resendActivationEmail(newEmail);
    System.out.println("New email res error: " + newEmailRes.getError().getErrorText());

    // AddUserRole
    AddUserRoleRequestType req = new AddUserRoleRequestType();
    req.setRole(RoleType.FIRM_ADMIN);
    req.setUserID(userRes.getUserID());
    BaseResponseType res = firmPort.addUserRole(req);
    System.out.println("Set new role error: " + res.getError().getErrorText());

    // UpdateUser
    UserType correctUser = new UserType();
    correctUser.setFirstName("Bryce");
    correctUser.setFirstName("Steven");
    correctUser.setLastName("Willey");
    correctUser.setEmail("bryce.steven.willey+tylertesting@gmail.com");
    correctUser.setUserID(userRes.getUserID());
    UpdateUserRequestType updateUser = new UpdateUserRequestType();
    updateUser.setUser(correctUser);
    UpdateUserResponseType correctUserRes = firmPort.updateUser(updateUser);
    System.out.println(correctUserRes.getError().getErrorText());

    // GetUser

    // GetUserList
    UserListResponseType userList = firmPort.getUserList();
    System.out.println(userList.getUser().size() + " users");
    for (UserType u : userList.getUser()) {
      System.out.println(u.getEmail());
    }

    // GetNotificationPreferencesList

    // RemoveUserRole
    RemoveUserRoleRequestType removeRole = new RemoveUserRoleRequestType();
    removeRole.setUserID(userRes.getUserID());
    removeRole.setRole(RoleType.FIRM_ADMIN);
    BaseResponseType removedRoleRes = firmPort.removeUserRole(removeRole);
    System.out.println("Remove role error: " + removedRoleRes.getError().getErrorText());

    // RemoveUser
    RemoveUserRequestType removeUser = new RemoveUserRequestType();
    removeUser.setUserID(userRes.getUserID());
    BaseResponseType removeUserRes = firmPort.removeUser(removeUser);
    System.out.println("Remove user error: " + removeUserRes.getError().getErrorText());

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
    List<Header> headersList = Arrays
        .asList(TylerUserNamePassword.makeHeader(authRes.getEmail(), authRes.getPasswordHash()));
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
    System.out.println("Get new user: " + getNewUserResp.getError().getErrorCode() + " "
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
    UpdateNotificationPreferencesRequestType updateNotif = new UpdateNotificationPreferencesRequestType();
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
    System.out
        .println("Successfully changed password?: " + changePassResp.getError().getErrorText());
    System.out.println("New pass stuff: " + changePassResp.getPasswordHash());
    System.out.println("New pass stuff: " + changePassResp.getExpirationDateTime());

    headersList = new ArrayList<Header>();
    headersList.add(
        TylerUserNamePassword.makeHeader(authRes.getEmail(), changePassResp.getPasswordHash()));
    ctx.put(Header.HEADER_LIST, headersList);

    // Change it back please, lol
    changePass.setOldPassword(builder.toString());
    changePass.setNewPassword(System.getenv("BRYCE_USER_PASSWORD"));
    changePassResp = port.changePassword(changePass);
    System.out.println("Changed back successfully?: " + changePassResp.getError().getErrorText());

    headersList = new ArrayList<Header>();
    headersList.add(
        TylerUserNamePassword.makeHeader(authRes.getEmail(), changePassResp.getPasswordHash()));
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

  public static void testAttorneyAndServiceManagement(IEfmFirmService port, boolean remove) {
    AttorneyType newAtt = new AttorneyType();
    newAtt.setFirstName("Valarie");
    newAtt.setMiddleName("DONTUSE_REALPERSON");
    newAtt.setLastName("Franklin");
    // https://www.iardc.org/HB_RB_Disp_Html.asp?id=13441
    newAtt.setBarNumber("6224951");
    CreateAttorneyRequestType attorney = new CreateAttorneyRequestType();
    attorney.setAttorney(newAtt);
    CreateAttorneyResponseType resp = port.createAttorney(attorney);
    if (checkErrors(resp)) {
      return;
    }

    AttorneyListResponseType list = port.getAttorneyList();
    if (checkErrors(list)) {
      return;
    }
    for (AttorneyType att : list.getAttorney()) {
      System.err.println(att.getFirstName() + " " + att.getMiddleName() + " " + att.getLastName());
      System.err
          .println(att.getFirmID() + ", " + att.getAttorneyID() + ", " + att.getBarNumber() + "\n");
    }

    UpdateAttorneyRequestType updateAtt = new UpdateAttorneyRequestType();
    newAtt.setMiddleName("Lobert");
    newAtt.setAttorneyID(resp.getAttorneyID());
    updateAtt.setAttorney(newAtt);
    UpdateAttorneyResponseType updatedAtt = port.updateAttorney(updateAtt);
    if (checkErrors(updatedAtt)) {
      return;
    }

    GetAttorneyRequestType attReq = new GetAttorneyRequestType();
    attReq.setAttorneyID(updatedAtt.getAttorneyID());
    GetAttorneyResponseType getResp = port.getAttorney(attReq);
    if (checkErrors(getResp)) {
      return;
    }
    AttorneyType att = getResp.getAttorney();
    System.err.println(att.getFirstName() + " " + att.getMiddleName() + " " + att.getLastName());
    System.err
        .println(att.getFirmID() + ", " + att.getAttorneyID() + ", " + att.getBarNumber() + "\n");

    if (remove) {
      RemoveAttorneyRequestType rart = new RemoveAttorneyRequestType();
      rart.setAttorneyID(getResp.getAttorney().getAttorneyID());
      BaseResponseType rartResp = port.removeAttorney(rart);
      if (checkErrors(rartResp)) {
        return;
      }
    }

    //////////// Service
    // TODO(brycew): service contacts can only be at particular firms, so kinda
    // useless?
    //////////// 
    tyler.efm.services.schema.common.ObjectFactory efmObjFac = new tyler.efm.services.schema.common.ObjectFactory();
    CreateServiceContactRequestType create = new CreateServiceContactRequestType();
    ServiceContactType contact = efmObjFac.createServiceContactType();
    contact.setFirstName("Sterve");
    contact.setMiddleName("\"Not Me\"");
    contact.setLastName("Cormact");
    contact.setEmail("bwilley@suffolk.edu");
    contact.setAdministrativeCopy("bryce.steven.willey@gmail.com");
    Address address = new Address("893 E Broadway", "", "Boston", "MA", "02127", CountryCodeSimpleType.US);
    contact.setAddress(address.getAsTylerAddress());
    contact.setIsInFirmMasterList(efmObjFac.createServiceContactTypeIsInFirmMasterList(true));
    contact.setIsPublic(efmObjFac.createServiceContactTypeIsInFirmMasterList(true));
    create.setServiceContact(contact);
    CreateServiceContactResponseType servResp = port.createServiceContact(create);
    if (checkErrors(servResp)) {
      return;
    }
    System.err.println("Service contact id: " + servResp.getServiceContactID());

    ServiceContactListResponseType listResp = port.getServiceContactList();
    if (checkErrors(listResp)) {
      return;
    }
    if (listResp.getServiceContact().size() == 0) {
      System.err.println("Service contacts are empty");
    }
    for (ServiceContactType c : listResp.getServiceContact()) {
      System.err.println("List: " + c.getServiceContactID() + ", " + c.getFirstName() + " "
          + c.getMiddleName() + " " + c.getLastName());
    }
    contact.setServiceContactID(servResp.getServiceContactID());

    UpdateServiceContactRequestType update = new UpdateServiceContactRequestType();
    contact.setMiddleName("\"Not a computer\"");
    update.setServiceContact(contact);
    UpdateServiceContactResponseType updateResp = port.updateServiceContact(update);
    if (checkErrors(updateResp)) {
      return;
    }

    GetServiceContactRequestType getReq = new GetServiceContactRequestType();
    getReq.setServiceContactID(servResp.getServiceContactID());
    GetServiceContactResponseType getServResp = port.getServiceContact(getReq);
    if (checkErrors(getServResp)) {
      return;
    }
    contact = getServResp.getServiceContact();
    System.err.println("GetResp: " + contact.getFirstName() + " " + contact.getMiddleName() + " "
        + contact.getLastName());

    String preSetupCaseId = "f3d9b420-18e1-4e70-ac39-3270928bc29c";
    AttachServiceContactRequestType attachServ = new AttachServiceContactRequestType();
    attachServ.setCaseID(preSetupCaseId);
    attachServ.setServiceContactID(getServResp.getServiceContact().getServiceContactID());
    // attachServ.setCasePartyID(); TODO(brycew): what should this be? is optional
    BaseResponseType attachBase = port.attachServiceContact(attachServ);
    if (checkErrors(attachBase)) {
      System.exit(-1);
    }

    DetachServiceContactRequestType detachServ = new DetachServiceContactRequestType();
    detachServ.setCaseID(preSetupCaseId);
    detachServ.setServiceContactID(getServResp.getServiceContact().getServiceContactID());
    BaseResponseType detachBase = port.detachServiceContact(detachServ);
    if (checkErrors(detachBase)) {
      System.exit(-1);
    }

    RemoveServiceContactRequestType rmReq = new RemoveServiceContactRequestType();
    rmReq.setServiceContactID(contact.getServiceContactID());

    BaseResponseType base = port.removeServiceContact(rmReq);
    if (checkErrors(base)) {
      return;
    }

    listResp = port.getServiceContactList();
    if (checkErrors(listResp)) {
      return;
    }
    if (listResp.getServiceContact().size() == 0) {
      System.err.println("Service contacts are empty");
    }
    for (ServiceContactType c : listResp.getServiceContact()) {
      System.err.println("List: " + c.getServiceContactID() + ", " + c.getFirstName() + " "
          + c.getMiddleName() + " " + c.getLastName());
    }
  }

  public static void paymentAccounts(IEfmFirmService port, boolean global) {
    // Remove all
    if (global) {
      PaymentAccountListResponseType allAccs = port.getGlobalPaymentAccountList();
      for (PaymentAccountType acc : allAccs.getPaymentAccount()) {
        System.err.println("Removing global acc: " + acc.getPaymentAccountID() + ", with token: "
            + acc.getAccountToken());
        RemovePaymentAccountRequestType rmReq = new RemovePaymentAccountRequestType();
        rmReq.setPaymentAccountID(acc.getPaymentAccountID());
        if (checkErrors(port.removeGlobalPaymentAccount(rmReq))) {
          return;
        }
      }
    } else {
      PaymentAccountListResponseType allAccs = port.getPaymentAccountList();
      for (PaymentAccountType acc : allAccs.getPaymentAccount()) {
        System.err.println("Removing acc: " + acc.getPaymentAccountID() + ", with token: "
            + acc.getAccountToken());
        RemovePaymentAccountRequestType rmReq = new RemovePaymentAccountRequestType();
        rmReq.setPaymentAccountID(acc.getPaymentAccountID());
        if (checkErrors(port.removePaymentAccount(rmReq))) {
          return;
        }
      }
    }

    PaymentAccountTypeListResponseType listResp = port.getPaymentAccountTypeList();
    if (listResp.getPaymentAccountType().size() == 0) {
      System.err.println("No payment account types available?");
      return;
    }
    for (PaymentAccountTypeType accountType : listResp.getPaymentAccountType()) {
      System.err
          .println("New Account: " + accountType.getCode() + ", " + accountType.getDescription());
      tyler.efm.services.schema.common.ObjectFactory efmObjFac = new tyler.efm.services.schema.common.ObjectFactory();
      if (!accountType.getCode().equals("WV")) {
        continue;
      }
      PaymentAccountType newAccount = efmObjFac.createPaymentAccountType();
      newAccount.setPaymentAccountTypeCode(accountType.getCode());
      newAccount.setAccountName("Waiver Account");
      newAccount.setAccountToken("mywaiveridentifier");
      // TODO(brycew): on 122 for creation, look at all Account Tokens and don't
      // choose them again
      if (accountType.getCode().equals("CC")) {
        newAccount.setAccountToken("myccaccounttoken");
        newAccount.setCardType(efmObjFac.createPaymentAccountTypeCardType("MASTERCARD"));
        newAccount.setCardLast4("1234");
        newAccount.setCardMonth(efmObjFac.createPaymentAccountTypeCardMonth(1));
        newAccount.setCardYear(efmObjFac.createPaymentAccountTypeCardYear(2025));
        newAccount.setCardHolderName(efmObjFac.createPaymentAccountTypeCardHolderName("Bob Bobby"));
      } else if (accountType.getCode().equals("BankAccount")) {
        newAccount.setAccountName("My Bank Payment Account");
        newAccount.setAccountToken("mybank_identifier");
        newAccount.setCardType(efmObjFac.createPaymentAccountTypeCardType("Checking"));
        newAccount.setCardLast4("1235");
        newAccount.setCardMonth(efmObjFac.createPaymentAccountTypeCardMonth(0));
        newAccount.setCardYear(efmObjFac.createPaymentAccountTypeCardYear(0));
        newAccount.setCardHolderName(efmObjFac.createPaymentAccountTypeCardHolderName("Bob Bobby"));
      }

      if (global) {
        newAccount.setAccountToken(newAccount.getAccountToken() + "global");
      }

      CreatePaymentAccountRequestType createAccount = new CreatePaymentAccountRequestType();
      createAccount.setPaymentAccount(newAccount);
      CreatePaymentAccountResponseType createResp;
      System.err.println("Creating payment account with token: " + newAccount.getAccountToken());
      if (global) {
        createResp = port.createGlobalPaymentAccount(createAccount);
      } else {
        createResp = port.createPaymentAccount(createAccount);
      }
      if (checkErrors(createResp)) {
        PaymentAccountListResponseType allAccs = port.getGlobalPaymentAccountList();
        for (PaymentAccountType acc : allAccs.getPaymentAccount()) {
          System.err.println("Existing global acc: " + acc.getPaymentAccountID() + ", with token: "
              + acc.getAccountToken());
        }
        allAccs = port.getPaymentAccountList();
        for (PaymentAccountType acc : allAccs.getPaymentAccount()) {
          System.err.println("Existing acc: " + acc.getPaymentAccountID() + ", with token: "
              + acc.getAccountToken());
        }
        return;
      }

      System.err.println("Created payment account: " + createResp.getPaymentAccountID() + ", "
          + "token: " + newAccount.getAccountToken());

      return;
      /*
       * UpdatePaymentAccountRequestType updateReq = new
       * UpdatePaymentAccountRequestType();
       * newAccount.setActive(efmObjFac.createPaymentAccountTypeActive(false));
       * newAccount.setPaymentAccountID(createResp.getPaymentAccountID());
       * updateReq.setPaymentAccount(newAccount); UpdatePaymentAccountResponseType
       * updateResp; if (global) { updateResp =
       * port.updateGlobalPaymentAccount(updateReq); } else { updateResp =
       * port.updatePaymentAccount(updateReq); } if (checkErrors(updateResp)) {
       * return; }
       * 
       * GetPaymentAccountRequestType getReq = new GetPaymentAccountRequestType();
       * getReq.setPaymentAccountID(createResp.getPaymentAccountID());
       * GetPaymentAccountResponseType getResp; if (global) { getResp =
       * port.getGlobalPaymentAccount(getReq); } else { getResp =
       * port.getPaymentAccount(getReq); } if (checkErrors(getResp)) { return; }
       * System.err.println("Account: " + getResp.getPaymentAccount().getAccountName()
       * + ", " + getResp.getPaymentAccount().getActive().getValue() + ", " +
       * getResp.getPaymentAccount().getPaymentAccountTypeCode());
       * 
       * RemovePaymentAccountRequestType rmReq = new
       * RemovePaymentAccountRequestType();
       * rmReq.setPaymentAccountID(createResp.getPaymentAccountID()); BaseResponseType
       * baseResp; if (global) { baseResp = port.removeGlobalPaymentAccount(rmReq); }
       * else { baseResp = port.removePaymentAccount(rmReq); } if
       * (checkErrors(baseResp)) { return; }
       */
    }
  }

  public static void testFilingService(FilingReviewMDEPort port, String courtId) {
    oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.ObjectFactory listObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.filinglistquerymessage_4.ObjectFactory();
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory cof = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    FilingListQueryMessageType m = listObjFac.createFilingListQueryMessageType();
    JAXBElement<PersonType> elem2 = cof.createEntityPerson(new PersonType());
    EntityType typ = new EntityType();
    typ.setEntityRepresentation(elem2);
    m.setQuerySubmitter(typ);
    m.setDocumentSubmitter(null); // cof.createEntityPerson(null));
    m.setCaseCourt(XmlHelper.convertCourtType(courtId));
    m.setSendingMDELocationID(XmlHelper.convertId("https://filingassemblymde.com"));
    m.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    FilingListResponseMessageType resp = port.getFilingList(m);
    if (checkErrors(resp)) {
      System.exit(-1);
    }

    System.out.println("FilingDoc List: " 
        + XmlHelper.objectToXmlStrOrError(resp, FilingListResponseMessageType.class));

    String caseTrackingId = "";
    String filingId = "";
    for (MatchingFilingType fil : resp.getMatchingFiling()) {
      System.err.println(fil.getCaseTrackingID().getValue() + " // " + fil.getId() + " // ");
      caseTrackingId = fil.getCaseTrackingID().getValue();
      filingId = fil.getDocumentIdentification().stream()
          .filter((id) -> ((TextType) id.getIdentificationCategory().getValue()).getValue()
              .equals("FILINGID"))
          .map((id) -> id.getIdentificationID().getValue()).findFirst().orElse(filingId);
      if (fil.getFilingStatus() != null && fil.getFilingStatus().getStatusText() != null) {
        System.err.println(fil.getFilingStatus().getStatusText().getValue());
      }
    }
    if (caseTrackingId.isBlank() || filingId.isBlank()) {
      return;
    }

    oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.ObjectFactory statusObjFac =
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.filingstatusquerymessage_4.ObjectFactory();
    FilingStatusQueryMessageType status = statusObjFac.createFilingStatusQueryMessageType();
    status.setCaseCourt(XmlHelper.convertCourtType(courtId));
    // TODO(brycew): SendingMDELocationID is the running URL of the server
    status.setSendingMDELocationID(XmlHelper.convertId("https://filingassemblymde.com"));
    status.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    status.setDocumentIdentification(XmlHelper.convertId(filingId));
    status.setQuerySubmitter(typ);
    FilingStatusResponseMessageType statusResp = port.getFilingStatus(status);
    if (checkErrors(statusResp)) {
      System.exit(-1);
    }

    System.out.println("FilingDoc Status: " 
        + XmlHelper.objectToXmlStrOrError(statusResp, FilingStatusResponseMessageType.class));
    System.out.println(statusResp.getFilingStatus().getStatusDescriptionText().stream()
        .map((n) -> n.getValue()).reduce((start, n) -> start + ", " + n));

    tyler.ecf.extensions.filingdetailquerymessage.ObjectFactory detailObjFac =
        new tyler.ecf.extensions.filingdetailquerymessage.ObjectFactory();
    FilingDetailQueryMessageType details = detailObjFac.createFilingDetailQueryMessageType();
    details.setCaseCourt(XmlHelper.convertCourtType(courtId));
    details.setSendingMDELocationID(XmlHelper.convertId("https://filingassemblymde.com"));
    details.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    details.setDocumentIdentification(XmlHelper.convertId(filingId));
    details.setQuerySubmitter(typ);
    FilingDetailResponseMessageType detailsResp = port.getFilingDetails(details);
    if (checkErrors(detailsResp)) {
      System.exit(-1);
    }

    System.out.println("FilingDoc Details: "
        + XmlHelper.objectToXmlStrOrError(detailsResp, FilingDetailResponseMessageType.class));
    System.out.println(detailsResp.getFilingStatus().getStatusDescriptionText().stream()
        .map((n) -> n.getValue()).reduce((start, n) -> start + ", " + n));

    tyler.ecf.extensions.cancelfilingmessage.ObjectFactory cancelObjFac =
        new tyler.ecf.extensions.cancelfilingmessage.ObjectFactory();
    CancelFilingMessageType cancel = cancelObjFac.createCancelFilingMessageType();
    cancel.setCaseCourt(XmlHelper.convertCourtType(courtId));
    cancel.setDocumentIdentification(XmlHelper.convertId(filingId));
    cancel.setSendingMDELocationID(XmlHelper.convertId("https://filingassemblymde.com"));
    cancel.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    cancel.setQuerySubmitter(typ);
    CancelFilingResponseMessageType cancelResp = port.cancelFiling(cancel);
    if (checkErrors(cancelResp)) {
      System.exit(-1);
    }

    System.err.println(cancelResp.getFilingStatus().getStatusText().getValue());
  }

  public static IEfmUserService makeUserService(URL userWsdlUrl) {
    EfmUserService ss = new EfmUserService(userWsdlUrl, USER_SERVICE_NAME);
    System.out.println(userWsdlUrl.getHost() + userWsdlUrl.getPath());
    IEfmUserService port = ss.getBasicHttpBindingIEfmUserService();
    BindingProvider bp = (BindingProvider) port;
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put("security.username", "bwilley@suffolk.edu");
    ctx.put("security.password", "can-be-anything?");
    ctx.put("security.signature.properties", "client_sign.properties");
    ctx.put("security.callback-handler", ClientCallbackHandler.class.getName());
    ctx.put("security.signature.username", "1");
    return port;
  }

  public static IEfmFirmService makeFirmService(URL firmWsdlUrl) {
    return makeFirmService(firmWsdlUrl, List.of());
  }

  public static IEfmFirmService makeFirmService(URL firmWsdlUrl, List<Header> headersList) {
    EfmFirmService ss = new EfmFirmService(firmWsdlUrl, FIRM_SERVICE_NAME);
    IEfmFirmService port = ss.getBasicHttpBindingIEfmFirmService();
    BindingProvider bp = (BindingProvider) port;
    Map<String, Object> ctx = bp.getRequestContext();
    ctx.put(Header.HEADER_LIST, headersList);
    ctx.put("security.username", "bwilley@suffolk.edu");
    ctx.put("security.password", "can-be-anything?");
    ctx.put("security.signature.properties", "client_sign.properties");
    ctx.put("security.callback-handler", ClientCallbackHandler.class.getName());
    ctx.put("security.signature.username", "1");
    return port;
  }

  public static FilingReviewMDEPort makeFilingService(URL filingURL, List<Header> headersList) {
    // https://stackoverflow.com/a/18923391/11416267
    // makes it much faster, but fucks up the WSDL security
    FilingReviewMDEService filingService = new FilingReviewMDEService(filingURL,
        FilingReviewMDEService.SERVICE);
    FilingReviewMDEPort filingPort = filingService.getFilingReviewMDEPort();
    BindingProvider bp = (BindingProvider) filingPort;
    Map<String, Object> ctx = bp.getRequestContext();
    // System.out.println(filingURL.toExternalForm());
    ctx.put(Header.HEADER_LIST, headersList);
    // ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
    // "https://illinois-stage.tylerhost.net/efm/FilingReviewMDEPort.svc");
    // //filingURL.toExternalForm());
    ctx.put("security.username", "bwilley@suffolk.edu");
    ctx.put("security.password", "can-be-anything?");
    ctx.put("security.signature.properties", "client_sign.properties");
    ctx.put("security.callback-handler", ClientCallbackHandler.class.getName());
    ctx.put("security.signature.username", "1");
    return filingPort;
  }

  // TODO(brycew): figure out how to pass in person information
  // TODO(brycew): not handling attorneys, only SRLs right now
  public static Optional<CoreFilingMessageType> makeCivilCase(CodeDatabase cd,
      String courtLocationId, List<Person> plaintiffs, List<Person> defendants,
      CaseCategory caseCategoryCode, String caseType, String caseSubtype, List<FilingDoc> filingDocs,
      String paymentId, String queryType) throws SQLException, IOException {
    EcfCaseTypeFactory ecfCaseFactory = new EcfCaseTypeFactory(cd);

    Optional<JAXBElement<? extends gov.niem.niem.niem_core._2.CaseType>> assembledCase = ecfCaseFactory
        .makeCaseTypeFromTylerCategory(courtLocationId, caseCategoryCode, caseType, caseSubtype,
            plaintiffs, defendants,
            filingDocs.stream().map((f) -> f.getIdString()).collect(Collectors.toList()), paymentId, queryType,
            JsonNodeFactory.instance.objectNode());
    if (assembledCase.isEmpty()) {
      return Optional.empty();
    }
    oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory ecfCfmObjFac = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory();
    CoreFilingMessageType cfm = ecfCfmObjFac.createCoreFilingMessageType();
    cfm.setSendingMDELocationID(XmlHelper.convertId("https://filingassemblymde.com"));
    cfm.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    cfm.setCase(assembledCase.get());
    int seqNum = 0;
    for (FilingDoc filingDoc : filingDocs) {
      if (filingDoc.isLead()) {
        cfm.getFilingLeadDocument().add(filingDoc.asDocument(seqNum));
      } else {
        cfm.getFilingConnectedDocument().add(filingDoc.asDocument(seqNum));
      }
      seqNum += 1;
    }
    return Optional.of(cfm);
  }

  public static void checkFees(FilingReviewMDEPort filingPort, CodeDatabase cd,
      String courtLocationId, List<Person> plaintiffs, List<Person> defendants,
      CaseCategory caseCategoryCode, String caseType, String caseSubtype, List<FilingDoc> filingDocs,
      String paymentId) throws SQLException, IOException {

    Optional<CoreFilingMessageType> cfm = makeCivilCase(cd, courtLocationId, plaintiffs, defendants,
        caseCategoryCode, caseType, caseSubtype, filingDocs, paymentId, "fees");

    oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.ObjectFactory of = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.feescalculationquerymessage_4.ObjectFactory();
    FeesCalculationQueryMessageType feesQuery = of.createFeesCalculationQueryMessageType();
    EntityType typ = new EntityType();
    oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory cof = 
        new oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory();
    JAXBElement<PersonType> elem2 = cof.createEntityPerson(new PersonType());
    typ.setEntityRepresentation(elem2);
    feesQuery.setQuerySubmitter(typ);

    feesQuery.setSendingMDELocationID(XmlHelper.convertId("https://filingassemblymde.com"));
    feesQuery.setSendingMDEProfileCode(ServiceHelpers.MDE_PROFILE_CODE);
    feesQuery.setCoreFilingMessage(cfm.get());
    System.err.println(XmlHelper.objectToXmlStrOrError(feesQuery, FeesCalculationQueryMessageType.class));
    System.err.println();
    FeesCalculationResponseMessageType fees = filingPort.getFeesCalculation(feesQuery);
    System.err.println(XmlHelper.objectToXmlStrOrError(fees, FeesCalculationResponseMessageType.class));
    System.err.println("Fees: " + fees.getFeesCalculationAmount().getCurrencyText() + " "
        + fees.getFeesCalculationAmount().getValue());
    if (checkErrors(fees)) {
      System.exit(1);
    }
  }

  public static void main(String[] args) throws JAXBException, SQLException, IOException {
    URL userWsdlUrl = EfmUserService.WSDL_LOCATION;
    URL firmWsdlUrl = EfmFirmService.WSDL_LOCATION;
    if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
      try {
        File userWsdlFile = new File(args[0]);
        if (userWsdlFile.exists()) {
          userWsdlUrl = userWsdlFile.toURI().toURL();
        } else {
          userWsdlUrl = new URL(args[0]);
        }
        if (args.length > 1 && args[1] != null && !"".equals(args[1])) {
          File firmWsdlFile = new File(args[1]);
          if (firmWsdlFile.exists()) {
            firmWsdlUrl = firmWsdlFile.toURI().toURL();
          } else {
            firmWsdlUrl = new URL(args[1]);
          }
        }
      } catch (MalformedURLException e) {
        e.printStackTrace();
      }
    }
    String x509Password = System.getenv("X509_PASSWORD");
    System.err.println("x509 password: " + x509Password);
    ClientCallbackHandler.setX509Password(x509Password); 
    IEfmUserService userPort = makeUserService(userWsdlUrl);
    // testUserActionManagement(userPort, "bwilley@suffolk.edu");
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail("bwilley@suffolk.edu");
    authReq.setPassword(System.getenv("BRYCE_USER_PASSWORD"));
    AuthenticateResponseType authRes = userPort.authenticateUser(authReq);
    System.out.println("Auth'd?: " + authRes.getError().getErrorText());
    List<Header> headersList = TylerUserNamePassword.makeHeaderList(authRes);
    IEfmFirmService firmPort = makeFirmService(firmWsdlUrl, headersList);
    // EfmClient.testFirmManagement(userPort, firmPort);
    // EfmClient.testAttorneyAndServiceManagement(firmPort, true);
    // System.err.println("------------- GLOBAL -------------");
    // EfmClient.paymentAccounts(firmPort, true);
    // System.err.println("------------- FIRM -------------");
    // EfmClient.paymentAccounts(firmPort, false);
    // EfmClient.testFilingService(filingPort, "adams");
    CodeDatabase cd = new CodeDatabase(System.getenv("POSTGRES_URL"), 
        Integer.parseInt(System.getenv("POSTGRES_PORT")), 
        System.getenv("POSTGRES_CODES_DB"));
    cd.createDbConnection(System.getenv("POSTGRES_USER"), System.getenv("POSTGRES_PASSWORD"));

    // List<Person> plaintiffs, List<Person> defendants,
    // List<FilingDoc> filings) throws SQLException, IOException
    Address plaintiffAddress = new Address("83 Fake St", "Apt 2", "Boston", "MA", "02125", CountryCodeSimpleType.US);
    Person plaintiff = new Person(new Name("Plaintiff", "Goth"), "fakeemail@example.com", false);
    Person defendant = new Person(new Name("Defendant", "Zombie"), "fakeemail2@example.com", false);
    List<Person> plaintiffs = List.of(plaintiff);
    List<Person> defendants = List.of(defendant);
    // filing code: complaint (27967): got from filing table, location = 'adams',
    // casecategory='210',
    // and filingtype='Both' or 'Initial'
    NameAndCode regActionDesc = new NameAndCode("Complaint", "27967");
    // SELECT * from filingcomponent where location = 'adams' and
    // filingcodeid='27967';
    String componentCode = "332";
    String fileName = "quality_check_overlay.pdf";
    InputStream x = EfmClient.class.getClassLoader().getResourceAsStream("/" + fileName); 
    FilingDoc filingDoc = new FilingDoc(fileName, x, regActionDesc,
        plaintiffs.stream().map((p) -> p.getIdString()).collect(Collectors.toList()), "5766",
        componentCode, FilingTypeType.E_FILE);

    PaymentAccountListResponseType allAccs = firmPort.getPaymentAccountList();
    String paymentId = "";
    // Manual combination: Decided on Adams, then it's a family, so "Family" name in
    // catecategory table
    // The code for those in adams in 210. Then, get all casetype where
    // casecategory='210'
    // Subtype is never used, the table is empty?
    CaseCategory caseCategory = new CaseCategory("210", "Family", "DomesticCase", "Not Available",
        "Not Available", "Not Available");
    for (PaymentAccountType acc : allAccs.getPaymentAccount()) {
      System.err.println("Acc: " + acc.getAccountName());
      if (acc.getAccountName().equals("Waiver Account")) {
        paymentId = acc.getPaymentAccountID();
      }
    }
    if (paymentId.isEmpty()) {
      System.err.println("Couldn't find Waiver Account account?");
      System.exit(1);
    }
    FilingReviewMDEPort filingPort = makeFilingService(FilingReviewMDEService.WSDL_LOCATION,
        headersList);
    /* EfmClient.sendFiling(filingPort, cd, "adams", plaintiffs, defendants, caseCategory, "25384", "",
          List.of(filing), paymentId);
    
    CourtPolicyQueryMessageType m = new CourtPolicyQueryMessageType(); 
    CourtType court = new CourtType(); 
    IdentificationType courtId = makeIDType("henderson"); 
    ObjectFactory of = new ObjectFactory();
    JAXBElement<IdentificationType> elem =
    of.createOrganizationIdentification(courtId);
    court.setOrganizationIdentification(elem); // TODO(brycew): change this stuff
    m.setSendingMDELocationID(makeIDType("https://filingassemblymde.com"));
    m.setSendingMDEProfileCode(MDE_PROFILE_CODE); 
    JAXBElement<PersonType> elem2 = of.createEntityPerson(new PersonType()); 
    EntityType typ = new EntityType();
    typ.setEntityRepresentation(elem2); 
    m.setQuerySubmitter(typ);
    m.setCaseCourt(court);
     */
    /*
     * Exception in thread "main" javax.xml.ws.soap.SOAPFaultException: The element
     * 'CourtPolicyQueryMessage' in namespace
     * 'urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyQueryMessage-4
     * .0' has invalid child element 'CaseCourt' in namespace
     * 'http://niem.gov/niem/domains/jxdm/4.0'. List of possible elements expected:
     * 'SendingMDELocationID' in namespace
     * 'urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0'. at
     * org.apache.cxf.jaxws.JaxWsClientProxy.mapException(JaxWsClientProxy.java:195)
     * at org.apache.cxf.jaxws.JaxWsClientProxy.invoke(JaxWsClientProxy.java:145) at
     * com.sun.proxy.$Proxy71.getPolicy(Unknown Source) at
     * edu.suffolk.litlab.efspserver.EfmClient.main(EfmClient.java:370) Caused
     * by: org.apache.cxf.binding.soap.SoapFault: The element
     * 'CourtPolicyQueryMessage' in namespace
     * 'urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyQueryMessage-4
     * .0' has invalid child element 'CaseCourt' in namespace
     * 'http://niem.gov/niem/domains/jxdm/4.0'. List of possible elements expected:
     * 'SendingMDELocationID' in namespace
     * 'urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0'. at
     * org.apache.cxf.binding.soap.interceptor.Soap11FaultInInterceptor.
     * unmarshalFault(Soap11FaultInInterceptor.java:87) at
     * org.apache.cxf.binding.soap.interceptor.Soap11FaultInInterceptor.
     * handleMessage(Soap11FaultInInterceptor.java:53) at
     * org.apache.cxf.binding.soap.interceptor.Soap11FaultInInterceptor.
     * handleMessage(Soap11FaultInInterceptor.java:42) // TODO(brycew): this fails
     * because the generated WSDL doesn't actually use the proper security headers.
     * Need to add manually CourtPolicyResponseMessageType p =
     * filingPort.getPolicy(m); // https://stackoverflow.com/a/36762179/11416267
     */
    /*
     * StringBuilder sb = new StringBuilder(); sb.append(p.getCaseCourt().getId() +
     * ", "); //sb.append(p.getCaseCourt().getCourtName().getValue() + ", ");
     * sb.append(p.getSendingMDEProfileCode() + ", ");
     * sb.append(p.getPolicyLastUpdateDate() + ", ");
     * sb.append(p.getPolicyVersionID()); sb.append('\n'); sb.append("Errors: ");
     * for (ErrorType e : p.getError()) { sb.append(e.getErrorCode() + ", ");
     * sb.append(e.getErrorText()); sb.append('\n'); }
     * sb.append("Runtime Policy Params: "); for (CourtCodelistType l :
     * p.getRuntimePolicyParameters().getCourtCodelist()) {
     * sb.append(l.getECFElementName() + ", "); sb.append(l.getEffectiveDate() +
     * ", "); sb.append(l.getCourtCodelistURI() + ", "); } for (OperationNameType t
     * : p.getDevelopmentPolicyParameters().getValue().getSupportedOperationName())
     * { sb.append(t.getValue()); } System.out.print(sb.toString());
     */

    // testUserManagement(userPort);
    // testUserActionManagement(port, "bwilley@suffolk.edu");
  }
}
