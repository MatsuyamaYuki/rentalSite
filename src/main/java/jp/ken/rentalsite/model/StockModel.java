package jp.ken.rentalsite.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class StockModel implements Serializable {

    private String stockId;
	@NotEmpty(groups=ErrorCheckGroup1.class,message="名前を省略することはできません")
	private String stockName;
	@NotEmpty(groups=ErrorCheckGroup1.class,message="個数を省略することはできません")
	private String stockCount;
	private String newOrOld;
	private String stockType;
	@NotEmpty(groups=ErrorCheckGroup1.class,message="アーティスト名を省略することはできません")
	private String artist;
	@NotEmpty(groups=ErrorCheckGroup1.class,message="監督名を省略することはできません")
	private String manager;
	private String registration;


	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockCount() {
		return stockCount;
	}
	public void setStockCount(String stockCount) {
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
