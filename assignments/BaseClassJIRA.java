package week3.assignments;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClassJIRA {
	
	static String key = null;
	static RequestSpecification request =null;
	static Response response = null;
	
	@BeforeMethod
	public void preSetup() {
		
		RestAssured.baseURI = "https://swethasj99.atlassian.net/rest/api/2/";
		RestAssured.authentication = RestAssured.preemptive().basic("swethajeyachandran28@gmail.com", "WQFDy6w1c4Pi2yz499Bu8DF5");
		
		request=RestAssured.given().contentType(ContentType.JSON).log().all();
		
	}
	
	@AfterMethod
	public void postSetup() {
		response.then().log().all(); 
	}

}
