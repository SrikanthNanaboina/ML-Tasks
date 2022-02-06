package com.bhavna.textfileprocessor;


public class LoginRecord {
	private String userName;
	private String date;
	private String time;
	
	public LoginRecord(String userName, String date, String time) {
		this.userName = userName;
		this.date = date;
		this.time = time;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "User Name: " + userName + ", Login time: " + time + " " + date ;
	}
	
}
