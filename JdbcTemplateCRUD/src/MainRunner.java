import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;  
public class MainRunner {  
	public static void main(String[] args) {  
		ApplicationContext ctx=null;
	    ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
	    
	    EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
	    
	    try {
	    	dao.saveEmployee(new EmployeePojo(105,"Glenn",5600));  
	    	System.out.println("Inserted.. ");  
	    }
	    catch(Exception e) {
	    	System.out.println("Enter unique ID for insertion!!");
	    }
	          
	    dao.updateEmployee(new EmployeePojo(103,"Updated orton",15000)); 
	    System.out.println("Updated!!.. "); 
	      
	    try {
	    EmployeePojo e=new EmployeePojo(); 
	    e.setId(0); 
	    dao.deleteEmployee(e); 
	    System.out.println("Record deleted...");  
	    }
	    catch(Exception e) {
	    	System.out.println("No such ID!!");
	    }
	    
	    if(ctx!=null) {
	    	((AbstractApplicationContext) ctx).close();
	    }
	}  
} 