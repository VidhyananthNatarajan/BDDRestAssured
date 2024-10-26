package com.testPackage;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class SamplePATCHMethod {
	
	@Test
	public void verifyPATCHRequest() {
		
		HashMap<String,String> map = new HashMap <String,String>();
		map.put("name","Testuser507");
		map.put("email","testuser507@test.com");
		map.put("gender","male");
		map.put("status","active");
		String token ="6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216";
		
		
		 given()
		   .baseUri("https://gorest.co.in/public/v2/users/5134357")
		   .contentType("application/json")
		   .body(map)
		   .header("Authorization","Bearer "+token)
		.when()
		   .patch()
		   
		.then()
		    .statusCode(200)
		    .assertThat()
		    .body("gender", equalTo("male"))
		    .body("status", equalTo("active"))
		    .log().body()
		    .extract().response();
	}

}
