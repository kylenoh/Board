package com.kyle.jscbpm.memo;

import java.math.BigDecimal;

public class ReveiwNo {

	private BigDecimal start;
	private BigDecimal end;
	
	public ReveiwNo() {
		// TODO Auto-generated constructor stub
	}

	public ReveiwNo(BigDecimal start, BigDecimal end) {
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
