package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import com.api.utils.ConfigReader;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class GetLoggedInUserProfileTest {

	@Test(description = "Verify the Logged In User Profile..")
	public void loginTest() {
		LoginRequest loginRequest = new LoginRequest(ConfigReader.get("api.username"), ConfigReader.get("api.password"));
		UserService userService = new UserService();
		Response response = userService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		response = userService.getLoginUserProfile(loginResponse.getAccess_token());
		UserProfileResponse userprofile = response.as(UserProfileResponse.class);
		
		System.out.println(response.asPrettyString());
//		Assert.assertTrue(loginResponse.getAccess_token() != null);
		Assert.assertEquals(userprofile.getFirst_name(), "Jane");
	}
}
