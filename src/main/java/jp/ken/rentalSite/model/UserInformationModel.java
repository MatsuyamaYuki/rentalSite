package jp.ken.rentalSite.model;

import java.io.Serializable;

public class UserInformationModel implements Serializable {

	private String userPassword;
	private String plan;
	private String zip;
	private String userAddress;
	private String userTel;
	private String userName;
	private String userBirthday;
	private String cardNumber;
	private String gender;

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
