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
 String roleDB = "";
 
 try
 {
 con = DBConnection.createConnection();
 statement = con.createStatement();
 resultSet = statement.executeQuery("select username,password,role from users");
 
 //Query should be changed to match the database
 
 
 while(resultSet.next())
 {
 userNameDB = resultSet.getString("username");
 passwordDB = resultSet.getString("password");
 roleDB = resultSet.getString("role");
 
 if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Admin"))
 return "Admin_Role";
 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("Editor"))
 return "Editor_Role";
 else if(userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("User"))
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