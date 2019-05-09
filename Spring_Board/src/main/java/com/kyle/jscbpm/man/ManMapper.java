package com.kyle.jscbpm.man;

import java.util.List;

public interface ManMapper {
	public abstract int writeMan(Man m);
	
	public abstract List<Man>getAllMemo();
	
	public abstract int getAllMemoCount();
	
	public abstract List<Man>getMemo(MemoNo mn);
	
	public abstract List<Man>search(Man m);
	
	public abstract int delete(Man m);
}
