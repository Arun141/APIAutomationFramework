package com.api.models.request;

public class BrandRequest {
	private String name;
	private String slug;
	
	public BrandRequest(String name, String slug) {
		super();
		this.name = name;
		this.slug = slug;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

}
