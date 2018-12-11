package jp.ken.rentalSite.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.ken.rentalSite.annotation.TelCheck;

public class TelCheckValidator implements ConstraintValidator<TelCheck,String>{

	@Override
	public void initialize(TelCheck arg0) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext cxt) {
		return isTelNumber(value);
	}

	private boolean isTelNumber(String zipNumber) {
		if(zipNumber.matches("^0\\d{9,10}$")) {
			return true;
		}else {
			return false;
		}
	}
}
