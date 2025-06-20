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
import tyler.efm.latest.services.schema.common.RegistrationType;
import tyler.efm.latest.services.schema.common.RoleLocationType;
import tyler.efm.latest.services.schema.common.ServiceContactType;
import tyler.efm.latest.services.schema.common.UserType;

public class Conversion {

  static {
    var converter = new CustomBeanConverter();
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
            RegistrationType.class,
            RoleLocationType.class,
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
            tyler.efm.v2022_1.services.schema.common.RegistrationType.class,
            tyler.efm.v2022_1.services.schema.common.RoleLocationType.class,
            tyler.efm.v2022_1.services.schema.common.ServiceContactType.class,
            tyler.efm.v2022_1.services.schema.common.UserType.class);
    for (var clazz : classesToRegister) {
      utils.register(converter, clazz);
    }
  }

  /** Copies all of the content from the src object to the dest, returning it fluently. */
  public static <T> T convert(T dest, Object src) {
    copyProperties(dest, src);
    return dest;
  }

  private static void copyProperties(Object dest, Object src) {
    // TODO(brycew): check to make sure the objects have the same common name?
    try {
      BeanUtils.copyProperties(dest, src);
    } catch (IllegalAccessException | InvocationTargetException ex) {
      // TODO(brycew): log here?
      throw new RuntimeException(ex);
    }
  }

  private static class CustomBeanConverter implements Converter {

    @Override
    public <T> T convert(Class<T> aClass, Object o) {
      try {
        T output = aClass.getDeclaredConstructor().newInstance();
        BeanUtils.copyProperties(output, o);
        return output;
      } catch (IllegalAccessException
          | InvocationTargetException
          | NoSuchMethodException
          | InstantiationException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
