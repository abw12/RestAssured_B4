package httpmethodtypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.equalTo;

public class PostType {
	
	@Test
	public void postTest() {
		
		JSONObject jo = new JSONObject();
		jo.put("name","John");
		jo.put("job","Tester");
		
		System.out.println(jo.toJSONString());
		
		baseURI = "https://reqres.in";

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
