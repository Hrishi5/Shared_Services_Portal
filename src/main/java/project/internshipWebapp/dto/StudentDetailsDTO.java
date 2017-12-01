package project.internshipWebapp.dto;

public class StudentDetailsDTO {

	private String studentID;
	private String lastName;
	private String firstName;
	private String stuAddress;
	private String stuCell;
	private String stuEmail;
	private String major;
	private String minor;
	private String gradYear;
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getStuAddress() {
		return stuAddress;
	}
	public void setStuAddress(String stuAddress) {
		this.stuAddress = stuAddress;
	}
	public String getStuCell() {
		return stuCell;
	}
	public void setStuCell(String stuCell) {
		this.stuCell = stuCell;
	}
	public String getStuEmail() {
		return stuEmail;
	}
	public void setStuEmail(String stuEmail) {
		this.stuEmail = stuEmail;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMinor() {
		return minor;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
	public String getGradYear() {
		return gradYear;
	}
	public void setGradYear(String gradYear) {
		this.gradYear = gradYear;
	}
	@Override
	public String toString() {
		return "StudentDetailsDTO [studentID=" + studentID + ", lastName=" + lastName + ", firstName=" + firstName
				+ ", stuAddress=" + stuAddress + ", stuCell=" + stuCell + ", stuEmail=" + stuEmail + ", major=" + major
				+ ", minor=" + minor + ", gradYear=" + gradYear + "]";
	}
	
	
}
