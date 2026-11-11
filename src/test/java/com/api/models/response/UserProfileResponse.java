package com.api.models.response;

public class UserProfileResponse {
	private String id;
	private String provider;
	private String first_name;
	private String last_name;
	private String phone;
	private String dob;
	private String email;
    private boolean totp_enabled;
    private String created_at;
    UserAddressResponse address;
    
    
	public UserProfileResponse() {
		super();
	}
	
	public UserProfileResponse(String id, String provider, String first_name, String last_name, String phone, String dob,
			String email, boolean totp_enabled, String created_at, UserAddressResponse address) {
		super();
		this.id = id;
		this.provider = provider;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.dob = dob;
		this.email = email;
		this.totp_enabled = totp_enabled;
		this.created_at = created_at;
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isTotp_enabled() {
		return totp_enabled;
	}
	public void setTotp_enabled(boolean totp_enabled) {
		this.totp_enabled = totp_enabled;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public UserAddressResponse getAddress() {
		return address;
	}
	public void setAddress(UserAddressResponse address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", provider=" + provider + ", first_name=" + first_name + ", last_name="
				+ last_name + ", phone=" + phone + ", dob=" + dob + ", email=" + email + ", totp_enabled="
				+ totp_enabled + ", created_at=" + created_at + ", address=" + address + "]";
	}
    
}
