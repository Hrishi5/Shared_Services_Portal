package project.timesheetWebapp.dto;

import java.util.ArrayList;
import java.util.List;

public class TimesheetDetailsDTO {

	private String date ;
	private float hours ;
	private List<TimesheetTaskDTO> tasks ;
	
	public TimesheetDetailsDTO() {
		tasks = new ArrayList<TimesheetTaskDTO>() ;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getHours() {
		return hours;
	}
	public void setHours(float hours) {
		this.hours = hours;
	}
	public List<TimesheetTaskDTO> getTasks() {
		return tasks;
	}
	public void setTasks(List<TimesheetTaskDTO> tasks) {
		this.tasks = tasks;
	}
	
	public void addTask(TimesheetTaskDTO dto) {
		tasks.add(dto) ;
	}
	
	public void removeTask(TimesheetTaskDTO dto) {
		tasks.remove(dto) ;
	}
	@Override
	public String toString() {
		return "TimesheetDetailsDTO [date=" + date + ", hours=" + hours + ", tasks=" + tasks + "]";
	}
	
	
	
}
