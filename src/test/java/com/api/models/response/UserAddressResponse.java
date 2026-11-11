package com.api.models.response;

public class UserAddressResponse {
	private String street;
	private String house_number;
	private String city;
	private String state;
	private String country;
	private String postal_code;
	
	
	
	public UserAddressResponse() {
		super();
	}

	public UserAddressResponse(String street, String house_number, String city, String state, String country,
			String postal_code) {
		super();
		this.street = street;
		this.house_number = house_number;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postal_code = postal_code;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	@Override
	public String toString() {
		return "UserAddress [street=" + street + ", house_number=" + house_number + ", city=" + city + ", state="
				+ state + ", country=" + country + ", postal_code=" + postal_code + "]";
	}
	
}
