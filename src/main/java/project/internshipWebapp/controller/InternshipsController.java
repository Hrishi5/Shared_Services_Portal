package project.internshipWebapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.internshipWebapp.dto.InternshipDetailsDTO;
import project.internshipWebapp.dto.ResponseDTO;
import project.internshipWebapp.service.InternshipsService;

@Controller
public class InternshipsController {
	@Autowired
	InternshipsService service ;
	
	@RequestMapping(value="/students", method=RequestMethod.GET,produces="application/json")
	@ResponseBody public ResponseDTO getStudentDetails() {
		return service.getStudentDetails() ;
	}
	
	@RequestMapping(value="/viewInternships", method=RequestMethod.GET,produces="application/json")
	@ResponseBody public ResponseDTO getInternshipDetails() {
		return service.getInternshipDetails() ;
	}
	
	@RequestMapping(value="/saveInternship", method=RequestMethod.POST,produces="application/json")
	@ResponseBody public ResponseDTO saveInternshipDetails(@RequestBody InternshipDetailsDTO dto) {
		return service.insertIntoInternshipTable(dto) ;
	}
	
	@RequestMapping(value="/deleteInternship", method=RequestMethod.POST,produces="application/json")
	@ResponseBody public ResponseDTO deleteInternshipDetails(@RequestBody InternshipDetailsDTO dto) {
		return service.deleteFromInternshipTable(dto.getInternshipId()) ;
	}
	
	@RequestMapping(value="/updateInternship", method=RequestMethod.POST,produces="application/json")
	@ResponseBody public ResponseDTO updateInternshipDetails(@RequestBody InternshipDetailsDTO dto) {
		return service.updateInternshipDetails(dto) ;
	}
	
	
	
}
