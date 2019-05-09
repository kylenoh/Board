package com.kyle.jscbpm.dataRoom;

import java.math.BigDecimal;
import java.util.Date;

public class Data {
	private BigDecimal js_no;
	private String js_uploader;
	private String js_title;
	private String js_cate;
	private String js_file;
	private Date js_date;
	
	public Data() {
		// TODO Auto-generated constructor stub
	}

	public Data(BigDecimal js_no, String js_uploader, String js_title, String js_cate, String js_file, Date js_date) {
		super();
		this.js_no = js_no;
		this.js_uploader = js_uploader;
		this.js_title = js_title;
		this.js_cate = js_cate;
		this.js_file = js_file;
		this.js_date = js_date;
	}

	public BigDecimal getJs_no() {
		return js_no;
	}

	public void setJs_no(BigDecimal js_no) {
		this.js_no = js_no;
	}

	public String getJs_uploader() {
		return js_uploader;
	}

	public void setJs_uploader(String js_uploader) {
		this.js_uploader = js_uploader;
	}

	public String getJs_title() {
		return js_title;
	}

	public void setJs_title(String js_title) {
		this.js_title = js_title;
	}

	public String getJs_cate() {
		return js_cate;
	}

	public void setJs_cate(String js_cate) {
		this.js_cate = js_cate;
	}

	public String getJs_file() {
		return js_file;
	}

	public void setJs_file(String js_file) {
		this.js_file = js_file;
	}

	public Date getJs_date() {
		return js_date;
	}

	public void setJs_date(Date js_date) {
		this.js_date = js_date;
	}

}
