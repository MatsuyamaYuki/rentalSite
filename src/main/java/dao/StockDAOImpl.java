package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
	@Override
	public Stock getById(int id) {
		Session session=this.sessionFactory.openSession();
		Query query=session.createQuery("FROM Stock WHERE stock_id=?");
		query.setParameter(0, id);
		Stock sto=(Stock)query.uniqueResult();
		session.close();
		return sto;
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Stock> getByName(String name){
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM Stock WHERE stock_name LIKE ?");
		query.setParameter(0, "%"+name+"%");
		List<Stock>list=query.list();
		session.close();
		return list;
	}
	@Override
	public boolean insertStockData(Stock stock) {
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		try {
			session.saveOrUpdate(stock);
			tx.commit();
			return true;
		}catch (HibernateException e) {
			tx.rollback();
			return false;
		}finally {
			session.close();
		}
	}
		@Override
		public int updateStockData(Stock stock) {
			Session session=this.sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			try {
				session.saveOrUpdate(stock);
				tx.commit();
				return 1;
			}catch (HibernateException e) {
				tx.rollback();
				return 0;
			}finally {
				session.close();
			}
		}
		@Override
		public int deleteStockData(int id) {
			Session session=this.sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			try {
				Query query=session.createQuery("FROM Stock WHERE stock_id=?");
				query.setParameter(0, id);
				Stock sto=(Stock)query.uniqueResult();
				session.delete(sto);
				tx.commit();
				return 1;
			}catch(HibernateException e) {
				e.printStackTrace();
				tx.rollback();
				return 0;
			}finally {
				session.close();
			}
		}
	}

