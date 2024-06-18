
package tyler.efm.services.schema.baserequest;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;
import tyler.efm.services.schema.adduserrolerequest.AddUserRoleRequestType;
import tyler.efm.services.schema.attachservicecontactrequest.AttachServiceContactRequestType;
import tyler.efm.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.services.schema.changepasswordrequest.ChangePasswordRequestType;
import tyler.efm.services.schema.createattorneyrequest.CreateAttorneyRequestType;
import tyler.efm.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;
import tyler.efm.services.schema.createservicecontactrequest.CreateServiceContactRequestType;
import tyler.efm.services.schema.detachservicecontactrequest.DetachServiceContactRequestType;
import tyler.efm.services.schema.getattorneyrequest.GetAttorneyRequestType;
import tyler.efm.services.schema.getpasswordquestionrequest.GetPasswordQuestionRequestType;
import tyler.efm.services.schema.getpaymentaccountlistrequest.GetPaymentAccountListRequestType;
import tyler.efm.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType;
import tyler.efm.services.schema.getservicecontactrequest.GetServiceContactRequestType;
import tyler.efm.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.services.schema.registrationrequest.RegistrationRequestType;
import tyler.efm.services.schema.removeattorneyrequest.RemoveAttorneyRequestType;
import tyler.efm.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType;
import tyler.efm.services.schema.removeservicecontactrequest.RemoveServiceContactRequestType;
import tyler.efm.services.schema.removeuserrequest.RemoveUserRequestType;
import tyler.efm.services.schema.removeuserrolerequest.RemoveUserRoleRequestType;
import tyler.efm.services.schema.replaceservicecontactrequesttype.ReplaceServiceContactRequestType;
import tyler.efm.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType;
import tyler.efm.services.schema.resetpasswordrequest.ResetPasswordRequestType;
import tyler.efm.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType;
import tyler.efm.services.schema.selfresendactivationemailrequest.SelfResendActivationEmailRequestType;
import tyler.efm.services.schema.updateattorneyrequest.UpdateAttorneyRequestType;
import tyler.efm.services.schema.updatefirmrequest.UpdateFirmRequestType;
import tyler.efm.services.schema.updatenotificationpreferencesrequest.UpdateNotificationPreferencesRequestType;
import tyler.efm.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType;
import tyler.efm.services.schema.updateservicecontactrequest.UpdateServiceContactRequestType;
import tyler.efm.services.schema.updateuserrequest.UpdateUserRequestType;


/**
 * <p>Java class for BaseRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseRequestType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseRequestType")
@XmlSeeAlso({
    ResetPasswordRequestType.class,
    GetPasswordQuestionRequestType.class,
    ChangePasswordRequestType.class,
    AuthenticateRequestType.class,
    GetUserRequestType.class,
    UpdateUserRequestType.class,
    UpdateNotificationPreferencesRequestType.class,
    SelfResendActivationEmailRequestType.class,
    UpdateServiceContactRequestType.class,
    UpdatePaymentAccountRequestType.class,
    UpdateFirmRequestType.class,
    UpdateAttorneyRequestType.class,
    ResetUserPasswordRequestType.class,
    ResendActivationEmailRequestType.class,
    RemoveUserRoleRequestType.class,
    RemoveUserRequestType.class,
    RemoveServiceContactRequestType.class,
    RemovePaymentAccountRequestType.class,
    RemoveAttorneyRequestType.class,
    GetServiceContactRequestType.class,
    GetPaymentAccountListRequestType.class,
    GetPaymentAccountRequestType.class,
    GetAttorneyRequestType.class,
    ReplaceServiceContactRequestType.class,
    DetachServiceContactRequestType.class,
    CreateServiceContactRequestType.class,
    CreatePaymentAccountRequestType.class,
    CreateAttorneyRequestType.class,
    AttachServiceContactRequestType.class,
    AddUserRoleRequestType.class,
    RegistrationRequestType.class
})
public class BaseRequestType {


    /**
     * Generates a String representation of the contents of this type.
     * This is an extension method, produced by the 'ts' xjc plugin
     * 
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, JAXBToStringStyle.DEFAULT_STYLE);
    }

}
