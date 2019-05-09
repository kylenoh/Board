package com.kyle.jscbpm.naver;

import java.util.List;

public class Result {
	private int width;
	private int height;
	private List<Faces>resultF;
	
	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(int width, int height, List<Faces> resultF) {
		super();
		this.width = width;
		this.height = height;
		this.resultF = resultF;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public List<Faces> getResultF() {
		return resultF;
	}

	public void setResultF(List<Faces> resultF) {
		this.resultF = resultF;
	}
	
}
