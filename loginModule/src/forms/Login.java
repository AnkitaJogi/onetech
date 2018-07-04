package forms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Login")
public class Login extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		PrintWriter pw = response.getWriter();
		
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head><title>Login form</title></head>");
		pw.print("<body>"
				+ "<form action='LoginAction' method='get'>"
				+ "First name:"
				+ "<input type='text' name='name' ><br>"
				+"<br>Password"
				+"<input type='number' name='roll'><br>"
				+"<input type ='submit' value='update'>"
				+ "</form>"
				+ "</body>");
		pw.print("</html>");

		
		
	}

}
