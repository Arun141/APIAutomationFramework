package com.api.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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
	public void GetLoggedInUserProfile() {
		LoginRequest loginRequest = new LoginRequest(ConfigReader.get("api.username"), ConfigReader.get("api.password"));
		UserService userService = new UserService();
		Response response = userService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schemas/login-response-schema.json"));

		response = userService.getLoginUserProfile(loginResponse.getAccess_token());
		UserProfileResponse userprofile = response.as(UserProfileResponse.class);
		
//		Assert.assertTrue(loginResponse.getAccess_token() != null);
		Assert.assertEquals(userprofile.getFirst_name(), "Jane");
	}
}
