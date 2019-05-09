package com.kyle.jscbpm.naver;

public class Faces {
	private Object facial_attributes;
	private Object facial_points;
	private int score;
	
	public Faces() {
		// TODO Auto-generated constructor stub
	}

	public Faces(Object facial_attributes, Object facial_points, int score) {
		super();
		this.facial_attributes = facial_attributes;
		this.facial_points = facial_points;
		this.score = score;
	}

	public Object getFacial_attributes() {
		return facial_attributes;
	}

	public void setFacial_attributes(Object facial_attributes) {
		this.facial_attributes = facial_attributes;
	}

	public Object getFacial_points() {
		return facial_points;
	}

	public void setFacial_points(Object facial_points) {
		this.facial_points = facial_points;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}
