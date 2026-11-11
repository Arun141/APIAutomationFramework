package com.api.models.request;

public class SendNewContactRequest {
	private String name;
	private String email;
	private String subject;
	private String message;
	
	private SendNewContactRequest(String name, String email, String subject, String message) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
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

	@Override
	public String toString() {
		return "SendNewContactRequest [name=" + name + ", email=" + email + ", subject=" + subject + ", message="
				+ message + "]";
	}
	
	public static class Builder{
		private String name;
		private String email;
		private String subject;
		private String message;
		
		public Builder name(String name) {
			this.name=name;
			return this;
		}
		
		public Builder email(String email) {
			this.email=email;
			return this;
		}
		
		public Builder subject(String subject) {
			this.subject=subject;
			return this;
		}
		
		public Builder message(String message) {
			this.message=message;
			return this;
		}
		
		public SendNewContactRequest build() {
			SendNewContactRequest sendNewContactRequest = new SendNewContactRequest(name, email, subject, message);
			return sendNewContactRequest;
		}
	}
}
