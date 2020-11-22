package org.com.test;

import org.com.data.JSONplaceholderdata;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JSonplaceholdertest {
	
	HashMap map= new HashMap();
	HashMap map1 = new HashMap();
	JSONObject obj;
	JSONObject obj1;
	
	int randomId;
	String randomURI;
	
	@BeforeClass
	public void setup() {
		map.put("userId", JSONplaceholderdata.getRandomUserId());
		map.put("id", JSONplaceholderdata.getRandomId());
		map.put("title", JSONplaceholderdata.getRandomTitle());
		map.put("body", JSONplaceholderdata.getRandomBody());
		
		
		RestAssured.baseURI="https://jsonplaceholder.typicode.com";
		RestAssured.basePath = "/posts";
		obj= new JSONObject(map);
		
		
		
		
		randomId=JSONplaceholderdata.getRandomIDNumber();
		System.out.println(randomId);
		randomURI = "https://jsonplaceholder.typicode.com/posts/"+randomId;
		
		map1.put("userId", JSONplaceholderdata.getRandomUserId());
		map1.put("id", randomId);
		map1.put("title", JSONplaceholderdata.getRandomTitle());
		map1.put("body", JSONplaceholderdata.getRandomBody());
		obj1 = new JSONObject(map1);
		System.out.println(randomURI);
		System.out.println(obj1);
	}
	
	@Test(priority=0)
	public void getPosts() {
		given()
			.header("Contenet-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.statusCode(200)
				.log().all()
		        .body("userId[0]",equalTo(1))
		        .and()
			    .body("title[0]",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
			    .and()
			    .body("id[3]",equalTo(4))
			    .and()
				.body("title[3]",containsString("occaecati"))
				.and()
				.body("body[5]",containsString("ut aspernatur"));
	}
	
	@Test(priority=1)
	public void postData() {
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(obj)
			
		.when()
			.post()
		.then()
			.statusCode(201)
			.log().all()
			.body("body",containsString("agent number"));
			
		
	}
	
	@Test(priority=2)
	public void  patchData() {
		
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(obj1)
		.when()
			.patch(randomURI)
		.then()
			.statusCode(200)
			.log().all()
			
			.and()
			.body("id",equalTo(randomId))
			.and()
			.body("title",equalTo(map1.get("title")))
			.and()
			.body("userId",equalTo(map1.get("userId")))
			.and()
			.body("body",equalTo(map1.get("body")));
		
	}
	
	@Test(priority=3)
	public void deleteData() {
		given()
			.header("Content-Type","application/json")
			.accept(ContentType.JSON)
			.contentType(ContentType.JSON)
			
		.when()
			.delete(randomURI)
		.then()
			.statusCode(200);
	}
}
