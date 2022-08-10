package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.util.TestUtil;

public class GetApiTest extends TestBase {
	TestBase testBase;
	String pageUrl;
	String apiUrl;
	String actualUrl;
	RestClient restClient;
	CloseableHttpResponse closeablehttpResponse;
	

	@BeforeMethod
	
	public void setup() {
		
		testBase = new TestBase();
		pageUrl= prop.getProperty("URL");
		 apiUrl= prop.getProperty("serviceURL");
		 
		actualUrl = pageUrl+apiUrl;
		
		//creating a obj of rest client method to get url
		
		
		
	}
	
	@Test(priority=1)
	public void getAPITestwithoutHeaders() throws ClientProtocolException, IOException {
		restClient= new RestClient();
		closeablehttpResponse = restClient.get(actualUrl);
		
		
		int statusCode =closeablehttpResponse.getStatusLine().getStatusCode();
		 System.out.println("Status Code--->"+	statusCode);
		 
		 //validation
		 Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");
		 
		 
		 //below will retirevie the joson from api as string
		String responseString = EntityUtils.toString(closeablehttpResponse.getEntity(), "UTF-8");
		//below will convert the above string in to json format
		JSONObject responsejson = new JSONObject(responseString);
		
		 System.out.println("responsejson from API--->"+	responsejson);
		 
		 //single value asserstion
		 String perPageValue = TestUtil.getValueByJPath(responsejson,"/per_page");
		 System.out.println("value of per page is-->"+perPageValue);
		 Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		 
		 
		 //Json array assesrtion
		 String lastName= TestUtil.getValueByJPath(responsejson, "/data[0]/last_name");
		 String avatar= TestUtil.getValueByJPath(responsejson, "/data[0]/avatar");
		 String id= TestUtil.getValueByJPath(responsejson, "/data[0]/id");
		 String firstName= TestUtil.getValueByJPath(responsejson, "/data[0]/first_name");
		 System.out.println(lastName);
		 System.out.println(avatar);
		 System.out.println(id);
		 System.out.println(firstName);
		 
		 
		 
		 
		 
		 
		 //header validation-->below line stores teh header value inside an array
		 Header[] headerArray = closeablehttpResponse.getAllHeaders();
		 
		 //since we wanted like key, value format we re converting the array to hashmap
		 HashMap<String,String> allHeader = new HashMap<String,String>();
		 
		 for (Header header: headerArray) {
			 allHeader.put(header.getName(), header.getValue());
		 }
		 System.out.println("Headers Arrray-->"+allHeader);
		 
		 
		
	}
	
	@Test(priority=2)
	public void getAPITestWithHeaders() throws ClientProtocolException, IOException {
		restClient= new RestClient();
		
		HashMap<String,String> headerMap= new HashMap<String,String>();
		headerMap.put("Content-Type", "application/json");
		closeablehttpResponse = restClient.get(actualUrl,headerMap);
		
		
		int statusCode =closeablehttpResponse.getStatusLine().getStatusCode();
		 System.out.println("Status Code--->"+	statusCode);
		 
		 //validation
		 Assert.assertEquals(statusCode, RESPONSE_STATUS_CODE_200, "Status code is not 200");
		 
		 
		 //below will retirevie the joson from api as string
		String responseString = EntityUtils.toString(closeablehttpResponse.getEntity(), "UTF-8");
		//below will convert the above string in to json format
		JSONObject responsejson = new JSONObject(responseString);
		
		 System.out.println("responsejson from API--->"+	responsejson);
		 
		 //single value asserstion
		 String perPageValue = TestUtil.getValueByJPath(responsejson,"/per_page");
		 System.out.println("value of per page is-->"+perPageValue);
		 Assert.assertEquals(Integer.parseInt(perPageValue), 6);
		 
		 
		 //Json array assesrtion
		 String lastName= TestUtil.getValueByJPath(responsejson, "/data[0]/last_name");
		 String avatar= TestUtil.getValueByJPath(responsejson, "/data[0]/avatar");
		 String id= TestUtil.getValueByJPath(responsejson, "/data[0]/id");
		 String firstName= TestUtil.getValueByJPath(responsejson, "/data[0]/first_name");
		 System.out.println(lastName);
		 System.out.println(avatar);
		 System.out.println(id);
		 System.out.println(firstName);
		 
		 
		 
		 
		 
		 
		 //header validation-->below line stores teh header value inside an array
		 Header[] headerArray = closeablehttpResponse.getAllHeaders();
		 
		 //since we wanted like key, value format we re converting the array to hashmap
		 HashMap<String,String> allHeader = new HashMap<String,String>();
		 
		 for (Header header: headerArray) {
			 allHeader.put(header.getName(), header.getValue());
		 }
		 System.out.println("Headers Arrray-->"+allHeader);
		 
		 
		
	}
	
	@AfterMethod
	public void tearDown() {
		
	}
}
