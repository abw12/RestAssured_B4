package httpmethodtypes;


import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.equalTo;

public class GetTest {

	@Test
	public void getTest(){

		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(res.statusCode());
		System.out.println(res.getStatusCode());

		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.jsonPath().getString("data[1].first_name"), "Lindsay");
		Assert.assertNotEquals(res.jsonPath().getString("data[1].first_name"), "Abhi");

	}

	@Test
	public void getTestBDD()
	{
		baseURI = "https://reqres.in";

		given().queryParam("page",2)
		.when().get("/api/users")
		.then().statusCode(200)
		.body("data[0].first_name", equalTo("Michael"))
		.body("data[5].id",equalTo(12))
		.body("data.first_name",hasItems("Lindsay"))
		.log().all();
	}

}
