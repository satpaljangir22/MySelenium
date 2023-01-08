package application.apitests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import application.apis.RestClient;

public class GetAPITests {

	String baseUrl;
	String apiUrl;
	String url;	
	
	@BeforeMethod
	public void setUp() {
		baseUrl = "https://reqres.in/";
		apiUrl = "/api/users";
		url = baseUrl + apiUrl;		
	}
	
	@Test
	public void testGetApi() throws ClientProtocolException, IOException {
		RestClient restClient = new RestClient();
		int statusCode = restClient.get(url);
		Assert.assertEquals(200, statusCode);
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Test Execution Completed.");
	}
}
