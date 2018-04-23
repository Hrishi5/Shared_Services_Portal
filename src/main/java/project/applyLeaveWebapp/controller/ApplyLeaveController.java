package project.applyLeaveWebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.applyLeaveWebapp.dto.ApplyLeaveDetailsDTO;
import project.applyLeaveWebapp.dto.ResponseDTO;
import project.applyLeaveWebapp.service.ApplyLeaveService;


@Controller
public class ApplyLeaveController {

	@Autowired
	ApplyLeaveService service ;
	
	@RequestMapping(value="/viewLeave",method=RequestMethod.GET,produces="application/json")
	@ResponseBody public ResponseDTO getApplyLeaveDetails()
	{
		return service.getApplyLeaveDetails();
	}
	
	@RequestMapping(value="/applyLeave",method=RequestMethod.POST,produces="application/json")
	@ResponseBody public ResponseDTO insertIntoApplyLeaveTable(@RequestBody ApplyLeaveDetailsDTO dto)
	{	System.out.println(dto);
		return service.insertIntoApplyDetailsTable(dto);
	}
}
