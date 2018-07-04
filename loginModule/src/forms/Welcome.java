package forms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/Welcome")
public class Welcome extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head><title>Login form</title></head>");
		pw.print("<body><h1> Successfully Done</h1></body>");
		pw.print("</html>");
	}

}
