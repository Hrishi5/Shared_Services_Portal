package project.timesheetWebapp.service;

import java.util.List;

import project.applyLeaveWebapp.dto.ResponseDTO;
import project.timesheetWebapp.dto.TimesheetDetailsDTO;

public interface TimesheetService {
	
	public ResponseDTO saveTimesheet(List<TimesheetDetailsDTO> dto) ;
	public ResponseDTO getTimesheet(String employeeId , String date) ;	

}
