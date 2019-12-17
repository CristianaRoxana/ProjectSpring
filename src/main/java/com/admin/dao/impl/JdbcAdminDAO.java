package com.admin.dao.impl;

import com.admin.dao.AdminDAO;
import com.admin.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class JdbcAdminDAO implements AdminDAO{
private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
public void insert(Admin admin){
		
		String sql = "INSERT INTO Admin " +
				"(AdminId, email, password) VALUES (?, ?, ?)";
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, admin.getAdmId());
			ps.setString(2, admin.getEmail());
			ps.setString(3, admin.getPassword());
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
			
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
public void delete(Admin admin){
	
	String sql = "DELETE FROM Admin WHERE  email= ? " ;
			
	Connection conn = null;
	
	try {
		conn = dataSource.getConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, admin.getEmail());
		ps.executeUpdate();
		ps.close();
		
	} catch (SQLException e) {
		throw new RuntimeException(e);
		
	} finally {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
	}
}
	public Admin findByAdminId(int adminId){
		
		String sql = "SELECT * FROM Admin WHERE AdminId = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, adminId);
			Admin admin = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Admin(
					rs.getInt("AdminId"),
					rs.getString("email"), 
					rs.getString("password")
				);
			}
			rs.close();
			ps.close();
			return admin;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}
public Admin getAdmin(String email, String password){
		
		String sql = "SELECT * FROM Admin WHERE email = ? and password = ?";
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			Admin  admin = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin = new  Admin (
					rs.getInt("AdminId"),
					rs.getString("email"), 
					rs.getString("password")
				);
			}
			rs.close();
			ps.close();
			return admin;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}

