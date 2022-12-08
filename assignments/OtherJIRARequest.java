package week3.assignments;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class OtherJIRARequest extends BaseClassJIRA{

	@Test(dependsOnMethods = {"week3.assignments.CreateIssue.createIssueTest"}, priority = 1)
	public void putIssueTest() {
		
		RequestSpecification prequest = request.given().body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"description\": \"Bug creation Using REST API for testing-update\",\r\n"
				+ "        \"environment\": \"Testing\",\r\n"
				+ "        \"priority\":{\r\n"
				+ "        \"name\": \"High\"\r\n"
				+ "    }\r\n"
				+ "}\r\n"
				+ "}");
		response = prequest.put("issue/"+key);
		
		response.then().assertThat().statusCode(204);
	}
	
	@Test(dependsOnMethods = {"week3.assignments.CreateIssue.createIssueTest"}, priority = 2)
	public void getIssueTest() {
		
	
		response = request.get("issue/"+key);
		
		response.then().assertThat().statusCode(200);
	}
	
	@Test(dependsOnMethods = {"week3.assignments.CreateIssue.createIssueTest"}, priority = 3)
	public void getAllIssueTest() {
		
	
		response = request.given().queryParam("jql", "project=\"APS\"").get("/search");
		
		response.then().assertThat().statusCode(200);
		
		response.then().assertThat().body("issues.key", Matchers.hasItem(key));
	}
	
	@Test(dependsOnMethods = {"week3.assignments.CreateIssue.createIssueTest"}, priority = 4)
	public void deleteIssueTest() {
		
	
		response = request.delete("issue/"+key);
		
		response.then().assertThat().statusCode(204);
		response.then().assertThat().statusLine("HTTP/1.1 204 No Content");

	}
	
	

}
