package edu.suffolk.litlab.efsp.tyler;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.Converter;
import tyler.efm.latest.services.schema.common.AddressType;
import tyler.efm.latest.services.schema.common.AttorneyType;
import tyler.efm.latest.services.schema.common.ErrorType;
import tyler.efm.latest.services.schema.common.FirmType;
import tyler.efm.latest.services.schema.common.LocationNode;
import tyler.efm.latest.services.schema.common.NotificationType;
import tyler.efm.latest.services.schema.common.PaymentAccountLocation;
import tyler.efm.latest.services.schema.common.PaymentAccountLocationDetails;
import tyler.efm.latest.services.schema.common.PaymentAccountType;
import tyler.efm.latest.services.schema.common.PaymentAccountTypeType;
import tyler.efm.latest.services.schema.common.RegistrationType;
import tyler.efm.latest.services.schema.common.RoleLocationType;
import tyler.efm.latest.services.schema.common.RoleType;
import tyler.efm.latest.services.schema.common.ServiceContactType;
import tyler.efm.latest.services.schema.common.UserType;
import tyler.efm.latest.services.schema.paymentaccounttypelistresponse.PaymentAccountTypeListResponseType;

public class Conversion {

  private static CustomBeanConverter converter;

  static {
    converter = new CustomBeanConverter();
    var utils = BeanUtilsBean.getInstance().getConvertUtils();
    var classesToRegister =
        List.of(
            AddressType.class,
            AttorneyType.class,
            ErrorType.class,
            FirmType.class,
            LocationNode.class,
            NotificationType.class,
            PaymentAccountLocation.class,
            PaymentAccountLocationDetails.class,
            PaymentAccountType.class,
            PaymentAccountTypeType.class,
            PaymentAccountTypeListResponseType.class,
            RegistrationType.class,
            RoleLocationType.class,
            RoleType.class,
            ServiceContactType.class,
            UserType.class,
            tyler.efm.v2022_1.services.schema.common.AddressType.class,
            tyler.efm.v2022_1.services.schema.common.AttorneyType.class,
            tyler.efm.v2022_1.services.schema.common.ErrorType.class,
            tyler.efm.v2022_1.services.schema.common.FirmType.class,
            tyler.efm.v2022_1.services.schema.common.LocationNode.class,
            tyler.efm.v2022_1.services.schema.common.NotificationType.class,
            tyler.efm.v2022_1.services.schema.common.PaymentAccountLocation.class,
            tyler.efm.v2022_1.services.schema.common.PaymentAccountLocationDetails.class,
            tyler.efm.v2022_1.services.schema.common.PaymentAccountType.class,
            tyler.efm.v2022_1.services.schema.common.PaymentAccountTypeType.class,
            tyler.efm.v2022_1.services.schema.paymentaccounttypelistresponse
                .PaymentAccountTypeListResponseType.class,
            tyler.efm.v2022_1.services.schema.common.RegistrationType.class,
            tyler.efm.v2022_1.services.schema.common.RoleLocationType.class,
            tyler.efm.v2022_1.services.schema.common.RoleType.class,
            tyler.efm.v2022_1.services.schema.common.ServiceContactType.class,
            tyler.efm.v2022_1.services.schema.common.UserType.class);
    for (var clazz : classesToRegister) {
      utils.register(converter, clazz);
    }
  }

  /** Copies all of the content from the src object to the dest, returning it fluently. */
  @SuppressWarnings(value = {"unchecked"})
  public static <T> T convert(Class<T> destClass, Object src) {
    return (T) copyProperties(destClass, src);
  }

  private static Object copyProperties(Class<?> destClass, Object src) {
    // TODO(brycew): check to make sure the objects have the same common name?
    return converter.convert(destClass, src);
  }

  private static class CustomBeanConverter implements Converter {

    @Override
    @SuppressWarnings("unchecked")
    public <T> T convert(Class<T> aClass, Object o) {
      try {
        if (aClass.isEnum()) {
          String value = (String) o.getClass().getDeclaredMethod("value").invoke(o);
          T output = (T) aClass.getMethod("fromValue", String.class).invoke(null, value);
          return output;
        } else if (aClass
            .getName()
            .equals(
                tyler.efm.latest.services.schema.paymentaccounttypelistresponse
                    .PaymentAccountTypeListResponseType.class
                    .getName())) {
          // TODO(brycew): this is a hack to fix BeanUtils not working with lists.
          var pat =
              new tyler.efm.latest.services.schema.paymentaccounttypelistresponse
                  .PaymentAccountTypeListResponseType();
          BeanUtils.copyProperties(pat, o);
          if (o
              instanceof
              tyler.efm.v2022_1.services.schema.paymentaccounttypelistresponse
                      .PaymentAccountTypeListResponseType
                  oldObj) {
            for (int i = 0; i < oldObj.getPaymentAccountType().size(); i++) {
              pat.getPaymentAccountType()
                  .add(
                      convert(
                          tyler.efm.latest.services.schema.common.PaymentAccountTypeType.class,
                          oldObj.getPaymentAccountType().get(i)));
            }
          }
          return (T) pat;
        } else {
          T output = aClass.getDeclaredConstructor().newInstance();
          BeanUtils.copyProperties(output, o);
          return output;
        }
      } catch (IllegalAccessException
          | InvocationTargetException
          | NoSuchMethodException
          | InstantiationException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
