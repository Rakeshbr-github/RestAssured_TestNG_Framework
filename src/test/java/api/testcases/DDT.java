package api.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.payloads.User;
import api.urls.User_requests;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDT {
	
	@Test(priority=1, dataProvider="Data",dataProviderClass=DataProviders.class)
	public void postuser(String userID,String userName,String fname,String Lname,String useremail,String pwd,String ph)
	{
		User userPayload=new User();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(Lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response response=User_requests.createuser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);	
	}
	
	@Test(priority=2,dataProvider="deletedata",dataProviderClass=DataProviders.class)
	public void deletuser(String username)
	{
            Response response= User_requests.deleteuser(username);
             Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
