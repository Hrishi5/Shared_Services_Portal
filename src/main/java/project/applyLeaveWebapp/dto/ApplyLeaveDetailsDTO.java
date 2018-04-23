package project.applyLeaveWebapp.dto;

public class ApplyLeaveDetailsDTO {

	int employeeId;
	int leaveID;
	String fromDate;
	String toDate;
	String reason;
	String leaveType;
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
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	@Override
	public String toString() {
		return "ApplyLeaveDetailsDTO [employeeId=" + employeeId + ", leaveID=" + leaveID + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", reason=" + reason + ", status=" + status + ", leaveType=" + leaveType + "]";
	}
	
	}
	
	
	// to be considered
	// int duration;
	// Document (BitMap/Image or another DataStructure)

