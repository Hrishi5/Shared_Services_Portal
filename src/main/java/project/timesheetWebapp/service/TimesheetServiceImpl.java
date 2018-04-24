package project.timesheetWebapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.applyLeaveWebapp.dto.ResponseDTO;
import project.timesheetWebapp.constants.Constants;
import project.timesheetWebapp.dao.TimesheetDAO;
import project.timesheetWebapp.dto.TimesheetDetailsDTO;
import project.timesheetWebapp.dto.TimesheetTaskDTO;

@Service
public class TimesheetServiceImpl implements TimesheetService {
	@Autowired
	private TimesheetDAO dao ;
	
	public ResponseDTO saveTimesheet(List<TimesheetDetailsDTO> dto) {
		ResponseDTO response = new ResponseDTO() ;
		if(dto == null || dto.size() == 0) {
			response.setStatus(Constants.statusZero);
			response.setResponse(Constants.responseFailed);
			return response ;
		}
		int result = dao.saveTimesheet(dto) ;
		if(result <= 0 ) {
			response.setStatus(Constants.statusZero);
			response.setResponse(Constants.responseFailed);
			return response ;
		}else {
			response.setStatus(Constants.statusOne);
			response.setResponse(Constants.responseSuccess);
			return response ;
		}
	}
	
	public ResponseDTO getTimesheet(String employeeId,String date) {
		ResponseDTO response = new ResponseDTO() ;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateStr = null;
		try {
			dateStr = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<TimesheetTaskDTO> list = dao.getTimesheet(employeeId, dateStr) ;
		if(list.size() > 0) {
		TimesheetDetailsDTO day = new TimesheetDetailsDTO() ; 
		day.setDate(date);
		day.setTasks(list);		
		response.setStatus(Constants.statusOne);
		response.setResponse(day);
		}else {
			response.setStatus(Constants.statusZero);
			response.setResponse("Failed to get tasks for selected day");
		}
		return response ;
	}

}
