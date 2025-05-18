package api.urls;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

import api.payloads.User;

public class User_requests {
	
	public static Response createuser(User payload)
	{
		Response response=
	    given()
			    .contentType(ContentType.JSON)
			    .accept(ContentType.JSON)
			    .body(payload)
	    .when()
	            .post(Routes.POST_URL);
	    return response;
	    
	}
	
	public static Response readUser(String userName)
	{

		Response response=
				given()
						.pathParam("username", userName)
				.when()
				 		.get(Routes.GET_URL);
	    return response;
	}
	
	public static Response Updateuser(String userName, User payload)
	{

		Response response=
				given() 
					    .contentType(ContentType.JSON)
					    .accept(ContentType.JSON)
						.body(payload)
						.pathParam("username", userName)
				.when()
				 		.put(Routes.UPDATE_URL);
	    return response;
	}
	
	public static Response deleteuser(String userName)
	{

		Response response=
				given()
						.pathParam("username", userName)
				.when()
				 		.delete(Routes.DELETE_URL);
	    return response;
	}
	
	

}
