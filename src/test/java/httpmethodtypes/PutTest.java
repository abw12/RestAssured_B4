package httpmethodtypes;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutTest {
	@Test
	public void putTest() {

		
		JSONObject jo = new JSONObject();
		jo.put("name","John");
		jo.put("job","Dev");
		
		System.out.println(jo.toJSONString());
		
		baseURI = "https://reqres.in";

		given()
		.contentType("application/json")
		.accept(ContentType.JSON)
		.body(jo.toJSONString())
		.when()
		.put("/api/users/2")
		.then()
		.statusCode(200)
		.log().all();
	
	}

}
