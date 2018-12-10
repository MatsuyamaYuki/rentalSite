package jp.ken.rentalSite.model;

import java.io.Serializable;

public class StockModel implements Serializable {
	
	private String stockName;
	private int stockCount;
	private String newOrOld;
	private String stockType;
	private String artist;
	private String manager;
	private String registration;
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getStockCount() {
		return stockCount;
	}
	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}
	public String getNewOrOld() {
		return newOrOld;
	}
	public void setNewOrOld(String newOrOld) {
		this.newOrOld = newOrOld;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}

}
