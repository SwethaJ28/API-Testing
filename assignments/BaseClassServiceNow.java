package week3.assignments;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClassServiceNow {

	static RequestSpecification request = null;
	static String sys_id = null;
	static String number = null;
	static Response response = null;

	@BeforeMethod

	public void baseClassSNTest() {

		RestAssured.baseURI = "https://dev81059.service-now.com/api/now/table/incident";

		RestAssured.authentication = RestAssured.basic("admin", "@HKku6=fyQ6B");

		request = RestAssured.given().contentType(ContentType.JSON).log().all();

	}

	@AfterMethod

	public void respose() {
		response.then().log().all();
	}

}
