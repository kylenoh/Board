package com.kyle.jscbpm.member;

public class Member {
	private String js_id;
	private String js_pw;
	private String js_name;
	private String js_email;
	private String js_addr;
	private String js_photo;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String js_id, String js_pw, String js_name, String js_email, String js_addr, String js_photo) {
		super();
		this.js_id = js_id;
		this.js_pw = js_pw;
		this.js_name = js_name;
		this.js_email = js_email;
		this.js_addr = js_addr;
		this.js_photo = js_photo;
	}

	public String getJs_id() {
		return js_id;
	}
	
	public void setJs_id(String js_id) {
		this.js_id = js_id;
	}

	public String getJs_pw() {
		return js_pw;
	}
	public void setJs_pw(String js_pw) {
		this.js_pw = js_pw;
	}
	
	public String getJs_name() {
		return js_name;
	}
	public void setJs_name(String js_name) {
		this.js_name = js_name;
	}

	public String getJs_email() {
		return js_email;
	}
	public void setJs_email(String js_email) {
		this.js_email = js_email;
	}

	public String getJs_addr() {
		return js_addr;
	}
	public void setJs_addr(String js_addr) {
		this.js_addr = js_addr;
	}

	public String getJs_photo() {
		return js_photo;
	}
	public void setJs_photo(String js_photo) {
		this.js_photo = js_photo;
	}


}
