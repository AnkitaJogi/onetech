package action;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class Registration
 */
@WebServlet(description = "RegistrationAction", urlPatterns = { "/RegistrationAction" })
public class RegistrationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
  		String email;
   		String password;
   		String number;
   		String user_name;
   		RequestDispatcher rq;
   	    PrintWriter pw = response.getWriter();
	    
   		
   		email = request.getParameter("email");
   		password = request.getParameter("password");
   		number  = request.getParameter("number");
   		user_name = request.getParameter("user_name");
   	   	
   		
   		if(email.trim().length() == 0 || password.trim().length() == 0 || number.trim().length() == 0 || user_name.trim().length() == 0) {
   			
   			pw.println("<div class=\"alert alert-warning alert-dismissible fade show\" role=\"alert\">\r\n" + 
   	        		"  <strong>Invalid Data Error!</strong> Required field can not be Left blank.\r\n" + 
   	        		"  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n" + 
   	        		"    <span aria-hidden=\"true\">&times;</span>\r\n" + 
   	        		"  </button>\r\n" + 
   	        		"</div>");
	        
   			rq = request.getRequestDispatcher("index.jsp");
   			rq.include(request,response);
   			
   		}
   		
   		User user = new User();
   		
   		user.setEmail(email);
   		user.setPassword(password);
   		user.setNumber(number);
   		user.setName(user_name);
   	   	
   		
   		DaoFactory dao = DaoFactory.getDao();
   		boolean b = dao.registration(user);
   		
   		if(b) {
   			
   		 pw.println("<div class=\"alert alert-success alert-dismissible fade show\" role=\"alert\">\r\n" + 
	        		"  <strong>Well Done </strong> You have successfully registered.\r\n" + 
	        		"  <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n" + 
	        		"    <span aria-hidden=\"true\">&times;</span>\r\n" + 
	        		"  </button>\r\n" + 
	        		"</div>");
   		    
   			rq = request.getRequestDispatcher("index.jsp");
   			rq.include(request, response);
            
   		}
   		else {
   			 rq = request.getRequestDispatcher("index.jsp");
   			 rq.forward(request, response);
   		}
       
  	}

  	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
