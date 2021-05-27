package com.example.demo.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.demo.models.User;
import com.example.demo.models.Vendor;

@Component
public class VendorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Vendor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Vendor vendor = (Vendor) target;
		
		if(!vendor.getConfirmPassword().equals(vendor.getPassword())) {
			//first string has to be same name as variable
			errors.rejectValue("confirmPassword","Match","Passwords do not match!");
		}
	}

}
