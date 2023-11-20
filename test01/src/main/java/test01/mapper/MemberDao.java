package test01.mapper;

import java.util.List;

import test01.model.Member;

public interface MemberDao {
	public int insert(Member member);
	public Member select(String id);  
	public List<Member> list(); 
	public int update(String id);
	public int delete(String id);
	
}
