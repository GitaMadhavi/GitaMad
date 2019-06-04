package ExampleRestAssured.ExampleRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {
	
	@Test
	public void testResponseData(){
		
		Response resp = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int code = resp.statusCode();
		System.out.println("status code:"+ code);
		Assert.assertEquals(code,200);
	}

}
