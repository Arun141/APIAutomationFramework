package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.utils.ConfigReader;

import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {

	@Test(description = "Verify if Login API is working..")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest(ConfigReader.get("api.username"), ConfigReader.get("api.password"));
		UserService userService = new UserService();
		Response response = userService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schemas/login-response-schema.json"));
		
		Assert.assertTrue(loginResponse.getAccess_token() != null);
		Assert.assertEquals(loginResponse.getToken_type(), "bearer");
	}
}
