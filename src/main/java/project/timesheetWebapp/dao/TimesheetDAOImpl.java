package project.timesheetWebapp.dao;

import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import project.applyLeaveWebapp.dao.BaseDAO;
import project.timesheetWebapp.constants.QueryConstant;
import project.timesheetWebapp.dto.TimesheetDetailsDTO;
import project.timesheetWebapp.dto.TimesheetTaskDTO;

@Repository
public class TimesheetDAOImpl extends BaseDAO implements TimesheetDAO{

	public int saveTimesheet(List<TimesheetDetailsDTO> timesheet) {
		String userId = "926882" ;
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate) 
				.withTableName("timesheet") ;
		int result = 0 ;
		for(TimesheetDetailsDTO day : timesheet) {
			for(TimesheetTaskDTO task:day.getTasks()) {
				SqlParameterSource ps = new BeanPropertySqlParameterSource(task) ;
				result+= insert.execute(ps) ;
			}
		}
		return result ;
	}
	
	public List<TimesheetTaskDTO> getTimesheet(String employeeId , Date date) {
		return jdbcTemplate.query(QueryConstant.GET_TIMESHEET.toString() , new Object[] {employeeId,date} , new BeanPropertyRowMapper<TimesheetTaskDTO>(TimesheetTaskDTO.class)) ;
	}
	
	
	
}
