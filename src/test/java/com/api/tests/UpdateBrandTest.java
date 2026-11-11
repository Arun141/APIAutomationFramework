package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.BrandService;
import com.api.base.ContactService;
import com.api.models.request.BrandRequest;
import com.api.models.request.SendNewContactRequest;
import com.api.models.response.NewBrandResponse;
import com.api.models.response.SendNewContactResponse;

import io.restassured.response.Response;

public class UpdateBrandTest {
	
	@Test(description = "Create and Update a New Brand..")
	public void loginTest() {
		BrandRequest brandRequest =new  BrandRequest("abc brand1","abc-brand1");
		
		BrandService brandService = new BrandService();
		Response response = brandService.createBrand(brandRequest);
		NewBrandResponse newBrandResponse = response.as(NewBrandResponse.class);
		System.out.println(response.asPrettyString());
		System.out.println(newBrandResponse.getId());
		System.out.println("--------------------------------------------------------------");
		BrandRequest updateBrandRequest =new BrandRequest("abc brand123","abc-brand123");
		response = brandService.updateBrand(updateBrandRequest, newBrandResponse.getId());
		Assert.assertTrue(response.jsonPath().getBoolean("success"));
		
	}
	
}
