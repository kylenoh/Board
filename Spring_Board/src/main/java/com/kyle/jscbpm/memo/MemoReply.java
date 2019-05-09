package com.kyle.jscbpm.memo;

import java.math.BigDecimal;
import java.util.Date;

public class MemoReply {

	private BigDecimal jmr_no;
	private BigDecimal jmr_js_no;
	private String jmr_writer;
	private String jmr_txt;
	private Date jmr_date;
	
	public MemoReply() {
		// TODO Auto-generated constructor stub
	}

	public MemoReply(BigDecimal jmr_no, BigDecimal jmr_js_no, String jmr_writer, String jmr_txt, Date jmr_date) {
		super();
		this.jmr_no = jmr_no;
		this.jmr_js_no = jmr_js_no;
		this.jmr_writer = jmr_writer;
		this.jmr_txt = jmr_txt;
		this.jmr_date = jmr_date;
	}

	public BigDecimal getJmr_no() {
		return jmr_no;
	}

	public void setJmr_no(BigDecimal jmr_no) {
		this.jmr_no = jmr_no;
	}

	public BigDecimal getJmr_js_no() {
		return jmr_js_no;
	}

	public void setJmr_js_no(BigDecimal jmr_js_no) {
		this.jmr_js_no = jmr_js_no;
	}

	public String getJmr_writer() {
		return jmr_writer;
	}

	public void setJmr_writer(String jmr_writer) {
		this.jmr_writer = jmr_writer;
	}

	public String getJmr_txt() {
		return jmr_txt;
	}

	public void setJmr_txt(String jmr_txt) {
		this.jmr_txt = jmr_txt;
	}

	public Date getJmr_date() {
		return jmr_date;
	}

	public void setJmr_date(Date jmr_date) {
		this.jmr_date = jmr_date;
	}
	
}
