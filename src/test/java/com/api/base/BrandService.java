package com.api.base;

import java.util.Map;

import com.api.models.request.BrandRequest;

import io.restassured.response.Response;

public class BrandService extends BaseService{
	
	private static final String BASE_PATH = "/brands";
	private static final String BASE_PATH_BY_ID = "/brands/{brandId}";
	
	public Response createBrand(BrandRequest payload) {
		return postRequest(payload,BASE_PATH);
	}
	public Response updateBrand(BrandRequest payload, String brandId) {
		return putRequest(payload,BASE_PATH_BY_ID, Map.of("brandId",brandId));
	}
}
