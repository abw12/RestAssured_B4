package mocking;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostTestMock {
	
	@Test
public void postTest() {
		
		JSONObject jo = new JSONObject();
		jo.put("name","John");
		jo.put("job","Tester");
		baseURI = "http://localhost:3001";

		given()
		.contentType("application/json")
		.accept(ContentType.JSON)
		.body(jo.toJSONString())
		.when()
		.post("/api/users")
		.then()
		.statusCode(201)
		.log().all();
	}

}
