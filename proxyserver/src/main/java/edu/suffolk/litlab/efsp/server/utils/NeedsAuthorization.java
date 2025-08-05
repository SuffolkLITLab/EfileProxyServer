package edu.suffolk.litlab.efsp.server.utils;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import jakarta.ws.rs.NameBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Put this annotation on endpoints that require a server API Key. */
@Target({TYPE, METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
@NameBinding
public @interface NeedsAuthorization {
  AuthType[] permissions() default {};

  public enum AuthType {
    USER_PORT,
    USER_PORT_NO_HEADER,
    FIRM_PORT,
    REVIEW_MDE,
    SERVICE_MDE,
    CASE_MDE,
    SCHEDULE_MDE;
  }
}
