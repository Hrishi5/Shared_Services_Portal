package project.internshipWebapp.dao;



import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
 

public class BaseDAO {
	
	@Autowired
	DataSource datasource ;
	
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	

}
