package project.applyLeaveWebapp.dto;

public class ResponseDTO {
	
	private String status ;
	private Object response ;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "ResponseDTO [status=" + status + ", response=" + response + "]";
	}
	
	

}