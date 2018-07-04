<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%! int a = 0; %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="backgroud-color:blue">
  <form action="RegisterAction" method="post">
   
      <label>Email id</label>
      <span><input type="text" name="email"></span>
      <br><br>
      <label>Password</label>
      <span><input type="text" name="password"></span>
      <br><br>
      <label>Phone no</label>
      <span><input type="number" name="phone_no"></span>
      <br><br>
      <input type="submit" value="Submit">
      <input type="reset" value="Reset">
      
  </form>
</body>
</html>