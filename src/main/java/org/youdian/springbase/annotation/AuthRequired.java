package org.youdian.springbase.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用户注解handlermethod，被注解的方法需要用户身份信息
 * @author zhouzhou
 *
 */
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
