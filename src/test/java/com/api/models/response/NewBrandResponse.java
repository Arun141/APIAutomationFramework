package com.api.models.response;

public class NewBrandResponse {
	private String name;
	private String slug;
	private String id;
	
	public NewBrandResponse() {
		super();
	}

	public NewBrandResponse(String id, String name, String slug) {
		super();
		this.id = id;
		this.name = name;
		this.slug = slug;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "NewBrandResponse [id=" + id + ", name=" + name + ", slug=" + slug + "]";
	}

}
