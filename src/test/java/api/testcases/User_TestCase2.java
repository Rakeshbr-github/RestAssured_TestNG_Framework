package api.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.payloads.User;
import api.urls.User_requests2;
import io.restassured.response.Response;

public class User_TestCase2 {
	
	Faker faker;
	User userPayload;
	public Logger logger;
	
	@BeforeClass
	public void setUpData()
	{
		faker=new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
//		to log these setup details 
		logger=LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority=1)
	public void testpostuser()
	{
		logger.info("***************Creating user********************");
		Response response=User_requests2.createuser(userPayload);
		response
				.then().log().all().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void getUserByName()
	{
		logger.info("***************Reading user info********************");
		Response response=User_requests2.readUser(this.userPayload.getUsername());
		response
		.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);	
		logger.info("**************User info is displayed********************");
	}
	
	@Test(priority=3)
	public void UpdateUser()
	{
		logger.info("***************User info updating********************");
//		Update data
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=User_requests2.Updateuser(this.userPayload.getUsername(), userPayload);
		response
				.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("***************User info updated********************");
	}
	
	@Test(priority=4)
	public void deleteUser()
	{
		logger.info("***************User info deleting********************");
		Response response=User_requests2.deleteuser(this.userPayload.getUsername());
		response
				.then().log().body().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("***************User info deleted********************");
	}

	
	
}
