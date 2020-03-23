import org.springframework.jdbc.core.JdbcTemplate;  
  
public class EmployeeDao {  
	
	private JdbcTemplate jt;  
	  
	public void setJdbcTemplate(JdbcTemplate jt) {  
	    this.jt = jt;  
	}  
	  
	public int saveEmployee(EmployeePojo e){  
	    String query="insert into employee values('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";  
	    return jt.update(query);  
	}  
	public int updateEmployee(EmployeePojo e){  
	    String query="update employee set name='"+e.getName()+"',salary='"+e.getSalary()+"' where id='"+e.getId()+"' ";  
	    return jt.update(query);  
	}  
	public int deleteEmployee(EmployeePojo e){  
	    String query="delete from employee where id='"+e.getId()+"' ";  
	    return jt.update(query);  
	}  
	
}