package com.admin.dao;

import com.admin.model.Admin;

public interface AdminDAO {
	public void insert(Admin admin);
	public void delete(Admin admin);
	public Admin findByAdminId(int adminId);
	public Admin getAdmin(String email, String password);	

}
