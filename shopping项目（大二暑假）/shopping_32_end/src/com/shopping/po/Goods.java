package com.shopping.po;

import java.util.Date;

public class Goods {
	private int id;
	private String gname;
	private float gdiscount;
	private float marketPrice;
	private float salPrice;
	private String info;
	private String photo;
	private int bargainPrice;
	private Date pdate;
	private int number;
	private Category sort;
	private int salCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	

	public float getGdiscount() {
		return gdiscount;
	}

	public void setGdiscount(float gdiscount) {
		this.gdiscount = gdiscount;
	}

	public float getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}

	public float getSalPrice() {
		return salPrice;
	}

	public void setSalPrice(float salPrice) {
		this.salPrice = salPrice;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getBargainPrice() {
		return bargainPrice;
	}

	public void setBargainPrice(int bargainPrice) {
		this.bargainPrice = bargainPrice;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Category getSort() {
		return sort;
	}

	public void setSort(Category sort) {
		this.sort = sort;
	}

	public int getSalCount() {
		return salCount;
	}

	public void setSalCount(int salCount) {
		this.salCount = salCount;
	}

}
