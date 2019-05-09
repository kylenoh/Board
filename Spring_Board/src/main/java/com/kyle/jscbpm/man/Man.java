package com.kyle.jscbpm.man;

import java.math.BigDecimal;
import java.util.Date;

public class Man {
	private BigDecimal js_no;
	private String js_txt;
	private Date js_date;
	private String js_file;
	
	public Man() {
		// TODO Auto-generated constructor stub
	}

	public Man(BigDecimal js_no, String js_txt, Date js_date, String js_file) {
		super();
		this.js_no = js_no;
		this.js_txt = js_txt;
		this.js_date = js_date;
		this.js_file = js_file;
	}

	public BigDecimal getJs_no() {
		return js_no;
	}

	public void setJs_no(BigDecimal js_no) {
		this.js_no = js_no;
	}

	public String getJs_txt() {
		return js_txt;
	}

	public void setJs_txt(String js_txt) {
		this.js_txt = js_txt;
	}

	public Date getJs_date() {
		return js_date;
	}

	public void setJs_date(Date js_date) {
		this.js_date = js_date;
	}

	public String getJs_file() {
		return js_file;
	}

	public void setJs_file(String js_file) {
		this.js_file = js_file;
	}

	
}
