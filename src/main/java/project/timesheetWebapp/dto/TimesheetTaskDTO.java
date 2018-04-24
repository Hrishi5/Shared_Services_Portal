package project.timesheetWebapp.dto;

public class TimesheetTaskDTO {
private String name ;
private String details ;
private float hours ;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public float getHours() {
	return hours;
}
public void setHours(float hours) {
	this.hours = hours;
}
@Override
public String toString() {
	return "TimesheetTaskDTO [name=" + name + ", details=" + details + ", hours=" + hours + "]";
}




}
