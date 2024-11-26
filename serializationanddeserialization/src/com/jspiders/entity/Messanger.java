package com.jspiders.entity;

import java.io.Serializable;

public class Messanger implements Serializable{

	private static final long serialVersionUID = 1L;
	private String msg;
	

	public Messanger(String msg) {
		super();
		this.msg = msg;
	}



	@Override
	public String toString() {
		return "Messanger [msg=" + msg + "]";
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	

}
