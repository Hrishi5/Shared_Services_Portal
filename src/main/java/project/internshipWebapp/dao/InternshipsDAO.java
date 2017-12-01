package project.internshipWebapp.dao;

import java.util.List;

import project.internshipWebapp.dto.InternshipDetailsDTO;
import project.internshipWebapp.dto.StudentDetailsDTO;

public interface InternshipsDAO {

	List<StudentDetailsDTO> getStudentDetails();
	List<InternshipDetailsDTO> getInternshipDetails() ;
	public int insertIntoInternshipTable(InternshipDetailsDTO dto);
	public int deleteFromInternshipTable(int internshipId) ;
	public int updateInternshipTable(String query,InternshipDetailsDTO dto) ;

}