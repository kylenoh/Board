package com.kyle.jscbpm.man;

import java.math.BigDecimal;

public class MemoNo {

	private BigDecimal start;
	private BigDecimal end;
	
	public MemoNo() {
		// TODO Auto-generated constructor stub
	}

	public MemoNo(BigDecimal start, BigDecimal end) {
		super();
		this.start = start;
		this.end = end;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}
}
