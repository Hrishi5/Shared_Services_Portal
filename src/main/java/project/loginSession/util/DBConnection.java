package project.loginSession.util;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class DBConnection {
 
public static Connection createConnection()
{
Connection con = null;
String url = "jdbc:mysql://127.0.0.1:3306/sharedservice";
String username = "root";
String password = "root";
 
try
{
try
{
Class.forName("com.mysql.jdbc.Driver");
}
catch (ClassNotFoundException e)
{
e.printStackTrace();
}
con = DriverManager.getConnection(url, username, password);
System.out.println("Post establishing a DB connection - "+con.toString());
}
catch (Exception e)
{
e.printStackTrace();
}
 
return con;
}
}