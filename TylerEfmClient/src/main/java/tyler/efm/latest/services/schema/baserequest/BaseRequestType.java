
package tyler.efm.latest.services.schema.baserequest;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import tyler.efm.latest.services.schema.adduserrolerequest.AddUserRoleRequestType;
import tyler.efm.latest.services.schema.attachservicecontactrequest.AttachServiceContactRequestType;
import tyler.efm.latest.services.schema.authenticaterequest.AuthenticateRequestType;
import tyler.efm.latest.services.schema.changepasswordrequest.ChangePasswordRequestType;
import tyler.efm.latest.services.schema.createattorneyrequest.CreateAttorneyRequestType;
import tyler.efm.latest.services.schema.createpaymentaccountrequest.CreatePaymentAccountRequestType;
import tyler.efm.latest.services.schema.createservicecontactrequest.CreateServiceContactRequestType;
import tyler.efm.latest.services.schema.detachservicecontactrequest.DetachServiceContactRequestType;
import tyler.efm.latest.services.schema.getattorneyrequest.GetAttorneyRequestType;
import tyler.efm.latest.services.schema.getpasswordquestionrequest.GetPasswordQuestionRequestType;
import tyler.efm.latest.services.schema.getpaymentaccountlistrequest.GetPaymentAccountListRequestType;
import tyler.efm.latest.services.schema.getpaymentaccountrequest.GetPaymentAccountRequestType;
import tyler.efm.latest.services.schema.getpubliclistrequest.GetPublicListRequestType;
import tyler.efm.latest.services.schema.getservicecontactrequest.GetServiceContactRequestType;
import tyler.efm.latest.services.schema.getuserlistrequest.GetUserListRequest;
import tyler.efm.latest.services.schema.getuserrequest.GetUserRequestType;
import tyler.efm.latest.services.schema.registrationrequest.RegistrationRequestType;
import tyler.efm.latest.services.schema.removeattorneyrequest.RemoveAttorneyRequestType;
import tyler.efm.latest.services.schema.removepaymentaccountrequest.RemovePaymentAccountRequestType;
import tyler.efm.latest.services.schema.removeservicecontactrequest.RemoveServiceContactRequestType;
import tyler.efm.latest.services.schema.removeuserrequest.RemoveUserRequestType;
import tyler.efm.latest.services.schema.removeuserrolerequest.RemoveUserRoleRequestType;
import tyler.efm.latest.services.schema.replaceservicecontactrequest.ReplaceServiceContactRequestType;
import tyler.efm.latest.services.schema.resendactivationemailrequest.ResendActivationEmailRequestType;
import tyler.efm.latest.services.schema.resetpasswordrequest.ResetPasswordRequestType;
import tyler.efm.latest.services.schema.resetuserpasswordrequest.ResetUserPasswordRequestType;
import tyler.efm.latest.services.schema.updateattorneyrequest.UpdateAttorneyRequestType;
import tyler.efm.latest.services.schema.updatefirmrequest.UpdateFirmRequestType;
import tyler.efm.latest.services.schema.updatepaymentaccountrequest.UpdatePaymentAccountRequestType;
import tyler.efm.latest.services.schema.updateservicecontactrequest.UpdateServiceContactRequestType;
import tyler.efm.latest.services.schema.updateuserrequest.UpdateUserRequestType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.cxf.xjc.runtime.JAXBToStringStyle;


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
    RegistrationRequestType.class,
    GetUserListRequest.class,
    GetUserRequestType.class,
    AddUserRoleRequestType.class,
    RemoveUserRoleRequestType.class,
    UpdateUserRequestType.class,
    RemoveUserRequestType.class,
    UpdateFirmRequestType.class,
    GetAttorneyRequestType.class,
    UpdateAttorneyRequestType.class,
    CreateAttorneyRequestType.class,
    RemoveAttorneyRequestType.class,
    GetPaymentAccountListRequestType.class,
    GetPaymentAccountRequestType.class,
    UpdatePaymentAccountRequestType.class,
    CreatePaymentAccountRequestType.class,
    RemovePaymentAccountRequestType.class,
    GetServiceContactRequestType.class,
    UpdateServiceContactRequestType.class,
    CreateServiceContactRequestType.class,
    RemoveServiceContactRequestType.class,
    AttachServiceContactRequestType.class,
    DetachServiceContactRequestType.class,
    ReplaceServiceContactRequestType.class,
    ResetUserPasswordRequestType.class,
    ResendActivationEmailRequestType.class,
    GetPublicListRequestType.class,
    AuthenticateRequestType.class,
    ResetPasswordRequestType.class,
    GetPasswordQuestionRequestType.class,
    ChangePasswordRequestType.class
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
