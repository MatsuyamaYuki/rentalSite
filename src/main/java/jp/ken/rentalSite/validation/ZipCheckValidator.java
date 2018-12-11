package jp.ken.rentalSite.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import jp.ken.rentalSite.annotation.ZipCheck;

public class ZipCheckValidator implements ConstraintValidator<ZipCheck,String>{

	@Override
	public void initialize(ZipCheck arg0) {}

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
