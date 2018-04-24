package project.timesheetWebapp.dto;

import java.util.Date;

public class TimesheetTaskDTO {
private String name ;
private String details ;
private float hours ;
private Date date ;
private String task ;
private String employeeId ;


public String getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(String employeeId) {
	this.employeeId = employeeId;
}
public String getTask() {
	return task;
}
public void setTask(String task) {
	this.task = task;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
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
	return "TimesheetTaskDTO [name=" + name + ", details=" + details + ", hours=" + hours + ", date=" + date + "]";
}






}
