package chaining;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Parameters({"appBaseURI","token"})
	@Test
	public void getUserTest(String appBaseURI,String token,ITestContext context)
	{
		baseURI = appBaseURI;
		int id= (int) context.getSuite().getAttribute("id");
		
		System.out.println("ID from testContext: " + id);

		given().
		headers("Authorization","Bearer " + token)
		.contentType("application/json")
		.pathParam("id", id)
		.when().get("/public/v2/users/{id}")
		.then().statusCode(200)
		.log().all();
	}

}
