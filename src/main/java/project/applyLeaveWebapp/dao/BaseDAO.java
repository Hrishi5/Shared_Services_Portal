package project.applyLeaveWebapp.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
 

public class BaseDAO {
	
	@Autowired
	public DataSource datasource ;
	
	@Autowired
	public JdbcTemplate jdbcTemplate ;
	
	

}
