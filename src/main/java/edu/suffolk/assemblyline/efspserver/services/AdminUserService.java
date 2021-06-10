package edu.suffolk.assemblyline.efspserver.services;

import edu.suffolk.assemblyline.efspserver.TylerUserNamePassword;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import org.apache.cxf.headers.Header;
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
import tyler.efm.services.schema.common.RoleLocationType;
import tyler.efm.services.schema.common.UserType;
import tyler.efm.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.services.schema.notificationpreferenceslistresponse.NotificationPreferencesListResponseType;
import tyler.efm.services.schema.notificationpreferencesresponse.NotificationPreferencesResponseType;
import tyler.efm.services.schema.registrationrequest.RegistrationRequestType;
import tyler.efm.services.schema.registrationresponse.RegistrationResponseType;
import tyler.efm.services.schema.removeuserrequest.RemoveUserRequestType;
import tyler.efm.services.schema.removeuserrolerequest.RemoveUserRoleRequestType;
import tyler.efm.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType;
import tyler.efm.services.schema.resetpasswordrequest.ResetPasswordRequestType;
import tyler.efm.services.schema.resetpasswordresponse.ResetPasswordResponseType;
import tyler.efm.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType;
import tyler.efm.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType;
import tyler.efm.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType;
import tyler.efm.services.schema.updateuserrequest.UpdateUserRequestType;
import tyler.efm.services.schema.updateuserresponse.UpdateUserResponseType;
import tyler.efm.services.schema.userlistresponse.UserListResponseType;

/**
 * Covers all of the FirmUserManagement and UserService operations. Progress so far:
 * * User Service
 *   * [x] AuthenticateUser
 *   * [x] ChangePassword
 *   * [ ] ~GetPasswordQuestion~ (is deprecated by Tyler)
 *   * [x] ResetPassword
 *   * [ ] ~GetUser (User Service)~ (use the firm version)
 *   * [ ] ~UpdateUser (User Service)~ (use the firm version, not sure the difference)
 *   * [x] GetNotificationPreferences
 *   * [x] UpdateNotificationPreferences
 *   * [x] SelfResendActivationEmail
 * * Firm User Management
 *   * [x] RegisterUser: PUT on /users
 *   * [x] AddUserRole: POST on /users/{id}/role
 *   * [x] GetUser: GET on /users/{id}
 *   * [ ] GetUserList: GET on /users
 *   * [x] RemoveUser: DELETE on /users/{id}
 *   * [x] RemoveUserRole: DELETE on /users/{id}/role
 *   * [x] ResendActivationEmail
 *   * [x] ResetUserPassword
 *   * [x] UpdateUser: POST on /users/{id}
 *   * [x] GetNotificationPreferencesList
 *
 * @author brycew
 *
 */
@Path("/adminusers/")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class AdminUserService {

  private EfmFirmService firmServiceFactory;
  private EfmUserService userServiceFactory;
  
  public AdminUserService() {
    init();
  }

  final void init() {
    URL firmWsdlUrl = EfmFirmService.WSDL_LOCATION;
    firmServiceFactory = AdminUserService.makeFirmServiceFactory(firmWsdlUrl);
    URL userWsdlUrl = EfmUserService.WSDL_LOCATION;
    userServiceFactory = AdminUserService.makeUserServiceFactory(userWsdlUrl);
  }

  @POST
  @Path("/authenticate/")
  public Response authenticateUser(UserAuth userAuth) {
    System.out.println("Invoking User Auth for " + userAuth.getUsername());
    AuthenticateRequestType authReq = new AuthenticateRequestType();
    authReq.setEmail(userAuth.getUsername());
    authReq.setPassword(userAuth.getPassword());
    if (authReq.getPassword() == null || authReq.getPassword().isBlank()) {
      return Response.status(403, "Password was not provided; you need to send a password").build();
    }
    IEfmUserService userPort = makeUserPort(userServiceFactory);
    AuthenticateResponseType authRes = userPort.authenticateUser(authReq);
    System.out.println(authRes.getError().getErrorText());
    if (!authRes.getError().getErrorCode().equals("0")) {
      return Response.status(403, authRes.getError().getErrorText()).build();
    } else {
      QName qname = new QName("tyler.test.objectToXml", "objectToXml");
      JAXBElement<AuthenticateResponseType> jax = new JAXBElement<AuthenticateResponseType>(
          qname, AuthenticateResponseType.class, authRes);
      return Response.ok(jax.getValue()).build();
    }
  }
  
  @GET
  @Path("/user/notification_preferences")
  public Response getNotificationPrefs(@Context HttpHeaders httpHeaders) {
    Optional<IEfmUserService> port = setupUserPort(httpHeaders);
    if (port.isEmpty()) { 
      return Response.status(403).build();
    }
    
    NotificationPreferencesResponseType notifResp = port.get().getNotificationPreferences();

    return ServiceHelpers.mapTylerCodesToHttp(notifResp.getError(), 
        () -> Response.ok(notifResp.getNotification()).build());
  }
  
  @POST
  @Path("/user/notification_preferences")
  public Response updateNotificationPrefs(@Context HttpHeaders httpHeaders,
      List<NotificationType> notifications) {
    Optional<IEfmUserService> port = setupUserPort(httpHeaders);
    if (port.isEmpty()) { 
      return Response.status(403).build();
    }
    
    UpdateNotificationPreferencesRequestType updateNotif = 
        new UpdateNotificationPreferencesRequestType();
    for (NotificationType nt : notifications) {
      updateNotif.getNotification().add(nt);
    }

    BaseResponseType notifResp = port.get().updateNotificationPreferences(updateNotif);
    return ServiceHelpers.mapTylerCodesToHttp(notifResp.getError(), 
        () -> Response.noContent().build()); 
  }
  
  @POST
  @Path("/user/resend_activation_email")
  public Response selfResendActivationEmail(@Context HttpHeaders httpHeaders,
      String emailToSendTo) {
    Optional<IEfmUserService> port = setupUserPort(httpHeaders);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    
    SelfResendActivationEmailRequestType req = 
        new SelfResendActivationEmailRequestType();
    req.setEmail(emailToSendTo);
    BaseResponseType resp = port.get().selfResendActivationEmail(req);
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), 
        () -> Response.noContent().build()); 
  }
  
  @POST
  @Path("/users/{id}/resend_activation_email")
  public Response resendActivationEmail(@Context HttpHeaders httpHeaders, 
      @PathParam("id") String id) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    
    ResendActivationEmailRequestType req = 
        new ResendActivationEmailRequestType();
    req.setUserID(id);
    BaseResponseType resp = port.get().resendActivationEmail(req);
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), 
        () -> Response.noContent().build()); 
  }
  
  @POST
  @Path("/users/{id}/change_password")
  public Response resetPassword(@Context HttpHeaders httpHeaders,
      @PathParam("id") String id, String email, String password) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    
    ResetUserPasswordRequestType resetReq = new ResetUserPasswordRequestType();
    resetReq.setUserID(id);
    resetReq.setEmail(email);
    resetReq.setPassword(password);
    ResetPasswordResponseType resp = port.get().resetUserPassword(resetReq);
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), 
        () -> Response.ok(resp.getPasswordHash()).build()); 
  }
  
  @POST
  @Path("/user/change_password")
  public Response setPassword(@Context HttpHeaders httpHeaders,
      String oldPassword, String newPassword) {
    Optional<IEfmUserService> port = setupUserPort(httpHeaders);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    
    ChangePasswordRequestType change = new ChangePasswordRequestType();
    change.setOldPassword(oldPassword);
    change.setNewPassword(newPassword);
    ChangePasswordResponseType resp = port.get().changePassword(change);
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), 
        () -> Response.ok(resp.getPasswordHash()).build()); 
  }
  
  @POST
  @Path("/user/reset_password")
  public Response selfResetPassword(@Context HttpHeaders httpHeaders,
      String emailToSend) {
    Optional<IEfmUserService> port = setupUserPort(httpHeaders);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    
    ResetPasswordRequestType reset = new ResetPasswordRequestType();
    reset.setEmail(emailToSend);
    ResetPasswordResponseType resp = port.get().resetPassword(reset);
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), 
        () -> Response.ok(resp.getPasswordHash()).build()); 
  }

  /**
   * For GetUser (Firm Service).
   *
   * @param id The id of the user, embedded in the URL
   * @return
   */
  @GET
  @Path("/users/{id}")
  public Response getUser(@Context HttpHeaders httpHeaders,
      @PathParam("id") String id) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) { 
      return Response.status(403).build();
    }
    
    GetUserRequestType getUserReq = new GetUserRequestType();
    getUserReq.setUserID(id);
    GetUserResponseType userRes = port.get().getUser(getUserReq);
    return ServiceHelpers.mapTylerCodesToHttp(userRes.getError(), 
        () -> Response.ok(userRes.getUser()).build()); 
  }

  @GET
  @Path("/users")
  public Response getUserList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) { 
      return Response.status(403).build();
    }
    
    UserListResponseType resp = port.get().getUserList();
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), 
        () -> Response.ok(resp.getUser()).build());
  }

  /**
   * For UpdateUser (AdminUserService).
   * @param id The id of the user, embedded in the URL
   * @param updatedUser
   * @return
   */
  @POST
  @Path("/users/{id}")
  public Response updateUser(@Context HttpHeaders httpHeaders, 
      @PathParam("id") String id, UserType updatedUser) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) {
      return Response.status(403).build();
    }
    // Ensure the user exists already.
    GetUserRequestType getUserReq = new GetUserRequestType();
    getUserReq.setUserID(id);
    GetUserResponseType userRes = port.get().getUser(getUserReq);
    if (ServiceHelpers.checkErrors(userRes.getError())) {
      return Response.status(401, userRes.getError().getErrorText()).build();
    }
    if (updatedUser.getRole().size() > 0) {
      // Will need to make update and remove Role calls.
      Set<RoleLocationType> newRoles = updatedUser.getRole()
          .stream().collect(Collectors.toSet());
      Set<RoleLocationType> existingRoles = userRes.getUser().getRole()
          .stream().collect(Collectors.toSet());
      Set<RoleLocationType> toAdd = new HashSet<RoleLocationType>();
      for (RoleLocationType role : newRoles) {
        if (!existingRoles.contains(role)) {
          toAdd.add(role);
        }
      }
      Set<RoleLocationType> toRm = new HashSet<RoleLocationType>();
      for (RoleLocationType role : existingRoles) {
        if (!newRoles.contains(role)) {
          toRm.add(role);
        }
      }
    }
    
    UpdateUserRequestType updateReq = new UpdateUserRequestType();
    updateReq.setUser(updatedUser);
    UpdateUserResponseType updateResp = port.get().updateUser(updateReq);
    if (ServiceHelpers.checkErrors(updateResp.getError())) {
      return Response.status(401).entity(updateResp.getError().getErrorText()).build();
    }
    
    return Response.noContent().build();
  }

  /**
   * Duplicate of GetUser, but just for the roles of that user. More REST-like.
   *
   * @param id The id of the user, embedded in the URL
   * @return
   */
  @GET
  @Path("/users/{id}/roles")
  public Response getRoles(@Context HttpHeaders httpHeaders,
      @PathParam("id") String id) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) { 
      return Response.status(403).build();
    }
    
    GetUserRequestType getUserReq = new GetUserRequestType();
    getUserReq.setUserID(id);
    GetUserResponseType userRes = port.get().getUser(getUserReq);
    return ServiceHelpers.mapTylerCodesToHttp(userRes.getError(), 
        () -> Response.ok(userRes.getUser().getRole()).build());
  }

  /**
   * For AddUserRole.
   *
   * @param id
   * @param toAdd
   * @return
   */
  @POST
  @Path("/users/{id}/roles")
  public Response addRoles(@Context HttpHeaders httpHeaders,
      @PathParam("id") String id, List<RoleLocationType> toAdd) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) { 
      return Response.status(403).build();
    }
    
    for (RoleLocationType role : toAdd) {
      AddUserRoleRequestType addRole = new AddUserRoleRequestType();
      addRole.setLocation(role.getLocation());
      addRole.setRole(role.getRoleName());
      addRole.setUserID(id);
      // TODO(brycew): this won't be consistent if it fails part way through?
      BaseResponseType resp = port.get().addUserRole(addRole);
      if (ServiceHelpers.checkErrors(resp.getError())) {
        return Response.status(401).entity(resp.getError().getErrorText()).build();
      }
    }
    
    return Response.noContent().build();
  }

  /**
   * For RemoveUserRole.
   *
   * @param id
   * @param toRm
   * @return
   */
  @DELETE
  @Path("/users/{id}/roles")
  public Response removeRoles(@Context HttpHeaders httpHeaders,
      @PathParam("id") String id, List<RoleLocationType> toRm) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) { 
      return Response.status(403).build();
    }
    
    for (RoleLocationType role : toRm) {
      RemoveUserRoleRequestType rmRole = new RemoveUserRoleRequestType();
      rmRole.setLocation(role.getLocation());
      rmRole.setRole(role.getRoleName());
      rmRole.setUserID(id);
      // TODO(brycew): this won't be consistent if it fails part way through?
      BaseResponseType resp = port.get().removeUserRole(rmRole);
      if (ServiceHelpers.checkErrors(resp.getError())) {
        return Response.status(401).entity(resp.getError().getErrorText()).build();
      }
    }
    
    return Response.ok().build();
    
  }
  
  /**
   * For RegisterUser.
   *
   * @param req
   * @return
   */
  @PUT
  @Path("/users")
  public Response registerUser(@Context HttpHeaders httpHeaders,
      RegistrationRequestType req) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) { 
      return Response.status(403).build();
    }
    
    // TODO(brycew): add a check for global passwords here: in the datafield table, it's name is 'GlobalPassword'
    RegistrationResponseType regResp = port.get().registerUser(req);
    return ServiceHelpers.mapTylerCodesToHttp(regResp.getError(), 
        () -> Response.ok(regResp).build());
  }
  
  /**
   * For RemoveUser.
   *
   * @param id The id of the user to remove, embedded in the URL
   * @return
   */
  @DELETE
  @Path("/users/{id}")
  public Response removeUser(@Context HttpHeaders httpHeaders,
      @PathParam("id") String id) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) {
      return Response.status(407).build();
    }
    
    RemoveUserRequestType rmUser = new RemoveUserRequestType();
    rmUser.setUserID(id);
    BaseResponseType resp = port.get().removeUser(rmUser);
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), 
        () -> Response.ok().build());
  }
  
  @GET
  @Path("/notification_options")
  public Response getNotificationPreferenceList(@Context HttpHeaders httpHeaders) {
    Optional<IEfmFirmService> port = setupFirmPort(httpHeaders);
    if (port.isEmpty()) {
      return Response.status(407).build();
    }
    
    NotificationPreferencesListResponseType resp = port.get().getNotificationPreferencesList();
    return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), 
        () -> Response.ok(resp.getNotificationListItem()).build());
  }
  
  private Optional<IEfmFirmService> setupFirmPort(HttpHeaders httpHeaders) {
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromHeaders(httpHeaders);
    if (creds.isEmpty()) {
      return Optional.empty();
    }

    IEfmFirmService port = firmServiceFactory.getBasicHttpBindingIEfmFirmService();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    try {
      List<Header> headersList = List.of(creds.get().toHeader());
      ctx.put(Header.HEADER_LIST, headersList);
    } catch (JAXBException ex) {
      System.err.println(ex.toString());
      return Optional.empty();
    }

    return Optional.of(port);
  }

  /** Creates a connection to Tyler's SOAP API that is has the right Auth Headers.
   *
   * @param httpHeaders The context tag from the server method
   * @return false if setup didn't work, and subsequent service calls will likely fail
   */
  private Optional<IEfmUserService> setupUserPort(HttpHeaders httpHeaders) {
    Optional<TylerUserNamePassword> creds = ServiceHelpers.userCredsFromHeaders(httpHeaders);
    if (creds.isEmpty()) {
      return Optional.empty();
    }

    IEfmUserService port = makeUserPort(userServiceFactory); 
    Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
    try {
      List<Header> headersList = List.of(creds.get().toHeader());
      ctx.put(Header.HEADER_LIST, headersList);
    } catch (JAXBException ex) {
      System.err.println(ex.toString());
      return Optional.empty();
    }

    return Optional.of(port);
  }
  
  /** Creates a connection to Tyler's SOAP API WITHOUT any Auth headers.
   * Can be used to make an Auth request, or can have the header inserted later.
   *
   * @param EfmUserService the definition of the SOAP WSDL service 
   * @return A port connection to the SOAP server 
   */
  private static IEfmUserService makeUserPort(EfmUserService userService) {
    IEfmUserService port = userService.getBasicHttpBindingIEfmUserService();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    return port;
  }
  
  private static EfmFirmService makeFirmServiceFactory(URL firmWsdlUrl) {
    return new EfmFirmService(firmWsdlUrl, EfmFirmService.SERVICE); 
  }

  public static EfmUserService makeUserServiceFactory(URL userWsdlUrl) {
    return new EfmUserService(userWsdlUrl, EfmUserService.SERVICE);
  }
  
}
