package week3.assignments;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class CreateIssue extends BaseClassJIRA{
	
	@Test
	public void createIssueTest() {
		
		RequestSpecification prequest = request.given().body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "    \"project\":\r\n"
				+ "                {\r\n"
				+ "                    \"key\": \"APS\"\r\n"
				+ "                },\r\n"
				+ "    \"summary\": \"create issue in RA project\",\r\n"
				+ "    \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n"
				+ "    \"issuetype\": {\r\n"
				+ "                    \"name\": \"Bug\"\r\n"
				+ "                }\r\n"
				+ "    }\r\n"
				+ "}");
		response = prequest.post("issue/");
		
		key = response.jsonPath().get("key");
		
		System.out.println("The created Issue is "+key);
		
		response.then().assertThat().statusCode(201);
	}

}
