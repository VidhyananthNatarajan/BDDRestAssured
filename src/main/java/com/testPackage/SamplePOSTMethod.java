package com.testPackage;

import java.util.HashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class SamplePOSTMethod {
	
@Test
public void verifyPOSTRequest() {
	
	RestAssured.baseURI="https://gorest.co.in/public/v2/users";
	
	HashMap<String,String> map = new HashMap <String,String>();
	map.put("name","UserTest510");
	map.put("email","userTest510@test.com");
	map.put("gender","male");
	map.put("status","Active");
	String token ="6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216";
	
	
	Response respone =
			
		given()
	   .contentType("application/json")
	   .body(map)
	   .header("Authorization","Bearer "+token)
	.when()
	   .post()
	   
	.then()
	    .statusCode(201)
	    .log().body()
	    .extract().response();
	
	String id = respone.jsonPath().getString("id");
	System.out.println("The Content id is:" +id);	
}
}
