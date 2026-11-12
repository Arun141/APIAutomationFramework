package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.ContactService;
import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.request.SendNewContactRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.SendNewContactResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class SendContactMessageTest {

	@Test(description = "Verify if Compliant Message has been Sent..")
	public void loginTest() {
		SendNewContactRequest sendNewContactRequest =new  SendNewContactRequest.Builder().name("John Dube")
		.email("john@dube.example")
		.subject("website")
		.message("Something is wrong with the website").build();
		
		ContactService contactService = new ContactService();
		Response response = contactService.sendContactMessage(sendNewContactRequest);
		SendNewContactResponse sendNewContactResponse = response.as(SendNewContactResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(sendNewContactResponse.getStatus());
		
		Assert.assertTrue(sendNewContactResponse.getStatus() != null);
		Assert.assertEquals(response.getStatusCode(), 200 );
	}

}
