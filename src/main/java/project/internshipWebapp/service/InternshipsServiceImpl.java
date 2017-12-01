package project.internshipWebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.internshipWebapp.dao.InternshipsDAO;
import project.internshipWebapp.dto.InternshipDetailsDTO;
import project.internshipWebapp.dto.ResponseDTO;
import project.internshipWebapp.dto.StudentDetailsDTO;

@Service
public class InternshipsServiceImpl implements InternshipsService {
	@Autowired
	InternshipsDAO dao ;
	/* (non-Javadoc)
	 * @see project.internshipWebapp.service.InternshipsService#getStudentDetails()
	 */
	public ResponseDTO getStudentDetails() {
		ResponseDTO response = new ResponseDTO() ;
		List<StudentDetailsDTO> list = dao.getStudentDetails() ;
		if(list.size() == 0) {
			response.setStatus("0");
		}else {
			response.setResponse(list);
			response.setStatus("1");
		}
		return response ;
	}
	public ResponseDTO getInternshipDetails() {
		// TODO Auto-generated method stub
		ResponseDTO response = new ResponseDTO() ;
		List<InternshipDetailsDTO> list = dao.getInternshipDetails() ;
		if(list.size() == 0) {
			response.setStatus("0");
		}else {
			response.setResponse(list);
			response.setStatus("1");
		}
		return response ;
	}
	public ResponseDTO insertIntoInternshipTable(InternshipDetailsDTO dto) {
		// TODO Auto-generated method stub
		ResponseDTO response = new ResponseDTO() ;
		if(dto == null) {
			response.setStatus("0");
			response.setStatus("Invalid input");
			return response ;
		}
		int id = dao.insertIntoInternshipTable(dto) ;
		if(id <= 0) {
			response.setStatus("0");
			response.setStatus("Failed to save data");
		}else {
			response.setStatus("1");
			response.setResponse("Successfully saved date!");
		}
		return response ;
	}
	
	public ResponseDTO deleteFromInternshipTable(String internshipIdStr) {
		ResponseDTO response = new ResponseDTO() ;
		int internshipId ;
		try {
			internshipId = Integer.parseInt(internshipIdStr) ;
		}catch(Exception e) {
			response.setStatus("0");
			response.setResponse("Invalid input");
			return response ;	
		}
		
		int affectedRows = dao.deleteFromInternshipTable(internshipId) ;
		if(affectedRows <= 0) {
			response.setStatus("0");
			response.setResponse("Failed to delete data");
			return response ;
		}
		response.setStatus("1");
		response.setResponse("Internship Removed");
		return response ;
	}
	public ResponseDTO updateInternshipDetails(InternshipDetailsDTO dto) {
		// TODO Auto-generated method stub
		ResponseDTO response = new ResponseDTO() ;
		if(null==dto.getInternshipId() || "".equalsIgnoreCase(dto.getInternshipId())) {
			response.setResponse("Invalid Input") ;
			response.setStatus("0");
			return response ;
		}
		boolean shouldUpdate = false ;
		StringBuilder sb = new StringBuilder("UPDATE INTERNSHIP SET ") ;
		if(null!=dto.getDescription() && !"".equalsIgnoreCase(dto.getDescription())) {
			sb.append("DESCRIPTION = " + "'"+dto.getDescription()+"'" + ",") ;
			shouldUpdate = true ;
		}
		if(null!=dto.getType() && !"".equalsIgnoreCase(dto.getType())) {
			sb.append("TYPE = " + "'"+dto.getType()+"'" + ",") ;
			shouldUpdate = true ;
		}
		if(null!=dto.getCompanyId() && !"".equalsIgnoreCase(dto.getCompanyId())) {
			sb.append("COMPANYID = " + "'"+dto.getCompanyId()+"'") ;
			shouldUpdate = true ;
		}
		if(sb.charAt(sb.length()-1) == ',') {
			sb.setCharAt(sb.length()-1,' ');
		}
		sb.append(" WHERE INTERNSHIPID = ?") ;
		System.out.println(sb);
		if(!shouldUpdate) {
			response.setResponse("No internship specified to be updated");
			response.setStatus("0");
			return response ;
		}
		int affectedRows = dao.updateInternshipTable(sb.toString(), dto) ;
		if(affectedRows <=0) {
			response.setStatus("0") ;
			response.setResponse("Failed to update data");
			return response ;
		}else {
			response.setStatus("1");
			response.setResponse("Internship details updated!");
			return response ;
		}
		
		
	}
}
