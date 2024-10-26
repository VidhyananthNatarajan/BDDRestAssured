package com.testPackage;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SamplePUTMethod {
	
	@Test
	public void verifyPUTRequest() {
		
		//RestAssured.baseURI="https://gorest.co.in/public/v2/users";
		
		HashMap<String,String> map = new HashMap <String,String>();
		map.put("name","Testuser506");
		map.put("email","testuser506@test.com");
		map.put("gender","Female");
		map.put("status","Inactive");
		String token ="6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216";
		
		
		 given()
		   .baseUri("https://gorest.co.in/public/v2/users/5134357")
		   .contentType("application/json")
		   .body(map)
		   .header("Authorization","Bearer "+token)
		.when()
		   .put()
		   
		.then()
		    .statusCode(200)
		    .assertThat()
		    .body("gender", equalTo("female"))
		    .body("status", equalTo("inactive"))
		    .log().body()
		    .extract().response();
	}
}
