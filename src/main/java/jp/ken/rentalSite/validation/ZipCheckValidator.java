package jp.ken.rentalSite.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.ken.rentalSite.annotation.TelCheck;

public class ZipCheckValidator implements ConstraintValidator<TelCheck,String>{

	@Override
	public void initialize(TelCheck arg0) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext cxt) {
		return isZipNumber(value);
	}

	private boolean isZipNumber(String zipNumber) {
		if(zipNumber.matches("^[0-9]{7}$")) {
			return true;
		}else {
			return false;
		}
	}
}
