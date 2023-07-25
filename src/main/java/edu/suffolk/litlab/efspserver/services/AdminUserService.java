package edu.suffolk.litlab.efspserver.services;

import static edu.suffolk.litlab.efspserver.services.ServiceHelpers.makeResponse;
import static edu.suffolk.litlab.efspserver.services.ServiceHelpers.setupFirmPort;

import edu.suffolk.litlab.efspserver.SoapClientChooser;
import edu.suffolk.litlab.efspserver.StdLib;
import edu.suffolk.litlab.efspserver.TylerUserNamePassword;
import edu.suffolk.litlab.efspserver.codes.CodeDatabase;
import edu.suffolk.litlab.efspserver.codes.CourtLocationInfo;
import edu.suffolk.litlab.efspserver.codes.DataFieldRow;
import edu.suffolk.litlab.efspserver.db.AtRest;
import edu.suffolk.litlab.efspserver.db.LoginDatabase;
import edu.suffolk.litlab.efspserver.ecf.TylerLogin;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.BindingProvider;
import java.net.URI;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import javax.sql.DataSource;
import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import tyler.efm.services.EfmFirmService;
import tyler.efm.services.EfmUserService;
import tyler.efm.services.IEfmFirmService;
import tyler.efm.services.IEfmUserService;
import tyler.efm.services.schema.adduserrolerequest.AddUserRoleRequestType;
import tyler.efm.services.schema.baseresponse.BaseResponseType;
import tyler.efm.services.schema.changepasswordrequest.ChangePasswordRequestType;
import tyler.efm.services.schema.changepasswordresponse.ChangePasswordResponseType;
import tyler.efm.services.schema.common.NotificationType;
import tyler.efm.services.schema.common.RegistrationType;
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
 * Covers all of the FirmUserManagement and UserService operations. * User Service *
 * AuthenticateUser * ChangePassword * ResetPassword * GetUser (User Service) * UpdateUser (User
 * Service) * GetNotificationPreferences * UpdateNotificationPreferences * SelfResendActivationEmail
 * * Firm User Management * RegisterUser: PUT on /users * AddUserRole: POST on /users/{id}/role *
 * GetUser: GET on /users/{id} * GetUserList: GET on /users * RemoveUser: DELETE on /users/{id} *
 * RemoveUserRole: DELETE on /users/{id}/role * ResendActivationEmail * ResetUserPassword *
 * UpdateUser: POST on /users/{id} * GetNotificationPreferencesList
 *
 * @author brycew
 */
@Produces(MediaType.APPLICATION_JSON)
public class AdminUserService {

  private static final Logger log = LoggerFactory.getLogger(AdminUserService.class);

  private final EfmUserService userFactory;
  private final EfmFirmService firmFactory;
  private final DataSource codeDs;
  private final DataSource userDs;
  private final String jurisdiction;
  private final String env;

  public AdminUserService(String jurisdiction, String env, DataSource codeDs, DataSource userDs) {
    this.jurisdiction = jurisdiction;
    this.env = env;
    Optional<EfmUserService> maybeUserFactory =
        SoapClientChooser.getEfmUserFactory(jurisdiction, env);
    if (maybeUserFactory.isEmpty()) {
      throw new RuntimeException(
          "Can't find " + jurisdiction + " in the SoapClientChooser for EfmUser");
    }
    this.userFactory = maybeUserFactory.get();
    ;
    Optional<EfmFirmService> maybeFirmFactory =
        SoapClientChooser.getEfmFirmFactory(jurisdiction, env);
    if (maybeFirmFactory.isEmpty()) {
      throw new RuntimeException(
          "Can't find " + jurisdiction + " in the SoapClientChooser for EfmFirm factory");
    }
    this.firmFactory = maybeFirmFactory.get();
    this.codeDs = codeDs;
    this.userDs = userDs;
  }

  @GET
  @Path("/")
  public Response getAll() {
    EndpointReflection ef =
        new EndpointReflection("/jurisdictions/" + jurisdiction + "/adminusers");
    return Response.ok(ef.endPointsToMap(ef.findRESTEndpoints(List.of(AdminUserService.class))))
        .build();
  }

  @GET
  @Path("/user")
  public Response getSelfUser(@Context HttpHeaders httpHeaders) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.getSelfUser");
      Optional<IEfmUserService> port = setupUserPort(httpHeaders);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }
      String tylerId =
          httpHeaders.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
      if (tylerId == null || tylerId.isBlank()) {
        return Response.status(500)
            .entity(
                "Server does not have a Tyler UUID for the current account. Can you give it to me?")
            .build();
      }

      GetUserRequestType req = new GetUserRequestType();
      req.setUserID(tylerId);
      GetUserResponseType resp = port.get().getUser(req);
      return makeResponse(resp, () -> Response.ok(resp.getUser()).build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @GET
  @Path("/user/notification-preferences")
  public Response getNotificationPrefs(@Context HttpHeaders httpHeaders) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.getNotificationPrefs");
      Optional<IEfmUserService> port = setupUserPort(httpHeaders);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      NotificationPreferencesResponseType notifResp = port.get().getNotificationPreferences();

      return ServiceHelpers.mapTylerCodesToHttp(
          notifResp.getError(), () -> Response.ok(notifResp.getNotification()).build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @PATCH
  @Path("/user/notification-preferences")
  public Response updateNotificationPrefs(
      @Context HttpHeaders httpHeaders, List<NotificationType> notifications) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.updateNotificationPrefs");
      Optional<IEfmUserService> port = setupUserPort(httpHeaders);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      UpdateNotificationPreferencesRequestType updateNotif =
          new UpdateNotificationPreferencesRequestType();
      for (NotificationType nt : notifications) {
        updateNotif.getNotification().add(nt);
      }

      BaseResponseType notifResp = port.get().updateNotificationPreferences(updateNotif);
      return ServiceHelpers.mapTylerCodesToHttp(notifResp.getError(), () -> Response.ok().build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @POST
  @Path("/user/resend-activation-email")
  public Response selfResendActivationEmail(
      @Context HttpHeaders httpHeaders, String emailToSendTo) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.selfResendActivationEmail");
      Optional<IEfmUserService> port = setupUserPort(httpHeaders, false);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      SelfResendActivationEmailRequestType req = new SelfResendActivationEmailRequestType();
      req.setEmail(emailToSendTo);
      BaseResponseType resp = port.get().selfResendActivationEmail(req);
      return makeResponse(resp, () -> Response.noContent().build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @POST
  @Path("/users/{id}/resend-activation-email")
  public Response resendActivationEmail(
      @Context HttpHeaders httpHeaders, @PathParam("id") String id) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.resendActivationEmail");
      Optional<IEfmFirmService> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      ResendActivationEmailRequestType req = new ResendActivationEmailRequestType();
      req.setUserID(id);
      BaseResponseType resp = port.get().resendActivationEmail(req);
      return makeResponse(resp, () -> Response.noContent().build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  public static class ResetPasswordParams {
    public String email;
    public String newPassword;
  }

  @POST
  @Path("/users/{id}/password")
  public Response resetPassword(
      @Context HttpHeaders httpHeaders, @PathParam("id") String id, ResetPasswordParams params) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.resetPassword");
      Optional<IEfmFirmService> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      // The "1" is the default for all courts. There's no way to enforce court specific passwords
      DataFieldRow globalPasswordRow = DataFieldRow.MissingDataField("GlobalPassword");
      try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, codeDs.getConnection())) {
        globalPasswordRow = cd.getDataField("1", "GlobalPassword");
      } catch (SQLException e) {
        log.error("Couldn't get connection to Codes db:" + StdLib.strFromException(e));
      }
      if (!passwordOk(globalPasswordRow, params.newPassword)) {
        return Response.status(400).entity(globalPasswordRow.validationmessage).build();
      }
      ResetUserPasswordRequestType resetReq = new ResetUserPasswordRequestType();
      resetReq.setUserID(id);
      resetReq.setEmail(params.email);
      resetReq.setPassword(params.newPassword);
      ResetPasswordResponseType resp = port.get().resetUserPassword(resetReq);
      return ServiceHelpers.mapTylerCodesToHttp(
          resp.getError(),
          () -> {
            return Response.ok("\"" + resp.getPasswordHash() + "\"").build();
          });
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  public static class SetPasswordParams {
    public String currentPassword;
    public String newPassword;
  }

  @POST
  @Path("/user/password")
  public Response setPassword(@Context HttpHeaders httpHeaders, SetPasswordParams params) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.setPassword");
      Optional<IEfmUserService> port = setupUserPort(httpHeaders);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }
      // The "1" is the default for all courts. There's no way to enforce court specific passwords
      DataFieldRow globalPasswordRow = DataFieldRow.MissingDataField("GlobalPassword");
      try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, codeDs.getConnection())) {
        globalPasswordRow = cd.getDataField("1", "GlobalPassword");
      } catch (SQLException e) {
        log.error("Couldn't get connection to Codes db:" + StdLib.strFromException(e));
      }

      if (!passwordOk(globalPasswordRow, params.newPassword)) {
        return Response.status(400).entity(globalPasswordRow.validationmessage).build();
      }
      ChangePasswordRequestType change = new ChangePasswordRequestType();
      change.setOldPassword(params.currentPassword);
      change.setNewPassword(params.newPassword);
      change.setPasswordQuestion("");
      change.setPasswordAnswer("");
      ChangePasswordResponseType resp = port.get().changePassword(change);
      return ServiceHelpers.mapTylerCodesToHttp(
          resp.getError(),
          () -> {
            return Response.ok("\"" + resp.getPasswordHash() + "\"").build();
          });
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @POST
  @Path("/user/password/reset")
  public Response selfResetPassword(@Context HttpHeaders httpHeaders, String emailToSend) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.selfResetPassword");
      Optional<IEfmUserService> port = setupUserPort(httpHeaders, false);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      ResetPasswordRequestType reset = new ResetPasswordRequestType();
      reset.setEmail(emailToSend);
      ResetPasswordResponseType resp = port.get().resetPassword(reset);
      // TODO(brycew-later): why would we reply with the password hash? They still shouldn't be able
      // to log in?
      return ServiceHelpers.mapTylerCodesToHttp(
          resp.getError(),
          () -> {
            return Response.ok("\"" + resp.getPasswordHash() + "\"").build();
          });
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  /**
   * For GetUser (Firm Service).
   *
   * @param id The id of the user, embedded in the URL
   * @return
   */
  @GET
  @Path("/users/{id}")
  public Response getUser(@Context HttpHeaders httpHeaders, @PathParam("id") String id) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.getUser");
      String tylerId =
          httpHeaders.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
      GetUserRequestType getUserReq = new GetUserRequestType();
      getUserReq.setUserID(id);

      Function<GetUserRequestType, GetUserResponseType> userGetter = null;
      if (tylerId != null && !tylerId.isBlank() && tylerId.equals(id)) {
        Optional<IEfmUserService> userPort = setupUserPort(httpHeaders);
        if (userPort.isEmpty()) {
          return Response.status(401).build();
        }
        userGetter = (req) -> userPort.get().getUser(getUserReq);
      } else {
        Optional<IEfmFirmService> port =
            setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
        if (port.isEmpty()) {
          return Response.status(401).build();
        }
        userGetter = (req) -> port.get().getUser(getUserReq);
      }
      var userRes = userGetter.apply(getUserReq);
      return ServiceHelpers.mapTylerCodesToHttp(
          userRes.getError(), () -> Response.ok(userRes.getUser()).build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @GET
  @Path("/users")
  public Response getUserList(@Context HttpHeaders httpHeaders) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.getUserList");
      Optional<IEfmFirmService> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      UserListResponseType resp = port.get().getUserList();
      return ServiceHelpers.mapTylerCodesToHttp(
          resp.getError(), () -> Response.ok(resp.getUser()).build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @PATCH
  @Path("/user")
  public Response updateUser(@Context HttpHeaders httpHeaders, UserType updatedUser) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.updateUser");
      Optional<IEfmUserService> port = setupUserPort(httpHeaders, true);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }
      // Ensure the user exists already.
      GetUserRequestType getUserReq = new GetUserRequestType();
      getUserReq.setUserID(httpHeaders.getHeaderString(TylerLogin.getHeaderId(jurisdiction)));
      GetUserResponseType userRes = port.get().getUser(getUserReq);
      if (ServiceHelpers.checkErrors(userRes.getError())) {
        return Response.status(401, userRes.getError().getErrorText()).build();
      }

      UpdateUserRequestType updateReq = updateUser(userRes.getUser(), updatedUser);
      UpdateUserResponseType updateResp = port.get().updateUser(updateReq);
      if (ServiceHelpers.checkErrors(updateResp.getError())) {
        return Response.status(401).entity(updateResp.getError().getErrorText()).build();
      }

      return Response.noContent().build();
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  /**
   * For UpdateUser (AdminUserService).
   *
   * @param id The id of the user, embedded in the URL
   * @param updatedUser, null fields are ignored
   * @return
   */
  @PATCH
  @Path("/users/{id}")
  public Response updateUserById(
      @Context HttpHeaders httpHeaders, @PathParam("id") String id, UserType updatedUser) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.updateUserById");
      Optional<IEfmFirmService> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }
      // Ensure the user exists already.
      GetUserRequestType getUserReq = new GetUserRequestType();
      getUserReq.setUserID(id);
      GetUserResponseType userRes = port.get().getUser(getUserReq);
      if (ServiceHelpers.checkErrors(userRes.getError())) {
        return Response.status(401, userRes.getError().getErrorText()).build();
      }

      UpdateUserRequestType updateReq = updateUser(userRes.getUser(), updatedUser);
      UpdateUserResponseType updateResp = port.get().updateUser(updateReq);
      if (ServiceHelpers.checkErrors(updateResp.getError())) {
        return Response.status(401).entity(updateResp.getError().getErrorText()).build();
      }

      return Response.noContent().build();
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  private static UpdateUserRequestType updateUser(UserType existingUser, UserType updatedUser) {
    if (updatedUser.getEmail() != null) {
      existingUser.setEmail(updatedUser.getEmail());
    }
    if (updatedUser.getFirstName() != null) {
      existingUser.setFirstName(updatedUser.getFirstName());
    }
    if (updatedUser.getMiddleName() != null) {
      existingUser.setMiddleName(updatedUser.getMiddleName());
    }
    if (updatedUser.getLastName() != null) {
      existingUser.setLastName(updatedUser.getLastName());
    }
    UpdateUserRequestType updateReq = new UpdateUserRequestType();
    updateReq.setUser(existingUser);
    return updateReq;
  }

  /**
   * Duplicate of GetUser, but just for the roles of that user. More REST-like.
   *
   * @param id The id of the user, embedded in the URL
   * @return
   */
  @GET
  @Path("/users/{id}/roles")
  public Response getRoles(@Context HttpHeaders httpHeaders, @PathParam("id") String id) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.getRoles");
      Optional<IEfmFirmService> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      GetUserRequestType getUserReq = new GetUserRequestType();
      getUserReq.setUserID(id);
      GetUserResponseType userRes = port.get().getUser(getUserReq);
      return ServiceHelpers.mapTylerCodesToHttp(
          userRes.getError(), () -> Response.ok(userRes.getUser().getRole()).build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
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
  public Response addRoles(
      @Context HttpHeaders httpHeaders, @PathParam("id") String id, List<RoleLocationType> toAdd) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.addRoles");
      Optional<IEfmFirmService> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      for (RoleLocationType role : toAdd) {
        AddUserRoleRequestType addRole = new AddUserRoleRequestType();
        addRole.setLocation(role.getLocation());
        addRole.setRole(role.getRoleName());
        addRole.setUserID(id);
        // TODO(brycew-later): this won't be consistent if it fails part way through?
        BaseResponseType resp = port.get().addUserRole(addRole);
        if (ServiceHelpers.checkErrors(resp.getError())) {
          return Response.status(401).entity(resp.getError().getErrorText()).build();
        }
      }

      return Response.noContent().build();
    } finally {
      MDCWrappers.removeAllMDCs();
    }
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
  public Response removeRoles(
      @Context HttpHeaders httpHeaders, @PathParam("id") String id, List<RoleLocationType> toRm) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.removeRoles");
      Optional<IEfmFirmService> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }
      if (toRm == null) {
        return Response.ok().build();
      }

      for (RoleLocationType role : toRm) {
        RemoveUserRoleRequestType rmRole = new RemoveUserRoleRequestType();
        rmRole.setLocation(role.getLocation());
        rmRole.setRole(role.getRoleName());
        rmRole.setUserID(id);
        // TODO(brycew-later): this won't be consistent if it fails part way through?
        BaseResponseType resp = port.get().removeUserRole(rmRole);
        if (ServiceHelpers.checkErrors(resp.getError())) {
          return Response.status(401).entity(resp.getError().getErrorText()).build();
        }
      }

      return Response.ok().build();
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  private static boolean nullOrBlank(String str) {
    return str == null || str.isBlank();
  }

  /**
   * For RegisterUser.
   *
   * @param req
   * @return
   */
  @POST
  @Path("/users")
  public Response registerUser(
      @Context HttpHeaders httpHeaders, final RegistrationRequestType req) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.registerUser");
      final var regType = req.getRegistrationType();
      boolean needsAuth = regType.equals(RegistrationType.FIRM_ADMIN_NEW_MEMBER);
      Optional<IEfmFirmService> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, needsAuth, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }
      if (req.getCountryCode() == null || req.getCountryCode().isBlank()) {
        // By default, assume US.
        req.setCountryCode("US");
      }

      if (regType.equals(RegistrationType.FIRM_ADMINISTRATOR)
          || regType.equals(RegistrationType.INDIVIDUAL)) {
        for (var entry :
            Map.of(
                    "streetAddressLine1", req.getStreetAddressLine1(),
                    "city", req.getCity(),
                    "stateCode", req.getStateCode(),
                    "zipCode", req.getZipCode(),
                    "countryCode", req.getCountryCode(),
                    "phoneNumber", req.getPhoneNumber())
                .entrySet()) {
          if (nullOrBlank(entry.getValue())) {
            return Response.status(422)
                .entity("You are missing " + entry.getKey() + ", which is required")
                .build();
          }
        }
      }
      if (regType.equals(RegistrationType.FIRM_ADMINISTRATOR) && nullOrBlank(req.getFirmName())) {
        return Response.status(422).entity("You are missing firmName, which is required").build();
      }

      // The "1" is the default for all courts. There's no way to enforce court specific passwords
      try (CodeDatabase cd = new CodeDatabase(jurisdiction, env, codeDs.getConnection())) {
        Optional<CourtLocationInfo> system = cd.getFullLocationInfo("0");
        if (system.isPresent()) {
          if (regType.equals(RegistrationType.INDIVIDUAL)
              && !system.get().allowindividualregistration) {
            return Response.status(400)
                .entity("System does not allow individual registration")
                .build();
          }
        }
        DataFieldRow globalPasswordRow = cd.getDataField("1", "GlobalPassword");
        // The "1" is the default for all courts. There's no way to enforce court specific passwords
        if (!passwordOk(globalPasswordRow, req.getPassword())) {
          return Response.status(400).entity(globalPasswordRow.validationmessage).build();
        }
      } catch (SQLException e) {
        log.error("Couldn't get connection to Codes db:" + StdLib.strFromException(e));
        return Response.status(500).build();
      }

      RegistrationResponseType regResp = port.get().registerUser(req);
      log.info(
          "Created new user with requested "
              + req.getRegistrationType()
              + ", firm id: "
              + regResp.getFirmID()
              + " and user id: "
              + regResp.getUserID());
      if (!ServiceHelpers.checkErrors(regResp.getError())) {
        return Response.created(URI.create(regResp.getUserID())).entity(regResp).build();
      }
      return makeResponse(regResp, () -> Response.ok(regResp).build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  /**
   * For RemoveUser.
   *
   * @param id The id of the user to remove, embedded in the URL
   * @return
   */
  @DELETE
  @Path("/users/{id}")
  public Response removeUser(@Context HttpHeaders httpHeaders, @PathParam("id") String id) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.removeUser");
      Optional<IEfmFirmService> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      RemoveUserRequestType rmUser = new RemoveUserRequestType();
      rmUser.setUserID(id);
      BaseResponseType resp = port.get().removeUser(rmUser);
      return ServiceHelpers.mapTylerCodesToHttp(resp.getError(), () -> Response.ok().build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @GET
  @Path("/notification-options")
  public Response getNotificationPreferenceList(@Context HttpHeaders httpHeaders) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.getNotificationPreferenceList");
      Optional<IEfmFirmService> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(407).build();
      }

      NotificationPreferencesListResponseType resp = port.get().getNotificationPreferencesList();
      return ServiceHelpers.mapTylerCodesToHttp(
          resp.getError(), () -> Response.ok(resp.getNotificationListItem()).build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  private static boolean passwordOk(DataFieldRow row, String password) {
    if (row.isvisible && row.isrequired && password != null && !password.isEmpty()) {
      return row.matchRegex(password);
    }
    return true;
  }

  /** Default needsSoapHeader to True: most ops need Tyler Authentication in the SOAP header. */
  private Optional<IEfmUserService> setupUserPort(HttpHeaders httpHeaders) {
    return setupUserPort(httpHeaders, true);
  }

  /**
   * Creates a connection to Tyler's SOAP API that is has the right Auth Headers.
   *
   * @param httpHeaders The context tag from the server method
   * @param needsSoapHeader True if the operation needs Authenticated Tyler creds to work
   * @return false if setup didn't work, and subsequent service calls will likely fail
   */
  private Optional<IEfmUserService> setupUserPort(
      HttpHeaders httpHeaders, boolean needsSoapHeader) {
    String apiKey = httpHeaders.getHeaderString("X-API-KEY");
    try (Connection conn = userDs.getConnection()) {
      LoginDatabase ld = new LoginDatabase(conn);
      Optional<AtRest> atRest = ld.getAtRestInfo(apiKey);
      if (atRest.isEmpty()) {
        return Optional.empty();
      }
      IEfmUserService port = makeUserPort(userFactory);
      if (needsSoapHeader) {
        String tylerToken =
            httpHeaders.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
        MDC.put(MDCWrappers.USER_ID, ld.makeHash(tylerToken));
        Optional<TylerUserNamePassword> creds =
            ServiceHelpers.userCredsFromAuthorization(tylerToken);
        if (creds.isEmpty()) {
          return Optional.empty();
        }
        Map<String, Object> ctx = ((BindingProvider) port).getRequestContext();
        List<Header> headersList = List.of(creds.get().toHeader());
        ctx.put(Header.HEADER_LIST, headersList);
      }
      return Optional.of(port);
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return Optional.empty();
    }
  }

  /**
   * Creates a connection to Tyler's SOAP API WITHOUT any Auth headers. Can be used to make an Auth
   * request, or can have the header inserted later.
   *
   * @param EfmUserService the definition of the SOAP WSDL service
   * @return A port connection to the SOAP server
   */
  private static IEfmUserService makeUserPort(EfmUserService userService) {
    IEfmUserService port = userService.getBasicHttpBindingIEfmUserService();
    ServiceHelpers.setupServicePort((BindingProvider) port);
    return port;
  }
}
