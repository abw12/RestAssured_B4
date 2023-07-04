package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeleteUser {
	
	@Parameters({"appBaseURI","token"})
	@Test
public void deleteTest(String appBaseURI,String token,ITestContext context) {

		
		baseURI = appBaseURI;
		int id= (int) context.getSuite().getAttribute("id");
		
		
//		given().header("Authorization","Bearer " + token)
		
		when()
		.delete("/api/users/{id}")
		.then()
		.statusCode(204)
		.log().all();
	
	
	
	}

}
