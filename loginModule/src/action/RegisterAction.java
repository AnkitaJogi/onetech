package action;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.sun.net.httpserver.HttpServer;

import bean.User;
import dao.DAOFactory;

@WebServlet("/RegisterAction")
public class RegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
		String email ;
		String password;
		String phone_no;
		
		email = request.getParameter("email");
		password = request.getParameter("password");
		phone_no = request.getParameter("phone_no");
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone_no(phone_no);
		
		DAOFactory dao = DAOFactory.getDao();
		boolean f=dao.registration(user);
		if(f) {
			RequestDispatcher rs = request.getRequestDispatcher("/Welcome");
			rs.forward(request, response);
		}else {
			RequestDispatcher rs = request.getRequestDispatcher("RegisterAction");
			rs.forward(request, response);
		}
	}

}
