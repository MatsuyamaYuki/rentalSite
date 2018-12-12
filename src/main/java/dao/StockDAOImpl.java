package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jp.ken.rentalSite.entity.Stock;

public class StockDAOImpl implements StockDAO<Stock> {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Stock> allList(){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM Stock");
		List<Stock> stoList=query.list();
		session.close();
		return stoList;
	}

}
