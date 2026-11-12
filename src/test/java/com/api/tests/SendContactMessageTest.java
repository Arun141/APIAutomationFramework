package com.api.tests;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.ContactService;
import com.api.base.UserService;
import com.api.dataproviders.ContactDataProvider;
import com.api.models.request.LoginRequest;
import com.api.models.request.SendNewContactRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.SendNewContactResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class SendContactMessageTest {

	@Test(description = "Verify if Compliant Message has been Sent..", dataProvider = "contactData", dataProviderClass = ContactDataProvider.class)
	public void sendContactMessageTest(String name, String email, String subject, String message) {
		SendNewContactRequest sendNewContactRequest = new SendNewContactRequest.Builder().name(name).email(email)
				.subject(subject).message(message).build();

		ContactService contactService = new ContactService();
		Response response = contactService.sendContactMessage(sendNewContactRequest);
		SendNewContactResponse sendNewContactResponse = response.as(SendNewContactResponse.class);
		response.then().assertThat().body(matchesJsonSchemaInClasspath("schemas/send-contact-response-schema.json"));

		Assert.assertTrue(sendNewContactResponse.getStatus() != null);
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(sendNewContactResponse.getName(), name);
		Assert.assertEquals(sendNewContactResponse.getEmail(), email);
	}

}
