package au.edu.unsw.soacourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import au.edu.unsw.soacourse.model.User;
import au.edu.unsw.soacourse.util.JDBC_Connection;

;

public class UserDao {

	private Connection connection;

	public UserDao() {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
	}

	public User getUser(String username) {
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from LOCALJOBSEEKER where EMAIL=?");
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setUserID(rs.getString("USERID"));
				user.setName(rs.getString("NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean isUserExist(String username, String password) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from LOCALJOBSEEKER where EMAIL='"
							+ username + "' and PASSWORD='" + password + "'");
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isUserExistAndVerified(String username) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection
					.prepareStatement("select * from LOCALJOBSEEKER where EMAIL='"
							+ username + "' and VERIFICATION='Yes'");
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isEmailExist(String email) {
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection
					.prepareStatement("select * from LOCALJOBSEEKER where EMAIL='"
							+ email + "'");
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TOD0 Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	 public void addUser (User user) {
		 try {
			 PreparedStatement preparedStatement = connection
					 .prepareStatement("insert into LOCALJOBSEEKER" 
							 	+ "(USERID, EMAIL, PASSWORD, NAME, VERIFICATION) values (?, ?, ?, ?, ?)");
			 preparedStatement.setString(1, user.getUserID()); 
			 preparedStatement.setString (2, user.getEmail ()); 
			 preparedStatement.setString(3, user.getPassword()); 
			 preparedStatement.setString (4, user.getName()); 
			 preparedStatement.setString(5, user. getVerified()); 
			 preparedStatement.executeUpdate();
		 } catch (SQLException e) { 
			 e.printStackTrace();
		 }
	 }
}
