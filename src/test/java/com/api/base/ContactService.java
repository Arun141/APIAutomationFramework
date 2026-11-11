package com.api.base;

import com.api.models.request.SendNewContactRequest;

import io.restassured.response.Response;

public class ContactService extends BaseService {
	private static final String BASE_PATH = "";
	
	public Response sendContactMessage(SendNewContactRequest payload) {
		return postRequest(payload,"messages");
	}
}
