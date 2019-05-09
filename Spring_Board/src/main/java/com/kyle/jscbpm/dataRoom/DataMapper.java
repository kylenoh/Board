package com.kyle.jscbpm.dataRoom;

import java.util.List;

public interface DataMapper {

	public abstract int upload(Data d);
	
	public abstract List<Data>select();
	
	public abstract int deleteData(Data d);
}
