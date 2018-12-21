package jp.ken.musiclifeagency.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userinformation")
public class UserInformation {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String userMail;
	private String userPassword;
	private int plan;
	private int zip;
	private String userAddress;
	private int userTel;
	private String userName;
	private String userBirthday;
	private String cardNumber;
	private int cardMonth;
	private int cardYear;
	private int gender;

	public int getId() {
		return id;
	}
	public String getUserMail() {
		return userMail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public int getPlan() {
		return plan;
	}
	public int getZip() {
		return zip;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public int getUserTel() {
		return userTel;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public int getCardMonth() {
		return cardMonth;
	}
	public int getCardYear() {
		return cardYear;
	}
	public int getGender() {
		return gender;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setPlan(int plan) {
		this.plan = plan;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public void setUserTel(int userTel) {
		this.userTel = userTel;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setCardMonth(int cardMonth) {
		this.cardMonth = cardMonth;
	}
	public void setCardYear(int cardYear) {
		this.cardYear = cardYear;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}


}