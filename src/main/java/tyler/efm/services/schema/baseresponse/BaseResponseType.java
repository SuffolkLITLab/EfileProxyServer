
package tyler.efm.services.schema.baseresponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import tyler.efm.services.schema.attorneylistresponse.AttorneyListResponseType;
import tyler.efm.services.schema.authenticateresponse.AuthenticateResponseType;
import tyler.efm.services.schema.changepasswordresponse.ChangePasswordResponseType;
import tyler.efm.services.schema.common.ErrorType;
import tyler.efm.services.schema.createattorneyresponse.CreateAttorneyResponseType;
import tyler.efm.services.schema.createpaymentaccountresponse.CreatePaymentAccountResponseType;
import tyler.efm.services.schema.createservicecontactresponse.CreateServiceContactResponseType;
import tyler.efm.services.schema.getattorneyresponse.GetAttorneyResponseType;
import tyler.efm.services.schema.getfirmresponse.GetFirmResponseType;
import tyler.efm.services.schema.getpaymentaccountresponse.GetPaymentAccountResponseType;
import tyler.efm.services.schema.getservicecontactresponse.GetServiceContactResponseType;
import tyler.efm.services.schema.getuserresponse.GetUserResponseType;
import tyler.efm.services.schema.notificationpreferencesresponse.NotificationPreferencesResponseType;
import tyler.efm.services.schema.passwordquestionresponse.PasswordQuestionResponseType;
import tyler.efm.services.schema.paymentaccountlistresponse.PaymentAccountListResponseType;
import tyler.efm.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType;
import tyler.efm.services.schema.registrationresponse.RegistrationResponseType;
import tyler.efm.services.schema.resetpasswordresponse.ResetPasswordResponseType;
import tyler.efm.services.schema.servicecontactlistresponse.ServiceContactListResponseType;
import tyler.efm.services.schema.updateattorneyresponse.UpdateAttorneyResponseType;
import tyler.efm.services.schema.updatepaymentaccountresponse.UpdatePaymentAccountResponseType;
import tyler.efm.services.schema.updateservicecontactresponse.UpdateServiceContactResponseType;
import tyler.efm.services.schema.updateuserresponse.UpdateUserResponseType;
import tyler.efm.services.schema.userlistresponse.UserListResponseType;


/**
 * &lt;p&gt;Java class for BaseResponseType complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="BaseResponseType"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="Error" type="{urn:tyler:efm:services:schema:Common}ErrorType" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResponseType", propOrder = {
    "error"
})
@XmlSeeAlso({
    UserListResponseType.class,
    GetAttorneyResponseType.class,
    ChangePasswordResponseType.class,
    ResetPasswordResponseType.class,
    AttorneyListResponseType.class,
    UpdatePaymentAccountResponseType.class,
    ServiceContactListResponseType.class,
    GetServiceContactResponseType.class,
    CreatePaymentAccountResponseType.class,
    UpdateAttorneyResponseType.class,
    CreateServiceContactResponseType.class,
    GetUserResponseType.class,
    GetFirmResponseType.class,
    PaymentAccountTypeListResponseType.class,
    PasswordQuestionResponseType.class,
    CreateAttorneyResponseType.class,
    GetPaymentAccountResponseType.class,
    PaymentAccountListResponseType.class,
    RegistrationResponseType.class,
    UpdateServiceContactResponseType.class,
    AuthenticateResponseType.class,
    UpdateUserResponseType.class,
    NotificationPreferencesResponseType.class
})
public class BaseResponseType {

    @XmlElement(name = "Error")
    protected ErrorType error;

    /**
     * Gets the value of the error property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorType }
     *     
     */
    public ErrorType getError() {
        return error;
    }

    /**
     * Sets the value of the error property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorType }
     *     
     */
    public void setError(ErrorType value) {
        this.error = value;
    }

}
