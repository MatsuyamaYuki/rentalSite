package jp.ken.rentalSite.dao;

public interface UserInformationDAO<T> {

	public void insertUserInformation(int id,String userMail,String userPassword,int plan,int zip,String userAddress,int userTel,String userName,String userBirthday,String cardName,int cardMonth,int cardYear,int gender);
}