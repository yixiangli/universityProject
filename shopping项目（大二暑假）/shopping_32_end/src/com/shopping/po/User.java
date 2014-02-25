package com.shopping.po;

import java.util.Date;

public class User {

	private int id;              //����
	private String username; 
	private String password;
	private String email;
	private String realname;     //��ʵ����
	private String address;      //��ַ
	private String area;         //����
	private String postcode;     //����
	private String tel;          //�绰
	private int type;	         //��Ա�ȼ�
	private Date pdate;	         //ע��ʱ��
	private int state;           //�˺�״̬
	private float spend;         //���ѽ��
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getPdate() {
		return pdate;
	}
	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public float getSpend() {
		return spend;
	}
	public void setSpend(float spend) {
		this.spend = spend;
	}
	
}
