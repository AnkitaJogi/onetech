package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean.User;

public class SqlDao extends DaoFactory {

	@Override
	public User checkLogin(User user) {
	    User usr=null;
		Connection con;
		Statement st;
		ResultSet rs;
		String query;
		try {
			
			con = DbConnection.getConnection();
			st  = con.createStatement();
			query ="select * from login_table where email = '"+user.getEmail()+"' and password ='"+user.getPassword()+"' and status='active' ";
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				usr = new User();
				usr.setId(rs.getInt("id"));
				usr.setName(rs.getString("name"));
				
			}
			con.close();
			st.close();
			rs.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return usr;
	}

	@Override
	public boolean registration(User user) {
	
		Connection con;
		Statement st;
		String query;
		String active;
		boolean b = false;
		try {
			
			con = DbConnection.getConnection();
			st  = con.createStatement();
			query ="insert into login_table(email,password,number,name,status,role) values('"+user.getEmail()+"' ,'"+user.getPassword()+"' , '"+user.getNumber()+"', '"+user.getName()+"' , 'active','user') ";
			int i = st.executeUpdate(query);
			
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

	@Override
	public User retrieveData() {
	
		Connection con;
		Statement st;
		ResultSet res;
		String query = null;
		
		try {
		     	con = DbConnection.getConnection();
		     	st = con.createStatement();
		     	query = "select * from login_table";
		 
		     	res = st.executeQuery(query);
		     	
		     	if(res.next()) {
		     		
		     		User user = new User();
		     		user.getName();
		     	}
		     	
		     	
		}catch(Exception e) {
			
		}
		return null;
	}
	
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
