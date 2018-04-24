package project.timesheetWebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.applyLeaveWebapp.dto.ResponseDTO;
import project.timesheetWebapp.dto.JsonKeyValueDTO;
import project.timesheetWebapp.dto.TimesheetDetailsDTO;
import project.timesheetWebapp.service.TimesheetService;

@Controller
public class TimesheetController {
	@Autowired
	private TimesheetService service ;
	
	@RequestMapping(value="/saveTimesheet" ,method = RequestMethod.POST, produces="application/json")
	@ResponseBody public ResponseDTO saveTimesheet(@RequestBody List<TimesheetDetailsDTO> dto) {
		System.out.println(dto);
		return service.saveTimesheet(dto) ;
	}
	
	@RequestMapping(value="/getTimesheet" ,method = RequestMethod.POST, produces="application/json")
	@ResponseBody public ResponseDTO getTimesheet(@RequestBody JsonKeyValueDTO dto) {
		return service.getTimesheet(dto.getKey(), dto.getValue()) ;
	}
	
}
