package com.imooc.domain;

public class User {
	private String username;
	private String password;
	private String phone;
	private String Email;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public User(String username, String password, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.phone = phone;
		Email = email;
	}
	public User(){
		
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", phone=" + phone + ", Email=" + Email + "]";
	}
	

}
