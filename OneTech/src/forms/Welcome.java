package forms;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter pw = response.getWriter();
	/*	pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head><title>Login form</title></head>");
	*/	pw.print("<body><h1> Successfully Done</h1></body>");
	//	pw.print("</html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response); 
		
	/*  PrintWriter pw = response.getWriter();
	  pw.println("<!DOCTYPE html><html><head><title>Login page</title></head><body> <h> Scuccessfully match </h1></body></html>");
	
	  pw.println("<!DOCTYPE html>");*/
	  
		
	  
	  
	}

}