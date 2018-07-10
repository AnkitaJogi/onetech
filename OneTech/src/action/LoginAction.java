package action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.DaoFactory;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet(description = "LoginAction", urlPatterns = { "/LoginAction" })
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   		String email;
   		String password;
   		RequestDispatcher rq;
   	    PrintWriter pw = response.getWriter();
   		
   		email = request.getParameter("email");
   		password = request.getParameter("password");
   		
   		if(email.trim().length() == 0 || password.trim().length() == 0) {
   	     
   			pw.println("<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">\r\n" + 
   	        		"  <strong>Invalid Data Error!</strong> Required field can not be Left blank.\r\n" + 
   	        		"  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n" + 
   	        		"    <span aria-hidden=\"true\">&times;</span>\r\n" + 
   	        		"  </button>\r\n" + 
   	        		"</div>");
   			rq = request.getRequestDispatcher("index.jsp");
   			rq.include(request, response);
   		}
   		
   		User user = new User();
   		user.setEmail(email);
   		user.setPassword(password);
   		
   		DaoFactory dao = DaoFactory.getDao();
   		User usr = dao.checkLogin(user);
   		
   		if(usr != null){
   			
   			HttpSession session = request.getSession(true);
   			String name = usr.getName();
   				
   			session.setAttribute("user_name", name);
   				    
   			pw.println("<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\r\n"  +
   	        		"  <strong>Successfully Loged In !</strong> \r\n" + 
   	        		"  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n" + 
   	        		"    <span aria-hidden=\"true\">&times;</span>\r\n" + 
   	        		"  </button>\r\n" + 
   	        		"</div>");
   			
   			rq = request.getRequestDispatcher("index.jsp");
   			rq.include(request, response);
            
   		}
   		else {
   			
   			pw.println("<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">\r\n" + 
 	        		"  <strong>Invalid Email Id and Password!</strong> Please enter valid Email Id and Password.\r\n" + 
 	        		"  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n" + 
 	        		"    <span aria-hidden=\"true\">&times;</span>\r\n" + 
 	        		"  </button>\r\n" + 
 	        		"</div>");
   			
   			 rq = request.getRequestDispatcher("index.jsp");
   			 rq.include(request, response);
   			 
   		}
   		
   	}		
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
   		doGet(request, response);
   		
	}

}
