package project.loginSession.dto;

public class LoginDTO {

	 private String userName;
	 private String password;
	 private String emailId;
	 
	 public String getEmailId()
	 {
		 return emailId;
	 }
	 
	 public void setEmailId(String emailId)
	 {
		 this.emailId=emailId;
	 }
	 
	 public String getUserName() {
	 return userName;
	 }
	 public void setUserName(String userName) {
	 this.userName = userName;
	 }
	 public String getPassword() {
	 return password;
	 }
	 public void setPassword(String password) {
	 this.password = password;
	 }
	}
