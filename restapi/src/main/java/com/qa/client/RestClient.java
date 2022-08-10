package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//1. GET method without headers
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClinet = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url); //http get request
		//below one has all the response inlusdding status json data & header
		 CloseableHttpResponse closeablehttpResponse = httpClinet.execute(httpGet); //hit the get url
		 
		 //2nd part changes
		 
		 return closeablehttpResponse;
		 
	}
	
	//get method with header
		public CloseableHttpResponse get(String url, HashMap<String, String> hashMapObj) throws ClientProtocolException, IOException {
			CloseableHttpClient httpClinet = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url); //http get request
			
			for (Map.Entry<String, String> entry:hashMapObj.entrySet() ) {
				httpGet.addHeader(entry.getKey(),entry.getValue());
			}
			
		
			//below one has all the response inlusdding status json data & header
			 CloseableHttpResponse closeablehttpResponse = httpClinet.execute(httpGet); //hit the get url
			 
			 //2nd part changes
			 
			 return closeablehttpResponse;
		 
		 //api second part-->since need to do assert i want all these steps into my @test testng file
		/*
		 int statusCode =closeablehttpResponse.getStatusLine().getStatusCode();
		 System.out.println("Status Code--->"+	statusCode);
		 
		 
		 //below will retirevie the joson from api as string
		String responseString = EntityUtils.toString(closeablehttpResponse.getEntity(), "UTF-8");
		//below will convert the above string in to json format
		JSONObject responsejson = new JSONObject(responseString);
		
		 System.out.println("responsejson from API--->"+	responsejson);
		 
		 //header validation-->below line stores teh header value inside an array
		 Header[] headerArray = closeablehttpResponse.getAllHeaders();
		 
		 //since we wanted like key, value format we re converting the array to hashmap
		 HashMap<String,String> allHeader = new HashMap<String,String>();
		 
		 for (Header header: headerArray) {
			 allHeader.put(header.getName(), header.getValue());
		 }
		 System.out.println("Headers Arrray-->"+allHeader);
		 
		 */
		
	
		}
	
	

}
