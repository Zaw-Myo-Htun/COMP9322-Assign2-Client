package au.edu.unsw.soacourse.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Connection {
	public Connection con;
	
	public Connection getConnection(){
		try{
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\AlphaOne-Admin\\cs9322-Prac\\$9322_PRAC$\\MySQLiteDB");
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
