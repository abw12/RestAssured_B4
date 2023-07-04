package mocking;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

public class GetTestMock {
	
	@Test
	public void getTestMock() {
		baseURI = "http://localhost:3001";

		given().queryParam("page",2)
		.when().get("/api/users")
		.then().statusCode(200)
		.log().all();
	}

}
