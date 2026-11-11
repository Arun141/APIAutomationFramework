package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.CartService;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class DeleteCartTest {

	@Test(description="Create and Delete a Cart..")
	public void DeleteCart() {
		CartService cartService = new CartService();
		Response response = cartService.createNewCart();
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 201);
		
		Assert.assertEquals(cartService.deleteCart(response.jsonPath().getString("id")).getStatusCode(), 204);
	}
}
