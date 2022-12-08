package week3.assignments;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class UPDTestServiceNow extends BaseClassServiceNow{
	
	@Test(priority = 1, dependsOnMethods = {"week3.assignments.POST_CreateIncident.createIncidentTest"})
	
	public void patchIncident() {
		
		response = request.body("{\r\n"
				+ "    \"description\": \"patch-updating the comments\",\r\n"
				+ "    \"short_description\": \"Using Patch comments for hamcrest\",\r\n"
				+ "    \"user_input\": \"working upon the fix will update by EOD\"\r\n"
				+ "}").patch("/"+sys_id);
		
		response.then().assertThat().body("result.short_description", Matchers.equalTo("Using Patch comments for hamcrest"));
		
		response.then().assertThat().statusCode(200);
		
	}
	
@Test(priority = 2, dependsOnMethods = {"week3.assignments.POST_CreateIncident.createIncidentTest"})
	
	public void putIncident() {
		
		response = request.body("{\r\n"
				+ "    \"description\": \"PUT-updating the comments\",\r\n"
				+ "    \"short_description\": \"Using put comments for hamcrest\",\r\n"
				+ "    \"user_input\": \"working upon the fix will update by EOD-PUT\"\r\n"
				+ "}").put("/"+sys_id);
		
		response.then().assertThat().body("result.short_description", Matchers.containsString("hamcrest"));
		
		response.then().assertThat().body("result.number", Matchers.equalTo(number));
		
		response.then().assertThat().statusCode(200);
		
	}

@Test(priority = 3, dependsOnMethods = {"week3.assignments.POST_CreateIncident.createIncidentTest"})

public void deleteIncident() {
	
	response = request.delete("/"+sys_id);
		
	response.then().assertThat().statusCode(204);
	
	response.then().assertThat().statusLine("HTTP/1.1 204 No Content");

	
}

}
