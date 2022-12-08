package week3.assignments;



import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class POST_CreateIncident extends BaseClassServiceNow{
	
	@Test
	
	public void createIncidentTest() {
		
		response = request.post();
		
		sys_id = response.jsonPath().get("result.sys_id");
		number = response.jsonPath().get("result.number");
		
		System.out.println("The Created Incident number is "+number+ " and is sys_id follows: "+sys_id);
		
		response.then().assertThat().body("result.number", Matchers.containsString("INC"));
		
		response.then().assertThat().statusCode(201);
		
		

	}

}
