package com.api.base;
import static io.restassured.RestAssured.*;

import java.util.Map;

import com.api.filters.LoggingFilter;
import com.api.utils.ConfigReader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class BaseService { //Wrapper for Rest Assured, Base URI, creating request, handling response
	
	private static final String BASE_URL = ConfigReader.get("base.url");
	private RequestSpecification requestSpecification;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer "+token);
	}
	
	protected Response postRequest(String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).post(endpoint);
	}
	
	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}
	
	protected Response putRequest(Object payload, String endpoint, Map<String, ?> pathParams) {
		return requestSpecification.contentType(ContentType.JSON).pathParams(pathParams).body(payload).put(endpoint);
	}
	
	protected Response deleteRequest(String endpoint, Map<String, String> pathParams) {
		return requestSpecification.contentType(ContentType.JSON).pathParams(pathParams).delete(endpoint);
	}
	
}
