package edu.suffolk.assemblyline.efspserver;

import java.io.File;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import tyler.efm.wsdl.webservicesprofile_implementation_4_0.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import org.apache.cxf.headers.Header;
import org.oasis_open.docs.codelist.ns.genericode._1.CodeListDocument;
import org.oasis_open.docs.codelist.ns.genericode._1.Row;

import gov.niem.niem.domains.jxdm._4.CourtType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.ObjectFactory;
import gov.niem.niem.niem_core._2.PersonType;
import oasis.names.specification.ubl.schema.xsd.commonbasiccomponents_2.ServiceTypeCodeType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ErrorType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyquerymessage_4.CourtPolicyQueryMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtCodelistType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.CourtPolicyResponseMessageType;
import oasis.names.tc.legalxml_courtfiling.schema.xsd.courtpolicyresponsemessage_4.OperationNameType;
import oasis.names.tc.legalxml_courtfiling.wsdl.webservicesprofile_definitions_4_0.FilingReviewMDEPort;
import tyler.efm.services.EfmFirmService;
import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.adduserrolerequest.AddUserRoleRequestType;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.services.schema.baseresponse.BaseResponseType;
import tyler.efm.services.schema.changepasswordrequest.ChangePasswordRequestType;
import tyler.efm.services.schema.changepasswordresponse.ChangePasswordResponseType;
import tyler.efm.services.schema.common.NotificationType;
import tyler.efm.services.schema.common.RegistrationType;
import tyler.efm.services.schema.common.RoleType;
import tyler.efm.services.schema.common.UserType;
import tyler.efm.services.schema.getfirmresponse.GetFirmResponseType;
import tyler.efm.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.services.schema.notificationpreferencesresponse.NotificationPreferencesResponseType;
import tyler.efm.services.schema.registrationrequest.RegistrationRequestType;
import tyler.efm.services.schema.registrationresponse.RegistrationResponseType;
import tyler.efm.services.schema.removeuserrequest.RemoveUserRequestType;
import tyler.efm.services.schema.removeuserrolerequest.RemoveUserRoleRequestType;
import tyler.efm.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType;
import tyler.efm.services.schema.resetpasswordrequest.ResetPasswordRequestType;
import tyler.efm.services.schema.resetpasswordresponse.ResetPasswordResponseType;
import tyler.efm.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType;
import tyler.efm.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType;
import tyler.efm.services.schema.updateuserrequest.UpdateUserRequestType;
import tyler.efm.services.schema.updateuserresponse.UpdateUserResponseType;
import tyler.efm.services.schema.userlistresponse.UserListResponseType;

public final class EfspServer {

  private static final QName USER_SERVICE_NAME = new QName("urn:tyler:efm:services", "EfmUserService");
  private static final QName FIRM_SERVICE_NAME = new QName("urn:tyler:efm:services", "EfmFirmService");

  public static void testFirmManagement(IEfmUserService userPort, IEfmFirmService firmPort) throws JAXBException {
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail("bwilley@suffolk.edu");
    authReq.setPassword(System.getenv("BRYCE_USER_PASSWORD"));
    AuthenticateResponseType authRes = userPort.authenticateUser(authReq);

    List<Header> headersList = Arrays.asList(TylerUserNamePassword.makeHeader(authRes.getEmail(), authRes.getPasswordHash()));
    ((BindingProvider) firmPort).getRequestContext().put(Header.HEADER_LIST, headersList); 
    ((BindingProvider) userPort).getRequestContext().put(Header.HEADER_LIST, headersList); 

    GetFirmResponseType firm = firmPort.getFirm();
    System.out.println("Firm info: " + firm.getFirm().getFirmID() + ", " + firm.getFirm().getFirmName());
    
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
    // RegistrationType.INDIVIDUAL doesn't let you have any control over the user or let you delete
    // the account in any way
    regUser.setStateCode("TX");
    regUser.setZipCode("77098");
    regUser.setStreetAddressLine1("123 Fake St");
    regUser.setStreetAddressLine2("Apt 1");
    regUser.setFirmName(firm.getFirm().getFirmName());
    RegistrationResponseType userRes = firmPort.registerUser(regUser);
    System.out.println("New user errors: " + userRes.getError().getErrorCode() + ", " + userRes.getError().getErrorText());
    System.out.println("New User for gmail: " + userRes.getUserID() + ", " + userRes.getFirmID() + ", " + userRes.getExpirationDateTime());

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
    List<Header> headersList = Arrays.asList(TylerUserNamePassword.makeHeader(authRes.getEmail(), authRes.getPasswordHash()));
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
    System.out.println("Successfully changed password?: " + changePassResp.getError().getErrorText());
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
  
  public static IEfmUserService makeUserService(URL userWsdlUrl) {
    EfmUserService ss = new EfmUserService(userWsdlUrl, USER_SERVICE_NAME);
    System.out.println(userWsdlUrl.getHost()+ userWsdlUrl.getPath());
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
    EfmFirmService ss = new EfmFirmService(firmWsdlUrl, FIRM_SERVICE_NAME);
    IEfmFirmService port = ss.getBasicHttpBindingIEfmFirmService();
    BindingProvider bp = (BindingProvider) port;
    Map<String, Object> ctx = bp.getRequestContext();
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
    FilingReviewMDEService filingService = new FilingReviewMDEService(FilingReviewMDEService.WSDL_LOCATION, FilingReviewMDEService.SERVICE);
    FilingReviewMDEPort filingPort = filingService.getFilingReviewMDEPort();
    BindingProvider bp = (BindingProvider) filingPort;
    Map<String, Object> ctx = bp.getRequestContext();
    System.out.println(filingURL.toExternalForm());
    ctx.put(Header.HEADER_LIST, headersList); 
    //ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://illinois-stage.tylerhost.net/efm/FilingReviewMDEPort.svc"); //filingURL.toExternalForm()); 
    ctx.put("security.username", "bwilley@suffolk.edu");
    ctx.put("security.password", "can-be-anything?");
    ctx.put("security.signature.properties", "client_sign.properties");
    ctx.put("security.callback-handler", ClientCallbackHandler.class.getName());
    ctx.put("security.signature.username", "1");
    return filingPort;
  }
  
  public static String objectToXmlString() throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(GetUserRequestType.class);
    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    StringWriter sw = new StringWriter();
    GetUserRequestType req = new GetUserRequestType();
    req.setUserID("123456");
    marshaller.marshal(req, sw);
    return sw.toString();
  }
  
  public static IdentificationType makeIDType(String idStr) {
    IdentificationType id = new IdentificationType();
    gov.niem.niem.proxy.xsd._2.String s = new gov.niem.niem.proxy.xsd._2.String();
    s.setValue(idStr);
    id.setIdentificationID(s); 
    return id;
  }

  public static void main(String[] args) throws JAXBException {
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
    IEfmUserService userPort = makeUserService(userWsdlUrl);
    IEfmFirmService firmPort = makeFirmService(firmWsdlUrl);
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail("bwilley@suffolk.edu");
    authReq.setPassword(System.getenv("BRYCE_USER_PASSWORD"));
    AuthenticateResponseType authRes = userPort.authenticateUser(authReq);
    System.out.println("Auth'd?: " + authRes.getError().getErrorText());
    List<Header> headersList = TylerUserNamePassword.makeHeaderList(authRes); 
    FilingReviewMDEPort filingPort = makeFilingService(FilingReviewMDEService.WSDL_LOCATION, headersList); 
    CourtPolicyQueryMessageType m = new CourtPolicyQueryMessageType();
    CourtType court = new CourtType();
    IdentificationType courtId = makeIDType("henderson"); 
    ObjectFactory of = new ObjectFactory();
    JAXBElement<IdentificationType> elem = of.createOrganizationIdentification(courtId);
    court.setOrganizationIdentification(elem);
    // TODO(brycew): change this stuff
    m.setSendingMDELocationID(makeIDType("https://filingassemblymde.com"));
    m.setSendingMDEProfileCode("urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:WebServicesMessaging-2.0");
    JAXBElement<PersonType> elem2 = of.createEntityPerson(new PersonType());  
    EntityType typ = new EntityType();
    typ.setEntityRepresentation(elem2);
    m.setQuerySubmitter(typ);
    m.setCaseCourt(court);
    /*
     *Exception in thread "main" javax.xml.ws.soap.SOAPFaultException: The element 'CourtPolicyQueryMessage' in namespace 'urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyQueryMessage-4.0' has invalid child element 'CaseCourt' in namespace 'http://niem.gov/niem/domains/jxdm/4.0'. List of possible elements expected: 'SendingMDELocationID' in namespace 'urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0'.
        at org.apache.cxf.jaxws.JaxWsClientProxy.mapException(JaxWsClientProxy.java:195)
        at org.apache.cxf.jaxws.JaxWsClientProxy.invoke(JaxWsClientProxy.java:145)
        at com.sun.proxy.$Proxy71.getPolicy(Unknown Source)
        at edu.suffolk.assemblyline.efspserver.EfspServer.main(EfspServer.java:370)
Caused by: org.apache.cxf.binding.soap.SoapFault: The element 'CourtPolicyQueryMessage' in namespace 'urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CourtPolicyQueryMessage-4.0' has invalid child element 'CaseCourt' in namespace 'http://niem.gov/niem/domains/jxdm/4.0'. List of possible elements expected: 'SendingMDELocationID' in namespace 'urn:oasis:names:tc:legalxml-courtfiling:schema:xsd:CommonTypes-4.0'.
        at org.apache.cxf.binding.soap.interceptor.Soap11FaultInInterceptor.unmarshalFault(Soap11FaultInInterceptor.java:87)
        at org.apache.cxf.binding.soap.interceptor.Soap11FaultInInterceptor.handleMessage(Soap11FaultInInterceptor.java:53)
        at org.apache.cxf.binding.soap.interceptor.Soap11FaultInInterceptor.handleMessage(Soap11FaultInInterceptor.java:42)
     */
    // TODO(brycew): this fails because the generated WSDL doesn't actually use the proper security headers. Need to add manually
    CourtPolicyResponseMessageType p = filingPort.getPolicy(m);
    JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class, gov.niem.niem.structures._2.ObjectFactory.class,
        oasis.names.tc.legalxml_courtfiling.schema.xsd.corefilingmessage_4.ObjectFactory.class, 
        oasis.names.tc.legalxml_courtfiling.schema.xsd.commontypes_4.ObjectFactory.class); 
    Marshaller mar = jc.createMarshaller();
    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    QName qName = new QName("tyler.test.bbb", "bbb");
    JAXBElement<CourtPolicyResponseMessageType> pp = new JAXBElement<CourtPolicyResponseMessageType>(qName, CourtPolicyResponseMessageType.class, p);
    mar.marshal(pp, new File("full_court_obj_henderson.xml"));

    StringBuilder sb = new StringBuilder(); 
    sb.append(p.getCaseCourt().getId() + ", ");
    //sb.append(p.getCaseCourt().getCourtName().getValue() + ", ");
    sb.append(p.getSendingMDEProfileCode() + ", ");
    sb.append(p.getPolicyLastUpdateDate() + ", ");
    sb.append(p.getPolicyVersionID());
    sb.append('\n');
    sb.append("Errors: ");
    for (ErrorType e : p.getError()) {
      sb.append(e.getErrorCode() + ", ");
      sb.append(e.getErrorText());
      sb.append('\n');
    }
    sb.append("Runtime Policy Params: ");
    for (CourtCodelistType l : p.getRuntimePolicyParameters().getCourtCodelist()) {
      sb.append(l.getECFElementName() + ", ");
      sb.append(l.getEffectiveDate() + ", ");
      sb.append(l.getCourtCodelistURI() + ", ");
    }
    for (OperationNameType t : p.getDevelopmentPolicyParameters().getValue().getSupportedOperationName()) {
      sb.append(t.getValue());
    }
    System.out.print(sb.toString());
    
    //testUserManagement(userPort);
    //testUserActionManagement(port, "bwilley@suffolk.edu");
    //testFirmManagement(userPort, firmPort);
  }
}
