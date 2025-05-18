package api.urls;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import api.payloads.User;

public class User_requests2 {
	
//	This method is for getting url from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes=ResourceBundle.getBundle("routes"); //loads properties file
		return routes;
	}
	 	
	public static Response createuser(User payload)
	{
		
		String post_url=getURL().getString("POST_URL");
		Response response=
	    given()
			    .contentType(ContentType.JSON)
			    .accept(ContentType.JSON)
			    .body(payload)
	    .when()
	            .post(post_url);
	    return response;
	    
	}
	
	public static Response readUser(String userName)
	{
		String get_url=getURL().getString("GET_URL");
		Response response=
				given()
						.pathParam("username", userName)
				.when()
				 		.get(get_url);
	    return response;
	}
	
	public static Response Updateuser(String userName, User payload)
	{
		String update_url=getURL().getString("UPDATE_URL");
		Response response=
				given() 
					    .contentType(ContentType.JSON)
					    .accept(ContentType.JSON)
						.body(payload)
						.pathParam("username", userName)
				.when()
				 		.put(update_url);
	    return response;
	}
	
	public static Response deleteuser(String userName)
	{
		String delete_url=getURL().getString("DELETE_URL");
		Response response=
				given()
						.pathParam("username", userName)
				.when()
				 		.delete(delete_url);
	    return response;
	}
	
	

}
