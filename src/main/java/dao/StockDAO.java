package dao;

import java.util.List;

import jp.ken.rentalSite.entity.Stock;

public interface StockDAO<T> {

	public List<T> allList();

	public Stock getById(int id);

	public List<T> getByName(String name);

	public boolean insertStockData(Stock stock);

	public int updateStockData(Stock stock);

	public int deleteStockData(int id);

}
