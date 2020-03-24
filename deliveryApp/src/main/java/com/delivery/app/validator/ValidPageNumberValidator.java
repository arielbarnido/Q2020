package com.delivery.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.ws.rs.ext.Provider;

import com.delivery.app.constraint.ValidPageNumber;

@Provider
public class ValidPageNumberValidator implements ConstraintValidator<ValidPageNumber, Integer>{

	@Override
	public boolean isValid(Integer arg0, ConstraintValidatorContext arg1) {
		System.out.println("VAL:");
		System.out.println(arg0);
		
		return false;
	}

	

}
