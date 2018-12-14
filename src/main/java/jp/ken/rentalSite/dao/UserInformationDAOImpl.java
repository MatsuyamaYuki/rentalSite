package jp.ken.rentalSite.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jp.ken.rentalSite.entity.UserInformation;

public class UserInformationDAOImpl implements UserInformationDAO<UserInformation> {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insertUserInformation(int id, String userMail, String userPassword, int plan, int zip,
			String userAddress, int userTel, String userName, String userBirthday, String cardName, int cardMonth,
			int cardYear, int gender) {

		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("INSERT ");

	}

}
