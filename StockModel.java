package jp.ken.rentalsite.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class StockModel implements Serializable {

    private String stockId;
	@NotEmpty(groups=ErrorCheckGroup1.class,message="名前を省略することはできません")
	private String stock_Name;
	@NotEmpty(groups=ErrorCheckGroup1.class,message="個数を省略することはできません")
	private String stock_Count;
	private String new_or_old;
	private String type_id;
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
	public String getStock_Name() {
		return stock_Name;
	}
	public void setStock_Name(String stock_Name) {
		this.stock_Name = stock_Name;
	}
	public String getStock_Count() {
		return stock_Count;
	}
	public void setStock_Count(String stock_Count) {
		this.stock_Count = stock_Count;
	}
	public String getNew_or_old() {
		return new_or_old;
	}
	public void setNew_or_old(String new_or_old) {
		this.new_or_old = new_or_old;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
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