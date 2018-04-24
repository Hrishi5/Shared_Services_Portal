package project.applyLeaveWebapp.dto;

public class ApplyLeaveDetailsDTO {

	int employeeId;
	int leaveID;
	String fromDate;
	String toDate;
	String reason;
	String type ;
	String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getLeaveID() {
		return leaveID;
	}
	public void setLeaveID(int leaveID) {
		this.leaveID = leaveID;
	}
	public String getFromDate() {
		return fromDate;
	}
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	public String getToDate() {
		return toDate;
	}
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setType(String type) {
		this.type = type ;
	}
	
	public String getType() {
		return this.type ;
	}
	}
	
	
	// to be considered
	// int duration;
	// Document (BitMap/Image or another DataStructure)

