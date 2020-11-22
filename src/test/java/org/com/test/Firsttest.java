package org.com.test;

import org.com.data.Testdata;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class Firsttest {
	
	HashMap map = new HashMap();
	JSONObject jsondata;
	
	@BeforeClass
	public void setup() {
		map.put("name", Testdata.getRandomName());
		map.put("type", Testdata.getRandomType());
		map.put("price", Testdata.getRandomPrice());
		map.put("Shipping", Testdata.getRandomShipping());
		map.put("upc", Testdata.getRandomUPC());
		map.put("description", Testdata.getRandomDesc());
		map.put("manufacturer", Testdata.getRandomManufacturer());
		map.put("model", Testdata.getRandomModel());
		map.put("url", Testdata.getRandomURL());
		map.put("image", Testdata.getRandomIMG());
		
		
		RestAssured.baseURI ="http://localhost:3030";
		RestAssured.basePath="/products";
		jsondata = new JSONObject(map);
		System.out.println(map);
		System.out.println(jsondata);
	}
	
	@Test
	public void testFirst() {
		ValidatableResponse resp = given()
		   .when()
		   		.get()
		   	.then()
		   		.statusCode(200)
				.log().all();
				
//	System.out.println(resp.toString());	
	}
	
	
	@Test
	public void testPost() {
		given()
	        .header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			
			.body(jsondata)
		.when()
			.post()
		.then()
			.statusCode(200)
			.log().all();

	}
	


}
