package com.undo.assessment.businessrule.domain;

public class Email {
	
	private String recipent;
	private String subject;
	private String body;
	
	public Email(){
		
	}

	public Email(String recipent, String subject, String body) {
		super();
		this.recipent = recipent;
		this.subject = subject;
		this.body = body;
	}

	public String getRecipent() {
		return recipent;
	}

	public void setRecipent(String recipent) {
		this.recipent = recipent;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
