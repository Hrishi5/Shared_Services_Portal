package project.applyLeaveWebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.applyLeaveWebapp.dao.ApplyLeaveDAO;
import project.applyLeaveWebapp.dto.ApplyLeaveDetailsDTO;
import project.applyLeaveWebapp.dto.ResponseDTO;

@Service
public class ApplyLeaveServiceImpl implements ApplyLeaveService{
	@Autowired
	ApplyLeaveDAO dao;
	
	public ResponseDTO getApplyLeaveDetails() {
		ResponseDTO response = new ResponseDTO() ;
		List<ApplyLeaveDetailsDTO> list = dao.getApplyLeaveDetails() ;
		if(list.size() == 0) {
			response.setStatus("0");
		}else {
			response.setResponse(list);
			response.setStatus("1");
		}
		return response ;
	}

	public ResponseDTO insertIntoApplyDetailsTable(ApplyLeaveDetailsDTO dto) {
		ResponseDTO response = new ResponseDTO() ;
		if(dto == null) {
			response.setStatus("0");
			response.setStatus("Invalid input");
			return response ;
		}
		int id = dao.insertIntoApplyLeaveTable(dto) ;
		if(id <= 0) {
			response.setStatus("0");
			response.setStatus("Failed to save data");
		}else {
			response.setStatus("1");
			response.setResponse("Successfully saved date!");
		}
		return response ;
	}

	
}
