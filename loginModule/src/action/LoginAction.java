package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.DAOFactory;

@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String email;
		String password;
		email=request.getParameter("email");
		password=request.getParameter("password");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		
		DAOFactory dao = DAOFactory.getDao();
		boolean b = dao.checkLogin(user);

		if(b) {
			HttpSession session  = request.getSession(true);
			session.setAttribute("user_info","Aman Thory ");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);
		}
		else {
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
		}

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}


