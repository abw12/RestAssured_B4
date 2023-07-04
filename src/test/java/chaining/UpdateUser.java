package chaining;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;

public class UpdateUser {
	
	@Parameters({"appBaseURI","token"})
	@Test
	public void updateUserTest(String appBaseURI,String token ,ITestContext context) {


		baseURI = appBaseURI;
		int id= (int) context.getSuite().getAttribute("id");

		Faker faker = new Faker();
		JSONObject jo = new JSONObject();
		jo.put("name",faker.name().fullName());
		jo.put("gender","male");
		jo.put("email",faker.internet().emailAddress());
		jo.put("status","inactive");

		given()
		.contentType("application/json")
		.accept(ContentType.JSON)
		.headers("Authorization","Bearer " + token)
		.pathParam("id", id)
		.body(jo.toJSONString())
		.when()
		.put("/public/v2/users/{id}")
		.then()
		.statusCode(200)
		.log().all();

	}

}
