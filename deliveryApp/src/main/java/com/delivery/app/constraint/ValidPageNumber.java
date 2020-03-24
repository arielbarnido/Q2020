package com.delivery.app.constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.delivery.app.validator.ValidPageNumberValidator;

@Target({ElementType.ANNOTATION_TYPE, ElementType.PARAMETER, ElementType.METHOD, ElementType.TYPE, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPageNumberValidator.class)
@Documented
public @interface ValidPageNumber {
	String message  () default "Page number must be atleast 1";
	
	Class<?> [] groups () default{};
	
	Class<? extends Payload>[] payload () default{};
}
