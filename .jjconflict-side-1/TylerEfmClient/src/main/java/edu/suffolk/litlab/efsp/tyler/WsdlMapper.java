package edu.suffolk.litlab.efsp.tyler;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Maps between different versions of the Tyler WSDL Schema objects.
 *
 * <p>Usage: <code>WsdlMapper mapper = new WsdlMapperImpl();</code> In the application code, we
 * always use the schema objects from the "latest" packages. There are two conversions;
 *
 * <ul>
 *   <li>from the latest objects to earlier versions ( right now, only toV2022). This are usually
 *       the request types being sent to older servers that only understand the early version of the
 *       schema.
 *   <li>from the earlier versions to the latest version (toLatest). This converts the server
 *       responses to the latest version that our application code works with.
 * </ul>
 *
 * .
 */
@Mapper
public interface WsdlMapper {

  public tyler.efm.v2022_1.services.schema.removeservicecontactrequest
          .RemoveServiceContactRequestType
      toV2022(
          tyler.efm.latest.services.schema.removeservicecontactrequest
                  .RemoveServiceContactRequestType
              req);

  public tyler.efm.v2022_1.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType
      toV2022(
          tyler.efm.latest.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType
              req);

  public tyler.efm.v2022_1.services.schema.removeuserrequest.RemoveUserRequestType toV2022(
      tyler.efm.latest.services.schema.removeuserrequest.RemoveUserRequestType req);

  public tyler.efm.v2022_1.services.schema.removepaymentaccountrequest
          .RemovePaymentAccountRequestType
      toV2022(
          tyler.efm.latest.services.schema.removepaymentaccountrequest
                  .RemovePaymentAccountRequestType
              req);

  public tyler.efm.v2022_1.services.schema.removeuserrolerequest.RemoveUserRoleRequestType toV2022(
      tyler.efm.latest.services.schema.removeuserrolerequest.RemoveUserRoleRequestType req);

  public tyler.efm.v2022_1.services.schema.changepasswordrequest.ChangePasswordRequestType toV2022(
      tyler.efm.latest.services.schema.changepasswordrequest.ChangePasswordRequestType req);

  public tyler.efm.v2022_1.services.schema.resetpasswordrequest.ResetPasswordRequestType toV2022(
      tyler.efm.latest.services.schema.resetpasswordrequest.ResetPasswordRequestType req);

  public tyler.efm.v2022_1.services.schema.updateattorneyrequest.UpdateAttorneyRequestType toV2022(
      tyler.efm.latest.services.schema.updateattorneyrequest.UpdateAttorneyRequestType req);

  public tyler.efm.v2022_1.services.schema.registrationrequest.RegistrationRequestType toV2022(
      tyler.efm.latest.services.schema.registrationrequest.RegistrationRequestType req);

  public tyler.efm.v2022_1.services.schema.adduserrolerequest.AddUserRoleRequestType toV2022(
      tyler.efm.latest.services.schema.adduserrolerequest.AddUserRoleRequestType req);

  public tyler.efm.v2022_1.services.schema.getpubliclistrequest.GetPublicListRequestType toV2022(
      tyler.efm.latest.services.schema.getpubliclistrequest.GetPublicListRequestType req);

  public tyler.efm.v2022_1.services.schema.authenticaterequest.AuthenticateRequestType toV2022(
      tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType req);

  public tyler.efm.v2022_1.services.schema.getuserrequest.GetUserRequestType toV2022(
      tyler.efm.latest.services.schema.getuserrequest.GetUserRequestType req);

  public tyler.efm.v2022_1.services.schema.createpaymentaccountrequest
          .CreatePaymentAccountRequestType
      toV2022(
          tyler.efm.latest.services.schema.createpaymentaccountrequest
                  .CreatePaymentAccountRequestType
              req);

  public tyler.efm.v2022_1.services.schema.updatepaymentaccountrequest
          .UpdatePaymentAccountRequestType
      toV2022(
          tyler.efm.latest.services.schema.updatepaymentaccountrequest
                  .UpdatePaymentAccountRequestType
              req);

  public tyler.efm.v2022_1.services.schema.removeattorneyrequest.RemoveAttorneyRequestType toV2022(
      tyler.efm.latest.services.schema.removeattorneyrequest.RemoveAttorneyRequestType req);

  public tyler.efm.v2022_1.services.schema.createservicecontactrequest
          .CreateServiceContactRequestType
      toV2022(
          tyler.efm.latest.services.schema.createservicecontactrequest
                  .CreateServiceContactRequestType
              req);

  public tyler.efm.v2022_1.services.schema.updateservicecontactrequest
          .UpdateServiceContactRequestType
      toV2022(
          tyler.efm.latest.services.schema.updateservicecontactrequest
                  .UpdateServiceContactRequestType
              req);

  public tyler.efm.v2022_1.services.schema.getpaymentaccountlistrequest
          .GetPaymentAccountListRequestType
      toV2022(
          tyler.efm.latest.services.schema.getpaymentaccountlistrequest
                  .GetPaymentAccountListRequestType
              req);

  public tyler.efm.v2022_1.services.schema.updatefirmrequest.UpdateFirmRequestType toV2022(
      tyler.efm.latest.services.schema.updatefirmrequest.UpdateFirmRequestType req);

  public tyler.efm.v2022_1.services.schema.getattorneyrequest.GetAttorneyRequestType toV2022(
      tyler.efm.latest.services.schema.getattorneyrequest.GetAttorneyRequestType req);

  public tyler.efm.v2022_1.services.schema.selfresendactivationemailrequest
          .SelfResendActivationEmailRequestType
      toV2022(
          tyler.efm.latest.services.schema.selfresendactivationemailrequest
                  .SelfResendActivationEmailRequestType
              req);

  public tyler.efm.v2022_1.services.schema.attachservicecontactrequest
          .AttachServiceContactRequestType
      toV2022(
          tyler.efm.latest.services.schema.attachservicecontactrequest
                  .AttachServiceContactRequestType
              req);

  public tyler.efm.v2022_1.services.schema.baserequest.BaseRequestType toV2022(
      tyler.efm.latest.services.schema.baserequest.BaseRequestType req);

  public tyler.efm.v2022_1.services.schema.updateuserrequest.UpdateUserRequestType toV2022(
      tyler.efm.latest.services.schema.updateuserrequest.UpdateUserRequestType req);

  public tyler.efm.v2022_1.services.schema.resendactivationemailrequest
          .ResendActivationEmailRequestType
      toV2022(
          tyler.efm.latest.services.schema.resendactivationemailrequest
                  .ResendActivationEmailRequestType
              req);

  public tyler.efm.v2022_1.services.schema.getpasswordquestionrequest.GetPasswordQuestionRequestType
      toV2022(
          tyler.efm.latest.services.schema.getpasswordquestionrequest.GetPasswordQuestionRequestType
              req);

  public tyler.efm.v2022_1.services.schema.createattorneyrequest.CreateAttorneyRequestType toV2022(
      tyler.efm.latest.services.schema.createattorneyrequest.CreateAttorneyRequestType req);

  public tyler.efm.v2022_1.services.schema.detachservicecontactrequest
          .DetachServiceContactRequestType
      toV2022(
          tyler.efm.latest.services.schema.detachservicecontactrequest
                  .DetachServiceContactRequestType
              req);

  public tyler.efm.v2022_1.services.schema.updatenotificationpreferencesrequest
          .UpdateNotificationPreferencesRequestType
      toV2022(
          tyler.efm.latest.services.schema.updatenotificationpreferencesrequest
                  .UpdateNotificationPreferencesRequestType
              req);

  public tyler.efm.v2022_1.services.schema.getservicecontactrequest.GetServiceContactRequestType
      toV2022(
          tyler.efm.latest.services.schema.getservicecontactrequest.GetServiceContactRequestType
              req);

  public tyler.efm.v2022_1.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType
      toV2022(
          tyler.efm.latest.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType
              req);

  @Mapping(target = "status", expression = "java(\"\")")
  @Mapping(target = "notificationContact", expression = "java(List.of())")
  public tyler.efm.latest.services.schema.common.UserType toLatest(
      tyler.efm.v2022_1.services.schema.common.UserType userType);

  public tyler.efm.latest.services.schema.common.RegistrationType toLatest(
      tyler.efm.v2022_1.services.schema.common.RegistrationType regType);

  public tyler.efm.latest.services.schema.baseresponse.BaseResponseType toLatest(
      tyler.efm.v2022_1.services.schema.baseresponse.BaseResponseType resp);

  public tyler.efm.latest.services.schema.getuserresponse.GetUserResponseType toLatest(
      tyler.efm.v2022_1.services.schema.getuserresponse.GetUserResponseType resp);

  public tyler.efm.latest.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType
      toLatest(
          tyler.efm.v2022_1.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType
              req);

  public tyler.efm.latest.services.schema.createservicecontactresponse
          .CreateServiceContactResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.createservicecontactresponse
                  .CreateServiceContactResponseType
              req);

  public tyler.efm.latest.services.schema.notificationpreferencesresponse
          .NotificationPreferencesResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.notificationpreferencesresponse
                  .NotificationPreferencesResponseType
              req);

  public tyler.efm.latest.services.schema.createpaymentaccountresponse
          .CreatePaymentAccountResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.createpaymentaccountresponse
                  .CreatePaymentAccountResponseType
              req);

  public tyler.efm.latest.services.schema.updateattorneyresponse.UpdateAttorneyResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.updateattorneyresponse.UpdateAttorneyResponseType req);

  public tyler.efm.latest.services.schema.attorneylistresponse.AttorneyListResponseType toLatest(
      tyler.efm.v2022_1.services.schema.attorneylistresponse.AttorneyListResponseType req);

  public tyler.efm.latest.services.schema.updatepaymentaccountresponse
          .UpdatePaymentAccountResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.updatepaymentaccountresponse
                  .UpdatePaymentAccountResponseType
              req);

  public tyler.efm.latest.services.schema.notificationpreferenceslistresponse
          .NotificationPreferencesListResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.notificationpreferenceslistresponse
                  .NotificationPreferencesListResponseType
              req);

  public tyler.efm.latest.services.schema.getfirmresponse.GetFirmResponseType toLatest(
      tyler.efm.v2022_1.services.schema.getfirmresponse.GetFirmResponseType req);

  public tyler.efm.latest.services.schema.updateservicecontactresponse
          .UpdateServiceContactResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.updateservicecontactresponse
                  .UpdateServiceContactResponseType
              req);

  public tyler.efm.latest.services.schema.createattorneyresponse.CreateAttorneyResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.createattorneyresponse.CreateAttorneyResponseType req);

  public tyler.efm.latest.services.schema.authenticateresponse.AuthenticateResponseType toLatest(
      tyler.efm.v2022_1.services.schema.authenticateresponse.AuthenticateResponseType req);

  public tyler.efm.latest.services.schema.getattorneyresponse.GetAttorneyResponseType toLatest(
      tyler.efm.v2022_1.services.schema.getattorneyresponse.GetAttorneyResponseType req);

  @Mapping(target = "isMailServiceContact", ignore = true)
  public tyler.efm.latest.services.schema.common.ServiceContactType toLatest(
      tyler.efm.v2022_1.services.schema.common.ServiceContactType contactType);

  public tyler.efm.latest.services.schema.servicecontactlistresponse.ServiceContactListResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.servicecontactlistresponse
                  .ServiceContactListResponseType
              req);

  public tyler.efm.latest.services.schema.passwordquestionresponse.PasswordQuestionResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.passwordquestionresponse.PasswordQuestionResponseType
              req);

  public tyler.efm.latest.services.schema.registrationresponse.RegistrationResponseType toLatest(
      tyler.efm.v2022_1.services.schema.registrationresponse.RegistrationResponseType req);

  public tyler.efm.latest.services.schema.updateuserresponse.UpdateUserResponseType toLatest(
      tyler.efm.v2022_1.services.schema.updateuserresponse.UpdateUserResponseType req);

  public tyler.efm.latest.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.paymentaccountlistresponse
                  .PaymentAccountListResponseType
              req);

  public tyler.efm.latest.services.schema.paymentaccounttypelistresponse
          .PaymentAccountTypeListResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.paymentaccounttypelistresponse
                  .PaymentAccountTypeListResponseType
              req);

  public tyler.efm.latest.services.schema.getvitalchekpaymentaccountidresponse
          .GetVitalChekPaymentAccountIdResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.getvitalchekpaymentaccountidresponse
                  .GetVitalChekPaymentAccountIdResponseType
              req);

  public tyler.efm.latest.services.schema.changepasswordresponse.ChangePasswordResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.changepasswordresponse.ChangePasswordResponseType req);

  public tyler.efm.latest.services.schema.getservicecontactresponse.GetServiceContactResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.getservicecontactresponse.GetServiceContactResponseType
              req);

  @Mapping(target = "paging", ignore = true)
  public tyler.efm.latest.services.schema.userlistresponse.UserListResponseType toLatest(
      tyler.efm.v2022_1.services.schema.userlistresponse.UserListResponseType req);

  public tyler.efm.latest.services.schema.resetpasswordresponse.ResetPasswordResponseType toLatest(
      tyler.efm.v2022_1.services.schema.resetpasswordresponse.ResetPasswordResponseType req);

  public tyler.efm.latest.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType
      toLatest(
          tyler.efm.v2022_1.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType
              req);
}
