package com.api.base;

import com.api.models.request.LoginRequest;

import io.restassured.response.Response;

public class UserService extends BaseService{
	private static final String BASE_PATH = "/users/";
	
	public Response login(LoginRequest payload) {
		return postRequest(payload,BASE_PATH+"login");
	}
	
	public Response getLoginUserProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"me");
	}
}
