package com.kyle.jscbpm.member;

import java.util.ArrayList;

public class Members {
	private ArrayList<Member>member;
	
	public Members() {
		// TODO Auto-generated constructor stub
	}

	public Members(ArrayList<Member> member) {
		super();
		this.member = member;
	}

	public ArrayList<Member> getMember() {
		return member;
	}

	public void setMember(ArrayList<Member> member) {
		this.member = member;
	}
	
}
