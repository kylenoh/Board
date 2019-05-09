package com.kyle.jscbpm.memo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Memo {
	private BigDecimal js_no;
	private String js_txt;
	private String js_writer;
	private Date js_date;
	private String js_file;
	
	private List<MemoReply>js_memo_Reply;
	
	public Memo() {
		// TODO Auto-generated constructor stub
	}

	public Memo(BigDecimal js_no, String js_txt, String js_writer, Date js_date, String js_file,
			List<MemoReply> js_memo_Reply) {
		super();
		this.js_no = js_no;
		this.js_txt = js_txt;
		this.js_writer = js_writer;
		this.js_date = js_date;
		this.js_file = js_file;
		this.js_memo_Reply = js_memo_Reply;
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

	public String getJs_writer() {
		return js_writer;
	}

	public void setJs_writer(String js_writer) {
		this.js_writer = js_writer;
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

	public List<MemoReply> getJs_memo_Reply() {
		return js_memo_Reply;
	}

	public void setJs_memo_Reply(List<MemoReply> js_memo_Reply) {
		this.js_memo_Reply = js_memo_Reply;
	}
	
	}
