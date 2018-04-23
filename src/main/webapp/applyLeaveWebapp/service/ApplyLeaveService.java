package project.applyLeaveWebapp.service;

import org.springframework.stereotype.Service;

import project.applyLeaveWebapp.dto.ApplyLeaveDetailsDTO;
import project.applyLeaveWebapp.dto.ResponseDTO;

@Service
public interface ApplyLeaveService {

	ResponseDTO getApplyLeaveDetails();
	
	ResponseDTO insertIntoApplyDetailsTable(ApplyLeaveDetailsDTO dto) ;
	
}
