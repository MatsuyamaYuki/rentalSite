package jp.ken.rentalsite.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("deprecation")
public class UserInformationModel implements Serializable {

	@NotEmpty(groups=ErrorCheckGroup1.class, message="メールアドレスを入力してください")
	@Email(groups=ErrorCheckGroup1.class,message="メールアドレスではありません")
	private String userMail;
	@NotEmpty(groups=ErrorCheckGroup1.class, message="パスワードを入力してください")
	@Pattern(regexp="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}$", message="パスワードは8文字以上で数字と英字を含める必要があります")
	private String userPassword;
	private String plan;
	@NotEmpty(groups=ErrorCheckGroup1.class, message="郵便番号を入力してください")
	@Pattern(regexp="^\\d{7}",message="正しい郵便番号を入力してください")
	private String zip;
	private String userAddress;
	@NotEmpty(message="電話番号を入力してください")
	@Pattern(regexp="^\\d{9,11}$",message="正しい電話番号を入力してください")
	private String userTel;
	@NotEmpty
	private String userName;
	private String userBirthday;
	private String year;
	private String month;
	private String day;
	private String cardName;
	private String cardNumber;
	private String cardMonth;
	private String cardYear;
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
	public String getYear() {
		return year;
	}
	public String getMonth() {
		return month;
	}
	public String getDay() {
		return day;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardName() {
		return cardName;
	}
	public String getCardMonth() {
		return cardMonth;
	}
	public String getCardYear() {
		return cardYear;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public void setCardMonth(String cardMonth) {
		this.cardMonth = cardMonth;
	}
	public void setCardYear(String cardYear) {
		this.cardYear = cardYear;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}
