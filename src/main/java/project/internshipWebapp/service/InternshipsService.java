package project.internshipWebapp.service;

import project.internshipWebapp.dto.InternshipDetailsDTO;
import project.internshipWebapp.dto.ResponseDTO;

public interface InternshipsService {

	ResponseDTO getStudentDetails();
	
	ResponseDTO getInternshipDetails() ;
	
	ResponseDTO insertIntoInternshipTable(InternshipDetailsDTO dto) ;
	
	public ResponseDTO deleteFromInternshipTable(String internshipIdStr) ;
	
	public ResponseDTO updateInternshipDetails(InternshipDetailsDTO dto) ;
	

}