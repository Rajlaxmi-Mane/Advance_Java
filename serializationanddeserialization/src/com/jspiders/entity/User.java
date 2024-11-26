package com.jspiders.entity;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String email;
	private String pass;
	private long mobile;
	public User() {
		super();
	}
	public User(String userName, String email, String pass, long mobile) {
		super();
		this.userName = userName;
		this.email = email;
		this.pass = pass;
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", pass=" + pass + ", mobile=" + mobile + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	

}
