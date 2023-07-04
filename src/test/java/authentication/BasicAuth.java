package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BasicAuth {
		
	@Test
	public void basicAuthTest() {
		
		baseURI = "https://postman-echo.com";

		given()
		.auth().basic("postman", "password")
		.when()
		.get("/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
		
	}
	
	@Test
	public void digestAuthTest() {
		
		baseURI = "https://postman-echo.com";

		given()
		.auth().digest("postman", "password")
		.when()
		.get("/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
	
	@Test
	public void preemtiveAuthTest() {
		
		baseURI = "https://postman-echo.com";

		given()
		.auth().preemptive().basic("postman", "password")
		.when()
		.get("/basic-auth")
		.then()
		.statusCode(200)
		.body("authenticated", equalTo(true))
		.log().all();
	}
}
