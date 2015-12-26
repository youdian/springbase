package org.youdian.springbase.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface AuthRequired {

	public enum AuthType {
		REQUIRED,
		OPTIONAL
	}
	
	AuthType value() default AuthType.REQUIRED;
}
