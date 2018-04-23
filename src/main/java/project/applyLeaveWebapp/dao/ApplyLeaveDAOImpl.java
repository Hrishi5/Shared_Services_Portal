package project.applyLeaveWebapp.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import project.applyLeaveWebapp.dto.ApplyLeaveDetailsDTO;

@Repository
public class ApplyLeaveDAOImpl extends BaseDAO implements ApplyLeaveDAO{

	public List<ApplyLeaveDetailsDTO> getApplyLeaveDetails() {
		return jdbcTemplate.query("select * from leave",new BeanPropertyRowMapper<ApplyLeaveDetailsDTO>(ApplyLeaveDetailsDTO.class)) ;
									// could be applyLeave depending on database
	}

	public int insertIntoApplyLeaveTable(ApplyLeaveDetailsDTO dto) {
//		List<String> idList = jdbcTemplate.queryForList("SELECT MAX(id) FROM Leaves",String.class) ;
//		// could be applyLeave depending on database
//		if(idList.size() == 0) {
//			return -1 ;
//		}else {
//			int id = Integer.parseInt(idList.get(0)) + 1 ;
//			dto.setLeaveID((id));
//		}
		
		System.out.println(dto);
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate) 
		.withTableName("Leaves") ; 
		
		SqlParameterSource ps = new BeanPropertySqlParameterSource(dto) ;
		int key = insert.execute(ps) ;
		System.out.println(key);
		return key ;
	}

}
