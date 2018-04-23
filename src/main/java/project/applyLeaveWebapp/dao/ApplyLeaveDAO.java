package project.applyLeaveWebapp.dao;

import project.applyLeaveWebapp.dto.ApplyLeaveDetailsDTO;
import java.util.List;

public interface ApplyLeaveDAO {

	public List<ApplyLeaveDetailsDTO> getApplyLeaveDetails();
	public int insertIntoApplyLeaveTable(ApplyLeaveDetailsDTO dto);
}
