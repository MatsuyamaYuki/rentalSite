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
			String userAddress, int userTel, String userName,String cardNumber, String userBirthday, String cardName, int cardMonth,
			int cardYear, int gender) {

		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery(""
				+ "INSERT INTO rentsite_database.userinformation(userMail,userPassword,plan,zip,"
				+ "userAddress,userTel,userName,userBirthday,cardName,cardNumber,cardMonth,cardYear,gender) "
				+ "VALUE('?','?',?,?,'?',?,'?','?','?','?',?,?,?)");

				query.setParameter(0 ,userMail);
				query.setParameter(1 ,userPassword);
				query.setParameter(2 ,plan);
				query.setParameter(3 ,zip);
				query.setParameter(4 ,userAddress);
				query.setParameter(5 ,userTel);
				query.setParameter(6 ,userName);
				query.setParameter(7 ,userBirthday);
				query.setParameter(8 ,cardName);
				query.setParameter(9 ,cardNumber);
				query.setParameter(10 ,cardMonth);
				query.setParameter(11 ,cardYear);
				query.setParameter(12 ,gender );

	}

}
