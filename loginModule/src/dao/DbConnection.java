package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
	//	Connection	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_details", "root", "Ananya@97");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_detail", "root", "123");
		
		}catch(Exception e) {
		
			System.out.println(e);
		
		}

		return con;

	}
	
}
