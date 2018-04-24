package project.timesheetWebapp.dao;

import java.util.Date;
import java.util.List;

import project.timesheetWebapp.dto.TimesheetDetailsDTO;
import project.timesheetWebapp.dto.TimesheetTaskDTO;

public interface TimesheetDAO {
	public int saveTimesheet(List<TimesheetDetailsDTO> timesheet) ;
	
	public List<TimesheetTaskDTO> getTimesheet(String employeeId , Date date) ;
}
