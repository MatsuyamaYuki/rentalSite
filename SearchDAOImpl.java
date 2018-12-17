package jp.ken.search.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jp.ken.search.entity.Stock;
public class SearchDAOImpl implements SearchDAO<Stock>{
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}



	@Override
	@SuppressWarnings("unchecked")
	public List<Stock> searchList(String name,String type){
		Session session=this.sessionFactory.openSession();
		Query query=session.createQuery("FROM Stock   WHERE  (name   LIKE  ?  OR  Artist  LIKE ? ) AND  (type = ?)");
		query.setParameter(0, "%"+name+"%");
		query.setParameter(1, "%"+name+"%");
		query.setParameter(2, Integer.parseInt(type));
		List<Stock> searchList=query.list();
		session.close();
		return searchList;
	}
}
