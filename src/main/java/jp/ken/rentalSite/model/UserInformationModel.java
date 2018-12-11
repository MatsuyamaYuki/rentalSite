package jp.ken.rentalSite.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import jp.ken.rentalSite.annotation.TelCheck;
import jp.ken.rentalSite.annotation.ZipCheck;

@SuppressWarnings("deprecation")
public class UserInformationModel implements Serializable {

	@NotEmpty(groups=ErrorCheckGroup1.class, message="メールアドレスを入力してください")
	@Email(groups=ErrorCheckGroup1.class,message="メールアドレスではありません")
	private String userMail;
	@NotEmpty(groups=ErrorCheckGroup1.class, message="パスワードを入力してください")
	private String userPassword;
	private String plan;
	@NotEmpty(groups=ErrorCheckGroup1.class, message="郵便番号を入力してください")
	@ZipCheck(message="正しい郵便番号を入力してください")
	private String zip;
	private String userAddress;
	@TelCheck(message="正しい電話番号を入力してください")
	private String userTel;
	private String userName;
	private String userBirthday;
	private String cardNumber;
	private String gender;

	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
