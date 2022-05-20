package steps;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.hamcrest.core.Is;

import com.edsoft.framework.base.api.RestAssuredExtension;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import model.Posts;

public class BDDStyledMethod {
	
	public static ResponseOptions<Response> response;
	public static String token;
	/**
	 * *******************GET**************************
	 */

	/**
	 * passagem do id =1 @throws Exception
	 */
	public static void simpleGETPost(String postNumber) {
		given()
			.contentType(ContentType.JSON).when()
			.get(String.format("http://localhost:3000/posts/%s",postNumber))
    	.then()
    		.body("author", is("Eduardo"));
	}
	
	/**
	 * Validação de authores @throws Exception
	 */
	public static void PerformContainsCollection() {
        given()
                .contentType(ContentType.JSON)
                
        .when()
                .get("http://localhost:3000/posts")
        .then()
                .body("author", containsInAnyOrder("Eduardo", "Henrique",null)).statusCode(204);
    }
	
	/**
	 * Parameter de post = 1 @throws Exception
	 */
	public static void PerformPathParameter() {
		given()
			.contentType(ContentType.JSON)
		.with()
			.pathParam("post", "1")
		.when()
			.get("http://localhost:3000/posts/{post}")
		.then()
			.body("author", containsString("Eduardo"));
	}
	
	/**
	 * Parameter por query @throws Exception
	 */
	public static void PerformQueryParameter() {
		given()
			.contentType(ContentType.JSON)
			.queryParam("id", 1)
		.when()
			.get("http://localhost:3000/posts/")
		.then()
			.body("author", hasItem("Eduardo"));
	}
	
	/**
	 * *******************POST**************************
	 */
	
	/**
	 * Criação de Posts  @throws Exception
	 */
	public static void PerformPOSTWithBodyParameter() {
		HashMap<String, String> postContent = new HashMap<>();
		postContent.put("id","16");
		postContent.put("title","API Testing course");
		postContent.put("author","Test");
		
		given()
			.contentType(ContentType.JSON)
		.with()
		      .body(postContent)
	    .when()
			.post("http://localhost:3000/posts")
		.then()
			.body("author", Is.is("Test"));
	}
}
