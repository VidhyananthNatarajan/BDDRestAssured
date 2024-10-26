package com.testPackage;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class SampleGETMethod {
@Test
public void verifyGETRequest() {
	
    given()
	 .header("Authorization","Bearer 6f1b388313271a302832c363fa16942e80e255bccb45e624b7950d3189200216")
	 .when()
	 .get("https://gorest.co.in/public/v2/users/5134315")
	 .then()
	  .statusCode(200)
      .assertThat()
      .body("gender", equalTo("male"))
      .log().body();    
	}
}
