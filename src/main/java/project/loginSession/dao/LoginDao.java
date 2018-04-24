package project.loginSession.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
import project.loginSession.util.DBConnection;

import project.loginSession.dto.LoginDTO;
 
public class LoginDao {
 
public String authenticateUser(LoginDTO loginDto)
{
 String userName = loginDto.getUserName();
 String password = loginDto.getPassword();
 
 Connection con = null;
 Statement statement = null;
 ResultSet resultSet = null;
 
 String userNameDB = "";
 String passwordDB = "";
 
 
 try
 {
 con = DBConnection.createConnection();
 statement = con.createStatement();
 resultSet = statement.executeQuery("select email_address ,password from employee");
 
 //Query should be changed to match the database
 
 
 while(resultSet.next())
 {
 userNameDB = resultSet.getString("email_address");
 passwordDB = resultSet.getString("password");
  
 if(userName.equals(userNameDB) && password.equals(passwordDB))
 return "User_Role";
  }
 }
 catch(SQLException e)
 {
 e.printStackTrace();
 }
 return "Invalid user credentials";
}
}