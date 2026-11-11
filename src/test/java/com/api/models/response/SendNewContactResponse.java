package com.api.models.response;

public class SendNewContactResponse {
	private String name;
	private String email;
	private String subject;
	private String message;
	private String status;
	private String id;
	private String created_at;
	
	public SendNewContactResponse() {
		super();
	}

	public SendNewContactResponse(String name, String email, String subject, String message, String status, String id,
			String created_at) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
		this.status = status;
		this.id = id;
		this.created_at = created_at;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	
}
