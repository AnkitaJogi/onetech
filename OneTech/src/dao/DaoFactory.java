package dao;

import java.util.ArrayList;

import bean.User;

public abstract class DaoFactory {

	public static DaoFactory getDao() {
		
		DaoFactory dao = new SqlDao();
		
		return dao;
	}
	
	public abstract User checkLogin(User user); 
	public abstract boolean registration(User user); 
	public abstract User retrieveData();
}
