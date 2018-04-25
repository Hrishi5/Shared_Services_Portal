package project.loginSession.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import project.loginSession.dto.LoginDTO;
import project.loginSession.dao.*; 
 
public class LoginServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
 
public LoginServlet() {
}
 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
 String emailId = request.getParameter("emailId");
 String password = request.getParameter("password");
 
 
 System.out.println("Inside LoginServlet");
  
 LoginDTO loginDto = new LoginDTO();
 Statement statement = null;
 ResultSet resultSet = null;
 Connection con = null;
 //loginDto.setUserName(emailId);
 loginDto.setPassword(password);
 loginDto.setEmailId(emailId);
 String emailIdDB = "";
 String passwordDB = "";
 
try {
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sharedservice", "root", "root");
	 
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
// LoginDao loginDao = new LoginDao();
 String userValidate = "";
 try
 {
 
	 try {
 statement = con.createStatement();
 resultSet = statement.executeQuery("select email_address ,password from employee");
 
 while(resultSet.next())
 {
	 System.out.println("Insdide while loop");
 emailIdDB = resultSet.getString("email_address");
 passwordDB = resultSet.getString("password");
  
 	System.out.println("emailDB "+ emailIdDB);
 	System.out.println("emailId "+emailId);
 	
 	
 	System.out.println("password "+ passwordDB);
 	System.out.println("password "+password);
 if(emailId.equals(emailIdDB) && password.equals(passwordDB))
 userValidate ="User_Role";
 
  }
 
 }
 
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 

 if(userValidate.equals("User_Role"))
 {
	 System.out.println("Employee's Home");
	 
	 HttpSession session = request.getSession(); //Creating a session
	 session.setAttribute("Employee", emailId); //setting session attribute
	 request.setAttribute("emailId", emailId);
	 
	 //request.getRequestDispatcher("/Shared_Serivces_Portal/leave.html").forward(request, response);
	 response.sendRedirect("/Shared_Services_Portal/leave.html");
	 
	 //change it to the page to be sent again
	 
	 }
 else
 {
	 System.out.println("Error message = "+userValidate);
	 request.setAttribute("errMessage", userValidate);
	 
	 //request.getRequestDispatcher("/Shared_Services_Portal/LoginSession.jsp").forward(request, response);
	 response.sendRedirect("/Shared_services_Portal/LoginSession.jsp");
	 
	 //change it to the page to be sent after logout
	 }
 }
 catch (IOException e1)
 {
 e1.printStackTrace();
 }
 catch (Exception e2)
 {
 e2.printStackTrace();
 }
} //End of doPost()
}