package dao;

import java.util.ArrayList;

import bean.User;

public abstract class DAOFactory {

		public static DAOFactory getDao() {
		
			DAOFactory dao = new SqlDAO();
			
			return dao;	
		}
		
		public abstract ArrayList<User> getData();
		public abstract void insertDetail(String name , int roll);
		public abstract boolean checkLogin(User user);
		public abstract boolean registration(User user);
		public abstract void deleteData();
	}


