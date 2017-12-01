package project.internshipWebapp.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import project.internshipWebapp.dto.InternshipDetailsDTO;
import project.internshipWebapp.dto.StudentDetailsDTO;

@Repository
public class InternshipsDAOImpl extends BaseDAO implements InternshipsDAO {

	/* (non-Javadoc)
	 * @see project.internshipWebapp.dao.InternshipsDAO#getStudentDetails()
	 */
	public List<StudentDetailsDTO> getStudentDetails() {
		return jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<StudentDetailsDTO>(StudentDetailsDTO.class)) ;
	}
	

	public List<InternshipDetailsDTO> getInternshipDetails() {
		// TODO Auto-generated method stub
		String query = "select i.internshipID,i.description,i.Type,c.companyName,c.comAddress,c.comEmail from internship i,company c where i.companyId = c.companyID" ;
		return jdbcTemplate.query(query,new BeanPropertyRowMapper<InternshipDetailsDTO>(InternshipDetailsDTO.class) ) ;
	}
	
	public int insertIntoInternshipTable(InternshipDetailsDTO dto) {
		
		List<String> idList = jdbcTemplate.queryForList("SELECT MAX(INTERNSHIPID) FROM INTERNSHIP",String.class) ;
		if(idList.size() == 0) {
			return -1 ;
		}else {
			int id = Integer.parseInt(idList.get(0)) + 1 ;
			dto.setInternshipId(String.valueOf(id));
		}
		System.out.println(dto);
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate) 
		.withTableName("internship") ; 
		
		SqlParameterSource ps = new BeanPropertySqlParameterSource(dto) ;
		int key = insert.execute(ps) ;
		System.out.println(key);
		return key ;
	}
	
	public int deleteFromInternshipTable(int internshipId) {
		return jdbcTemplate.update("DELETE FROM INTERNSHIP WHERE INTERNSHIPID = ?", new Object[] {internshipId}) ;
	}


	public int updateInternshipTable(String query, InternshipDetailsDTO dto) {
		return jdbcTemplate.update(query,dto.getInternshipId()) ;
		
	}
	
	
}
