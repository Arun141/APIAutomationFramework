package com.api.base;

import java.util.Map;

import com.api.models.request.SendNewContactRequest;

import io.restassured.response.Response;

public class CartService extends BaseService{
	
	private static final String BASE_PATH = "/carts";
	
	public Response createNewCart() {
		return postRequest(BASE_PATH);
	}
	
	public Response deleteCart(String cartId) {
		return deleteRequest(BASE_PATH+"/{cardId}", Map.of("cardId", cartId));
	}
}
