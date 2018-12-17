package jp.ken.search.entity;
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
 @GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 private String name;
 private int stock_count;
 private String new_or_old;
 private int type;
 private String artist;

 @OneToOne
 @JoinColumn(name="id",insertable=false,updatable=false)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getStock_count() {
	return stock_count;
}
public void setStock_count(int stock_count) {
	this.stock_count = stock_count;
}
public String getNew_or_old() {
	return new_or_old;
}
public void setNew_or_old(String new_or_old) {
	this.new_or_old = new_or_old;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public String getArtist() {
	return artist;
}
public void setArtist(String artist) {
	this.artist = artist;
}



}
