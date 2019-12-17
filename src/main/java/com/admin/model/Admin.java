package com.admin.model;

public class Admin {
	int adminId;
	String email;
	String password;
	public Admin(int adminId, String email,String password) {
		this.adminId=adminId;
		this.email=email;
		this.password=password;
	}
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public void setAdminId(int adminId){
		this.adminId = adminId;
		
	}
	
	public int getAdmId() {
		// TODO Auto-generated method stub
		return adminId;
	}
	public void setEmail(String email){
		this.email = email;
		
	}
	
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public void setPassword(String password){
		this.password = password;
		
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String toString() {
		return "Admin [AdminId=" + adminId + ", email=" + email
				+ ", password=" + password + "]";
	}
}
