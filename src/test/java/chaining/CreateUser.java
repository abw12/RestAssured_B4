package chaining;



import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
public class CreateUser {

	@Parameters({"appBaseURI","token"})
	@Test
	public void postUserTest(String appBaseURI,String token ,ITestContext context) {
		baseURI = appBaseURI;

		Faker faker = new Faker();
		JSONObject jo = new JSONObject();
		jo.put("name",faker.name().fullName());
		jo.put("gender","male");
		jo.put("email",faker.internet().emailAddress());
		jo.put("status","active");


		int id =given()
				.headers("Authorization","Bearer " + token)
				.contentType("application/json")
				.accept(ContentType.JSON)
				.body(jo.toJSONString())
				.when()
				.post("/public/v2/users")
//				.jsonPath().getInt("id");
				.then()
				.statusCode(201)
				.log().all()
				.extract().jsonPath().getInt("id");
		
		context.getSuite().setAttribute("id", id);
		
		System.out.println("Generated User id : " + id);

	}

}
