package com.delivery.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.delivery.app.constraint.ValidPageNumber;

public class ValidPageNumberValidator implements ConstraintValidator<ValidPageNumber, Integer>{

	@Override
	public boolean isValid(Integer page, ConstraintValidatorContext arg1) {
		return page > 0;
	}

	

}
