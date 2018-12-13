package jp.ken.rentalSite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="stock")
public class Stock {

	@Id
	@Column(name="stock_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stock_id;

	private String stock_name;
	private String stock_count;
	private String new_or_old;
	private String stock_type;
	private String artist;
	private String manager;

	@OneToOne
	@JoinColumn(name="",insertable=false,updatable=false)
	private 

	public int getStock_id() {
		return stock_id;
	}
	public void setStock_id(int stock_id) {
		this.stock_id = stock_id;
	}
	public String getStock_name() {
		return stock_name;
	}
	public void setStock_name(String stock_name) {
		this.stock_name = stock_name;
	}
	public String getStock_count() {
		return stock_count;
	}
	public void setStock_count(String stock_count) {
		this.stock_count = stock_count;
	}
	public String getNew_or_old() {
		return new_or_old;
	}
	public void setNew_or_old(String new_or_old) {
		this.new_or_old = new_or_old;
	}
	public String getStock_type() {
		return stock_type;
	}
	public void setStock_type(String stock_type) {
		this.stock_type = stock_type;
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
}
