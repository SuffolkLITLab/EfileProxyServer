package edu.suffolk.litlab.efsp.server.services;

import static edu.suffolk.litlab.efsp.server.utils.ServiceHelpers.setupFirmPort;
import static edu.suffolk.litlab.efsp.tyler.TylerErrorCodes.makeResponse;

import com.hubspot.algebra.NullValue;
import com.hubspot.algebra.Result;
import com.webcohesion.enunciate.metadata.rs.ResponseCode;
import com.webcohesion.enunciate.metadata.rs.StatusCodes;
import edu.suffolk.litlab.efsp.db.LoginDatabase;
import edu.suffolk.litlab.efsp.db.model.AtRest;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CodeDatabase;
import edu.suffolk.litlab.efsp.ecfcodes.tyler.CourtLocationInfo;
import edu.suffolk.litlab.efsp.server.auth.TylerLogin;
import edu.suffolk.litlab.efsp.server.utils.EndpointReflection;
import edu.suffolk.litlab.efsp.server.utils.MDCWrappers;
import edu.suffolk.litlab.efsp.server.utils.ServiceHelpers;
import edu.suffolk.litlab.efsp.stdlib.StdLib;
import edu.suffolk.litlab.efsp.tyler.TylerClients;
import edu.suffolk.litlab.efsp.tyler.TylerEnv;
import edu.suffolk.litlab.efsp.tyler.TylerErrorCodes;
import edu.suffolk.litlab.efsp.tyler.TylerFirmClient;
import edu.suffolk.litlab.efsp.tyler.TylerUserClient;
import edu.suffolk.litlab.efsp.tyler.TylerUserNamePassword;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.BindingProvider;
import java.net.URI;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import javax.sql.DataSource;
import org.apache.cxf.headers.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import tyler.efm.EfmFirmService;
import tyler.efm.EfmUserService;
import tyler.efm.latest.services.schema.adduserrolerequest.AddUserRoleRequestType;
import tyler.efm.latest.services.schema.baseresponse.BaseResponseType;
import tyler.efm.latest.services.schema.changepasswordrequest.ChangePasswordRequestType;
import tyler.efm.latest.services.schema.changepasswordresponse.ChangePasswordResponseType;
import tyler.efm.latest.services.schema.common.NotificationType;
import tyler.efm.latest.services.schema.common.PagingType;
import tyler.efm.latest.services.schema.common.RegistrationType;
import tyler.efm.latest.services.schema.common.RoleLocationType;
import tyler.efm.latest.services.schema.common.UserType;
import tyler.efm.latest.services.schema.getuserlistrequest.GetUserListRequest;
import tyler.efm.latest.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.latest.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.latest.services.schema.notificationpreferenceslistresponse.NotificationPreferencesListResponseType;
import tyler.efm.latest.services.schema.notificationpreferencesresponse.NotificationPreferencesResponseType;
import tyler.efm.latest.services.schema.registrationrequest.RegistrationRequestType;
import tyler.efm.latest.services.schema.registrationresponse.RegistrationResponseType;
import tyler.efm.latest.services.schema.removeuserrequest.RemoveUserRequestType;
import tyler.efm.latest.services.schema.removeuserrolerequest.RemoveUserRoleRequestType;
import tyler.efm.latest.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType;
import tyler.efm.latest.services.schema.resetpasswordrequest.ResetPasswordRequestType;
import tyler.efm.latest.services.schema.resetpasswordresponse.ResetPasswordResponseType;
import tyler.efm.latest.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType;
import tyler.efm.latest.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType;
import tyler.efm.latest.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType;
import tyler.efm.latest.services.schema.updateuserrequest.UpdateUserRequestType;
import tyler.efm.latest.services.schema.updateuserresponse.UpdateUserResponseType;
import tyler.efm.latest.services.schema.userlistresponse.UserListResponseType;

/**
 * Covers all of the FirmUserManagement and UserService operations.
 *
 * <p><strong>User Service</strong>
 *
 * <ul>
 *   <li>AuthenticateUser
 *   <li>ChangePassword
 *   <li>ResetPassword
 *   <li>GetUser (User Service)
 *   <li>UpdateUser (User Service)
 *   <li>GetNotificationPreferences
 *   <li>UpdateNotificationPreferences
 *   <li>SelfResendActivationEmail
 * </ul>
 *
 * <strong>Firm User Management</strong>
 *
 * <ul>
 *   <li>RegisterUser: PUT on /users
 *   <li>AddUserRole: POST on /users/{id}/role
 *   <li>GetUser: GET on /users/{id}
 *   <li>GetUserList: GET on /users
 *   <li>RemoveUser: DELETE on /users/{id}
 *   <li>RemoveUserRole: DELETE on /users/{id}/role
 *   <li>ResendActivationEmail
 *   <li>ResetUserPassword
 *   <li>UpdateUser: POST on /users/{id}
 *   <li>GetNotificationPreferencesList
 * </ul>
 *
 * @author brycew
 */
@Produces(MediaType.APPLICATION_JSON)
public class AdminUserService {
  private static final Logger log = LoggerFactory.getLogger(AdminUserService.class);

  private final EfmUserService userFactory;
  private final EfmFirmService firmFactory;
  private final DataSource userDs;
  private final Function<String, Result<NullValue, String>> passwordChecker;
  private final Supplier<CodeDatabase> cdSupplier;
  private final String jurisdiction;

  public AdminUserService(
      String jurisdiction,
      String env,
      DataSource userDs,
      Supplier<CodeDatabase> cdSupplier,
      Function<String, Result<NullValue, String>> passwordChecker) {
    this.jurisdiction = jurisdiction;
    this.passwordChecker = passwordChecker;
    Optional<EfmUserService> maybeUserFactory =
        TylerClients.getEfmUserFactory(jurisdiction, TylerEnv.parse(env));
    if (maybeUserFactory.isEmpty()) {
      throw new RuntimeException(
          "Can't find " + jurisdiction + " in the SoapClientChooser for EfmUser");
    }
    this.userFactory = maybeUserFactory.get();
    ;
    Optional<EfmFirmService> maybeFirmFactory =
        TylerClients.getEfmFirmFactory(jurisdiction, TylerEnv.parse(env));
    if (maybeFirmFactory.isEmpty()) {
      throw new RuntimeException(
          "Can't find " + jurisdiction + " in the SoapClientChooser for EfmFirm factory");
    }
    this.firmFactory = maybeFirmFactory.get();
    this.cdSupplier = cdSupplier;
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
      Optional<TylerUserClient> port = setupUserPort(httpHeaders);
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
      Optional<TylerUserClient> port = setupUserPort(httpHeaders);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      NotificationPreferencesResponseType notifResp = port.get().getNotificationPreferences();

      return TylerErrorCodes.mapTylerCodesToHttp(
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
      Optional<TylerUserClient> port = setupUserPort(httpHeaders);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      UpdateNotificationPreferencesRequestType updateNotif =
          new UpdateNotificationPreferencesRequestType();
      for (NotificationType nt : notifications) {
        updateNotif.getNotification().add(nt);
      }

      BaseResponseType notifResp = port.get().updateNotificationPreferences(updateNotif);
      return TylerErrorCodes.mapTylerCodesToHttp(notifResp.getError(), () -> Response.ok().build());
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
      Optional<TylerUserClient> port = setupUserPort(httpHeaders, false);
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
      Optional<TylerFirmClient> port =
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

  /**
   * @param httpHeaders Should include the "X-API-KEY" and "TYLER-TOKEN-<jurisdiction>" headers
   *     (should be logged in as a firm admin user).
   * @param id The UUID of the user to reset the password for.
   * @param params The email and newPassword to replace the existing password. The new password
   *     should match the complexity requirements for the jurisdiction. For example: <code>
   *   { "email": "bob@example.com", "newPassword": "wow_new_P@ssword1"}
   *   </code>
   * @return The password hash as a string, if successful
   */
  @StatusCodes({
    @ResponseCode(
        code = 400,
        condition = "Password doesn't match complexity requirements (see data_fields)"),
    @ResponseCode(
        code = 401,
        condition = "API Key not present / Not currently logged in as a firm admin")
  })
  @POST
  @Path("/users/{id}/password")
  public Response resetPassword(
      @Context HttpHeaders httpHeaders, @PathParam("id") String id, ResetPasswordParams params) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.resetPassword");
      Optional<TylerFirmClient> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      // The "1" is the default for all courts. There's no way to enforce court specific passwords
      Result<NullValue, String> passwordGood = passwordChecker.apply(params.newPassword);
      if (passwordGood.isErr()) {
        return Response.status(400)
            .entity(passwordGood.expectErr("invalid internal state"))
            .build();
      }
      ResetUserPasswordRequestType resetReq = new ResetUserPasswordRequestType();
      resetReq.setUserID(id);
      resetReq.setEmail(params.email);
      resetReq.setPassword(params.newPassword);
      ResetPasswordResponseType resp = port.get().resetUserPassword(resetReq);
      return TylerErrorCodes.mapTylerCodesToHttp(
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
      Optional<TylerUserClient> port = setupUserPort(httpHeaders);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }
      Result<NullValue, String> passwordGood = passwordChecker.apply(params.newPassword);
      if (passwordGood.isErr()) {
        return Response.status(400)
            .entity(passwordGood.expectErr("invalid internal state"))
            .build();
      }
      ChangePasswordRequestType change = new ChangePasswordRequestType();
      change.setOldPassword(params.currentPassword);
      change.setNewPassword(params.newPassword);
      change.setPasswordQuestion("");
      change.setPasswordAnswer("");
      ChangePasswordResponseType resp = port.get().changePassword(change);
      return TylerErrorCodes.mapTylerCodesToHttp(
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
      Optional<TylerUserClient> port = setupUserPort(httpHeaders, false);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      ResetPasswordRequestType reset = new ResetPasswordRequestType();
      reset.setEmail(emailToSend);
      ResetPasswordResponseType resp = port.get().resetPassword(reset);
      // TODO(brycew-later): why would we reply with the password hash? They still shouldn't be able
      // to log in?
      return TylerErrorCodes.mapTylerCodesToHttp(
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
        Optional<TylerUserClient> userPort = setupUserPort(httpHeaders);
        if (userPort.isEmpty()) {
          return Response.status(401).build();
        }
        userGetter = (req) -> userPort.get().getUser(getUserReq);
      } else {
        Optional<TylerFirmClient> port =
            setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
        if (port.isEmpty()) {
          return Response.status(401).build();
        }
        userGetter = (req) -> port.get().getUser(getUserReq);
      }
      var userRes = userGetter.apply(getUserReq);
      return TylerErrorCodes.mapTylerCodesToHttp(
          userRes.getError(), () -> Response.ok(userRes.getUser()).build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @GET
  @Path("/users")
  public Response getUserList(
      @Context HttpHeaders httpHeaders,
      @QueryParam("page_index") @DefaultValue("0") int pageIndex,
      @QueryParam("page_size") @DefaultValue("20") int pageSize) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.getUserList");
      Optional<TylerFirmClient> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      var paging = new PagingType();
      paging.setPageIndex(pageIndex);
      paging.setPageSize(pageSize);

      var req = new GetUserListRequest();
      req.setPaging(paging);
      UserListResponseType resp = port.get().getUserList(req);
      return TylerErrorCodes.mapTylerCodesToHttp(
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
      Optional<TylerUserClient> port = setupUserPort(httpHeaders, true);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }
      // Ensure the user exists already.
      GetUserRequestType getUserReq = new GetUserRequestType();
      getUserReq.setUserID(httpHeaders.getHeaderString(TylerLogin.getHeaderId(jurisdiction)));
      GetUserResponseType userRes = port.get().getUser(getUserReq);
      if (TylerErrorCodes.checkErrors(userRes.getError())) {
        return Response.status(401, userRes.getError().getErrorText()).build();
      }

      UpdateUserRequestType updateReq = updateUser(userRes.getUser(), updatedUser);
      UpdateUserResponseType updateResp = port.get().updateUser(updateReq);
      if (TylerErrorCodes.checkErrors(updateResp.getError())) {
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
      Optional<TylerFirmClient> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }
      // Ensure the user exists already.
      GetUserRequestType getUserReq = new GetUserRequestType();
      getUserReq.setUserID(id);
      GetUserResponseType userRes = port.get().getUser(getUserReq);
      if (TylerErrorCodes.checkErrors(userRes.getError())) {
        return Response.status(401, userRes.getError().getErrorText()).build();
      }

      UpdateUserRequestType updateReq = updateUser(userRes.getUser(), updatedUser);
      UpdateUserResponseType updateResp = port.get().updateUser(updateReq);
      if (TylerErrorCodes.checkErrors(updateResp.getError())) {
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
    // Clear status, Tyler doesn't like when we send it.
    existingUser.setStatus(null);
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
      Optional<TylerFirmClient> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      GetUserRequestType getUserReq = new GetUserRequestType();
      getUserReq.setUserID(id);
      GetUserResponseType userRes = port.get().getUser(getUserReq);
      return TylerErrorCodes.mapTylerCodesToHttp(
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
      Optional<TylerFirmClient> port =
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
        if (TylerErrorCodes.checkErrors(resp.getError())) {
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
      Optional<TylerFirmClient> port =
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
        if (TylerErrorCodes.checkErrors(resp.getError())) {
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
   * To register a new user.
   *
   * @param req the registration request: An example:
   *     <pre>
   *   <code>
   *   {
   *     "registrationType": "INDIVIDUAL",
   *     "email": "bob@example.com",
   *     "firstName": "Bob",
   *     "middleName": "",
   *     "lastName": "Brown",
   *     "streetAddressLine1": "123 Main St",
   *     "streetAddressLine2": "Apt 1",
   *     "city": "Boston",
   *     "stateCode": "MA",
   *     "zipCode": "02125",
   *     "countryCode": "US",
   *     "phoneNumber": "617-333-1234"
   *   }
   *   </code>
   *   </pre>
   *
   * @return The object with the user's password hash, their user ID, and their firm ID.
   *     (TODO(bryce): get example).
   */
  @StatusCodes({
    @ResponseCode(
        code = 400,
        condition = "Password doesn't match complexity requirements (see data_fields)"),
    @ResponseCode(code = 401, condition = "API Key not present"),
    @ResponseCode(code = 422, condition = "Missing some required attribute")
  })
  @POST
  @Path("/users")
  public Response registerUser(
      @Context HttpHeaders httpHeaders, final RegistrationRequestType req) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.registerUser");
      final var regType = req.getRegistrationType();
      boolean needsAuth = regType.equals(RegistrationType.FIRM_ADMIN_NEW_MEMBER);
      Optional<TylerFirmClient> port =
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
      try (CodeDatabase cd = cdSupplier.get()) {
        Optional<CourtLocationInfo> system = cd.getFullLocationInfo("0");
        if (system.isPresent()) {
          if (regType.equals(RegistrationType.INDIVIDUAL)
              && !system.get().allowindividualregistration) {
            return Response.status(400)
                .entity("System does not allow individual registration")
                .build();
          }
        }
      } catch (SQLException e) {
        log.error("Couldn't get connection to Codes db:" + StdLib.strFromException(e));
        return Response.status(500).build();
      }

      Result<NullValue, String> passwordGood = passwordChecker.apply(req.getPassword());
      if (passwordGood.isErr()) {
        return Response.status(400)
            .entity(passwordGood.expectErr("invalid internal state"))
            .build();
      }

      RegistrationResponseType regResp = port.get().registerUser(req);
      log.info(
          "Created new user with requested "
              + req.getRegistrationType()
              + ", firm id: "
              + regResp.getFirmID()
              + " and user id: "
              + regResp.getUserID());
      if (!TylerErrorCodes.checkErrors(regResp.getError())) {
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
      Optional<TylerFirmClient> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(401).build();
      }

      RemoveUserRequestType rmUser = new RemoveUserRequestType();
      rmUser.setUserID(id);
      BaseResponseType resp = port.get().removeUser(rmUser);
      return TylerErrorCodes.mapTylerCodesToHttp(resp.getError(), () -> Response.ok().build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  @GET
  @Path("/notification-options")
  public Response getNotificationPreferenceList(@Context HttpHeaders httpHeaders) {
    try {
      MDC.put(MDCWrappers.OPERATION, "AdminUserService.getNotificationPreferenceList");
      Optional<TylerFirmClient> port =
          setupFirmPort(firmFactory, httpHeaders, userDs, jurisdiction);
      if (port.isEmpty()) {
        return Response.status(407).build();
      }

      NotificationPreferencesListResponseType resp = port.get().getNotificationPreferencesList();
      return TylerErrorCodes.mapTylerCodesToHttp(
          resp.getError(), () -> Response.ok(resp.getNotificationListItem()).build());
    } finally {
      MDCWrappers.removeAllMDCs();
    }
  }

  /** Default needsSoapHeader to True: most ops need Tyler Authentication in the SOAP header. */
  private Optional<TylerUserClient> setupUserPort(HttpHeaders httpHeaders) {
    return setupUserPort(httpHeaders, true);
  }

  /**
   * Creates a connection to Tyler's SOAP API that is has the right Auth Headers.
   *
   * @param httpHeaders The context tag from the server method
   * @param needsSoapHeader True if the operation needs Authenticated Tyler creds to work
   * @return false if setup didn't work, and subsequent service calls will likely fail
   */
  private Optional<TylerUserClient> setupUserPort(
      HttpHeaders httpHeaders, boolean needsSoapHeader) {
    String apiKey = httpHeaders.getHeaderString("X-API-KEY");
    try (LoginDatabase ld = new LoginDatabase(userDs.getConnection())) {
      Optional<AtRest> atRest = ld.getAtRestInfo(apiKey);
      if (atRest.isEmpty()) {
        return Optional.empty();
      }
      if (needsSoapHeader) {
        String tylerToken =
            httpHeaders.getHeaderString(TylerLogin.getHeaderKeyFromJurisdiction(jurisdiction));
        MDC.put(MDCWrappers.USER_ID, ld.makeHash(tylerToken));
        Optional<TylerUserNamePassword> creds =
            ServiceHelpers.userCredsFromAuthorization(tylerToken);
        if (creds.isEmpty()) {
          return Optional.empty();
        }
        Consumer<BindingProvider> setup =
            (BindingProvider bp) -> {
              ServiceHelpers.setupServicePort(bp);
              Map<String, Object> ctx = bp.getRequestContext();
              List<Header> headersList = List.of(creds.get().toHeader());
              ctx.put(Header.HEADER_LIST, headersList);
            };
        return Optional.of(new TylerUserClient(userFactory, userFactory.getVersion(), setup));
      } else {
        // Creates a connection to Tyler's SOAP API WITHOUT any Auth headers. Can be used to make an
        // Auth
        // request, or can have the header inserted later.
        return Optional.of(
            new TylerUserClient(
                userFactory, userFactory.getVersion(), ServiceHelpers::setupServicePort));
      }
    } catch (SQLException ex) {
      log.error(StdLib.strFromException(ex));
      return Optional.empty();
    }
  }
}
