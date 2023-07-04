package authentication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class OAuthTest {
	
	@Test
	public void bearerTokenTest()
	{
		baseURI = "https://api.github.com";
		String apiToken = "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";

		given()
		.auth().oauth2(apiToken)
		.when().get("/user/repos")
		.then().statusCode(200)	
		.log().all();
	}

}
