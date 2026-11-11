package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginAPITest {

	@Test(description = "Verify if Login API is working..")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest("customer@practicesoftwaretesting.com", "welcome01");
		UserService userService = new UserService();
		Response response = userService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getAccess_token());
		
		Assert.assertTrue(loginResponse.getAccess_token() != null);
		Assert.assertEquals(loginResponse.getToken_type(), "bearer");
	}
}
