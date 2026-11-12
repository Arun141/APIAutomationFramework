package com.api.dataproviders;

import org.testng.annotations.DataProvider;

public class ContactDataProvider {

	@DataProvider(name = "contactData")
	public static Object[][] contactData(){
		return new Object[][] {
			{ "John Dube", "john@dube.example", "website", "Something is wrong with the website"},
			{ "Jane Smith", "jane@smith.example", "website", "Unable to load the product page"},
			{ "Arun Kumar", "arun@kumar.example", "website", "Checkout button is not working"}
		};
	}
}
