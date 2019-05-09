package com.kyle.jscbpm.memo;

import java.util.List;

public interface MemoMapper {
	public abstract int writeMemo(Memo m);
	
	public abstract int getReviewCount();
	
	public abstract List<Memo>getReview(ReveiwNo rn);
	
	public abstract List<Memo>search(Memo m);
	
	public abstract int delReview(Memo m);
	
	public abstract int update(Memo m);
	
	public abstract int writeReply(MemoReply mp);
	
	public abstract List<MemoReply>getReply();
	
	public abstract int deleteReply(MemoReply mp);
}
