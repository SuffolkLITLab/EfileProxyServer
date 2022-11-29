package tyler.efm.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.4
 * 2022-11-29T12:38:21.472-05:00
 * Generated source version: 3.5.4
 *
 */
@WebService(targetNamespace = "urn:tyler:efm:services", name = "IEfmUserService")
@XmlSeeAlso({tyler.efm.services.schema.paymentaccounttypelistresponse.ObjectFactory.class, tyler.efm.services.schema.updatepaymentaccountresponse.ObjectFactory.class, tyler.efm.services.schema.authenticateresponse.ObjectFactory.class, tyler.efm.services.schema.attachservicecontactrequest.ObjectFactory.class, tyler.efm.services.schema.resetpasswordrequest.ObjectFactory.class, tyler.efm.services.schema.getpaymentaccountlistrequest.ObjectFactory.class, tyler.efm.services.schema.getpaymentaccountrequest.ObjectFactory.class, tyler.efm.services.schema.attorneylistresponse.ObjectFactory.class, tyler.efm.services.schema.getuserresponse.ObjectFactory.class, tyler.efm.services.schema.getpasswordquestionrequest.ObjectFactory.class, ObjectFactory.class, tyler.efm.services.schema.getpaymentaccountresponse.ObjectFactory.class, tyler.efm.services.schema.createservicecontactresponse.ObjectFactory.class, tyler.efm.services.schema.removeuserrolerequest.ObjectFactory.class, tyler.efm.services.schema.baseresponse.ObjectFactory.class, tyler.efm.services.schema.changepasswordresponse.ObjectFactory.class, tyler.efm.services.schema.removeattorneyrequest.ObjectFactory.class, tyler.efm.services.schema.updateuserrequest.ObjectFactory.class, tyler.efm.services.schema.createattorneyresponse.ObjectFactory.class, tyler.efm.services.schema.paymentaccountlistresponse.ObjectFactory.class, tyler.efm.services.schema.adduserrolerequest.ObjectFactory.class, tyler.efm.services.schema.baserequest.ObjectFactory.class, tyler.efm.services.schema.registrationresponse.ObjectFactory.class, tyler.efm.services.schema.createpaymentaccountresponse.ObjectFactory.class, tyler.efm.services.schema.selfresendactivationemailrequest.ObjectFactory.class, tyler.efm.services.schema.updateattorneyresponse.ObjectFactory.class, tyler.efm.services.schema.changepasswordrequest.ObjectFactory.class, tyler.efm.services.schema.updateservicecontactrequest.ObjectFactory.class, tyler.efm.services.schema.removeservicecontactrequest.ObjectFactory.class, tyler.efm.services.schema.getservicecontactrequest.ObjectFactory.class, tyler.efm.services.schema.authenticaterequest.ObjectFactory.class, tyler.efm.services.schema.common.ObjectFactory.class, tyler.efm.services.schema.detachservicecontactrequest.ObjectFactory.class, tyler.efm.services.schema.updateservicecontactresponse.ObjectFactory.class, tyler.efm.services.schema.updatefirmrequest.ObjectFactory.class, tyler.efm.services.schema.userlistresponse.ObjectFactory.class, tyler.efm.services.schema.createservicecontactrequest.ObjectFactory.class, tyler.efm.services.schema.resetpasswordresponse.ObjectFactory.class, tyler.efm.services.schema.registrationrequest.ObjectFactory.class, tyler.efm.services.schema.updateattorneyrequest.ObjectFactory.class, tyler.efm.services.schema.createpaymentaccountrequest.ObjectFactory.class, tyler.efm.services.schema.passwordquestionresponse.ObjectFactory.class, tyler.efm.services.schema.getuserrequest.ObjectFactory.class, tyler.efm.services.schema.getfirmresponse.ObjectFactory.class, tyler.efm.services.schema.resetuserpasswordrequest.ObjectFactory.class, tyler.efm.services.schema.removeuserrequest.ObjectFactory.class, tyler.efm.services.schema.getservicecontactresponse.ObjectFactory.class, tyler.efm.services.schema.updatenotificationpreferencesrequest.ObjectFactory.class, tyler.efm.services.schema.getattorneyresponse.ObjectFactory.class, tyler.efm.services.schema.getattorneyrequest.ObjectFactory.class, tyler.efm.services.schema.notificationpreferencesresponse.ObjectFactory.class, tyler.efm.services.schema.servicecontactlistresponse.ObjectFactory.class, tyler.efm.services.schema.updateuserresponse.ObjectFactory.class, tyler.efm.services.schema.resendactivationemailrequest.ObjectFactory.class, tyler.efm.services.schema.updatepaymentaccountrequest.ObjectFactory.class, tyler.efm.services.schema.createattorneyrequest.ObjectFactory.class, tyler.efm.services.schema.removepaymentaccountrequest.ObjectFactory.class})
public interface IEfmUserService {

    @WebMethod(operationName = "AuthenticateUser", action = "urn:tyler:efm:services/IEfmUserService/AuthenticateUser")
    @Action(input = "urn:tyler:efm:services/IEfmUserService/AuthenticateUser", output = "urn:tyler:efm:services/IEfmUserService/AuthenticateUserResponse")
    @RequestWrapper(localName = "AuthenticateUser", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.AuthenticateUser")
    @ResponseWrapper(localName = "AuthenticateUserResponse", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.AuthenticateUserResponse")
    @WebResult(name = "AuthenticateUserResponse", targetNamespace = "urn:tyler:efm:services")
    public tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType authenticateUser(

        @WebParam(name = "AuthenticateRequest", targetNamespace = "urn:tyler:efm:services")
        tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType authenticateRequest
    );

    @WebMethod(operationName = "UpdateUser", action = "urn:tyler:efm:services/IEfmUserService/UpdateUser")
    @Action(input = "urn:tyler:efm:services/IEfmUserService/UpdateUser", output = "urn:tyler:efm:services/IEfmUserService/UpdateUserResponse")
    @RequestWrapper(localName = "UpdateUser", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.UpdateUser")
    @ResponseWrapper(localName = "UpdateUserResponse", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.UpdateUserResponse")
    @WebResult(name = "UpdateUserResponse", targetNamespace = "urn:tyler:efm:services")
    public tyler.efm.services.schema.updateuserresponse.UpdateUserResponseType updateUser(

        @WebParam(name = "UpdateUserRequest", targetNamespace = "urn:tyler:efm:services")
        tyler.efm.services.schema.updateuserrequest.UpdateUserRequestType updateUserRequest
    );

    @WebMethod(operationName = "GetNotificationPreferences", action = "urn:tyler:efm:services/IEfmUserService/GetNotificationPreferences")
    @Action(input = "urn:tyler:efm:services/IEfmUserService/GetNotificationPreferences", output = "urn:tyler:efm:services/IEfmUserService/GetNotificationPreferencesResponse")
    @RequestWrapper(localName = "GetNotificationPreferences", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.GetNotificationPreferences")
    @ResponseWrapper(localName = "GetNotificationPreferencesResponse", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.GetNotificationPreferencesResponse")
    @WebResult(name = "GetNotificationPreferencesResponse", targetNamespace = "urn:tyler:efm:services")
    public tyler.efm.services.schema.notificationpreferencesresponse.NotificationPreferencesResponseType getNotificationPreferences()
;

    @WebMethod(operationName = "GetUser", action = "urn:tyler:efm:services/IEfmUserService/GetUser")
    @Action(input = "urn:tyler:efm:services/IEfmUserService/GetUser", output = "urn:tyler:efm:services/IEfmUserService/GetUserResponse")
    @RequestWrapper(localName = "GetUser", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.GetUser")
    @ResponseWrapper(localName = "GetUserResponse", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.GetUserResponse")
    @WebResult(name = "GetUserResponse", targetNamespace = "urn:tyler:efm:services")
    public tyler.efm.services.schema.getuserresponse.GetUserResponseType getUser(

        @WebParam(name = "GetUserRequest", targetNamespace = "urn:tyler:efm:services")
        tyler.efm.services.schema.getuserrequest.GetUserRequestType getUserRequest
    );

    @WebMethod(operationName = "SelfResendActivationEmail", action = "urn:tyler:efm:services/IEfmUserService/SelfResendActivationEmail")
    @Action(input = "urn:tyler:efm:services/IEfmUserService/SelfResendActivationEmail", output = "urn:tyler:efm:services/IEfmUserService/SelfResendActivationEmailResponse")
    @RequestWrapper(localName = "SelfResendActivationEmail", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.SelfResendActivationEmail")
    @ResponseWrapper(localName = "SelfResendActivationEmailResponse", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.SelfResendActivationEmailResponse")
    @WebResult(name = "SelfResendActivationEmailResponse", targetNamespace = "urn:tyler:efm:services")
    public tyler.efm.services.schema.baseresponse.BaseResponseType selfResendActivationEmail(

        @WebParam(name = "SelfResendActivationEmailRequest", targetNamespace = "urn:tyler:efm:services")
        tyler.efm.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType selfResendActivationEmailRequest
    );

    @WebMethod(operationName = "ResetPassword", action = "urn:tyler:efm:services/IEfmUserService/ResetPassword")
    @Action(input = "urn:tyler:efm:services/IEfmUserService/ResetPassword", output = "urn:tyler:efm:services/IEfmUserService/ResetPasswordResponse")
    @RequestWrapper(localName = "ResetPassword", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.ResetPassword")
    @ResponseWrapper(localName = "ResetPasswordResponse", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.ResetPasswordResponse")
    @WebResult(name = "ResetPasswordResponse", targetNamespace = "urn:tyler:efm:services")
    public tyler.efm.services.schema.resetpasswordresponse.ResetPasswordResponseType resetPassword(

        @WebParam(name = "ResetPasswordRequest", targetNamespace = "urn:tyler:efm:services")
        tyler.efm.services.schema.resetpasswordrequest.ResetPasswordRequestType resetPasswordRequest
    );

    @WebMethod(operationName = "GetPasswordQuestion", action = "urn:tyler:efm:services/IEfmUserService/GetPasswordQuestion")
    @Action(input = "urn:tyler:efm:services/IEfmUserService/GetPasswordQuestion", output = "urn:tyler:efm:services/IEfmUserService/GetPasswordQuestionResponse")
    @RequestWrapper(localName = "GetPasswordQuestion", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.GetPasswordQuestion")
    @ResponseWrapper(localName = "GetPasswordQuestionResponse", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.GetPasswordQuestionResponse")
    @WebResult(name = "GetPasswordQuestionResponse", targetNamespace = "urn:tyler:efm:services")
    public tyler.efm.services.schema.passwordquestionresponse.PasswordQuestionResponseType getPasswordQuestion(

        @WebParam(name = "GetPasswordQuestionRequest", targetNamespace = "urn:tyler:efm:services")
        tyler.efm.services.schema.getpasswordquestionrequest.GetPasswordQuestionRequestType getPasswordQuestionRequest
    );

    @WebMethod(operationName = "ChangePassword", action = "urn:tyler:efm:services/IEfmUserService/ChangePassword")
    @Action(input = "urn:tyler:efm:services/IEfmUserService/ChangePassword", output = "urn:tyler:efm:services/IEfmUserService/ChangePasswordResponse")
    @RequestWrapper(localName = "ChangePassword", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.ChangePassword")
    @ResponseWrapper(localName = "ChangePasswordResponse", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.ChangePasswordResponse")
    @WebResult(name = "ChangePasswordResponse", targetNamespace = "urn:tyler:efm:services")
    public tyler.efm.services.schema.changepasswordresponse.ChangePasswordResponseType changePassword(

        @WebParam(name = "ChangePasswordRequest", targetNamespace = "urn:tyler:efm:services")
        tyler.efm.services.schema.changepasswordrequest.ChangePasswordRequestType changePasswordRequest
    );

    @WebMethod(operationName = "UpdateNotificationPreferences", action = "urn:tyler:efm:services/IEfmUserService/UpdateNotificationPreferences")
    @Action(input = "urn:tyler:efm:services/IEfmUserService/UpdateNotificationPreferences", output = "urn:tyler:efm:services/IEfmUserService/UpdateNotificationPreferencesResponse")
    @RequestWrapper(localName = "UpdateNotificationPreferences", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.UpdateNotificationPreferences")
    @ResponseWrapper(localName = "UpdateNotificationPreferencesResponse", targetNamespace = "urn:tyler:efm:services", className = "tyler.efm.services.UpdateNotificationPreferencesResponse")
    @WebResult(name = "UpdateNotificationPreferencesResponse", targetNamespace = "urn:tyler:efm:services")
    public tyler.efm.services.schema.baseresponse.BaseResponseType updateNotificationPreferences(

        @WebParam(name = "UpdateNotificationPreferencesRequest", targetNamespace = "urn:tyler:efm:services")
        tyler.efm.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType updateNotificationPreferencesRequest
    );
}
