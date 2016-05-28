package au.edu.unsw.soacourse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import au.edu.unsw.soacourse.model.SavedJobRequestDTO;
import au.edu.unsw.soacourse.model.User;
import au.edu.unsw.soacourse.util.JDBC_Connection;

;

public class UserDao {

	private Connection connection;

	public User getUser(String username) {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
		User user = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from LOCALJOBSEEKER where EMAIL=?");
			preparedStatement.setString(1, username);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user.setUserID(rs.getString("USERID"));
				user.setName(rs.getString("NAME"));
				user.setEmail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
		return user;
	}

	public boolean isUserExist(String username, String password) {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from LOCALJOBSEEKER where EMAIL='"
							+ username + "' and PASSWORD='" + password + "'");
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
		return false;
	}

	public boolean isUserExistAndVerified(String username) {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection
					.prepareStatement("select * from LOCALJOBSEEKER where EMAIL='"
							+ username + "' and VERIFICATION='Yes'");
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
		return false;
	}

	public boolean isEmailExist(String email) {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
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
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
		return false;
	}

	public void addUser(User user) {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into LOCALJOBSEEKER"
							+ "(USERID, EMAIL, PASSWORD, NAME, VERIFICATION) values (?, ?, ?, ?, ?)");
			preparedStatement.setString(1, user.getUserID());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getName());
			preparedStatement.setString(5, user.getVerified());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean isSavedJobExist(String jobID, String userID) {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
		String sqlString2 = "Select * from LOCALSAVEDJOBS where USERID=? and JOB_ID=?";
		PreparedStatement pd2;
		try {
			
			pd2 = connection.prepareStatement(sqlString2);
			pd2.setString(1, userID);
			pd2.setString(2, jobID);
			ResultSet rs = pd2.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
		return false;
	}

	// Add Saved Jobs
	public void addSavedJobs(SavedJobRequestDTO savedjob) {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into LOCALSAVEDJOBS"
							+ "(USERID, JOB_ID, JOB_NAME) values (?, ?, ?)");
			preparedStatement.setString(1, savedjob.getUserID());
			preparedStatement.setString(2, savedjob.getJobID());
			preparedStatement.setString(3,savedjob.getJobName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
	}
	
	public ArrayList<ArrayList> getAllSavedJobsByUserID(String userID){
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
		ArrayList<ArrayList> allSavedJobs = new ArrayList<ArrayList>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from LOCALSAVEDJOBS where USERID=?");
			preparedStatement.setString(1, userID);
			ResultSet rs = preparedStatement.executeQuery();
			ArrayList temp;
			while (rs.next()) {
				temp=new ArrayList<String>();
				temp.add(rs.getString("JOB_ID"));
				temp.add(rs.getString("JOB_NAME"));
				allSavedJobs.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
		return allSavedJobs;
	}
	public void deleteSavedJob(SavedJobRequestDTO savedjob) {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from LOCALSAVEDJOBS"
							+ " where USERID=? and JOB_ID=?");
			preparedStatement.setString(1, savedjob.getUserID());
			preparedStatement.setString(2, savedjob.getJobID());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
	}
	public boolean isManagerEmailExist(String email) {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection
					.prepareStatement("select * from LOCALMANAGER where EMAIL='"
							+ email + "'");
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TOD0 Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
		return false;
	}
	public boolean isManagerExist(String username, String password) {
		JDBC_Connection conn = new JDBC_Connection();
		connection = conn.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from LOCALMANAGER where EMAIL='"
							+ username + "' and PASSWORD='" + password + "'");
			ResultSet rs = preparedStatement.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(Exception e){
				
			}
		}
		return false;
	}
}
