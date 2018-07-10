package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;

import java.sql.*;
import bean.User;

public class SqlDAO extends DAOFactory{

	@Override
	public ArrayList<User> getData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override	
		
		public void insertDetail( String name , int roll) {
			
			String query;
			
			try {
				
				Connection con = DbConnection.getConnection();
				Statement st = con.createStatement();
				User user = new User();
				user.setName(name);
				user.setRoll(roll);
				
				query = "insert into new_table(name,roll) values('"+user.getName()+"','"+user.getRoll()+"')";
				int i = st.executeUpdate(query);
				if(i>0)
					System.out.println("success ");
				else
					System.out.println("error");
			}catch(Exception e) {

				e.printStackTrace();
				
			}
			
		}
		
		
	@Override
	public void deleteData() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkLogin(User user) {
		Connection con;
		Statement st;
		String query;
		ResultSet rs;
		boolean b = false;
		try {
			
		    con = DbConnection.getConnection();
		    st = con.createStatement();
			query = "select * from login_table where email='"+user.getEmail()+"' and password='"+user.getPassword()+"' ";
			System.out.println(query);
			rs=st.executeQuery(query);
			
			if(rs.next()) {
				
				b=true;
			}			
			con.close();
			st.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public boolean registration(User user) {
		Connection con;
		Statement st;
		String query;
		ResultSet rs;
		boolean b = false;
		try {
			
		    con = DbConnection.getConnection();
		    st = con.createStatement();
			query = "insert into registration_table(email,password,phone_no) values('"+user.getEmail()+"' ,'"+user.getPassword()+"' ,'"+user.getPhone_no()+"') ";
			System.out.println(query);
			int i =st.executeUpdate(query);
			
			if(i>0) {
				b=true;
			}			
			con.close();
			st.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	
	}
}
