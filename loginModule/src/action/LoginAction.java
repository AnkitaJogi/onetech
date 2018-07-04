package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import bean.User;
import dao.DAOFactory;

@WebServlet("/LoginAction")
public class LoginAction extends GenericServlet {
	private static final long serialVersionUID = 1L;
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		
		String email;
		String password;
		email=request.getParameter("email");
		password=request.getParameter("password");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		DAOFactory dao = DAOFactory.getDao();
		boolean f = dao.checkLogin(user);

		if(f) {
			RequestDispatcher rs = request.getRequestDispatcher("/Welcome");
			rs.forward(request, response);
		}
		else {
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
		}
			
		
	}

}
