package com.kyle.jscbpm.member;

public interface MemberMapper {
	public abstract int reg(Member m);

	public abstract Member getMemberById(Member m);
	
	public abstract int updateMember(Member m);
	
	public abstract int deleteMember(Member m);
}
